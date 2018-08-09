/*
 * SQLClassLoader.java
 *
 * Copyright *C* 2001 Jack J. Woehr
 * All Rights Reserved
 * PO Box 51, Golden, Colorado 80402-0051 USA
 * http://www.softwoehr.com
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Free Software NO WARRANTY NO GUARANTEE
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Open Source SoftWoehr
 * Created on May 5, 2001, 12:31 AM
 */

package com.softwoehr.util;

import javax.sql.RowSet;
import java.io.*;
import java.sql.*;

/** Store and load Java classes to and from a database.
 *
 * @author  jax
 * @version $Id: SQLClassLoader.java,v 1.1.1.1 2001/08/21 02:44:10 jwoehr Exp $
 */
public class SQLClassLoader extends java.lang.ClassLoader{
    
    private String my_server_url = null;
    private String my_sql_collection_name = null;
    private String my_sql_table_name = null;
    private String my_userid = null;
    private int my_session_type = SQLSession.NO_SESSION_TYPE;
    
    private RowSet my_rowset = null;
    
    /** Free the RowSet connection resource */
    public void close_rowset() {
        if (my_rowset != null) {
            try {
                my_rowset.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    /** Clean up, e.g., free the RowSet connection resource
     * @throws Throwable If an exception occurs during finalization.
     */
    public void finalize() throws Throwable {
        close_rowset();
    }
    
    /** Creates new SQLClassLoader
     * @param user_id
     * @param password
     * @param server_name
     * @param sql_collection_name
     * @param sql_table_name
     * @param session_type
     * @throws SQLException
     * @throws ClassNotFoundException  */
    public SQLClassLoader
    (String server_name, String user_id, String password, String sql_collection_name, String sql_table_name, int session_type)
    throws java.sql.SQLException, ClassNotFoundException {
        my_session_type = session_type;
        my_server_url = SQLSession.calcURL(server_name, session_type);
        my_sql_collection_name = sql_collection_name;
        my_sql_table_name = sql_table_name;
        my_userid = user_id;
        // System.out.println("server URL " + my_server_url + " collection name " + my_sql_collection_name + " table name " + my_sql_table_name + " type " + session_type);
        SQLSession.registerDriver(my_session_type);
        
        switch (session_type) {
            case SQLSession.JT400   :
                my_rowset = null; // new AS400JDBCRowSet(my_server_url, my_userid, password);
                break;
                
            case SQLSession.JDBCODBC:
                break;
                
            case SQLSession.POSTGRES:
                break;
                
            case SQLSession.MYSQL:
                break;
                
            default:
        }
    }
    
    /** An exception when no result set comes back */
    public static class NoRowSetException extends Exception {
    }
    
    /** Check validity of object state before running.
     * @throws NoRowSetException  */
    public void validate_setup()
    throws NoRowSetException {
        switch (my_session_type) {
            
            case SQLSession.JT400 :
                if (null == my_rowset) {
                    throw new NoRowSetException();
                }
                break;
                
            case SQLSession.JDBCODBC:
                break;
                
            case SQLSession.POSTGRES:
                break;
                
            case SQLSession.MYSQL:
                break;
                
            default:
        }
    }
    
    /** Read in a file to a byte array. The file is the class file for the
     * fully-qualified class name passed in.
     * @param class_name
     * @return  */
    public byte [] read_class_file(String class_name) {
        byte []            input_bytes  = null;
        int                bytes_read   = 0;
        File               class_file   = null;
        FileInputStream    file_stream  = null;
        String             file_name    = null;
        String             path_name    = null;
        
        // Support package names by converting the class name to
        //   a file name by replacing the "." in the package name with a
        //   path separator. This only applies because the class file is being
        //  loaded from a file.
        file_name = class_name.replace('.', File.separatorChar);
        path_name = file_name + ".class";
        
        // Read the class file into a buffer in one shot
        try {
            class_file = new File(path_name);
            file_stream = new FileInputStream(class_file);
            
            // Create a buffer big enough to hold the entire class file.
            bytes_read = (int)class_file.length();
            input_bytes = new byte[bytes_read];
            
            // Read the class file into the buffer
            try {
                bytes_read = file_stream.read(input_bytes);
            }
            catch (IOException e) {
                System.err.println("Exception trying to read the class file");
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("File " + class_file.toString() + " doesn't exist");
        }
        return input_bytes;
    }
    
    /**
     * @param class_name
     * @param class_object
     * @throws NoRowSetException
     * @throws SQLException  */
    public void insertAS400class(String class_name, Object class_object)
    throws NoRowSetException, SQLException {
        // Throws if object not set up correctly.
        validate_setup();
        
        // Set the prepared statement and initialize the parameters.
        my_rowset.setCommand("INSERT INTO " + my_sql_collection_name + "." + my_sql_table_name + " VALUES (?, ?)");
        my_rowset.setString(1, class_name);
        my_rowset.setObject(2, class_object);
        
        // Populate the rowset.
        my_rowset.execute();
    }
    
    /**
     * @param class_name
     * @throws NoRowSetException
     * @throws ClassNotFoundException
     * @throws SQLException
     * @return  */
    public byte [] selectAS400class(String class_name)
    throws NoRowSetException, ClassNotFoundException, SQLException {
        // Throws if object not set up correctly.
        validate_setup();
        
        my_rowset.setCommand
        (
        "SELECT CLASSFILE FROM "
        + my_sql_collection_name
        + "."
        + my_sql_table_name
        + " WHERE CLASSNAME = '"
        + class_name
        + "'"
        );
        my_rowset.execute();
        my_rowset.next();
        Blob blob = my_rowset.getBlob("CLASSFILE");
        return blob.getBytes(1, new Long(blob.length()).intValue());
    }
    
    /**
     * @param class_name
     * @param class_object
     * @throws NoRowSetException
     * @throws SQLException  */
    public void addClassToDataSource(String class_name, Object class_object)
    throws NoRowSetException, SQLException {
        switch (my_session_type) {
            
            case SQLSession.JT400 :
                insertAS400class(class_name, class_object);
                break;
                
            case SQLSession.JDBCODBC:
                break;
                
            case SQLSession.POSTGRES:
                break;
                
            case SQLSession.MYSQL:
                break;
                
            default:
        }
    }
    
    
    /**
     * @param class_name
     * @param file_name
     * @throws NoRowSetException
     * @throws SQLException  */
    public void insertClassFile(String class_name, String file_name)
    throws NoRowSetException, SQLException {
        addClassToDataSource(class_name, read_class_file(file_name));
    }
    
    /** Get a class from SQLClassLoader's assigned data source.
     * @return The not-yet-resolved Class object
     * @param class_name The sought class
     * @throws ClassNotFoundException If class is not found.
     */
    public Class findClass(String class_name) throws ClassNotFoundException {
        byte [] b = null;
        Class   c = null;
        
        switch (my_session_type) {
            
            case SQLSession.JT400 :
                try {
                    b = selectAS400class(class_name);
                }
                catch (NoRowSetException e) {
                    e.printStackTrace();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
                
                break;
                
            case SQLSession.JDBCODBC:
                break;
                
            case SQLSession.POSTGRES:
                break;
                
            case SQLSession.MYSQL:
                break;
                
            default:
        }
        
        if (null != b) {
            c = defineClass(class_name, b, 0, b.length);
        }
        
        return c;
    }
    
    /** This loadClass() varies from the default algorithm
     * in that it searches in the order:
     * <ol>
     * <li>Loaded classes</li>
     * <li>Database</li>
     * <li>Parent classes</li>
     * </ol>
     * @param name Name of class to seek
     * @param resolve <code>true<code> if class should be resolved before return
     * @throws ClassNotFoundException If class is not found
     * @return the class object
     */
    protected Class loadClass(String name, boolean resolve)
    throws ClassNotFoundException {
        
        // Try loaded classes
        Class c = findLoadedClass(name);
        if (c == null) {
            
            try {
                // Try the database
                c = findClass(name);
            }
            catch (ClassNotFoundException ex) {
                ClassLoader parent = getParent();
                if (parent != null) {
                    // This can go ahead and throw on failure.
                    // Try the parent class loader
                    c = parent.loadClass(name);
                }
                else { // null means system class loader is parent.
                    // This can go ahead and throw on failure.
                    // Try the system class loader.
                    c = findSystemClass(name);
                }
            }
        }
        
        // Resolve if requested.
        if (resolve) {
            // C is never null because parent.loadClass or
            // findSystemClass would already have thrown.
            resolveClass(c);
        }
        return c;
    }
    
    /** Test self
     * @return
     * @param user_id
     * @param password
     * @param call_main
     * @param server_name
     * @param collection_name
     * @param table_name
     * @param class_name
     * @param file_name
     * @param session_type
     * @param command  */
    public static Class test_me
    (
    String server_name
    , String user_id
    , String password
    , String collection_name
    , String table_name
    , String class_name
    , String file_name
    , int session_type
    , String command
    , boolean call_main
    ) {
        SQLClassLoader sql = null;
        Class c = null;
        char cmd = '!';
        // System.out.println("1");
        // Parse command
        if (command != null) {
            cmd = command.trim().charAt(0);
        }
        else {
            usage();
        }
        // System.out.println("2");
        
        // Get connection
        if (server_name != null && table_name != null) {
            try {
                // System.out.println("2.5");
                sql = new SQLClassLoader(server_name, user_id, password, collection_name, table_name, session_type);
            }
            catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            usage();
        }
        
        // System.out.println("3");
        
        // Try it
        if (sql != null && class_name != null) {
            java.lang.reflect.Method [] methods = null;
            switch (cmd) {
                
                case 'r' :
                    try {
                        // System.out.println("4");
                        c = sql.loadClass(class_name, true);
                        System.out.println("Resolved class is: " + c.toString());
                        System.out.println("Methods are: ");
                        methods = c.getDeclaredMethods();
                        for (int i = 0; i < methods.length ; i++) {
                            java.lang.reflect.Method m = methods[i];
                            System.out.println(m.toString());
                            if (call_main && m.getName().equals("main")) {
                                Object [] a = new Object [1];
                                a[0] = new String [0];
                                try {
                                    System.out.println("Calling " + c + " method " + m);
                                    m.invoke(c, a);
                                }
                                catch (java.lang.reflect.InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                                catch (java.lang.IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                    
                case 'w' :
                    if (file_name != null) {
                        try {
                            // System.out.println("5");
                            sql.insertClassFile(class_name, file_name);
                        }
                        catch (SQLClassLoader.NoRowSetException e) {
                            e.printStackTrace();
                        }
                        catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                    
                default :
                    System.out.println("Unknown command '" + command + "'." );
            }
        }
        else {
            usage();
        }
        return c;
    }
    
    /** Print usage message */
    public static void usage() {
        System.out.println("Usage:");
        System.out.println
        ("SQLClassLoader -s server_name -u userid -p password -c collection_name -t table_name -n class_name -f file_name -y session_type -x cmd [ -m (calls main) ]");
    }
    /** Test storing and retrieving classes
     * @param argv Arguments to the test.
     */
    public static void main(String [] argv) {
        GetArgs args = new GetArgs(argv);
        Argument a = null;
        
        int my_session_type = SQLSession.NO_SESSION_TYPE;
        String my_server_name = null;
        String my_sql_collection_name = null;
        String my_sql_table_name = null;
        String my_class_name = null;
        String my_file_name = null;
        String my_command = null;
        String my_userid = null;
        String my_password = null;
        boolean call_main = false;
        
        // Get our arguments */
        System.err.println("Option count is " + args.optionCount() + "\n");
        
        // Loop through options */
        for (int i = 0; i < args.optionCount(); i++) {
            System.err.println("Evaluting option number " + i);
            a = args.nthOption(i);
            System.err.println("Evaluating option " + a.option + " " + a.argument);
            if (a.option.equals("-s")) {
                my_server_name = a.argument.trim();
                System.out.println("Server is " + my_server_name);
            }
            else if (a.option.equals("-u")) {
                my_userid = a.argument.trim();
                System.out.println("User id is " + my_userid);
            }
            else if (a.option.equals("-p")) {
                my_password = a.argument.trim();
                System.out.println("Password is " + my_password);
            }
            else if (a.option.equals("-c")) {
                my_sql_collection_name = a.argument.trim();
                System.out.println("Collection is " + my_sql_collection_name);
            }
            else if (a.option.equals("-t")) {
                my_sql_table_name = a.argument.trim();
                System.out.println("Table is " + my_sql_table_name);
            }
            else if (a.option.equals("-n")) {
                my_class_name = a.argument.trim();
                System.out.println("Class is " + my_class_name);
            }
            else if (a.option.equals("-f")) {
                my_file_name = a.argument.trim();
                System.out.println("File is " + my_file_name);
            }
            else if (a.option.equals("-m")) {
                call_main = true;
            }
            else if (a.option.equals("-y")) {
                try {
                    my_session_type = Integer.parseInt(a.argument.trim());
                    System.out.println("Session type is " + my_session_type);
                }
                catch(NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            else if (a.option.equals("-x")) {
                my_command = a.argument.trim();
            }
            else {
                System.err.println("Bad option " + a.option + " " + a.argument);
                usage();
                System.exit(-1);
            }
        }
        System.out.println("Arguments all evaluted. Ready to call:");
        System.out.println
        (
        "test_me (" + my_server_name
        + ", " + my_sql_collection_name
        + ", " + my_sql_table_name
        + ", " + my_class_name
        + ", " + my_file_name
        + ", " + my_session_type
        + ", " + my_command
        + ", " + call_main
        + ")"
        );
        
        try {
            test_me // Execute self test
            (
            my_server_name
            , my_userid
            , my_password
            , my_sql_collection_name
            , my_sql_table_name
            , my_class_name
            , my_file_name
            , my_session_type
            , my_command
            , call_main
            );
        }
        
        finally {
            System.gc();
        }
        
        System.exit(0);
    }
}
