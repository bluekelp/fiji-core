/* Wordlist.java ...  lists of semantics     */
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

import  java.util.*;

import  com.SoftWoehr.*;
import  com.SoftWoehr.util.*;

/** This is a word list of Semantics. They
 * are keyed by their names. If a Semantic of an
 * existing name is keyed in, the previous is lost.
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
public class Wordlist extends Semantic implements SoftWoehr, verbose {
    /** Revision level */
    private static final String rcsid = "$Id: Wordlist.java,v 1.1.1.1 2001/08/21 02:39:34 jwoehr Exp $";
    /** Implements com.SoftWoehr.SoftWoehr
     * @return  */
    public String rcsId() {return rcsid;}
    
    /**  Flags whether we are in verbose mode. */
    public boolean isverbose = false;
    /**  Helper for verbose mode. */
    private verbosity v = new verbosity(this);
    
    private Hashtable wordlist;
    
    /** Arity/0 ctor. */
    public Wordlist() {
        reinit("Anonymous Wordlist.");
    }
    
    /** Arity/1 ctor.
     * @param name  */
    public Wordlist(String name) {
        reinit(name);
    }
    
    /** Reinit discarding previous state.
     * @param name  */
    public void reinit(String name) {
        setName(name);
        wordlist=new Hashtable();
    }
    
    /** Do a string dump wordlist's name.
     * @return  */
    public String toString() {
        String result = "A Wordlist named " + getName();
        return result;
    }
    
    /** shutdown() here does nothing.
     * @see com.SoftWoehr.SoftWoehr#
     * @return  */
    public int shutdown() { return 0; }
    
    /**
     * @throws Throwable  */
    protected void finalize() throws Throwable {           /* Called by garbage collector in case no longer referenced*/
        super.finalize();
    }
    
    /**
     * @see com.SoftWoehr.util.verbose#
     * @see com.SoftWoehr.util.verbosity#
     * @return  */
    public boolean isVerbose()              {return isverbose;}
    
    /**
     * @see com.SoftWoehr.util.verbose#
     * @see com.SoftWoehr.util.verbosity#
     * @param tf  */
    public void    setVerbose  (boolean tf) {isverbose = tf;
    announce(getName() + " Wordlist is set verbose.");
    }
    
    /**
     * @see com.SoftWoehr.util.verbose#
     * @see com.SoftWoehr.util.verbosity#
     * @param s  */
    public void    announce    (String s)   {v.announce(s);   }
    
    /** Add a Semantic in, comes with its own key. If key
     * already exists, push the previous Semantic for the key
     * (so that it can later be restored if the user 'forget's
     * the active Semantic) and set the active Semantic to the
     * Semantic presented to this method.
     * @param s  */
    public void put(Semantic s) {
        String name = s.getName();
        WordlistEntry entry = findEntry(name);
        if (null == entry) {
            entry = new WordlistEntry(s);
            wordlist.put(name, entry);
        }
        else {
            entry.push(s);
        }                                                           /* End if*/
    }                                        /* public void put(Semantic s)*/
    
    /** Find a WordlistEntry by name in a wordlist. */
    private WordlistEntry findEntry(String name) {
        return (WordlistEntry)wordlist.get(name);
    }                             /* public Semantic findEntry(String name)*/
    
    /** Find a Semantic by name in a wordlist.
     * @param name
     * @return  */
    public Semantic find(String name) {
        Semantic s = null;
        WordlistEntry entry = findEntry(name);
        if (null != entry) {
            s = entry.getSemantic();
        }                                                           /* End if*/
        return s;
    }                                  /* public Semantic find(String name)*/
    
    /** 'Forget' the active Semantic for a name, popping the previous
     * Semantic in its place. If no previous Semantic
     * is stacked, remove the entry from the Wordlist.
     * @param name  */
    public void forget(String name) {
        WordlistEntry entry = (WordlistEntry)wordlist.get(name);
        if (null != entry) {
            Semantic s = entry.pop();
            if (null == s) {
                wordlist.remove(name);
            }                                                         /* End if*/
        }                                                           /* End if*/
    }                                   /* public void forget (String name)*/
    
    /** Utterly discard a wordlist entry.
     * @param name  */
    public void discard(String name) {
        wordlist.remove(name);
    }
    
    /** Return a string of all words in the wordlist.
     * @return  */
    public String words() {
        String result = "";
        WordlistEntry entry = null;
        for (Enumeration e = wordlist.elements(); e.hasMoreElements();) {
            entry = (WordlistEntry) (e.nextElement());
            if (null != entry) {
                result += entry.getName() + " ";
                announce(result + "\n");
            }
        }                                                          /* End for*/
        return result;
    }                                             /* public String words ()*/
    
    /** Create a default wordlist for initial engine.
     * Each invocation of this method results in
     * a unique instance. Alternatively, the
     * list could be a static member, but then
     * it had better be read-only to interpreter
     * instances due to its being shared.
     * @return  */
    public static Wordlist defaultWordlist() {
        Wordlist defaultList = new Wordlist("FIJI");
        try {
            defaultList.put(new Primitive("arf"          , "arf"                  ));
            defaultList.put(new Primitive("noop"         , "noop"                 ));
            defaultList.put(new Primitive("depth"        , "depth"                ));
            defaultList.put(new Primitive("dup"          , "dup"                  ));
            defaultList.put(new Primitive("drop"         , "drop"                 ));
            defaultList.put(new Primitive("swap"         , "swap"                 ));
            defaultList.put(new Primitive("over"         , "over"                 ));
            defaultList.put(new Primitive("rot"          , "rot"                  ));
            defaultList.put(new Primitive("roll"         , "roll"                 ));
            defaultList.put(new Primitive("pick"         , "pick"                 ));
            defaultList.put(new Primitive(".s"           , "dot_s"                ));
            defaultList.put(new Primitive(".c"           , "dot_c"                ));
            defaultList.put(new Primitive(".sc"          , "dot_sc"               ));
            defaultList.put(new Primitive("."            , "dot"                  ));
            defaultList.put(new Primitive(".."           , "dotdot"               ));
            defaultList.put(new Primitive(".r"           , "dot_r"                ));
            defaultList.put(new Primitive("warm"         , "warm"                 ));
            defaultList.put(new Primitive("cold"         , "cold"                 ));
            defaultList.put(new Primitive("quit"         , "quit"                 ));
            defaultList.put(new Primitive(">class"       , "getStackEntryClass"   ));
            defaultList.put(new Primitive(">string"      , "stackEntryToString"   ));
            defaultList.put(new Primitive("("            , "javaArgs"             ));
            defaultList.put(new Primitive(","            , "accumulateArg"        ));
            defaultList.put(new Primitive(")"            , "callJava"             ));
            defaultList.put(new Primitive("'"            , "lexeme"               ));
            defaultList.put(new Primitive("class"        , "classForName"         ));
            defaultList.put(new Primitive("bye"          , "bye"                  ));
            defaultList.put(new Primitive("sysexit"      , "sysexit"              ));
            defaultList.put(new Primitive("true"         , "pushTrue"             ));
            defaultList.put(new Primitive("null"         , "pushNull"             ));
            defaultList.put(new Primitive("false"        , "pushFalse"            ));
            defaultList.put(new Primitive("()"           , "castParam"            ));
            defaultList.put(new Primitive("primitive"    , "classToPrimitiveType" ));
            defaultList.put(new Primitive(">primitive"   , "stackEntryToPrimitive"));
            defaultList.put(new Primitive("(primitive)"  , "stackEntryToPrimParam"));
            defaultList.put(new Primitive("Long>intparam", "longToIntParam"       ));
            defaultList.put(new Primitive("find"         , "find"                 ));
            defaultList.put(new Primitive("execute"      , "execute"              ));
            defaultList.put(new Primitive("compile"      , "compile"              ));
            defaultList.put(new Primitive("["   /* Special compilation semantics.*/
            , "leftBracket"
            , "leftBracket"
            ));
            defaultList.put(new Primitive("]"   /* Special compilation semantics.*/
            , "rightBracket"
            , "rightBracket"
            ));
            defaultList.put(new Primitive("base"         , "popBase"              ));
            defaultList.put(new Primitive("base?"        , "pushBase"             ));
            defaultList.put(new Primitive("state"        , "doState"              ));
            defaultList.put(new Primitive("immediate?"   , "isImmediate"          ));
            defaultList.put(new Primitive("immediate"/* Special compilation semantics.*/
            , "compileOnly"
            , "setCurrentImmediate"
            ));
            defaultList.put(new Primitive("\""  /* Special compilation semantics.*/
            , "doubleQuote"
            , "compileDoubleQuote"
            ));
            defaultList.put(new Primitive("`"   /* Special compilation semantics.*/
            , "backTick"
            , "compileBackTick"
            ));
            defaultList.put(new Primitive("\\"  /* Special compilation semantics.*/
            , "comment"
            , "comment"
            ));
            defaultList.put(new Primitive("exit"         , "doExit"               ));
            defaultList.put(new Primitive("not"          , "not"                  ));
            defaultList.put(new Primitive("and"          , "and"                  ));
            defaultList.put(new Primitive("or"           , "or"                   ));
            defaultList.put(new Primitive("xor"          , "xor"                  ));
            defaultList.put(new Primitive("="            , "isEqual"              ));
            defaultList.put(new Primitive(">"            , "greaterThan"          ));
            defaultList.put(new Primitive("<"            , "lessThan"             ));
            defaultList.put(new Primitive("<>"           , "isUnequal"            ));
            defaultList.put(new Primitive("+"            , "add"                  ));
            defaultList.put(new Primitive("-"            , "sub"                  ));
            defaultList.put(new Primitive("*"            , "mul"                  ));
            defaultList.put(new Primitive("/"            , "div"                  ));
            defaultList.put(new Primitive("mod"          , "mod"                  ));
            defaultList.put(new Primitive("array"        , "array"                ));
            defaultList.put(new Primitive("dimarray"     , "dimarray"             ));
            defaultList.put(new Primitive("variable"     , "newVariable"          ));
            defaultList.put(new Primitive("!"            , "store"                ));
            defaultList.put(new Primitive("@"            , "fetch"                ));
            defaultList.put(new Primitive("value"        , "newValue"             ));
            defaultList.put(new Primitive("to"  /* Special compilation semantics.*/
            ,"toValue"
            ,"compileToValue"
            ));
            defaultList.put(new Primitive("{"            , "newAnonymousDefinition"));
            defaultList.put(new Primitive("}"
            ,"compileOnly"                      /* Special compilation semantics.*/
            ,"concludeAnonymousDefinition"
            ));
            defaultList.put(new Primitive(":"            , "newDefinition"         ));
            defaultList.put(new Primitive(";"   /* Special compilation semantics.*/
            ,"compileOnly"
            ,"concludeDefinition"
            ));
            defaultList.put(new Primitive("if"  /* Special compilation semantics.*/
            ,"compileOnly"
            ,"compileConditionalBranch"
            ));
            defaultList.put(new Primitive("else"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"compileAndResolveBranch"
            ));
            defaultList.put(new Primitive("then"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"resolveBranch"
            ));
            defaultList.put(new Primitive("begin"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"pushUnconditionalBranch"
            ));
            defaultList.put(new Primitive("again"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"compileUnconditionalBackwardsBranch"
            ));
            defaultList.put(new Primitive("until"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"compileConditionalBackwardsBranch"
            ));
            defaultList.put(new Primitive("while"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"compileConditionalBranch"   /* == 'if'*/
            ));
            defaultList.put(new Primitive("repeat"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"resolveTwoBranches"
            ));
            defaultList.put(new Primitive("cr"           , "cr"                   ));
            defaultList.put(new Primitive("do"  /* Special compilation semantics.*/
            ,"compileOnly"
            ,"compileDo"
            ));
            defaultList.put(new Primitive("loop"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"compileLoop"
            ));
            defaultList.put(new Primitive("+loop"/* Special compilation semantics.*/
            ,"compileOnly"
            ,"compilePlusLoop"
            ));
            defaultList.put(new Primitive("leave"        , "doLeave"              ));
            defaultList.put(new Primitive("index"        , "index"                ));
            defaultList.put(new Primitive("verbose"      , "runtimeVerbose"       ));
            defaultList.put(new Primitive("decompile"    , "decompile"            ));
            defaultList.put(new Primitive("system"       , "system"               ));
            defaultList.put(new Primitive("interpret"    , "interpret"            ));
            defaultList.put(new Primitive("load"         , "load"                 ));
            defaultList.put(new Primitive("version"      , "version"              ));
            defaultList.put(new Primitive("getorder"     , "getOrder"             ));
            defaultList.put(new Primitive("setorder"     , "setOrder"             ));
            defaultList.put(new Primitive("wordlist"     , "newWordlist"          ));
            defaultList.put(new Primitive("setcurrent"   , "setCurrent"           ));
            defaultList.put(new Primitive("getcurrent"   , "getCurrent"           ));
            defaultList.put(new Primitive("words"        , "words"                ));
            defaultList.put(new Primitive("forget"       , "forget"               ));
            defaultList.put(new Primitive("discard"      , "discard"              ));
            defaultList.put(defaultList);                    /* Add self to list!*/
        }                                                          /* End try*/
        catch (Exception e) {
            e.printStackTrace(System.err);
        }                                                        /* End catch*/
        return defaultList;
    }
    
    /** Demonstrate <code>Wordlist<code>.
     * @param argv  */
    public static void main(String argv[]) {
    }
}                                                  /* End of Wordlist class*/

/** The entries in a Wordlist are composite entities, an active defintion
 * for an entry and a stack of previous definitions which were overridden
 * by redefinition of the same name. Thus when we 'forget' a definition,
 * the previous definition of that same name in this same wordlist is
 * restored to visibility.
 */
class WordlistEntry {
    /** Create a WordlistEntry on a Semantic.
     * @param s  */
    public WordlistEntry(Semantic s) {
        semantic = s;
        semanticStack = null;/* Only have a stack if one needed, memory impact.*/
    }
    
    /**
     * @return  */
    public String toString()
    {return super.toString();}
    
    /**
     * @throws Throwable  */
    protected void finalize() throws Throwable {           /* Called by garbage collector in case no longer referenced*/
        super.finalize();
    }
    
    /** The active Semantic of a word. */
    private Semantic semantic;
    
    /** The stack of previous Semantics of this same word. */
    private Stack semanticStack;
    
    /** Get the Semantic to which this entry refers.
     * @return  */
    public Semantic getSemantic() {
        return semantic;
    }
    
    /** Get the name of the semantic to which this entry refers.
     * @return  */
    public String getName() {
        return semantic.getName();
    }
    
    /** Change the active Semantic.
     * @param s  */
    public void push(Semantic s) {
        if (null == semanticStack) {
            semanticStack = new Stack();                    /* Create as needed.*/
        }                                                           /* End if*/
        semanticStack.push(semantic);
        semantic = s;
    }                              /* public void pushSemantic (Semantic s)*/
    
    /** Pop the Semantic stack to restore an active Semantic,
     * discarding that which was the active Semantic. Returns
     * that Semantic which becomes the active Semantic as a
     * a result of this operation.
     * @return  */
    public Semantic pop() {
        semantic = null;                         /* Throw away active Semantic.*/
        if (null != semanticStack)/* If we have a stack of previous Semantic(s) ...*/ {
            // .. then it's a non-empty stack, since we chuck our empties.
            semantic = (Semantic)semanticStack.pop();        /* Restore previous.*/
            if (semanticStack.empty()) /* Don't keep empty stacks, memory impact.*/ {
                semanticStack = null;        /* Chuck away if empty, memory impact.*/
            }                                                         /* End if*/
        }                                                           /* End if*/
        return semantic;   /* Lets caller know if this entry is dead (== null).*/
    }                                     /* public Semantic popSemantic ()*/
}                                             /* End of WordlistEntry class*/
/*  End of Wordlist.java */
