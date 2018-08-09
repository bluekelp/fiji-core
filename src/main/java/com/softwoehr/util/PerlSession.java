/*********************************************/
/* PerlSession.java                          */
/* Invoke a Perl macro on a text buffer.     */
/* jack j. woehr jax@well.com jwoehr@ibm.net */
/* http://www.well.com/user/jax/rcfb         */
/* P.O. Box 51, Golden, Colorado 80402-0051  */
/*********************************************/
/* Copyright *C* 1998, All Rights Reserved.  */
/*                                           */
/*       This Program is Free                */
/*            SoftWoehr                      */
/*                                           */
/* Permission to distribute this SoftWoehr   */
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

import com.softwoehr.*;
import java.io.*;

public class PerlSession implements SoftWoehr
  {
  private static final String rcsid = "$Id: PerlSession.java,v 1.1.1.1 2001/08/21 02:44:22 jwoehr Exp $";

  /** Returns revision info for SoftWoehr interface. */
  public  String              rcsId() { return rcsid; }

  /** shutdown() here does nothing.
    * @see com.softwoehr.SoftWoehr
  */
  public int shutdown () { return 0; }

  public String result;
  public char outBuffer[];             /* Resultant text.                  */
  public String invocation = "perl";
  public String options = "";
  public String redirection = "";

  public PerlSession () {}

  public String toString ()
    {return super.toString();}

  protected void finalize () throws Throwable
    {           /* Called by garbage collector in case no longer referenced*/
      super.finalize();
    }


  //* Execute a perl macro specified by a script name and an input file name
  synchronized void perform (String scriptName
                             , char inBuf[]
                             , String inputFileName)
    {
    redirection =  new String ("<" + inputFileName);
    perform(scriptName, inBuf);
    }

  //* Execute a perl macro specified by a script name.
  synchronized void perform (String scriptName, char inBuf[]) {

    result = "";                                 /* empty the result string*/
    String commandLine = invocation
                         + " "
                         + scriptName                      /* build cmdline*/
                         + " "
                         + redirection;

    try {
      Process p = Runtime.getRuntime().exec(commandLine);    /* exec script*/

      /* If redirection, inBuff not meaningful. */
      if (redirection.equals("")) {                    /* inBuff meaningful*/
        OutputStreamWriter pOut = new OutputStreamWriter (p.getOutputStream());
        pOut.write(inBuf);
        pOut.flush();
        pOut.close();
        }

      // Prepare to read in the results.
      InputStreamReader   pIn = new InputStreamReader  (p.getInputStream());
      outBuffer = new char[1024];
      int numRead;

      // Loop reading.
      while((numRead = pIn.read(outBuffer, 0, outBuffer.length)) != -1) {
        result = result + new String(outBuffer, 0, numRead);
        }
      }

    catch (java.io.IOException ex) {
      System.out.println(ex.getMessage());
      }

    finally
      {
      redirection = "";
      }                                                      /* End finally*/
    }                                   /* void perform (String scriptName)*/

  public static void main (String argv[]) {
    char foo[] = new char[10000];
    if (argv.length != 2)
      {
      System.out.println ("Usage: PerlSession infilename scriptfilename");
      System.exit(0);
      }
    PerlSession p = new PerlSession();
    p.perform(argv[0], null, argv[1]);
    System.out.println(p.result);
    }
  }                                             /* End of PerlSession class*/



