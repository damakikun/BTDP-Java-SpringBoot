package com.learning.sax;

import java.util.jar.Attributes.Name;

public class User {
    int id;
    private String Name;
    private String Gender;
    private String role;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User{").append("id=").append(id)
                .append(", Name=").append(Name)
                .append(", Gender=").append(Gender)
                .append(", role=").append(role).append("}");

        return builder.toString();
    }
}
