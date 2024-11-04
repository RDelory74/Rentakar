package com.rentakar.exceptions;

public class LicenseNotValid extends RuntimeException {
    public LicenseNotValid(String message) {
        super(message);
    }
}
