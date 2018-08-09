/* Primitive.java ...  A builtin semantic.   */
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

import com.softwoehr.util.verbose;
import com.softwoehr.util.verbosity;

import java.lang.reflect.Method;

/** A Primitive is a Semantic coded all in Java.
 *
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
class Primitive extends Semantic implements verbose {
    /**  Flags whether we are in verbose mode. */
    public boolean isverbose = false;
    
    /**  Helper for verbose mode. */
    private verbosity v = new verbosity(this);
    
    /** Resolved method that represents execution semantics. */
    public Method method;
    
    /** Resolved method that represents compilation semantics. */
    public Method compilationMethod;
    
    /** Arity/0 ctor.
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException  */
    public Primitive()
    throws java.lang.ClassNotFoundException
    , java.lang.NoSuchMethodException {
        this("noop", "noop");
    }
    
    /** Arity/2 ctor. This creates
     * a named, resolved primitive, the only
     * useful constructor.
     * @param name
     * @param methodName
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException  */
    public Primitive(String name, String methodName)
    throws java.lang.ClassNotFoundException
    , java.lang.NoSuchMethodException {
        this.setName(name);
        Class c = Class.forName("com.softwoehr.fiji.interpreter.Engine");
        method = c.getMethod(methodName, new Class[0]);          /* All Arity/0*/
    }
    
    /** Arity/2 ctor. This creates
     * a named, resolved primitive, the only
     * useful constructor.
     * @param name
     * @param methodName
     * @param compilationMethodName
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException  */
    public Primitive(String name, String methodName, String compilationMethodName)
    throws java.lang.ClassNotFoundException
    , java.lang.NoSuchMethodException {
        this.setName(name);
        Class c = Class.forName("com.softwoehr.fiji.interpreter.Engine");
        method = c.getMethod(methodName, new Class[0]);          /* All Arity/0*/
        compilationMethod = c.getMethod(compilationMethodName
        , new Class[0]);  /* All Arity/0*/
    }
    
    /** shutdown() here does nothing.
     * @see com.softwoehr.SoftWoehr#
     * @return  */
    public int shutdown() { return 0; }
    
    /**
     * @see com.softwoehr.util.verbose#
     * @see com.softwoehr.util.verbosity#
     * @return  */
    public boolean isVerbose()              {return isverbose;}
    
    /**
     * @see com.softwoehr.util.verbose#
     * @see com.softwoehr.util.verbosity#
     * @param tf  */
    public void    setVerbose  (boolean tf) {isverbose = tf;  }
    
    /**
     * @see com.softwoehr.util.verbose#
     * @see com.softwoehr.util.verbosity#
     * @param s  */
    public void    announce    (String s)   {v.announce(s);   }
    
    
    /** Execution semantics
     * @param anEngine
     * @throws BadPrimitiveExecute  */
    public void execute(Engine anEngine)
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute {
        try {
            method.invoke(anEngine, new Object[0]);      /* zero-arity invocation*/
        }                                                          /* End try*/
        catch (Exception e) {
            String s = "Problem executing method from FIJI primitive " + getName();
            System.out.println(s);
            e.printStackTrace(System.err);
            throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute(s, e);
        }                                                        /* End catch*/
    }                                                            /* execute*/
    
    /** Compilation semantics, the default behavior
     * being to append self to the current definition.
     * If the Primitive has special compilation semantics,
     * carry them out instead.
     * @param e
     * @throws BadPrimitiveCompile
     * @throws BadDefinitionCompile
     * @throws BadPrimitiveExecute
     * @throws BadDefinitionExecute  */
    
    public void compile(Engine e)
    throws com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionCompile
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.base.Exceptions.desktop.shell.BadDefinitionExecute {
        if (null == compilationMethod) {
            super.compile(e);
        }
        else                                                           /* If we*/ {
            try {
                compilationMethod.invoke(e, new Object[0]);
            }                                                        /* End try*/
            catch (Exception ex) {
                String s = "Problem executing compilation method from FIJI primitive " + getName();
                System.out.println(s);
                ex.printStackTrace(System.err);
                throw new com.softwoehr.fiji.base.Exceptions.desktop.shell.BadPrimitiveCompile(s, ex);
            }                                                      /* End catch*/
        }                                                           /* End if*/
    }                                                            /* compile*/
    
    /** Decompilation semantics.
     * A primitive just returns itself.
     * @return  */
    public Semantic[] decompile() {
        Semantic result [] = new Semantic[1];
        result[0] = this;
        return result;
    }
}                                                 /* End of Primitive class*/

/*  End of Primitive.java */
