package com.brasilsoldado.model;

public class Qualification {

    private int idQualification;
    private String type;

    public Qualification() {
    }

    public Qualification(int idQualification, String type) {
        this.idQualification = idQualification;
        this.type = type;
    }

    public int getIdQualification() {
        return idQualification;
    }

    public void setIdQualification(int idQualification) {
        this.idQualification = idQualification;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
