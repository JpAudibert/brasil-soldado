package com.brasilsoldado.controller;

import com.brasilsoldado.interfaces.BasicController;
import com.brasilsoldado.model.State;
import java.util.ArrayList;

public class StateController implements BasicController {

    @Override
    public ArrayList<Object> index() {
        ArrayList<Object> statesArray = new ArrayList<>();
        State state = new State();
        statesArray.add(state);
        return statesArray;
    }

    @Override
    public boolean store() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
