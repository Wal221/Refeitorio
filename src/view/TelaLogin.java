/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.FuncionarioDAO;
import Model.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Administrador
 */
public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public JPasswordField getCampSenha() {
        return campSenha;
    }

    public void setCampSenha(JPasswordField campSenha) {
        this.campSenha = campSenha;
    }

    public JFormattedTextField getCampUser() {
        return campUser;
    }

    public void setCampUser(JFormattedTextField campUser) {
        this.campUser = campUser;
    }

    
    public JButton getButtonLogin() {
        return ButtonLogin;
    }

    public void setButtonLogin(JButton ButtonLogin) {
        this.ButtonLogin = ButtonLogin;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campUser = new javax.swing.JFormattedTextField();
        campSenha = new javax.swing.JPasswordField();
        ButtonLogin = new javax.swing.JButton();
        cadastrFunciona = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campUserActionPerformed(evt);
            }
        });
        getContentPane().add(campUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 150, 30));
        getContentPane().add(campSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 302, 150, 30));

        ButtonLogin.setText("Login");
        ButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        cadastrFunciona.setText("cadastra");
        cadastrFunciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrFuncionaActionPerformed(evt);
            }
        });
        getContentPane().add(cadastrFunciona, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/New Arrivals (2) (1).png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campUserActionPerformed

    private void ButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoginActionPerformed
   
        try{
        int user = Integer.parseInt(campUser.getText());
     String senha = campSenha.getText();
    
     Funcionario fun = new Funcionario(user, senha);
     FuncionarioDAO funcionario = new FuncionarioDAO();
     
     
     ResultSet rsfunc = funcionario.autenti(fun);
     if(rsfunc.next()){
         new TelaPrincipal().setVisible(true);
         dispose();
     }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Senha ou matriculas incorretas");
        }
        

    }//GEN-LAST:event_ButtonLoginActionPerformed

    private void cadastrFuncionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrFuncionaActionPerformed
       new TelaCadastroFunc().setVisible(true);
    }//GEN-LAST:event_cadastrFuncionaActionPerformed

    /**ç;
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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLogin;
    private javax.swing.JButton cadastrFunciona;
    private javax.swing.JPasswordField campSenha;
    private javax.swing.JFormattedTextField campUser;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
