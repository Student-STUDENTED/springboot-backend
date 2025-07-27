package com.example.springboot_backend.entities; // ✅ Java package names should be lowercase

import jakarta.persistence.*;

@Entity
@Table(name = "users") // ✅ Explicit table name is good practice
public class User { // ✅ Renamed from `Users` to `User` (Java class names should be singular)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // ✅ Added column name explicitly for clarity (optional but recommended)
    private int id;

    @Column(name = "name") // ✅ Makes DB mapping clear
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    // ✅ Getter and setter methods follow standard naming conventions (no change needed)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
