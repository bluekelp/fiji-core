/*
 * Text Filer.java
 *
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Created on October 27, 2000, 4:16 PM
 */

package com.SoftWoehr.JaXWT;

import java.io.File;

/** An interface representing a filer of text. The interface implementer
 * defineds where text is found.
 *
 * @author jax
 * @version $Id: TextFiler.java,v 1.1.1.1 2001/08/21 02:43:37 jwoehr Exp $
 */
public interface TextFiler {
    
  /** Save some text to a file.
   * @param f The File to which to save the text
   * @param encoding The character encoding of the File.
   * @return  True iff saved. */
    public boolean save (File f, int encoding);
    
  /** Open a file in some predefined area
   * @param f The File to open into a text region.
   * @param encoding The character encoding of the File.
   * @return True iff opened. */
    public boolean open (File f, int encoding);
    
  /** Insert a file in some area at some offset
   * @param f The File to read and insert into a text region.
   * @param encoding The File's character encoding.
   * @param position The position in the text region to insert the File's contents.
   * @return True iff inserted. */
    public boolean insert (File f, int encoding, int position);
    
}
