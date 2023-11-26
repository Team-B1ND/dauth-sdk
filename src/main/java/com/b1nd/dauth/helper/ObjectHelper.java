package com.b1nd.dauth.helper;

import com.b1nd.dauth.DAuthException;
import com.b1nd.dauth.util.Assert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public final class ObjectHelper {

    public static final ObjectHelper INSTANCE = new ObjectHelper();
    private static final ObjectMapper mapper = new ObjectMapper();

    private ObjectHelper() {
    }

    public <T> T convert(final String response, final Class<T> target) {
        try {
            return mapper.readValue(response, target);
        } catch (JsonProcessingException e) {
            throw new DAuthException(500);
        }
    }

    public ObjectNode createNode(final String... keyValuePairs) {
        Assert.notOdd(keyValuePairs.length, "Pairs");

        final ObjectNode node = mapper.createObjectNode();

        return fillOut(node, keyValuePairs);
    }

    private ObjectNode fillOut(final ObjectNode node, final String... keyValuePairs) {
        for (int i = 0; i<keyValuePairs.length; i+=2) {
            node.put(keyValuePairs[i], keyValuePairs[i+1]);
        }

        return node;
    }

}