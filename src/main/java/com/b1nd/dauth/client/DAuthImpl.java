package com.b1nd.dauth.client;

import com.b1nd.dauth.DAuth;
import com.b1nd.dauth.client.response.DAuthTokenInfo;
import com.b1nd.dauth.client.response.DAuthAccessTokenInfo;
import com.b1nd.dauth.client.response.DAuthUserInfo;
import com.b1nd.dauth.helper.HttpProcessor;
import com.b1nd.dauth.util.ObjectUtil;
import com.b1nd.dauth.util.HttpRequestUtil;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.hc.core5.http.*;

import static com.b1nd.dauth.client.DodamUri.*;

public class DAuthImpl implements DAuth {

    private final HttpProcessor httpProcessor;
    private final Client client;
    private static final String REFRESH = "/refresh";

    DAuthImpl(final HttpProcessor httpProcessor, final Client client) {
        this.httpProcessor = httpProcessor;
        this.client = client;
    }

    @Override
    public DAuthTokenInfo issueToken(final String code) {
        final ObjectNode node = ObjectUtil.createNode("code", code, "client_id", client.id(), "client_secret", client.secret());

        final ClassicHttpRequest request = HttpRequestUtil.create(TOKEN_SERVER.get(), node);

        return httpProcessor.execute(request, DAuthTokenInfo.class);
    }

    @Override
    public DAuthAccessTokenInfo reissueAccessToken(final String refreshToken) {
        final ObjectNode node = ObjectUtil.createNode("refreshToken", refreshToken, "clientId", client.id());

        final String reissueAccessTokenUri = TOKEN_SERVER.get() + REFRESH;

        final ClassicHttpRequest request = HttpRequestUtil.create(reissueAccessTokenUri, node);

        return httpProcessor.execute(request, DAuthAccessTokenInfo.class);
    }

    @Override
    public DAuthUserInfo getUser(final String accessToken) {
        final ClassicHttpRequest request = HttpRequestUtil.create(USER_SERVER.get(), accessToken);

        return httpProcessor.execute(request, DAuthUserInfo.class);
    }

}
