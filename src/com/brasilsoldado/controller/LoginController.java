package com.brasilsoldado.controller;

import com.brasilsoldado.helpers.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {

    private ResultSet result;

    public boolean authenticate(String email, String password) {
        Base64.Decoder decoder = Base64.getDecoder();

        boolean auth = false;

        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT idperson, password FROM person WHERE email = '" + email + "'";

            result = stmt.executeQuery(query);

            if (result.next()) {
                String passwordDecoded = new String(decoder.decode(result.getString("password")));
                if (passwordDecoded.equals(password)) {
                    auth = true;
                    System.out.println("FOI MEU BOM");
                }
            }
            return auth;
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return auth;
    }
}
