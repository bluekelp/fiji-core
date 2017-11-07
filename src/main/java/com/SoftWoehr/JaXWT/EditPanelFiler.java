/*
 * EditPanelFiler.java
 *
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Created on October 27, 2000, 4:35 PM
 */

package com.SoftWoehr.JaXWT;

import java.io.*;
import javax.swing.JFrame;


/** Predecessor to EditPanePanel ... not currently used.
 *
 * @author  jax
 * @version $Id: EditPanelFiler.java,v 1.1.1.1 2001/08/21 02:42:16 jwoehr Exp $
 */
public class EditPanelFiler extends Object implements TextFiler {
    
    public static final int DEFAULT_ENCODING = 0;
    public static final int UTF_8  = 8;
    public static final int UTF_16 = 16;
    public static final int UNKNOWN_ENCODING = -1;
    
    private EditPanel edit_panel;
    
  /** Creates new EditPanelFiler */
    public EditPanelFiler(EditPanel ep) {
        set_edit_panel(ep);
    }
    
  /** Set the edit text area to which we refer */
    protected void set_edit_panel(EditPanel ep) {
        edit_panel = ep;
    }
    
  /** Set the edit text area to which we refer */
    protected EditPanel get_edit_panel() {
        return edit_panel;
    }
    
    protected JFrame get_panel_frame() {
        return get_edit_panel().get_frame();
    }
    
  /** Get the edit text area to which we refer */
    protected EditTextArea get_edit_text_area() {
        return edit_panel.get_text_area();
    }
    
  /** An exception when we don't recognize an encoding request */
    public static class UnknownEncodingException extends Exception {
    }
    
  /** Get read and write char encoding from string */
    public static int get_encoding_value(String encoding)
    throws UnknownEncodingException
    {
        int result = UNKNOWN_ENCODING;
        
        if (null == encoding) {
            throw new UnknownEncodingException();
        }
        
        else if (encoding.equals("UTF-8")) {
            result = UTF_8;
        }
        else if (encoding.equals("UTF-16")) {
            result = UTF_16;
        }
        else {
            throw new UnknownEncodingException();
        }
        return result;
    }
    
  /** Get read and write char encoding string from int*/
    public static String get_encoding_string(int encoding)
    throws UnknownEncodingException
    {
        String result = "";
        switch (encoding) {
            case UTF_8 :
                result = "UTF-8";
                break;
            case UTF_16 :
                result = "UTF-16";
                break;
                default:
                    throw new UnknownEncodingException();
        }
        return result;
    }
    
  /** If file is readable, read text into area from it */
    protected boolean read_text_area_from_file(File f, int encoding) {
        boolean result = false;
        String text = read_text_from_file(f, encoding);
        if (null != text) {
            get_edit_text_area().setText(text);
            result = true;
        }
        return result;
    }
    
  /** If file is readable, insert into area from it */
    protected boolean insert_text_area_from_file(File f, int encoding, int offset) {
        boolean result = false;
        String text = read_text_from_file(f, encoding);
        if (null != text) {
            get_edit_text_area().insert(text, offset);
            result = true;
        }
        return result;
    }
    
  /** If file is readable, read text from it */
    protected String read_text_from_file (File f, int encoding) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer((int)f.length());
        String result = null;
        
        try {    // Read all in as chars in a buffered fashion.
            fis = new FileInputStream(f);
            if (DEFAULT_ENCODING == encoding) {
                isr = new InputStreamReader (fis);
            }
            else {
                isr = new InputStreamReader (fis, get_encoding_string(encoding));
            }
            br  = new BufferedReader(isr);
            while (br.ready()) {
                sb.append((char) br.read());
            }
            result = sb.toString();
        }
        catch (FileNotFoundException ex) {
            StockDialog.showExceptionDialog(get_panel_frame(), "Couldn't find " + f.getAbsolutePath() + ".", ex, "Exception reading file");
        }
        catch (UnsupportedEncodingException ex) {
            StockDialog.showExceptionDialog(get_panel_frame(), "Unsupported encoding.", ex, "Exception reading file");
        }
        catch (IOException ex) {
            StockDialog.showExceptionDialog(get_panel_frame(), "I/O Exception reading " + f.getAbsolutePath() + ".", ex, "Exception reading file");
        }
        catch (UnknownEncodingException ex) {
            StockDialog.showExceptionDialog(get_panel_frame(), "Unknown Encoding Exception reading " + f.getAbsolutePath() + ".", ex, "Exception reading file");
        }
        // Cleanup
        if (null != br) {
            try {
                br.close();
            }
            catch (IOException ex) {
                StockDialog.showExceptionDialog(get_panel_frame(), "I/O Exception closing BufferedReader.", ex, "Exception reading file");
            }
        }
        if (null != isr) {
            try {
                isr.close();
            }
            catch (IOException ex) {
                StockDialog.showExceptionDialog(get_panel_frame(), "I/O Exception closing InputStreamReader.", ex, "Exception reading file");
            }
        }
        if (null != fis) {
            try {
                fis.close();
            }
            catch (IOException ex) {
                StockDialog.showExceptionDialog(get_panel_frame(), "I/O Exception closing FileInputStream.", ex, "Exception reading file");
            }
        }
        return result;
    }
    
  /** Save string if possible. True if success. */
    protected boolean save_to_file(File f, int encoding, String s) {
        boolean result = false;
        if (!f.isDirectory()) {
            try {
                f.createNewFile(); // Simply returns false if extant
                result = write_to_file(f, encoding, s);
            }
            catch (IOException ex) {
                StockDialog.fileCreateException(get_panel_frame(), f.getAbsolutePath(), ex);
                result = false;
            }
            catch (UnknownEncodingException ex) {
                StockDialog.showExceptionDialog(get_panel_frame(), "An unknown text encoding was requested.", ex, "Exception in Save");
                result = false;
            }
        }
        else {
            StockDialog.showErrorDialog
            (get_panel_frame(), "The path " + f.getAbsolutePath() + " is a directory, not a file.", "Can't Overwrite Directory");
        }
        return result;
    }
    
  /** If file is writable, write text area to it */
    protected boolean write_to_file (File f, int encoding, String s)
    throws UnknownEncodingException
    {
        boolean result = false;
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        String filename = f.getAbsolutePath();
        if (null == s) {
            s = "";
        }
        FileWriter fw = null;
        if (f.canWrite()) {
            try {
                fos = new FileOutputStream(f);
                if (DEFAULT_ENCODING == encoding) {
                    osw = new OutputStreamWriter(fos);
                }
                else {
                    osw = new OutputStreamWriter(fos, get_encoding_string(encoding));
                }
                bw = new BufferedWriter(osw);
                bw.write(s);
                result = true;
            }
            catch (IOException ex) {
                StockDialog.fileWriteException(get_panel_frame(), filename, ex);
            }
            if (null != bw) {
                try {
                    bw.close();
                }
                catch (IOException ex) {
                }
            }
            
            if (null != osw) {
                try {
                    osw.close();
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (null != fos) {
                try {
                    fos.close();
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        else { // File wasn't writable
            StockDialog.showErrorDialog(get_panel_frame(), "The file " + filename + " is not writable.", "Can't Write File");
        }
        return result;
    }
    
  /** Save edit text area to a file.
   * True iff saved.
   */
    public boolean save(File f,int encoding) {
        boolean result = save_to_file(f, encoding, get_edit_text_area().getText());
        if (result) {
            get_edit_text_area().set_changed(false);
        }
        return result;
    }
    
  /** Open a file in text area */
    public boolean open(File f,int encoding) {
        boolean result = read_text_area_from_file(f, encoding);
        if (result) {
            get_edit_text_area().set_changed(false);
        }
        return result;
    }
    
  /** Insert a file in some area at some offset */
    public boolean insert(File f,int encoding,int position) {
        boolean result = insert_text_area_from_file(f, encoding, position);
        return result;
    }
}