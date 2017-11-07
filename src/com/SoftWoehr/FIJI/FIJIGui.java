/*
 * FIJIGui.java
 *
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Created on October 15, 2000, 7:49 PM
 */

package com.SoftWoehr.FIJI;
import com.SoftWoehr.util.GetArgs;
import com.SoftWoehr.util.Argument;
import com.SoftWoehr.JaXWT.StockDialog;

/** The application controller for the GUI form of FIJI.
 *
 * @author jax
 * @version $Id: FIJIGui.java,v 1.1.1.1 2001/08/21 02:35:19 jwoehr Exp $
 */
public class FIJIGui extends Object implements Runnable {
    
    /** The screen title */
    public static final String BASE_TITLE = "SoftWoehr FIJI ForthIsh Java Interpreter";
    public static final String RELEASE_LEVEL = "beta";
    
    private FijiProperties properties = new FijiProperties();
    
    private String props_file_name;
    
    /** If true allow System.exit(); */
    private boolean systemExiting = true;
    
    /** Creates new FIJIGui */
    public FIJIGui() {
    }
    
    /** True if it's okay to System.exit() when closing the last FIJIFrame.
     * @return <CODE>true</CODE> means that it's okay to call System.exit() on closing the last FIJIFrame.
     */
    public boolean isSystemExiting() {
        return systemExiting;
    }
    
    /** Set true, a close of the session will invoke System.exit() when the last FIJIFrame closes.
     * @param yesNo If <CODE>false</CODE> then closing the last FIJIFrame will not explicitly call System.exit(0);
     */
    public void setSystemExiting(boolean yesNo) {
        systemExiting = yesNo;
    }
    
    /** Return an application property from the app controller.
     * @param key String indicating sought property.
     * @return String representing sought property.
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    /** True if the it's okay with this instance to exit the application.
     * @param f The associated FIJI Frame requesting permission to exit.
     * @return <CODE>true</CODE> if the frame may exit.
     */
    protected boolean exit_requested (FijiFrame f) {
        boolean result = true;
        // ...
        return result;
    }
    
    /** True if the it's okay with this instance to exit the application.
     * @param f The associated FIJI Frame requesting permission to exit.
     * @return <CODE>true</CODE> if the frame may exit.
     */
    protected boolean system_exit_requested (FijiFrame f) {
        // /* Debug */ System.out.println(isSystemExiting());
        return isSystemExiting();
    }
    
    /** Create a new fiji gui frame with this as app controller
     * @return the new FijiFrame
     */
    protected FijiFrame new_frame() {
        return new FijiFrame(this);
    }
    
    /** Set name of last loaded or saved props file.
     * @return  The name of the saved or loaded props file. */
    protected String get_props_file_name() {
        return props_file_name;
    }
    
    /** Get name of last loaded or saved props file.
     * @param name Fully-qualified or relative name of props file to load
     */
    protected void set_props_file_name(String name) {
        props_file_name = name;
    }
    
    /** Just a little error reporter */
    private void exception_loading_props_file(Exception e) {
        e.printStackTrace(System.err);
        StockDialog.showExceptionDialog(null, "Couldn't load properties file " + props_file_name + " .", e, "Exception loading properties file");
    }
    
    /** Load whatever the props file name is as properties file
     * @return <CODE>true</CODE> if file loaded okay, <CODE>false</CODE> otherwise.
     */
    protected boolean load_props () {
        boolean result = false;
        if (null != props_file_name){
            try {
                properties.load_from_file(props_file_name);
                result = true;
            }
            catch (java.io.FileNotFoundException e) {
                exception_loading_props_file(e);
            }
            catch (java.io.IOException e) {
                exception_loading_props_file(e);
            }
        }
        else {
            StockDialog.showErrorDialog(null, "No properties file name assigned.", "Error attempting to load properties file");
        }
        return result;
    }
    
    /** Process command line options */
    private void process_options(String args[]) {
        int i;
        Argument a;
        
        GetArgs g = new GetArgs(args);
        for (i = 0; i < g.optionCount() ; i++)
        {
            a =  g.nthOption(i);
            if (null != a.option) {
                if (a.option.equals("-p")) {
                    if (null != a.argument) {
                        props_file_name = a.argument;
                        load_props();
                    }
                }
            }
        }
    }
    
    /** Run the GUI version of FIJI.
     * @param args the command line arguments
     */
    public static void main (String args[]) {
        FIJIGui fiji = new FIJIGui();
        fiji.process_options(args);
        fiji.new_frame().show ();
    }
    
    /** Run when used to create a Thread.
     * In this state, exiting the frame doesn't call System.exit().
     */
    public void run() {
        setSystemExiting(false);
        new_frame().show ();
    }
    
}
