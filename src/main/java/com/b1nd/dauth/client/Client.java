package com.b1nd.dauth.client;

import com.b1nd.dauth.util.Assert;

public class Client {

    private final String id;
    private final String secret;
    private final String redirectUrl;

    Client(final String id, final String secret, final String redirectUrl) {
        Assert.notBlank(id, "ClientId");
        Assert.notBlank(secret, "ClientSecret");
        Assert.notBlank(redirectUrl, "RedirectUrl");

        this.id = id;
        this.secret = secret;
        this.redirectUrl = redirectUrl;
    }

    public String id() {
        return id;
    }

    public String secret() {
        return secret;
    }

    public String redirectUrl() {
        return redirectUrl;
    }

}
