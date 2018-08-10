package com.softwoehr.fiji.interpreter;

/** Represents a parameter to a Java call.
 * The problem this class addresses is that
 * the "naive" means for deciding the signature
 * of a Java method call involves examining the
 * the class of the passed parameter. Consider,
 * however, the case of java.lang.String.equals(Object) ...
 * If the user provides a String, the Interpreter tries
 * to resolve a call to java.lang.String.equals(String),
 * a method which does not exist.
 *
 *<p> JavaParam allows a parameter to record what it
 * wants to be considered as when Class.getDefinedMethod()
 * is called.
 */
public class JavaParam {

    /** The actual object passed as a parameter. */
    private Object realObject;

    /** The class the parameter needs to be represented as
     * in resolving the method call.
     */
    private Class signatureClass;

    public JavaParam() {
        this(new Object(), new Object().getClass());
    }

    JavaParam(Object o) {
        this(o, o.getClass());
    }

    JavaParam(Object o, Class c) {
        reinit(o, c);
    }

    public String toString() {
        String s = "(" + signatureClass + ")" + realObject;
        return s;
    }

    private void reinit(Object o, Class c) {
        realObject = o;
        signatureClass = c;
    }

    Object getRealObject() {
        return realObject;
    }

    Class getSignatureClass() {
        return signatureClass;
    }
}