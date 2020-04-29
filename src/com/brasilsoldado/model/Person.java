package com.brasilsoldado.model;

import com.brasilsoldado.helpers.Validacao;
import java.util.Date;
import java.util.Base64;

public class Person {

    private int idPerson;
    private String name;
    private String surname;
    private Date birthday;
    private String cpf;
    private String email;
    private String password;
    private int type;
    private boolean enabled;
    private String momsName;
    private String dadsName;
    private int fkCityId;

    public Person() {
    }

    public Person(int idPerson, String name, String surname, Date birthday, String cpf, String email, String password, int type, boolean enabled, String momsName, String dadsName, int fkCityId) {
        this.idPerson = idPerson;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.type = type;
        this.enabled = enabled;
        this.momsName = momsName;
        this.dadsName = dadsName;
        this.fkCityId = fkCityId;
    }

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
        if (Validacao.notNull(name)) {
            this.name = name;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (Validacao.notNull(surname)) {
            this.surname = surname;
        }
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) { //TODO date validation
        this.birthday = birthday;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (Validacao.validarCPF(cpf)) {
            this.cpf = cpf;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (Validacao.notNull(name)) {
            this.email = email;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Base64.Encoder encoder = Base64.getEncoder();
        password = encoder.encodeToString(password.getBytes());
        this.password = password;
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
