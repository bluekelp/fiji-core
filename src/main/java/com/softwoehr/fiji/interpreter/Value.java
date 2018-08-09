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

import  com.softwoehr.SoftWoehr;
import  com.softwoehr.util.*;

 /** Value is a self-fetching Variable.
   *
   * @author $Author: jwoehr $
   * @version $Revision: 1.1.1.1 $
   */
public class Value extends Semantic implements SoftWoehr, verbose
{
  /*****************************************/
  /*% SoftWoehr default variables section. */
  /*****************************************/

  /** Revision level */
  private static final String rcsid = "$Id: Value.java,v 1.1.1.1 2001/08/21 02:39:25 jwoehr Exp $";
  /** Implements com.SoftWoehr.SoftWoehr */
  public String rcsId() {return rcsid;}

  /**  Flags whether we are in verbose mode. */
  private boolean isverbose = true;
  /**  Helper for verbose mode. */
  private verbosity v = new verbosity(this);

  /** Does the work of notifying shutdown clients. */
  private ShutdownHelper shutdownHelper = new ShutdownHelper();

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

  protected void finalize () throws Throwable
    {           /* Called by garbage collector in case no longer referenced*/
      super.finalize();
    }

  /** The Value notifies subcomponents of shutdown then shuts itself down.
    * @see com.softwoehr.SoftWoehr
    */
  public int shutdown() {
    shutdownHelper.shutdownClients();
    // Your shutdown code for this object goes here.
    // ...

    // ...
    // Your shutdown code for this object went there.
    return 0;
    }

  /** Reinitialize the Value, discarding previous state. */
  //public void reinit() {
  //  }

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

  /** Demonstrate <code>Value</code>. */
  public static void main (String argv[]) {

    GetArgs myArgs = new GetArgs(argv);/* Assimilate the command line.     */
    Value theValue = new Value();      /* Instance of Value we're demoing. */

    /* GPL'ed SoftWoehr announces itself. */
    System.out.println("Value, Copyright (C) 1999 Jack J. Woehr.");
    System.out.println("Value comes with ABSOLUTELY NO WARRANTY;");
    System.out.println("Please see the file COPYING and/or COPYING.LIB");
    System.out.println("which you should have received with this software.");
    System.out.println("This is free software, and you are welcome to redistribute it");
    System.out.println("under certain conditions enumerated in COPYING and/or COPYING.LIB.");

    /* See if user passed in the -v flag to request verbosity. */
    for (int i = 0; i < myArgs.optionCount() ; i++)
      {
      if (myArgs.nthOption(i).getOption().substring(1,2).equals("v"))
        {
        theValue.setVerbose(true);
        }                                                         /* End if*/
      }

    // Your code goes here.
    // -------------------

    // -------------------

    return;
    }
}                                                      /* End of Value class*/

/*  End of Value.java */
