package com.softwoehr.fiji.core;

import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Vector;

// A class representing a list of Semantics to be executed.
public class Definition extends Semantic {
    /** This is the compiled definition */
    private Semantic body[];

    /** This is the definition under compilation */
    private Vector composition;

    /** If true, the word's execution semantics are performed
     * at compile time.
     */
    private boolean immediate;

    Definition() {
        this("Anonymous Definition.");
    }

    Definition(String s) {
        super(s);
        immediate=false;
    }

    /** Return a string representing the definition.
     * @return A string representation.
     */
    public String toString() {
        return "A Definition named " + getName();
    }

    /** Set the word immediate, i.e.,  if true, its execution
     * semantics will be performed at compile time.
     * @param tf  */
    void setImmediate(boolean tf) {
        immediate = tf;
    }

    /** See if the word is immediate.
     * @return  */
    boolean getImmediate() {
        return immediate;
    }

    /** Start a definition. */
    void commence() {
        body = null;
        composition = new Vector();
    }

    /** Finish a definition. */
    void complete() {
        body = new Semantic[composition.size()];
        Enumeration e = composition.elements();
        for (int i = 0; e.hasMoreElements(); i++) {
            body[i] = (Semantic) e.nextElement();
        }
        composition = null;
    }

    void append(Semantic s) {
        composition.addElement(s);
    }

    public void execute(Engine e) throws InvocationTargetException, IllegalAccessException {
        e.innerInterpreter.interpret(this);
    }

    public void compile(Engine e) throws InvocationTargetException, IllegalAccessException {
        if (immediate) {
            execute(e);
        }
        else {
            super.compile(e);
        }
    }

    public Semantic[] decompile() {
        Semantic result [] = new Semantic[body.length];
        for (int i = 0; i < body.length; i++) {
            result[i] = body[i];
        }
        return result;
    }

    int lastIndex() {
        return body.length - 1;
    }

    public int length() {
        return body.length;
    }

    Semantic nthSemantic(int index) {
        return body[index];
    }

    int compositionLength() {
        return composition.size();
    }
}
