/* ControlFlowElement.java ...               */
/* FIJI representation of control flow.      */
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

import  com.softwoehr.SoftWoehr;
import  com.softwoehr.util.*;

/** ControlFlowElement wrappers a Semantic pushed on the control flow
 * stack along with information about the context when the entry
 * was pushed. Definitions may nest and the current definition is
 * pushed to support this, but the real nice thing aside from the
 * marginally useful ability to nest definitions is that it's easy
 * for the compiler to know a definition was messed up when it
 * doesn't find a Definition control flow element on popping the
 * control flow stack.
 *
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
public class ControlFlowElement implements SoftWoehr, verbose {
    
    /** Revision level */
    private static final String rcsid = "$Id: ControlFlowElement.java,v 1.1.1.1 2001/08/21 02:39:02 jwoehr Exp $";
    /** Implements com.SoftWoehr.SoftWoehr
     * @return  */
    public String rcsId() {return rcsid;}
    
    /**  Flags whether we are in verbose mode. */
    private boolean isverbose = true;
    /**  Helper for verbose mode. */
    private verbosity v = new verbosity(this);
    
    /** Does the work of notifying shutdown clients. */
    private ShutdownHelper shutdownHelper = new ShutdownHelper();
    
    /** The Semantic this entry represents. */
    public Semantic element;
    
    /** Interpret/compile state at time this entry was created. */
    public boolean state;
    
    /** The Class this ControlFlowElement represents, since
     * sometimes this.element is null, e.g., in the case
     * of a pushed null currentDefinition.
     */
    public Class semanticClass;
    
    /** Creates a ControlFlowElement for a
     * specific Semantic  with a null element.
     * @param s
     * @param e  */
    public ControlFlowElement(Semantic s, Engine e) {
        reinit(s,e);
    }
    
    /** Creates a ControlFlowElement representing specific
     * type of Semantic with a non-null element.
     * @param s
     * @param e
     * @param c  */
    public ControlFlowElement(Semantic s, Engine e, Class c) {
        reinit(s,e,c);
    }
    
    /** Return a string representation of the object.
     * @return  */
    public String toString()
    {return super.toString();}
    
    /** Finalize the object.
     *
     *@exception Throwable If something throws during finalization.
     */
    protected void finalize() throws Throwable {           /* Called by garbage collector in case no longer referenced*/
        super.finalize();
    }
    
    /** The ControlFlowElement notifies subcomponents of shutdown then shuts itself down.
     * @see com.softwoehr.SoftWoehr#
     * @return  */
    public int shutdown() {
        shutdownHelper.shutdownClients();
        // Your shutdown code for this object goes here.
        // ...
        
        // ...
        // Your shutdown code for this object went there.
        return 0;
    }
    
    /** Reinitialize the ControlFlowElement, discarding previous state.
     * @param s
     * @param e  */
    public void reinit(Semantic s, Engine e) {
        reinit(s, e, s.getClass());
    }
    
    /** Reinitialize the ControlFlowElement, discarding previous state.
     * @param s
     * @param e
     * @param c  */
    public void reinit(Semantic s, Engine e, Class c) {
        element = s;
        state = e.state;
        semanticClass = c;
    }
    
    /** Return the class of the Semantic element this entry represents.
     * @return  */
    public Class elementClass() {
        return semanticClass;
    }
    
    /** Return the Semantic element this entry represents.
     * @return  */
    public Semantic getElement() {
        return element;
    }
    
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
    
    /** Demonstrate <code>ControlFlowElement</code>.
     * @param argv  */
    public static void main(String argv[]) {
        
        GetArgs myArgs = new GetArgs(argv);/* Assimilate the command line.     */
        // ControlFlowElement theControlFlowElement = new ControlFlowElement();         /* Instance of ControlFlowElement we're demoing.  */
        
    /* GPL'ed SoftWoehr announces itself. */
        System.out.println("ControlFlowElement, Copyright (C) 1999 Jack J. Woehr.");
        System.out.println("ControlFlowElement comes with ABSOLUTELY NO WARRANTY;");
        System.out.println("Please see the file COPYING and/or COPYING.LIB");
        System.out.println("which you should have received with this software.");
        System.out.println("This is free software, and you are welcome to redistribute it");
        System.out.println("under certain conditions enumerated in COPYING and/or COPYING.LIB.");
        
    /* See if user passed in the -v flag to request verbosity. */
        for (int i = 0; i < myArgs.optionCount() ; i++) {
            if (myArgs.nthOption(i).getOption().substring(1,2).equals("v")) {
                // theControlFlowElement.setVerbose(true);
            }                                                         /* End if*/
        }
        
        // Your code goes here.
        // -------------------
        
        // -------------------
        
        return;
    }
}                                        /* End of ControlFlowElement class*/

/*  End of ControlFlowElement.java */
