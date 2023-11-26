package com.b1nd.dauth.client;

import com.b1nd.dauth.DAuth;

public final class DAuthBuilder {

    private String clientId;
    private String clientSecret;
    private String tokenServerUri;
    private String reissueTokenServerUri;
    private String userServerUri;

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

    public DAuthBuilder tokenServerUri(final String uri) {
        tokenServerUri = uri;

        return this;
    }

    public DAuthBuilder reissueTokenServerUri(final String uri) {
        reissueTokenServerUri = uri;

        return this;
    }

    public DAuthBuilder userServerUri(final String uri) {
        userServerUri = uri;

        return this;
    }

    public DAuth build() {
        final Client client = new Client(clientId, clientSecret);
        final ServerUri serverUri = new ServerUri(tokenServerUri, reissueTokenServerUri, userServerUri);

        return new DAuthImpl(client, serverUri);
    }

}