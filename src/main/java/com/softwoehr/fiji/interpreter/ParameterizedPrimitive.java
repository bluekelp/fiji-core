/* ParameterizedPrimitive.java ...  */
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

package com.softwoehr.fiji.interpreter;

/** ParameterizedPrimitive is an on-the-fly Primitive which
 * we declare to provide special runtimes to be compiled by
 * special compilation semantics, e.g., the runtime of
 * compiled 'to'.
 *
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
public class ParameterizedPrimitive extends Primitive {
    /** The object that this prim implicitly operates upon. */
    private Object myObject;
    private Class  myObjectClass;

    private static Class intClassInstance;
    private static Class intClass() throws ClassNotFoundException {
        if (intClassInstance == null)
            intClassInstance = Class.forName("java.lang.Integer");

        return intClassInstance;
    }

    private static Class objClassInstance;
    private static Class objClass() throws ClassNotFoundException {
        if (objClassInstance == null)
            objClassInstance = Class.forName("java.lang.Object");

        return objClassInstance;
    }

    /** The primitive for a branch. */
    public static class Branch extends ParameterizedPrimitive {
        /**
         * @param name
         * @param methodName
         * @param delta
         * @throws ClassNotFoundException
         * @throws NoSuchMethodException  */
        public Branch( String name
        , String methodName
        , int delta
        )
        throws java.lang.ClassNotFoundException
        , java.lang.NoSuchMethodException {
            super(name, methodName, new Integer(delta), intClass());
        }
    }                                                  /* End of Branch class*/

    /** The primitive for an unconditional branch. */
    public static class UnconditionalBranch extends Branch {
        /** Construct an unconditional branch.
         * @param delta
         * @throws ClassNotFoundException
         * @throws NoSuchMethodException  */
        public UnconditionalBranch(int delta)
        throws java.lang.ClassNotFoundException
        , java.lang.NoSuchMethodException {
            super( "unconditionalBranch"
            , "doUnconditionalBranch"
            , delta
            );
        }

        /** Return string representation of the primitive.
         * @return  */
        public String toString() {
            Object  o = super.getObject();
            Integer i = (Integer) o;
            String s = "An UnconditionalBranch of " + i;
            return s;
        }
    }                                     /* End of UnconditionalBranch class*/

    /** The primitive for a conditional branch. */
    public static class ConditionalBranch extends Branch {
        /** Construct a conditional branch.
         * @param delta
         * @throws ClassNotFoundException
         * @throws NoSuchMethodException  */
        public ConditionalBranch(int delta)
        throws java.lang.ClassNotFoundException
        , java.lang.NoSuchMethodException {
            super( "conditionalBranch"
            , "doConditionalBranch"
            , delta
            );
        }

        /** Return string representation of the primitive.
         * @return  */
        public String toString() {
            Object  o = super.getObject();
            Integer i = (Integer) o;
            String s = "A ConditionalBranch of " + i;
            return s;
        }
    }                                       /* End of ConditionalBranch class*/

    /** The primitive for a literal. */
    public static class Literal extends ParameterizedPrimitive {
        /** Construct a literal for any object.
         * @param o
         * @throws ClassNotFoundException
         * @throws NoSuchMethodException  */
        public Literal(Object o)
        throws java.lang.ClassNotFoundException
        , java.lang.NoSuchMethodException {
            super ( "(literal)"
            , "doLiteral"
            , o
            , objClass()
            );
        }

        /** Return string representation of the primitive.
         * @return  */
        public String toString() {
            Object  o = super.getObject();
            String s = "A Literal for " + o;
            return s;
        }
    }                                                 /* End of Literal class*/

    /** The primitive for a do. The Integer is the "leave" offset
     * in the Definition.
     */
    public static class Do extends ParameterizedPrimitive {
        /**
         * @param offset
         * @throws ClassNotFoundException
         * @throws NoSuchMethodException  */
        public Do   (int offset)   /* Offset in definition at which 'do' occurs*/
        throws java.lang.ClassNotFoundException
        , java.lang.NoSuchMethodException {
            super("(do)", "doDo", new Integer(offset), intClass());
        }
    }                                                      /* End of Do class*/

    /** The primitive for a loop. */
    public static class Loop extends ParameterizedPrimitive {
        /**
         * @param delta
         * @throws ClassNotFoundException
         * @throws NoSuchMethodException  */
        public Loop   (int delta)
        throws java.lang.ClassNotFoundException
        , java.lang.NoSuchMethodException {
            super("(loop)", "loop", new Integer(delta), intClass());
        }
    }                                                    /* End of Loop class*/

    /** The primitive for a +loop. */
    public static class PlusLoop extends ParameterizedPrimitive {
        /**
         * @param delta
         * @throws ClassNotFoundException
         * @throws NoSuchMethodException  */
        public PlusLoop   (int delta)
        throws java.lang.ClassNotFoundException
        , java.lang.NoSuchMethodException {
            super("(+loop)", "plusLoop", new Integer(delta), intClass());
        }
    }                                                    /* End of Loop class*/

    /** Arity/4 ctor, passing in a name for the primitive,
     * a method name to resolve for class Engine, an Object
     * (possibly null) to be the datum for this primitive instance,
     * and an object class referring to the datum to allow validation
     * of dynamically initialized ParameterizedPrimitive's.
     * @param name
     * @param methodName
     * @param object
     * @param objectClass
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException  */
    public ParameterizedPrimitive(String name
    ,String methodName
    ,Object object
    ,Class objectClass
    )
    throws java.lang.ClassNotFoundException
    , java.lang.NoSuchMethodException {
        reinit(name, methodName, object, objectClass);
    }

    /** Reinitialize object setting name, method name, object, object class.
     * @param name
     * @param methodName
     * @param o
     * @param objectClass
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException  */
    public void reinit( String name
    , String methodName
    , Object o
    , Class objectClass
    )
    throws java.lang.ClassNotFoundException
    , java.lang.NoSuchMethodException {
        myObject = o;
        myObjectClass = objectClass;
        setName(name);
        Class signature[] = new Class[1];
        signature[0] = this.getClass();
        Class c = Class.forName("com.softwoehr.fiji.interpreter.Engine");
        method = c.getMethod(methodName, signature);     /* All Arity/0*/
    }

    /** Return string representation of object. Doesn't do any
     * checking for object validity.
     * @return  */
    public String toString() {
        String s = "";
        s += "A ParameterizedPrimitive named " + getName();
        s += " with an Object of " + getObject().toString();
        s += " with a real Class of " + getObject().getClass().toString();
        s += " with a declared Class of " + getObjectClass().toString();
        return s;
    }

    /** Invoke Engine method on has'd Object.
     * @param e  */
    public void execute(Engine e) {
        Object argArray[] = new Object[1];
        argArray[0] = this;
        try {
            method.invoke(e, argArray);
        }                                                          /* End try*/
        catch (Exception ex) {                                           /* ! Clean this up later!*/
            ex.printStackTrace(System.err);
        }                                                        /* End catch*/
    }

    /** Get the object this paramprim operates on implicitly.
     * @return  */
    public Object getObject() {
        return myObject;
    }

    /** Set the object this paramprim operates on implicitly.
     * @param o  */
    public void setObject(Object o) {
        myObject = o;
    }

    /** Get the Class this paramprim operates on implicitly.
     * @return  */
    public Class getObjectClass() {
        return myObjectClass;
    }

    /** Set the Class this paramprim operates on implicitly.
     * @param o  */
    public void setObjectClass(Class o) {
        myObjectClass = o;
    }

    /** Validate that object and object class are instanced
     * and that object class equals declared object class.
     * The validation check presumes the programmer was right,
     * i.e., that the declared object class is what is intended.
     * This method validate() thus only guards against runtime
     * non-instantiation or instantiation with the wrong type
     * of object. Cf. Engine.runtimeTo() which calls validate()
     * but doesn't compare to class Value because it's assumed
     * that the code creating the primitive knew what class was meant.
     * @return  */
    public boolean validate() {
        boolean result = true;
        if (null == myObject || null == myObjectClass) {
            result = false;
        }                                                           /* End if*/
        else {
            result= myObject.getClass().equals(myObjectClass);
        }
        return result;
    }
}                                                      /* End of ParameterizedPrimitive class*/

/*  End of ParameterizedPrimitive.java */
