/* JavaParam.java ...  */
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
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
public class JavaParam {

    /** The actual object passed as a parameter. */
    private Object realObject;
    
    /** The class the parameter needs to be represented as
     * in resolving the method call.
     */
    private Class signatureClass;
    
    /** Arity/0 ctor. */
    public JavaParam() {
        this(new Object(), new Object().getClass());
    }
    
    /** Arity/1 ctor.
     * @param o  */
    public JavaParam(Object o) {
        this(o, o.getClass());
    }
    
    /** Arity/2 ctor.
     * @param o
     * @param c  */
    public JavaParam(Object o, Class c) {
        reinit(o, c);
    }
    
    /** Return a string representation of the object.
     * @return a string representation of the object.
     */
    public String toString() {
        String s = "(" + signatureClass + ")" + realObject;
        return s;
    }
    
    /** shutdown() here does nothing.
     * @see com.softwoehr.SoftWoehr#
     * @return  */
    public int shutdown() { return 0; }
    
    /** Reinitialize object, discarding previous state.
     * @param o
     * @param c  */
    public void reinit(Object o, Class c) {
        realObject = o;
        signatureClass = c;
    }
    
    /** Return the real object this JavaParam represents.
     * @return  */
    public Object getRealObject() {
        return realObject;
    }
    
    /** Set the real object this JavaParam represents.
     * @param o  */
    public void setRealObject(Object o) {
        realObject = o;
    }
    
    /** Get the class this JavaParam represents in the method signature.
     * @return  */
    public Class getSignatureClass() {
        return signatureClass;
    }
    
    /** Set the class this JavaParam represents in the method signature.
     * @param c  */
    public void setSignatureClass(Class c) {
        signatureClass = c;
    }
    
}                                                 /* End of JavaParam class*/

/*  End of JavaParam.java */
