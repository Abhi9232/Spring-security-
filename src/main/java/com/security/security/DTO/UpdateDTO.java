package com.security.security.DTO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationAotProcessor;

public class UpdateDTO {
    private   String  firstName;

    private  String lastName;
     private  String email;

     private  String password;

    public UpdateDTO(String firstName, String lastName, String email ,String  password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UpdateDTO() {
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

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
