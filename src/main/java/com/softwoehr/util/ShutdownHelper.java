/* ShutdownHelper.java ...  */
/*********************************************/
/* Copyright *C* 1998, All Rights Reserved.  */
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

package com.softwoehr.util;

import java.util.*;

import  com.softwoehr.*;

/** Helps implement com.SoftWoehr.SoftWoehr.shutdown();
   *
   * @author $Author: jwoehr $
   * @version $Revision: 1.1.1.1 $
   */
public class ShutdownHelper implements SoftWoehr, verbose
{
  /*****************************************/
  /*% SoftWoehr default variables section. */
  /*****************************************/

  /** Revision level */
  private static final String rcsid = "$Id: ShutdownHelper.java,v 1.1.1.1 2001/08/21 02:44:31 jwoehr Exp $";
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

  /** Clients to shutdown when told shutdown(). */
  private Vector clients;

  /*********************************/
  /*% User variables section ends. */
  /*********************************/

  /*********************************/
  /*% User methods section starts. */
  /*********************************/

  /** Arity/0 ctor. */
  public ShutdownHelper () {}

  public String toString ()
    {return super.toString();}

  protected void finalize () throws Throwable
    {           /* Called by garbage collector in case no longer referenced*/
      super.finalize();
    }

  /** The ShutdownHelper notifies subcomponents of shutdown then shuts itself down.
    * @see com.softwoehr.SoftWoehr
    */
  public int shutdown (){
    return shutdownClients();
    }

  /** Reinitialize the ShutdownHelper, discarding previous state. */
  public void reinit() {
    clients = new Vector();
    }

  /** Add client for later shutdown calls. */
  public void addShutdownClient(SoftWoehr s) {
    clients.addElement(s);
    }

  /** Remove client for later shutdown calls. */
  public void removeShutdownClient(SoftWoehr s) {
    clients.removeElement(s);
    }

 /** Shutdown clients. */
 public int shutdownClients() {
   int result = 0;
   for (Enumeration e = clients.elements(); e.hasMoreElements();) {
     result = ((SoftWoehr)(e.nextElement())).shutdown();
     if (result != 0)
       {
       break;
       }
     }
   return result;
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

  /** Demonstrate <code>ShutdownHelper</code>. */
  public static void main (String argv[]) {

    GetArgs myArgs = new GetArgs(argv);/* Assimilate the command line.     */
    ShutdownHelper theShutdownHelper = new ShutdownHelper();         /* Instance of ShutdownHelper we're demoing.  */

    /* GPL'ed SoftWoehr announces itself. */
    System.out.println("ShutdownHelper, Copyright (C) 1988 Jack J. Woehr.");
    System.out.println("ShutdownHelper comes with ABSOLUTELY NO WARRANTY;");
    System.out.println("Please see the file COPYING and/or COPYING.LIB");
    System.out.println("which you should have received with this software.");
    System.out.println("This is free software, and you are welcome to redistribute it");
    System.out.println("under certain conditions enumerated in COPYING and/or COPYING.LIB.");

    /* See if user passed in the -v flag to request verbosity. */
    for (int i = 0; i < myArgs.optionCount() ; i++)
      {
      if (myArgs.nthOption(i).getOption().substring(1,2).equals("v"))
        {
        theShutdownHelper.setVerbose(true);
        }                                                         /* End if*/
      }

    // Your code goes here.
    // -------------------

    // -------------------

    return;
    }
}                                                      /* End of ShutdownHelper class*/

/*  End of ShutdownHelper.java */
