package com.rentakar.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
    private int id;
    private int userId;
    private int vehiculeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private double amount;

    public Order(int id, int userId, int vehiculeId, LocalDate startDate, LocalDate endDate, double amount) {
        this.id = id;
        this.userId = userId;
        this.vehiculeId = vehiculeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVehiculeId() {
        return vehiculeId;
    }

    public void setVehiculeId(int vehiculeId) {
        this.vehiculeId = vehiculeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
