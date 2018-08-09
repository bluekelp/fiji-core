/* Argument.java ... an option parsed.       */
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

/** Holds an argument parsed from a command line.
  * If it's a plain argument, records the argument
  * string and position. If it is a dash-option,
  * records the option string (-a -b etc.) and
  * the argument to the option, if any. In any
  * case, records the position in the command
  * line that the arg or opt-arg pair came in.
  * @author $Author: jwoehr $
  * @version $Revision: 1.1.1.1 $
  * @see GetArgs
  */
public class Argument
{
  /** The "option", that is, dash-letter, e.g., -a -b etc. */
  public String option;

  /** The argument to the option, e.g., "-o full" where
    * "full" is the argument to the option "-o".
    */
  public String argument;

  /** The position among the options-and-arguments in which
    * this option-and-argument appears.
    */
  public int position;

  /** Create an Argument from an option, argument and position. */
  public Argument (String option, String argument, int position) {
    this.option   = option;
    this.argument = argument;
    this.position = position;
    }

  /** Return the option and argument as a String. */
  public String toString ()
    {return option + " " + argument;}

  /** Return the option portion (if any) of the Argument. */
  public String getOption() {return option;}

  /** Return the argument portion (if any) of the Argument. */
  public String getArgument() {return argument;}
}
