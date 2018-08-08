/*
 * FIJI.java
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

package com.SoftWoehr.FIJI;

import com.SoftWoehr.FIJI.interpreter.engine;
import com.SoftWoehr.FIJI.interpreter.interpreter;
import com.SoftWoehr.util.Argument;
import com.SoftWoehr.util.GetArgs;

import java.io.*;
import java.util.function.Consumer;

/** This class merely serves as a launcher for the FIJI
 * interpreter running at the command line.
 * @author  jax
 * @version $Id: FIJI.java,v 1.1.1.1 2001/08/21 02:35:20 jwoehr Exp $
 */
public class FIJI {
    public static void main(String argv[]) {
      FIJI f = new FIJI();
      f.runner(argv);
    }

    private void runner(String argv[])
    {
      interpreter i;
      InputStreamReader isr;
      BufferedReader br;
      GetArgs myArgs = new GetArgs(argv);/* Assimilate the command line.     */

      /* Create the interpreter instance. */
      try {
        Consumer<String> outputter = this::output;
        i = new interpreter(outputter);
      }                                                          /* End try*/

      catch (Exception e) {
        e.printStackTrace(System.err);

        /*  Does java reflect to which class main() belongs to without
         *  exhaustively enumerating candidate classes and testing them?
         *  The stack trace.
         */
        throw new com.SoftWoehr.FIJI.base.Error.bAcKtOmain(e);
      }                                                        /* End catch*/

      /* Examine the arguments. */
      //    try
      //      {
      for (int x = 0; x < myArgs.optionCount(); x++) {
        Argument a = myArgs.nthOption(x);

        if (a.option.equals("-v")) {
          i.setVerbose(true);
          i.announce("Verbose mode set.\n");
        }
        else if (a.option.equals("-b")) {
          if (a.argument != null ) {
            try {
              i.setBase(Integer.decode(a.argument));
            }                                                  /* End try*/
            catch (Exception e) {
              e.printStackTrace(System.err);
              throw new com.SoftWoehr.FIJI.base.Error.desktop.shell.BadBase(e);
            }                                                /* End catch*/
          }
          else {
            String s = "(null) presented for interpreter numeric base.";
            System.out.println(s);
            throw new com.SoftWoehr.FIJI.base.Error.desktop.shell.BadBase(s, null);
          }                                                     /* End if*/
        }
        else if (a.option.equals("-o")) {
          if (a.argument != null) {
            setOutputStreamEncoding(a.argument);
          }
          else {
            String s = "Bad output stream encoding proposed: " + a.option;
            System.out.println(s);
            throw new com.SoftWoehr.FIJI.base.Error.desktop.shell.BadEncoding(s, null);
          }                                                     /* End if*/
        }                                                       /* End if*/
        else if (a.option.equals("-h") || a.option.equals("--")) {
          usage();
          return;
        }                                                       /* End if*/
        else {
          String s = "Bad option " + a.option + " " + a.argument;
          System.err.println(s);
          usage();
          throw new com.SoftWoehr.FIJI.base.Error.bAdArGtOmain(s, null);
        }                                                       /* End if*/
      }                                                        /* End for*/
      //      }                                                          /* End try*/
      //    catch (Exception e)
      //      {
      //        e.printStackTrace(System.err);
      //        throw new com.SoftWoehr.FIJI.base.Error.bAcKtOmain(e);
      //      }                                                        /* End catch*/

      /* GPL announces itself. */
      System.out.println( "FIJI ForthIsh Java Interpreter "
              + engine.fijiVersion()
      );
      System.out.println("Copyright (C) 1999, 2001 by Jack J. Woehr.");
      System.out.println("FIJI comes with ABSOLUTELY NO WARRANTY;");
      System.out.println("Please see the file COPYING and/or COPYING.LIB");
      System.out.println("which you should have received with this software.");
      System.out.println("This is free software, and you are welcome to redistribute it");
      System.out.println("under certain conditions enumerated in COPYING and/or COPYING.LIB.");

      /* Set up to run. */
      try {
        setOutput(System.out);/* Note this occurs after setOutputEncoding()*/
        setInput(System.in);
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
      }                                                          /* End try*/
      catch (Exception e) {
        e.printStackTrace(System.err);
        throw new com.SoftWoehr.FIJI.base.Error.bAcKtOmain(e);
      }                                                        /* End catch*/

      /* Now treat every argument as a file to load. */
      for (int j = 0; j < myArgs.argumentCount() ; j++) {
        try {
          Argument a =  myArgs.nthArgument(j);
          i.load(a.argument);
        }                                                        /* End try*/
        catch (Exception e) {
          e.printStackTrace(System.err);
          break;
        }                                                      /* End catch*/
      }                               /* Done loading any source arguments.*/

      /* Begin to parse interactive input. */
      i.prompt();
      while (true) {
        try {
          String tib = br.readLine();

          boolean stop = i.interpret(tib);
          if (stop) break;
          else i.prompt();
        }                                                      /* End try*/
        catch (EOFException e) {                          /* No more input.*/
          break;
        }
        catch (IOException e) {
          e.printStackTrace(System.err);
          break;
        }
        catch (Exception e) {
          e.printStackTrace(System.err);
        }                                                    /* End catch*/
      }                                                        /* End while*/
      try {
        br.close();
      }                                                         /* End try*/
      catch (Exception e) {
        e.printStackTrace(System.err);
      }                                                       /* End catch*/
    }

  /** Close current input stream. */
  private void closeCurrentInput() {
    try {
      if (null != currentInput) {
        currentInput.close();
        currentInput = null;
      }                                                         /* End if*/
    }                                                          /* End try*/
    catch (Exception e) {
      e.printStackTrace(System.err);
    }                                                        /* End catch*/
  }

  /** Close current output stream. */
  private void closeCurrentOutput() {
    try {
      if (null != currentOutput) {
        currentOutput.close();
        currentOutput = null;
      }
    }                                                          /* End try*/
    catch (Exception e) {
      e.printStackTrace(System.err);
    }                                                        /* End catch*/
  }

  /** Output a string
   * @param s  */
  private void output(String s) {
    try {
      getOutputStreamWriter().write(s);
      getOutputStreamWriter().flush();
    }                                                          /* End try*/
    catch (Exception e) {
      e.printStackTrace(System.err);
    }                                                        /* End catch*/
  }

  /** Set the current input
   * @param i  */
  private void setInput(InputStream i) {
    currentInput = i;
  }

  /** Get the current input
   */
  private InputStream getInput() {
    return currentInput;
  }

  /** Set the current output
   * @param o  */
  private void setOutput(OutputStream o) {
    currentOutput = o;
    if (getOutputStreamEncoding() == null) {
      outputStreamWriter = new OutputStreamWriter(currentOutput);
    }
    else {
      try {
        outputStreamWriter
                = new OutputStreamWriter( currentOutput
                , getOutputStreamEncoding()
        );
      }                                                        /* End try*/
      catch (Exception e) {
        e.printStackTrace(System.err);
      }                                                      /* End catch*/
    }                                                           /* End if*/
  }

  /** Get the current output
   */
  private OutputStream getOutput() {
    return currentOutput;
  }

  /** Get the output stream writer
   */
  private OutputStreamWriter getOutputStreamWriter() {
    return outputStreamWriter;
  }

  /** Set output stream encoding to a given codepage.
   * One must subsequently do a <code>setOutput()</code> to make
   * the codepage take effect.
   *
   * @param codepage  */
  private void setOutputStreamEncoding(String codepage) {
    outputStreamEncoding = codepage;
  }

  /** Get output stream codepage name.
   */
  private String getOutputStreamEncoding() {
    return outputStreamEncoding;
  }

  /** An input stream */
  private InputStream currentInput;

  /** An output stream */
  private OutputStream currentOutput;

  /** Output stream writer to handle host codepage issues. */
  private OutputStreamWriter outputStreamWriter;

  /** Encoding used by OutputStreamWriter */
  private String outputStreamEncoding;

  /** Display main() command line usage. */
  private void usage() {
    System.err.println("Usage:");
    System.err.println(" java com.SoftWoehr.FIJI.interpreter.interpreter [-b base] [-o output_codepage] [-v] [file file ...]");
    System.err.println(" -v                 .. enables verbose mode, weird, unintelligible debug msgs.");
    System.err.println(" -o output_codepage .. for VM/ESA with Java 1.1.4 use Cp1407.");
    System.err.println(" -b base            .. where base is numeric input base, e.g. 8 16 0x10 etc.");
    System.err.println(" file file ...      .. these files will be loaded as FIJI source code.");
  }
}