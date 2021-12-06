/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import database.EstudanteDAO;
/**
 *
 * @author andre
 */
public class TelaInicial extends javax.swing.JFrame {
    private EstudanteDAO estudantedao = new EstudanteDAO();
    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
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

        bemvindoLabel = new javax.swing.JLabel();
        tituloLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        atividadesButton = new javax.swing.JButton();
        conteudosButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1143, 668));
        setPreferredSize(new java.awt.Dimension(1143, 668));
        getContentPane().setLayout(null);

        bemvindoLabel.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        bemvindoLabel.setForeground(new java.awt.Color(51, 0, 51));
        bemvindoLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bemvindoLabel.setText(EstudanteDAO.estudante.getNome());
        getContentPane().add(bemvindoLabel);
        bemvindoLabel.setBounds(250, 150, 190, 21);

        tituloLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        tituloLabel.setText("Study It Yourself!");
        getContentPane().add(tituloLabel);
        tituloLabel.setBounds(470, 610, 290, 40);

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Grupo 26.png"))); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.setBorderPainted(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });
        getContentPane().add(logoutButton);
        logoutButton.setBounds(30, 610, 170, 50);

        atividadesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Grupo 27.png"))); // NOI18N
        atividadesButton.setBorderPainted(false);
        atividadesButton.setContentAreaFilled(false);
        atividadesButton.setDefaultCapable(false);
        atividadesButton.setFocusPainted(false);
        atividadesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atividadesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(atividadesButton);
        atividadesButton.setBounds(550, 300, 280, 70);

        conteudosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Grupo 28.png"))); // NOI18N
        conteudosButton.setText("Conteúdos");
        conteudosButton.setBorderPainted(false);
        conteudosButton.setContentAreaFilled(false);
        conteudosButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conteudosButtonMouseClicked(evt);
            }
        });
        conteudosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conteudosButtonActionPerformed(evt);
            }
        });
        getContentPane().add(conteudosButton);
        conteudosButton.setBounds(560, 400, 270, 70);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/image-from-rawpixel-id-2721421-png.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(790, 470, 280, 250);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Grupo 25.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 110, 460, 106);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Grupo 29.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(250, 220, 630, 440);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Grupo 24.png"))); // NOI18N
        jLabel1.setAutoscrolls(true);
        jLabel1.setDoubleBuffered(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -90, 1310, 840);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        estudantedao.fazerLogout();
        dispose();
        TelaLogin tela = new TelaLogin();
        tela.show();
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void atividadesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atividadesButtonActionPerformed
        dispose();
        TelaAtividades tela = new TelaAtividades();
        tela.show();
    }//GEN-LAST:event_atividadesButtonActionPerformed

    private void conteudosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conteudosButtonActionPerformed
        dispose();
        TelaConteudos tela = new TelaConteudos();
        tela.show();
    }//GEN-LAST:event_conteudosButtonActionPerformed

    private void conteudosButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conteudosButtonMouseClicked

    }//GEN-LAST:event_conteudosButtonMouseClicked

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atividadesButton;
    private javax.swing.JLabel bemvindoLabel;
    private javax.swing.JButton conteudosButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables
}
