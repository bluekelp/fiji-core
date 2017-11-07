/*
 * FIJI.java
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Created on October 15, 2000, 7:48 PM
 */

package com.SoftWoehr.FIJI;

/** This class merely serves as a launcher for the FIJI
 * interpreter running at the command line.
 * @author  jax
 * @version $Id: FIJI.java,v 1.1.1.1 2001/08/21 02:35:20 jwoehr Exp $
 */
public class FIJI extends Object {
    
  /** Creates new FIJI */
    public FIJI() {
    }
  /**
   * @param args the command line arguments
   */
    public static void main (String args[]) {
        com.SoftWoehr.FIJI.base.desktop.shell.interpreter.main(args);
    }
    
}