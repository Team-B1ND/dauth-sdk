package com.b1nd.dauth.client;

import com.b1nd.dauth.util.Assert;

public class ServerUri {

    private final String tokenServer;
    private final String reissueTokenServer;
    private final String userServer;

    ServerUri(final String tokenServer, final String reissueTokenServer, final String userServer) {
        Assert.notBlank(tokenServer, "TokenServerUri");
        Assert.notBlank(reissueTokenServer, "ReissueTokenServerUri");
        Assert.notBlank(userServer, "UserServerUri");

        this.tokenServer = tokenServer;
        this.reissueTokenServer = reissueTokenServer;
        this.userServer = userServer;
    }

    public String tokenServer() {
        return tokenServer;
    }

    public String reissueTokenServer() {
        return reissueTokenServer;
    }

    public String userServer() {
        return userServer;
    }

}