package com.example.Spring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="user1")
public class User {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="Name")
    private String name;

    @Column(name="Email")
    private String email;

    @Column(name="Mobile_Number")
    private String phone;

    @Column(name="Address")
    private String address;

    @Column(name="PinCode")
    private String pinCode;

    @Column(name="State")
    private String state;

    @Column(name="Password")
    private String pass;

    public User() {
    }

    public User(String name, String email, String phone, String address, String pinCode, String state,
            String pass) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.pinCode = pinCode;
        this.state = state;
        this.pass = pass;
    }

    public int getId() {
        return id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address
                + ", pinCode=" + pinCode + ", state=" + state + ", pass=" + pass + "]";
    }

    



}
