package com.rentakar.model;

public class Vehicule {
    private int id;
    private String model;
    private String color;
    private String type;
    private int km;


    public Vehicule(int id, String model, String color, String type, int km) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.type = type;
        this.km = km;
    }

    public Vehicule() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }


}
