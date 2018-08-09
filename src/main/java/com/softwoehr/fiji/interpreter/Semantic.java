/* Semantic.java ...  */
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

/**
 *
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
public class Semantic {
    private String myName;

    /** Arity/0 ctor. */
    public Semantic() {
        this("Anonymous Semantic");
    }

    /** Arity/1 ctor.
     * @param name  */
    public Semantic(String name) {
        myName = name;
    }

    /**
     * @return  */
    public String toString()
    {return "A Semantic named " + getName();}

    /** Identification.
     * @return  */
    public String getName() {
        return myName;
    }

    /** Set string id.
     * @param s  */
    public void setName(String s) {
        myName = s;
    }

    /** Execution semantics, the default behavior
     * being to push self to stack.
     * @param e
     * throws BadPrimitiveExecute
     * throws BadDefinitionExecute  */
    public void execute(Engine e)
    throws com.softwoehr.fiji.errors.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.errors.Exceptions.desktop.shell.BadDefinitionExecute {
        e.push(this);
    }

    /** Compilation semantics, the default behavior
     * being to append self to the current definition.
     * @param e
     * throws BadPrimitiveCompile
     * throws BadDefinitionCompile
     * throws BadPrimitiveExecute
     * throws BadDefinitionExecute  */

    public void compile(Engine e)
    throws com.softwoehr.fiji.errors.Exceptions.desktop.shell.BadPrimitiveCompile
    , com.softwoehr.fiji.errors.Exceptions.desktop.shell.BadDefinitionCompile
    , com.softwoehr.fiji.errors.Exceptions.desktop.shell.BadPrimitiveExecute
    , com.softwoehr.fiji.errors.Exceptions.desktop.shell.BadDefinitionExecute {
        e.getCurrentDefinition().append(this);
    }

    /** Decompilation semantics. The default is to
     * push a Sematic array with 'this' as only entry.
     * @return  */
    public Semantic[] decompile() {
        Semantic decompilation [] = new Semantic[1];
        decompilation[0] = this;
        return decompilation;
    }
}                                                  /* End of Semantic class*/

/*  End of Semantic.java */
