package com.b1nd.dauth.client;

import com.b1nd.dauth.DAuth;
import com.b1nd.dauth.helper.HttpProcessAdapter;
import com.b1nd.dauth.helper.HttpProcessor;

public final class DAuthBuilder {

    private String clientId;
    private String clientSecret;

    private DAuthBuilder() {
    }

    public static DAuthBuilder create() {
        return new DAuthBuilder();
    }

    public DAuthBuilder clientId(final String clientId) {
        this.clientId = clientId;

        return this;
    }

    public DAuthBuilder clientSecret(final String clientSecret) {
        this.clientSecret = clientSecret;

        return this;
    }

    public DAuth build() {
        final HttpProcessor httpProcessor = new HttpProcessAdapter();
        final Client client = new Client(clientId, clientSecret);

        return new DAuthImpl(httpProcessor, client);
    }

}
