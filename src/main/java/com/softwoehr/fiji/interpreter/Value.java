/* Value.java ...  */
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

/** Value is a self-fetching Variable.
   *
   * @author $Author: jwoehr $
   * @version $Revision: 1.1.1.1 $
   */
public class Value extends Semantic
{
  /***********************************/
  /*% User variables section starts. */
  /***********************************/
  private Object datum = null;

  /*********************************/
  /*% User variables section ends. */
  /*********************************/

  /*********************************/
  /*% User methods section starts. */
  /*********************************/

  /** Arity/0 ctor, anonymous */
  public Value () {
    super("Anonymous Value");
    }

  /** Arity/1 ctor, the most useful one. */
  public Value (String name) {
    super(name);
  }

  /** Return a String representation of the object. */
  public String toString () {
    return "A Value named " + getName() + " whose value is " + datum;
    }

  /** Execution semantics are to push own datum. */
  public void execute (Engine e) {
    e.push(datum);
    }

  /** Get the datum. */
  public Object getDatum() {
    return datum;
    }

  /** Set the datum. */
  public void setDatum(Object o) {
    datum = o;
    }
}                                                      /* End of Value class*/

/*  End of Value.java */
