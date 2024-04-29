package com.b1nd.dauth.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DAuthCodeInfo {

    @JsonProperty("data")
    private Location location;

    public String location() {
        return location.value;
    }

    public String extractCode() {
        return location().split("=")[1].split("&")[0];
    }

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Location {

    @JsonProperty("location")
    String value;

}
