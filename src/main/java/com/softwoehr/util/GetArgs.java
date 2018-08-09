/* GetArgs.java -- argv parser               */
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

import java.util.Vector;

/** Parses arguments and options from a string
  * e.g., from a command line. GetArgs views
  * the string as a series of blank-delimited
  * lexemes which it interprets as either plain
  * arguments or option-argument pairs as described
  * below.
  *
  *<p> GetArgs breaks up the passed-in string
  * into two lists, one of the plain arguments,
  * and one of the option-argument pairs.
  * GetArgs creates com.SoftWoehr.Argument objects
  * of each of these entities.
  *
  * <p>Each option is identified by a single character
  * preceded by an option introducer. Remaining characters
  * in such a lexeme are regarded as the argument to
  * the option, e.g.,
  * <pre>
  *              -Djava.foo=bar
  * </pre>
  * where -D is the option and java.foo=bar is the argument.
  *
  *<p>The option introducer is any individual character
  * in the string returned by <code>getOptionIntroducers()</code>,
  * by default the sole character '-' "dash". This string of
  * option introducers may be changed by
  * <code>setOptionIntroducers()</code>.
  *
  * <p><b>NOTE</b> that all options are presumed to have option
  * arguments, so if the lexeme recognized as an option consists
  * only of the option introducer or an option introducer and
  * one (1) following option character, the next lexeme
  * in the command line following the option is regarded as
  * the option argument <b>UNLESS</b> that next lexeme is itself
  * an option, i.e., a string headed by a member of the current
  * set of option introducers.
  *
  *<p>The position in which the command line argument or
  * option-argument pair occurred is recorded in the Argument
  * object also.
  *
  * @author $Author: jwoehr $
  * @version $Revision: 1.1.1.1 $
  * see com.softwoehr.Argument
  */
public class GetArgs implements verbose
{
  /*****************************************/
  /*% SoftWoehr default variables section. */
  /*****************************************/

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

  /** Holds the Argument objects, as many as parsed. */
  private Vector optList, argList;

  /** Option introducers. */
  private String optionIntroducers = "-";

  /*********************************/
  /*% User variables section ends. */
  /*********************************/

  /*********************************/
  /*% User methods section starts. */
  /*********************************/

  /** Arity/1 constructor. The arity/0 exists uselessly.
    * If you must use GetArgs/0 be sure to call reinit/1.
    */
  public GetArgs (String argv[]) { reinit(argv); }

  /** Reinitialize the object, discarding previous state.
    * Creates two arrays, one of options and their
    * (possibly null) arguments, the other of plain arguments.
    * The members of these lists are accessible via other methods.
    */
  public void reinit (String argv[]) {
    int i;

    optList = new Vector();
    argList = new Vector();

    String tempOpt;        /* A potential option while we're processing it.*/
    String theOpt;       /* The option marker_char + opt_letter, e.g., -x .*/
    String tempArg;                    /* A potential argument.            */

    int position = 0;                  /* nthness in line                  */

    for (i = 0; i < argv.length; i++)
      {
      tempOpt = argv[i].trim();
      if (isOptionIntroducer(tempOpt.charAt(0)))      /* Is this an option?*/
        {
        theOpt =     /* Record option, introducer plus second char, if any.*/
         tempOpt.substring(0,Math.min(2, tempOpt.length()));

        if (tempOpt.length() > 2)    /* Is the optarg in the option itself?*/
          {                         /* If so, extract that option argument.*/
          tempArg = tempOpt.substring(2, tempOpt.length());
          }
        else             /* No, optarg not included directly in opt string.*/
          {                          /* Look for it in next lexical element*/
          if ((i+1) < argv.length)     /* Do we have another lex elem left?*/
            {
            tempArg = argv[i+1].trim();   /* Next lex an option on its own?*/
            if (isOptionIntroducer(tempArg.charAt(0)))
              {
              tempArg = null;     /* Yup, so previous option is null-arged.*/
              }
            else /* No, it's not an option, so must be arg to previous opt.*/
              {                       /* (We already read it into tempArg.)*/
              i++;                 /* Bump index past this lexical element.*/
              }                                                   /* End if*/
            }
          else                                /* Command line is exhausted.*/
            {
            tempArg = null;                           /* No arg to the opt.*/
            }                                                     /* End if*/
          }  /*  Done looking for argument to option. */          /* End if*/

        /* We can now store our option and its argument (if any). */
        optList.addElement(new Argument(theOpt, tempArg, position));
        }  /* Done processing found option. */                    /* End if*/

      else              /* Wasn't an option, must be just a plain argument.*/
        {
        tempArg = tempOpt;                      /* Already have it in hand.*/
        tempOpt = null;                                        /* No option*/
        /* Add to list of plain arguments */
        argList.addElement(new Argument(tempOpt, tempArg, position));
        }                                                         /* End if*/
      position++;
      }  /* Done looping through string array of command line. *//* End for*/
    }                                                 /* End of constructor*/

  /** Return a string of all the options and arguments,
    * options first, then arguments, but otherwise in order.
    */
  public String toString ()
    {
    Argument a;
    String result = "";

    /* Iterate through the option and argument lists */
    for (int i = 0; i < optList.size() ; i++)
      {
      a = nthOption(i);
      result += "(" + a.position + ") ";

      if (null != a.option) {
        result += a.option + " ";
        }                                                         /* End if*/
      if (null != a.argument) {
        result += a.argument + " ";
        }
      }                                                          /* End for*/

    for (int i = 0; i < argList.size() ; i++)
      {
      a = nthArgument(i);
      result += "(" + a.position + ") ";

      if (null != a.option) {
        result += a.option + " ";
        }                                                         /* End if*/
      if (null != a.argument) {
        result += a.argument + " ";
        }
      }                                                          /* End for*/

    return result;
    }

  /** Return string of option introducers.
    */
  public String getOptionIntroducers() { return optionIntroducers; }

  /** Set string of single-character option introducers.
    * Any individual char in the list will be considered an intro
    * to an option on the command line.
    */
  public void setOptionIntroducers(String s ) { optionIntroducers = s; }

  /** Is the given char found in the string of option introducers? */
  public boolean isOptionIntroducer (char c) {
    int found = optionIntroducers.indexOf(c);
    return (found != -1);
    }

  /** Return the nth option as an Argument object.
    * Returns null if no such nth option.
  */
  public Argument nthOption(int n) {
    Argument a = null;
    if (n < optList.size())
      {
      a = (Argument) (optList.elementAt(n));
      }
    return a;
    }

  /** Returns nth argument as Argument object.
    * Returns null of no such nth argument.
    */
  public Argument nthArgument(int n) {
    Argument a = null;
    if (n < argList.size())
      {
      a = (Argument) (argList.elementAt(n));
      }
    return a;
    }

  /** Number of options parsed. */
  public int optionCount () {
    return optList.size();
    }

  /** Number of plain arguments parsed. */
  public int argumentCount () {
    return argList.size();
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
}

/* End of GetArgs.java */




