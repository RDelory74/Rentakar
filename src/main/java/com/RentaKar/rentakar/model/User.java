package com.RentaKar.rentakar.model;

import java.util.Date;
import java.util.UUID;

public class User {
    //Attributs
    private int id;
    private String username;
    private String firstname;
    private int licenceid;
    private String dateOfBirth;

    // Constructeur
    public User(){

    }
    public User(int id,String username, String firstname, int licenceid, String dateOfBirth) {
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
    public String toString(){
        return "User{"+
                "|| Id = "+ id +
                "|| Prénom = "+ username +
                "|| Nom = "+ firstname +
                "|| Date de naissance = " +dateOfBirth+
                "|| N° de Permis = " + licenceid +
                '}';
    }
}
