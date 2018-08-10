package com.bluekelp.fiji.cli;

/** Holds an argument parsed from a command line.
  * If it's a plain argument, records the argument
  * string and position. If it is a dash-option,
  * records the option string (-a -b etc.) and
  * the argument to the option, if any. In any
  * case, records the position in the command
  * line that the arg or opt-arg pair came in.
  */
public class Argument
{
  /** The "option", that is, dash-letter, e.g., -a -b etc. */
  String option;

  /** The argument to the option, e.g., "-o full" where
    * "full" is the argument to the option "-o".
    */
  String argument;

  /** The position among the options-and-arguments in which
    * this option-and-argument appears.
    */
  int position;

  /** Create an Argument from an option, argument and position. */
  Argument(String option, String argument, int position) {
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
