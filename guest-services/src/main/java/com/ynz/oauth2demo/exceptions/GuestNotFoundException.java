package com.ynz.oauth2demo.exceptions;

public class GuestNotFoundException extends RuntimeException {
    public GuestNotFoundException(String s) {
        super(s);
    }

    public GuestNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
