package com.b1nd.dauth.client;

enum DodamUri {

    USER_SERVER("http://open.dodam.b1nd.com/api/user"),
    TOKEN_SERVER("http://dauth.b1nd.com/api/token");

    private final String value;

    DodamUri(final String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }

}