package com.softwoehr.fiji.embed;

import com.softwoehr.fiji.core.Interpreter;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.function.Function;

@SuppressWarnings("unused")
public class Embedded {
    public void run(String... ss) {
        run(deafStream(), deafStream(), ss);
    }

    public void run(PrintStream outputStream, PrintStream errorStream, String... ss)
    {
        Interpreter i;

        this.errorStream = errorStream;

        try {
            i = new Interpreter(errorStream, outputStream, loader);
        } catch (Exception e) {
            throw error(e);
        }

        for (String s : ss) {
            if (i.interpret(s))
                break;
        }
    }

    /**
     * Returns a deaf PrintSteam which ignores all output
     */
    @SuppressWarnings("WeakerAccess")
    public PrintStream deafStream() {
        OutputStream deaf = new OutputStream() {
            public void write(int b) {
            }
        };

        return new PrintStream(deaf);
    }

    private PrintStream errorStream;

    private String load(String fn) {
        return "";
    }

    private Function<String, String> loader = this::load;

    private RuntimeException error(String s) {
        return error(s, null);
    }

    private RuntimeException error(Exception e) {
        return error(null, e);
    }

    private RuntimeException error(String s, Exception e) {
        if (s != null) {
            errorStream.println(s);
        }
        if (e != null) {
            e.printStackTrace(errorStream);
        }
        return new RuntimeException(s, e);
    }

}
