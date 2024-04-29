package com.b1nd.dauth.client;

import com.b1nd.dauth.util.Assert;

public class Client {

    private final String id;
    private final String secret;

    Client(final String id, final String secret) {
        Assert.notBlank(id, "ClientId");
        Assert.notBlank(secret, "ClientSecret");

        this.id = id;
        this.secret = secret;
    }

    public String id() {
        return id;
    }

    public String secret() {
        return secret;
    }

}
