/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brasilsoldado.controller;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.interfaces.IBasicController;
import com.brasilsoldado.model.Interview;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author deusjp
 */
public class InterviewController implements IBasicController<Interview> {

    private ResultSet result;

    @Override
    public ArrayList<Interview> index() {
        ArrayList interviews = new ArrayList<Interview>();
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM interview ORDER BY idinterview";

            result = stmt.executeQuery(query);
            for (int i = 0; result.next(); i++) {
                Interview newInterview = new Interview(i + 1, result.getString("report"));
                interviews.add(newInterview);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QualificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return interviews;
    }

    @Override
    public Interview show(int id) {
        Interview interview = null;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM interview WHERE idinterview= " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                interview = new Interview();
                interview.setIdInterview(result.getInt("idinterview"));
                interview.setReport(result.getString("report"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(QualificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return interview;
    }

    @Override
    public boolean store(Interview interview) {
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " INSERT INTO interview VALUES("
                    + "DEFAULT,"
                    + "\'" + interview.getReport() + "\'"
                    + ") RETURNING idinterview";

            System.out.println(query);

            stmt.execute(query);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(QualificationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public int storeReturningId(Interview interview) {
        int response = -1;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " INSERT INTO interview VALUES("
                    + "DEFAULT,"
                    + "\'" + interview.getReport() + "\'"
                    + ") RETURNING idinterview";

            System.out.println(query);

            result = stmt.executeQuery(query);

            if (result.next()) {
                response = result.getInt("idinterview");
            }

        } catch (SQLException ex) {
            Logger.getLogger(QualificationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }

    @Override
    public boolean update(Interview interview, int id) {
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " UPDATE interview SET "
                    + "type = '" + interview.getReport() + "' "
                    + "WHERE idinterview= " + id;

            System.out.println(query);

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(QualificationController.class.getName()).log(Level.SEVERE, null, ex);
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

            String query = " DELETE FROM interview WHERE idinterview = " + id;

            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(QualificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /* Popula JTable */
    public void popularTabelaXXX(JTable table, String criteria) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Código";
        cabecalho[1] = "Relato";

        // cria matriz de acordo com nº de registros da tabela
        try {
            result = DBConnection.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM interview WHERE report ILIKE '%" + criteria + "%'");

            result.next();

            dadosTabela = new Object[result.getInt(1)][2];
            System.out.println(result.getInt(1));

        } catch (Exception e) {
            System.out.println("Erro ao consultar type: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            result = DBConnection.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM interview WHERE report ILIKE '%" + criteria + "%'");

            while (result.next()) {

                dadosTabela[lin][0] = result.getInt("idinterview");
                dadosTabela[lin][1] = result.getString("report");

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
//        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    setBackground(Color.GREEN);
//                } else {
//                    setBackground(Color.LIGHT_GRAY);
//                }
//                return this;
//            }
//        });
    }
}
