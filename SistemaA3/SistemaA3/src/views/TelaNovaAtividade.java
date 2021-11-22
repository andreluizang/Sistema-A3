/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import database.AtividadeDAO;
import database.ConexaoDAO;
import database.DisciplinaDAO;
import database.EstudanteDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Atividade;

/**
 *
 * @author andre
 */
public class TelaNovaAtividade extends javax.swing.JFrame {
    
    Atividade atividade = new Atividade();
    AtividadeDAO atividadedao = new AtividadeDAO();

    /**
     * Creates new form TelaNovaAtividade
     */
    public TelaNovaAtividade() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        disciplinaLabel = new javax.swing.JLabel();
        notaLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        notaMaxTextPane = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        atividadeTextPane = new javax.swing.JTextPane();
        concluidaCheckBox = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        descricaoTextArea = new javax.swing.JTextArea();
        descricaoLabel = new javax.swing.JLabel();
        atividadeLabel = new javax.swing.JLabel();
        disciplinasComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        notaTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        novaDsclpnButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        diaTextField = new javax.swing.JTextField();
        mesTextField = new javax.swing.JTextField();
        anoTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        diaConclusaoTextField = new javax.swing.JTextField();
        mesConclusaoTextField = new javax.swing.JTextField();
        anoConclusaoTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        voltarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        disciplinaLabel.setText("Disciplina");

        notaLabel.setText("Nota Máxima");

        notaMaxTextPane.setText("0.0");
        notaMaxTextPane.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane3.setViewportView(notaMaxTextPane);

        jScrollPane6.setViewportView(atividadeTextPane);

        concluidaCheckBox.setText("Concluída");
        concluidaCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                concluidaCheckBoxStateChanged(evt);
            }
        });
        concluidaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concluidaCheckBoxActionPerformed(evt);
            }
        });

        descricaoTextArea.setColumns(20);
        descricaoTextArea.setRows(5);
        jScrollPane2.setViewportView(descricaoTextArea);

        descricaoLabel.setText("Descrição");

        atividadeLabel.setText("Atividade");

        disciplinasComboBox.setMaximumSize(new java.awt.Dimension(79, 20));
        disciplinasComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                disciplinasComboBoxItemStateChanged(evt);
            }
        });
        disciplinasComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disciplinasComboBoxMouseClicked(evt);
            }
        });

        jLabel2.setText("Nota");

        notaTextField.setText("0.0");
        notaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notaTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Prazo");

        novaDsclpnButton.setText("(+) Nova");
        novaDsclpnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaDsclpnButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Nova atividade");

        diaTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        mesTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        anoTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setText(" Dia      Mês       Ano");

        diaConclusaoTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        diaConclusaoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaConclusaoTextFieldActionPerformed(evt);
            }
        });

        mesConclusaoTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        anoConclusaoTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText(" Dia      Mês       Ano");

        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(atividadeLabel)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(disciplinaLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(novaDsclpnButton))
                                    .addComponent(disciplinasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(40, 40, 40)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notaLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(diaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(mesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(anoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(voltarButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(diaConclusaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(mesConclusaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(anoConclusaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(15, 15, 15)
                                            .addComponent(concluidaCheckBox)))
                                    .addGap(27, 27, 27)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(notaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(171, 171, 171)
                            .addComponent(okButton))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(descricaoLabel, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(atividadeLabel)
                            .addComponent(disciplinaLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(disciplinasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(novaDsclpnButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(notaLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(diaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(anoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addGap(9, 9, 9)
                .addComponent(descricaoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(okButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(concluidaCheckBox)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(diaConclusaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mesConclusaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(anoConclusaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(notaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(voltarButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        
        String nome = atividadeTextPane.getText();
        String descricao = descricaoTextArea.getText();
        int idDisciplina = 0;
        String querySelect = "SELECT id FROM DISCIPLINA WHERE nome = ? AND fk_estudante = ?";
        ArrayList<Object> dadosSelect = new ArrayList<>();
        dadosSelect.add(disciplinasComboBox.getSelectedItem().toString());
        dadosSelect.add(EstudanteDAO.estudante.getId());
        ConexaoDAO conexao = new ConexaoDAO();
        conexao.getConnection();
        ResultSet rs = conexao.Select(querySelect, dadosSelect);
        try{
            if(rs!= null && rs.next())
                idDisciplina = rs.getInt(1);
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.closeConnection();
        double notaMaxima = Double.parseDouble(notaMaxTextPane.getText());
        LocalDate p = LocalDate.of(Integer.parseInt(anoTextField.getText()),
                Integer.parseInt(mesTextField.getText()),
                Integer.parseInt(diaTextField.getText()));
        LocalDate prazo = p.withDayOfMonth(Integer.parseInt(diaTextField.getText()));
        boolean concluida = concluidaCheckBox.isSelected();
        LocalDate dataConclusao;
        double nota;
        if(concluida){
            dataConclusao = LocalDate.of(Integer.parseInt(anoConclusaoTextField.getText()),
                Integer.parseInt(mesConclusaoTextField.getText()),
                Integer.parseInt(diaConclusaoTextField.getText()));
            nota = Double.parseDouble(notaTextField.getText());

        }else{
            dataConclusao = LocalDate.of(1970, 1, 1);
            nota = -1;
        }
        
        int idEstudante = EstudanteDAO.estudante.getId();
        
        atividadedao.cadastrarAtividade(nome, descricao, idDisciplina, nota, notaMaxima,
            prazo, concluida, dataConclusao, idEstudante);        
    }//GEN-LAST:event_okButtonActionPerformed

    private void concluidaCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concluidaCheckBoxActionPerformed

    }//GEN-LAST:event_concluidaCheckBoxActionPerformed

    private void disciplinasComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disciplinasComboBoxMouseClicked
    }//GEN-LAST:event_disciplinasComboBoxMouseClicked

    private void disciplinasComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_disciplinasComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_disciplinasComboBoxItemStateChanged

    private void novaDsclpnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaDsclpnButtonActionPerformed
        //Cadastrar nova disciplina
        String novaDisciplina = JOptionPane.showInputDialog("Digite o nome da disciplina: ");       
        DisciplinaDAO disciplinadao = new DisciplinaDAO();
        boolean cadastrada = false;
        if(!DisciplinaDAO.disciplina.isEmpty()){
            for(int i = 0; i < DisciplinaDAO.disciplina.size(); i++){
                if(novaDisciplina.equals(DisciplinaDAO.disciplina.get(i).getNome())){
                    cadastrada = true;
                    break;
                }else{
                    cadastrada = false;
                }
            }
        }
        if(cadastrada){
            JOptionPane.showMessageDialog(null, "Essa disciplina já está cadastrada!", "ERRO!", 0);
            System.out.println("Essa disciplina já está cadastrada!");
        }else{
            disciplinadao.cadastrarDisciplina(novaDisciplina);
        }
        
        disciplinasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(disciplinadao.formatarComboBox()));
    }//GEN-LAST:event_novaDsclpnButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DisciplinaDAO disciplinadao = new DisciplinaDAO();
        disciplinasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(disciplinadao.formatarComboBox()));

    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void notaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notaTextFieldActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        dispose();
        TelaAtividades tela = new TelaAtividades();
        tela.show();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void concluidaCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_concluidaCheckBoxStateChanged
    }//GEN-LAST:event_concluidaCheckBoxStateChanged

    private void diaConclusaoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaConclusaoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diaConclusaoTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(TelaNovaAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovaAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovaAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovaAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNovaAtividade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anoConclusaoTextField;
    private javax.swing.JTextField anoTextField;
    private javax.swing.JLabel atividadeLabel;
    private javax.swing.JTextPane atividadeTextPane;
    private javax.swing.JCheckBox concluidaCheckBox;
    private javax.swing.JLabel descricaoLabel;
    private javax.swing.JTextArea descricaoTextArea;
    private javax.swing.JTextField diaConclusaoTextField;
    private javax.swing.JTextField diaTextField;
    private javax.swing.JLabel disciplinaLabel;
    private javax.swing.JComboBox<String> disciplinasComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField mesConclusaoTextField;
    private javax.swing.JTextField mesTextField;
    private javax.swing.JLabel notaLabel;
    private javax.swing.JTextPane notaMaxTextPane;
    private javax.swing.JTextField notaTextField;
    private javax.swing.JButton novaDsclpnButton;
    private javax.swing.JButton okButton;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
