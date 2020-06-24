package com.brasilsoldado.model;

public class Inspection {
    private int idinspection;
    private double headSize;
    private double height;
    private double weight;
    private double footSize;
    private double weightLifted;
    private boolean isHealthy;
    private String report;
    private int fkPersonId;

    public Inspection(int idinspection, double headSize, double height, double weight, double footSize, double weightLifted, boolean isHealthy, String report, int fkPersonId) {
        this.idinspection = idinspection;
        this.headSize = headSize;
        this.height = height;
        this.weight = weight;
        this.footSize = footSize;
        this.weightLifted = weightLifted;
        this.isHealthy = isHealthy;
        this.report = report;
        this.fkPersonId = fkPersonId;
    }

    public Inspection() {
    }

    public int getIdinspection() {
        return idinspection;
    }

    public void setIdinspection(int idinspection) {
        this.idinspection = idinspection;
    }

    public double getHeadSize() {
        return headSize;
    }

    public void setHeadSize(double headSize) {
        this.headSize = headSize;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weitght) {
        this.weight = weitght;
    }

    public double getFootSize() {
        return footSize;
    }

    public void setFootSize(double footSize) {
        this.footSize = footSize;
    }

    public double getWeightLifted() {
        return weightLifted;
    }

    public void setWeightLifted(double weightLifted) {
        this.weightLifted = weightLifted;
    }

    public boolean isIsHealthy() {
        return isHealthy;
    }

    public void setIsHealthy(boolean isHealthy) {
        this.isHealthy = isHealthy;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public int getFkPersonId() {
        return fkPersonId;
    }

    public void setFkPersonId(int fkPersonId) {
        this.fkPersonId = fkPersonId;
    }
    
    
}
