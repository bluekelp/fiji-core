/*
 * FijiProperties.java
 *
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Created on October 19, 2000, 4:13 PM
 */
 
package com.SoftWoehr.FIJI;

/** Encapsulates FIJI properties.
 *
 * @author  jax
 * @version $Id: FijiProperties.java,v 1.1.1.1 2001/08/21 02:36:57 jwoehr Exp $
 */
public class FijiProperties extends com.SoftWoehr.util.Properties {

  static {
    add_default_property("com.SoftWoehr.FIJI.text_path",".");
    add_default_property("com.SoftWoehr.FIJI.source_path",".");
  }
  
  /** Creates new FijiProperties */
  public FijiProperties() {
  }
  
 /** Return a header suitable for a props file. The default value is "SoftWoehr Generic Properties".
   * Override this method to cause saves to write your custom header.
   * @return Text for header of a written properties file.
   */
  protected String get_properties_header () {
    return "com.SoftWoehr.FIJI.FijiProperties $Revision: 1.1.1.1 $";
  }
  
}