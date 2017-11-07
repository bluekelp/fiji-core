/*
 * EditTextPaneKeyProcessor.java
 *
 * Created on December 24, 2000, 7:15 PM
 */

package com.SoftWoehr.JaXWT;

/**
 *
 * @author  jax
 * @version
 */
public interface EditTextPaneKeyProcessor {
  /** Process certain key events before text area gets 'em
   * True if consumed.
   */
  public boolean processKeyEvent(java.awt.event.KeyEvent e);
}
