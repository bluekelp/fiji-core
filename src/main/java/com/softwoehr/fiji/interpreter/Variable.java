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

import  com.softwoehr.*;
import  com.softwoehr.util.*;

 /**
   *
   * @author $Author: jwoehr $
   * @version $Revision: 1.1.1.1 $
   */
public class Variable extends Semantic implements SoftWoehr, verbose
{
  /*****************************************/
  /*% SoftWoehr default variables section. */
  /*****************************************/

  /** Revision level */
  private static final String rcsid = "$Id: Variable.java,v 1.1.1.1 2001/08/21 02:39:28 jwoehr Exp $";
  /** Implements com.SoftWoehr.SoftWoehr */
  public String rcsId() {return rcsid;}

  /**  Flags whether we are in verbose mode. */
  private boolean isverbose = true;
  /**  Helper for verbose mode. */
  private verbosity v = new verbosity(this);

  /**********************************************/
  /*% SoftWoehr default variables section ends. */
  /**********************************************/

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

  /*******************************/
  /*% User methods section ends. */
  /*******************************/

  /**********************************************/
  /*% SoftWoehr default methods section starts. */
  /**********************************************/

   /**
    * @see com.softwoehr.util.verbose
    * @see com.softwoehr.util.verbosity
    */
   public boolean isVerbose()              {return isverbose;}

   /**
    * @see com.softwoehr.util.verbose
    * @see com.softwoehr.util.verbosity
    */
   public void    setVerbose  (boolean tf) {isverbose = tf;  }

   /**
    * @see com.softwoehr.util.verbose
    * @see com.softwoehr.util.verbosity
    */
   public void    announce    (String s)   {v.announce(s);   }

  /********************************************/
  /*% SoftWoehr default methods section ends. */
  /********************************************/

  /*********/
  /*% Main */
  /*********/

  /** Demonstrate <code>Variable</code>. */
  public static void main (String argv[]) {

    GetArgs myArgs = new GetArgs(argv);/* Assimilate the command line.     */
    Variable theVariable = new Variable();         /* Instance of Variable we're demoing.  */

    /* GPL'ed SoftWoehr announces itself. */
    System.out.println("Variable, Copyright (C) 1999, 2000 by Jack J. Woehr.");
    System.out.println("Variable comes with ABSOLUTELY NO WARRANTY;");
    System.out.println("Please see the file COPYING and/or COPYING.LIB");
    System.out.println("which you should have received with this software.");
    System.out.println("This is free software, and you are welcome to redistribute it");
    System.out.println("under certain conditions enumerated in COPYING and/or COPYING.LIB.");

    /* See if user passed in the -v flag to request verbosity. */
    for (int i = 0; i < myArgs.optionCount() ; i++)
      {
      if (myArgs.nthOption(i).getOption().substring(1,2).equals("v"))
        {
        theVariable.setVerbose(true);
        }                                                         /* End if*/
      }

    // Your code goes here.
    // -------------------

    // -------------------

    return;
    }
}                                                      /* End of Variable class*/

/*  End of Variable.java */
