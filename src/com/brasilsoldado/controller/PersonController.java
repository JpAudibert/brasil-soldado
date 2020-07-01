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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
                person.setPassword(new String(Base64.getDecoder().decode(result.getString("password"))));
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
                person.setPassword(new String(Base64.getDecoder().decode(result.getString("password"))));
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

    /* Popula JTable */
    public void popularTabelaXXX(JTable table, String criteria) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Código";
        cabecalho[1] = "Pessoa";
        cabecalho[2] = "Email";
        cabecalho[3] = "CPF";

        // cria matriz de acordo com nº de registros da tabela
        try {
            result = DBConnection.getInstance().getConnection().createStatement().executeQuery(""
                    + " SELECT count(idperson) FROM person WHERE type = 1 AND CONCAT (name, ' ', surname) ILIKE '%" + criteria + "%'");

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
                    + "	idperson,\n"
                    + "	CONCAT (name, ' ', surname) AS person,\n"
                    + "	email,\n"
                    + "	cpf\n"
                    + " FROM\n"
                    + "	person"
                    + " WHERE type = 1 AND "
                    + " CONCAT (name, ' ', surname) ILIKE '%" + criteria + "%'");

            while (result.next()) {

                dadosTabela[lin][0] = result.getInt("idperson");
                dadosTabela[lin][1] = result.getString("person");
                dadosTabela[lin][2] = result.getString("email");
                dadosTabela[lin][3] = result.getString("cpf");

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
