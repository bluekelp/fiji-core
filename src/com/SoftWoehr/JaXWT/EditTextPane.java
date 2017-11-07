/*
 * EditTextPane.java
 *
 * Created on December 10, 2000, 5:11 PM
 */

package com.SoftWoehr.JaXWT;

import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author  jax
 * @version
 */
public class EditTextPane extends javax.swing.JTextPane
implements javax.swing.Scrollable, FindAndReplaceServer {

  private EditTextPaneKeyProcessor my_key_processor;
  private boolean changed = false;
  protected boolean key_processing = false;

  /** Creates new EditTextPane */
  public EditTextPane() {
    getDocument().addDocumentListener(new DocumentListener () {
      // Gives notification that an attribute or set of attributes changed.
      public void changedUpdate(DocumentEvent e) {
        changed = true;
      }

      // Gives notification that there was an insert into the document.
      public void insertUpdate(DocumentEvent e) {
        changed = true;
      }

      // Gives notification that a portion of the document has been removed.
      public void removeUpdate(DocumentEvent e) {
        changed = true;
      }
    });
  }

  /** Mark changed/unchanged */
  public void set_changed (boolean tf) {
    changed = tf;
  }

  /** Is text changed? */
  public boolean get_changed () {
    return changed;
  }
 
  // Key processing
  /////////////////
  
  /** Return the proxied key processor or null */
  public EditTextPaneKeyProcessor get_key_processor () {
    return my_key_processor;
  }
  /** Set the proxied key processor or null */
  public void set_key_processor (EditTextPaneKeyProcessor kp) {
    my_key_processor = kp;
  }

  /** TRUE sets key processing on by key processor, FALSE off. */
  public void set_key_processing (boolean on_off) {
    key_processing = on_off;
  }

  /** TRUE means key processing on by key processor, FALSE off. */
  public boolean get_key_processing () {
    return key_processing;
  }

  /** Toggle whether we proxy process keys for the text area */
  public void toggle_key_processing() {
    // System.out.println("in toggle");
    if(key_processing) {
      key_processing = false;
    }
    else {
      key_processing = true;
    }
  }


  /** Process certain key events before textedit gets 'em */
  protected void processKeyEvent(java.awt.event.KeyEvent e) {
    /* Debug */
    // int keyCode = e.getKeyCode();
    // int keyChar = e.getKeyChar();
    // int keyModifiers = e.getModifiers();
    // String keyModifiersText = e.getKeyModifiersText(keyModifiers);
    // String keyText = e.getKeyText(keyCode);
    // boolean actionKey = e.isActionKey();
    // String paramString = e.paramString();
    // int id = e.getID();

    // System.out.println
    // ("Keycode " + keyCode + " Keychar " + keyChar + " Modifiers " + keyModifiers
    // + " Modtext " + keyModifiersText + " Text " + keyText + " Actionkey " + actionKey
    // + " Parmstring " + paramString + "ID " + id);
    // System.out.println ("Key Processor is " + my_key_processor);
    /* Debug */

    if (key_processing) {
      if (null == my_key_processor) {
        // System.out.println("In null processing " + e.toString());
        super.processKeyEvent(e);
      }
      else {
        if (!my_key_processor.processKeyEvent(e)) {
          super.processKeyEvent(e);
        }
      }
    }
    else {
      // System.out.println("In default key processing");
      super.processKeyEvent(e);
    }
  }

  // -- Obligatory interfaces
  ///////////////////////////

  // Scrollable
  /////////////

  /** Refer interface call to super. */
  public boolean getScrollableTracksViewportHeight() {
    return super.getScrollableTracksViewportHeight();
  }
  /** Refer interface call to super. */
  public int getScrollableUnitIncrement(final java.awt.Rectangle p1,int p2,int p3) {
    return super.getScrollableUnitIncrement(p1, p2, p3);
  }
  /** Refer interface call to super. */
  public int getScrollableBlockIncrement(final java.awt.Rectangle p1,int p2,int p3) {
    return super. getScrollableBlockIncrement(p1, p2, p3);
  }
  /** Refer interface call to super. */
  public java.awt.Dimension getPreferredScrollableViewportSize() {
    return super.getPreferredScrollableViewportSize();
  }
  /** Refer interface call to super. */
  public boolean getScrollableTracksViewportWidth() {
    return super.getScrollableTracksViewportWidth();
  }

  // Interface FindAndReplaceServer
  /////////////////////////////////

  /** Find text and select it. True if found */
  public boolean find_forward_and_select (String s) {
    boolean result = false;
    if (null != s) {
      int pos = getText().indexOf(s, getCaretPosition());
      if (-1 < pos) {
        setCaretPosition(pos);
        moveCaretPosition(pos + s.length());
        result = true;
      }
    }
    return result;
  }

  /** Find backwards and hilite. False iff not found */
  public boolean find_backward_and_select(String s) {
    boolean result = false;
    if (null != s) {
      int pos = getText().lastIndexOf(s, java.lang.Math.max(0,getCaretPosition() - 1));
      if (-1 < pos) {
        setCaretPosition(pos + s.length());
        moveCaretPosition(pos);
        // System.out.println("Pos is " + pos + "Caret position is " + getCaretPosition());
        result = true;
      }
    }
    return result;
  }

  /** Replace selected with replacement. False iff nothing selected. */
  public boolean replace_selected (String replacement) {
    boolean result = false;
    if (null != getSelectedText()) {
      replaceSelection(replacement);
      result = true;
    }
    return result;
  }

  /** Replace all matches with replacement. False iff nothing replaced. */
  public int replace_globally(String sought,String replacement) {
    int result = 0;
    setCaretPosition(0);
    while (find_forward_and_select(sought)) {
      if (null != getSelectedText()) {
        replaceSelection(replacement);
        result++;
      }
    }
    return result;
  }
}