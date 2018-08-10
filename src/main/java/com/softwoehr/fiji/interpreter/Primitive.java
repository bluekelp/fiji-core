package com.softwoehr.fiji.interpreter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// A Primitive is a Semantic coded all in Java.
class Primitive extends Semantic {
    /** Resolved method that represents execution semantics. */
    public Method method;

    /** Resolved method that represents compilation semantics. */
    private Method compilationMethod;

    Primitive() throws java.lang.ClassNotFoundException, java.lang.NoSuchMethodException {
        this("noop", "noop");
    }

    Primitive(String name, String methodName) throws java.lang.ClassNotFoundException, java.lang.NoSuchMethodException {
        this.setName(name);
        Class c = Class.forName("com.softwoehr.fiji.interpreter.Engine");
        method = c.getMethod(methodName);
    }

    // creates a named, resolved primitive
    Primitive(String name, String methodName, String compilationMethodName) throws java.lang.ClassNotFoundException, java.lang.NoSuchMethodException {
        this.setName(name);
        Class c = Class.forName("com.softwoehr.fiji.interpreter.Engine");
        method = c.getMethod(methodName);
        compilationMethod = c.getMethod(compilationMethodName);
    }

    // Execution semantics
    public void execute(Engine anEngine) throws InvocationTargetException, IllegalAccessException {
        method.invoke(anEngine);
    }

    /** Compilation semantics, the default behavior
     * being to append self to the current definition.
     * If the Primitive has special compilation semantics,
     * carry them out instead.
     */

    public void compile(Engine e) throws InvocationTargetException, IllegalAccessException {
        if (null == compilationMethod) {
            super.compile(e);
        }
        else {
            compilationMethod.invoke(e);
        }
    }

    /**
     * Decompilation semantics.
     * A primitive just returns itself.
     * */
    public Semantic[] decompile() {
        Semantic result [] = new Semantic[1];
        result[0] = this;
        return result;
    }
}
