/*
 * ChooseFile.java
 *
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Created on October 16, 2000, 1:00 AM
 */

package com.SoftWoehr.JaXWT;

/** A user interaction to choose a file to load/save, etc.
 * @author jax
 * @version $Id: ChooseFile.java,v 1.1.1.1 2001/08/21 02:41:31 jwoehr Exp $
 */
public class ChooseFile extends javax.swing.JFileChooser {
    
  /** Creates new ChooseFile
   * @param path The filepath to open on.
   * @param default_filter The filter to start with.
   * @param filters The set of possible filters for the chooser drop-down.
   * @param accept_all_used <code>true</code> iff an "all files" option be offered.
   */
    public ChooseFile(String path, ChooseFileFilter default_filter, ChooseFileHashSet filters, boolean accept_all_used) {
        super(path);
        setAcceptAllFileFilterUsed(accept_all_used);
        if (null != filters) { // If we have any filters
            java.util.Iterator it = filters.iterator();
            while (it.hasNext()) {
                addChoosableFileFilter((ChooseFileFilter) it.next());
            }
        }
        setFileFilter(default_filter);
    }
}