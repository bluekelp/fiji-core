package com.softwoehr.fiji.core;

/**
 * ParameterizedPrimitive is an on-the-fly Primitive which
 * we declare to provide special runtimes to be compiled by
 * special compilation semantics, e.g., the runtime of
 * compiled 'to'.
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

    // The primitive for a branch.
    static class Branch extends ParameterizedPrimitive {
        Branch(String name
                , String methodName
                , int delta
        )
        throws java.lang.ClassNotFoundException
        , java.lang.NoSuchMethodException {
            super(name, methodName, delta, intClass());
        }
    }

    // The primitive for an unconditional branch.
    public static class UnconditionalBranch extends Branch {
        // Construct an unconditional branch.
        UnconditionalBranch(int delta)
        throws java.lang.ClassNotFoundException
        , java.lang.NoSuchMethodException {
            super( "unconditionalBranch"
            , "doUnconditionalBranch"
            , delta
            );
        }

        public String toString() {
            Object  o = super.getObject();
            Integer i = (Integer) o;
            String s = "An UnconditionalBranch of " + i;
            return s;
        }
    }

    // The primitive for a conditional branch.
    public static class ConditionalBranch extends Branch {
        // Construct a conditional branch.
        ConditionalBranch(int delta)
        throws java.lang.ClassNotFoundException
        , java.lang.NoSuchMethodException {
            super( "conditionalBranch"
            , "doConditionalBranch"
            , delta
            );
        }

        public String toString() {
            Object  o = super.getObject();
            Integer i = (Integer) o;
            String s = "A ConditionalBranch of " + i;
            return s;
        }
    }

    public static class Literal extends ParameterizedPrimitive {
        Literal(Object o)
        throws java.lang.ClassNotFoundException
        , java.lang.NoSuchMethodException {
            super ( "(literal)"
            , "doLiteral"
            , o
            , objClass()
            );
        }

        public String toString() {
            Object  o = super.getObject();
            String s = "A Literal for " + o;
            return s;
        }
    }

    /** The primitive for a do. The Integer is the "leave" offset
     * in the Definition.
     */
    public static class Do extends ParameterizedPrimitive {
        public Do   (int offset)   /* Offset in definition at which 'do' occurs*/
        throws java.lang.ClassNotFoundException
        , java.lang.NoSuchMethodException {
            super("(do)", "doDo", offset, intClass());
        }
    }

    static class Loop extends ParameterizedPrimitive {
        Loop(int delta)
        throws java.lang.ClassNotFoundException
        , java.lang.NoSuchMethodException {
            super("(loop)", "loop", delta, intClass());
        }
    }

    /** The primitive for a +loop. */
    static class PlusLoop extends ParameterizedPrimitive {
        PlusLoop(int delta)
        throws java.lang.ClassNotFoundException
        , java.lang.NoSuchMethodException {
            super("(+loop)", "plusLoop", delta, intClass());
        }
    }

    /** Arity/4 ctor, passing in a name for the primitive,
     * a method name to resolve for class Engine, an Object
     * (possibly null) to be the datum for this primitive instance,
     * and an object class referring to the datum to allow validation
     * of dynamically initialized ParameterizedPrimitive's.
     */
    ParameterizedPrimitive(String name
            , String methodName
            , Object object
            , Class objectClass
    ) throws java.lang.ClassNotFoundException , java.lang.NoSuchMethodException {
        reinit(name, methodName, object, objectClass);
    }

    private void reinit(String name, String methodName, Object o, Class objectClass) throws java.lang.ClassNotFoundException, java.lang.NoSuchMethodException
    {
        myObject = o;
        myObjectClass = objectClass;
        setName(name);
        Class signature[] = new Class[1];
        signature[0] = this.getClass();
        Class c = Class.forName("com.softwoehr.fiji.core.Engine");
        method = c.getMethod(methodName, signature);
    }

    public String toString() {
        String s = "";
        s += "A ParameterizedPrimitive named " + getName();
        s += " with an Object of " + getObject().toString();
        s += " with a real Class of " + getObject().getClass().toString();
        s += " with a declared Class of " + getObjectClass().toString();
        return s;
    }

    // Invoke Engine method on has'd Object.
    public void execute(Engine e) {
        Object argArray[] = new Object[1];
        argArray[0] = this;
        try {
            method.invoke(e, argArray);
        }
        catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

    public Object getObject() {
        return myObject;
    }

    public void setObject(Object o) {
        myObject = o;
    }

    private Class getObjectClass() {
        return myObjectClass;
    }

    public void setObjectClass(Class o) {
        myObjectClass = o;
    }

    /**
     * Validate that object and object class are instanced
     * and that object class equals declared object class.
     * The validation check presumes the programmer was right,
     * i.e., that the declared object class is what is intended.
     * This method validate() thus only guards against runtime
     * non-instantiation or instantiation with the wrong type
     * of object. Cf. Engine.runtimeTo() which calls validate()
     * but doesn't compare to class Value because it's assumed
     * that the code creating the primitive knew what class was meant.
     */
    boolean validate() {
        boolean result;
        if (null == myObject || null == myObjectClass) {
            result = false;
        }
        else {
            result= myObject.getClass().equals(myObjectClass);
        }
        return result;
    }
}
