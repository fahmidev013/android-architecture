package com.sera.amm.services.authInfoService;


public class SignupModel {
    public String email;
    public String userName;
    public String password;
    public String firstName;
    public String lastName;

    public SignupModel(String email, String userName, String password, String firstName, String lastName) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
