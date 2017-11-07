/*
 * EditPanelKeyProcessor.java
 *
 * Created on October 23, 2000, 5:52 PM
 */

package com.SoftWoehr.JaXWT;

/**
 *
 * @author  jax
 * @version
 */
public interface EditTextAreaKeyProcessor {
  /** Process certain key events before text area gets 'em
   * True if consumed.
   */
  public boolean processKeyEvent(java.awt.event.KeyEvent e);
}
