package com.brasilsoldado.model;

import com.brasilsoldado.helpers.Validacao;

public class State {

    private int idState;
    private String name;
    private String initials;

    public State(int idState, String name, String initials) {
        this.idState = idState;
        this.name = name;
        this.initials = initials;
    }

    public State() {
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
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

}
