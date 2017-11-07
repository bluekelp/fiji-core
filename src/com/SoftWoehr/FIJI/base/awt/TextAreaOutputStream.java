/* TextAreaOutputStream.java ... text output */
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

package com.SoftWoehr.FIJI.base.awt;

import java.awt.*;
import java.io.*;

import  com.SoftWoehr.SoftWoehr;
import  com.SoftWoehr.util.*;

/** A class to encapsulate writing to a TextArea as an
 * an OutputStream.
 *
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
public class TextAreaOutputStream extends OutputStream
implements SoftWoehr, verbose {
    /*****************************************/
  /*% SoftWoehr default variables section. */
    /*****************************************/
    
    /** Revision level */
    private static final String rcsid = "$Id: TextAreaOutputStream.java,v 1.1.1.1 2001/08/21 02:38:42 jwoehr Exp $";
    
    /** Implements com.SoftWoehr.SoftWoehr
     * @return Returns rcsid.
     */
    public String rcsId() {return rcsid;}
    
    /**  Flags whether we are in verbose mode. */
    private boolean isverbose = true;
    /**  Helper for verbose mode. */
    private verbosity v = new verbosity(this);
    /** The text area we stream for */
    private TextArea textArea;
    
    /** Arity/0 ctor.
     * @param t TextArea we open on. */
    public TextAreaOutputStream(TextArea t) {
        reinit(t);
    }
    
    /** Shutdown here does nothing.
     * @see com.SoftWoehr.SoftWoehr#
     * @return false means no problem */
    public int shutdown() {
        return 0;
    }
    
    /** Reinitialize the TextAreaOutputStream, discarding previous state.
     * @param t  Text area we stream for. */
    public void reinit(TextArea t) {
        textArea = t;
    }
    
    /** Write a byte to the output stream.
     * @param b  byte to write */
    public void write(int  b) {
        byte b1[] = new byte[1];
        b1[0]=(byte) b;
        textArea.append(new String(b1));
    }
    
    /** Write a byte array to the output stream.
     * @param b byte array to write */
    public void write(byte b[]) {
        textArea.append(new String(b));
    }
    
    /** Write a byte subarray to the output stream.
     * @param b byte array to write from
     * @param offset offset in array to start at
     * @param length number to write
     */
    public void write(byte b[], int offset, int length) {
        textArea.append(new String(b, offset, length));
    }
    
    /** Returns verbosity level.
     * @see com.SoftWoehr.util.verbose#
     * @see com.SoftWoehr.util.verbosity#
     * @return <code>true</code> if verbose. */
    public boolean isVerbose() {
        return isverbose;
    }
    
    /** Set verbosity
     * @see com.SoftWoehr.util.verbose#
     * @see com.SoftWoehr.util.verbosity#
     * @param tf Iff true, it's verbose. */
    public void    setVerbose  (boolean tf) {
        isverbose = tf;
    }
    
    /** Announce to verbose output stream if verbosity set.
     * @see com.SoftWoehr.util.verbose#
     * @see com.SoftWoehr.util.verbosity#
     * @param s  String to announce (during debugging). */
    public void    announce    (String s)   {v.announce(s);   }
    
    /** Demonstrate <code>TextAreaOutputStream</code>.
     * @param argv  The arguments to the test. */
    public static void main(String argv[]) {
        
        GetArgs myArgs = new GetArgs(argv);/* Assimilate the command line.     */
        TextAreaOutputStream theTextAreaOutputStream
        = new TextAreaOutputStream(new TextArea());/* Instance of TextAreaOutputStream we're demoing.*/
        
    /* GPL'ed SoftWoehr announces itself. */
        System.out.println("TextAreaOutputStream, Copyright (C) 1998, 2000 Jack J. Woehr.");
        System.out.println("TextAreaOutputStream comes with ABSOLUTELY NO WARRANTY;");
        System.out.println("Please see the file COPYING and/or COPYING.LIB");
        System.out.println("which you should have received with this software.");
        System.out.println("This is free software, and you are welcome to redistribute it");
        System.out.println("under certain conditions enumerated in COPYING and/or COPYING.LIB.");
        
    /* See if user passed in the -v flag to request verbosity. */
        for (int i = 0; i < myArgs.optionCount() ; i++) {
            if (myArgs.nthOption(i).getOption().substring(1,2).equals("v")) {
                theTextAreaOutputStream.setVerbose(true);
            }                                                         /* End if*/
        }
        return;
    }
}                                      /* End of TextAreaOutputStream class*/

/*  End of TextAreaOutputStream.java */
