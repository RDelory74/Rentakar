package com.rentakar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;


//@JsonFilter("monFiltreDynamique")
@Entity
public class User {
    //Attributs
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "licence_id")
    private int licenceid;
    @Column(name = "licence_year")
    private LocalDate licenceyear;
    @Column(name = "Date_Of_Birth")
    private LocalDate dateOfBirth;
    @Column(name = "address")
    private String address;
    @Column(name = "post_code")
    private String postCode;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private int phone;
    @Column(name = "role")
    private String role;
    @Column(name = "password")
    private int password;
    @Column(name = "has_order_id")
    private int orderId;
    @Column(name = "has_vehicule_id")
    private int vehiculeId;


    // Constructeur
    public User() {

    }

    public User(int id, String username, String firstname, int licenceid, LocalDate licenceyear, LocalDate dateOfBirth, String address, String postCode, String email, int phone, String role, int password, int orderId, int vehiculeId) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.licenceid = licenceid;
        this.licenceyear = licenceyear;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.postCode = postCode;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.password = password;
        this.orderId = orderId;
        this.vehiculeId = vehiculeId;
    }


    //Getter
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getLicenceid() {
        return licenceid;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLicenceid(int licenceid) {
        this.licenceid = licenceid;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getLicenceyear() {
        return licenceyear;
    }

    public void setLicenceyear(LocalDate licenceyear) {
        this.licenceyear = licenceyear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getVehiculeId() {
        return vehiculeId;
    }

    public void setVehiculeId(int vehiculeId) {
        this.vehiculeId = vehiculeId;
    }

    // Methodes Specifiques
    public String toString() {
        return "User{" +
                "|| Id = " + id +
                "|| Prénom = " + username +
                "|| Nom = " + firstname +
                "|| Date de naissance = " + dateOfBirth +
                "|| N° de Permis = " + licenceid +
                '}';
    }
}
