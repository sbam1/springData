package com.suseelbam.javatutorials.springData.entities;


import javax.persistence.*;

@Entity
public class Users extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "USERS_ID")
    private long id;

    private String userName;
    private String email;

    @OneToOne
    private Address address;

    public Users() {
    }

    public Users(String userName, String email, Address address) {
        this.userName = userName;
        this.email = email;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
