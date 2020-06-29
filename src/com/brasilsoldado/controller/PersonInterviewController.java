/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brasilsoldado.controller;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.interfaces.IBasicController;
import com.brasilsoldado.model.Interview;
import com.brasilsoldado.model.PersonInterview;
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
public class PersonInterviewController implements IBasicController<PersonInterview>{

    private ResultSet result;
    final private String tableName = "\"personInterview\"";
    
    @Override
    public ArrayList<PersonInterview> index() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonInterview show(int id) {
        PersonInterview personInterview = null;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM " + tableName + " WHERE fkPersonId = " + id + " LIMIT 1";

            result = stmt.executeQuery(query);

            if (result.next()) {
                personInterview = new PersonInterview();
                personInterview.setIdPersonInterview(result.getInt("idpersoninterview"));
                personInterview.setFkPersonId(result.getInt("fkpersonid"));
                personInterview.setFkInterviewId(result.getInt("fkinterviewid"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonInterviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personInterview;
    }

    public Interview showInterview(int id) {
        Interview interview = null;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT i.idinterview, i.report FROM interview i INNER JOIN " + tableName + " pi ON pi.fkinterviewid = i.idinterview WHERE pi.fkpersonid = " + id + " LIMIT 1";

            result = stmt.executeQuery(query);

            if (result.next()) {
                interview = new Interview();
                interview.setIdInterview(result.getInt("idinterview"));
                interview.setReport(result.getString("report"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonInterviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return interview;
    }
    
    @Override
    public boolean store(PersonInterview personInter) {
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " INSERT INTO " + tableName + " VALUES("
                    + "DEFAULT,"
                    + "\'" + personInter.getFkPersonId() + "\',"
                    + "\'" + personInter.getFkInterviewId() + "\'"
                    + ")";

            System.out.println(query);
            stmt.execute(query);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonInterviewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean update(PersonInterview o, int id) {
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
            Logger.getLogger(PersonInterviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
