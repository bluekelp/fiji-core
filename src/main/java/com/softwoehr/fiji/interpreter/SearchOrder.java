/* SearchOrder.java ...  */
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

import java.util.*;
import  com.softwoehr.SoftWoehr;
import  com.softwoehr.util.*;

/** This class provides the SearchOrder entity used by
 * FIJI to collate Wordlists.
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
public class SearchOrder implements SoftWoehr, verbose {
    
    /** Revision level */
    private static final String rcsid = "$Id: SearchOrder.java,v 1.1.1.1 2001/08/21 02:39:23 jwoehr Exp $";
    /** Implements com.SoftWoehr.SoftWoehr
     * @return  */
    public String rcsId() {return rcsid;}
    
    /**  Flags whether we are in verbose mode. */
    private boolean isverbose = true;
    /**  Helper for verbose mode. */
    private verbosity v = new verbosity(this);
    
    /** Does the work of notifying shutdown clients. */
    private ShutdownHelper shutdownHelper = new ShutdownHelper();
    
    /** Vector which holds the search order */
    private Vector<Wordlist> my_vector = new Vector<>();
    
    
    /** Arity/0 ctor. */
    public SearchOrder() {
        reinit();
    }
    
    /** Finalize the object.
     *
     *@exception Throwable
     */
    protected void finalize() throws Throwable {           /* Called by garbage collector in case no longer referenced*/
        super.finalize();
    }
    
    /** The SearchOrder notifies subcomponents of shutdown then shuts itself down.
     * @see com.softwoehr.SoftWoehr#
     * @return  */
    public int shutdown() {
        shutdownHelper.shutdownClients();
        // Your shutdown code for this object goes here.
        // ...
        
        // ...
        // Your shutdown code for this object went there.
        return 0;
    }
    
    /** Reinitialize the SearchOrder, discarding previous state. */
    public void reinit() {
        my_vector.setSize(0);
    }
    
    /** Find a Semantic (or null) somewhere in the search order.
     * @param name
     * @return  */
    public Semantic find(String name) {
        Semantic result = null;
        Wordlist w = null;
        for (Enumeration e = my_vector.elements(); e.hasMoreElements();) {
            w = (Wordlist) (e.nextElement());
            result = w.find(name);
            if (null != result) {
                break;
            }
        }                                                          /* End for*/
        return result;
    }                                  /* public Semantic find(String name)*/
    
    /* Pop the active Semantic of a wordlist entry by finding
     * the first occurrence of same in the search order. Remove
     * the entry if no previous Semantic for the name exists.
     *
     * @see com.SoftWoehr.desktop.shell.Wordlist.forget#
     * @param name
     * @return  */
    public boolean forget(String name) {
        boolean rc = false;
        Semantic result = null;
        Wordlist w = null;
        for (Enumeration e = my_vector.elements(); e.hasMoreElements();) {
            w = (Wordlist) (e.nextElement());
            result = w.find(name);
            if (null != result) {
                w.forget(name);    /* Pop the previous Semantic or discard if none.*/
                rc = true;                           /* Signal that name was found.*/
                break;                                                     /* Done.*/
            }
        }                                                          /* End for*/
        return rc;
    }                                  /* public void boolean (String name)*/
    
    /* Discard utterly a wordlist entry by finding
     * the first occurrence of same in the search order.
     *
     * @see com.SoftWoehr.desktop.shell.Wordlist.discard#
     * @param name
     * @return  */
    public boolean discard(String name) {
        boolean rc = false;
        Semantic result = null;
        Wordlist w = null;
        for (Enumeration e = my_vector.elements(); e.hasMoreElements();) {
            w = (Wordlist) (e.nextElement());
            result = w.find(name);
            if (null != result) {
                w.discard(name);   /* Pop the previous Semantic or discard if none.*/
                rc = true;                           /* Signal that name was found.*/
                break;                                                     /* Done.*/
            }
        }                                                          /* End for*/
        return rc;
    }                                 /* public boolean forget(String name)*/
    
    /** Push the search order topped by number of Wordlists in search order.
     * @param z  */
    public void getOrder(engine z) {
        for (Enumeration e = my_vector.elements(); e.hasMoreElements();) {
            z.push(e.nextElement());
        }                                                          /* End for*/
        z.push(new Long(my_vector.size()));
    }                                     /* public void getOrder(engine z)*/
    
    /** Grab search order from stack
     * @param z  */
    public void setOrder(engine z) {
        reinit();                                        /* Empty search order.*/
        int numWordlists = ((Long) z.pop()).intValue();
        for (int i = 0; i < numWordlists; ++i) {
            my_vector.addElement((Wordlist)z.pop());                       /* Add wordlists to order.*/
        }                                                          /* End for*/
    }                                     /* public void setOrder(engine z)*/
    
    /** Return names of all words in the search order.
     * @return  */
    public String words() {
        final StringBuilder sb = new StringBuilder();
        my_vector.forEach(wl -> sb.append(wl.words()));
        return sb.toString();
    }                                             /* public String words () */
    
    
    /** Add a Wordlist to the SearchOrder
     * @param w
     * @return  */
    public boolean add(Wordlist w) {
        return my_vector.add(w);
    }
    
    /** A simple Wordlist-typed method to addElement().
     * @param i
     * @return  */
    public Wordlist nthElement(int i) {
        return (Wordlist) my_vector.elementAt(i);
    }
    
    /**
     * @see com.softwoehr.util.verbose#
     * @see com.softwoehr.util.verbosity#
     * @return  */
    public boolean isVerbose()              {return isverbose;}
    
    /**
     * @see com.softwoehr.util.verbose#
     * @see com.softwoehr.util.verbosity#
     * @param tf  */
    public void    setVerbose  (boolean tf) {
        isverbose = tf;
        announce("Setting search order verbose.");
        Wordlist w = null;
        for (Enumeration e = my_vector.elements(); e.hasMoreElements();) {
            w = (Wordlist) (e.nextElement());
            w.setVerbose(isVerbose());
        }                                                          /* End for*/
    }
    
    /**
     * @see com.softwoehr.util.verbose#
     * @see com.softwoehr.util.verbosity#
     * @param s  */
    public void    announce    (String s)   {v.announce(s);   }
    
    
    /** Demonstrate <code>SearchOrder</code>.
     * @param argv  */
    public static void main(String argv[]) {
        
        GetArgs myArgs = new GetArgs(argv);/* Assimilate the command line.     */
        // SearchOrder theSearchOrder = new SearchOrder();         /* Instance of SearchOrder we're demoing.  */
        
        /* GPL'ed SoftWoehr announces itself. */
        System.out.println("SearchOrder, Copyright (C) 1999 Jack J. Woehr.");
        System.out.println("SearchOrder comes with ABSOLUTELY NO WARRANTY;");
        System.out.println("Please see the file COPYING and/or COPYING.LIB");
        System.out.println("which you should have received with this software.");
        System.out.println("This is free software, and you are welcome to redistribute it");
        System.out.println("under certain conditions enumerated in COPYING and/or COPYING.LIB.");
        
        /* See if user passed in the -v flag to request verbosity. */
        for (int i = 0; i < myArgs.optionCount() ; i++) {
            if (myArgs.nthOption(i).getOption().substring(1,2).equals("v")) {
                // theSearchOrder.setVerbose(true);
            }                                                         /* End if*/
        }
        
        // Your code goes here.
        // -------------------
        SearchOrder searchOrder = new SearchOrder();
        searchOrder.nthElement(0);
        searchOrder.add(new Wordlist());
        // -------------------
        
        return;
    }
}                                                      /* End of SearchOrder class*/

/*  End of SearchOrder.java */
