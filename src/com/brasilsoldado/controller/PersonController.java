package com.brasilsoldado.controller;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.interfaces.IBasicController;
import com.brasilsoldado.model.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
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
    public Person show(int id) {
        Person person = null;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM person WHERE idperson = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                person = new Person();
                person.setIdPerson(result.getInt("idperson"));
                person.setName(result.getString("name"));
                person.setSurname(result.getString("surname"));
                person.setBirthday(result.getDate("birthday"));
                person.setCpf(result.getString("cpf"));
                person.setEmail(result.getString("email"));
                person.setPassword(result.getString("password"));
                person.setType(result.getInt("type"));
                person.setEnabled(result.getBoolean("enabled"));
                person.setMomsName(result.getString("momsname"));
                person.setDadsName(result.getString("dadsname"));
                person.setFkCityId(result.getInt("fkcityid"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }

    public Person show(String email) {
        Person person = null;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM person WHERE email = '" + email + "'";

            System.out.println(query);
            result = stmt.executeQuery(query);

            if (result.next()) {
                person = new Person();
                person.setIdPerson(result.getInt("idperson"));
                person.setName(result.getString("name"));
                person.setSurname(result.getString("surname"));
                person.setBirthday(result.getDate("birthday"));
                person.setCpf(result.getString("cpf"));
                person.setEmail(result.getString("email"));
                person.setPassword(result.getString("password"));
                person.setType(result.getInt("type"));
                person.setEnabled(result.getBoolean("enabled"));
                person.setMomsName(result.getString("momsname"));
                person.setDadsName(result.getString("dadsname"));
                person.setFkCityId(result.getInt("fkcityid"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }

    @Override
    public boolean store(Person person) {
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
                    + "\'" + person.getPassword() + "\',"
                    + "\'" + person.getType() + "\', "
                    + "\'" + person.isEnabled() + "\', "
                    + "\'" + person.getMomsName() + "\', "
                    + "\'" + person.getDadsName() + "\', "
                    + "\'" + person.getFkCityId() + "\'"
                    + ")";

            System.out.println(query);

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean update(Person person, int id) {
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
                    + "momsname = '" + person.getMomsName() + "',"
                    + "dadsname = '" + person.getDadsName() + "',"
                    + "fkcityid = '" + person.getFkCityId() + "',"
                    + "password = '" + person.getPassword() + "'"
                    + "WHERE idperson = " + id;

            System.out.println(query);

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
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

            String query = " DELETE FROM person WHERE idperson = " + id;

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
