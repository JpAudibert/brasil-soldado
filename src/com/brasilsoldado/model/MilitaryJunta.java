package com.brasilsoldado.model;

public class MilitaryJunta {

    private int idMilitaryJunta;
    private int fkBattalionId;

    public int getIdMilitaryJunta() {
        return idMilitaryJunta;
    }

    public void setIdMilitaryJunta(int idMilitaryJunta) {
        this.idMilitaryJunta = idMilitaryJunta;
    }

    public int getFkBattalionId() {
        return fkBattalionId;
    }

    public void setFkBattalionId(int fkBattalionId) {
        this.fkBattalionId = fkBattalionId;
    }

}
