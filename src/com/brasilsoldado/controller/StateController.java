package com.brasilsoldado.controller;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.interfaces.IBasicController;
import com.brasilsoldado.model.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StateController implements IBasicController<State> {

    private ResultSet result;

    @Override
    public ArrayList<State> index() {
        ArrayList states = new ArrayList<State>();
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM state ORDER BY name";

            result = stmt.executeQuery(query);
            for (int i = 0; result.next(); i++) {
                State newState = new State(i + 1, result.getString("name"), result.getString("initials"));
                states.add(newState);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return states;
    }

    @Override
    public ArrayList<State> show(int id) {
        ArrayList states = new ArrayList<State>();
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM state WHERE idstate = " + id;

            result = stmt.executeQuery(query);
            for (int i = 0; result.next(); i++) {
                State newState = new State(i + 1, result.getString("name"), result.getString("initials"));
                states.add(newState);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return states;
    }

    @Override
    public boolean store(State state) {
        boolean response = false;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " INSERT INTO state VALUES("
                    + "DEFAULT,"
                    + "\'" + state.getName() + "\',"
                    + "\'" + state.getInitials() + "\'"
                    + ")";

            System.out.println(query);

            if (stmt.execute(query)) {
                response = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }

    @Override
    public boolean update(State state, int id) {
        boolean response = false;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " UPDATE state SET "
                    + "name = '" + state.getName() + "',"
                    + "initials = '" + state.getInitials() + "' "
                    + "WHERE idstate = " + id;

            System.out.println(query);

            if (stmt.execute(query)) {
                response = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }

    @Override
    public boolean delete(int id) {
        boolean response = false;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " DELETE FROM state WHERE idstate = " + id;

            result = stmt.executeQuery(query);

            response = true;
        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

}
