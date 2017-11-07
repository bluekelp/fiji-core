/* SoftWoehr.java ... base interface.        */
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

package com.SoftWoehr;

/**
  * An interface implemented by some SoftWoehr classes.
  *
  * @author $Author: jwoehr $
  * @version $Revision: 1.1.1.1 $
  */
public interface SoftWoehr {

  /** Versioning string returned. */
  public String rcsId();

  /** Shutdown children and then ready self for shutdown.
    * Significance of int return is TBD.
    */
  public int shutdown ();

  }                                          /* End of interface SoftWoehr.*/
/*  End of SoftWoehr.java */
