/* FijiApplet.java ...  */
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

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import  com.SoftWoehr.SoftWoehr;
import  com.SoftWoehr.util.*;

/**
 *
 * @author $Author: jwoehr $
 * @version $Revision: 1.1.1.1 $
 */
public class FijiApplet extends Applet
implements SoftWoehr
, verbose
// , ActionListener
, KeyListener
{
  /*****************************************/
  /*% SoftWoehr default variables section. */
  /*****************************************/

  /** Revision level */
  private static final String rcsid = "$Id: FijiApplet.java,v 1.1.1.1 2001/08/21 02:38:45 jwoehr Exp $";
  /** Implements com.SoftWoehr.SoftWoehr */
public String rcsId() {return rcsid;}

  /**  Flags whether we are in verbose mode. */
  private boolean isverbose = true;
  /**  Helper for verbose mode. */
  private verbosity v = new verbosity(this);

  /** Does the work of notifying shutdown clients. */
  private ShutdownHelper shutdownHelper = new ShutdownHelper();

  /**********************************************/
  /*% SoftWoehr default variables section ends. */
  /**********************************************/

  /***********************************/
  /*% User variables section starts. */
  /***********************************/
  private ShellTextArea myShellTextArea;
  // private MenuBar myMenuBar;
  private Menu fileMenu;
  /*********************************/
  /*% User variables section ends. */
  /*********************************/

  /*********************************/
  /*% User methods section starts. */
  /*********************************/

  /** Arity/0 ctor. */
  public FijiApplet () {
    reinit();
  }

  /** Return a string representation of the object.
   */
  public String toString ()
{return super.toString();}

  /** Finalize the object.
   *
   *@exception Throwable
   */
  protected void finalize () throws Throwable
  {           /* Called by garbage collector in case no longer referenced*/
    super.finalize();
  }

  /** The FijiApplet notifies subcomponents of shutdown then shuts itself down.
   * @see com.SoftWoehr.SoftWoehr
   */
  public int shutdown() {
    shutdownHelper.shutdownClients();
    // Your shutdown code for this object goes here.
    // ...

    // ...
    // Your shutdown code for this object went there.
    return 0;
  }

  /** Reinitialize the FijiApplet, discarding previous state. */
  public void reinit() {
  }

  public void init() {
    // MenuItem tempMenuItem;
    // MenuShortcut tempMenuShortcut;
    myShellTextArea = new ShellTextArea();
    myShellTextArea.addKeyListener(this);
    add(myShellTextArea);
    // If applet has a loadfile assigned, load it.
    String loadfile = getParameter("loadfile");
    if (null != loadfile) {
      load(loadfile);
    }
    // Go interactive
    myShellTextArea.prompt(true);
    
    // myMenuBar = new MenuBar();
    // fileMenu = new Menu("File");
    // tempMenuShortcut = new MenuShortcut(KeyEvent.VK_I);
    // tempMenuItem = new MenuItem("Interpret", tempMenuShortcut);
    // tempMenuItem.addActionListener(this);
    // fileMenu.add(tempMenuItem);
    // tempMenuShortcut = new MenuShortcut(KeyEvent.VK_Q);
    // tempMenuItem = new MenuItem("Quit", tempMenuShortcut);
    // tempMenuItem.addActionListener(this);
    // fileMenu.add(tempMenuItem);
    // myMenuBar.add(fileMenu);
    // setMenuBar(myMenuBar);
  }

  /** Handle menu actions. */
  // public void actionPerformed(ActionEvent e) {
  //   String a = e.getActionCommand();
  //   if (a.equals("Interpret"))
  //     {
  //     interpretSelected();
  //     }
  //   // else if (a.equals("Edit"))
  //     // {
  //     // }
  //   else if (a.equals("Quit"))
  //     {
  //     shutdown();
  // //    System.exit(0);
  //    }                                                           /* End if*/
  //  }

  /** Load a file */
  public void load (String filename) {
    myShellTextArea.load(filename);
  }

  /** Handle key actions for the Text Frame, if we want to.
   * Currently, all we care about is VK_ENTER.
   * Currently, not used. There's not an easy way to "get current line"
   * in java.awt.TextArea.
   */
  public void keyTyped(KeyEvent e) {      /* getCode comes back 0 in Linux.*/
    char  c = e.getKeyChar();
    int keyCode = e.getKeyCode();
    if (('\n' == c || '\r' == c) || (keyCode == KeyEvent.VK_ENTER))
    // if (keyCode == KeyEvent.VK_ENTER)
    {
      interpretLastLine();
    }
  }                                        /* end of keyTyped(KeyEvent e)*/

  /** Does nothing. */
  public void keyPressed(KeyEvent e) {
  }
  /** Does nothing. */
  public void keyReleased(KeyEvent e) {
  }

  /** Interprets the selected text in the text area. */
  public void interpretSelected() {
    myShellTextArea.interpretSelected();
  }

  /** Interprets the last line before user hit Enter in the text area. */
  public void interpretLastLine() {
    myShellTextArea.interpretLastLine();
  }

  /** Run a ShellFrame. */
  //  public void run () {
  //   setSize(480,240);
  //   setVisible(true);
  //   myShellTextArea.prompt(false);
  //   }

  /** Display brief usage message. */
  public void usage () {
    System.out.println("usage: ShellFrame [-v]");
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

  /**
   * @see com.SoftWoehr.util.verbose
   * @see com.SoftWoehr.util.verbosity
   */
public void    setVerbose  (boolean tf) {isverbose = tf;  }

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

  /** Demonstrate <code>FijiApplet</code>. */
  public static void main (String argv[]) {

    GetArgs myArgs = new GetArgs(argv);/* Assimilate the command line.     */
    // FijiApplet theFijiApplet = new FijiApplet();         /* Instance of FijiApplet we're demoing.  */

    /* GPL'ed SoftWoehr announces itself. */
    System.out.println("FijiApplet, Copyright (C) 1999 Jack J. Woehr.");
    System.out.println("FijiApplet comes with ABSOLUTELY NO WARRANTY;");
    System.out.println("Please see the file COPYING and/or COPYING.LIB");
    System.out.println("which you should have received with this software.");
    System.out.println("This is free software, and you are welcome to redistribute it");
    System.out.println("under certain conditions enumerated in COPYING and/or COPYING.LIB.");

    /* See if user passed in the -v flag to request verbosity. */
    for (int i = 0; i < myArgs.optionCount() ; i++)
    {
      if (myArgs.nthOption(i).getOption().substring(1,2).equals("v"))
      {
        // theFijiApplet.setVerbose(true);
      }                                                         /* End if*/
    }

    // Your code goes here.
    // -------------------

    // -------------------

    return;
  }
}                                                /* End of FijiApplet class*/

/*  End of FijiApplet.java */
