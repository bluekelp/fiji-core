/* verbosity.java ... support opt. verbose.  */
/* jack j. woehr jax@well.com jwoehr@ibm.net */
/* http://www.well.com/user/jax/rcfb         */
/* P.O. Box 51, Golden, Colorado 80402-0051  */
/*********************************************/
/* Copyright *C* 1998, All Rights Reserved.  */
/*                                           */
/*       This Program is Free                */
/*            Softwoehr                      */
/*                                           */
/* Permission to distribute this Softwoehr   */
/* with copyright notice attached is granted.*/
/*                                           */
/* Permission to modify for personal use at  */
/* at home or for your personal use on the   */
/* job is granted, but you may not publicly  */
/* make available modified versions of this  */
/* program without asking and getting the    */
/* permission of the author, Jack Woehr.     */
/*                                           */
/* The permission will usually be granted if */
/* granted reciprocally by you for the mods. */
/*                                           */
/* THERE IS NO GUARANTEE, NO WARRANTY AT ALL */
/*********************************************/
package com.softwoehr.util;

/**
  * Class verbosity provides routines for
  * programming of applications which
  * implement <code>com.SoftWoehr.util.verbose</code>.
  * @author $Author: jwoehr $
  * @version $Revision: 1.1.1.1 $
  * @see com.softwoehr.util.verbose
  */
public class verbosity
  {
  /**
    * The verbose is a class which implements the interface
    * and on whose behalf <code>verbosity.announce()</code>
    * is performed.
    */
  verbose v;

  /** Open on the <code>verbose</code> instance. */
  public verbosity (verbose v) {
    this.v = v;
  }

  /** Unimplemented arity/0 ctor. */
  private verbosity () {}

  /** Default implementation. */
  public String toString ()
    {return super.toString();}

  /** Say something on behalf of the <code>verbosity</code> implementation
    * if it's being verbose at that instant. The point of
    * <code>verbose</code>/<code>verbosity</code>.
    */
  public void announce(String s) {
    if (v.isVerbose())
      {
      System.err.println(s);
      System.err.flush();
      }                                                           /* End if*/
   }
  }                                               /* End of verbosity class*/
