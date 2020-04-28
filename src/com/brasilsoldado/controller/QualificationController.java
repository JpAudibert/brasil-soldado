/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brasilsoldado.controller;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.interfaces.IBasicController;
import com.brasilsoldado.model.Qualification;
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
public class QualificationController implements IBasicController<Qualification> {

    private ResultSet result;

    @Override
    public ArrayList<Qualification> index() {
        ArrayList qualifications = new ArrayList<Qualification>();
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM qualification ORDER BY type";

            result = stmt.executeQuery(query);
            for (int i = 0; result.next(); i++) {
                Qualification newQualification = new Qualification(i + 1, result.getString("type"));
                qualifications.add(newQualification);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QualificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qualifications;
    }

    @Override
    public ArrayList<Qualification> show(int id) {
        ArrayList qualification = new ArrayList<Qualification>();
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM qualification WHERE idqualification = " + id;

            result = stmt.executeQuery(query);
            for (int i = 0; result.next(); i++) {
                Qualification newQualification = new Qualification(i + 1, result.getString("type"));
                qualification.add(newQualification);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QualificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qualification;
    }

    @Override
    public boolean store(Qualification quali) {
        boolean response = false;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " INSERT INTO qualification VALUES("
                    + "DEFAULT,"
                    + "\'" + quali.getType() + "\'"
                    + ")";

            System.out.println(query);

            if (stmt.execute(query)) {
                response = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QualificationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }

    @Override
    public boolean update(Qualification quali, int id) {
        boolean response = false;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " UPDATE qualification SET "
                    + "name = '" + quali.getType()+ "' "
                    + "WHERE idqualification = " + id;

            System.out.println(query);

            if (stmt.execute(query)) {
                response = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QualificationController.class.getName()).log(Level.SEVERE, null, ex);
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

            String query = " DELETE FROM qualification WHERE idqualification = " + id;

            if (stmt.execute(query)) {
                response = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QualificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

}
