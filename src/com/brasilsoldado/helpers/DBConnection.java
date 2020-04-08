package com.brasilsoldado.helpers;

import java.sql.*;
import java.io.*;
import java.util.*;

public class DBConnection {

    private static DBConnection instancia = null;
    private Connection conexao = null;

    public DBConnection() {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("db.properties"));
            String dbdriver = prop.getProperty("db.driver");
            String dburl = prop.getProperty("db.url");
            String dbuser = prop.getProperty("db.user");
            String dbsenha = "postgres";

            Class.forName(dbdriver);

            if (dbuser.length() != 0) {
                conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);
            } else {
                conexao = DriverManager.getConnection(dburl);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static DBConnection getInstance() {
        if (instancia == null) {
            instancia = new DBConnection();
        }
        return instancia;
    }

    public Connection getConnection() {
        if (conexao == null) {
            throw new RuntimeException("conexao==null");
        }
        return conexao;
    }

    public void shutDown() {
        try {
            conexao.close();
            instancia = null;
            conexao = null;
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
