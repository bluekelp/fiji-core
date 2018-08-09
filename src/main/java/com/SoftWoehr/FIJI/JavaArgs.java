package com.SoftWoehr.FIJI;

import com.SoftWoehr.FIJI.interpreter.JavaParam;

import java.util.Enumeration;
import java.util.Vector;

/** A class to represent arguments passed to Java method resolution,
 * and thence to a Java method invocation. Necessitated by the fact
 * that arguments sometimes must be of one class but cast as another,
 * e.g., java.lang.String.equals(java.lang.Object o) but the Object
 * is a String.
 */
public class JavaArgs extends Vector {
    /** Create a JavaArgs object to pass args to java method invocation.
     */
    public JavaArgs() {}                     /* Needs an arity/1 on Object[]*/

    /** Return an object array of the elements of the vector.
     * All the objects in the JavaArgs vector are stored in JavaParam's,
     * along with their nominal class for the purpose of method signature
     * resolution.
     * @see JavaParam#
     * @return An array of objects representing the arguments stored
     * in a JavaArgs
     */
    public synchronized Object[] toObjectArray() {
        int sz = size();
        Object result[] = new Object[sz];
        Enumeration e = elements();
        for (int i = 0; i < sz ; ++i) {
            result[i] = ((JavaParam) (e.nextElement())).getRealObject();
        }                                                          /* End for*/
        return result;
    }

    /** Return a Class array of the classes of the elements of the vector.
     * All the objects and their nominal classes for the purpose of
     * method signature resolution are stored as JavaParams in the vector.
     * see com.SoftWoehr.desktop.shell.JavaParam#
     * @return The array of classes from the vector.
     */
    public synchronized Class[] toClassArray() {
        int sz = size();
        Class result[] = new Class[sz];
        Enumeration e = elements();
        for (int i = 0; i < sz ; ++i) {
            result[i] = ((JavaParam) (e.nextElement())).getSignatureClass();
        }                                                          /* End for*/
        return result;
    }
}                                                /* End of JavaArgs class*/
