package com.b1nd.dauth.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class DAuthUser {

    @JsonProperty("uniqueId")
    private String uniqueId;
    @JsonProperty("grade")
    private Integer grade;
    @JsonProperty("room")
    private Integer room;
    @JsonProperty("number")
    private Integer number;
    @JsonProperty("name")
    private String name;
    @JsonProperty("profileImage")
    private String profileImage;
    @JsonProperty("role")
    private String role;
    @JsonProperty("email")
    private String email;

    public String getUniqueId() {
        return uniqueId;
    }

    public Integer getGrade() {
        return grade;
    }

    public Integer getRoom() {
        return room;
    }

    public Integer getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

}