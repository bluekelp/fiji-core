/*
 * ChooserFileFilter.java
 *
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Created on October 16, 2000, 12:25 AM
 */

package com.SoftWoehr.JaXWT;

/**
 * A filter to choose files with a ChooseFile
 *
 * @author  jax
 * @version $Id: ChooseFileFilter.java,v 1.1.1.1 2001/08/21 02:41:31 jwoehr Exp $
 */
public class ChooseFileFilter extends javax.swing.filechooser.FileFilter {
    
    private String my_extension;
    private String my_description;
    private boolean accepts_directory = true;
    
    /** Creates new ChooseFileFilter based on extension, description, and whether directories are shown
     * @param extension Filename dot-extension
     * @param description Description of meaning of extension.
     * @param accept_directory <CODE>true</CODE> if directories are accepted.
     */
    public ChooseFileFilter(String extension, String description, boolean accept_directory) {
        my_extension = extension;
        my_description = description;
        accepts_directory = accept_directory;
    }
    
    /** Return true if this file should be shown in the directory pane,
     * false if it shouldn't.
     * Files that begin with "." are ignored.
     * @param f The File in question.
     * @return <CODE>true</CODE> if file passes acceptance test.
     */
    public boolean accept(java.io.File f) {
        boolean rc = false;
        if(f != null) {
            if(f.isDirectory() && accepts_directory) {
                rc = true;
            }
            else { // Not directory
                String extension = getExtension(f);
                if(null == extension) {
                    if (null == my_extension) {
                        rc = true;
                    }
                }
                else if (extension.equals(my_extension)) { // Extension not null
                    rc =  true;
                }
            }
        }
        return rc;
    }
    
    /** Return the extension portion of the file's name .
     * @param f File in question
     * @return The extension of the file's name.
     */
    public String getExtension(java.io.File f) {
        String result = null;
        if(f != null) {
            String filename = f.getAbsolutePath();
            int i = filename.lastIndexOf('.');
            if(i>0 && i<filename.length()-1) {
                result = filename.substring(i+1).toLowerCase();
            }
        }
        return result;
    }
    
    /** Return the description of the file pattern
     * @return The description of the meaning of the file pattern (typically the file extension).
     */
    public String getDescription () {
        return my_description;
    }
}