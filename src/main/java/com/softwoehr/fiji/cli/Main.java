package com.softwoehr.fiji.cli;

import com.softwoehr.fiji.core.Engine;
import com.softwoehr.fiji.core.Interpreter;

import java.io.*;
import java.util.function.Function;

// launcher for the FIJI interpreter running at the command line.
public class Main {
    public static void main(String argv[]) {
      Main f = new Main();
      f.runner(argv);
    }

    private String load(String fn) throws IOException {
      File file = new File(fn);
      long length = file.length();
      char input[] = new char[(int) length];
      FileInputStream fileInputStream = new FileInputStream(file);
      InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
      int n = inputStreamReader.read(input, 0, (int) length);
      return new String(input);
    }

    private String safeLoad(String fn) {
      try {
        return load(fn);
      } catch (IOException e) {
        return "\" error\" .";
      }
    }

  private Function<String, String> loader = this::safeLoad;

  private RuntimeException error(String s) {
    return error(s, null);
  }

  private RuntimeException error(Exception e) {
    return error(null, e);
  }

  private RuntimeException error(String s, Exception e) {
      if (s != null) {
        System.err.println(s);
      }
      if (e != null) {
        e.printStackTrace(System.err);
      }
      return new RuntimeException(s, e);
  }

  private void runner(String argv[])
    {
      Interpreter i;
      InputStreamReader isr;
      BufferedReader br;
      GetArgs args = new GetArgs(argv);

      try {
        i = new Interpreter(System.err, System.out, loader);
      } catch (Exception e) {
        throw error(e);
      }

      for (Argument a : args.options) {

        if (a.option.equals("-b")) {
          if (a.argument != null ) {
            try {
              i.setBase(Integer.decode(a.argument));
            }
            catch (Exception e) {
              throw error("bad base", e);
            }
          }
          else {
            String s = "(null) presented for Interpreter numeric base.";
            throw error(s, null);
          }
        }
        else if (a.option.equals("-h") || a.option.equals("--")) {
          usage();
          return;
        }
        else {
          usage();
          throw error("Bad option " + a.option + " " + a.argument);
        }
      }

      /* GPL announces itself. */
      System.out.println( "FIJI ForthIsh Java Interpreter "
              + Engine.fijiVersion()
      );
      System.out.println("Copyright (C) 1999, 2001 by Jack J. Woehr.");
      System.out.println("FIJI comes with ABSOLUTELY NO WARRANTY;");
      System.out.println("Please see the file COPYING and/or COPYING.LIB");
      System.out.println("which you should have received with this software.");
      System.out.println("This is free software, and you are welcome to redistribute it");
      System.out.println("under certain conditions enumerated in COPYING and/or COPYING.LIB.");

      try {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
      }
      catch (Exception e) {
        throw error(e);
      }

      for (Argument a : args.arguments) {
        /* Now treat every argument as a file to load. */
        try {
          i.load(a.argument);
        }
        catch (Exception e) {
          e.printStackTrace(System.err);
          break;
        }
      }

      /* Begin to parse interactive input. */
      i.prompt();
      while (true) {
        try {
          String tib = br.readLine();

          boolean stop = i.interpret(tib);
          if (stop) break;
          else i.prompt();
        }
        catch (EOFException e) {
          break;
        }
        catch (IOException e) {
          e.printStackTrace(System.err);
          break;
        }
        catch (Exception e) {
          e.printStackTrace(System.err);
        }
      }
      try {
        br.close();
      }
      catch (Exception e) {
        e.printStackTrace(System.err);
      }
    }

  private void usage() {
    System.err.println("Usage:");
    System.err.println(" java com.softwoehr.fiji.Main [-b base] [-o output_codepage] [file file ...]");
    System.err.println(" -b base            .. where base is numeric input base, e.g. 8 16 0x10 etc.");
    System.err.println(" file file ...      .. these files will be loaded as FIJI source code.");
  }
}