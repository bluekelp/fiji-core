/* BinDump.java ... a binary examiner/dumper */
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
package com.SoftWoehr.util;

import com.SoftWoehr.*;
import com.SoftWoehr.util.UnsignedByte;
import java.io.*;

/** BinDump is able to read an InputStream and dump rows of
  * character data to an OutputStream interpreting the original
  * unsigned binary data in a "hex dump" in user-specified radix.
  * The radix may be from 2 to 36 because
  * <code>java.io.Integer.toString(int n, radix r)</code>
  * limits BinDump to that range.
  *
  * <p>A BinDump is a one-shot. You use it, possibly mark()
  * and reset() on input streams which support such as
  * tested by markSupported(), and then release it to
  * garbage collection. It closes its streams in finalize().
  *
  * <p>You can close the BinDump's streams manually with close(),
  * which closes both input and output. <b>A BinDump cannot
  * be used for any BinDump purpose after a close(), and must be
  * discarded for garbage collection.</b>
  * @author  $Author: jwoehr $
  * @version $Revision: 1.1.1.1 $
  */
public class BinDump implements SoftWoehr
{
  /** Identifies revision level of source for SoftWoehr interface */
  private static final String rcsid = "$Id: BinDump.java,v 1.1.1.1 2001/08/21 02:43:49 jwoehr Exp $";

  /** Returns revision info for SoftWoehr interface. */
  public  String              rcsId() { return rcsid; }

/** shutdown() here does nothing.
    * @see com.SoftWoehr.SoftWoehr
  */
  public int shutdown () { return 0; }

  /** Represents output in binary base. */
  public final static int BINARY      =  2;

  /** Represents output in octal base. */
  public final static int OCTAL       =  8;

  /** Represents output in decimal base. */
  public final static int DECIMAL     = 10;

  /** Represents output in hexadecimal base. */
  public final static int HEXADECIMAL = 16;

  /** Default number of bytes per row of dump. */
  public final static int DEFAULT_ROW_LENGTH   = 16;

  /** Base in which binary data will be output. */
  private int radix;

  /** Width of <code>UnsignedByte.toString(byte, int radix)</code>
    * of the widest UnsignedByte output as a String in the given radix.
    * @see com.SoftWoehr.util.UnsignedByte
    */
  private int paddedStringWidth;

  /** Convert output to uppercase
    * The default is false.
    */
  private boolean uppercasing;

  /** The InputStream from whence data. */
  private InputStream myInput;

  /** The OutputStream whither goeth the dump. */
  private OutputStream myOutput;

  /** The byte buffer which holds one line's worth of input.
    * Its allocated size is the only record we keep of how
    * many bytes per row we are outputting.
    */
  private byte          inBuff[];

  /** Constructs a <code>BinDump</code> on <code>System.in</code>
    * and <code>System.out</code>.
    */
  public BinDump () {
    this(System.in);
  }

  /** Constructs a <code>BinDump</code> on an <code>InputStream</code>
    * and <code>System.out</code>
    */
  public BinDump (InputStream anInputStream) {
    this(anInputStream, System.out);
    }

  /** Constructs a <code>BinDump</code> on an <code>InputStream</code>
    * and <code>OutputStream</code> */
  public BinDump (InputStream anInputStream
                  , OutputStream anOutputStream)
    {
    myInput=anInputStream;
    myOutput=anOutputStream;
    setRowLength(DEFAULT_ROW_LENGTH);
    setRadix(HEXADECIMAL);
    setUppercase(false);
    }

  /** Return object as a string. In this case we dump it all as string. */
  public String toString () {
    return this.allRowsToString();
    }

  /** Closes all streams and otherwise disposes of resources.
    * @exception Throwable
    */
  protected void finalize () throws Throwable
    {           /* Called by garbage collector in case no longer referenced*/
      close();
      super.finalize();
    }

  /**
  * Closes all streams.
  * <p><b>A <code>BinDump</code> cannot be used for any
  * <code>BinDump</code> purpose after a close(), and must be
  * discarded for garbage collection.</b>
  * @exception IOException
  */
  public void close() throws IOException {
      // Close input if non-null references.
      if (null != myInput)
        {
        myInput.close();
        myInput = null;
        }                                                         /* End if*/
      if (null != myOutput)
        {
        myOutput.close();
        myOutput = null;
        }                                                         /* End if*/
    }

  /** Mark stream for later position reset, if supported. */
  public synchronized void mark(int readlimit) {
    myInput.mark(readlimit);
  }

  /** Reset input stream to last mark, if supported.
    * @exception IOException
    */
  public synchronized void reset() throws IOException {
    myInput.reset();
    }

  /** Return true if input stream supports mark()/reset(). */
  public boolean markSupported() {
    return myInput.markSupported();
    }

  /** Set length in input data bytes of that which makes one output row. */
  public void setRowLength(int size) {
    inBuff = new byte [size];
    }

  /** Return length of input data we need per row of output.*/
  public int getRowLength() {
    return inBuff.length;
    }

  /** Set the radix of conversion and calc max string width. */
  public void setRadix(int radix) {
    this.radix = radix;
    paddedStringWidth = UnsignedByte.toString(0xff, radix).length();
    }

  /** Get the radix of conversion. */
  public int getRadix() {
    return radix;
    }

  /** Set to true if uppercase output is desired, false otherwise. */
  public void setUppercase(boolean upperNotUpper) {
    uppercasing = upperNotUpper;
    }

  /** Return true if uppercase output, false otherwise. */
  public boolean getUppercase() {
    return uppercasing;
    }

  /** Read all input and output all as rows to the out stream. */
  public void allRows() {
    try
      {
      myOutput.write(allRowsToString().getBytes());
      }                                                          /* End try*/
    catch (Exception e)
      {
        e.printStackTrace(System.err);
      }                                                        /* End catch*/
    }

  /** Read one row's worth of input and output one row to the out stream.
    * Returns number of bytes read, or -1 if input exhausted.
    */
  public int oneRow() {
    String output = "";
    int numRead = 0;   /* number read in by read operation on input stream.*/
    try
      {
      output = oneRowToString();
      numRead = output.length();
      }                                                          /* End try*/
    catch (EOFException e) {
      numRead = -1;
      }
    catch (Exception e)
      {
        e.printStackTrace(System.err);
      }                                                        /* End catch*/
    try
      {
      myOutput.write(output.getBytes());  // Because even if we reached end ...
                                          // ... we may have e.g., half a row.
      }                                                          /* End try*/
    catch (Exception e)
      {
        e.printStackTrace(System.err);
      }                                                        /* End catch*/
    return numRead;
    }

  /** Return entire input data as rows of dump, all in one string. */
  public String allRowsToString() {
    String output = "";
    boolean done = false;
    do
      {
      try
        {
        output += oneRowToString();
        }                                                        /* End try*/
      catch (EOFException e) {
        done = true;
        }
      catch (Exception e)
        {
        e.printStackTrace(System.err);
        done = true;
        }                                                      /* End catch*/
      } while(!done);                                             /* End do*/
    return output;
    }

  /** Return one row of input data as dump in a string.
    * @exception EOFException, IOException
    */
  public synchronized String oneRowToString() throws EOFException
                                       ,IOException
  {
    String output = "";
    int readLen = myInput.read(inBuff);
    if (-1 == readLen)
      {
      throw new EOFException ();
      }
    else
      {
      output = translateBuff(readLen);
      }                                                           /* End if*/
    return output;
  }

  /** Return a string dump translation of the bytes in inBuff[]. */
  private String translateBuff(int length) {
    String output="";
    for (int i = 0; i < length ; i++)
      {
      output+=translateByte(inBuff[i]);
      if (length > i + 1) // If this ain't the last byte in the row
        {
        output += " "; // Add a space at the end
        }
      else
        {
        output += "\n"; // Otherwise, add a newline.
        }                                                         /* End if*/
      }                                                          /* End for*/
    return output;
    }

  /** Return an output string translating one byte of input. */
  public String translateByte (byte b) {

    String output = UnsignedByte.toString(b, radix);
    int padNeeded = paddedStringWidth - output.length();

    // UnsignedByte.toString() doesn't prepend 0 to single-character Strings.
    for (int i = 0; i <padNeeded; i++)
      {
      output = "0"+ output;
      }                                                           /* End if*/

    // Uppercase if requested.
    if (uppercasing)
      {
      output = output.toUpperCase();
      }                                                           /* End if*/

    // Return composed string representing input UnsignedByte.
    return output;
    }

  /** Demo <code>BinDump</code> by reading a file or System.in. */
  public static void main (String argv[]) {
    BinDump b;
    if (1 == argv.length && (argv[0].equals("-h")
                         ||  argv[0].equals("--help")
                         ))
      {
      System.out.println
        ("Usage: com.SoftWoehr.util.BinDump.main [infile] [outfile] [radix] [rowlen]");
      return;                                      /* Exit on call for help*/
      }                                                           /* End if*/
    if (0 == argv.length)
      {
      b = new BinDump();
      }
    else
      {
      File fileIn = new File(argv[0]);
      FileInputStream fi;
      try
        {
        fi = new FileInputStream(fileIn);
        }                                                        /* End try*/
      catch (Exception e)
        {
        e.printStackTrace(System.err);
        return;
        }                                                      /* End catch*/
      if (1 < argv.length)
        {
        File fileOut = new File(argv[1]);
        FileOutputStream fo;
        try
          {
          fo = new FileOutputStream(fileOut);
          }                                                      /* End try*/
        catch (Exception e)
          {
            e.printStackTrace(System.err);
            return;
          }                                                    /* End catch*/
        b = new BinDump(fi, fo);
        }                                                         /* End if*/
      else
        {
        b = new BinDump(fi);
        }                                                         /* End if*/
      if (2 < argv.length)
        {
        b.setRadix(Integer.parseInt(argv[2]));
        }                                                         /* End if*/
      if (3 < argv.length)
        {
        b.setRowLength(Integer.parseInt(argv[3]));
        }                                                         /* End if*/
      }
    // /* debug */ System.err.println("radix is " + b.radix);
    b.allRows();
    }
}                                                   /* End of BinDump class*/
/*  End of BinDump.java */
