package com.b1nd.dauth.client;

import com.b1nd.dauth.DAuth;
import com.b1nd.dauth.client.response.DAuthCodeInfo;
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
    private static final String LOGIN = "/auth/login";
    private static final String ISSUE_TOKEN = "/token";
    private static final String REISSUE_TOKEN = "/token/refresh";
    private static final String USER = "/user";

    DAuthImpl(final HttpProcessor httpProcessor, final Client client) {
        this.httpProcessor = httpProcessor;
        this.client = client;
    }

    @Override
    public DAuthCodeInfo issueCode(String id, String password) {
        final ObjectNode node = ObjectUtil.createNode("id", id, "pw", password, "clientId", client.id(), "redirectUrl", client.redirectUrl());
        final ClassicHttpRequest request = HttpRequestUtil.create(AUTH_SERVER.get() + LOGIN, node);

        return httpProcessor.execute(request, DAuthCodeInfo.class);
    }

    @Override
    public DAuthTokenInfo issueToken(final String code) {
        final ObjectNode node = ObjectUtil.createNode("code", code, "client_id", client.id(), "client_secret", client.secret());
        final String url = AUTH_SERVER.get() + ISSUE_TOKEN;
        final ClassicHttpRequest request = HttpRequestUtil.create(url, node);

        return httpProcessor.execute(request, DAuthTokenInfo.class);
    }

    @Override
    public DAuthAccessTokenInfo reissueAccessToken(final String refreshToken) {
        final ObjectNode node = ObjectUtil.createNode("refreshToken", refreshToken, "clientId", client.id());
        final String url = AUTH_SERVER.get() + REISSUE_TOKEN;
        final ClassicHttpRequest request = HttpRequestUtil.create(url, node);

        return httpProcessor.execute(request, DAuthAccessTokenInfo.class);
    }

    @Override
    public DAuthUserInfo getUser(final String accessToken) {
        final String url = RESOURCE_SERVER.get() + USER;
        final ClassicHttpRequest request = HttpRequestUtil.create(url, accessToken);

        return httpProcessor.execute(request, DAuthUserInfo.class);
    }

}
