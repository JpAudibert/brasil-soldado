package com.brasilsoldado.model;

public class PersonWarning {

    private int idPersonWarning;
    private int fkPersonId;
    private int fkWarningId;

    public int getIdPersonWarning() {
        return idPersonWarning;
    }

    public void setIdPersonWarning(int idPersonWarning) {
        this.idPersonWarning = idPersonWarning;
    }

    public int getFkPersonId() {
        return fkPersonId;
    }

    public void setFkPersonId(int fkPersonId) {
        this.fkPersonId = fkPersonId;
    }

    public int getFkWarningId() {
        return fkWarningId;
    }

    public void setFkWarningId(int fkWarningId) {
        this.fkWarningId = fkWarningId;
    }

}
