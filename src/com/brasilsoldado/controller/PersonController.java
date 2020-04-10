package com.brasilsoldado.controller;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.interfaces.IBasicController;
import com.brasilsoldado.model.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonController implements IBasicController<Person> {

    private ResultSet result;

    @Override
    public ArrayList<Person> index() {
        ArrayList people = new ArrayList<Person>();
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM person ORDER BY name";

            result = stmt.executeQuery(query);
            for (int i = 0; result.next(); i++) {
                Person newPerson = new Person(
                        i + 1,
                        result.getString("name"),
                        result.getString("surname"),
                        result.getDate("birthday"),
                        result.getString("cpf"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getInt("type"),
                        result.getBoolean("enabled"),
                        result.getString("momsname"),
                        result.getString("dadsname"),
                        result.getInt("fkcityid")
                );
                people.add(newPerson);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return people;
    }

    @Override
    public ArrayList<Person> show(int id) {
        ArrayList people = new ArrayList<Person>();
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM person WHERE idperson = " + id;

            result = stmt.executeQuery(query);
            for (int i = 0; result.next(); i++) {
                Person newPerson = new Person(
                        i + 1,
                        result.getString("name"),
                        result.getString("surname"),
                        result.getDate("birthday"),
                        result.getString("cpf"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getInt("type"),
                        result.getBoolean("enabled"),
                        result.getString("momsname"),
                        result.getString("dadsname"),
                        result.getInt("fkcityid")
                );
                people.add(newPerson);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return people;
    }

    @Override
    public boolean store(Person person) {
        boolean response = false;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " INSERT INTO person VALUES("
                    + "DEFAULT,"
                    + "\'" + person.getName() + "\', "
                    + "\'" + person.getSurname() + "\', "
                    + "\'" + person.getBirthday() + "\', "
                    + "\'" + person.getCpf() + "\', "
                    + "\'" + person.getEmail() + "\', "
                    + "\'" + person.getType() + "\', "
                    + "\'" + person.isEnabled() + "\', "
                    + "\'" + person.getMomsName() + "\', "
                    + "\'" + person.getDadsName() + "\', "
                    + "\'" + person.getFkCityId() + "\',"
                    + "\'" + person.getPassword() + "\'"
                    + ")";

            System.out.println(query);

            if (stmt.execute(query)) {
                response = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }

    @Override
    public boolean update(Person person, int id) {
        boolean response = false;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " UPDATE person SET "
                    + "name = '" + person.getName() + "',"
                    + "surname = '" + person.getSurname() + "',"
                    + "birthday = '" + person.getBirthday() + "',"
                    + "cpf = '" + person.getCpf() + "',"
                    + "email = '" + person.getEmail() + "',"
                    + "type = '" + person.getType() + "',"
                    + "enabled = '" + person.isEnabled() + "',"
                    + "momsname = '" + person.getMomsName() + "',"
                    + "dadsname = '" + person.getDadsName() + "',"
                    + "fkcityid = '" + person.getFkCityId() + "',"
                    + "password = '" + person.getPassword() + "'"
                    + "WHERE idperson = " + id;

            System.out.println(query);

            if (stmt.execute(query)) {
                response = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
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

            String query = " DELETE FROM person WHERE idperson = " + id;

            if (stmt.execute(query)) {
                response = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

}
