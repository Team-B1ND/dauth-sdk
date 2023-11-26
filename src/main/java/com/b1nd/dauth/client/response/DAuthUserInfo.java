package com.b1nd.dauth.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class DAuthUserInfo {

    @JsonProperty("data")
    private DAuthUser user;

    public DAuthUser getUser() {
        return user;
    }

}