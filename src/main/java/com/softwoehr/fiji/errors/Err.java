package com.softwoehr.fiji.errors;

public class Err extends RuntimeException {
    public Err(String s, Throwable t) {
        super(s, t);
    }
}
