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

import java.util.Enumeration;
import java.util.Vector;

/** This class provides the SearchOrder entity used by
 * FIJI to collate Wordlists.
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
public class SearchOrder {

    /** Vector which holds the search order */
    private Vector<Wordlist> my_vector = new Vector<>();

    /** Arity/0 ctor. */
    public SearchOrder() {
        reinit();
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
    public void getOrder(Engine z) {
        for (Enumeration e = my_vector.elements(); e.hasMoreElements();) {
            z.push(e.nextElement());
        }                                                          /* End for*/
        z.push(new Long(my_vector.size()));
    }                                     /* public void getOrder(Engine z)*/

    /** Grab search order from stack
     * @param z  */
    public void setOrder(Engine z) {
        reinit();                                        /* Empty search order.*/
        int numWordlists = ((Long) z.pop()).intValue();
        for (int i = 0; i < numWordlists; ++i) {
            my_vector.addElement((Wordlist)z.pop());                       /* Add wordlists to order.*/
        }                                                          /* End for*/
    }                                     /* public void setOrder(Engine z)*/

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
}                                                      /* End of SearchOrder class*/

/*  End of SearchOrder.java */
