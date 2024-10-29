package com.RentaKar.rentakar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


//@JsonFilter("monFiltreDynamique")
@Entity
public class User {
    //Attributs
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "firstname",nullable = false)
    private String firstname;
    @Column(name = "licence_id")
    private int licenceid;
    @Column(name = "Date_Of_Birth")
    private String dateOfBirth;

    // Constructeur
    public User() {

    }

    public User(int id, String username, String firstname, int licenceid, String dateOfBirth) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.licenceid = licenceid;
        this.dateOfBirth = dateOfBirth;
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

    public String getDateOfBirth() {
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

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
