package com.haristallat2001.recyler_view;

import java.math.BigInteger;

public class person {

    String name, email, address, DOB,number;


    public person(String nameii, String emailii, String addressii, String dobii) {

    }

    public person(String name, String email, String address, String DOB, String number) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.number = number;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", DOB='" + DOB + '\'' +
                ", number=" + number +
                '}';
    }
}
