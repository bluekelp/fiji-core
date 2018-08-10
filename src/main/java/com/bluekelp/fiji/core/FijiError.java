package com.bluekelp.fiji.core;

public class FijiError extends RuntimeException {
    public FijiError(String s, Throwable t) {
        super(s, t);
    }
}
