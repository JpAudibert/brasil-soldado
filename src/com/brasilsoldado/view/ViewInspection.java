/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brasilsoldado.view;

import com.brasilsoldado.controller.InspectionController;
import com.brasilsoldado.controller.InterviewController;
import com.brasilsoldado.controller.PersonController;
import com.brasilsoldado.controller.PersonInterviewController;
import com.brasilsoldado.controller.PersonQualificationController;
import com.brasilsoldado.controller.QualificationController;
import com.brasilsoldado.helpers.CombosDAO;
import com.brasilsoldado.helpers.Validacao;
import com.brasilsoldado.model.Inspection;
import com.brasilsoldado.model.Interview;
import com.brasilsoldado.model.Person;
import com.brasilsoldado.model.PersonInterview;
import com.brasilsoldado.model.PersonQualification;
import com.brasilsoldado.model.Qualification;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author deusjp
 */
public class ViewInspection extends javax.swing.JFrame {

    final InspectionController inspectionController = new InspectionController();
    final PersonController personController = new PersonController();
    final QualificationController qualificationController = new QualificationController();
    final PersonQualificationController personQualificationController = new PersonQualificationController();
    final InterviewController interviewController = new InterviewController();
    final PersonInterviewController personInterviewController = new PersonInterviewController();
    final CombosDAO combo = new CombosDAO();
    int id = 0;
    String email;
    String oldEmail;
    int idPerson = 0;
    ArrayList<Qualification> qualifications = new ArrayList<>();
    String exceptions = "";

    /**
     * Creates new form ViewInspection
     */
    public ViewInspection() {
        initComponents();
        this.recruit.setVisible(false);
        this.toRecruit.setVisible(false);

    }

    public ViewInspection(String email) {
        initComponents();
        this.email = email;
        this.recruit.setVisible(false);
        this.toRecruit.setVisible(false);
        this.jTabbedPane2.setEnabledAt(1, false);
        this.jTabbedPane2.setEnabledAt(2, false);
    }

    public ViewInspection(String email, boolean isView) {
        initComponents();
        this.email = email;
        System.out.println(this.email);

        Person person = this.personController.show(email);
        Inspection inspectionShow = this.inspectionController.showFkPersonId(person.getIdPerson());

        this.idPerson = person.getIdPerson();
        this.fkPersonId.setText(person.getName() + " " + person.getSurname());
        this.headSize.setText(inspectionShow.getHeadSize() + " cm");
        this.height.setText(inspectionShow.getHeight() + " cm");
        this.weight.setText(inspectionShow.getWeight() + " kg");
        this.footSize.setText(inspectionShow.getFootSize() + "");
        this.weightLifted.setText(inspectionShow.getWeightLifted() + " kg");
        this.report.setText(inspectionShow.getReport());

        this.healthy.setSelected(inspectionShow.isIsHealthy());

        this.fkPersonId.setEditable(false);
        this.headSize.setEditable(false);
        this.height.setEditable(false);
        this.weight.setEditable(false);
        this.footSize.setEditable(false);
        this.weightLifted.setEditable(false);
        this.healthy.setEnabled(false);
        this.report.setEditable(false);
        this.submit1.setVisible(false);

        qualificationController.popularTabelaXXXColigation(qualificationsIndex, idPerson);
        qualiText.setText("Atributos do alistado:");
        qualification.setVisible(false);
        searchQuali.setVisible(false);
        addToList.setVisible(false);
        removeFromList.setVisible(false);
        qualificationsSelected.setVisible(false);
        qualiSelected.setText("Ignorar tabela abaixo");
        submitQuali.setVisible(false);

        interview.setText(personInterviewController.showInterview(person.getIdPerson()).getReport());
        interview.setEditable(false);
        submitInterview.setVisible(false);
        this.recruit.setVisible(false);
        this.toRecruit.setVisible(false);

        this.jTabbedPane2.setEnabledAt(1, true);
        this.jTabbedPane2.setEnabledAt(2, true);
    }

    public ViewInspection(String email, boolean isView, String oldEmail) {
        initComponents();
        this.email = email;
        this.oldEmail = oldEmail;
        System.out.println(this.email);

        Person person = this.personController.show(email);
        Inspection inspectionShow = this.inspectionController.showFkPersonId(person.getIdPerson());

        this.idPerson = person.getIdPerson();
        this.fkPersonId.setText(person.getName() + " " + person.getSurname());
        this.headSize.setText(inspectionShow.getHeadSize() + " cm");
        this.height.setText(inspectionShow.getHeight() + " cm");
        this.weight.setText(inspectionShow.getWeight() + " kg");
        this.footSize.setText(inspectionShow.getFootSize() + "");
        this.weightLifted.setText(inspectionShow.getWeightLifted() + " kg");
        this.report.setText(inspectionShow.getReport());

        this.healthy.setSelected(inspectionShow.isIsHealthy());

        this.fkPersonId.setEditable(false);
        this.headSize.setEditable(false);
        this.height.setEditable(false);
        this.weight.setEditable(false);
        this.footSize.setEditable(false);
        this.weightLifted.setEditable(false);
        this.healthy.setEnabled(false);
        this.report.setEditable(false);
        this.submit1.setVisible(false);

        qualificationController.popularTabelaXXXColigation(qualificationsIndex, idPerson);
        qualiText.setText("Atributos do alistado:");
        qualification.setVisible(false);
        searchQuali.setVisible(false);
        addToList.setVisible(false);
        removeFromList.setVisible(false);
        qualificationsSelected.setVisible(false);
        qualiSelected.setText("Ignorar tabela abaixo");
        submitQuali.setVisible(false);

        interview.setText(personInterviewController.showInterview(person.getIdPerson()).getReport());
        interview.setEditable(false);
        submitInterview.setVisible(false);
        this.recruit.setVisible(false);
        this.toRecruit.setVisible(false);
        if (personController.show(this.oldEmail).getType() == 777) {
            this.toRecruit.setVisible(true);
            this.recruit.setVisible(true);

        }

        this.jTabbedPane2.setEnabledAt(1, true);
        this.jTabbedPane2.setEnabledAt(2, true);
    }

    public void setPerson(int id, String name) {
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
        recruit = new javax.swing.JButton();
        toRecruit = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        qualificationsSelected = new javax.swing.JTable();
        searchQuali = new javax.swing.JButton();
        addToList = new javax.swing.JButton();
        qualification = new javax.swing.JTextField();
        qualiText = new javax.swing.JLabel();
        removeFromList = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        qualificationsIndex = new javax.swing.JTable();
        qualiSelected = new javax.swing.JLabel();
        submitQuali = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        warning3 = new javax.swing.JLabel();
        submitInterview = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        interview = new javax.swing.JTextArea();

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

        recruit.setText("Recrutar");
        recruit.setPreferredSize(new java.awt.Dimension(100, 35));
        recruit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recruitActionPerformed(evt);
            }
        });

        toRecruit.setForeground(new java.awt.Color(53, 53, 53));
        toRecruit.setText("Recrutar");

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
                            .addGap(33, 33, 33))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(34, 34, 34)
                                            .addComponent(weightLifted))
                                        .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(33, 33, 33))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(toRecruit)
                                            .addGap(30, 30, 30)
                                            .addComponent(recruit, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(52, 52, 52))
                                                .addGroup(jPanel7Layout.createSequentialGroup()
                                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(warning1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(submit1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(32, 32, 32)))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(32, 32, 32)))))))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {footSize, jScrollPane2, weight, weightLifted});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
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
                .addGap(18, 18, 18)
                .addComponent(submit1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recruit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toRecruit))
                .addContainerGap(26, Short.MAX_VALUE))
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
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Inspeção", jPanel3);

        jPanel5.setPreferredSize(new java.awt.Dimension(1120, 620));

        jPanel9.setBackground(new java.awt.Color(57, 128, 65));
        jPanel9.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Brasil! Soldado - Qualificações");

        qualificationsSelected.setForeground(new java.awt.Color(29, 29, 29));
        qualificationsSelected.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(qualificationsSelected);

        searchQuali.setForeground(new java.awt.Color(53, 53, 53));
        searchQuali.setText("Pesquisar");
        searchQuali.setPreferredSize(new java.awt.Dimension(100, 35));
        searchQuali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchQualiActionPerformed(evt);
            }
        });

        addToList.setForeground(new java.awt.Color(53, 53, 53));
        addToList.setText("Adicionar >>");
        addToList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToListActionPerformed(evt);
            }
        });

        qualification.setMinimumSize(new java.awt.Dimension(23, 40));
        qualification.setName(""); // NOI18N
        qualification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qualificationActionPerformed(evt);
            }
        });

        qualiText.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        qualiText.setForeground(new java.awt.Color(254, 254, 254));
        qualiText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        qualiText.setText("Selecione uma qualificação (código ou nome):");

        removeFromList.setForeground(new java.awt.Color(53, 53, 53));
        removeFromList.setText("<< Remover");
        removeFromList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFromListActionPerformed(evt);
            }
        });

        qualificationsIndex.setForeground(new java.awt.Color(29, 29, 29));
        qualificationsIndex.setModel(new javax.swing.table.DefaultTableModel(
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
        qualificationsIndex.setCellSelectionEnabled(true);
        jScrollPane3.setViewportView(qualificationsIndex);

        qualiSelected.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        qualiSelected.setForeground(new java.awt.Color(254, 254, 254));
        qualiSelected.setText("Qualificações do Alistado:");

        submitQuali.setText("Enviar Dados");
        submitQuali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitQualiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                            .addComponent(qualification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(searchQuali, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(qualiSelected))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(submitQuali, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(addToList, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(removeFromList, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(42, 42, 42))))
                    .addComponent(qualiText)))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addToList, removeFromList, searchQuali});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(qualiText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qualification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchQuali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qualiSelected))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(addToList)
                        .addGap(18, 18, 18)
                        .addComponent(removeFromList)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitQuali, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addToList, removeFromList, searchQuali, submitQuali});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane3});

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

        jTabbedPane2.addTab("Qualificações", jPanel5);

        jPanel15.setBackground(new java.awt.Color(57, 128, 65));
        jPanel15.setPreferredSize(new java.awt.Dimension(1120, 620));

        jLabel24.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(254, 254, 254));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Brasil! Soldado - Entrevista");

        warning3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        warning3.setForeground(new java.awt.Color(254, 254, 254));
        warning3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        submitInterview.setText("Enviar Dados");
        submitInterview.setPreferredSize(new java.awt.Dimension(100, 35));
        submitInterview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitInterviewActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(254, 254, 254));
        jLabel29.setText("Relatório: *");

        interview.setColumns(20);
        interview.setRows(5);
        jScrollPane7.setViewportView(interview);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(452, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submitInterview, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warning3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(326, 326, 326))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(warning3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitInterview, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Entrevista", jPanel15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitQualiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitQualiActionPerformed
        Person person = personController.show(idPerson);
        boolean response = false;
        PersonQualification personTest = personQualificationController.show(person.getIdPerson());
//        if (personTest != null || !personTest.equals("")) {
//            personQualificationController.delete(person.getIdPerson());
//        }
        for (int i = 0; i < qualifications.size(); i++) {
            PersonQualification personQualification = new PersonQualification();
            personQualification.setFkPersonId(idPerson);
            personQualification.setFkQualificationId(qualifications.get(i).getIdQualification());

            response = personQualificationController.store(personQualification);
        }
        if (response) {
            JOptionPane.showMessageDialog(null, "Qualificações salvas!");
            this.jTabbedPane2.setSelectedIndex(2);
            this.jTabbedPane2.setEnabledAt(2, true);
        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro");
        }
    }//GEN-LAST:event_submitQualiActionPerformed

    private void removeFromListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFromListActionPerformed
        int deleteIndex = -1;
        deleteIndex = Integer.parseInt(String.valueOf(qualificationsSelected.getValueAt(qualificationsSelected.getSelectedRow(), 0)));

        if (deleteIndex > -1) {
            for (int i = 0; i < qualifications.size(); i++) {
                if (qualifications.get(i).getIdQualification() == deleteIndex) {
                    qualifications.remove(i);
                }
            }

            exceptions = "";
            qualifications.forEach(qualification1 -> {
                exceptions += qualification1.getIdQualification() + ",";
            });

            System.out.println(exceptions);
            if (exceptions.equals("") || exceptions == null) {
                this.qualificationController.popularTabelaXXX(qualificationsIndex, this.qualification.getText());
            } else {
                exceptions = exceptions.substring(0, exceptions.length() - 1);
                qualificationController.popularTabelaXXXException(qualificationsIndex, this.qualification.getText(), exceptions);

            }
            qualificationController.popularTabelaXXXDynamics(qualificationsSelected, qualifications);
        }
    }//GEN-LAST:event_removeFromListActionPerformed

    private void qualificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qualificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qualificationActionPerformed

    private void addToListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToListActionPerformed
        int qualiId = -1;
        qualiId = Integer.parseInt(String.valueOf(qualificationsIndex.getValueAt(qualificationsIndex.getSelectedRow(), 0)));

        if (qualiId > -1) {
            Qualification quali = qualificationController.show(qualiId);

            qualifications.add(quali);
            exceptions = "";
            qualifications.forEach(qualification1 -> {
                exceptions += qualification1.getIdQualification() + ",";
            });

            exceptions = exceptions.substring(0, exceptions.length() - 1);

            qualificationController.popularTabelaXXXDynamics(qualificationsSelected, qualifications);
            qualificationController.popularTabelaXXXException(qualificationsIndex, this.qualification.getText(), exceptions);

        }
    }//GEN-LAST:event_addToListActionPerformed

    private void searchQualiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchQualiActionPerformed
        this.qualificationController.popularTabelaXXX(qualificationsIndex, this.qualification.getText());
    }//GEN-LAST:event_searchQualiActionPerformed

    private void searchPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPersonActionPerformed
        DlgPerson dlgSeacrhPerson = new DlgPerson(null, true, this);
        dlgSeacrhPerson.setVisible(true);
    }//GEN-LAST:event_searchPersonActionPerformed

    private void weightLiftedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightLiftedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_weightLiftedActionPerformed

    private void healthyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_healthyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_healthyActionPerformed

    private void footSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_footSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_footSizeActionPerformed

    private void weightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_weightActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        JOptionPane.showMessageDialog(null, "Todo progresso não salvo será perdido");
        if (oldEmail == null || oldEmail.equals("")) {
            System.out.println("YOOOOOOOOO");
            new ViewDashboard(email).setVisible(true);
        } else {
            System.out.println("AEEEEEEEEEEE");
            if (personController.show(oldEmail).getType() == 777) {
                new ViewListInspection(oldEmail).setVisible(true);
            }
        }
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void submit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit1ActionPerformed
        Inspection inspection = new Inspection();
        boolean response = false;
        int idSoldier = idPerson;
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

            this.inspectionController.changeStatus(this.healthy.isSelected(), idSoldier);
            if (response) {
                JOptionPane.showMessageDialog(null, "Registro Salvo com sucesso!");
                if (!this.healthy.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Soldado não saudável, retornando para a tela inicial!");
                    new ViewDashboard(email).setVisible(true);
                    this.setVisible(false);
                }
                this.fkPersonId.setText("");
                this.headSize.setText("");
                this.height.setText("");
                this.weight.setText("");
                this.footSize.setText("");
                this.weightLifted.setText("");
                this.healthy.setSelected(false);
                this.report.setText("");

                this.fkPersonId.requestFocus();

                id = 0;
                this.jTabbedPane2.setSelectedIndex(1);
                this.jTabbedPane2.setEnabledAt(1, true);
                this.qualificationController.popularTabelaXXX(qualificationsIndex, "");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.");
        }
    }//GEN-LAST:event_submit1ActionPerformed

    private void submitInterviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitInterviewActionPerformed
        if (Validacao.notNull(interview.getText())) {
            Interview newInterview = new Interview();

            newInterview.setReport(interview.getText());

            int intId = interviewController.storeReturningId(newInterview);

            PersonInterview personInterview = new PersonInterview();
            personInterview.setFkPersonId(idPerson);
            personInterview.setFkInterviewId(intId);

            if (personInterviewController.store(personInterview)) {
                JOptionPane.showMessageDialog(null, "Registro Salvo com sucesso!");
                new ViewDashboard(email).setVisible(true);
                this.setVisible(false);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.");
        }
    }//GEN-LAST:event_submitInterviewActionPerformed

    private void recruitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recruitActionPerformed
        this.inspectionController.changeStatusToEnlisted(this.toRecruit.isSelected(), idPerson);
        new ViewListInspection(oldEmail).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_recruitActionPerformed

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
    private javax.swing.JButton addToList;
    private javax.swing.JButton back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JTextField fkPersonId;
    private javax.swing.JTextField footSize;
    private javax.swing.JTextField headSize;
    private javax.swing.JRadioButton healthy;
    private javax.swing.JTextField height;
    private javax.swing.JTextArea interview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel qualiSelected;
    private javax.swing.JLabel qualiText;
    private javax.swing.JTextField qualification;
    private javax.swing.JTable qualificationsIndex;
    private javax.swing.JTable qualificationsSelected;
    private javax.swing.JButton recruit;
    private javax.swing.JButton removeFromList;
    private javax.swing.JTextArea report;
    private javax.swing.JButton searchPerson;
    private javax.swing.JButton searchQuali;
    private javax.swing.JButton submit1;
    private javax.swing.JButton submitInterview;
    private javax.swing.JButton submitQuali;
    private javax.swing.JCheckBox toRecruit;
    private javax.swing.JLabel warning1;
    private javax.swing.JLabel warning3;
    private javax.swing.JTextField weight;
    private javax.swing.JTextField weightLifted;
    // End of variables declaration//GEN-END:variables
}
