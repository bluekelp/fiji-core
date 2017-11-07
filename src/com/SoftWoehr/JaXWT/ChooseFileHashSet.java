/*
 * ChooseFileHashSet.java
 *
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Created on October 16, 2000, 1:03 AM
 */

package com.SoftWoehr.JaXWT;

/**
 *
 * @author  jax
 * @version $Id: ChooseFileHashSet.java,v 1.1.1.1 2001/08/21 02:41:31 jwoehr Exp $
 */
public class ChooseFileHashSet extends java.util.HashSet {
    
  /** Creates new ChooseFileHashSet */
    public ChooseFileHashSet() {
    }
    
    // !! Java 1.3.0.2 seems to have a problem with this pattern.
    
  /** Fails to add an object to the collection.
   * Only a ChooseFileFilter may be added.
   * So this method does nothing and always returns false.
   * @param o
   * @return
   */
    //  public boolean add (Object o)
    //  {
    //    return false;
    //  }
    
  /** Add a  ChooseFileFilter to the collection
   * @param cff
   * @return
   */
    //  public boolean add (ChooseFileFilter cff) {
    //    return super.add(cff);
    //  }
    
}