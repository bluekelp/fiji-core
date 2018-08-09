/*********************************************/
/* DirSupport.java                           */
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
/* @author  $Author: jwoehr $                         */
/* @version $Revision: 1.1.1.1 $                       */

package com.softwoehr.util;
import java.io.*;

/**
  * A class offering support for working with directories.
  * @author  $Author: jwoehr $
  * @version $Revision: 1.1.1.1 $
  */
public class DirSupport extends Object {

  /** Revision level */
  private static final String rcsid = "$Id: DirSupport.java,v 1.1.1.1 2001/08/21 02:43:38 jwoehr Exp $";

  /** Implements com.SoftWoehr.SoftWoehr */
  public String rcsId() {return rcsid;}

  private File dir;
  private String [] entries;
  private File [] files;

  /** Open a <code>DirSupport</code> on the current directory. */
  public DirSupport () {
     this(".");
     }

  /** Open a <code>DirSupport</code> on the named directory. */
  public DirSupport (String dirName) {
     instance(dirName);
     }

  public String toString ()
    {return super.toString();}

/** shutdown() here does nothing.
    * @see com.softwoehr.SoftWoehr
  */
  public int shutdown () { return 0; }

  protected void finalize () throws Throwable
    {           /* Called by garbage collector in case no longer referenced*/
    super.finalize();
    dir = null; System.gc();         /* Make sure any dir lock is released.*/
    }

  /** Instance or re-instance the <code>DirSupport</code> on a named dir.
    * Discards previous instancing and all related data. Dir locks are
    * freed by calling <code>System.gc()</code>
    */
  public void instance (String dirName) {
    dir     = new File(dirName); System.gc();
    files   = null;
    entries = null;
    refresh();
    }

  /** Refresh the list of entries. */
  public void refresh () {
    entries = dir.list();
    }

  /** Creates a <code>java.io.File</code> for each entry. */
  public void thicken() {
    files = new File[entries.length];
    System.gc();
    String path = dir.getPath();
    char last = (path.charAt(path.length() - 1));
    if (last != '\\' && last != '/')
      {
      path = path + '/';
      }
    for (int i = 0; i < entries.length; i++)
      {
      files[i] = new File(path + entries[i]);
      }                                                          /* End for*/
    }

  /** Prints all entries. */
  public void printEntries() {
    for (int i = 0; i < entries.length; i++)
      {
      System.out.println(entries[i]);
      }                                                          /* End for*/
    }

  /** Prints all files. This is the thicken information. */
  public void printFList() {
    String s [] = getFList();
    for (int i = 0; i < s.length; i++)
      {
      System.out.println(s[i]);
      }                                                          /* End for*/
    }

  /** Get the name of the directory referenced by this instance. */
  public String getName () {
    return dir.getName();
    }

  /** Get a string representing all the thickened file info. */
  public String [] getFList() {
    thicken();
    String flist [] = new String [entries.length];
    for (int i = 0; i < flist.length; i++)
      {
      String s = entries[i];
      File f = files[i];
      if (f.isFile())
        {
        s = s + " " + new Long(f.length()).toString();
        }
      else
        {
        if (f.isDirectory())
          {
          s = s + " <DIR>";
          }
        else
          {
          s = s+ " <???>";
          }                                                       /* End if*/
        }                                                         /* End if*/
      flist[i] = s;
      }                                                          /* End for*/
    return flist;
    }

  /** Demonstrate <code>DirSupport</code>. */
  public static void main (String argv[]) {
    DirSupport d;

    for (int i = 0; i < argv.length; i++)
      {
      d = new DirSupport(argv[i]);
      System.out.println("Class:         " + d.getClass().getName());
      System.out.println("Revision info: " + d.rcsId());
      System.out.print("Slim Directory of ");
      System.out.print(d.getName());
      System.out.println(" ...");
      d.printEntries();
      d.thicken();
      System.out.print("Thick Directory of ");
      System.out.print(d.getName());
      System.out.println(" ...");
      d.printFList();
      }                                                          /* End for*/
    }
}
/* End of DirSupport.java */
