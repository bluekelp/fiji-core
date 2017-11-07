/*
 * FijiInputPanel.java
 *
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Created on October 13, 2000, 4:47 PM
 */

package com.SoftWoehr.FIJI;

/**
 *
 * @author jax
 * @version $Id: FijiInputPanel.java,v 1.1.1.1 2001/08/21 02:36:54 jwoehr Exp $
 */
public class FijiInputPanel extends javax.swing.JPanel {
    
    FijiPanelController my_controller;
    
    /** Creates new form FijiInputPanel */
    public FijiInputPanel() {
        initComponents();
        init_input_box();
    }
    
    /** Creates new form FijiInputPanel instancing controller
     * @param fpc  The associated panel controller */
    public FijiInputPanel(FijiPanelController fpc) {
        this();
        set_controller(fpc);
    }
    
    /** Instance controller
     * @param fpc  The associated panel controller */
    protected void set_controller(FijiPanelController fpc) {
        my_controller = fpc;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the FormEditor.
     */
  private void initComponents () {//GEN-BEGIN:initComponents
    clearButton = new javax.swing.JButton ();
    interpretButton = new javax.swing.JButton ();
    fijiInputComboBox = new com.SoftWoehr.FIJI.FijiInputComboBox ();
    setLayout (new java.awt.BorderLayout ());

    clearButton.setToolTipText ("Clear entire history list of commands which you entered at right.");
    clearButton.setText ("Clear");
    clearButton.addActionListener (new java.awt.event.ActionListener () {
      public void actionPerformed (java.awt.event.ActionEvent evt) {
        clearButtonActionPerformed (evt);
      }
    }
    );


    add (clearButton, java.awt.BorderLayout.WEST);

    interpretButton.setToolTipText ("Interpret the text input in the combo box.");
    interpretButton.setText ("Interpret");
    interpretButton.addActionListener (new java.awt.event.ActionListener () {
      public void actionPerformed (java.awt.event.ActionEvent evt) {
        interpretButtonActionPerformed (evt);
      }
    }
    );


    add (interpretButton, java.awt.BorderLayout.EAST);

    fijiInputComboBox.setToolTipText ("Edit and recall input.");


    add (fijiInputComboBox, java.awt.BorderLayout.CENTER);

  }//GEN-END:initComponents
  
  private void interpretButtonActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interpretButtonActionPerformed
      // Add your handling code here:
      interpret_input();
  }//GEN-LAST:event_interpretButtonActionPerformed
  
  private void clearButtonActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
      fijiInputComboBox.removeAllItems();
  }//GEN-LAST:event_clearButtonActionPerformed
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton clearButton;
  private javax.swing.JButton interpretButton;
  private com.SoftWoehr.FIJI.FijiInputComboBox fijiInputComboBox;
  // End of variables declaration//GEN-END:variables
  
  /** Set up for user input */
  private void init_input_box() {
      fijiInputComboBox.getEditor().addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              fijiInputComboBoxEditorActionPerformed(evt);
          }
      }
      );
  }
  
  /** Handle combo box editor action event, i.e., user pressed Enter */
  private void fijiInputComboBoxEditorActionPerformed(java.awt.event.ActionEvent evt) {
      interpret_input_string(evt.getActionCommand());
  }
  
  /** Grab input from combo box, if any, and pass to controller's interpreter */
  private void interpret_input() {
      Object o = fijiInputComboBox.getSelectedItem();
      if (null != o) {
          interpret_input_string(o.toString());
      }
  }
  
  /** Pass string to controller's interpreter */
  private void interpret_input_string(String s) {
      
      /*********/
    /* Debug */
      //  for (int i = 0; i < fijiInputComboBox.getItemCount(); i++) {
      //    System.err.println("Item " + i + " is: " + fijiInputComboBox.getItemAt(i));
      //  }
      //  System.err.println("Selected item is: " + fijiInputComboBox.getSelectedItem());
      //  System.err.println("Selected index is: " + fijiInputComboBox.getSelectedIndex());
    /* Debug */
      /*********/
      
      if (null != s) {
          my_controller.output(s + " ");
          my_controller.interpret(s);
      }
  }
}