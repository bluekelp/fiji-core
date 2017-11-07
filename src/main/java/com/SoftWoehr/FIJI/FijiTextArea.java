/*
 * FijiTextArea.java
 *
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Created on October 12, 2000, 2:37 PM
 */

package com.SoftWoehr.FIJI;

import javax.swing.JTextArea;
import com.SoftWoehr.JaXWT.JTextAreaOutputStream;
import com.SoftWoehr.JaXWT.EditTextArea;

/** The text area for free-form FIJI input and output.
 *
 * @author  jax
 * @version $Id: FijiTextArea.java,v 1.1.1.1 2001/08/21 02:38:10 jwoehr Exp $
 */
public class FijiTextArea extends EditTextArea implements javax.swing.Scrollable, com.SoftWoehr.JaXWT.FindAndReplaceServer {
    
    private FijiPanelController my_controller;
    
    private JTextAreaOutputStream my_output_stream = new JTextAreaOutputStream(this);
    
    /** Creates new FijiTextArea
     * ctor/0 needed by design tool.
     */
    public FijiTextArea() {
    }
    
    /** Creates new FijiTextArea
     * @param fpc associated FijiPanelController */
    public FijiTextArea(FijiPanelController fpc) {
        set_controller(fpc);
    }
    
    /** Return the output stream used by the interpreter
     * @return The text area represented as an output stream
     * to the FIJI interpreter.
     */
    public JTextAreaOutputStream get_output_stream() {
        return my_output_stream;
    }
    
    /** Get controller
     * @return associated FijiPanelController  */
    public FijiPanelController get_controller() {
        return my_controller;
    }
    
    /** Set controller
     * @param fpc associated FijiPanelController  */
    public void set_controller(FijiPanelController fpc) {
        my_controller = fpc;
    }
    
    /** Refer interface call to super.
     * @return  height */
    public boolean getScrollableTracksViewportHeight() {
        return super.getScrollableTracksViewportHeight();
    }
    /** Refer interface call to super.
     * @param p1
     * @param p2
     * @param p3
     * @return  */
    public int getScrollableUnitIncrement(final java.awt.Rectangle p1,int p2,int p3) {
        return super.getScrollableUnitIncrement(p1, p2, p3);
    }
    /** Refer interface call to super.
     * @param p1
     * @param p2
     * @param p3
     * @return  */
    public int getScrollableBlockIncrement(final java.awt.Rectangle p1,int p2,int p3) {
        return super. getScrollableBlockIncrement(p1, p2, p3);
    }
    /** Refer interface call to super.
     * @return  */
    public java.awt.Dimension getPreferredScrollableViewportSize() {
        return super.getPreferredScrollableViewportSize();
    }
    /** Refer interface call to super.
     * @return  */
    public boolean getScrollableTracksViewportWidth() {
        return super.getScrollableTracksViewportWidth();
    }
    
    // Hi-level editing functionality
    /////////////////////////////////
    
    /** Find text and select it. True if found
     * @param s Text to seek
     * @return  <code>true</code> iff found. */
    public boolean find_forward_and_select(String s) {
        return super.find_forward_and_select(s);
    }
    
    /** Find backwards and hilite. False iff not found
     * @param s Text to seek
     * @return <code>true</code> iff found. */
    public boolean find_backward_and_select(String s) {
        return super.find_backward_and_select(s);
    }
    
    /** Replace selected with replacement. False iff nothing selected.
     * @param replacement Text to replace selected with.
     * @return <code>true</code> iff found and replaced. */
    public boolean replace_selected(String replacement) {
        return super.replace_selected(replacement);
    }
    
    /** Replace all matches with replacement. False iff nothing replaced.
     * @param sought Text to seek
     * @param replacement Text to replace selected with.
     * @return number of replacements carried out. */
    public int replace_globally(String sought,String replacement) {
        return super.replace_globally(sought, replacement);
    }
}