package org.example.model;

public class User {

    private String name = "standard_user";
    private String password = "secret_sauce";

    private String firstName = "Vadim";
    private String lastName = "Vadim";
    private String userZipCode = "225800";

    public String getUserZipCode() {
        return userZipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

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
