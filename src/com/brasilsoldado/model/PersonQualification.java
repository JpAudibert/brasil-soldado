package com.brasilsoldado.model;

public class PersonQualification {

    private int IdPersonQualification;
    private int fkPersonId;
    private int fkQualificationId;

    public int getIdPersonQualification() {
        return IdPersonQualification;
    }

    public void setIdPersonQualification(int IdPersonQualification) {
        this.IdPersonQualification = IdPersonQualification;
    }

    public int getFkPersonId() {
        return fkPersonId;
    }

    public void setFkPersonId(int fkPersonId) {
        this.fkPersonId = fkPersonId;
    }

    public int getFkQualificationId() {
        return fkQualificationId;
    }

    public void setFkQualificationId(int fkQualificationId) {
        this.fkQualificationId = fkQualificationId;
    }

}
