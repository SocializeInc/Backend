package com.socialize.backend.bl.dto.response;

import java.util.Calendar;
import java.util.List;

public class LoginResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String country;
    private String description;
    private Calendar birthDate;
    private Calendar createDate;
    private List<String> roles;

    public LoginResponse(String accessToken, Long id, String username, String firstname, String lastname,
                         String email, String country, String description, Calendar birthDate, Calendar createDate,
                         List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.country = country;
        this.description = description;
        this.birthDate = birthDate;
        this.createDate = createDate;
        this.roles = roles;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", birthDate=" + birthDate +
                ", createDate=" + createDate +
                ", roles=" + roles +
                '}';
    }
}