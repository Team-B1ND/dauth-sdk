package com.b1nd.dauth;

import com.b1nd.dauth.client.response.DAuthTokenInfo;
import com.b1nd.dauth.client.response.DAuthAccessTokenInfo;
import com.b1nd.dauth.client.response.DAuthUserInfo;

public interface DAuth {

    DAuthTokenInfo issueToken(String code);
    DAuthAccessTokenInfo reissueAccessToken(String refreshToken);
    DAuthUserInfo getUser(String accessToken);

}
