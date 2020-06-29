/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brasilsoldado.controller;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.helpers.Inserts;
import com.brasilsoldado.interfaces.IBasicController;
import com.brasilsoldado.model.Qualification;
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
 * @author joaopedro
 */
public class QualificationController implements IBasicController<Qualification> {

    private ResultSet result;

    @Override
    public ArrayList<Qualification> index() {
        ArrayList qualifications = new ArrayList<Qualification>();
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM qualification ORDER BY type";

            result = stmt.executeQuery(query);
            for (int i = 0; result.next(); i++) {
                Qualification newQualification = new Qualification(i + 1, result.getString("type"));
                qualifications.add(newQualification);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QualificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qualifications;
    }

    @Override
    public Qualification show(int id) {
        Qualification qualification = null;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM qualification WHERE idqualification = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                qualification = new Qualification();
                qualification.setIdQualification(result.getInt("idqualification"));
                qualification.setType(result.getString("type"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(QualificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qualification;
    }

    @Override
    public boolean store(Qualification quali) {
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " INSERT INTO qualification VALUES("
                    + "DEFAULT,"
                    + "\'" + quali.getType() + "\'"
                    + ")";

            System.out.println(query);

            stmt.execute(query);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(QualificationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean update(Qualification quali, int id) {
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " UPDATE qualification SET "
                    + "type = '" + quali.getType() + "' "
                    + "WHERE idqualification = " + id;

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

            String query = " DELETE FROM qualification WHERE idqualification = " + id;

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
        cabecalho[1] = "Tipo de Qualificação";

        // cria matriz de acordo com nº de registros da tabela
        try {
            result = DBConnection.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT CASE \n"
                    + "         WHEN EXISTS (SELECT * FROM qualification LIMIT 1) THEN 1\n"
                    + "         ELSE 0 \n"
                    + "       END");
            result.next();
            if (result.getInt(1) == 0) {
                System.out.println("Inserindo dados");
                Inserts.insertQualifications();
            }

            result = DBConnection.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM qualification WHERE type ILIKE '%" + criteria + "%'");

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
                    + "SELECT * FROM qualification WHERE type ILIKE '%" + criteria + "%'");

            while (result.next()) {

                dadosTabela[lin][0] = result.getInt("idqualification");
                dadosTabela[lin][1] = result.getString("type");

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

    /* Popula JTable */
    public void popularTabelaXXXException(JTable table, String criteria, String exceptions) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Código";
        cabecalho[1] = "Tipo de Qualificação";

        // cria matriz de acordo com nº de registros da tabela
        try {
            result = DBConnection.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM qualification WHERE type ILIKE '%" + criteria + "%' AND idqualification NOT IN(" + exceptions + ")");

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
                    + "SELECT * FROM qualification WHERE type ILIKE '%" + criteria + "%' AND idqualification NOT IN(" + exceptions + ")");

            while (result.next()) {

                dadosTabela[lin][0] = result.getInt("idqualification");
                dadosTabela[lin][1] = result.getString("type");

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

    /* Popula JTable */
    public void popularTabelaXXXDynamics(JTable table, ArrayList<Qualification> qualifications) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Código";
        cabecalho[1] = "Tipo de Qualificação";

        // cria matriz de acordo com nº de registros da tabela
        try {
            dadosTabela = new Object[qualifications.size()][2];
            System.out.println(qualifications.size());

        } catch (Exception e) {
            System.out.println("Erro ao consultar type: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            for (int i = 0; i < qualifications.size(); i++) {
                dadosTabela[i][0] = qualifications.get(i).getIdQualification();
                dadosTabela[i][1] = qualifications.get(i).getType();
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

    /* Popula JTable */
    public void popularTabelaXXXColigation(JTable table, int personId) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Código";
        cabecalho[1] = "Tipo de Qualificação";

        // cria matriz de acordo com nº de registros da tabela
        try {
            result = DBConnection.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM qualification q INNER JOIN \"personQualification\" pq ON pq.fkqualificationid = q.idqualification WHERE pq.fkpersonid = " + personId);

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
                    + "SELECT q.idqualification, q.type FROM qualification q INNER JOIN \"personQualification\" pq ON pq.fkqualificationid = q.idqualification WHERE pq.fkpersonid = " + personId + " ORDER BY q.idqualification");

            while (result.next()) {

                dadosTabela[lin][0] = result.getInt("idqualification");
                dadosTabela[lin][1] = result.getString("type");

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
