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

package com.SoftWoehr.FIJI.base.desktop.shell;

import  com.SoftWoehr.*;
import  com.SoftWoehr.util.*;

/** Represents a parameter to a Java call.
 * The problem this class addresses is that
 * the "naive" means for deciding the signature
 * of a Java method call involves examining the
 * the class of the passed parameter. Consider,
 * however, the case of java.lang.String.equals(Object) ...
 * If the user provides a String, the interpreter tries
 * to resolve a call to java.lang.String.equals(String),
 * a method which does not exist.
 *
 *<p> JavaParam allows a parameter to record what it
 * wants to be considered as when Class.getDefinedMethod()
 * is called.
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
public class JavaParam implements SoftWoehr, verbose {
    
    /** Revision level */
    private static final String rcsid = "$Id: JavaParam.java,v 1.1.1.1 2001/08/21 02:39:18 jwoehr Exp $";
    /** Implements com.SoftWoehr.SoftWoehr
     * @return  */
    public String rcsId() {return rcsid;}
    
    /**  Flags whether we are in verbose mode. */
    private boolean isverbose = false;
    /**  Helper for verbose mode. */
    private verbosity v = new verbosity(this);
    
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
     * @see com.SoftWoehr.SoftWoehr#
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
    
    /**
     * @see com.SoftWoehr.util.verbose#
     * @see com.SoftWoehr.util.verbosity#
     * @return  */
    public boolean isVerbose()              {return isverbose;}
    
    /**
     * @see com.SoftWoehr.util.verbose#
     * @see com.SoftWoehr.util.verbosity#
     * @param tf  */
    public void    setVerbose  (boolean tf) {isverbose = tf;  }
    
    /**
     * @see com.SoftWoehr.util.verbose#
     * @see com.SoftWoehr.util.verbosity#
     * @param s  */
    public void    announce    (String s)   {v.announce(s);   }
    
    /** Demonstrate <code>JavaParam</code>.
     * @param argv  */
    public static void main(String argv[]) {
        
        GetArgs myArgs = new GetArgs(argv);/* Assimilate the command line.     */
        
    /* GPL'ed SoftWoehr announces itself. */
        System.out.println("JavaParam, Copyright (C) 1999 Jack J. Woehr.");
        System.out.println("JavaParam comes with ABSOLUTELY NO WARRANTY;");
        System.out.println("Please see the file COPYING and/or COPYING.LIB");
        System.out.println("which you should have received with this software.");
        System.out.println("This is free software, and you are welcome to redistribute it");
        System.out.println("under certain conditions enumerated in COPYING and/or COPYING.LIB.");
        
        // Test code goes here.
        // -------------------
        
        GetArgs.main(argv);       /* Delete this stub when you write some code.*/
        System.out.println("Not implemented.");
        // -------------------
        
        return;
    }
}                                                 /* End of JavaParam class*/

/*  End of JavaParam.java */
