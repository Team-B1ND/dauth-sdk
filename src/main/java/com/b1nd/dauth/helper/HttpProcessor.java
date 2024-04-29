package com.b1nd.dauth.helper;

import org.apache.hc.core5.http.ClassicHttpRequest;

public abstract class HttpProcessor {

    public abstract String send(final ClassicHttpRequest request);

    public abstract <T> T convert(final String response, final Class<T> target);

    public <T> T execute(final ClassicHttpRequest request, final Class<T> target) {
        final String response = send(request);

        return convert(response, target);
    }

}
