/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester_001;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jou
 */
public class NewJFrameLogin extends javax.swing.JFrame {

    NewJFrameCredit cdr;
    boolean credit_status=false;
    public NewJFrameLogin() {
        initComponents();
//        ImageIcon pic = new ImageIcon("src/tester_001/lock.jpg");
//        Image icon = pic.getImage();
//        Image real = icon.getScaledInstance(25, 30, java.awt.Image.SCALE_SMOOTH);
//        pic = new ImageIcon(real);
//        pass.setIcon(pic);
        pass.setText("");
//        ImageIcon pic2 = new ImageIcon("src/tester_001/user.png");
//        Image icon2 = pic2.getImage();
//        Image real2 = icon2.getScaledInstance(25, 30, java.awt.Image.SCALE_SMOOTH);
//        pic2 = new ImageIcon(real2);
//        id.setIcon(pic2);
        id.setText("");
        reset();
    }
    public void reset()
    {
        TFUsername.setText("");
        TFPassword.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        TFUsername = new javax.swing.JTextField();
        TFPassword = new javax.swing.JPasswordField();
        id = new javax.swing.JLabel();
        pass = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BackGroundLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LOG IN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 230, -1));

        TFUsername.setBackground(new java.awt.Color(0, 0, 0));
        TFUsername.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        TFUsername.setForeground(new java.awt.Color(255, 255, 255));
        TFUsername.setText("jTextField1");
        getContentPane().add(TFUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 190, -1));

        TFPassword.setBackground(new java.awt.Color(0, 0, 0));
        TFPassword.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        TFPassword.setForeground(new java.awt.Color(255, 255, 255));
        TFPassword.setText("jPasswordField1");
        TFPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(TFPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 190, -1));

        id.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/user.png"))); // NOI18N
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/lock.jpg"))); // NOI18N
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Credit");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        BackGroundLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/BackgroundLogin.jpg"))); // NOI18N
        getContentPane().add(BackGroundLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(TFUsername.getText().equalsIgnoreCase("admin")&& TFPassword.getText().equalsIgnoreCase("admin"))
       {
           setVisible(false);
           NewJFrameAdmin frm=new NewJFrameAdmin();
           frm.setVisible(true);
       }
       else JOptionPane.showMessageDialog(null,"username/password salah");
           
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TFPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFPasswordActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if(credit_status==false){
            cdr=new NewJFrameCredit(this);
            cdr.setVisible(true);
            credit_status=false;
        }
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(NewJFrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrameLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGroundLogin;
    private javax.swing.JPasswordField TFPassword;
    private javax.swing.JTextField TFUsername;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel pass;
    // End of variables declaration//GEN-END:variables
}
