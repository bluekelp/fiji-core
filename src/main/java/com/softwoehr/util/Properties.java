/*
 * Properties.java
 * A generic properties class which knows how to save itself.
 * Created on October 19, 2000, 12:15 PM
 */

package com.softwoehr.util;

/** A Properties class which knows how to load and store itself.
 * Overload this class and overload the method get_default_header()
 * to create a custom properties class. Add your default properties
 * with add_default_property (String key, String property);
 * @author jax
 * @version 1.0
 */
public class Properties extends java.util.Properties {

  /** Represents the default properties set. Use default_properties.addProperty() to add
   * a default property.
   */
  private static java.util.Properties default_properties;

  /** Set or add a default property
   * @param key Name of property.
   * @param property Value of property
   */
  protected static void add_default_property (String key, String property) {
    default_properties.setProperty(key, property);
  }

  /** To respond to requests */
  public class NoSuchPropertyException extends java.lang.Exception {
    NoSuchPropertyException(String property) {
      super("Unknown property: " + property);
    }
  }

  /** To respond to requests */
  public class InvalidIntPropertyException extends java.lang.Exception {
    InvalidIntPropertyException(String property) {
      super("Invalid integer property: " + property);
    }
  }

  /** Create the defaults */
  static {
    default_properties = new java.util.Properties ();

    /* Set all the defaults */
    // default_properties.setProperty("com.SoftWoehr.JTOpenContrib.MEU.system.server.user", null);
    // default_properties.setProperty("com.SoftWoehr.JTOpenContrib.MEU.system.server.servername", null);
    default_properties.setProperty("com.SoftWoehr.copyright", "Copyright *C* 2000 by Jack J. Woehr PO Box 51, Golden, Colorado 80402 USA\nhttp://www.SoftWoehr.com\nAll Rights Reserverd");
  }

  /** Creates new MEUProps */
  public Properties() {
    super(default_properties);
  }

  /** Load properties at creation
   * @param filename Properties file on local file system.
   */
  public Properties(String filename) {
    this();
    try {
      load_from_file(filename);
    }

    catch (java.io.FileNotFoundException e) {
      e.printStackTrace(System.err);
    }

    catch (java.io.IOException e) {
      e.printStackTrace(System.err);
    }
  }

  /** Reload saved properties from a local file
   * @param filename Local file to fetch property strings from
   * @throws FileNotFoundException Couldn't find that path.
   * @throws IOException Couldn't read for some reason.
   */
  public void load_from_file (String filename)
  throws java.io.FileNotFoundException, java.io.IOException
  {
    java.io.FileInputStream fi = new java.io.FileInputStream(filename);
    load(fi);
    fi.close();
  }

  /** Return a header suitable for a props file. The default value is "SoftWoehr Generic Properties".
   * Override this method to cause saves to write your custom header.
   * @return Text for header of a written properties file.
   */
  protected String get_properties_header () {
    return "SoftWoehr Generic Properties";
  }

  /** Save the properties
   * @param filename File on local file system to store props. to.
   * @throws FileNotFoundException Couldn't find that path.
   * @throws IOException Couldn't write for some reason.
   */
  public void store_to_file (String filename)
  throws java.io.FileNotFoundException, java.io.IOException
  {
    java.io.FileOutputStream fo = new java.io.FileOutputStream(filename);
    store(fo, get_properties_header ());
  }

  /** Get a specific int property.
   * @param property Name of property.
   * @throws NoSuchPropertyException No such.
   * @throws InvalidIntPropertyException Wasn't a base10 int.
   * @return Int value base 10 of property value
   */
  public int get_int_property (String property)
  throws NoSuchPropertyException, InvalidIntPropertyException
  {
    int value = 0;
    String prop = getProperty(property);
    if (null == prop)
    {
      throw new NoSuchPropertyException(property);
    }
    try {
      value = Integer.parseInt(prop);
    }
    catch (NumberFormatException e) {
      throw new InvalidIntPropertyException(property);
    }
    return value;
  }
}