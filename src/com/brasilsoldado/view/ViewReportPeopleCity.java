/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brasilsoldado.view;

import com.brasilsoldado.controller.CityController;
import com.brasilsoldado.helpers.CombosDAO;
import com.brasilsoldado.helpers.ComboItem;
import com.brasilsoldado.helpers.DBConnection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author deusjp
 */
public class ViewReportPeopleCity extends javax.swing.JFrame {

    final CityController cityController = new CityController();
    final CombosDAO combo = new CombosDAO();
    String email;

    /**
     * Creates new form ViewReportPeopleCity
     */
    public ViewReportPeopleCity() {
        initComponents();
        combo.popularCombo("state", "idstate", "name", this.fkStateId, "");
    }

    public ViewReportPeopleCity(String email) {
        initComponents();
        this.email = email;
        combo.popularCombo("state", "idstate", "name", this.fkStateId, "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        fkStateId = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        reportPeopleCity = new javax.swing.JButton();
        fkCityId = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(57, 128, 65));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        welcome.setFont(new java.awt.Font("Ubuntu", 1, 32)); // NOI18N
        welcome.setForeground(new java.awt.Color(254, 254, 254));
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome.setText("Lista de Chamada por Cidade");

        fkStateId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fkStateId.setPreferredSize(new java.awt.Dimension(99, 40));
        fkStateId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fkStateIdActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Selecione uma cidade para gerar o relatório: *");

        back.setText("Voltar");
        back.setMaximumSize(new java.awt.Dimension(52, 35));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        reportPeopleCity.setText("Gerar Relatório");
        reportPeopleCity.setPreferredSize(new java.awt.Dimension(150, 40));
        reportPeopleCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportPeopleCityActionPerformed(evt);
            }
        });

        fkCityId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fkCityId.setPreferredSize(new java.awt.Dimension(99, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(reportPeopleCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(324, 324, 324))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(fkStateId, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fkCityId, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(fkStateId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(fkCityId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(reportPeopleCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new ViewDashboard(email).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void reportPeopleCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportPeopleCityActionPerformed
        try {
            ComboItem item = (ComboItem) this.fkCityId.getSelectedItem();
            JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/com/brasilsoldado/reports/listPeopleCity.jrxml"));

            Map params = new HashMap();
            params.put("idCity", item.getCodigo());

            JasperPrint press = JasperFillManager.fillReport(report, params, DBConnection.getInstance().getConnection());

            JasperViewer.viewReport(press, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio: " + e);
        }
    }//GEN-LAST:event_reportPeopleCityActionPerformed

    private void fkStateIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fkStateIdActionPerformed
        combo.popularCombo("city", "idcity", "name", fkCityId, " WHERE fkstateid = " + this.fkStateId.getSelectedIndex());
    }//GEN-LAST:event_fkStateIdActionPerformed


/**
 * @param args the command line arguments
 */
public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

}
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewReportPeopleCity.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewReportPeopleCity.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewReportPeopleCity.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewReportPeopleCity.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewReportPeopleCity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JComboBox<String> fkCityId;
    private javax.swing.JComboBox<String> fkStateId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton reportPeopleCity;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
