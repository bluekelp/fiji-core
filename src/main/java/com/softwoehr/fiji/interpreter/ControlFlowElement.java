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
public class ControlFlowElement {
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
}                                        /* End of ControlFlowElement class*/

/*  End of ControlFlowElement.java */
