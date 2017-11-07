/* Definition.java ... compiled definitions  */
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

import  java.util.*;

import  com.SoftWoehr.*;
import  com.SoftWoehr.util.*;

/** A class representing a list of Semantics to be executed.
 *
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
public class Definition extends Semantic implements SoftWoehr, verbose {
    /** Revision level */
    private static final String rcsid = "$Id: Definition.java,v 1.1.1.1 2001/08/21 02:39:06 jwoehr Exp $";
    /** Implements com.SoftWoehr.SoftWoehr
     * @return  */
    public String rcsId() {return rcsid;}
    
    /**  Flags whether we are in verbose mode. */
    public boolean isverbose = false;
    /**  Helper for verbose mode. */
    private verbosity v = new verbosity(this);
    
    /** This is the compiled definition */
    private Semantic body[];
    
    /** This is the definition under compilation */
    private Vector composition;
    
    /** If true, the word's execution semantics are performed
     * at compile time.
     */
    private boolean immediate;
    
    /** Arity/0 ctor, an anonymous definition. */
    public Definition() {
        this("Anonymous Definition.");
    }
    
    /** Arity/1 ctor, a named Definition.
     * @param s  */
    public Definition(String s) {
        super(s);
        immediate=false;
    }
    
    /** Return a string representing the definition.
     * @return A string representation.
     */
    public String toString() {
        String result = "A Definition named " + getName();
        return result;
    }
    
    /** shutdown() here does nothing.
     * @see com.SoftWoehr.SoftWoehr
     */
    public int shutdown() { return 0; }
    
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
    
    /** Set the word immediate, i.e.,  if true, its execution
     * semantics will be performed at compile time.
     * @param tf  */
    public void setImmediate(boolean tf) {
        immediate = tf;
    }
    
    /** See if the word is immediate.
     * @return  */
    public boolean getImmediate() {
        return immediate;
    }
    
    /** Start a definition. */
    public void commence() {
        body = null;
        composition = new Vector();
    }
    
    /** Finish a definition. */
    public void complete() {
        body = new Semantic[composition.size()];
        Enumeration e = composition.elements();
        for (int i = 0; e.hasMoreElements(); i++) {
            body[i] = (Semantic) e.nextElement();
        }
        composition = null;
    }
    
    /** Append to a definition
     * @param s  */
    public void append(Semantic s) {
        composition.addElement(s);
    }
    
    /** Execution semantics
     * @param e
     * @throws BadDefinitionExecute
     * @throws BadPrimitiveExecute  */
    public void execute(engine e)
    throws com.SoftWoehr.FIJI.base.Exceptions.desktop.shell.BadDefinitionExecute
    , com.SoftWoehr.FIJI.base.Exceptions.desktop.shell.BadPrimitiveExecute {
        try {
            e.innerInterpreter.interpret(this);
        }                                                          /* End try*/
        catch (com.SoftWoehr.FIJI.base.Exceptions.desktop.shell.BadPrimitiveExecute  ex) {
            String s = "Problem in Definition.execute() for " + getName();
            com.SoftWoehr.FIJI.base.Exceptions.desktop.shell.BadDefinitionExecute x =
            new com.SoftWoehr.FIJI.base.Exceptions.desktop.shell.BadDefinitionExecute
            (s, ex);
            ex.printStackTrace(System.err);
            throw x;
        }                                                        /* End catch*/
    }
    
    /** Compilation semantics.
     * @param e
     * @throws BadDefinitionCompile
     * @throws BadDefinitionExecute
     * @throws BadPrimitiveExecute  */
    public void compile(engine e)
    throws com.SoftWoehr.FIJI.base.Exceptions.desktop.shell.BadDefinitionCompile
    , com.SoftWoehr.FIJI.base.Exceptions.desktop.shell.BadDefinitionExecute
    , com.SoftWoehr.FIJI.base.Exceptions.desktop.shell.BadPrimitiveExecute {
        if (immediate) {
            execute(e);
        }
        else {
            try {
                super.compile(e);
            }                                                        /* End try*/
            catch (com.SoftWoehr.FIJI.base.Exceptions.desktop.shell.BadPrimitiveCompile ex) {
                String s = "Problem in Definition.compile() for " + getName();
                com.SoftWoehr.FIJI.base.Exceptions.desktop.shell.BadDefinitionCompile x =
                new com.SoftWoehr.FIJI.base.Exceptions.desktop.shell.BadDefinitionCompile
                (s, ex);
                ex.printStackTrace(System.err);
                throw x;
            }                                                      /* End catch*/
        }                                                           /* End if*/
    }
    
    /** Decompilation semantics
     * @return  */
    public Semantic[] decompile() {
        Semantic result [] = new Semantic[body.length];
        for (int i = 0; i < body.length; i++) {
            result[i] = body[i];
        }                                                          /* End for*/
        return result;
    }
    
    /** Return index of last Semantic in list.
     * @return  */
    public int lastIndex() {
        return body.length - 1;
    }
    
    /** Return length of Semantic list.
     * @return  */
    public int length() {
        return body.length;
    }
    
    /** Returns nth Semantic in the list of Semantics which make up the
     * body of a Definition.
     * @param index
     * @return  */
    public Semantic nthSemantic(int index) {
        return body[index];
    }
    
    /** Returns the current length of the definition under composition.
     * Used to calculate branches.
     * @return  */
    public int compositionLength() {
        return composition.size();
    }
    
    /** Demonstrate <code>Definition<code>.
     * Currently, does nothing.
     * @param argv  */
    public static void main(String argv[]) {
    }
}                                                /* End of Definition class*/

/*  End of Definition.java */
