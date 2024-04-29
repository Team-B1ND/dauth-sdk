package com.b1nd.dauth;

public class DAuthException extends RuntimeException {

    private final int status;

    public DAuthException(final int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
