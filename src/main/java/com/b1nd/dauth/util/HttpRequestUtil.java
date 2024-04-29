package com.b1nd.dauth.util;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

public abstract class HttpRequestUtil {

    public static ClassicHttpRequest create(final String uri, final ObjectNode node) {
        return ClassicRequestBuilder.post()
                .setUri(uri)
                .setEntity(toEntity(node))
                .build();
    }

    public static ClassicHttpRequest create(final String uri, final String accessToken) {
        return ClassicRequestBuilder.get()
                .setUri(uri)
                .setHeader("Authorization", "Bearer " + accessToken)
                .build();
    }

    private static StringEntity toEntity(final ObjectNode node) {
        return new StringEntity(node.toString(), ContentType.APPLICATION_JSON);
    }

}
