package com.brasilsoldado.controller;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.interfaces.IBasicController;
import com.brasilsoldado.model.Inspection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InspectionController implements IBasicController<Inspection> {

    private ResultSet result;

    @Override
    public ArrayList<Inspection> index() {
        ArrayList inspections = new ArrayList<Inspection>();
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM inspection ORDER BY idinspection";

            result = stmt.executeQuery(query);
            for (int i = 0; result.next(); i++) {
                Inspection newInspection
                        = new Inspection(
                                i + 1,
                                result.getDouble("headSize"),
                                result.getDouble("height"),
                                result.getDouble("weight"),
                                result.getDouble("footSize"),
                                result.getDouble("weightLifted"),
                                result.getBoolean("isHealthy"),
                                result.getString("report"),
                                result.getInt("year"),
                                result.getInt("fkPersonId"));
                inspections.add(newInspection);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inspections;
    }

    @Override
    public Inspection show(int id) {
        Inspection inspection = null;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM inspection WHERE idinpsection = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                inspection = new Inspection();
                inspection.setIdinspection(result.getInt("idinspection"));
                inspection.setHeadSize(result.getDouble("headSize"));
                inspection.setHeight(result.getDouble("height"));
                inspection.setWeight(result.getDouble("weight"));
                inspection.setFootSize(result.getDouble("footSize"));
                inspection.setWeightLifted(result.getDouble("weightLifted"));
                inspection.setIsHealthy(result.getBoolean("isHealthy"));
                inspection.setReport(result.getString("report"));
                inspection.setFkPersonId(result.getInt("fkPersonId"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inspection;
    }
    
    public Inspection showFkPersonId(int fkPersonId) {
        Inspection inspection = null;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM inspection WHERE fkpersonid = " + fkPersonId;

            result = stmt.executeQuery(query);

            if (result.next()) {
                inspection = new Inspection();
                inspection.setIdinspection(result.getInt("idinspection"));
                inspection.setHeadSize(result.getDouble("headSize"));
                inspection.setHeight(result.getDouble("height"));
                inspection.setWeight(result.getDouble("weight"));
                inspection.setFootSize(result.getDouble("footSize"));
                inspection.setWeightLifted(result.getDouble("weightLifted"));
                inspection.setIsHealthy(result.getBoolean("isHealthy"));
                inspection.setReport(result.getString("report"));
                inspection.setFkPersonId(result.getInt("fkPersonId"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inspection;
    }

    @Override
    public boolean store(Inspection inspection) {
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " INSERT INTO inspection VALUES("
                    + "DEFAULT,"
                    + "\'" + inspection.getHeadSize() + "\',"
                    + "\'" + inspection.getHeight() + "\',"
                    + "\'" + inspection.getWeight() + "\',"
                    + "\'" + inspection.getFootSize() + "\',"
                    + "\'" + inspection.getWeightLifted() + "\',"
                    + "\'" + inspection.isIsHealthy() + "\',"
                    + "\'" + inspection.getReport() + "\',"
                    + "\'" + inspection.getYear() + "\',"
                    + "\'" + inspection.getFkPersonId() + "\'"
                    + ")";

            System.out.println(query);
            stmt.execute(query);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean update(Inspection inspection, int id) {
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " UPDATE inspection SET "
                    + "headsize = '" + inspection.getHeadSize() + "',"
                    + "height = '" + inspection.getHeight() + "',"
                    + "weight = '" + inspection.getWeight() + "',"
                    + "footsize = '" + inspection.getFootSize() + "',"
                    + "weightlifted = '" + inspection.getWeightLifted() + "',"
                    + "isHealthy = '" + inspection.isIsHealthy() + "',"
                    + "report = '" + inspection.getReport() + "',"
                    + "fkpersonid = '" + inspection.getFkPersonId() + "' "
                    + "WHERE idinspection = " + id;

            System.out.println(query);
            stmt.execute(query);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " DELETE FROM inspection WHERE idinspection = " + id;

            System.out.println(query);
            stmt.execute(query);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void changeStatus(boolean healthy, int id) {
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = "";
            if (healthy) {
                query = " UPDATE person SET type = 3 WHERE idperson = " + id;

            } else {
                query = " UPDATE person SET type = 2 WHERE idperson = " + id;
            }

            System.out.println(query);
            stmt.execute(query);

        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
