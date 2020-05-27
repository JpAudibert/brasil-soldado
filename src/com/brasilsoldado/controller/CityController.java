package com.brasilsoldado.controller;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.interfaces.IBasicController;
import com.brasilsoldado.model.City;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cities;
    }

    @Override
    public City show(int id) {
        City city = null;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM city WHERE idcity = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                city = new City();
                city.setIdCity(result.getInt("idcity"));
                city.setName(result.getString("name"));
                city.setInitials(result.getString("initials"));
                city.setFkStateId(result.getInt("fkstateid"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return city;
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
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    /* Popula JTable */
    public void popularTabelaXXX(JTable table, String criteria) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Código";
        cabecalho[1] = "Cidade";
        cabecalho[2] = "Sigla";
        cabecalho[3] = "UF";

        // cria matriz de acordo com nº de registros da tabela
        try {
            result = DBConnection.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(c.idcity) FROM city c INNER JOIN state s ON c.fkstateid = s.idstate WHERE c.name ILIKE '%" + criteria + "%'");

            result.next();

            dadosTabela = new Object[result.getInt(1)][4];
            System.out.println(result.getInt(1));

        } catch (Exception e) {
            System.out.println("Erro ao consultar name: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            result = DBConnection.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT c.idcity, c.name AS \"cityname\", c.initials AS \"cityinitials\", "
                    + "s.initials AS \"uf\" FROM city c INNER JOIN state s ON "
                    + "c.fkstateid = s.idstate WHERE c.name ILIKE '%" + criteria + "%'");

            while (result.next()) {

                dadosTabela[lin][0] = result.getInt("idcity");
                dadosTabela[lin][1] = result.getString("cityname");
                dadosTabela[lin][2] = result.getString("cityinitials");
                dadosTabela[lin][3] = result.getString("uf");

                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        table.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        table.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }
        // renderizacao das linhas da tabela = mudar a cor
//        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    table.setBackground(Color.WHITE);
//                    table.setForeground(Color.DARK_GRAY);
//                } else {
//                    table.setBackground(Color.LIGHT_GRAY);
//                    table.setForeground(Color.BLACK);
//                }
//                return this;
//            }
//        });
    }

}
