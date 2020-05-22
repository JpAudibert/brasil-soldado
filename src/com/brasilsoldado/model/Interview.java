package com.brasilsoldado.model;

public class Interview {

    private int idInterview;
    private String report;

    public Interview() {
    }

    public Interview(int idInterview, String report) {
        this.idInterview = idInterview;
        this.report = report;
    }

    public int getIdInterview() {
        return idInterview;
    }

    public void setIdInterview(int idInterview) {
        this.idInterview = idInterview;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

}
