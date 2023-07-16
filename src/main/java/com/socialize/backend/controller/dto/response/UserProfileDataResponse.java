package com.socialize.backend.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.socialize.backend.controller.dto.base.BaseAccountResponse;

import java.util.Calendar;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileDataResponse extends BaseAccountResponse {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String country;
    private String description;
    private Calendar birthDate;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "UserProfileDataResponse{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
