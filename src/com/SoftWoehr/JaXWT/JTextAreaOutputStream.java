/*
 * JTextAreaOutputStream.java
 *
 * Created on October 13, 2000, 10:58 PM
 */

package com.SoftWoehr.JaXWT;

import com.SoftWoehr.util.verbose;
import com.SoftWoehr.util.verbosity;
import javax.swing.JTextArea;

/**
 *
 * @author  jax
 * @version
 */
public class JTextAreaOutputStream extends java.io.OutputStream implements com.SoftWoehr.util.verbose {

  /**  Flags whether we are in verbose mode. */
  private boolean is_verbose = true;
  private JTextArea my_text_area;

  /**  Helper for verbose mode. */
  private verbosity v = new verbosity(this);
  /** Creates new JTextAreaOutputStream */

  /** Create without instancing text area */
  public JTextAreaOutputStream() {
  }

  /** Create instancing text area */
  public JTextAreaOutputStream(JTextArea jta) {
    set_text_area(jta);
  }

  /** Set the text area for this output. */
  public void set_text_area(JTextArea jta) {
    my_text_area = jta;
  }

  /** Get the text area for this output. */
  public JTextArea get_text_area() {
    return my_text_area;
  }

  
  /** Error message used by write() */
  private String no_text_area_message () {
   return new String (this + " doesn't have an associated JTextArea."); 
  }
  
  class NullTextAreaException extends Exception {
    NullTextAreaException( String s) {
      super(s);
    }
  }

  /** Write a byte to the output stream. */
  public void write(int  b) {
    byte b1[] = new byte[1];
    b1[0]=(byte) b;
    String s = new String(b1);

    /** Append if text area, otherwise print error. */
    if (null != get_text_area()) {
      my_text_area.append(s);
    }
    else {
      System.err.println(no_text_area_message ());
    }
  }

  /** Write a byte array to the output stream. */
  public void write(byte b[]) {
    String s = new String(b);

    /** Append if text area, otherwise print error. */
    if (null != get_text_area()) {
      my_text_area.append(s);
    }
    else {
      System.err.println(no_text_area_message ());
    }
  }

  /** Write a byte subarray to the output stream. */
  public void write(byte b[], int offset, int length) {
    String s = new String(b, offset, length);

     /** Append if text area, otherwise print error. */
    if (null != get_text_area()) {
      my_text_area.append(s);
    }
    else {
      System.err.println(no_text_area_message ());
    }
  }

  /** Returns true if instance is in verbose mode.
   * @see com.SoftWoehr.util.verbose
   * @see com.SoftWoehr.util.verbosity
   */
  public boolean isVerbose() {
    return is_verbose;
  }
  /** Sets <code>true</code> or resets <code>false</code> verbose mode.
   * @see com.SoftWoehr.util.verbose
   * @see com.SoftWoehr.util.verbosity
   */
  public void setVerbose(boolean b) {
    is_verbose = b;
  }
  /** Say something if the object is in verbose mode, be silent otherwise.
   * @see com.SoftWoehr.util.verbose
   * @see com.SoftWoehr.util.verbosity
   */
  public void announce(String message) {
    v.announce(message);
 }

}