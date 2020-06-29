package com.brasilsoldado.model;

public class PersonInterview {

    private int idPersonInterview;
    private int fkPersonId;
    private int fkInterviewId;

    public PersonInterview(int idPersonInterview, int fkPersonId, int fkInterviewId) {
        this.idPersonInterview = idPersonInterview;
        this.fkPersonId = fkPersonId;
        this.fkInterviewId = fkInterviewId;
    }

    public PersonInterview() {
    }

    public int getIdPersonInterview() {
        return idPersonInterview;
    }

    public void setIdPersonInterview(int idPersonInterview) {
        this.idPersonInterview = idPersonInterview;
    }

    public int getFkPersonId() {
        return fkPersonId;
    }

    public void setFkPersonId(int fkPersonId) {
        this.fkPersonId = fkPersonId;
    }

    public int getFkInterviewId() {
        return fkInterviewId;
    }

    public void setFkInterviewId(int fkInterviewId) {
        this.fkInterviewId = fkInterviewId;
    }

}
