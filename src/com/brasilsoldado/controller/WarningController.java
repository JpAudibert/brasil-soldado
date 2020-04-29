/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brasilsoldado.controller;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.interfaces.IBasicController;
import com.brasilsoldado.model.State;
import com.brasilsoldado.model.Warning;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaopedro
 */
public class WarningController implements IBasicController<Warning> {

    private ResultSet result;

    @Override
    public ArrayList<Warning> index() {
        ArrayList warnings = new ArrayList<Warning>();
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM warning ORDER BY name";

            result = stmt.executeQuery(query);
            for (int i = 0; result.next(); i++) {
                Warning newWarning = new Warning(i + 1, result.getString("message"));
                warnings.add(newWarning);
            }

        } catch (SQLException ex) {
            Logger.getLogger(WarningController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return warnings;
    }

    @Override
    public ArrayList<Warning> show(int id) {
        ArrayList warnings = new ArrayList<Warning>();
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM warning WHERE idwarning = " + id;

            result = stmt.executeQuery(query);
            for (int i = 0; result.next(); i++) {
                Warning newWarning = new Warning(i + 1, result.getString("message"));
                warnings.add(newWarning);
            }

        } catch (SQLException ex) {
            Logger.getLogger(WarningController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return warnings;
    }

    @Override
    public boolean store(Warning warning) {
        boolean response = false;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " INSERT INTO warning VALUES("
                    + "DEFAULT,"
                    + "\'" + warning.getMessage() + "\'"
                    + ")";

            System.out.println(query);

            if (stmt.execute(query)) {
                response = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WarningController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }

    @Override
    public boolean update(Warning warning, int id) {
        boolean response = false;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " UPDATE warning SET "
                    + "name = '" + warning.getMessage()+ "'"
                    + "WHERE idwarning = " + id;

            System.out.println(query);

            if (stmt.execute(query)) {
                response = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WarningController.class.getName()).log(Level.SEVERE, null, ex);
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

            String query = " DELETE FROM warning WHERE idwarning = " + id;

            if (stmt.execute(query)) {
                response = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

}
