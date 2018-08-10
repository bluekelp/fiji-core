package com.bluekelp.fiji.embed;

import com.bluekelp.fiji.core.Interpreter;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.function.Function;

@SuppressWarnings("unused")
public class Embedded {
    private PrintStream errorStream;
    private Interpreter interpreter;

    public Embedded(PrintStream out, PrintStream err) {
        this(out, err, x -> "");
    }

    @SuppressWarnings("WeakerAccess")
    public Embedded(PrintStream out, PrintStream err, Function<String, String> loader) {
        this.errorStream = err;

        try {
            interpreter = new Interpreter(errorStream, out, loader);
        } catch (Exception e) {
            throw error(e);
        }
    }

    public boolean run(String... ss)
    {
        for (String s : ss) {
            if (interpreter.interpret(s))
                return false;
        }

        return true;
    }

    /**
     * Returns a deaf PrintSteam which ignores all output
     */
    @SuppressWarnings("WeakerAccess")
    public PrintStream deafStream() {
        OutputStream deaf = new OutputStream() {
            public void write(int b) { }
        };

        return new PrintStream(deaf);
    }

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