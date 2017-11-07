/*
 * StockDialog.java
 *
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * Created on October 16, 2000, 12:48 PM
 */

package com.SoftWoehr.JaXWT;

/**
 * Stock dialogs in static methods.
 * @author jax
 * @version $Id: StockDialog.java,v 1.1.1.1 2001/08/21 02:43:34 jwoehr Exp $
 */
public class StockDialog extends Object {
    
    // No ctor needed.
    // /** Creates new StockDialog */
    // public StockDialog() {
    // }
    
    // General Dialogs
    //////////////////
    
  /** Inform the user in a dialog
   * @param frame Parent frame
   * @param message Text message
   * @param title Text title
   */
    public static void showInfoDialog (javax.swing.JFrame frame, String message, String title) {
        javax.swing.JOptionPane.showMessageDialog
        (frame, message, title , javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    
  /** Show some error in a dialog
   * @param frame Parent frame
   * @param message Text message
   * @param title Text title
   */
    public static void showErrorDialog(javax.swing.JFrame frame, String message, String title) {
        javax.swing.JOptionPane.showMessageDialog
        (frame,
        message,
        title,
        javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
  /** Show some exception in a dialog
   * @param e The Exception to show.
   * @param frame Parent frame
   * @param message Text message
   * @param title Text title
   */
    public static void showExceptionDialog(javax.swing.JFrame frame, String message, Exception e, String title) {
        javax.swing.JOptionPane.showMessageDialog
        (frame,
        message + "\nException message:\n" + e.getMessage(),
        title,
        javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
  /** Show warning in a dialog
   * @param frame Parent frame
   * @param message The warning message
   * @param title The title
   */
    public static void showWarningDialog(javax.swing.JFrame frame, String message, String title) {
        javax.swing.JOptionPane.showMessageDialog
        (frame,
        message,
        title,
        javax.swing.JOptionPane.WARNING_MESSAGE);
    }
    
  /** Get confirmation in a dialog
   * @param frame Parent frame
   * @param message The warning message
   * @param title The title
   * @param option JOptionPane option for confirmation buttons.
   * @return  java.swing.JOptionPane.YES_OPTION java.swing.JOptionPane.NO_OPTION
   * or java.swing.JOptionPane.CANCEL_OPTION
   */
    public static int showConfirmDialog(javax.swing.JFrame frame, String message, String title, int option) {
        return javax.swing.JOptionPane.showConfirmDialog (frame, message, title, option, javax.swing.JOptionPane.QUESTION_MESSAGE);
    }
    
    // File Dialogs
    ///////////////
    
  /** Ask user if save wanted
   * @param frame Parent frame
   * @return   java.swing.JOptionPane.YES_OPTION java.swing.JOptionPane.NO_OPTION
   * or java.swing.JOptionPane.CANCEL_OPTION
   */
    public static int offerSaveChanged(javax.swing.JFrame frame) {
        return showConfirmDialog
        (frame,
        "File is changed, do you wish to save it first?",
        "Save Changed File",
        javax.swing.JOptionPane.YES_NO_CANCEL_OPTION);
    }
    
  /** Get confirmation of overwrite extant filepath in a dialog
   * @param frame Parent frame
   * @param path The file path
   * @return java.swing.JOptionPane.YES_OPTION java.swing.JOptionPane.NO_OPTION
   * or java.swing.JOptionPane.CANCEL_OPTION
   */
    public static int confirmOverwriteExtant(javax.swing.JFrame frame, String path) {
        return showConfirmDialog
        (frame,
        "Should I overwrite the extant file " + path + " ?",
        "Overwrite Extant File",
        javax.swing.JOptionPane.OK_CANCEL_OPTION);
    }
    
  /** Warn user they have chosen not to save filepath.
   * @param frame Parent frame
   * @param path The file path
   */
    public static void fileNotSaved(javax.swing.JFrame frame, String path) {
        showWarningDialog(frame, "You chose not to save " + path + " .", "File Not Saved");
    }
    
  /** Warn user they have chosen not to save filepath.
   * @param frame Parent frame
   * @param path The file path
   * @param ex The exception
   */
    public static void fileCreateException(javax.swing.JFrame frame, String path, java.io.IOException ex) {
        showExceptionDialog(frame, path + " could not be created.", ex, "Exception Creating File");
    }
    
  /** Exception thrown on file write
   * @param frame Parent frame
   * @param path The file path
   * @param ex The exceptionf
   */
    public static void fileWriteException(javax.swing.JFrame frame, String path, java.io.IOException ex) {
        showExceptionDialog(frame, path + " could not be written.", ex, "Exception Writing File");
    }
    
  /** Exception thrown on file read
   * @param frame Parent frame
   * @param path The file path
   * @param ex The exceptionf
   */
    public static void fileReadException(javax.swing.JFrame frame, String path, java.io.IOException ex) {
        showExceptionDialog(frame, path + " could not be read.", ex, "Exception Reading File");
    }
    
    // Editor Dialogs
    /////////////////
    
  /** Offer a String user entry dialog --- returns null if they cancel
   * @return Description or null
   * @param initial_string The default text in the string search gadget.
   * @param frame Parent frame */
    public static String stringSearch(javax.swing.JFrame frame, String initial_string) {
        return  (String) javax.swing.JOptionPane.showInputDialog(frame,
        "Enter the text for which to search",
        "Find",
        javax.swing.JOptionPane.QUESTION_MESSAGE,
        null,
        null,
        initial_string
        );
    }
    
}