package com.security.security.DTO;




public class  Register {

    private  String firstName;

    public  String lastName;

    public  String email;

    public  String password;

    public Register(String firstName, String lastName, String email, String password ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password= password;
    }


    public Register() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

