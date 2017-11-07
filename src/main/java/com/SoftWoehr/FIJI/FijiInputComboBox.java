/*
 * FijiInputComboBox.java
 *
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Created on October 14, 2000, 11:28 PM
 */

package com.SoftWoehr.FIJI;
import javax.swing.JComboBox;

/** An input box to allow command-line input into FIJI interpreter.
 * Each line is parsed, echoed in the text window and executed with
 * results to the text window. It's also saved in the dropdown so
 * that if the user makes a selection it's as good as typing it in.
 * @author  jax
 * @version $Id: FijiInputComboBox.java,v 1.1.1.1 2001/08/21 02:36:35 jwoehr Exp $
 */
public class FijiInputComboBox extends JComboBox {
    
    /** Creates new FijiInputComboBox */
    public FijiInputComboBox() {
        re_init();
    }
    
    /** Set up the way we want it */
    protected final void re_init() {
        setEditable(true);
        setAutoscrolls(true);
        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fijiInputComboBoxActionPerformed(evt);
            }
        }
        );
    }
    
    /** Respond to either a selection or an ENTER in the edit box
     * All this does is push the input line down if it's non-blank.
     * Interpretation happens in an outer listener in FijiInputPanel.
     * @param evt The input event.
     */
    protected void fijiInputComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        Object item = getSelectedItem();
        int index   = getSelectedIndex();
        if (!has_no_input(item, index)) {
            if (-1 == index) {
                push_input();
            }
        }
    }
    
    /** Push down edited input */
    protected void push_input() {
        insertItemAt(getEditor().getItem(), 0);
    }
    
    // Figgerers outers of what user is trying to do.
    /////////////////////////////////////////////////
    
    /** User did, in effect, nothing.
     * @param item Item in the drop-down box.
     * @param index Index of item.
     * @return Return true if no input returned.
     */
    protected boolean has_no_input(Object item, int index) {
        return (-1 == index) && (null == item || item.toString().equals(""));
    }
}
