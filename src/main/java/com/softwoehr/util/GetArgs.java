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

import java.util.ArrayList;
import java.util.List;

/**
 * Parses arguments and options from a string
 * e.g., from a command line. GetArgs views
 * the string as a series of blank-delimited
 * lexemes which it interprets as either plain
 * arguments or option-argument pairs as described
 * below.
 *
 * <p> GetArgs breaks up the passed-in string
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
 * <p>The option introducer is any individual character
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
 * <p>The position in which the command line argument or
 * option-argument pair occurred is recorded in the Argument
 * object also.
 *
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 * see com.softwoehr.Argument
 */
public class GetArgs {
    public List<Argument> options, arguments; // YOLO - direct access ftw!

    /**
     * Arity/1 constructor. The arity/0 exists uselessly.
     * If you must use GetArgs/0 be sure to call reinit/1.
     */
    public GetArgs(String argv[]) {
        /* Reinitialize the object, discarding previous state.
         * Creates two arrays, one of options and their
         * (possibly null) arguments, the other of plain arguments.
         * The members of these lists are accessible via other methods.
         */
        int i;

        options = new ArrayList<>();
        arguments = new ArrayList<>();

        String tempOpt;        /* A potential option while we're processing it.*/
        String theOpt;       /* The option marker_char + opt_letter, e.g., -x .*/
        String tempArg;                    /* A potential argument.            */

        int position = 0;                  /* nthness in line                  */

        for (i = 0; i < argv.length; i++) {
            tempOpt = argv[i].trim();
            if (isOptionIntroducer(tempOpt.charAt(0)))      /* Is this an option?*/ {
                theOpt =     /* Record option, introducer plus second char, if any.*/
                        tempOpt.substring(0, Math.min(2, tempOpt.length()));

                if (tempOpt.length() > 2)    /* Is the optarg in the option itself?*/ {                         /* If so, extract that option argument.*/
                    tempArg = tempOpt.substring(2, tempOpt.length());
                } else             /* No, optarg not included directly in opt string.*/ {                          /* Look for it in next lexical element*/
                    if ((i + 1) < argv.length)     /* Do we have another lex elem left?*/ {
                        tempArg = argv[i + 1].trim();   /* Next lex an option on its own?*/
                        if (isOptionIntroducer(tempArg.charAt(0))) {
                            tempArg = null;     /* Yup, so previous option is null-arged.*/
                        } else /* No, it's not an option, so must be arg to previous opt.*/ {                       /* (We already read it into tempArg.)*/
                            i++;                 /* Bump index past this lexical element.*/
                        }
                    } else                                /* Command line is exhausted.*/ {
                        tempArg = null;                           /* No arg to the opt.*/
                    }
                }  /*  Done looking for argument to option. */

                /* We can now store our option and its argument (if any). */
                options.add(new Argument(theOpt, tempArg, position));
            }  /* Done processing found option. */ else              /* Wasn't an option, must be just a plain argument.*/ {
                tempArg = tempOpt;                      /* Already have it in hand.*/
                tempOpt = null;                                        /* No option*/
                /* Add to list of plain arguments */
                arguments.add(new Argument(null, tempArg, position));
            }
            position++;
        }  /* Done looping through string array of command line. */
    }

    /**
     * Return a string of all the options and arguments,
     * options first, then arguments, but otherwise in order.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        /* Iterate through the option and argument lists */
        for (Argument a : options) {
            sb.append("(" + a.position + ") ");

            if (null != a.option) {
                sb.append(a.option + " ");
            }
            if (null != a.argument) {
                sb.append(a.argument + " ");
            }
        }

        for (Argument a : arguments) {
            sb.append("(" + a.position + ") ");

            if (null != a.option) {
                sb.append(a.option + " ");
            }
            if (null != a.argument) {
                sb.append(a.argument + " ");
            }
        }

        return sb.toString();
    }

    // Is the given char found in the string of option introducers?
    private boolean isOptionIntroducer(char c) {
        int found = "-".indexOf(c);
        return (found != -1);
    }
}