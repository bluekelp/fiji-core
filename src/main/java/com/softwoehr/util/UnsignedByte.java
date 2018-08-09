/* UnsignedByte.java ... unsigned type.      */
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

import com.softwoehr.*;

/**
 * UnsignedByte is for unsigned byte math.
 * @author  $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
class UnsignedByte extends Number implements SoftWoehr
{
  /** Identifies revision level of source. */
  private static final String rcsid = "$Id: UnsignedByte.java,v 1.1.1.1 2001/08/21 02:44:33 jwoehr Exp $";

  /** Implements com.SoftWoehr.SoftWoehr */
  public String rcsId() {return rcsid;}

  /** shutdown() here does nothing.
    * @see com.softwoehr.SoftWoehr
  */
  public int shutdown () { return 0; }

  /** The maximum value an UnsignedByte can have. */
  public static final int MAX_VALUE = 0xff;

  /** The minimum value an UnsignedByte can have. */
  public static final int MIN_VALUE = 0;

  // /** The Class object representing the primitive type int. */
  // Have to examine what Byte returns for this.
  //  public static final class TYPE = ;

  /** The repository of value. */
  private int i;

  /** Construct an UnsignedByte from an integer. */
  public UnsignedByte (int i) {
    this.i = i & 0xff;
    }

/**
 * Construct an UnsignedByte from a string.
 * Uses <code>Integer.parseInt()</code> to conform
 * to the behaviour of the <code>Integer(String)</code>
 * and <code>Byte(String)</code>. The other
 * possibility was <code>Integer.decode(String)</code>.
 */
  public UnsignedByte (String s) {
    this(Integer.parseInt(s));
    }

/** Not implemented */
  private UnsignedByte () {}

/** Return a new String object representing the value in base 10. */
  public String toString () {
    return Integer.toString(i);
    }

/** Return a new String object
  * representing the object's value
  * in radix 10 as an unsigned byte.
  */
  public static String toString(int i) {
    return new UnsignedByte(i).toString();
    }

/** Return a new String object
  * representing the object's value
  * in radix radix.
  */
  public static String toString (int i, int radix) {
    return Integer.toString(new UnsignedByte(i).intValue(), radix);
    }

  protected void finalize () throws Throwable
    {           /* Called by garbage collector in case no longer referenced*/
      super.finalize();
    }

/** Returns the value of the specified number as a byte. */
  public byte byteValue() {
    return (byte) i;
  }

/** Returns the value of the specified number as a double. */
  public double doubleValue() {
    return i;
   }

/** Return the value of the specified number as a float. */
  public float floatValue() {
    return i;
  }

/** Returns the value of the specified number as an int. */
  public int intValue() {
     return i;
   }

/** Returns the value of the specified number as a long. */
  public long longValue() {
     return i;
     }

/** Returns the value of the specified number as a short. */
  public short shortValue() {
     return (short) i;
   }

/**
 * Decodes a String into an UnsignedByte. The String may
 * represent decimal, hexadecimal, and octal numbers.
 */
  public static UnsignedByte decode (String s) {
    return new UnsignedByte(Integer.decode(s).intValue());
    }

  /**
   * Assuming the specified String represents an UnsignedByte,,
   * returns a new UnsignedByte object initialized to that value.
   * Throws an exception if the String cannot be parsed as an
   * UnsignedByte.
   */
  public static UnsignedByte valueOf(String s,
                            int radix) // throws NumberFormatException
    {
    return new UnsignedByte(Integer.valueOf(s).intValue());
    }

/** Demo and test UnsignedByte */
  public static void main (String argv[]) {
    if (argv.length < 1)
      {
      System.out.println("Args should be: uByte [display-radix]");
      }
    else
      {
      UnsignedByte ub = new UnsignedByte(argv[0]);
      System.out.println("In decimal, that unsigned byte is " + ub.toString());
      System.out.println("In hex, that unsigned byte is "
                        + UnsignedByte.toString(ub.intValue(), 16));
      if (argv.length > 1)
        {
        int r = Integer.decode(argv[1]).intValue();
        System.out.println("In the radix " + r
                           + " which you suggested, that unsigned byte is "
                           + UnsignedByte.toString(ub.intValue(), r));
        }                                                         /* End if*/
      }                                                           /* End if*/
    }
}                                              /* End of UnsignedByte class*/

/*  End of UnsignedByte.java */

