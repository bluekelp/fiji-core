/* verbose.java ... a verbosity interface    */
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
  * An interface so implementors can be tested for verbose mode.
  * Implementors then can use <code>com.SoftWoehr.util.verbosity</code>
  * to handle verbose output.
  * @author $Author: jwoehr $
  * @version $Revision: 1.1.1.1 $
  * @see com.softwoehr.util.verbosity
  */
public interface verbose {

  /** Returns true if instance is in verbose mode. */
  boolean isVerbose();

  /** Sets <code>true</code> or resets <code>false</code> verbose mode. */
  void setVerbose(boolean b);

  /** Say something if the object is in verbose mode, be silent otherwise. */
  void announce (String message);
  }

/*  End of verbose.java */
