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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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


    /* Popula JTable */
    public void popularTabelaXXX(JTable table, String criteria, int qttQuali) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "Código";
        cabecalho[1] = "Pessoa";
        cabecalho[2] = "CPF";
        cabecalho[3] = "Altura";
        cabecalho[4] = "Peso";
        cabecalho[5] = "Localidade";
        cabecalho[6] = "Qualificações";

        // cria matriz de acordo com nº de registros da tabela
        try {
            result = DBConnection.getInstance().getConnection().createStatement().executeQuery(""
                    + " SELECT \n" +
                            " COUNT(p.idperson) "+
                        " FROM \n" +
                            " person p\n" +
                                " INNER JOIN inspection i ON p.idperson = i.fkpersonid\n" +
                                " INNER JOIN \"personQualification\" pq ON pq.fkpersonid = p.idperson\n" +
                                " INNER JOIN qualification q ON q.idqualification = pq.fkqualificationid\n" +
                                " INNER JOIN city c ON p.fkcityid = c.idcity\n" +
                                " INNER JOIN state s ON c.fkstateid = s.idstate\n" +
                        " WHERE\n" +
                            " p.type = 3\n" +
                            criteria +
                        " GROUP BY\n" +
                            " p.idperson, i.idinspection, c.idcity, s.idstate\n" +
                        " HAVING\n" +
                            " count(pq.fkqualificationid) > " + qttQuali);

            result.next();

            dadosTabela = new Object[1][7];
            System.out.println(result.getInt(1));

        } catch (Exception e) {
            System.out.println("Erro ao consultar name: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            result = DBConnection.getInstance().getConnection().createStatement().executeQuery(""
                    + " SELECT \n" +
                            " p.idperson,\n" +
                            " CONCAT(p.name, ' ', p.surname) AS name,\n" +
                            " p.cpf,\n" +
                            " i.height,\n" +
                            " i.weight,\n" +
                            " CONCAT (c.name, ' - ', s.initials) AS location,\n" +
                            " STRING_AGG(q.type, ', ') AS qualifications\n" +
                        " FROM \n" +
                            " person p\n" +
                                " INNER JOIN inspection i ON p.idperson = i.fkpersonid\n" +
                                " INNER JOIN \"personQualification\" pq ON pq.fkpersonid = p.idperson\n" +
                                " INNER JOIN qualification q ON q.idqualification = pq.fkqualificationid\n" +
                                " INNER JOIN city c ON p.fkcityid = c.idcity\n" +
                                " INNER JOIN state s ON c.fkstateid = s.idstate\n" +
                        " WHERE\n" +
                            " p.type = 3\n" +
                            criteria +
                        " GROUP BY\n" +
                            " p.idperson, i.idinspection, c.idcity, s.idstate\n" +
                        " HAVING\n" +
                            " count(pq.fkqualificationid) > " + qttQuali);

            while (result.next()) {

                dadosTabela[lin][0] = result.getInt("idperson");
                dadosTabela[lin][1] = result.getString("name");
                dadosTabela[lin][2] = result.getString("cpf");
                dadosTabela[lin][3] = result.getString("height");
                dadosTabela[lin][4] = result.getString("weight");
                dadosTabela[lin][5] = result.getString("location");
                dadosTabela[lin][6] = result.getString("qualifications");

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
