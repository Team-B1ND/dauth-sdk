package com.b1nd.dauth.client;

enum DodamUri {

    RESOURCE_SERVER("http://open.dodam.b1nd.com/api"),
    AUTH_SERVER("https://dauth.b1nd.com/api");

    private final String value;

    DodamUri(final String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }

}
