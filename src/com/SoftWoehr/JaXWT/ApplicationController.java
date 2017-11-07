/*
 * ApplicationController.java
 *
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Created on November 3, 2000, 7:48 PM
 */

package com.SoftWoehr.JaXWT;

/** A generic top-level application controller which can
 * be used to stand "outside and above" a toplevel frame so
 * that (for instance) an application can launch and manage
 * multiple frames.
 * @author  jax
 * @version $Id: ApplicationController.java,v 1.1.1.1 2001/08/21 02:41:31 jwoehr Exp $
 */
public class ApplicationController extends Object {
    
    private com.SoftWoehr.util.Properties my_properties = new com.SoftWoehr.util.Properties();
    
    private String props_file_name;
    
    /** Creates new ApplicationController
     */
    public ApplicationController() {
    }
    
    /** Set the properties object
     * @param p The properties set for this application.
     */
    public void set_properties(com.SoftWoehr.util.Properties p) {
        my_properties = p;
    }
    
    /** Get the properties object
     * @return The properties object associated with this application controller.
     */
    public com.SoftWoehr.util.Properties get_properties() {
        return my_properties;
    }
    
  /** Get name of last loaded or saved props file.
   * @return The name of the last loaded or saved props file.
   */
    protected String get_props_file_name() {
        return props_file_name;
    }
    
  /** Set name of last loaded or saved props file.
   * @param name The name of the last loaded or saved props file.
   */
    protected void set_props_file_name(String name) {
        props_file_name = name;
    }
    
  /** Just a little error reporter
   */
    private void exception_loading_props_file(Exception e) {
        e.printStackTrace(System.err);
        StockDialog.showExceptionDialog
        (null, "Couldn't load properties file " + props_file_name + " .", e, "Exception loading properties file");
    }
    
  /** Load whatever the props file name is as properties file
   * @return  <code>true</code> iff file loaded okay.
   */
    protected boolean load_props () {
        boolean result = false;
        if (null != props_file_name){
            try {
                my_properties.load_from_file(props_file_name);
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
            StockDialog.showErrorDialog
            (null, "No properties file name assigned.", "Error attempting to load properties file");
        }
        return result;
    }
    
    /** Process an application's command line options having to do with properties file loading.
     * @param args  The option having to do with the properties file.
     */
    protected void process_propfile_option(String args[]) {
        int i;
        com.SoftWoehr.util.Argument a;
        com.SoftWoehr.util.GetArgs g = new com.SoftWoehr.util.GetArgs(args);
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
}
