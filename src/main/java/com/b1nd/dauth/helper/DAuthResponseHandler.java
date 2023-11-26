package com.b1nd.dauth.helper;

import com.b1nd.dauth.DAuthException;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public final class DAuthResponseHandler implements HttpClientResponseHandler<String> {

    public static final HttpClientResponseHandler<String> INSTANCE = new DAuthResponseHandler();

    private DAuthResponseHandler() {
    }

    @Override
    public String handleResponse(final ClassicHttpResponse response) throws IOException {
        final int status = response.getCode();

        if(status>=400) {
            throw new DAuthException(status);
        }

        final InputStream inputStream = response.getEntity().getContent();

        return new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));
    }

}