/* interpreter.java ...  */
/*********************************************/
/* Copyright *C* 1999, All Rights Reserved.  */
/* Jack J. Woehr jax@well.com jwoehr@ibm.net */
/* http://www.well.com/user/jax/rcfb         */
/* P.O. Box 51, Golden, Colorado 80402-0051  */
/*********************************************/
/*                                           */
/*    This Program is Free SoftWoehr.        */
/*                                           */
/* THERE IS NO GUARANTEE, NO WARRANTY AT ALL */
/*********************************************/
/*
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package com.SoftWoehr.FIJI.interpreter;

import java.io.*;
import java.util.*;

import  com.SoftWoehr.util.*;

/** A class to interpret input of a stream of FIJI commands.
 *
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */

public class interpreter implements verbose {

    private PrintStream err;
    private PrintStream out;
    
    /**  Flags whether we are in verbose mode. */
    private boolean isverbose = false;
    /**  Helper for verbose mode. */
    private verbosity v = new verbosity(this);
    
    /** An execution engine */
    private engine myEngine;
    
    /** The tokenizer which gets our next lexeme. */
    private StringTokenizer st ;
    
    /** Stack needed so we can nest interpretation, e.g.,
     * when we load a file.
     */
    private Stack<StringTokenizer> tokenizerStack;
    
    /** We want to exit if this is true. */
    private boolean killFlag = false;
    
    /** We want to quit interp loop if this is true. */
    private boolean quitFlag = false;
    
    /** Number base for interpretation. */
    private int base = 10;
    
    private String defaultDelimiters = " \t\n\r";
    
    public interpreter(PrintStream err, PrintStream out) {
        this.err = err;
        this.out = out;
        reinit();
    }
    
    /** Reset the interpreter, losing all previous state. */
    public void reinit() {
        myEngine = new engine(this);
        v = new verbosity(this);
        warmReset();
    }

    /** Get the engine associated with this interpreter.
     */
    public engine getEngine() {
        return myEngine;
    }
    
    protected void finalize() throws Throwable {           /* Called by garbage collector in case no longer referenced*/
        super.finalize();
    }
    
    /** Set the kill flag.
     * @param tf  */
    void setKillFlag(boolean tf) {
        killFlag = tf;
    }
    
    /** Get the kill flag.
     */
    public boolean getKillFlag() {
        return killFlag;
    }
    
    /** Set the quit flag.
     * @param tf  */
    void setQuitFlag(boolean tf) {
        quitFlag = tf;
    }
    
    /** Get the quit flag.
     */
    public boolean getQuitFlag() {
        return quitFlag;
    }
    
    /** Set the interpreter numeric base.
     * @param i  */
    public void setBase(int i) {
        base = i;
    }
    
    /** Get the interpreter numeric base.
     */
    public int getBase() {
        return base;
    }
    
    /** Set the string tokenizing default delimiters.
     * @param delims  */
    public void setDefaultDelimiters(String delims) {
        defaultDelimiters = delims;
    }
    
    /** Get the string tokenizing default delimiters.
     */
    public String getDefaultDelimiters() {
        return defaultDelimiters;
    }
    
    /** Get next lexeme in string being interpret()'ed
     * using the delimiter set passed in the 'delims'
     * argument.
     * @param delims
     */
    String nextLexeme(String delims) {
        String s = null;
        if (null != st) {
            try {
                s = st.nextToken(delims);
            }                                                        /* End try*/
            catch (NoSuchElementException  e) {
          /* Do nothing .. thus method returns null. */
                s = null;                                     /* For "good luck".*/
          /* Does nextToken() "damage" `s' before throw? Spec unclear.*/
            }                                                      /* End catch*/
        }                                                           /* End if*/
        return s;
    }                            /* public String nextLexeme(String delims)*/
    
    /** Get next lexeme in string being interpret()'ed using default delims.
     */
    String nextLexeme() {
        return nextLexeme(defaultDelimiters);
    }                                         /* public String nextLexeme()*/
    
    /** Get next lexeme in string being interpret()'ed
     * using the delimiter set passed in the 'delims'
     * argument, with the option of consuming the
     * delimiter. <b> NOTE </b> that this is only
     * useful for non-blank delims, since it presumes
     * a blank will be left over at the front of the
     * string.
     *
     * <code>class StringTokenizer</code> in Java 1.1.7
     * and before is not a full-bodied lexing facility.
     * @param delims
     * @param consumeDelim
     */
    String nextLexeme(String delims, boolean consumeDelim) {
        String s = null;
        if (null != st) {
            s = st.nextToken(delims);                         /* Get actual token*/
            if (null != s) {
                s = s.substring(1, s.length());              /* Strip leading blank*/
            }                                                         /* End if*/
            if ((0 != st.countTokens()) && (consumeDelim))/* Consume delim.*/ {
                st.nextToken(defaultDelimiters);
            }                                                         /* End if*/
        }                                                           /* End if*/
        return s;
    }                    /* nextLexeme(String delims, boolean consumeDelim)*/
    
    /** Number of lexemes left in string being interpret()'ed .
     */
    private int countLexemes() {
        int count = 0;
        if (null != st) {
            count = st.countTokens();
        }                                                           /* End if*/
        return count;
    }

    public void output(String s) {
        out.print(s);
    }

    public void outputError(Exception e) {
        e.printStackTrace(err);
    }
    
    /** Issue the prompt as appropriate */
    public void prompt() {
        if (engine.INTERPRETING == myEngine.state)       /* We're interpreting*/ {
            output("\nok ");
        }
        else                                               /* We're compiling.*/ {
            output("\n(...) ");
        }                                                          /* End if*/
    }
    
    /** Something for the engine to call when it does a warm(). */
    void warmReset()  {
        st = null;
        tokenizerStack = new Stack<>();
        setKillFlag(false);
        setQuitFlag(false);
        setBase(10);
    }
    
    /** Interpret one String.
     * returns true if we should stop
     * @param s  */
    public boolean interpret(String s) {
        announce("String to interpret is: " + s);
        String aLexeme;                   /* Holds a lexeme as we examine it. */
        Semantic semantic;/* Holds a semantic as we decide what to do with it.*/
        
        setKillFlag(false);                     /* Indicate we're in business.*/
        setQuitFlag(false);                     /* Indicate we're in business.*/
        
     /* Interpret the passed-in string */
        if (s != null)                 /* Don't try to tokenize a null string.*/ {
            tokenizerStack.push(st);  /* Save (possibly null) current tokenizer.*/
            st = new StringTokenizer(s              /* Open on the input string.*/
            , defaultDelimiters  /* List of delimiters.*/
            , false             /* Delim not in return.*/
            );
            
            while ((countLexemes() > 0)            /* For all lexemes in string.*/
            && !killFlag
            && !quitFlag) {
                aLexeme = nextLexeme();                          /* Grab next one.*/
                announce("Lexeme is: " + aLexeme);
                semantic = myEngine.findSemantic(aLexeme); /* Find in wordlist(s).*/
                announce("Semantic is: " + semantic);
                
                if (null != semantic)      /* We found lexeme as dictionary entry.*/ {
                    if (engine.INTERPRETING == myEngine.state) /* We're interpreting*/ {
                        try {
                            announce("Executing interpretive semantics for "
                            + semantic.toString()
                            );
                            semantic.execute(myEngine);                     /* So do it.*/
                        }                                                 /* End try*/
                        catch (Exception e) {
                            e.printStackTrace(err);
                            output(e.getMessage());
                            myEngine.warm();
                        }                                               /* End catch*/
                    }                                                    /* End if*/
                    
                    else                                         /* We're compiling.*/ {
                        try {
                            announce("Executing compile semantics for "
                            + semantic.toString()
                            );
                            semantic.compile(myEngine);                /* So compile it.*/
                        }                                                 /* End try*/
                        catch (Exception e) {
                            e.printStackTrace(err);
                            output(e.getMessage());
                            myEngine.warm();
                        }                                               /* End catch*/
                    }                                                    /* End if*/
                }
                
                else           /* We didn't find the lexeme as a dictionary entry.*/ {
                    if (engine.INTERPRETING == myEngine.state)/* We're interpreting.*/ {
                        Long a;
                        try                                  /* Try to make it a long.*/ {
                            a = Long.valueOf(aLexeme, base);
                            myEngine.stack.push(a);                    /* Push the long.*/
                        }                                                 /* End try*/
                        catch (NumberFormatException e)              /* Wasn't a long.*/ {
                            myEngine.stack.push(aLexeme);            /* Push the lexeme.*/
                        }                                               /* End catch*/
                    }
                    
                    else                                         /* We're compiling.*/ {
                        long a = 0;
                        try                                  /* Try to make it a long.*/ {
                            a = Long.parseLong(aLexeme);
                            try            /* Try to compile the long as a literal Long.*/ {
                                myEngine.compileLiteral(a);
                            }                                               /* End try*/
                            catch (Exception x) {
                                announce("interpreter had problem compiling literal Long.");
                                announce("Lexeme was: " + aLexeme);
                                x.printStackTrace(err);
                                myEngine.warm();
                            }                                             /* End catch*/
                        }                                                 /* End try*/
                        catch (NumberFormatException e)              /* Wasn't a long.*/ {
                            try        /* Try to compile the lexeme as a string literal.*/ {
                                myEngine.compileLiteral(aLexeme);
                            }                                               /* End try*/
                            catch (Exception x) {
                                announce("interpreter had problem compiling literal String.");
                                announce("Lexeme was: " + aLexeme);
                                x.printStackTrace(err);
                                myEngine.warm();
                            }                                             /* End catch*/
                        }                                               /* End catch*/
                    }  /* End "we're compiling" */                       /* End if*/
                } /* End "didn't find" */                              /* End if*/
            }                                                     /* End while*/
            try {
                if (!tokenizerStack.isEmpty()) {
                    st = tokenizerStack.pop();/* Previous tokenizer.*/
                }
            }                                                       /* End try*/
            catch (Exception e) {
                e.printStackTrace(err);
                myEngine.warm();
            }                                                     /* End catch*/
        }                         /* End if (interpretation string non-null)*/
        return killFlag;
    }                                      /* End of interpreter.interpret*/
    
    
   /* Load a file as FIJI source. */
    /**
     * @param filename  */
    public void load(String filename) {
        myEngine.push(filename);
        myEngine.load();
    }
    
    /**
     * @see com.SoftWoehr.util.verbose#
     * @see com.SoftWoehr.util.verbosity#
     */
    public boolean isVerbose()              {return isverbose;}
    
    /**
     * As this class overloads setVerbose()
     * it control engine's verbosity, too.
     * @see com.SoftWoehr.util.verbose#
     * @see com.SoftWoehr.util.verbosity#
     * @param tf  */
    public void    setVerbose  (boolean tf) {
        isverbose = tf;
        if (myEngine != null) {
            myEngine.setVerbose(tf);
            announce("Setting engine verbose.");
        }                                                          /* End if*/
    }
    
    /**
     * @see com.SoftWoehr.util.verbose#
     * @see com.SoftWoehr.util.verbosity#
     * @param s  */
    public void    announce    (String s)   {v.announce(s);   }
    
}                                               /* End of interpreter class*/

/*  End of interpreter.java */
