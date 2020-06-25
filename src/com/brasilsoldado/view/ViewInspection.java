/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brasilsoldado.view;

import com.brasilsoldado.controller.InspectionController;
import com.brasilsoldado.helpers.CombosDAO;
import com.brasilsoldado.helpers.Validacao;
import com.brasilsoldado.model.Inspection;
import javax.swing.JOptionPane;

/**
 *
 * @author deusjp
 */
public class ViewInspection extends javax.swing.JFrame {

    final InspectionController inspectionController = new InspectionController();
    final CombosDAO combo = new CombosDAO();
    int id = 0;
    String email;
    String idPerson = "0";

    /**
     * Creates new form ViewInspection
     */
    public ViewInspection() {
        initComponents();
    }

    public ViewInspection(String email) {
        initComponents();
        this.email = email;
    }
    
    public void setPerson (String id, String name){
        fkPersonId.setText(name);
        idPerson = id;
        
        healthy.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        headSize = new javax.swing.JTextField();
        height = new javax.swing.JTextField();
        warning1 = new javax.swing.JLabel();
        submit1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        weight = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        footSize = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        healthy = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        report = new javax.swing.JTextArea();
        weightLifted = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fkPersonId = new javax.swing.JTextField();
        searchPerson = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        indexTable = new javax.swing.JTable();
        search = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        criteria = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1120, 620));

        jTabbedPane2.setPreferredSize(new java.awt.Dimension(1120, 620));

        jPanel3.setPreferredSize(new java.awt.Dimension(1120, 620));

        jPanel4.setPreferredSize(new java.awt.Dimension(1120, 620));

        jPanel7.setBackground(new java.awt.Color(57, 128, 65));
        jPanel7.setPreferredSize(new java.awt.Dimension(1120, 620));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Brasil! Soldado - Inspeção");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("É apto a servir: *");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Altura (cm):*");

        warning1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        warning1.setForeground(new java.awt.Color(254, 254, 254));
        warning1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        submit1.setText("Enviar Dados");
        submit1.setPreferredSize(new java.awt.Dimension(100, 35));
        submit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Peso Levantado (Kg):");

        back.setText("Voltar");
        back.setMaximumSize(new java.awt.Dimension(52, 35));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        weight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setText("Tamanho do pé: *");

        footSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                footSizeActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(254, 254, 254));
        jLabel11.setText("Relatório: *");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(254, 254, 254));
        jLabel12.setText("Tamanho da cabeça: *");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(254, 254, 254));
        jLabel13.setText("Alistado: *");

        healthy.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        healthy.setText("Sim");
        healthy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                healthyActionPerformed(evt);
            }
        });

        report.setColumns(20);
        report.setRows(5);
        jScrollPane2.setViewportView(report);

        weightLifted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightLiftedActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(254, 254, 254));
        jLabel14.setText("Peso (Kg): *");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("*Deixe em branco caso inapto*");

        fkPersonId.setEditable(false);

        searchPerson.setText("Pesquisar");
        searchPerson.setMaximumSize(new java.awt.Dimension(52, 35));
        searchPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPersonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fkPersonId, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(searchPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(55, 55, 55))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(healthy, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(9, 9, 9)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(85, 85, 85)))
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(286, 286, 286))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(weightLifted))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(33, 33, 33))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(submit1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(warning1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(20, 20, 20)))
                                    .addGap(32, 32, 32)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(32, 32, 32))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(headSize)
                                .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(footSize)
                            .addGap(33, 33, 33)))))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {footSize, jScrollPane2, weight, weightLifted});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fkPersonId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(healthy)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weightLifted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(footSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(headSize, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(warning1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(submit1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fkPersonId, footSize, headSize, height, weight, weightLifted});

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jTabbedPane2.addTab("Cadastro", jPanel3);

        jPanel5.setPreferredSize(new java.awt.Dimension(1120, 620));

        jPanel9.setBackground(new java.awt.Color(57, 128, 65));
        jPanel9.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Brasil! Soldado - Inspeção");

        indexTable.setForeground(new java.awt.Color(29, 29, 29));
        indexTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(indexTable);

        search.setForeground(new java.awt.Color(53, 53, 53));
        search.setText("Pesquisar");
        search.setPreferredSize(new java.awt.Dimension(100, 35));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        update.setForeground(new java.awt.Color(53, 53, 53));
        update.setText("Editar");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setForeground(new java.awt.Color(53, 53, 53));
        delete.setText("Excluir");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        criteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criteriaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Digite o nome do alistado para ver sua inspeção:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addComponent(criteria, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(319, 319, 319))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {delete, search, update});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(criteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update)
                    .addComponent(delete))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {delete, search, update});

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 1108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Listagem", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit1ActionPerformed
        Inspection inspection = new Inspection();
        boolean response = false;
        int idSoldier = Integer.parseInt(idPerson);
        if (Validacao.notNull(this.headSize.getText())
                && Validacao.notNull(this.height.getText())
                && Validacao.notNull(this.weight.getText())
                && Validacao.notNull(this.footSize.getText())
                && Validacao.notNull(this.report.getText())
                && idSoldier > 0) {
            inspection.setHeadSize(Double.parseDouble(this.headSize.getText()));
            inspection.setHeight(Double.parseDouble(this.height.getText()));
            inspection.setWeight(Double.parseDouble(this.weight.getText()));
            inspection.setFootSize(Double.parseDouble(this.footSize.getText()));
            inspection.setWeightLifted(Double.parseDouble(this.weightLifted.getText()));
            inspection.setIsHealthy(this.healthy.isSelected());
            inspection.setReport(this.report.getText());
            inspection.setFkPersonId(idSoldier);

            if (id == 0) {
                response = this.inspectionController.store(inspection);
            } else {
                response = this.inspectionController.update(inspection, id);
            }
            if (response) {
                JOptionPane.showMessageDialog(null, "Registro Salvo com sucesso!");
                this.headSize.setText("");

                this.fkPersonId.requestFocus();

                id = 0;
                idPerson = "0";
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.");
        }
    }//GEN-LAST:event_submit1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new ViewDashboard(email).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
//        this.cityController.popularTabelaXXX(indexTable, this.criteria.getText());
    }//GEN-LAST:event_searchActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String idString = String.valueOf(indexTable.getValueAt(indexTable.getSelectedRow(), 0));
        id = Integer.parseInt(idString);

        Inspection inspection = this.inspectionController.show(id);
        if (inspection != null) {

//            this.name.setText(city.getName());
//            this.initials.setText(city.getInitials());
//            combo.popularCombo("state", "idstate", "name", this.fkStateId, "");
//            this.fkStateId.setSelectedIndex(city.getFkStateId());
//
//            this.jTabbedPane1.setSelectedIndex(0);
//
//            this.name.requestFocus();
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String idString = String.valueOf(indexTable.getValueAt(indexTable.getSelectedRow(), 0));
        int idDelete = Integer.parseInt(idString);

        if (this.inspectionController.delete(idDelete)) {
            JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
//            this.inspectionController.popularTabelaXXX(indexTable, "");
        } else {
            JOptionPane.showMessageDialog(null, "Problemas ao excluir registro.");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void criteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criteriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_criteriaActionPerformed

    private void footSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_footSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_footSizeActionPerformed

    private void weightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_weightActionPerformed

    private void healthyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_healthyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_healthyActionPerformed

    private void weightLiftedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightLiftedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_weightLiftedActionPerformed

    private void searchPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPersonActionPerformed
        DlgPerson dlgSeacrhPerson = new DlgPerson(null, true, this);
        dlgSeacrhPerson.setVisible(true);
    }//GEN-LAST:event_searchPersonActionPerformed

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
            java.util.logging.Logger.getLogger(ViewInspection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewInspection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewInspection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewInspection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewInspection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JTextField criteria;
    private javax.swing.JButton delete;
    private javax.swing.JTextField fkPersonId;
    private javax.swing.JTextField footSize;
    private javax.swing.JTextField headSize;
    private javax.swing.JRadioButton healthy;
    private javax.swing.JTextField height;
    private javax.swing.JTable indexTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea report;
    private javax.swing.JButton search;
    private javax.swing.JButton searchPerson;
    private javax.swing.JButton submit1;
    private javax.swing.JButton update;
    private javax.swing.JLabel warning1;
    private javax.swing.JTextField weight;
    private javax.swing.JTextField weightLifted;
    // End of variables declaration//GEN-END:variables
}
