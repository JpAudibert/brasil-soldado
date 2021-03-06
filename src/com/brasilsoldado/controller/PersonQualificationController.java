/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brasilsoldado.controller;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.interfaces.IBasicController;
import com.brasilsoldado.model.PersonQualification;
import com.brasilsoldado.model.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deusjp
 */
public class PersonQualificationController implements IBasicController<PersonQualification> {

    private ResultSet result;
    final private String tableName = "\"personQualification\"";

    @Override
    public ArrayList<PersonQualification> index() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonQualification show(int id) {
        PersonQualification personQualification = null;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM " + tableName + " WHERE fkPersonId = " + id + " LIMIT 1";

            result = stmt.executeQuery(query);

            if (result.next()) {
                personQualification = new PersonQualification();
                personQualification.setIdPersonQualification(result.getInt("idpersonqualification"));
                personQualification.setFkPersonId(result.getInt("fkpersonid"));
                personQualification.setFkQualificationId(result.getInt("fkqualificationid"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonQualificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personQualification;
    }

    @Override
    public boolean store(PersonQualification personQuali) {
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " INSERT INTO " + tableName + " VALUES("
                    + "DEFAULT,"
                    + "\'" + personQuali.getFkPersonId() + "\',"
                    + "\'" + personQuali.getFkQualificationId() + "\'"
                    + ")";

            System.out.println(query);
            stmt.execute(query);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonQualificationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean update(PersonQualification personQuali, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " DELETE FROM " + tableName + " WHERE fkPersonId = " + id;

            System.out.println(query);
            stmt.execute(query);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonQualificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
