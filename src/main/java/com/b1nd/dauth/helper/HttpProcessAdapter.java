package com.b1nd.dauth.helper;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.util.Timeout;

import java.io.IOException;

public final class HttpProcessAdapter extends HttpProcessor {

    private static final HttpClient httpClient;

    static {
        httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectionRequestTimeout(Timeout.ofSeconds(5L))
                        .setResponseTimeout(Timeout.ofSeconds(5L))
                        .build())
                .build();
    }

    @Override
    public String send(final ClassicHttpRequest request) {
        try {
            return httpClient.execute(request, DAuthResponseHandler.INSTANCE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T convert(final String response, final Class<T> target) {
        return ObjectHelper.INSTANCE.convert(response, target);
    }

}