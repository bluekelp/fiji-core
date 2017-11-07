/*
 * FijiPanelController.java
 *
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Created on October 11, 2000, 3:22 PM
 */

package com.SoftWoehr.FIJI;


import java.io.*;

import com.SoftWoehr.FIJI.base.desktop.shell.interpreter;
import com.SoftWoehr.FIJI.base.desktop.shell.engine;
import com.SoftWoehr.JaXWT.JTextAreaOutputStream;
import com.SoftWoehr.JaXWT.ChooseFile;
import com.SoftWoehr.JaXWT.ChooseFileFilter;
import com.SoftWoehr.JaXWT.ChooseFileHashSet;
import com.SoftWoehr.JaXWT.StockDialog;
import com.SoftWoehr.JaXWT.FindAndReplaceDialog;

/** The controller for the FijiPanel. This controller provides
 * methods called by events, and also interaction with application
 * controller.
 * @author  jax
 * @version $Id: FijiPanelController.java,v 1.1.1.1 2001/08/21 02:38:10 jwoehr Exp $
 */
public class FijiPanelController extends Object {
    
    /** Indicates the file dialog to be opened is for save. */
    protected static final boolean SAVE_DIALOG = true;
    
    /** Indicates the file dialog to be opened is for open. */
    protected static final boolean OPEN_DIALOG = false;
    
    private interpreter my_interpreter;
    private FIJIGui my_application_controller;
    private FijiPanel my_panel;
    private FijiFrame my_frame;
    private FindAndReplaceDialog my_find_and_replace_dialog;
    private String my_current_text_path = ".";
    private String my_current_source_path = ".";
    private String my_save_file_name = null;
    private String my_last_find_string = "";
    
    /** Creates new FijiPanelController complete with interpreter but without instancing panel. */
    public FijiPanelController() {
        set_interpreter(new interpreter());
    }
    
    /** Creates new FijiPanelController complete with interpreter and instances panel reference.
     * @param fp the FijiPanel this controls. */
    public FijiPanelController(FijiPanel fp) {
        this();
        set_panel(fp);
        set_frame(get_panel().get_frame());
    }
    
    /** Creates new FijiPanelController complete with interpreter and instances app contoller and panel references.
     * @param fg Application controller
     * @param fp FijiPanel this controls. */
    public FijiPanelController(FIJIGui fg, FijiPanel fp) {
        this();
        set_panel(fp);
        set_application_controller(fg);
        set_frame(get_panel().get_frame());
        instance_title();
        get_properties();
    }
    
    /** Prepare to control the panel */
    protected void activate() {
        re_init_interpreter();
    }
    
    // The Application controller
    //////////////////////////////
    
    /** Get application_controller
     * @return the application_controller */
    protected FIJIGui get_application_controller() {
        return my_application_controller;
    }
    
    /** Set application_controller
     * @param fg application_controller */
    protected void set_application_controller(FIJIGui fg) {
        my_application_controller = fg;
    }
    
    // Properties
    /////////////
    
    /** Get a property from the app controller or null
     * @param key propname to seek
     * @return property string */
    protected String get_property(String key) {
        String result = null;
        if (null != my_application_controller) {
            result = my_application_controller.getProperty(key);
        }
        return result;
    }
    
    /** Get two needed filing properties to start this instance. */
    protected void get_properties() {
        String prop = get_property("com.SoftWoehr.FIJI.text_path");
        if (null != prop) {
            my_current_text_path = prop;
        }
        prop = get_property("com.SoftWoehr.FIJI.source_path");
        if (null != prop) {
            my_current_source_path = prop;
        }
    }
    
    // The Frame
    ////////////
    
    /** Get the associated frame
     * @return the associated frame */
    public FijiFrame get_frame() {
        return my_frame;
    }
    
    /** Set reference to frame holding controlled panel.
     * @param frame The frame holding the controlled panel. */
    public void set_frame(FijiFrame frame) {
        my_frame = frame;
    }
    
    /** Set title to show filename */
    protected void instance_title() {
        if (null != get_frame()) {
            get_frame().setTitle
            (FIJIGui.BASE_TITLE + " " + engine.fijiVersion() + FIJIGui.RELEASE_LEVEL + ((null == my_save_file_name) ? "" : (" - " + my_save_file_name)));
        }
    }
    
    // The Fiji Panel
    /////////////////
    
    /** Get controlled panel
     * @return controlled panel */
    public FijiPanel get_panel() {
        return my_panel;
    }
    
    /** Set controlled panel
     * @param fp controlled panel */
    public void set_panel(FijiPanel fp) {
        my_panel = fp;
    }
    
    // The Text Area
    ////////////////
    
    /** Get the free-form edit text area
     * @return The FijiTextArea
     */
    protected FijiTextArea get_text_area() {
        return get_panel().get_text_area();
    }
    
    /** Empty the text area */
    protected void clear_text_area() {
        get_text_area().setText(null);
    }
    
    /** Set contents of the panel's text area.
     * @param contents desired contents */
    protected void set_text_area_contents(String contents) {
        get_text_area().setText(contents);
    }
    
    /** Get the text area's pseudo output stream so the interpreter can write to it.
     * @return output stream representing text area to interpreter. */
    protected JTextAreaOutputStream  get_text_area_output_stream() {
        return get_text_area().get_output_stream();
    }
    
    /** Get selection in the text area
     * @return  Contents of selected region. */
    protected String get_text_area_selected_text() {
        return get_text_area().getSelectedText();
    }
    
    /** Set the text cursor to end of buffer. */
    private void set_text_area_cursor_to_end() {
        get_text_area().setCaretPosition(get_text_area().getText().length());
    }
    
    /** If file is readable, read text area from it */
    private boolean read_text_area_from_file(File f) {
        boolean result = false;
        String file_name = f.getAbsolutePath();
        FileInputStream fis = null;
        
        // Read if readable
        if (f.canRead()) {
            try {
                int file_length = (int) f.length(); // Only good for int, but hard to imagine reading a 2Gig+ file in.
                byte [] bytes = new byte [file_length];
                fis = new FileInputStream(f);
                fis.read(bytes);
                set_text_area_contents(new String(bytes));
                result = true;
            }
            catch (IOException ex) {
                StockDialog.fileReadException(my_frame, file_name , ex);
            }
            if (null != fis) {
                try {
                    fis.close();
                }
                catch (IOException ex) {
                }
            }
        }
        else { // File wasn't readable
            StockDialog.showErrorDialog(my_frame, "The file " + file_name + " is not readable.", "Can't Read File");
        }
        return result;
    }
    
    /** Save the text area to a file, if possible
     * @param f file to save to
     * @return <code>true</code> for Success */
    protected  boolean save_text_area(File f) {
        boolean result = false;
        if (save_to_file(f, get_text_area().getText())) {
            result = true;
        }
        else {
            StockDialog.fileNotSaved(my_frame, f.getAbsolutePath());
        }
        return result;
    }
    
    /** Save the selected region of the text area to a file, if possible
     * @param f File to save to.
     * @return <code>true</code> for Success */
    protected  boolean save_selected_text_area(File f) {
        boolean result = false;
        if (save_to_file(f, get_text_area().getSelectedText())) {
            result = true;
        }
        else {
            StockDialog.fileNotSaved(my_frame, f.getAbsolutePath());
        }
        return result;
    }
    
    /** Save text area to file, querying user if file extant
     * @param f file to save to.
     * @return <code>true</code> for Success */
    protected boolean query_save_text_area(File f) {
        boolean result = false;
        if (f.exists()) {
            if (javax.swing.JOptionPane.CANCEL_OPTION == StockDialog.confirmOverwriteExtant(my_frame, f.getAbsolutePath())) {
                StockDialog.fileNotSaved(my_frame, f.getAbsolutePath());
            }
            else {
                result = save_text_area(f);
            }
        }
        else {
            result = save_text_area(f);
        }
        return result;
    }
    
    /** Save text area to file, querying user if file extant
     * @param f file to save to.
     * @return <code>true</code> for Success */
    protected boolean query_save_selected_text(File f) {
        boolean result = false;
        if (f.exists()) {
            if (javax.swing.JOptionPane.CANCEL_OPTION == StockDialog.confirmOverwriteExtant(my_frame, f.getAbsolutePath())) {
                StockDialog.fileNotSaved(my_frame, f.getAbsolutePath());
            }
            else {
                result = save_selected_text_area(f);
            }
        }
        else {
            result = save_selected_text_area(f);
        }
        return result;
    }
    
    /** Save string if possible. True if success. */
    private boolean save_to_file(File f, String s) {
        boolean result = false;
        if (!f.isDirectory()) {
            try {
                f.createNewFile(); // Simply returns false if extant
                result = write_to_file(f,s);
            }
            catch (IOException ex) {
                StockDialog.fileCreateException(my_frame, f.getAbsolutePath(), ex);
                result = false;
            }
        }
        else {
            StockDialog.showErrorDialog(my_frame, "That path is a directory, not a file.", "Can't Overwrite Directory");
        }
        return result;
    }
    
    /** If file is writable, write text area to it */
    private boolean write_to_file(File f, String s) {
        boolean result = false;
        String file_name = f.getAbsolutePath();
        if (null == s) {
            s = "";
        }
        FileOutputStream fos = null;
        if (f.canWrite()) {
            try {
                fos = new FileOutputStream(f);
                fos.write(s.getBytes());
                result = true;
            }
            catch (IOException ex) {
                StockDialog.fileWriteException(my_frame, file_name, ex);
            }
            if (null != fos) {
                try {
                    fos.close();
                }
                catch (IOException ex) {
                }
            }
        }
        else { // File wasn't writable
            StockDialog.showErrorDialog(my_frame, "The file " + file_name + " is not writable.", "Can't Write File");
        }
        return result;
    }
    
    // The Interpreter
    //////////////////
    
    /** Get controlled interpreter
     * @return  the Fiji inner interprer */
    protected interpreter get_interpreter() {
        return my_interpreter;
    }
    
    /** Set controlled interpreter
     * @param interp the Fiji inner interprer */
    protected void set_interpreter(interpreter interp) {
        my_interpreter = interp;
    }
    
    /** Give the interpreter the text area's pseudo output stream. */
    protected void set_interpreter_output() {
        my_interpreter.setOutput(get_text_area_output_stream());
    }
    
    /** Append output to the text area.
     * @param s text to output. */
    protected void output(String s) {
        set_text_area_cursor_to_end();
        my_interpreter.output(s);
        set_text_area_cursor_to_end();
    }
    
    private void re_init_interpreter() {
        set_interpreter_output();
        output( "FIJI ForthIsh Java Interpreter "
        + engine.fijiVersion()
        + "\n"
        );
        output("Copyright 1999, 2001 by Jack J. Woehr\n");
        output("FIJI comes with ABSOLUTELY NO WARRANTY.\n");
        output("Please see the file COPYING and/or COPYING.LIB which\n");
        output("you should have received with this software.\n");
        output("This is free software, and you are welcome to redistribute it\n");
        output("under certain conditions enumerated in COPYING and/or COPYING.LIB.\n");
        prompt(false);
    }
    
    /** Load a FIJI source file in the interpreter.
     * @param filename Fiji source filename to load.
     */
    protected void load(String filename) {
        my_interpreter.load(filename);
    }
    
    /** Set interpreter numeric base.
     * @param base numeric base */
    protected void set_base(int base) {
        my_interpreter.setBase(base);
    }
    
    /** Pass selected text to interpreter, then prompt. */
    protected void interpret_selected() {
        String text = get_text_area_selected_text();
        interpret(text);
    }
    
    /** Pass a string to the interpreter, then prompt.
     * @param text text to interpret.  */
    protected void interpret(String text) {
        my_interpreter.interpret(text);
        if (my_interpreter.getKillFlag()) {
            System.exit(0);
        }
        prompt(false);
    }
    
    /** Display a prompt with an optional prepended space
     * @param spaceOrNone <CODE>true</CODE> if a space to be prepended.
     */
    protected void prompt(boolean spaceOrNone) {
        if (spaceOrNone) {
            output(" ");
        }
        my_interpreter.prompt();
        output("\n");
    }
    
    // Dialogs
    //////////
    
    /** Get pathname for a save or for an open of some text area stuff or return null
     * @param saveNotOpen <CODE>true</CODE> if save, else open.
     * @return <code>true</code> if save, else open.
     */
    protected String doSaveOpenTextDialog(boolean saveNotOpen) {
        String pathname = null;
        
        // Prepare filters for dialog.
        ChooseFileHashSet filters = new ChooseFileHashSet();
        filters.add(new ChooseFileFilter("txt", "Text Files (*.txt)", true));
        filters.add(new ChooseFileFilter("fiji", "Fiji Source Files (*.fiji)", true));
        
        // Create dialog with user.
        ChooseFile cf = new ChooseFile
        (my_current_text_path,
        new ChooseFileFilter("fiji_session", "Fiji Session Files (*.fiji_session)", true),
        filters,
        true);
        
        // Do dialog with user.
        cf.setMultiSelectionEnabled(false);
        int dialogResult = 0;
        if (saveNotOpen) { // Call is for a save dialog
            dialogResult = cf.showSaveDialog(my_frame);
        }
        else { // Call is for an open dialog
            dialogResult = cf.showOpenDialog(my_frame);
        }
        if(dialogResult == javax.swing.JFileChooser.APPROVE_OPTION) {
            my_current_text_path = cf.getCurrentDirectory().getPath();
            pathname = cf.getSelectedFile().getPath();
            // System.err.println("Selected File == " + pathname);
            // System.err.println("Choose path == " + my_current_text_path);
        }
        return pathname;
    }
    
    /** Get pathname for a save or for an open of some text area stuff or return null
     * @return  pathname */
    protected String doLoadFijiDialog() {
        String pathname = null;
        //System.err.println("fiji dialog says source path == " + my_current_source_path);
        
        // Create dialog with user.
        ChooseFile cf = new ChooseFile
        (my_current_source_path,
        new ChooseFileFilter("fiji", "Fiji Source Files (*.fiji)", true),
        null,
        true);
        
        // Do dialog with user.
        cf.setMultiSelectionEnabled(false);
        int dialogResult = 0;
        dialogResult = cf.showOpenDialog(my_frame);
        
        if(dialogResult == javax.swing.JFileChooser.APPROVE_OPTION) {
            my_current_source_path = cf.getCurrentDirectory().getPath();
            pathname = cf.getSelectedFile().getPath();
            // System.err.println("Selected File == " + pathname);
            // System.err.println("Choose path == " + my_current_text_path);
        }
        return pathname;
    }
    
    ////////////////
    // FIJI commands
    ////////////////
    
    /** Load a FIJI source file in response to an event
     * @param file_name Filename of Fiji source to load.
     */
    protected void load_source_file(String file_name) {
        output("Loading " + file_name + " ...\n");
        load(file_name);
        prompt(false);
    }
    
    // Events
    ////////
    
    /** Handle the load source menu event.
     * @param evt the action event */
    protected void event_load(java.awt.event.ActionEvent evt) {
        String file_name = doLoadFijiDialog();
        if (null != file_name) {
            load_source_file(file_name);
        }
        else {
            StockDialog.showWarningDialog(my_panel.get_frame(), "You chose no file, so no FIJI source was loaded.",  "No source loaded");
        }
    }
    
    /** Handle the interpret selected menu event.
     * @param evt the action event */
    protected void event_interpret_selected(java.awt.event.ActionEvent evt) {
        interpret_selected();
    }
    
    /** Clear the text area and discard the file name
     * @param evt the action event  */
    protected void event_new(java.awt.event.ActionEvent evt) {
        clear_text_area();
        my_save_file_name = null;
        instance_title();
    }
    
    /** Handle the open menu event
     * @param evt the action event  */
    protected void event_open(java.awt.event.ActionEvent evt) {
        String pathname = doSaveOpenTextDialog(OPEN_DIALOG);
        if(null != pathname) {
            if(read_text_area_from_file(new File(pathname))) {
                my_save_file_name = pathname;
                instance_title();
            }
        }
        else {
            StockDialog.showWarningDialog(my_panel.get_frame(), "You chose no file, so no file was opened in the edit area.",  "No file opened");
        }
    }
    
    /** Handle the save selected menu event
     * @param evt the action event  */
    protected void event_save_selected(java.awt.event.ActionEvent evt) {
        String pathname = doSaveOpenTextDialog(SAVE_DIALOG);
        if(null != pathname) {
            query_save_selected_text(new File(pathname));
        }
        else {
            StockDialog.showWarningDialog(my_panel.get_frame(), "You chose no file, so the selected text was not saved.",  "No file saved");
        }
    }
    
    /** Handle a save text area event
     * @param evt the action event  */
    protected void event_save(java.awt.event.ActionEvent evt) {
        if (null == my_save_file_name) {
            event_save_as(evt);
        }
        else {
            save_text_area(new File(my_save_file_name));
        }
    }
    
    /** Handle the save as menu event
     * @param evt the action event  */
    protected void event_save_as(java.awt.event.ActionEvent evt) {
        String pathname = doSaveOpenTextDialog(SAVE_DIALOG);
        if(null != pathname) {
            if(query_save_text_area(new File(pathname))) {
                my_save_file_name = pathname;
                instance_title();
            }
        }
        else {
            StockDialog.showWarningDialog(my_panel.get_frame(), "You chose no file, so the edit area was not saved.",  "No file saved");
        }
    }
    
    /** Handle a string Find event
     * @param evt the action event  */
    protected void event_find(java.awt.event.ActionEvent evt) {
        String s = StockDialog.stringSearch(my_frame, my_last_find_string);
        if (null != s) {
            my_last_find_string = s;
            get_text_area().find_forward_and_select(my_last_find_string);
        }
    }
    
    /** Handle a string Find event
     * @param evt the action event  */
    protected void event_replace(java.awt.event.ActionEvent evt) {
        if (null == my_find_and_replace_dialog) {
            my_find_and_replace_dialog = new FindAndReplaceDialog(get_text_area(), my_frame, false);
        }
        my_find_and_replace_dialog.show();
    }
    
    // Exiting
    //////////
    
    /** Frame wants to know if it's okay to close.
     * @return true if okay */
    protected boolean close_requested() {
        boolean result = true;
        // ...
        return result;
    }
}
