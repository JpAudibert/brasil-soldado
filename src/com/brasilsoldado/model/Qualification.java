package com.brasilsoldado.model;

public class Qualification {

    private int idQualification;
    private String type;
    private boolean hasQualification;

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

    public boolean isHasQualification() {
        return hasQualification;
    }

    public void setHasQualification(boolean hasQualification) {
        this.hasQualification = hasQualification;
    }

}
