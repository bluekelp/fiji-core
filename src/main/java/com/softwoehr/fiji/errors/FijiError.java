package com.softwoehr.fiji.errors;

public class FijiError extends RuntimeException {
    public FijiError(String s, Throwable t) {
        super(s, t);
    }
}
