package com.brasilsoldado.model;

public class City {

    private int idCity;
    private String name;
    private String initials;
    private int fkStateId;

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public int getFkStateId() {
        return fkStateId;
    }

    public void setFkStateId(int fkStateId) {
        this.fkStateId = fkStateId;
    }
}
