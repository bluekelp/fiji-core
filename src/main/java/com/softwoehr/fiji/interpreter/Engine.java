/* Engine.java ...  an execution Engine.     */
//********************************************/
/* Copyright *C* 1999, 2001                  */
/* All Rights Reserved.                      */
/* Jack J. Woehr jax@softwoehr.com           */
/* http://www.well.com/user/jax/rcfb         */
/* P.O. Box 51, Golden, Colorado 80402-0051  */
//********************************************/
/*                                           */
/*    This Program is Free SoftWoehr.        */
/*                                           */
/* THERE IS NO GUARANTEE, NO WARRANTY AT ALL */
//********************************************/
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

package com.softwoehr.fiji.interpreter;

import com.softwoehr.fiji.JavaArgs;
import com.softwoehr.fiji.base.Exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Stack;

/** The execution Engine for our interaction.
 * An instance of com.SoftWoehr.desktop.shell.Interpreter
 * creates itself an instance of com.SoftWoehr.desktop.shell.Engine.
 * The Engine is the guts of the shell's work and contains the bodies
 * of the com.SoftWoehr.desktop.shell.Primitive instances of primitive
 * Interpreter functions, since the Engine knows how to carry out
 * these tasks.
 *
 *<p>The Engine possess an object stack where each shell function
 * gets its parameters and deposits its results.
 *
 *<p>The descriptions of the methods below often contains a Forth-like
 * stack diagram referring to the effect of the operation on the object
 * stack maintained by the Engine.
 * @author $Author: jwoehr $
 * @version $Revision: 1.2 $
 */
public class Engine {

    /** Interpreting, not compiling. */
    static final boolean INTERPRETING = false;

    /** Compiling, not interpreting. */
    private static final boolean COMPILING = true;

    /**  Flags whether we are in verbose mode. */
    private boolean isverbose = false;

    // References to a Class object for comparisons to avoid frequent calls to Class.forName()
    private Class cBoolean   ;
    private Class cString    ;
    private Class cLong      ;
    private Class cClass     ;
    private Class cJavaParam ;
    private Class cVariable  ;
    private Class cValue     ;
    private Class cDefinition;
    private Class cParameterizedPrimitive;
    private Class cLiteral;

    /** Init the static class references. */
    private void loadClasses() {
        try {
            cString    = Class.forName("java.lang.String");
            cLong      = Class.forName("java.lang.Long");
//            cInteger   = Class.forName("java.lang.Integer");
            cClass     = Class.forName("java.lang.Class");
            cBoolean   = Class.forName("java.lang.Boolean");
//            cObject    = Class.forName("java.lang.Object");
            cJavaParam = Class.forName("com.softwoehr.fiji.interpreter.JavaParam");
            cVariable  = Class.forName("com.softwoehr.fiji.interpreter.Variable");
            cValue     = Class.forName("com.softwoehr.fiji.interpreter.Value");
            cDefinition= Class.forName("com.softwoehr.fiji.interpreter.Definition");
            cParameterizedPrimitive =
            Class.forName("com.softwoehr.fiji.interpreter.ParameterizedPrimitive");
            cLiteral =   /* Since name resolution by forName() won't work this one.*/
            new ParameterizedPrimitive.Literal("").getClass();
        } catch (Exception e) {
            outputError(e);
        }
    }

    /** Object stack. */
    public Stack<Object> stack;

    /** Inner Interpreter is the Definition Interpreter.
     * The inner Interpreter has the return stack and
     * the current definition under interpretation.
     */
    InnerInterpreter innerInterpreter;

    /** A ref to the current definition under composition. The
     * previous currentDefinition is pushed on the control
     * flow stack.
     */
    private Definition currentDefinition;

    /** Stack for unfinished Definitions and unresolved branches. */
    private Stack controlFlowStack;

    /** The input Interpreter with which this Engine is associated.*/
    private Interpreter myInterpreter;

    private void output(String s) {
        myInterpreter.output(s);
    }

    private void outputError(Exception e) {
        myInterpreter.outputError(e);
    }

    /** Compilation state */
    boolean state;

    /** The search order */
    private SearchOrder searchOrder;

    /** The current wordlist to which new defs are added. */
    private Wordlist currentWordlist;

    /** Open Engine on an input Interpreter and initialize cold.
     * @param i the associated input Interpreter
     */
    public Engine(Interpreter i) {
        cold();
        myInterpreter = i;
        loadClasses();
    }

    /** Reinit Engine like just came up. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void cold() {
        warm();
        searchOrder = new SearchOrder();
        Wordlist w = Wordlist.defaultWordlist();
        searchOrder.add(w);
        currentWordlist = searchOrder.nthElement(0);                    /* == w*/
    }

    /** Reinit Engine but preserve some state. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void warm() {
        stack = new Stack<>();
        innerInterpreter = new InnerInterpreter(this);
        controlFlowStack = new Stack();
        state = INTERPRETING;
        if (null != myInterpreter) {     /* Interpreter calls Engine.warm() when it wants to reset self.*/
            myInterpreter.warmReset();
        }                                                           /* End if*/
    }

    /** Set state INTERPRETING/COMPILING.
     * @param state <CODE>Engine.INTERPRETING</CODE> if interpreting; <CODE>Engine.COMPILING</CODE> if compiling.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void setState(boolean state) {
        this.state = state;
    }

    /** Get state INTERPRETING/COMPILING.
     * @return state <CODE>Engine.INTERPRETING</CODE> if interpreting; <CODE>Engine.COMPILING</CODE> if compiling.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public boolean getState() {
        return state;
    }

    /** Sets verbosity of the debugging output.
     * @param tf <CODE>true</CODE> iff verbose.
     */
    private void    setVerbose  (boolean tf) {
        isverbose = tf;
    }

    /** Outputs to verbose stream if verbose.
     * @param s Message to announce
     */
    void    announce    (String s)   { if (isverbose) output(s);}

    /** Find a semantic by name in one of the wordlists
     * in the array of same currently searched by this Engine.
     * Return either the semantic or 'null'.
     * @param name name of the semantic
     * @return The Semantic object of that name.
     */
    Semantic findSemantic(String name) {
        return searchOrder.find(name);
    }

    /** Push a reference to an object onto the stack.
     * @param o The obj to push
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void push(Object o) {
        stack.push(o);
    }

    /** Pop a reference to an object from the stack.
     * @return The obj popped.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public Object pop() {
        return stack.pop();
    }

    /** Peek at TOS.
     * @return The object from the top of the stack, which still resides there.
     */
    private Object peek() {
        return stack.peek();
    }

    /** ARF */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void arf() {
        output("\nHi there from arf!\n");
    }

    /** noop           --  */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void noop() {
    }

    /** depth      xn .. x1 -- n */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void depth() {
        push((long) stack.size());
    }

    /** dup          o -- o o
     * throws StackUnderflow If stack is empty.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void dup()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow {
        if (stack.size() > 0) {
            push(stack.peek());
        }
        else {
            String s = "Stack under.";
            announce(s);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow(s, null);
        }                                                           /* End if*/
    }

    /** drop          o --
     * throws StackUnderflow If stack is empty.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void drop()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow {
        if (stack.size() > 0) {
            stack.pop();
        }
        else {
            String s = "Stack under.";
            announce(s);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow(s, null);
        }                                                           /* End if*/
    }

    /** swap      o1 o2 -- o2 o1
     * throws StackUnderflow If stack is empty.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void swap()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow {
        int sz = stack.size();
        if (sz > 1) {
            stack.insertElementAt(stack.pop(), sz - 2);
        }
        else {
            String s = "Stack under.";
            announce(s);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow(s, null);
        }                                                           /* End if*/
    }

    /** over        o1 o2 -- o1 o2 o1
     * throws StackUnderflow If stack is too shallow for operation.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void over()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow {
        int sz = stack.size();
        if (sz > 1) {
            push(stack.elementAt(sz - 2));
        }
        else {
            String s = "Stack under.";
            announce(s);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow(s, null);
        }                                                           /* End if*/
    }

    /** rot        o1 o2 o3 -- o2 o3 o1
     * throws StackUnderflow If stack is too shallow for operation.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void rot()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow {
        int sz = stack.size();
        if (sz > 2) {
            Object o = stack.elementAt(sz - 3);
            stack.removeElementAt(sz - 3);
            push(o);
        }
        else {
            String s = "Stack under.";
            announce(s);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow(s, null);
        }                                                           /* End if*/
    }

    /** roll        om .. o((m-n)+1) om-n  m -- .. o((m-n)+1) om
     * throws StackUnderflow If stack is too shallow for operation.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void roll()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow {
        int sz = stack.size();
        if (sz > 0) {
            int item = ((Long)pop()).intValue();
            sz = stack.size();
            if (sz > item) {
                Object o = stack.elementAt((sz - 1) - item);
                stack.removeElementAt((sz - 1) - item);
                push(o);
            }
            else {
                String s = "Stack under.";
                announce(s);
                throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow(s, null);
            }                                                         /* End if*/
        }
        else {
            String s = "Stack under.";
            announce(s);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow(s, null);
        }                                                           /* End if*/
    }                                                /* public void roll ()*/

    /** pick      om .. om-n m -- om .. om-n om
     * throws StackUnderflow If stack is too shallow for operation.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void pick()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow {
        int sz = stack.size();
        if (sz > 0) {
            int item = ((Long)pop()).intValue();
            sz = stack.size();
            if (sz > item) {
                Object o = stack.elementAt((sz - 1) - item);
                push(o);
            }
            else {
                String s = "Stack under.";
                announce(s);
                throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow(s, null);
            }                                                         /* End if*/
        }
        else {
            String s = "Stack under.";
            announce(s);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow(s, null);
        }                                                           /* End if*/
    }

    /** .s        o1 .. oN -- o1 .. oN */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void dot_s() {
        if (stack.size() > 0) {
            for (Enumeration e = stack.elements(); e.hasMoreElements();) {
                Object o = e.nextElement();
                if (null != o) {
                    output("`" + o + "` ");
                }
                else {
                    output("`null` ");
                }                                                       /* End if*/

            }
        }
        else {
            output("Empty stack. ");
        }
    }

    /** .c        o1 .. oN -- o1 .. oN */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void dot_c() {
        if (stack.size() > 0) {
            for (Enumeration e = stack.elements(); e.hasMoreElements();) {
                Object o = e.nextElement();
                if (null != o) {
                    output("`" + o.getClass() + "` ");
                }
                else {
                    output("`null` ");
                }                                                       /* End if*/
            }
        }
        else {
            output("Empty stack. ");
        }
    }

    /** Primitive to display all stack entries and their classes.
     * .sc        o1 .. oN -- o1 .. oN
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void dot_sc() {
        if (stack.size() > 0) {
            for (Enumeration e = stack.elements(); e.hasMoreElements();) {
                Object o = e.nextElement();
                if (null != o) {
                    output("`" + o + " /*" + o.getClass() + "*/` ");
                }
                else {
                    output("`null` ");
                }                                                       /* End if*/
            }
        }
        else {
            output("Empty stack. ");
        }
    }

    /** .         o1 -- */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void dot() {
        if (stack.size() > 0) {
            Object o = pop();
            if (null != o) {
                output(o.toString() + " ");
            }
            else {
                output("`null` ");
            }                                                         /* End if*/
        }
        else {
            output("Empty stack. ");
        }                                                           /* End if*/
    }

    /** Display destructively all stack entries.
     * ..  o1 oN --
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void dotdot() {
        String s;
        Object o;
        if (stack.size() > 0) {
            while (stack.size() > 0) {
                o = stack.pop();
                if (null != o) {
                    s = o.toString();
                }
                else {
                    s = "`null`";
                }                                                       /* End if*/
                output(s + " ");
            }                                                      /* End while*/
        }                                                           /* End if*/
        else {
            output("Empty stack. ");
        }                                                           /* End if*/
    }                                                           /* dotdot()*/

    /** Print out the inner Interpreter state.
     * .r --        R: --
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void dot_r() {
        output(innerInterpreter.toString());
    }

    /** Trigger a quit of the input Interpreter loop
     * quit      o1 ... oN -- o1 ... oN
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void quit() {
        myInterpreter.setQuitFlag(true);
    }

    /** Turn a name into a class.
     * class     s1 -- c1
     * throws StackUnderflow if no name on stack
     * throws NotClassName if name on stack not a class name
     * throws NotClassInstance of tos is a builtin type and can't be tested for String-ness */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void classForName()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow
    , Exceptions.desktop.shell.NotClassName
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.NotClassInstance {
        if (stack.size() > 0) {
            try {
                if (peek().getClass() == cString) {
                    String name = (String) pop();
                    try {
                        push(Class.forName(name));
                    }                                                    /* End try*/
                    catch (Exception e) {
                        String s = name + " is not a class name.";
                        announce(s);
                        outputError(e);
                        throw new Exceptions.desktop.shell.NotClassName(s, e);
                    }                                                  /* End catch*/
                }
                else {
                    pop();
                    push(null);
                }                                                       /* End if*/
            }                                                        /* End try*/
            catch (Exception e) {
                String s = "classForName() couldn't getClass() on top-of-stack item.";
                outputError(e);
                throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.NotClassInstance(s, e);
            }                                                      /* End catch*/
        }                                                           /* End if*/
        else {
            String s = "Stack under.";
            announce(s);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow(s, null);
        }                                                           /* End if*/
    }                                              /* End of classForName()*/

    /** Convert an arg to a JavaParam with the class signature set.
     * ()        o stringClassName|Class -- javaParam
     * throws NotClassName If argument not a class name.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void castParam()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.NotClassName {
        Object o = peek();
        Class c = null;
        try {                                   /* Is TOS a Class object already?*/
            if (o.getClass() == cClass) {
                c = (Class) pop();                                  /* Yes, use it.*/
            }
            else                       /* TOS is presumed a string naming a class*/ {
                classForName();         /* TOS presumed to be string name of class.*/
                c = (Class) pop();                         /* Grab resultant class.*/
            }                                                         /* End if*/
        }                                                          /* End try*/
        catch (Exception e) {
      /* The only thing likely to throw above is classForName() */
            String s = "castParam() couldn't classForName() on top-of-stack item.";
            outputError(e);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.NotClassName(s, e);
        }                                                        /* End catch*/
        push(new JavaParam(pop(), c));                   /* Create a JavaParam.*/
    }                                                 /* End of castParam()*/

    /** Convert a reflection type to its primitive type.
     * This is necessary for methods type as 'int', etc.
     * primitive   class1 -- class2
     * throws StackUnderflow If stack empty
     * throws NonReflectedType If type argument indicates a non-reflected type.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void classToPrimitiveType()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.NonReflectedType {
        if (stack.size() > 0) {
            Class c = (Class) pop();
            try {
                Field f = c.getField("TYPE");
                push(f.get(c));
            }                                                        /* End try*/
            catch (Exception e) {
                String s = "classToPrimitiveType() found a  non-reflected type.";
                announce(s);
                outputError(e);
                throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.NonReflectedType(s, e);
            }                                                      /* End catch*/
        }
        else {
            String s = "Stack under.";
            announce(s);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow(s, null);
        }                                                           /* End if*/
    }

    /** Convert a stack entry to the class object of its primitive type.
     * This had rather better be coded as a definition than as a Forth prim.
     * >primitive     o -- c
     * throws StackUnderflow If stack empty.
     * throws NonReflectedType If type argument indicates non-reflected type.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void  stackEntryToPrimitive()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.NonReflectedType {
        getStackEntryClass();
        classToPrimitiveType();
    }

    /** Create a JavaParam with the object characterized
     * as its primitive type. Again, this were better
     * a definition than a Forth prim.
     * (primitive)    o1 -- javaParam
     * throws StackUnderflow If stack empty.
     * throws NonReflectedType If type argument indicates non-reflected type.
     * throws NotClassName  If argument not a class name.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void stackEntryToPrimParam()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.NonReflectedType
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.NotClassName {
        dup();
        stackEntryToPrimitive();
        castParam();
    }

    /** Create a JavaParam for an Integer characterized
     * as an int from the typical Long stack entry.
     * This had rather better be coded as a definition than as a Forth prim.
     * Long>int      L -- javaParam
     * throws NonReflectedType If type argument indicates non-reflected type.
     * throws StackUnderflow  If stack empty.
     * throws NotClassName   If argument not a class name.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void longToIntParam()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.NonReflectedType
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.NotClassName {
        push(new Integer(((Long)pop()).intValue()));
        stackEntryToPrimParam();
    }

    /** FIND in the searchOrder.
     * find   s -- semantic
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void find() {
        push(findSemantic((String)pop()));
    }

    /** Execute a semantic from the stack.
     * execute   x1 .. xn semantic -- ??
     * throws BadPrimitiveExecute If execution of primitive fails.
     * throws BadDefinitionExecute If execution of definition fails.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void execute()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionExecute

    {
        ((Semantic)pop()).execute(this);
    }

    /** Compile a semantic from the stack.
     * compile   semantic --
     * throws BadPrimitiveCompile If compile of primitive fails.
     * throws BadDefinitionCompile  If compile of definition fails.
     * throws BadPrimitiveExecute If execution of primitive fails.
     * throws BadDefinitionExecute If execution of definition fails.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void compile()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionExecute {
        ((Semantic)pop()).compile(this);
    }

    /** Temporarily unset compile state.
     * Shouldn't be used unless a definition
     * is under composition.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void leftBracket() {
        setState(INTERPRETING);
    }

    /** Set compile state. Shouldn't be used
     * unless a definition is under composition.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void rightBracket() {
        setState(COMPILING);
    }

    /** Test input base.
     * base? -- L
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void pushBase() {
        push((long) myInterpreter.getBase());
    }

    /** Set input base.
     * base L --
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void popBase() {
        myInterpreter.setBase(((Long)pop()).intValue());
    }

    /** Test compile state.
     * state   --- t|f
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void doState() {
        push(getState());
    }

    /** Makes current definition immediate.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void setCurrentImmediate() {
        currentDefinition.setImmediate(true);
    }

    /** Tests Definition on top of stack for immediacy.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void isImmediate() {
        push(((Definition) pop()).getImmediate());
    }

    /** >class   o1 -- c1 */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void getStackEntryClass() {
        push(pop().getClass());
    }

    /** Transform a stack entry into its representative string.
     * toString      o1 -- s1
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void stackEntryToString() {
        push(pop().toString());
    }

    /** Push a javaArgs object to accumulate arguments.
     * (      -- javaArgs
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void javaArgs() {
        push(new JavaArgs());
    }

    /** Pop an object off the stack and add it to the
     * JavaArgs vector underneath. Converts it to
     * a JavaParam if it's not one already. The reason
     * it would be one already would be that it had
     * been converted by castParam().
     * ,     o --
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void accumulateArg() {
        Object o = pop();  /* The actual argument, possibly already a JavaParam*/
        Class c = null;

        if (o.getClass() == cJavaParam) {                   /* If it's already a JavaParam, accumulate as-is.*/
            ((JavaArgs) peek()).addElement(o);
        }
        else                 /* It's not yet a JavaParam, accumulate it as one.*/ {
            ((JavaArgs) peek()).addElement(new JavaParam(o));
        }                                                           /* End if*/
    }

    /** Resove and make the call.
     * )     o1 methodname  javaArgs -- o2
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void callJava() {
        JavaArgs javaArgs = (JavaArgs) pop();
        String methodName = (String)   pop();
        Object o          = pop();
        if (methodName.equals("new")) {
            callJavaConstructor(o, javaArgs);
        }
        else {
            callJavaMethod(o, methodName, javaArgs);
        }                                                           /* End if*/
    }                                                     /* End callJava()*/

    /** Resolve and call a method, not a constructor.
     * @param o The object on which to call the (static or instance) method.
     * @param methodName Name of method.
     * @param javaArgs The arg array to pass to the method.
     */
    private void callJavaMethod(
            Object o
            , String methodName
            , JavaArgs javaArgs
    ) {
        Method method     = null;          /* The method we'll invoke.         */
        try {                              /* Resolve the method.*/
            if (cClass == o.getClass()) {  /* It's a class object, not an instance object.*/
                try {                       /* Try to resolve it as an object method.*/
                    method     =
                    o.getClass().getMethod(methodName, javaArgs.toClassArray());
                }                                                      /* End try*/
                catch (java.lang.NoSuchMethodException e) {     /* Oops, wasn't an object method. Try it as a class method.*/
                    method     =                              /* Try a static method.*/
                    ((Class)o).getMethod(methodName, javaArgs.toClassArray());
                }                                                    /* End catch*/
            }
            else                  /* It's an instance object, not a class object.*/ {
                method     =
                o.getClass().getMethod(methodName, javaArgs.toClassArray());
            }                                                         /* End if*/
            Object oo = method.invoke(o, javaArgs.toObjectArray());  /* invoke   */
            push(oo);
        }                                                          /* End try*/
        catch (Exception e) {
            outputError(e);
        }                                                        /* End catch*/
    }                                                 /* End callJavaMethod*/

    /** Resolve and call a constructor, not a method.
     * @param o The object on which to call the constructor.
     * @param javaArgs The arg array to pass to the method.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void callJavaConstructor( Object o
    , JavaArgs javaArgs
    ) {
        Constructor constructor = null;    /* The constructor we'll invoke.    */

        try                                          /* Resolve the constructor*/ {
            constructor  =
            ((Class) o).getConstructor(javaArgs.toClassArray());
        }                                                          /* End try*/
        catch (Exception e) {
            outputError(e);
        }                                                        /* End catch*/
        try {                                               /* Execute the call*/
            push(constructor.newInstance(javaArgs.toObjectArray()));
        }

        catch (Exception e) {
            outputError(e);
        }                                                        /* End catch*/
    }                                                 /* End callJavaMethod*/

    /** Return a java.lang.Field for an object instance.
     * @param o  The object whose field to find.
     * @param fieldName Name of field to find.
     * throws NoSuchFieldException Field doesn't exist.
     * @return The Field instance.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public Field findField(Object o, String fieldName)
    throws java.lang.NoSuchFieldException {
        Class c;                         /* The class we'll find the field for.*/
        Class x = o.getClass();         /* To check if this is a class already.*/
        if (x == cClass) {
            c = (Class) o;                           /* It is, just use it as is.*/
        }
        else {
            c = x;                     /* It's an instance, use the gotten class.*/
        }                                                           /* End if*/
        Field f = c.getField(fieldName);   /* Find the field name.             */
        return f;
    }                 /* public Field findField(Object o, String fieldName)*/

    /** Push next lexeme as a string literal.
     * '   TIB: lexeme --      -- s
     */
    public void lexeme() {
        push(myInterpreter.nextLexeme());
    }

    /** Grab a lexeme delimited specifically.
     * This being Arity/1 can't be a primitive,
     * which are all Arity/0.
     * @param delimiters Delimiters for the tokenizer.
     */
    public void lexeme(String delimiters) {
        push(myInterpreter.nextLexeme(delimiters));
    }

    /** Grab a lexeme delimited specifically,
     * possibly consuming the delimiter in the process.
     * This being Arity/1 can't be a primitive,
     * which are all Arity/0.
     * @param delimiters Delimiters for the tokenizer.
     * @param consumeDelim <CODE>true</CODE> if delimiter is consumed in the parsing.
     */
    private void lexeme(String delimiters, boolean consumeDelim) {
        push(myInterpreter.nextLexeme(delimiters, consumeDelim));
    }

    /** Parse a string up to the next doublequote or EOL
     * "      lexeme --   -- s
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void doubleQuote() {
        lexeme("\"\n\r", true);
    }

    /** Parse a string up to the next backtick or EOL
     * `      lexeme --   -- s
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void backTick() {
        lexeme("`\n\r", true);
    }

    /** Parse and discard text between backslashes. */
    public void comment() {
        lexeme("\\", true);
        pop();
    }

    /** Signal Interpreter that bye is requested. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void bye() {
        myInterpreter.setKillFlag(true);
    }

    /** System exit. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void sysexit() {
        int rc = ((Long)pop()).intValue();
        System.exit(rc);
    }

    /** Leave boolean true on stack */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void pushTrue() {
        push(Boolean.TRUE);
    }

    /** Leave boolean false on stack */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void pushFalse() {
        push(Boolean.FALSE);
    }

    /** Leave null on stack */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void pushNull() {
        push(null);
    }

    /**************************/
  /* Comparison and Logical */
    /**************************/

    /** Invert the boolean on top of stack. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void not() {
        push((Boolean) pop() == false
        );
    }                                                 /* public void not ()*/

    /** AND two booleans on top of stack. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void and() {
        boolean lhs = (Boolean) pop();
        boolean rhs = (Boolean) pop();
        push(lhs && rhs);
    }                                                 /* public void and ()*/

    /** OR two booleans on top of stack. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void or() {
        boolean lhs = (Boolean) pop();
        boolean rhs = (Boolean) pop();
        push(lhs || rhs);
    }                                                  /* public void or ()*/

    /** XOR two booleans on top of stack. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void xor() {
        boolean lhs = (Boolean) pop();
        boolean rhs = (Boolean) pop();
        push(lhs ^ rhs);
    }                                                 /* public void xor ()*/

    /** Compare two objects for equality. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void isEqual() {
        Object a = pop();
        Object b = pop();
        if (a == null || b == null) {
            if (a == null && b == null) {
                push(Boolean.TRUE);
            }
            else {
                push(Boolean.FALSE);
            }                                                         /* End if*/
        }
        else {
            push(a.equals(b));
        }                                                           /* End if*/
    }                                             /* public void isEqual ()*/

    /** Compare two objects for inequality. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void isUnequal() {
        Object a = pop();
        Object b = pop();
        if (a == null || b == null) {
            if (a == null && b == null) {
                push(Boolean.FALSE);
            }
            else {
                push(Boolean.TRUE);
            }                                                         /* End if*/
        }
        else {
            push(!a.equals(b));
        }                                                           /* End if*/
    }                                           /* public void isUnequal ()*/

    /** Compare two numbers (i.e., java.lang.Long's) or
     * two strings for greater-than.
     * > o1 o2 -- Boolean
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void greaterThan() {
        Object o = pop();
        final Class c  = o.getClass();
        if (c == cString) {
            push(0
                    <
                    ((String) pop()).compareTo((String) o));
        }
        else if (c == cLong) {
            push((Long) pop()
                    > (Long) o);
        }
        // TODO throw bAdAdD (if not both same class)?
    }

    /** Compare two numbers (i.e., java.lang.Long's) or
     * two strings for less-than
     * < o1 o2 -- Boolean
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void lessThan() {
        Object o = pop();
        final Class c  = o.getClass();
        if (c == cString) {
            push(0
                    >
                    ((String) pop()).compareTo((String) o));
        }
        else if (c == cLong) {
            push((Long) pop()
                    < (Long) o);
        }
        // TODO throw bAdAdD (if not both same class)?
    }

    //*************/
  /* Arithmetic */
    //*************/

    /** Add two numbers or two strings.
     * Should also work on ints, doubles, floats, etc., but doesn't yet.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void add() {
        Object o = pop();
        final Class c  = o.getClass();
        if (c == cString) {
            push((String) pop() + o);
        }
        else if (c == cLong) {
            push((Long) o + (Long) pop());
        }
        // TODO throw bAdAdD (if not both same class)?
    }

    /** Multiply two longs.
     * *  l1 l2 -- l1/l2
     * Should work on some other classes.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void mul() {
        Long multiplier   = (Long) pop();
        Long multiplicand = (Long) pop();
        push(multiplicand * multiplier);
    }

    /** Divide two longs.
     * /  l1 l2 -- l1/l2
     *  Should work on some other classes.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void div() {
        Long divisor = (Long) pop();
        Long dividend = (Long) pop();
        push(dividend / divisor);
    }

    /** Subtract two longs.
     * -  l1 l2 -- (l1 - l2)
     *  Should work on some other classes.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void sub() {
        Long subtrahend = (Long) pop();
        Long sum        = (Long) pop();
        push(sum - subtrahend);
    }

    /** Modulus of two longs.
     * %  l1 l2 -- l1%l2
     *  Should work on some other classes.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void mod() {
        Long divisor = (Long) pop();
        Long dividend = (Long) pop();
        push(dividend % divisor);
    }

    /** Create a new java.lang.reflect.Array of one dimension.
     * array   Long StringClassname -- Array
     * -or-
     * array   Long ClassObject -- Array
     * throws NonReflectedType If second-on-stack is non-reflected type.
     * throws StackUnderflow If stack depth < 2.
     * throws NotClassName If second-on-stack is not the String name of a Class.
     * throws NotClassInstance If second-on-stack is not a class type. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void array()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.NonReflectedType
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.NotClassName
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.NotClassInstance {
        Class aClass;
        Object o = peek();
        if (o.getClass() == cString)          /* It's a string name of a class.*/ {
            classForName();              /* Convert string to class on the stack.*/
        }

        aClass = (Class) pop();    /* class object for the type desired.*/

        int n = ((Long)pop()).intValue();  /* Convert long to Integer          */
        push(Array.newInstance(aClass, n));
    }

    /** Create a new java.lang.reflect.Array of n dimensions.
     * dimarray   L1 .. Ln nL StringClassname -- Array
     * -or-
     * dimarray   L1 .. Ln nL ClassObject -- Array
     * throws NonReflectedType If second-on-stack is non-reflected type.
     * throws StackUnderflow If stack depth < 2.
     * throws NotClassName If second-on-stack is not the String name of a Class.
     * throws NotClassInstance If second-on-stack is not a class type
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void dimarray()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.NonReflectedType
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.StackUnderflow
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.NotClassName
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.NotClassInstance {
        Class aClass;
        Object o = pop();
        if (o.getClass() == cString)          /* It's a string name of a class.*/ {
            push(o);
            classForName();              /* Convert string to class on the stack.*/
            aClass = (Class)pop();
        }
        else {
            aClass = (Class) o;    /* It's the class object for the type desired.*/
        }                                                           /* End if*/
        int nDims = ((Long)pop()).intValue(); /* Convert Long to int: num dims.*/
        int dimArray [] = new int [nDims];
        for (int i = 0; i < nDims; ++i) {
            dimArray[i] = ((Long)pop()).intValue();
        }                                                          /* End for*/
        push(Array.newInstance(aClass, dimArray));
    }

    //*********************/
  /* Variables & Values */
    //*********************/

    /** Parse input for a valid name.
     * throws BadName If no valid name found.
     * @return The name.
     */
    private String parseValidName()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.BadName {
        String s = myInterpreter.nextLexeme();
        if (null != s) {
            if (s.equals("")) {
                String t = "Invalid null name offered.";
                announce(t);
                throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.BadName(t, null);
            }                                                         /* End if*/
        }
        else {
            String t = "Invalid empty String name offered.";
            announce(t);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.BadName(t, null);
        }                                                           /* End if*/
        return s;
    }                                                   /* parseValidName()*/

    /** Create a new variable and add it to the current wordlist.
     * throws BadName  if no valid name found.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void newVariable()
    throws  com.softwoehr.fiji.base.Exceptions.desktop.shell.BadName {
        String s = parseValidName();
        currentWordlist.put(new Variable(s));
    }

    /** Store an object into a variable.
     * throws NonVariable If object for store isn't a variable.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void store()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.NonVariable {
        Object o = pop();
        if (o.getClass() == cVariable) {
            ((Variable) o).store(this);
        }
        else /* It's not a variable, assume it's an object field store request.*/ {
            String s =(String) pop();        /* Field name                       */
            try {
                Field f = findField(o, s);
                f.set(o, pop());                              /* set field contents*/
            }                                                        /* End try*/
            catch (Exception e) {
                String err = "Trouble setting field " + s + " of object " + o;
                announce(err);
                outputError(e);
                throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.NonVariable(s, null);
            }                                                      /* End catch*/
        }                                                           /* End if*/
    }

    /** Fetch an object from its storage in a variable.
     * throws NonVariable If object for store isn't a variable.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void fetch()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.NonVariable {
        Object o = pop();
        if (o.getClass() == cVariable) {
            ((Variable) o).fetch(this);
        }
        else /* It's not a variable, assume it's an object field fetch request.*/ {
            String s =(String) pop();        /* Field name                       */
            try {
                Field f = findField(o, s);
                push(f.get(o));
            }                                                        /* End try*/
            catch (Exception e) {
                String err = "Trouble getting field " + s + " of object " + o;
                announce(err);
                outputError(e);
                throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.NonVariable(s, null);
            }                                                      /* End catch*/
        }                                                           /* End if*/
    }

    // Fetch a wordlist from the search order, converting it to a value.

    /** Create a new value and add it to the current wordlist.
     * throws BadName If no valid name found.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void newValue()
    throws  com.softwoehr.fiji.base.Exceptions.desktop.shell.BadName {
        String s = parseValidName();
        currentWordlist.put(new Value(s));
    }

    /** Stuff a Value.
     * throws NonValue If target is not a Value
     * throws NameNotFound If name not found in wordlist(s).
     * throws BadName If no valid name found.  */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void toValue()
    throws  com.softwoehr.fiji.base.Exceptions.desktop.shell.NonValue
    ,  com.softwoehr.fiji.base.Exceptions.desktop.shell.NameNotFound
    ,  com.softwoehr.fiji.base.Exceptions.desktop.shell.BadName {
        parseValue().setDatum(pop());
    }

    /** Stuff a Value at runtime, a Value which we
     * tucked into an on-the-fly ParameterizedPrimitive.
     * @param p ParamterizedPrimitive to received value.
     * throws NonValue  If p is a non-Value.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void runtimeTo(ParameterizedPrimitive p)
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.NonValue {
        if (!p.validate()) {
            String s = " ParameterizedPrimitive posseses no valid Value.";
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.NonValue(s, null);
        }
        ((Value) p.getObject()).setDatum(pop());
    }

    /** Create a non-wordlist primitive on the fly to handle
     * compile-time use of "to".
     * throws CompileToValue If the compile-to-value-operation fails.
     * throws NonValue If target is not a Value
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void compileToValue()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.CompileToValue
    ,  com.softwoehr.fiji.base.Exceptions.desktop.shell.NonValue {
        try {
            Value v = parseValue();
            new ParameterizedPrimitive("(to)"
            ,"runtimeTo"
            ,v
            ,cValue
            ).compile(this);
        }                                                          /* End try*/
        catch (Exception e) {
            String s = "Problem with compileToValue()";
            announce(s);
            outputError(e);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.CompileToValue(s, e);
        }                                                        /* End catch*/
    }

    /** Grab the next lexeme, find it in the search order and determine
     * that it is a Value.
     * throws NameNotFound If name not found in wordlist(s)
     * throws NonValue If name does not represent a Value.
     * throws BadName If no valid name found.
     * @return The Value.
     */
    private Value parseValue()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.NameNotFound
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.NonValue
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadName {
        String aName = parseValidName();
        Semantic aSemantic = findSemantic(aName);
        if (null == aSemantic) {
            String s = "Name " + aName + " not found.";
            announce(s);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.NameNotFound(s, null);
        }                                                           /* End if*/

        if (aSemantic.getClass() != cValue) {
            String s = aName + " is not a Value.";
            announce(s);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.NonValue(s, null);
        }                                                           /* End if*/
        return (Value) aSemantic;
    }

    //*************/
  /* Compiling */
    //*************/

    /** Return the current definition under composition.
     * @return  the current definition. */
    Definition getCurrentDefinition() {
        return currentDefinition;
    }

    /** Push the current definition under composition to the control flow
     * stack and make the new definition the current definition.
     * @param d the current definition.
     */
    private void pushCurrentDefinition(Definition d) {
        pushControl
        (new ControlFlowElement( getCurrentDefinition()/* null if no current def.*/
        , this
        , cDefinition   /* Class to be recognized as.*/
        ));
        currentDefinition = d;                    /* Set new current definition*/
    }

    /** An interpret-time action for compile-only words, it throws.
     * throws CompileOnly If a compile-only Semantic is invoked outside compile mode.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void compileOnly()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.CompileOnly {
        String s = "Interpretive use of a compile-only word.";
        announce(s);
        throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.CompileOnly(s, null);
    }

    /** Set up Engine for compilation.
     * @param d The definition into which Semantics will be compiled.
     */
    private void commenceDefinition(Definition d) {
    /* Save current definition, usually null, on control flow stack. */
        pushCurrentDefinition(d);
        d.commence();                                   /* Init the definition.*/
        state = COMPILING;                     /* We'd need a state stack, too.*/
    }

    /** Finish compilation and link new definition into current wordlist.
     * throws ControlFlowStackImbalance If definition didn't balance out during compilation. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void concludeDefinition()
    throws  com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance {
        getCurrentDefinition().complete();
        if (0 < controlFlowStack.size()) {
            ControlFlowElement c = popControl();
            if (c.elementClass() != cDefinition) {
                String s = "Control flow error concluding a Definition.";
                announce(s);
                throw new
                com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance(s, null);
            }                                                         /* End if*/
            currentWordlist.put(getCurrentDefinition());   /* Link into wordlist.*/
            currentDefinition/* This is really mooted by innerInterpreter.getCurrentDefinition()*/
            = (Definition) c.element;/* Pop back next outer definition, maybe null.*/
            state = c.state;                          /* Pop back previous state.*/
        }
        else {
            String s = "Control flow stack empty concluding a Definition.";
            announce(s);
            throw new
            com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance(s, null);
        }                                                           /* End if*/
    }

    /** Finish compilation and leave token on the stack. Don't link
     * into any wordlist.
     * throws ControlFlowStackImbalance If definition didn't balance out during compilation.  */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void concludeAnonymousDefinition()
    throws  com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance {
        getCurrentDefinition().complete();
        if (0 < controlFlowStack.size()) {
            ControlFlowElement c = popControl();
            if (c.elementClass() != cDefinition) {
                String s = "Control flow error concluding an anonymous Definition.";
                announce(s);
                throw new
                com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance(s, null);
            }                                                         /* End if*/
            push(getCurrentDefinition());   /* Leave token on reference stack.*/
            currentDefinition = (Definition) c.element;/* Pop back next outer definition, maybe null.*/
            state = c.state;                          /* Pop back previous state.*/
        }
        else {
            String s = "Control flow stack empty concluding an anonymous Definition.";
            announce(s);
            throw new
            com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance(s, null);
        }                                                           /* End if*/
    }

    /** Create a new Definition in the current wordlist.
     * Immediacy applied by setImmediate().
     * @param name Name of the new definition.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void newDefinition(String name) {
        Definition d = new Definition(name);     /* Need nesting stack of same.*/
        commenceDefinition(d);                 /* Init engined for compilation.*/
    }

    /** Create a new Definition in the current wordlist
     * parsing name from input.
     *
     * NOTE that we're not dealing with immediacy yet.
     * throws BadName If no valid name found.  */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void newDefinition()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.BadName {
        String name = parseValidName();
        newDefinition(name);
    }

    /** Create a new anonmous Definition in the current wordlist.
     * NOTE that we're not dealing with immediacy yet.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void newAnonymousDefinition() {
        Definition d = new Definition();     /* Need nesting stack of same.*/
        commenceDefinition(d);                 /* Init engined for compilation.*/
    }

    //***********/
  /* Literals */
    //***********/

    /** Runtime for pushing a compiled literal on the stack.
     * @param l The literal to push.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void doLiteral(ParameterizedPrimitive.Literal l) {
        push(l.getObject());
    }

    /** Compile a literal already found by the Interpreter or some other
     * entity into a Definition. The literal object will push itself
     * at runtime of the Definition.
     * @param o The literal object.
     * throws NoSuchMethodException self-explanatory
     * throws ClassNotFoundException self-explanatory
     * throws BadPrimitiveCompile self-explanatory
     * throws BadDefinitionCompile self-explanatory
     * throws BadPrimitiveExecute self-explanatory
     * throws BadDefinitionExecute self-explanatory
     */
    void compileLiteral(Object o)
    throws java.lang.NoSuchMethodException
    , java.lang.ClassNotFoundException
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionExecute {
        new ParameterizedPrimitive.Literal(o).compile(this);
    }

    /** Parse up to next doublequote and compile
     * stack --       input: text" --
     * throws NoSuchMethodException self-explanatory
     * throws ClassNotFoundException self-explanatory
     * throws BadPrimitiveCompile self-explanatory
     * throws BadDefinitionCompile self-explanatory
     * throws BadPrimitiveExecute self-explanatory
     * throws BadDefinitionExecute self-explanatory
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void compileDoubleQuote()
    throws java.lang.NoSuchMethodException
    , java.lang.ClassNotFoundException
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionExecute {
        doubleQuote();
        compileLiteral(pop());
    }

    /** Parse up to next backtick and compile
     * stack --       input: text` --
     * throws NoSuchMethodException self-explanatory
     * throws ClassNotFoundException self-explanatory
     * throws BadPrimitiveCompile self-explanatory
     * throws BadDefinitionCompile self-explanatory
     * throws BadPrimitiveExecute self-explanatory
     * throws BadDefinitionExecute self-explanatory
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void compileBackTick()
    throws java.lang.NoSuchMethodException
    , java.lang.ClassNotFoundException
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionExecute {
        backTick();
        compileLiteral(pop());
    }

    //********************/
  /* Control flow     */
    //********************/

    /** Exit the currently executing Definition.*/
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void doExit() {
        innerInterpreter.exitCurrentDefinition();
    }

    /** Execute a control flow change within the currently executing definition.
     * @param delta delta by which to inc/dec the instruction pointer.
     */
    private void bump(Integer delta) {
        innerInterpreter.bump(delta);
    }

    /** Save a control flow entry on the control flow stack.
     * @param e the control flow entry
     */
    private void pushControl(ControlFlowElement e) {
        controlFlowStack.push(e);
    }

    /** Retrieve a control flow entry from the control flow stack.
     * @return the control flow entry
     */
    private ControlFlowElement popControl() {
        return (ControlFlowElement) controlFlowStack.pop();
    }

    /** Retrieve a control flow entry guaranteed to contain a
     * ParameterizedPrimitive. Returns null on empty stack.
     *
     * @exception com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance If the control flow stack wasn't balanced.
     * @return the control flow entry
     */
    private ControlFlowElement popParamPrimControl()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance {
        ControlFlowElement c = null;
        if (0 < controlFlowStack.size()) {
            c = popControl();
            if (c.elementClass() != cParameterizedPrimitive) {
                String s = "Control flow stack imbalance resolving a branch.";
                announce(s);
                throw new
                com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance(s, null);
            }                                                         /* End if*/
        }                                                           /* End if*/
        return c;
    }                     /* public ControlFlowElement popParamPrimControl()*/

    /** Execute the runtime of an unconditional branch. This is called from
     * a ParameterizedPrimitive so has an embedded object, the Integer which
     * is stored in the prim object indicating the index bump.
     * @param p Parameter to a primitive.
     * throws InvalidParameterObject self-explanatory
     */
    private void doUnconditionalBranch(ParameterizedPrimitive.Branch p)
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.InvalidParameterObject {
        if (!p.validate()) {
            String s = "A branch had a non-Integer value.";
            announce(s);
            throw
            new com.softwoehr.fiji.base.Exceptions.desktop.shell.InvalidParameterObject
            (s, null);
        }                                                           /* End if*/
        Integer i = (Integer) p.getObject();
        bump(i);
    }                     /* public void doBranch(ParameterizedPrimitive p)*/

    /** This method is here just as an alias so that strict resolution can occur
     * from within the ctor for ParameterizedPrimitive.UnconditionalBranch p).
     * The point is that ParameterizedPrimitive.ConditionalBranch() calls
     * doUnconditionalBranch() so the signature of the latter must be Branch.
     * @param p parameter for primitive
     * throws InvalidParameterObject self-explanatory
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void doUnconditionalBranch(ParameterizedPrimitive.UnconditionalBranch p)
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.InvalidParameterObject {
        doUnconditionalBranch((ParameterizedPrimitive.Branch) p);
    }

    /** Execute the runtime of a conditional branch. This is called from
     * a ParameterizedPrimitive so has an embedded object, the Integer which
     * is stored in the prim object indicating the index bump.
     * @param p param for primitive
     * throws InvalidParameterObject self-explanatory
     * throws ConditionalNonBoolean self-explanatory
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void doConditionalBranch(ParameterizedPrimitive.ConditionalBranch p)
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.InvalidParameterObject
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.ConditionalNonBoolean {
        Object o = stack.pop();            /* First, check flag.               */
        if (!(cBoolean == o.getClass())) {
            String s =
            "Non-Boolean at 'if' in '" + getCurrentDefinition() + "'";
            s += "\n" + innerInterpreter.toString();/* Throw something, it's not a boolean.*/
            announce(s);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.ConditionalNonBoolean(s, null);
        }                                                           /* End if*/

        if (!(Boolean) o) {           /* If true, don't branch.*/
            doUnconditionalBranch(p);
        }                                                           /* End if*/
    }                   /* public void doIfBranch(ParameterizedPrimitive p)*/

    /** Compile an unresolved conditional branch.
     * throws NoSuchMethodException self-explanatory
     * throws ClassNotFoundException self-explanatory
     * throws OpenIfBranch self-explanatory
     * throws BadPrimitiveCompile self-explanatory
     * throws BadDefinitionCompile self-explanatory
     * throws BadPrimitiveExecute self-explanatory
     * throws BadDefinitionExecute self-explanatory
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void compileConditionalBranch()
    throws java.lang.NoSuchMethodException
    , java.lang.ClassNotFoundException
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.OpenIfBranch
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionExecute {
        ParameterizedPrimitive p;
        announce("Creating parameterized primitive for conditional branch.");
        try {
            p =
            new ParameterizedPrimitive
            .ConditionalBranch(getCurrentDefinition()
            .compositionLength()
            );
        }                                                          /* End try*/
        catch (Exception e) {
            String s = "Problem opening a conditional branch in current definition."
            + getCurrentDefinition();
            announce(s);
            outputError(e);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.OpenIfBranch(s, e);
        }                                                        /* End catch*/
        p.compile(this);
        pushControl(new ControlFlowElement(p, this, cParameterizedPrimitive));
        // relocList.ifBranches.markReloc(p);
    }

    /** Compile an unresolved unconditional branch.
     * throws NoSuchMethodException self-explanatory
     * throws ClassNotFoundException self-explanatory
     * throws OpenIfBranch self-explanatory
     * throws BadPrimitiveCompile self-explanatory
     * throws BadDefinitionCompile self-explanatory
     * throws BadPrimitiveExecute self-explanatory
     * throws BadDefinitionExecute self-explanatory
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void compileBranch()
    throws java.lang.NoSuchMethodException
    , java.lang.ClassNotFoundException
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.OpenIfBranch
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionExecute {
        ParameterizedPrimitive p;
        announce("Creating parameterized primitive for unconditional branch.");
        try {
            p = new ParameterizedPrimitive
            .UnconditionalBranch(getCurrentDefinition()
            .compositionLength()
            );
        }                                                          /* End try*/
        catch (Exception e) {
            String s = "Problem opening an unconditional branch in current definition."
            + getCurrentDefinition();
            announce(s);
            outputError(e);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.OpenIfBranch(s, e);
        }                                                        /* End catch*/
        p.compile(this);
        pushControl(new ControlFlowElement(p, this, cParameterizedPrimitive));
        // relocList.ifBranches.markReloc(p);
    }                                       /* public void compileBranch ()*/

    /** Resolve a conditional or unconditional branch by popping control stack,
     * evaluating the integer offset at which the Parameterized
     * Primitive recorded itself in the (to resolution) unidentified
     * definition, and change the Primitive to hold the bump delta.
     * This works because the reference on the control flow stack
     * is a reference to the same object that got compiled into the
     * definition.
     * throws ControlFlowStackImbalance self-explanatory
     * throws BranchResolution self-explanatory
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void resolveBranch()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution {
        ControlFlowElement c = popParamPrimControl();/* Throws if non a ParamPrim.*/

        if (null == c)                                  /* Did we get anything?*/ {
            String s = "Branch resolution failure.";
            announce(s);
            throw new
            com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution(s, null);
        }                                                           /* End if*/

        ParameterizedPrimitive p =  /* Manipulate branch in definition via ref.*/
        (ParameterizedPrimitive) c.getElement();

        if (p.validate()) {/* Now resolve the branch via the ref from the stack.*/
            int origin = (Integer) p.getObject();
            int destination =   /* Okay - inner Interpreter while loop tests .LT.*/
            getCurrentDefinition().compositionLength();
            p.setObject((destination - origin) - 1);  /* Resolution.*/
      /* "Minus one" because this is the bump delta to the instruction
       * pointer, which latter has already been post-incremented in the
       * inner Interpreter loop.
       */
        }

        else                                                      /* Not valid.*/ {
            String s = "Branch resolution failure.";
            announce(s);
            throw new
            com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution(s, null);
        }                                                           /* End if*/
    }                                        /* public void resolveBranch()*/

    /** Make an 'else' by laying down an unconditional branch out
     * of the true-clause of the 'if' and then resolving the 'if'
     * to point just past it.
     * throws ControlFlowStackImbalance self-explanatory
     * throws BranchResolution self-explanatory
     * throws NoSuchMethodException self-explanatory
     * throws ClassNotFoundException self-explanatory
     * throws OpenIfBranch self-explanatory
     * throws BadPrimitiveCompile self-explanatory
     * throws BadDefinitionCompile self-explanatory
     * throws BadPrimitiveExecute self-explanatory
     * throws BadDefinitionExecute self-explanatory
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void compileAndResolveBranch()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution
    , java.lang.NoSuchMethodException
    , java.lang.ClassNotFoundException
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.OpenIfBranch
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionExecute {
    /* Retrieve the previously laid down unresolved branch. */
        ControlFlowElement c = popParamPrimControl();/* Throws if non a ParamPrim.*/
        if (null == c)                                  /* Did we get anything?*/ {
            String s = "Branch resolution failure.";
            announce(s);
            throw new
            com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution(s, null);
        }                                                           /* End if*/

    /* Keep unresolved in hand while laying down a new unresolved unconditional. */
        compileBranch();   /* Now quick like a bunny lay down a new unresolved.*/
        pushControl(c);/* Sneakily push back the previously retrieved unresolved.*/
        resolveBranch();/* Resolve the previously unresolved, leaving new unres.*/
    }                              /* public void compileAndResolveBranch()*/

    /** Push an unresolved unconditional branch. I.e., this is 'begin'.
     * The unconditional branch can be discarded for a conditional branch
     * if it turns out the the 'begin' is resolved by an 'until' instead
     * of an 'again' or 'repeat'.
     * throws NoSuchMethodException self-explanatory
     * throws ClassNotFoundException self-explanatory
     * throws OpenIfBranch self-explanatory
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void pushUnconditionalBranch()
    throws java.lang.NoSuchMethodException
    , java.lang.ClassNotFoundException
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.OpenIfBranch {
        ParameterizedPrimitive p;
        announce("Creating parameterized primitive for unconditional branch.");
        try {
            p = new ParameterizedPrimitive
            .UnconditionalBranch(getCurrentDefinition()
            .compositionLength()
            );
        }                                                          /* End try*/
        catch (Exception e) {
            String s = "Problem opening an unconditional branch in current definition."
            + getCurrentDefinition();
            announce(s);
            outputError(e);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.OpenIfBranch(s, e);
        }                                                        /* End catch*/
        pushControl(new ControlFlowElement(p, this, cParameterizedPrimitive));
    }                             /* public void pushUnconditionalBranch ()*/

    /** Compile an 'again', that is, resolve and compile
     * the unconditional branch pushed to the control
     * flow stack by 'begin'.
     * throws ControlFlowStackImbalance self-explanatory
     * throws BranchResolution self-explanatory
     * throws NoSuchMethodException self-explanatory
     * throws ClassNotFoundException self-explanatory
     * throws OpenIfBranch self-explanatory
     * throws BadPrimitiveCompile self-explanatory
     * throws BadDefinitionCompile self-explanatory
     * throws BadPrimitiveExecute self-explanatory
     * throws BadDefinitionExecute self-explanatory
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void compileUnconditionalBackwardsBranch()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution
    , java.lang.NoSuchMethodException
    , java.lang.ClassNotFoundException
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.OpenIfBranch
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionExecute {
    /* Retrieve the previously pushed unresolved branch. */
        ControlFlowElement c = popParamPrimControl();/* Throws if non a ParamPrim.*/
        if (null == c)                                  /* Did we get anything?*/ {
            String s = "Branch resolution failure.";
            announce(s);
            throw new
            com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution(s, null);
        }                                                           /* End if*/
        ParameterizedPrimitive p =         /* Grab branch to be resolved.      */
        (ParameterizedPrimitive) c.getElement();
        if (p.validate()) {/* Now resolve the branch via the ref from the stack.*/
            int destination = (Integer) p.getObject();
            int origin =
            getCurrentDefinition().compositionLength();
            p.setObject((destination - origin) - 1);/* Resolution backwards.*/
            p.compile(this);                                      /* Lay it down.*/
        }
        else                                                      /* Not valid.*/ {
            String s = "Branch resolution failure.";
            announce(s);
            throw new
            com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution(s, null);
        }                                                           /* End if*/
    }                  /* public void compileUnconditionalBackwardsBranch()*/

    /** Compile an 'until', that is, calc the delta from the unconditional
     * backwards branch pushed to the control flow stack by 'begin' and
     * compile a conditional branch.
     * throws ControlFlowStackImbalance self-explanatory
     * throws BranchResolution self-explanatory
     * throws NoSuchMethodException self-explanatory
     * throws ClassNotFoundException self-explanatory
     * throws OpenIfBranch self-explanatory
     * throws BadPrimitiveCompile self-explanatory
     * throws BadDefinitionCompile self-explanatory
     * throws BadPrimitiveExecute self-explanatory
     * throws BadDefinitionExecute self-explanatory
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void compileConditionalBackwardsBranch()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution
    , java.lang.NoSuchMethodException
    , java.lang.ClassNotFoundException
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.OpenIfBranch
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionExecute {
    /* Retrieve the previously pushed unresolved branch. */
        ControlFlowElement c = popParamPrimControl();/* Throws if non a ParamPrim.*/
        if (null == c)                                  /* Did we get anything?*/ {
            String s = "Branch resolution failure.";
            announce(s);
            throw new
            com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution(s, null);
        }                                                           /* End if*/
        ParameterizedPrimitive p =         /* Grab branch to be resolved.      */
        (ParameterizedPrimitive) c.getElement();
        if (p.validate()) {/* Now resolve the branch via the ref from the stack.*/
            int destination = (Integer) p.getObject();
            int origin =
            getCurrentDefinition().compositionLength();
            try {
                p =/* Discard the unconditional pushed by 'begin', create new branch.*/
                new ParameterizedPrimitive   /* Resolution backwards.            */
                .ConditionalBranch((destination-origin) - 1);
            }                                                        /* End try*/
            catch (Exception e) {
                String s = "Problem creating a conditional branch in current definition."
                + getCurrentDefinition();
                announce(s);
                outputError(e);
                throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.OpenIfBranch(s, e);
            }                                                      /* End catch*/
            p.compile(this);                                      /* Lay it down.*/
        }
        else                                                      /* Not valid.*/ {
            String s = "Branch resolution failure.";
            announce(s);
            throw new
            com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution(s, null);
        }                                                           /* End if*/
    }                    /* public void compileConditionalBackwardsBranch()*/

    /** Compile an 'repeat', that is, resove the unconditional
     * backwards branch pushed to the control flow stack by 'begin' and
     * compile it, all after resolving the conditional forward branch
     * pushed by 'while' ( == 'if').
     * throws ControlFlowStackImbalance self-explanatory
     * throws BranchResolution self-explanatory
     * throws NoSuchMethodException self-explanatory
     * throws ClassNotFoundException self-explanatory
     * throws OpenIfBranch self-explanatory
     * throws BadPrimitiveCompile self-explanatory
     * throws BadDefinitionCompile self-explanatory
     * throws BadPrimitiveExecute self-explanatory
     * throws BadDefinitionExecute self-explanatory
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void resolveTwoBranches()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution
    , java.lang.NoSuchMethodException
    , java.lang.ClassNotFoundException
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.OpenIfBranch
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionExecute {
        ControlFlowElement cfb = popControl();     /* We have to swap these ...*/
        ControlFlowElement ubb = popControl();    /* ... so that the 'while ...*/
        pushControl(cfb);                       /* ... will branch out past ...*/
        pushControl(ubb);                                  /* ... the 'repeat'.*/
        compileUnconditionalBackwardsBranch();/* Resolve the 'repeat' to 'begin'.*/
        resolveBranch();            /* Resolve the 'while' to past the 'begin'.*/
    }                                   /* public void resolveTwoBranches()*/

    /** The runtime for 'do', i.e., push the indices to control stack.
     * @param p The <CODE>Do</CODE> Semantic we are going to run.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void doDo(ParameterizedPrimitive.Do p) {
        int index = ((Long)pop()).intValue();
        announce("'do' index is " + index);
        int limit = ((Long)pop()).intValue();
        announce("'do' limit is " + limit);
        int egress = (Integer) p.getObject();
        announce("'do' egress is " + egress);
        innerInterpreter.startLoop(limit, index, egress);
    }

    /** Push control flow entry representing an unresolved 'do' and compile
     * the runtime for it.
     * throws NoSuchMethodException self-explanatory
     * throws ClassNotFoundException self-explanatory
     * throws OpenIfBranch self-explanatory
     * throws BadPrimitiveCompile self-explanatory
     * throws BadDefinitionCompile self-explanatory
     * throws BadPrimitiveExecute self-explanatory
     * throws BadDefinitionExecute self-explanatory
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void compileDo()
    throws java.lang.NoSuchMethodException
    , java.lang.ClassNotFoundException
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.OpenIfBranch
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionExecute {
        announce("Creating primitive for 'do'");
        ParameterizedPrimitive p;  /* Compile current offset for branch marker,*/
    /* later resolved to 'leave' offset.*/
        announce("Creating parameterized primitive for 'do'.");
        try {/* If it turns out to be a +loop we'll discard this later, using delta.*/
            p = new ParameterizedPrimitive/* Not compiled, just used as a marker.*/
            .Do(getCurrentDefinition()
            .compositionLength() + 1/* To right after the 'do' runtime.*/
            );
        }                                                          /* End try*/
        catch (Exception e) {
            String s = "Problem opening an unconditional branch in current definition."
            + getCurrentDefinition();
            announce(s);
            outputError(e);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.OpenIfBranch(s, e);
        }                                                        /* End catch*/
        pushControl(new ControlFlowElement(p, this, cParameterizedPrimitive));
        p.compile(this);
        // relocList.ifBranches.markReloc(p);
    }

    /** Runtime for 'loop'. Called from a ParameterizedPrimitive having
     * embedded object, the Integer stored indicating the bump value.
     * @param p The <code>Loop</code> Semantic we are going to execute.
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void loop(ParameterizedPrimitive.Loop p) {
        boolean done = innerInterpreter.loop();
        if (!done) {
            Integer i = (Integer) p.getObject();
            bump(i);
        }                                                           /* End if*/
    }                   /* public void loop (ParameterizedPrimitive.Loop p)*/

    /** Runtime for '+loop'. Called from a ParameterizedPrimitive having
     * embedded object, the Integer stored indicating the bump value.
     * @param p  */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void plusLoop(ParameterizedPrimitive.PlusLoop p) {
        int increment = ((Long)pop()).intValue();/* Get loop increment from stack.*/
        boolean done = innerInterpreter.plusLoop(increment);
        if (!done) {
            Integer i = (Integer) p.getObject();
            bump(i);
        }                                                           /* End if*/
    }                   /* public void loop (ParameterizedPrimitive.Loop p)*/

    /** Compile a 'loop' resolved to where the 'do' was encountered by
     * popping control stack,  evaluating the integer offset at
     * which the ParameterizedPrimitive recorded from the
     * current definition, changing the Primitive to hold the bump delta,
     * and compiling it into the current definition.
     * Doesn't validate that it's a Loop yet, should do that.
     * throws ControlFlowStackImbalance
     * throws BranchResolution
     * throws ClassNotFoundException
     * throws NoSuchMethodException
     * throws BadPrimitiveCompile
     * throws BadDefinitionCompile
     * throws BadPrimitiveExecute
     * throws BadDefinitionExecute  */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void compileLoop()
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution
    , java.lang.ClassNotFoundException
    , java.lang.NoSuchMethodException
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionExecute {
        ControlFlowElement c = popParamPrimControl();/* Throws if non a ParamPrim.*/

        if (null == c)                                  /* Did we get anything?*/ {
            String s = "Branch resolution failure.";
            announce(s);
            throw new
            com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution(s, null);
        }                                                           /* End if*/

        ParameterizedPrimitive p =  /* Manipulate branch in definition via ref.*/
        (ParameterizedPrimitive) c.getElement();

        if (p.validate()) {/* Now resolve the back branch via the ref from stack.*/
            int destination = (Integer) p.getObject();
            int origin =                /* Add one because inner interp will have*/
      /*  postincremented  past this compilation. */
            getCurrentDefinition().compositionLength() + 1;
            int delta = destination - origin;/* Backwards value.                 */
            p.setObject(origin); /* 'leave' Resolution for the 'do'.*/
            p = new ParameterizedPrimitive.Loop(delta);/* Create the resolved Loop.*/
            p.compile(this);                        /* Compile the resolved loop.*/
        }

        else                                                      /* Not valid.*/ {
            String s = "Branch resolution failure.";
            announce(s);
            throw new
            com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution(s, null);
        }                                                           /* End if*/
    }                                          /* public void compileLoop()*/

    /** Compile a '+loop' resolved to where the 'loop' was encountered by
     * popping control stack,  evaluating the integer offset at
     * which the ParameterizedPrimitive recorded from the
     * current definition, changing the Primitive to hold the bump delta,
     * and compiling it into the current definition.
     * Doesn't validate that it's a Loop yet, should do that.
     * throws NoSuchMethodException
     * throws ClassNotFoundException
     * throws ControlFlowStackImbalance
     * throws BranchResolution
     * throws BadPrimitiveCompile
     * throws BadDefinitionCompile
     * throws BadPrimitiveExecute
     * throws BadDefinitionExecute  */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void compilePlusLoop()
    throws java.lang.NoSuchMethodException
    , java.lang.ClassNotFoundException
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.ControlFlowStackImbalance
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionExecute {
        ControlFlowElement c = popParamPrimControl();/* Throws if non a ParamPrim.*/

        if (null == c)                                  /* Did we get anything?*/ {
            String s = "Branch resolution failure.";
            announce(s);
            throw new
            com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution(s, null);
        }                                                           /* End if*/

        ParameterizedPrimitive p =  /* Manipulate branch in definition via ref.*/
        (ParameterizedPrimitive) c.getElement();

        if (p.validate()) {/* Now resolve the back branch via the ref from stack.*/
            int destination = (Integer) p.getObject();
            int origin =                /* Add one because inner interp will have*/
      /*  postincremented  past this compilation. */
            getCurrentDefinition().compositionLength() + 1;
            int delta = destination - origin;/* Backwards Resolution.            */
            announce("Delta compiling +loop is " + delta);
            p.setObject(origin); /* 'leave' Resolution for the 'do'.*/
            p =                             /* Now create the PlusLoop, resolved.*/
            new ParameterizedPrimitive     /* Create new PlusLoop.             */
            .PlusLoop(delta);                       /* Backwards Resolution.*/
            p.compile(this);                                 /* Compile the loop.*/
        }

        else                                                      /* Not valid.*/ {
            String s = "Branch resolution failure.";
            announce(s);
            throw new
            com.softwoehr.fiji.base.Exceptions.desktop.shell.BranchResolution(s, null);
        }                                                           /* End if*/
    }                                      /* public void compilePlusLoop()*/

    /** Return a loop index. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void index() {
        push((long) innerInterpreter.ithIndex(((Long) pop()).intValue()));
    }                                               /* public void index ()*/

    /** Perform a leave at runtime */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void doLeave() {
        innerInterpreter.leaveLoop();
    }

    //************/
  /* Utilities */
    //************/

    /** Do a newline on the output. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void cr() {
        output("\n");
    }

    /** Set the Interpreter verbose or non- at runtime. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void runtimeVerbose() {
        setVerbose((Boolean) pop());
    }

    /** Decompile and print out. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void decompile() {
        Semantic s = (Semantic) pop();
        Semantic semantics[] = s.decompile();
        output(": " + s.getName() + " ");
        for (int i = 0; i < semantics.length ; ++i) {
            Semantic x = semantics[i];
            output(x.getName() + " ");
            if (x.getClass() == cLiteral) {
                myInterpreter
                .output(((ParameterizedPrimitive.Literal)x).getObject() + " ");
            }                                                         /* End if*/
        }                                                          /* End for*/
        output(";\n");
    }                                           /* public void decompile ()*/

    /** Interpret a string as fiji input. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void interpret() {
        myInterpreter.interpret((String)pop());
    }                                           /* public void interpret ()*/

    /** Load FIJI source from a file. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void load() {
        String fileName = (String) pop();
        File file = new File(fileName);
        long length = file.length();
        char input[] = new char[(int)length];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            try {
                inputStreamReader.read(input, 0, (int)length);
                String sourceCode = new String(input);
                myInterpreter.interpret(sourceCode);
            }                                                        /* End try*/
            catch (Exception e) {
                outputError(e);
            }                                                      /* End catch*/
            finally {
                fileInputStream  .close();
                inputStreamReader.close();
            }                                                    /* End finally*/
        }                                                          /* End try*/
        catch (Exception e) {
            outputError(e);
        }                                                        /* End catch*/
    }                                                 /* public void load()*/

    public static String fijiVersion() {
        return  "1.2";
    }

    /** Push the version of FIJI */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void version() {
        push(fijiVersion());
    }

    //************/
  /* Wordlists */
    //************/

    /** Create a new Wordlist and add it to the current wordlist.
     * throws BadName If no valid name found.  */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void newWordlist()
    throws  com.softwoehr.fiji.base.Exceptions.desktop.shell.BadName {
        String s = parseValidName();
        currentWordlist.put(new Wordlist(s));
    }

    /** Fetch the search order to stack. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void getOrder() {
        searchOrder.getOrder(this);
    }                                             /* public void getOrder()*/

    /** Set search order from stack. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void setOrder() {
        searchOrder.setOrder(this);
    }                                             /* public void setOrder()*/

    /** Set current Wordlist to the Wordlist on the top of the stack. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void setCurrent() {
        currentWordlist = (Wordlist) pop();
    }

    /** Get current Wordlist. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void getCurrent() {
        push(currentWordlist);
    }

    /** List all the words in the accessed Wordlists. */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void words() {
        output(searchOrder.words());
    }

    /** Pop the active Semantic of a wordlist entry in first
     * place found in the search order, discarding the entry
     * if no previous Semantic exists by that name.
     *
     * see com.SoftWoehr.desktop.shell.SearchOrder.forget
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void forget() {
        boolean result;
        String name = (String)pop();
        result = searchOrder.forget(name);
        if (false == result) {
            output(name + " not found.\n");
        }                                                           /* End if*/
    }                                              /* public void forget ()*/

    /** Discard a wordlist entry in first
     * place found in the search order.
     *
     * see com.SoftWoehr.desktop.shell.SearchOrder.discard
     */
    @SuppressWarnings({"unused", "WeakerAccess"}) // referenced in WordList and called as a primitive
    public void discard() {
        boolean result;
        String name = (String)pop();
        result = searchOrder.discard(name);
        if (false == result) {
            output(name + " not found.\n");
        }                                                           /* End if*/
    }                                              /* public void discard()*/

}                                                    /* End of Engine class*/

/*  End of Engine.java */
