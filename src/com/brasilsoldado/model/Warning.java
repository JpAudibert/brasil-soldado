package com.brasilsoldado.model;

public class Warning {

    private int idWarning;
    private String title;
    private String message;

    public Warning() {
    }

    public Warning(int idWarning, String title, String message) {
        this.idWarning = idWarning;
        this.title = title;
        this.message = message;
    }

    public int getIdWarning() {
        return idWarning;
    }

    public void setIdWarning(int idWarning) {
        this.idWarning = idWarning;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
