/*
 * Console.java
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Created on October 15, 2000, 7:48 PM
 */

package com.softwoehr.fiji;

import com.softwoehr.fiji.interpreter.Engine;
import com.softwoehr.fiji.interpreter.Interpreter;
import com.softwoehr.util.Argument;
import com.softwoehr.util.GetArgs;

import java.io.*;

/** This class merely serves as a launcher for the FIJI
 * interpreter running at the command line.
 * @author  jax
 */
public class Console {
    public static void main(String argv[]) {
      Console f = new Console();
      f.runner(argv);
    }

  private RuntimeException error(String s) {
    return error(s, null);
  }

  private RuntimeException error(Exception e) {
    return error(null, e);
  }

  private RuntimeException error(String s, Exception e) {
      if (s != null) {
        System.err.println(s);
      }
      if (e != null) {
        e.printStackTrace(System.err);
      }
      return new RuntimeException(s, e);
  }

  private void runner(String argv[])
    {
      Interpreter i;
      InputStreamReader isr;
      BufferedReader br;
      GetArgs args = new GetArgs(argv);/* Assimilate the command line.     */

      /* Create the Interpreter instance. */
      try {
        i = new Interpreter(System.err, System.out);
      }                                                          /* End try*/

      catch (Exception e) {
        e.printStackTrace(System.err);

        /*  Does java reflect to which class main() belongs to without
         *  exhaustively enumerating candidate classes and testing them?
         *  The stack trace.
         */
        throw error(e);
      }

      for (Argument a : args.options) {

        if (a.option.equals("-b")) {
          if (a.argument != null ) {
            try {
              i.setBase(Integer.decode(a.argument));
            }
            catch (Exception e) {
              throw error("bad base", e);
            }
          }
          else {
            String s = "(null) presented for Interpreter numeric base.";
            throw error(s, null);
          }
        }
        else if (a.option.equals("-o")) {
          if (a.argument != null) {
            setOutputStreamEncoding(a.argument);
          }
          else {
            String s = "Bad output stream encoding proposed: " + a.option;
            throw error(s, null);
          }
        }
        else if (a.option.equals("-h") || a.option.equals("--")) {
          usage();
          return;
        }
        else {
          String s = "Bad option " + a.option + " " + a.argument;
          usage();
          throw error(s);
        }
      }

      /* GPL announces itself. */
      System.out.println( "FIJI ForthIsh Java Interpreter "
              + Engine.fijiVersion()
      );
      System.out.println("Copyright (C) 1999, 2001 by Jack J. Woehr.");
      System.out.println("FIJI comes with ABSOLUTELY NO WARRANTY;");
      System.out.println("Please see the file COPYING and/or COPYING.LIB");
      System.out.println("which you should have received with this software.");
      System.out.println("This is free software, and you are welcome to redistribute it");
      System.out.println("under certain conditions enumerated in COPYING and/or COPYING.LIB.");

      try {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
      }
      catch (Exception e) {
        throw error(e);
      }

      for (Argument a : args.arguments) {
        /* Now treat every argument as a file to load. */
        try {
          i.load(a.argument);
        }
        catch (Exception e) {
          e.printStackTrace(System.err);
          break;
        }
      }

      /* Begin to parse interactive input. */
      i.prompt();
      while (true) {
        try {
          String tib = br.readLine();

          boolean stop = i.interpret(tib);
          if (stop) break;
          else i.prompt();
        }
        catch (EOFException e) {
          break;
        }
        catch (IOException e) {
          e.printStackTrace(System.err);
          break;
        }
        catch (Exception e) {
          e.printStackTrace(System.err);
        }
      }
      try {
        br.close();
      }
      catch (Exception e) {
        e.printStackTrace(System.err);
      }
    }

  /** Set output stream encoding to a given codepage.
   * One must subsequently do a <code>setOutput()</code> to make
   * the codepage take effect.
   *
   * @param codepage  */
  private void setOutputStreamEncoding(String codepage) {
    outputStreamEncoding = codepage;
  }

  // Encoding used by OutputStreamWriter
  private String outputStreamEncoding;

  private void usage() {
    System.err.println("Usage:");
    System.err.println(" java com.softwoehr.fiji.Main [-b base] [-o output_codepage] [file file ...]");
    System.err.println(" -o output_codepage .. for VM/ESA with Java 1.1.4 use Cp1407.");
    System.err.println(" -b base            .. where base is numeric input base, e.g. 8 16 0x10 etc.");
    System.err.println(" file file ...      .. these files will be loaded as FIJI source code.");
  }
}