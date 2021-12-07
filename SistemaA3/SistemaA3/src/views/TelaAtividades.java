/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import database.AtividadeDAO;
import database.ConexaoDAO;
import database.EstudanteDAO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author andre
 */
public class TelaAtividades extends javax.swing.JFrame {
    private EstudanteDAO estudantedao = new EstudanteDAO();
    private AtividadeDAO atividadedao = new AtividadeDAO();


    /**
     * Creates new form TelaAtividades
     */
    public TelaAtividades() {
        initComponents();
    }

    private void obj_btn_startActionPerformed(java.awt.event.ActionEvent evt){
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        atividadesTabela = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        descricaoTextArea = new javax.swing.JTextArea();
        concluidaCheckBox = new javax.swing.JCheckBox();
        atividadeTextField = new javax.swing.JTextField();
        disciplinaTextField = new javax.swing.JTextField();
        notaTextField = new javax.swing.JTextField();
        notaMaxTextField = new javax.swing.JTextField();
        diaConcluidaTextField = new javax.swing.JTextField();
        mesConcluidaTextField = new javax.swing.JTextField();
        anoConcluidaTextField = new javax.swing.JTextField();
        diaTextField = new javax.swing.JTextField();
        mesTextField = new javax.swing.JTextField();
        anoTextField = new javax.swing.JTextField();
        salvar = new javax.swing.JLabel();
        deletar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1165, 684));
        setPreferredSize(new java.awt.Dimension(1165, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        atividadesTabela.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        atividadesTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Atividade", "Disciplina", "Descrição", "Prazo", "Concluida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        atividadesTabela.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        atividadesTabela.setRowHeight(30);
        atividadesTabela.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                atividadesTabelaFocusGained(evt);
            }
        });
        atividadesTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atividadesTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(atividadesTabela);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 130, 530, 510);

        jScrollPane2.setBorder(null);

        descricaoTextArea.setColumns(20);
        descricaoTextArea.setRows(5);
        jScrollPane2.setViewportView(descricaoTextArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(570, 300, 490, 150);

        concluidaCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        concluidaCheckBox.setToolTipText("");
        concluidaCheckBox.setMaximumSize(new java.awt.Dimension(12, 12));
        concluidaCheckBox.setMinimumSize(new java.awt.Dimension(1, 1));
        concluidaCheckBox.setPreferredSize(new java.awt.Dimension(5, 5));
        concluidaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concluidaCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(concluidaCheckBox);
        concluidaCheckBox.setBounds(567, 480, 20, 10);

        atividadeTextField.setBorder(null);
        atividadeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atividadeTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(atividadeTextField);
        atividadeTextField.setBounds(570, 170, 350, 14);

        disciplinaTextField.setBackground(new java.awt.Color(255, 255, 255));
        disciplinaTextField.setBorder(null);
        getContentPane().add(disciplinaTextField);
        disciplinaTextField.setBounds(570, 223, 350, 20);

        notaTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        notaTextField.setText("0.0");
        notaTextField.setBorder(null);
        getContentPane().add(notaTextField);
        notaTextField.setBounds(990, 170, 50, 14);

        notaMaxTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        notaMaxTextField.setText("0.0");
        notaMaxTextField.setBorder(null);
        getContentPane().add(notaMaxTextField);
        notaMaxTextField.setBounds(1071, 167, 40, 20);

        diaConcluidaTextField.setBorder(null);
        getContentPane().add(diaConcluidaTextField);
        diaConcluidaTextField.setBounds(570, 514, 30, 20);

        mesConcluidaTextField.setBorder(null);
        getContentPane().add(mesConcluidaTextField);
        mesConcluidaTextField.setBounds(621, 514, 30, 20);

        anoConcluidaTextField.setBorder(null);
        getContentPane().add(anoConcluidaTextField);
        anoConcluidaTextField.setBounds(670, 514, 50, 20);

        diaTextField.setBorder(null);
        getContentPane().add(diaTextField);
        diaTextField.setBounds(910, 514, 30, 20);

        mesTextField.setBorder(null);
        getContentPane().add(mesTextField);
        mesTextField.setBounds(960, 514, 30, 20);

        anoTextField.setBorder(null);
        getContentPane().add(anoTextField);
        anoTextField.setBounds(1010, 514, 50, 20);

        salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salvarMouseClicked(evt);
            }
        });
        getContentPane().add(salvar);
        salvar.setBounds(850, 600, 100, 40);

        deletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletarMouseClicked(evt);
            }
        });
        getContentPane().add(deletar);
        deletar.setBounds(680, 600, 110, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Grupo 43.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1060, 620, 90, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Grupo 47.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 650, 80, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Atualizar.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(430, 640, 110, 43);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ATIVIDADE.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-6, 0, 1170, 690);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void atividadesTabelaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_atividadesTabelaFocusGained
        
    }//GEN-LAST:event_atividadesTabelaFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String[] col = {"Nome", "Disciplina", "Descrição", "Prazo", "Concluída"};
        
        TelaAtividades tela = new TelaAtividades();
        DefaultTableModel model = (DefaultTableModel) atividadesTabela.getModel();
        atividadesTabela.setModel(model);
        model.setDataVector(atividadedao.formatarTabela(), col);
        
        if (atividadesTabela.getColumnModel().getColumnCount() > 0) {
            atividadesTabela.getColumnModel().getColumn(0).setMinWidth(100);
            atividadesTabela.getColumnModel().getColumn(0).setPreferredWidth(100);
            atividadesTabela.getColumnModel().getColumn(0).setMaxWidth(150);
            atividadesTabela.getColumnModel().getColumn(1).setMinWidth(100);
            atividadesTabela.getColumnModel().getColumn(1).setPreferredWidth(100);
            atividadesTabela.getColumnModel().getColumn(1).setMaxWidth(150);
            atividadesTabela.getColumnModel().getColumn(3).setMinWidth(80);
            atividadesTabela.getColumnModel().getColumn(3).setPreferredWidth(80);
            atividadesTabela.getColumnModel().getColumn(3).setMaxWidth(80);
            atividadesTabela.getColumnModel().getColumn(4).setMinWidth(65);
            atividadesTabela.getColumnModel().getColumn(4).setPreferredWidth(65);
            atividadesTabela.getColumnModel().getColumn(4).setMaxWidth(65);

        }                                        
    }//GEN-LAST:event_formWindowOpened

    private void atividadesTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atividadesTabelaMouseClicked
        int index = atividadesTabela.getSelectedRow();
        System.out.println(index);
        System.out.println(AtividadeDAO.atividades.get(index).getNome());
        atividadeTextField.setText(AtividadeDAO.atividades.get(index).getNome());
        disciplinaTextField.setText(AtividadeDAO.atividades.get(index).getNomeDisciplina());
        descricaoTextArea.setText(AtividadeDAO.atividades.get(index).getDescricao());
        concluidaCheckBox.setSelected(AtividadeDAO.atividades.get(index).isConcluida());
        notaMaxTextField.setText(Double.toString(AtividadeDAO.atividades.get(index).getNotaMax()));
        if(AtividadeDAO.atividades.get(index).isConcluida()){
            notaTextField.setText(Double.toString(AtividadeDAO.atividades.get(index).getNota()));
            diaConcluidaTextField.setText(Integer.toString(AtividadeDAO.atividades.get(index).getDataconclusao().getDayOfMonth()));
            mesConcluidaTextField.setText(Integer.toString(AtividadeDAO.atividades.get(index).getDataconclusao().getMonthValue()));
            anoConcluidaTextField.setText(Integer.toString(AtividadeDAO.atividades.get(index).getDataconclusao().getYear()));
        }else{
            notaTextField.setText("");
            diaConcluidaTextField.setText("");
            mesConcluidaTextField.setText("");
            anoConcluidaTextField.setText("");
        }

        diaTextField.setText(Integer.toString(AtividadeDAO.atividades.get(index).getPrazo().getDayOfMonth()));
        mesTextField.setText(Integer.toString(AtividadeDAO.atividades.get(index).getPrazo().getMonthValue()));
        anoTextField.setText(Integer.toString(AtividadeDAO.atividades.get(index).getPrazo().getYear()));
        
                
    }//GEN-LAST:event_atividadesTabelaMouseClicked

    private void concluidaCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concluidaCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_concluidaCheckBoxActionPerformed

    private void atividadeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atividadeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_atividadeTextFieldActionPerformed

    private void salvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salvarMouseClicked
        String nome = atividadeTextField.getText();
        String descricao = descricaoTextArea.getText();
        double notaMaxima = Double.parseDouble(notaMaxTextField.getText());
        boolean concluida = concluidaCheckBox.isSelected();
        LocalDate prazo = LocalDate.of(Integer.parseInt(anoTextField.getText()),
                Integer.parseInt(mesTextField.getText()), Integer.parseInt(diaTextField.getText()));
        LocalDate dataConclusao;
        double nota;
        if(concluidaCheckBox.isSelected()){
            dataConclusao = LocalDate.of(Integer.parseInt(anoConcluidaTextField.getText()),
                    Integer.parseInt(mesConcluidaTextField.getText()), Integer.parseInt(diaConcluidaTextField.getText()));
            nota = Double.parseDouble(notaTextField.getText());
        }else{
            dataConclusao = LocalDate.of(1970, 1, 1);
            nota = -1;
        }
        int id = AtividadeDAO.atividades.get(atividadesTabela.getSelectedRow()).getId();
        int localId = atividadesTabela.getSelectedRow();
        atividadedao.atualizarAtividade(id, nome, descricao, nota, notaMaxima, concluida, prazo, dataConclusao, localId);
    }//GEN-LAST:event_salvarMouseClicked

    private void deletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletarMouseClicked
        Object[] options = { "Confirmar", "Cancelar" };
        int confirma = JOptionPane.showOptionDialog(null, "Clique Confirmar para continuar", "Essa ação é permanente!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        if(confirma==0){
            int id = AtividadeDAO.atividades.get(atividadesTabela.getSelectedRow()).getId();
            int localId = atividadesTabela.getSelectedRow();
            atividadedao.deletarAtividade(id, localId);
        }
    }//GEN-LAST:event_deletarMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
        TelaNovaAtividade tela =new TelaNovaAtividade();
        tela.show();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        dispose();
        TelaInicial tela = new TelaInicial();
        tela.show();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        String[] col = {"Nome", "Disciplina", "Descrição", "Prazo", "Concluída"};
        
        TelaAtividades tela = new TelaAtividades();
        DefaultTableModel model = (DefaultTableModel) atividadesTabela.getModel();
        atividadesTabela.setModel(model);
        model.setDataVector(atividadedao.formatarTabela(), col);
        
        if (atividadesTabela.getColumnModel().getColumnCount() > 0) {
            atividadesTabela.getColumnModel().getColumn(0).setMinWidth(100);
            atividadesTabela.getColumnModel().getColumn(0).setPreferredWidth(100);
            atividadesTabela.getColumnModel().getColumn(0).setMaxWidth(150);
            atividadesTabela.getColumnModel().getColumn(1).setMinWidth(100);
            atividadesTabela.getColumnModel().getColumn(1).setPreferredWidth(100);
            atividadesTabela.getColumnModel().getColumn(1).setMaxWidth(150);
            atividadesTabela.getColumnModel().getColumn(3).setMinWidth(80);
            atividadesTabela.getColumnModel().getColumn(3).setPreferredWidth(80);
            atividadesTabela.getColumnModel().getColumn(3).setMaxWidth(80);
            atividadesTabela.getColumnModel().getColumn(4).setMinWidth(65);
            atividadesTabela.getColumnModel().getColumn(4).setPreferredWidth(65);
            atividadesTabela.getColumnModel().getColumn(4).setMaxWidth(65);
        }
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(TelaAtividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAtividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAtividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAtividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAtividades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anoConcluidaTextField;
    private javax.swing.JTextField anoTextField;
    private javax.swing.JTextField atividadeTextField;
    private javax.swing.JTable atividadesTabela;
    private javax.swing.JCheckBox concluidaCheckBox;
    private javax.swing.JLabel deletar;
    private javax.swing.JTextArea descricaoTextArea;
    private javax.swing.JTextField diaConcluidaTextField;
    private javax.swing.JTextField diaTextField;
    private javax.swing.JTextField disciplinaTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mesConcluidaTextField;
    private javax.swing.JTextField mesTextField;
    private javax.swing.JTextField notaMaxTextField;
    private javax.swing.JTextField notaTextField;
    private javax.swing.JLabel salvar;
    // End of variables declaration//GEN-END:variables
}
