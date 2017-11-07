/* ShellTextArea.java ...  */
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

package com.SoftWoehr.FIJI.base.desktop;

import java.awt.*;
import java.awt.event.*;
import  com.SoftWoehr.SoftWoehr;
import  com.SoftWoehr.util.*;
import  com.SoftWoehr.FIJI.base.awt.*;
import  com.SoftWoehr.FIJI.base.desktop.shell.*;

 /**
   *
   * @author $Author: jwoehr $
   * @version $Revision: 1.1.1.1 $
   */
public class ShellTextArea extends TextArea implements SoftWoehr, verbose
{
  /*****************************************/
  /*% SoftWoehr default variables section. */
  /*****************************************/

  /** Revision level */
  private static final String rcsid = "$Id: ShellTextArea.java,v 1.1.1.1 2001/08/21 02:38:56 jwoehr Exp $";
  /** Implements com.SoftWoehr.SoftWoehr */
  public String rcsId() {return rcsid;}

  /**  Flags whether we are in verbose mode. */
  private boolean isverbose = false;
  /**  Helper for verbose mode. */
  private verbosity v = new verbosity(this);

  /**********************************************/
  /*% SoftWoehr default variables section ends. */
  /**********************************************/

  /***********************************/
  /*% User variables section starts. */
  /***********************************/
  /** Interpreter instance associated with this ShellTextArea. */
  private interpreter myInterpreter;

  /** TextOutputStream in use. */
  private TextAreaOutputStream myTextAreaOutputStream;

  /** ShellFrame instance associated with this ShellTextArea. */
  private ShellFrame myShellFrame;

  /*********************************/
  /*% User variables section ends. */
  /*********************************/

  /*********************************/
  /*% User methods section starts. */
  /*********************************/

  /** Arity/0 ctor. */
  public ShellTextArea () {
    this(null);
    }

  /** Arity/1 ctor */
  public ShellTextArea (ShellFrame frame) {
    reinit(frame);
    }

  public String toString ()
    {return super.toString();}

  /** Make sure shutdown-aware member objects know we're quitting.
    * @see com.SoftWoehr.SoftWoehr
  */
  public int shutdown () {
    myInterpreter.shutdown();
    return 0;
    }

  protected void finalize () throws Throwable
    {           /* Called by garbage collector in case no longer referenced*/
      super.finalize();
    }
  /** Re-initialize object discarding previous state. */
  public void reinit(ShellFrame frame) {
    myShellFrame = frame;
    myInterpreter = new interpreter();
    myTextAreaOutputStream = new TextAreaOutputStream(this);
    myInterpreter.setOutput(myTextAreaOutputStream);
    myInterpreter.output( "FIJI ForthIsh Java Interpreter "
                        + engine.fijiVersion()
                        + "\n"
                        );
    myInterpreter.output("Copyright 1999, 2000 by Jack J. Woehr\n");
    myInterpreter.output("FIJI comes with ABSOLUTELY NO WARRANTY.\n");
    myInterpreter.output("Please see the file COPYING and/or COPYING.LIB which\n");
    myInterpreter.output("you should have received with this software.\n");
    myInterpreter.output("This is free software, and you are welcome to redistribute it\n");
    myInterpreter.output("under certain conditions enumerated in COPYING and/or COPYING.LIB.\n");
    }

  /** Load a file in the interpreter. */
  public void load (String filename) {
    myInterpreter.load(filename);
    }

  /** Set interpreter numeric base. */
  public void setBase (int base) {
    myInterpreter.setBase(base);
    }

  /** Pass selected text to interpreter, then prompt. */
  public void interpretSelected() {
    String text = getSelectedText();
    interpret(text);
    }

  /** Pass a string to the interpreter, then prompt. */
  public void interpret(String text) {
    setCaretPosition(getText().length());
    myInterpreter.output(" ");
    myInterpreter.interpret(text);
    prompt(false);
    if (testKillFlag())             /* ! Crude, should be part of Shutdown.*/
      {
      if (null != myShellFrame)
        {
        myShellFrame.shutdown();      /* Crude, should be part of Shutdown.*/
        }
      }                                                           /* End if*/
    }                                                    /* End interpret()*/

  /** Pass line the user just hit Enter on to the interpter, then prompt. */
  public void interpretLastLine () {
    String text = getLastLine();
    interpret(text);
    }

  /** Extract the most recent line before an Enter hit. */
  public String getLastLine() {
     myInterpreter.output(" "); // HACK! HACK! HACK!
     /*! There seems to be a difference in caret */
     /*! positioning in different JDKs' AWTs.    */
     /*! This hack fixes truncated calc'ings of  */
     /*! The last line of text in TextArea.      */
     announce ("Caret position is: " + getCaretPosition());
     String text = getText();          /* Text in the buffer.              */
     text =
     text.substring( 0                                /* Only before caret.*/
                   , Math.max( 0, getCaretPosition() -1
                             )
                   )
                   .trim();

     int i = text.length();       /* Backwards-moving head-of-text pointer.*/

     for (i = i; i > 0 ; --i)                      /* find previous newline*/
       {
       char c = text.charAt(i-1);
       if ('\r' == c || '\n' == c)
         {
         break;
         }
       }                                                         /* End for*/
     text = text.substring(i);                    /* Extract the last line.*/
     if (text.equals("oK"))
       {
       text="";                              /* Don't interpret our prompt!*/
       }                                                          /* End if*/
     return text;
     }

  /** Display a prompt with an optional prepended newline */
  public void prompt(boolean newlineOrNone) {
    if (newlineOrNone)
      {
      myInterpreter.output("\n");
      }
      myInterpreter.prompt();
      myInterpreter.output("\n");
      setCaretPosition(getText().length()); // Is this really necessary?
    }

   /** See if interpreter has had bye called.
     * true means bye.
     */
   public boolean testKillFlag () {
     return myInterpreter.getKillFlag();
     }
  /*******************************/
  /*% User methods section ends. */
  /*******************************/

  /**********************************************/
  /*% SoftWoehr default methods section starts. */
  /**********************************************/

   /**
    * @see com.SoftWoehr.util.verbose
    * @see com.SoftWoehr.util.verbosity
    */
   public boolean isVerbose()              {return isverbose;}

   /** Sets the ShellTextArea and its interpreter verbose.
    * @see com.SoftWoehr.util.verbose
    * @see com.SoftWoehr.util.verbosity
    */
   public void    setVerbose  (boolean tf) {
     isverbose = tf;
     myInterpreter.setVerbose(tf);
     }

   /**
    * @see com.SoftWoehr.util.verbose
    * @see com.SoftWoehr.util.verbosity
    */
   public void    announce    (String s)   {v.announce(s);   }

  /********************************************/
  /*% SoftWoehr default methods section ends. */
  /********************************************/

  /*********/
  /*% Main */
  /*********/

  /** Demonstrate <code>ShellTextArea</code>. */
  public static void main (String argv[]) {

    GetArgs myArgs = new GetArgs(argv);/* Assimilate the command line.     */

    /* GPL'ed SoftWoehr announces itself. */
    System.out.println("ShellTextArea, Copyright (C) 1999 Jack J. Woehr.");
    System.out.println("ShellTextArea comes with ABSOLUTELY NO WARRANTY;");
    System.out.println("Please see the file COPYING and/or COPYING.LIB");
    System.out.println("which you should have received with this software.");
    System.out.println("This is free software, and you are welcome to redistribute it");
    System.out.println("under certain conditions enumerated in COPYING and/or COPYING.LIB.");

    // Test code goes here.
    // -------------------

    GetArgs.main(argv);       /* Delete this stub when you write some code.*/

    // -------------------

    return;
    }
}                                                   /* End of ShellTextArea*/
/*  End of ShellTextArea.java */
