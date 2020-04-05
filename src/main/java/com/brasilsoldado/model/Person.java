package com.brasilsoldado.model;

import java.sql.Date;

public class Person {

    private int idPerson;
    private String name;
    private String surname;
    private Date birthday;
    private int cpf;
    private String email;
    private int type;
    private boolean enabled;
    private String momsName;
    private String dadsName;
    private int fkCityId;

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getMomsName() {
        return momsName;
    }

    public void setMomsName(String momsName) {
        this.momsName = momsName;
    }

    public String getDadsName() {
        return dadsName;
    }

    public void setDadsName(String dadsName) {
        this.dadsName = dadsName;
    }

    public int getFkCityId() {
        return fkCityId;
    }

    public void setFkCityId(int fkCityId) {
        this.fkCityId = fkCityId;
    }

}
