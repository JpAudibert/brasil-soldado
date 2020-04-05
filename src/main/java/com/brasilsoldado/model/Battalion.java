package com.brasilsoldado.model;

public class Battalion {

    private int idBattalion;
    private int qttMembers;
    private int idPersonResponsible;
    private int fkCityId;

    public int getIdBattalion() {
        return idBattalion;
    }

    public void setIdBattalion(int idBattalion) {
        this.idBattalion = idBattalion;
    }

    public int getQttMembers() {
        return qttMembers;
    }

    public void setQttMembers(int qttMembers) {
        this.qttMembers = qttMembers;
    }

    public int getIdPersonResponsible() {
        return idPersonResponsible;
    }

    public void setIdPersonResponsible(int idPersonResponsible) {
        this.idPersonResponsible = idPersonResponsible;
    }

    public int getFkCityId() {
        return fkCityId;
    }

    public void setFkCityId(int fkCityId) {
        this.fkCityId = fkCityId;
    }

}
