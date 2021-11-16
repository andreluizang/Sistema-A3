/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import database.DisciplinaDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andre
 */
public class TelaNovaAtividade extends javax.swing.JFrame {

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
        prazoLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        notaTextPane = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        prazoTextPane = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        atividadeTextPane = new javax.swing.JTextPane();
        concluidaCheckBox = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        descricaoTextArea = new javax.swing.JTextArea();
        descricaoLabel = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        concluidaTextPane = new javax.swing.JTextPane();
        atividadeLabel = new javax.swing.JLabel();
        disciplinasComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        notaTextPane1 = new javax.swing.JTextPane();
        novaDsclpnButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

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

        prazoLabel.setText("Prazo");

        notaTextPane.setText("0.0");
        jScrollPane3.setViewportView(notaTextPane);

        prazoTextPane.setText("00/00/0000");
        jScrollPane5.setViewportView(prazoTextPane);

        jScrollPane6.setViewportView(atividadeTextPane);

        concluidaCheckBox.setText("Concluída");
        concluidaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concluidaCheckBoxActionPerformed(evt);
            }
        });

        descricaoTextArea.setColumns(20);
        descricaoTextArea.setRows(5);
        jScrollPane2.setViewportView(descricaoTextArea);

        descricaoLabel.setText("Descrição");

        concluidaTextPane.setEditable(false);
        concluidaTextPane.setText("00/00/0000");
        jScrollPane8.setViewportView(concluidaTextPane);

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

        jTextField1.setText("0.0");

        jLabel3.setText("Prazo");

        notaTextPane1.setText("0000-00-00");
        jScrollPane4.setViewportView(notaTextPane1);

        novaDsclpnButton.setText("(+) Nova");
        novaDsclpnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaDsclpnButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Nova atividade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(atividadeLabel)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(disciplinaLabel)
                                    .addComponent(novaDsclpnButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(disciplinasComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notaLabel)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(concluidaCheckBox)
                            .addComponent(descricaoLabel)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(okButton))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(270, 270, 270))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(prazoLabel)
                        .addGap(118, 118, 118))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(notaLabel)
                                .addComponent(jLabel3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(atividadeLabel)
                                .addComponent(disciplinaLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(disciplinasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(novaDsclpnButton)
                        .addGap(7, 7, 7)
                        .addComponent(descricaoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(concluidaCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(okButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(prazoLabel)
                .addGap(142, 142, 142)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        //CADASTRAR NOVA ATIVIDADE
        
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
    private javax.swing.JLabel atividadeLabel;
    private javax.swing.JTextPane atividadeTextPane;
    private javax.swing.JCheckBox concluidaCheckBox;
    private javax.swing.JTextPane concluidaTextPane;
    private javax.swing.JLabel descricaoLabel;
    private javax.swing.JTextArea descricaoTextArea;
    private javax.swing.JLabel disciplinaLabel;
    private javax.swing.JComboBox<String> disciplinasComboBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel notaLabel;
    private javax.swing.JTextPane notaTextPane;
    private javax.swing.JTextPane notaTextPane1;
    private javax.swing.JButton novaDsclpnButton;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel prazoLabel;
    private javax.swing.JTextPane prazoTextPane;
    // End of variables declaration//GEN-END:variables
}