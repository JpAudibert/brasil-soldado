package com.brasilsoldado.controller;

import com.brasilsoldado.helpers.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
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
                if (decoder.decode(result.getString("password")).equals(password)) {
                    auth = true;
                    System.out.println("FOI MEU BOM");
                }
            }
            System.out.println(Arrays.toString(decoder.decode(result.getString("password"))));
            return auth;
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return auth;
    }
}
