/* ShellFrame.java ...  */
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
import  com.SoftWoehr.FIJI.base.desktop.shell.*;

 /** Frame holding the ShellTextArea where user types
   * and interpreter responds. Also holds the menu(s).
   * @author $Author: jwoehr $
   * @version $Revision: 1.1.1.1 $
   */
public class ShellFrame extends Frame
                        implements ActionListener
                        , KeyListener                /* Currently disabled.*/
                        , Runnable
                        , SoftWoehr
                        , verbose
{
  /*****************************************/
  /*% SoftWoehr default variables section. */
  /*****************************************/

  /** Revision level */
  private static final String rcsid = "$Id: ShellFrame.java,v 1.1.1.1 2001/08/21 02:38:51 jwoehr Exp $";
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

  /** User and interpreter text communication. */
  private SoftWoehr mySoftWoehr;
  private ShellTextArea myShellTextArea;
  private MenuBar myMenuBar;
  private Menu fileMenu;

  /*********************************/
  /*% User variables section ends. */
  /*********************************/

  /*********************************/
  /*% User methods section starts. */
  /*********************************/

  /** Arity/0 ctor. */
  public ShellFrame () {
    this(null);
  }

  /** Arity/1 ctor. */
  public ShellFrame (SoftWoehr sw) {
    reinit(sw);
  }

  public String toString ()
    {return super.toString();}

  /** Shutdown the object and its dependents. */
  public int shutdown () {
    setVisible(false);
    if (myShellTextArea != null)
      {
      remove(myShellTextArea);
      myShellTextArea.shutdown();
      myShellTextArea = null;
      }                                                           /* End if*/
    dispose();
    if (null == mySoftWoehr)/* ! Should be an interface, not Desktop per se.*/
      {
      System.exit(0);
      }
    return 0;
    }

  protected void finalize () throws Throwable
    {           /* Called by garbage collector in case no longer referenced*/
      super.finalize();
    }

  /** Re-initialize object discarding previous state. */
  public void reinit(SoftWoehr sw) {
    mySoftWoehr = sw;
    this.setTitle("FIJI ForthIsh Java Interpreter Revision "
                 + engine.fijiVersion()
                 );
    MenuItem tempMenuItem;
    MenuShortcut tempMenuShortcut;
    myShellTextArea = new ShellTextArea(this);
    myShellTextArea.addKeyListener(this);
    add(myShellTextArea);
    myMenuBar = new MenuBar();
    fileMenu = new Menu("File");
    tempMenuShortcut = new MenuShortcut(KeyEvent.VK_I);
    tempMenuItem = new MenuItem("Interpret", tempMenuShortcut);
    tempMenuItem.addActionListener(this);
    fileMenu.add(tempMenuItem);
    tempMenuShortcut = new MenuShortcut(KeyEvent.VK_Q);
    tempMenuItem = new MenuItem("Quit", tempMenuShortcut);
    tempMenuItem.addActionListener(this);
    fileMenu.add(tempMenuItem);
    myMenuBar.add(fileMenu);
    setMenuBar(myMenuBar);
    }

  /** Handle menu actions. */
  public void actionPerformed(ActionEvent e) {
    String a = e.getActionCommand();
    if (a.equals("Interpret"))
      {
      interpretSelected();
      }
    // else if (a.equals("Edit"))
      // {
      // }
    else if (a.equals("Quit"))
      {
      shutdown();
//    System.exit(0);
      }                                                           /* End if*/
    }

  /** Handle key actions for the Text Frame, if we want to.
    * Currently, all we care about is VK_ENTER.
    * Currently, not used. There's not an easy way to "get current line"
    * in java.awt.TextArea.
    */
  public void keyTyped(KeyEvent e) {      /* getCode comes back 0 in Linux.*/
    char  c = e.getKeyChar();
    if ('\n' == c || '\r' == c)
      {
      interpretLastLine();
      }
    }                                        /* end of keyTyped(KeyEvent e)*/

   /** Does nothing. */
   public void keyPressed(KeyEvent e) {}
   /** Does nothing. */
   public void keyReleased(KeyEvent e) {}

   /** Interprets the selected text in the text area. */
   public void interpretSelected() {
    myShellTextArea.interpretSelected();
    }

   /** Interprets the last line before user hit Enter in the text area. */
   public void interpretLastLine() {
     myShellTextArea.interpretLastLine();
     }

   /** Load a file as FIJI source. */
   public void load (String filename) {
     myShellTextArea.load(filename);
     }

   /** Set interpreter numeric base. */
   public void setBase (int base) {
     myShellTextArea.setBase(base);
     }

   /** Run a ShellFrame. */
   public void run () {
    setSize(480,240);
    setVisible(true);
    myShellTextArea.prompt(false);
    }

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

   /** Sets the ShellFrame and its associated ShellTextArea verbose t/f.
    * @see com.SoftWoehr.util.verbose
    * @see com.SoftWoehr.util.verbosity
    */
   public void    setVerbose  (boolean tf) {
     isverbose = tf;
     myShellTextArea.setVerbose(tf);           /* pass it on to next level.*/
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

  /** Demonstrate <code>ShellFrame</code>. */
  public static void main (String argv[]) {

    GetArgs myArgs = new GetArgs(argv);/* Assimilate the command line.     */

    /* GPL'ed SoftWoehr announces itself. */
    System.out.println( "FIJI ForthIsh Java Interpreter "
                      + engine.fijiVersion()
                      );
    System.out.println("Copyright (C) 1999, 2000 by Jack J. Woehr.");
    System.out.println("FIJI comes with ABSOLUTELY NO WARRANTY;");
    System.out.println("Please see the file COPYING and/or COPYING.LIB");
    System.out.println("which you should have received with this software.");
    System.out.println("This is free software, and you are welcome to redistribute it");
    System.out.println("under certain conditions enumerated in COPYING and/or COPYING.LIB.");

    // Test code goes here.
    // -------------------

    ShellFrame sf = new ShellFrame();

    /* Examine the arguments. */
//    try
//      {
      for (int x = 0; x < myArgs.optionCount(); x++)
        {
        Argument a = myArgs.nthOption(x);

        if (a.option.equals("-v"))
          {
          sf.setVerbose(true);
          sf.announce("Verbose mode set.\n");
          }

        else if (a.option.equals("-b"))
          {
          if (a.argument != null )
            {
            try
              {
              sf.setBase(Integer.decode(a.argument).intValue());
              }                                                  /* End try*/
            catch (Exception e)
              {
                e.printStackTrace(System.err);
                throw new com.SoftWoehr.FIJI.base.Error.desktop.shell.BadBase(e);
              }                                                /* End catch*/
            }
          else
            {
            String s = "(null) presented for interpreter numeric base.";
            System.out.println(s);
            throw new com.SoftWoehr.FIJI.base.Error.desktop.shell.BadBase(s, null);
            }                                                     /* End if*/
          }
        else
          {
          String s = "Bad option " + a.option + " " + a.argument;
          System.err.println(s);
          sf.usage();
          throw new com.SoftWoehr.FIJI.base.Error.bAdArGtOmain(s, null);
          }                                                       /* End if*/
        }                                                        /* End for*/
//      }                                                          /* End try*/
//    catch (Exception e)
//      {
//        e.printStackTrace(System.err);
//        throw new com.SoftWoehr.FIJI.base.Error.bAcKtOmain(e);
//      }                                                        /* End catch*/

    /* Now start up. */
//    new Thread (sf).start();
    sf.setSize(480,240);
    sf.setVisible(true);

    /* Load any source code specified on the command line. */
    for (int j = 0; j < myArgs.argumentCount() ; j++)
      {
      try
        {
        Argument a =  myArgs.nthArgument(j);
        sf.load(a.argument);
        }                                                        /* End try*/
      catch (Exception e)
        {
        e.printStackTrace(System.err);
        break;
        }                                                      /* End catch*/
      }                               /* Done loading any source arguments.*/

    /* Go interactive. */
    sf.myShellTextArea.prompt(true);
    // -------------------

    return;
    }
}                                                /* End of ShellFrame class*/

/*  End of ShellFrame.java */
