/* Variable.java ...  */
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
public class Variable extends Semantic
{
  private Object datum = null;

  /** Arity/0 ctor, anonymous */
  public Variable () {
    super("Anonymous Variable");
    }

  /** Arity/1 ctor, the most useful one. */
  public Variable (String name) {
    super(name);
  }

  public String toString () {
    return "A Variable named " + getName() + " whose value is " + datum ;
    }

  /* A method for the FIJI operator '@' to use. */
  public void fetch (Engine e) {
    e.push(datum);
    }

  /* A method for the FIJI operator '!' to use. */
  public void store (Engine e) {
    datum = e.pop();
    }
}                                                      /* End of Variable class*/

/*  End of Variable.java */
