package com.brasilsoldado.model;

public class Warning {

    private int idWarning;
    private String message;

    public Warning() {
    }

    public Warning(int idWarning, String message) {
        this.idWarning = idWarning;
        this.message = message;
    }

    public int getIdWarning() {
        return idWarning;
    }

    public void setIdWarning(int idWarning) {
        this.idWarning = idWarning;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
