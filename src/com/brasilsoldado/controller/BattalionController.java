package com.brasilsoldado.controller;

import com.brasilsoldado.helpers.DBConnection;
import com.brasilsoldado.helpers.InsertStates;
import com.brasilsoldado.interfaces.IBasicController;
import com.brasilsoldado.model.Battalion;
import com.brasilsoldado.model.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class BattalionController implements IBasicController<Battalion> {

    private ResultSet result;

    @Override
    public ArrayList<Battalion> index() {
        ArrayList battalions = new ArrayList<Battalion>();
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM battalion ORDER BY idbattalion";

            result = stmt.executeQuery(query);
            for (int i = 0; result.next(); i++) {
                Battalion newBattalion = new Battalion(i + 1, result.getInt("qttmembers"), result.getInt("idpersonresponsible"), result.getInt("fkidcity"));
                battalions.add(newBattalion);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return battalions;
    }

    @Override
    public Battalion show(int id) {
        Battalion battalion = null;
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();

            String query = " SELECT * FROM battalion WHERE idbattalion = " + id;

            result = stmt.executeQuery(query);

            if (result.next()) {
                battalion = new Battalion();
                battalion.setIdBattalion(result.getInt("idbattalion"));
                battalion.setQttMembers(result.getInt("qttmembers"));
                battalion.setIdPersonResponsible(result.getInt("idpersonresponsible"));
                battalion.setFkCityId(result.getInt("fkcityid"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return battalion;
    }

    @Override
    public boolean store(Battalion battalion) {
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " INSERT INTO battalion VALUES("
                    + "DEFAULT,"
                    + "\'" + battalion.getQttMembers() + "\',"
                    + "\'" + battalion.getIdPersonResponsible() + "\',"
                    + "\'" + battalion.getFkCityId() + "\'"
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
    public boolean update(Battalion battalion, int id) {
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            String query = " UPDATE battalion SET "
                    + "qttmembers = '" + battalion.getQttMembers() + "',"
                    + "idpersonresponsible = '" + battalion.getIdPersonResponsible() + "',"
                    + "fkcityid = '" + battalion.getFkCityId() + "' "
                    + "WHERE idbattalion = " + id;

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

            String query = " DELETE FROM battalion WHERE idbattalion = " + id;

            System.out.println(query);
            stmt.execute(query);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /* Popula JTable */
    public void popularTabelaXXX(JTable table, String criteria) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Código";
        cabecalho[1] = "Quantidade de membros";
        cabecalho[2] = "Responsável";
        cabecalho[3] = "Cidade - UF";

        // cria matriz de acordo com nº de registros da tabela
        try {
            result = DBConnection.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(b.idbattalion) FROM battalion b INNER JOIN city c ON b.fkcityid = c.idcity WHERE c.name ILIKE '%" + criteria + "%'");

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
                    + " SELECT \n"
                    + "	b.idbattalion,\n"
                    + "	b.qttmembers,\n"
                    + "	CONCAT (p.name, ' ', p.surname) AS person,\n"
                    + "	CONCAT(c.name, ' - ', s.initials) AS city\n"
                    + " FROM\n"
                    + "	battalion b \n"
                    + "		INNER JOIN person p ON b.idpersonresponsible = p.idperson\n"
                    + "		INNER JOIN city c ON c.idcity = b.fkcityid\n"
                    + "		INNER JOIN state s ON c.fkstateid = s.idstate"
                    + " WHERE"
                    + " c.name ILIKE '%" + criteria + "%'");

            while (result.next()) {

                dadosTabela[lin][0] = result.getInt("idbattalion");
                dadosTabela[lin][1] = result.getInt("qttmembers");
                dadosTabela[lin][2] = result.getString("person");
                dadosTabela[lin][3] = result.getString("city");

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
