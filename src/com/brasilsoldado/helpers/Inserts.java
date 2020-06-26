package com.brasilsoldado.helpers;

import java.sql.Statement;


public class Inserts {
    public static void insertStates(){
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            
            String sql = " "
                    + "INSERT INTO state VALUES (DEFAULT, 'Acre', 'AC'),"
                    + "(DEFAULT, 'Alagoas', 'AL'),"
                    + "(DEFAULT, 'Amapá', 'AP'),"
                    + "(DEFAULT, 'Amazonas', 'AM'),"
                    + "(DEFAULT, 'Bahia', 'BA'),"
                    + "(DEFAULT, 'Ceará', 'CE'),"
                    + "(DEFAULT, 'Distrito Federal', 'DF'),"
                    + "(DEFAULT, 'Espírito Santo', 'ES'),"
                    + "(DEFAULT, 'Goiás', 'GO'),"
                    + "(DEFAULT, 'Maranhão', 'MA'),"
                    + "(DEFAULT, 'Mato Grosso', 'MT'),"
                    + "(DEFAULT, 'Mato Grosso do Sul', 'MS'),"
                    + "(DEFAULT, 'Minas Gerais', 'MG'),"
                    + "(DEFAULT, 'Pará', 'PA'),"
                    + "(DEFAULT, 'Paraíba', 'PB'),"
                    + "(DEFAULT, 'Paraná', 'PR'),"
                    + "(DEFAULT, 'Pernambuco', 'PE'),"
                    + "(DEFAULT, 'Piauí', 'PI'),"
                    + "(DEFAULT, 'Rio de Janeiro', 'RJ'),"
                    + "(DEFAULT, 'Rio Grande do Norte', 'RN'),"
                    + "(DEFAULT, 'Rio Grande do Sul', 'RS'),"
                    + "(DEFAULT, 'Rondônia', 'RO'),"
                    + "(DEFAULT, 'Roraima', 'RR'),"
                    + "(DEFAULT, 'Santa Catarina', 'SC'),"
                    + "(DEFAULT, 'São Paulo', 'SP'),"
                    + "(DEFAULT, 'Sergipe', 'SE'),"
                    + "(DEFAULT, 'Tocantins', 'TO')";
            
            if(stmt.execute(sql)){
                System.out.println("Estados Inseridos.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void insertQualifications(){
        try {
            Statement stmt = DBConnection
                    .getInstance()
                    .getConnection()
                    .createStatement();
            
            String sql = " "
                    + " INSERT INTO qualification VALUES "
                    + " (DEFAULT, 'Montagem/manutenção de computadores'),"
                    + " (DEFAULT, 'Programação de softwares'),"
                    + " (DEFAULT, 'Primeiros socorros'),"
                    + " (DEFAULT, 'Mêcaninca automotiva'),"
                    + " (DEFAULT, 'Elétrica automotiva'),"
                    + " (DEFAULT, 'Mecânica industrial'),"
                    + " (DEFAULT, 'Elétrica industrial'),"
                    + " (DEFAULT, 'Experiência na área de alimentos'),"
                    + " (DEFAULT, 'É/foi escoteiro ou  bandeirante'),"
                    + " (DEFAULT, 'Já trabalhou em escritório')";
            
            if(stmt.execute(sql)){
                System.out.println("Qualificações Inseridas.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
