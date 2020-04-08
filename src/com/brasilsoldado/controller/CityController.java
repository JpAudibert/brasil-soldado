package com.brasilsoldado.controller;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.interfaces.IBasicController;
import com.brasilsoldado.model.City;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CityController implements IBasicController<City> {

    private ResultSet result;

    @Override
    public ArrayList<City> index() {
        ArrayList cities = new ArrayList<City>();
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM city ORDER BY name";

            result = stmt.executeQuery(query);
            for (int i = 0; result.next(); i++) {
                City newCity = new City(i + 1, result.getString("name"), result.getString("initials"), result.getInt("fkstateid"));
                cities.add(newCity);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cities;
    }

    @Override
    public ArrayList<City> show(int id) {
        ArrayList cities = new ArrayList<City>();
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM city WHERE idcity = " + id;

            result = stmt.executeQuery(query);
            for (int i = 0; result.next(); i++) {
                City newCity = new City(i + 1, result.getString("name"), result.getString("initials"), result.getInt("fkstateid"));
                cities.add(newCity);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cities;
    }

    @Override
    public boolean store(City city) {
        boolean response = false;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " INSERT INTO city VALUES("
                    + "DEFAULT,"
                    + "\'" + city.getName() + "\', "
                    + "\'" + city.getInitials() + "\', "
                    + "\'" + city.getFkStateId() + "\'"
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
    public boolean update(City city, int id) {
        boolean response = false;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " UPDATE city SET "
                    + "name = '" + city.getName() + "',"
                    + "initials = '" + city.getInitials() + "' "
                    + "WHERE idcity = " + id;

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

            String query = " DELETE FROM city WHERE idcity = " + id;

            if (stmt.execute(query)) {
                response = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

}
