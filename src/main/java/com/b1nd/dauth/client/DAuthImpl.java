package com.b1nd.dauth.client;

import com.b1nd.dauth.DAuth;
import com.b1nd.dauth.client.response.DAuthTokenInfo;
import com.b1nd.dauth.client.response.DAuthAccessTokenInfo;
import com.b1nd.dauth.client.response.DAuthUserInfo;
import com.b1nd.dauth.helper.HttpProcessAdapter;
import com.b1nd.dauth.helper.HttpProcessor;
import com.b1nd.dauth.helper.ObjectHelper;
import com.b1nd.dauth.util.HttpRequestUtil;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.hc.core5.http.*;

public class DAuthImpl implements DAuth {

    private static final HttpProcessor httpProcessor = new HttpProcessAdapter();
    private final Client client;
    private final ServerUri serverUri;

    DAuthImpl(final Client client, final ServerUri serverUri) {
        this.client = client;
        this.serverUri = serverUri;
    }

    @Override
    public DAuthTokenInfo issueToken(final String code) {
        final ObjectNode node = ObjectHelper.INSTANCE.createNode("code", code, "client_id", client.id(), "client_secret", client.secret());

        final ClassicHttpRequest request = HttpRequestUtil.create(serverUri.tokenServer(), node);

        return httpProcessor.execute(request, DAuthTokenInfo.class);
    }

    @Override
    public DAuthAccessTokenInfo reissueAccessToken(final String refreshToken) {
        final ObjectNode node = ObjectHelper.INSTANCE.createNode("refreshToken", refreshToken, "clientId", client.id());

        final ClassicHttpRequest request = HttpRequestUtil.create(serverUri.reissueTokenServer(), node);

        return httpProcessor.execute(request, DAuthAccessTokenInfo.class);
    }

    @Override
    public DAuthUserInfo getUser(final String accessToken) {
        final ClassicHttpRequest request = HttpRequestUtil.create(serverUri.userServer(), accessToken);

        return httpProcessor.execute(request, DAuthUserInfo.class);
    }

}