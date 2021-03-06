package com.bluekelp.fiji.core;

import java.io.IOException;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.Function;

// A class to interpret input of a stream of FIJI commands.
public class Interpreter {

    private PrintStream err;
    private PrintStream out;
    Function<String, String> loader;

    private Engine engine;

    // The tokenizer which gets our next lexeme.
    private StringTokenizer st;

    /**
     * Stack needed so we can nest interpretation, e.g.,
     * when we load a file.
     */
    private Stack<StringTokenizer> tokenizerStack;

    // We want to exit if this is true.
    private boolean killFlag = false;

    // We want to quit interp loop if this is true.
    private boolean quitFlag = false;

    // Number base for interpretation.
    private int base = 10;

    private String defaultDelimiters = " \t\n\r";

    public Interpreter(PrintStream err, PrintStream out, Function<String, String> loader) throws NoSuchMethodException, ClassNotFoundException {
        this.err = err;
        this.out = out;
        this.loader = loader;
        reinit();
    }

    // Reset the Interpreter, losing all previous state.
    private void reinit() throws NoSuchMethodException, ClassNotFoundException {
        engine = new Engine(this);
        warmReset();
    }

    public Engine getEngine() {
        return engine;
    }

    void setKillFlag() {
        killFlag = true;
    }

    void setQuitFlag() {
        quitFlag = true;
    }

    public void setBase(int i) {
        base = i;
    }

    int getBase() {
        return base;
    }

    /**
     * Get next lexeme in string being interpret()'ed
     * using the delimiter set passed in the 'delims'
     * argument.
     */
    String nextLexeme(String delims) {
        String s = null;
        if (null != st) {
            try {
                s = st.nextToken(delims);
            } catch (NoSuchElementException e) {
                /* Do nothing .. thus method returns null. */
                /* Does nextToken() "damage" `s' before throw? Spec unclear.*/
            }
        }
        return s;
    }

    // Get next lexeme in string being interpret()'ed using default delims.
    String nextLexeme() {
        return nextLexeme(defaultDelimiters);
    }

    /**
     * Get next lexeme in string being interpret()'ed
     * using the delimiter set passed in the 'delims'
     * argument, with the option of consuming the
     * delimiter. <b> NOTE </b> that this is only
     * useful for non-blank delims, since it presumes
     * a blank will be left over at the front of the
     * string.
     *
     * <code>class StringTokenizer</code> in Java 1.1.7
     * and before is not a full-bodied lexing facility.
     */
    String nextLexeme(String delims, boolean consumeDelim) {
        String s = null;
        if (null != st) {
            s = st.nextToken(delims);                         /* Get actual token*/
            if (null != s) {
                s = s.substring(1, s.length());              /* Strip leading blank*/
            }
            if ((0 != st.countTokens()) && (consumeDelim))/* Consume delim.*/ {
                st.nextToken(defaultDelimiters);
            }
        }
        return s;
    }                    /* nextLexeme(String delims, boolean consumeDelim)*/

    // Number of lexemes left in string being interpret()'ed .
    private int countLexemes() {
        return st != null ? st.countTokens() : 0;
    }

    void output(String s) {
        out.print(s);
    }

    void outputError(Exception e) {
        if (e != null && err != null)
            e.printStackTrace(err);
    }

    // Issue the prompt as appropriate
    public void prompt() {
        if (Engine.INTERPRETING == engine.state)       /* We're interpreting*/ {
            output("\nok ");
        } else                                               /* We're compiling.*/ {
            output("\n(...) ");
        }
    }

    // Something for the Engine to call when it does a warm().
    void warmReset() {
        st = null;
        tokenizerStack = new Stack<>();
        this.killFlag = false;
        this.quitFlag = false;
        setBase(10);
    }

    // Interpret one String. returns true if we should stop
    public boolean interpret(String s) {
        announce("String to interpret is: " + s);
        String aLexeme;                   /* Holds a lexeme as we examine it. */
        Semantic semantic;/* Holds a semantic as we decide what to do with it.*/

        this.killFlag = false;
        this.quitFlag = false;

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
                semantic = engine.findSemantic(aLexeme); /* Find in wordlist(s).*/

                if (null != semantic)      /* We found lexeme as dictionary entry.*/ {
                    if (Engine.INTERPRETING == engine.state) /* We're interpreting*/ {
                        try {
                            semantic.execute(engine);                     /* So do it.*/
                        } catch (Exception e) {
                            e.printStackTrace(err);
                            output(e.getMessage());
                            engine.warm();
                        }
                    } else                                         /* We're compiling.*/ {
                        try {
                            announce("Executing compile semantics for "
                                    + semantic.toString()
                            );
                            semantic.compile(engine);                /* So compile it.*/
                        } catch (Exception e) {
                            e.printStackTrace(err);
                            output(e.getMessage());
                            engine.warm();
                        }
                    }
                } else           /* We didn't find the lexeme as a dictionary entry.*/ {
                    if (Engine.INTERPRETING == engine.state)/* We're interpreting.*/ {
                        Long a;
                        try                                  /* Try to make it a long.*/ {
                            a = Long.valueOf(aLexeme, base);
                            engine.stack.push(a);                    /* Push the long.*/
                        } catch (NumberFormatException e)              /* Wasn't a long.*/ {
                            engine.stack.push(aLexeme);            /* Push the lexeme.*/
                        }
                    } else                                         /* We're compiling.*/ {
                        long a;
                        try                                  /* Try to make it a long.*/ {
                            a = Long.parseLong(aLexeme);
                            try            /* Try to compile the long as a literal Long.*/ {
                                engine.compileLiteral(a);
                            } catch (Exception x) {
                                announce("Interpreter had problem compiling literal Long.");
                                announce("Lexeme was: " + aLexeme);
                                x.printStackTrace(err);
                                engine.warm();
                            }
                        } catch (NumberFormatException e)              /* Wasn't a long.*/ {
                            try        /* Try to compile the lexeme as a string literal.*/ {
                                engine.compileLiteral(aLexeme);
                            } catch (Exception x) {
                                announce("Interpreter had problem compiling literal String.");
                                announce("Lexeme was: " + aLexeme);
                                x.printStackTrace(err);
                                engine.warm();
                            }
                        }
                    }
                }
            }
            try {
                if (!tokenizerStack.isEmpty()) {
                    st = tokenizerStack.pop();/* Previous tokenizer.*/
                }
            } catch (Exception e) {
                e.printStackTrace(err);
                engine.warm();
            }
        }
        return killFlag;
    }


    /* Load a file as FIJI source. */
    public void load(String filename) throws IOException {
        engine.push(filename);
        engine.load();
    }

    private void announce(String s) {
    }

}