/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester_001;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jou
 */
public class NewJFrameCreateuser extends javax.swing.JFrame {

    public static ArrayList<Username> arr=new ArrayList<Username>();
    public NewJFrameCreateuser() {
        initComponents();
        reset();
    }

    public void reset()
    {
        TFUsername.setText("");
        TFPassword.setText("");
        TFConfirm.setText("");
        TFNotelp.setText("");
        TAAlamat.setText("");
        TFNama.setText("");
        
    }
    public int checknotelp(String notelp)
    {
        int index_return=0;
        String[] ars={"1","2","3","4","5","6","7","8","9","0"};
        if(notelp.length()>8)
        {
            index_return=0;
        }
        else{
            int akhir=1;
            String sub="";
            for (int i = 0; i < notelp.length(); i++) {
                for (int j = 0; j < ars.length; j++) {
                    sub=notelp.substring(i,akhir);
                    if(sub.equals(ars[j]))index_return++;
                }
                if(akhir!=notelp.length())akhir++;
            }
        }
        if(index_return==notelp.length())index_return=-1;
        return index_return;
    }
    public int checkusername(String Username)
    {
        int index_return=1;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getUser().equals(Username))
            {index_return=-1;break;}
            else{index_return=1;}
        }
        return index_return;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TFUsername = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        TFPassword = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TAAlamat = new javax.swing.JTextArea();
        TFConfirm = new javax.swing.JTextField();
        TFNotelp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TFNama = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("USERNAME");

        jLabel2.setText("PASSWORD");

        jLabel3.setText("CONFIRMPASSWORD");

        TFUsername.setText("jTextField1");

        jButton1.setText("CREATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TFPassword.setText("jTextField2");

        jButton2.setText("BACK To LOGIN PAGE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Alamat");

        TAAlamat.setColumns(20);
        TAAlamat.setRows(5);
        jScrollPane1.setViewportView(TAAlamat);

        TFConfirm.setText("jTextField1");

        TFNotelp.setText("jTextField2");

        jLabel5.setText("NO Telp");

        jLabel6.setText("NAMA");

        TFNama.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TFNotelp)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)
                                .addComponent(TFUsername)
                                .addComponent(TFNama))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TFConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TFConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TFNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFNotelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        NewJFrameLogin frm=new NewJFrameLogin();
        frm.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(TFUsername.getText().equals("")||TFNama.getText().equals("") ||TFPassword.getText().equals("")||TFConfirm.getText().equals("")||TFNotelp.getText().equals("")||TAAlamat.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "One or more column is empty", "empty Column",1);
        }
        else
        {
            int check=0;
            String Username=TFUsername.getText();
            if(checkusername(Username)==-1){
                JOptionPane.showMessageDialog(null, "Username sudah ada","Create new Username",1);
                reset();
            }
            else
            {
                String password=TFPassword.getText();
                String confirm=TFConfirm.getText();
                if(password.equals(confirm))
                {
                    String nama=TFNama.getText();
                    String alamat=TAAlamat.getText();
                    String notelp=TFNotelp.getText();
                    if(checknotelp(notelp)==-1)
                    {
                        long telp=Long.parseLong(notelp);
                        Username obj;
                        obj=new Username(Username, password, nama, alamat, telp);
//                        check=100;
//                        obj.inputarr(check,obj);
                        arr.add(obj);
                        JOptionPane.showMessageDialog(null, "username berhasil dibuat","Success",1);
                        reset();
                    }
                    else if(checknotelp(notelp)==0)
                    {                        
                        JOptionPane.showMessageDialog(null, "Panjang telepon tidak boleh lebih dari 8","panjang notelp",1);
                        TFNotelp.setText("");
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "Telepon harus mengandung angka!","Char on telepon",1);
                        TFNotelp.setText("");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Passwords didn't match","Try again ",1);
                    TFPassword.setText("");
                    TFConfirm.setText("");
                }
            }
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrameCreateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrameCreateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrameCreateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrameCreateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrameCreateuser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TAAlamat;
    private javax.swing.JTextField TFConfirm;
    private javax.swing.JTextField TFNama;
    private javax.swing.JTextField TFNotelp;
    private javax.swing.JTextField TFPassword;
    private javax.swing.JTextField TFUsername;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
