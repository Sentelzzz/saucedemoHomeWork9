package org.example.model;

public class User {

    private String name = "standard_user";
    private String password = "secret_sauce";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
