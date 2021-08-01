/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester_001;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class NewJFrame_transactionReport extends javax.swing.JFrame {

    
    Connection con;
    Statement statement;
    PreparedStatement ps;
    ResultSet rs;
    DefaultTableModel dt;
    ArrayList<HTrans> arrHTrans;
    NewJFrameAdmin adm;
    int index;
    int idtransaksi;
    int row, column;
    /**
     * Creates new form NewJFrame_transactionHistory
     */
    public NewJFrame_transactionReport() {
        
        
        initComponents();
        LocalDate myObj = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = myObj.format(myFormatObj);
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
            jDateChooser4.setDateFormatString("yyyy-MM-dd");
            jDateChooser3.setDateFormatString("yyyy-MM-dd");
            jDateChooser4.setDate(date);
            jDateChooser3.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(NewJFrame_transactionReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testingdbproyek","root","");
        } catch (Exception ex) {
            Logger.getLogger(NewJFrame_transactionReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testingdbproyek","root","");
        } catch (Exception ex) {
            Logger.getLogger(NewJFrame_transactionReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public NewJFrame_transactionReport(NewJFrameAdmin param) {
        
        
        initComponents();
        adm=param;
        LocalDate myObj = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = myObj.format(myFormatObj);
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
            jDateChooser4.setDateFormatString("yyyy-MM-dd");
            jDateChooser3.setDateFormatString("yyyy-MM-dd");
            jDateChooser4.setDate(date);
            jDateChooser3.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(NewJFrame_transactionReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testingdbproyek","root","");
        } catch (Exception ex) {
            Logger.getLogger(NewJFrame_transactionReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testingdbproyek","root","");
        } catch (Exception ex) {
            Logger.getLogger(NewJFrame_transactionReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void loadTabel(){
        arrHTrans = new ArrayList<>();
        String [] row = {"TRANSACTION ID","CUSTOMER NAME","TRANSACTION DATE","SUBTOTAL"};
        dt = new DefaultTableModel(row,0);
        try {
            statement = con.createStatement();
            rs = statement.executeQuery("select * from htrans");
            while(rs.next()){
                HTrans ht = new HTrans(rs.getInt("IDTRANS"),
                        rs.getString("CUSTOMER"),
                        rs.getDate("WAKTUTRANSAKSI"),
                        rs.getInt("TOTAL"));
               arrHTrans.add(ht);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame_transactionReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(HTrans h : arrHTrans){
            
            if(jDateChooser4.getDate().getTime()<=h.getWaktutransaksi().getTime()&&jDateChooser3.getDate().getTime()>=h.getWaktutransaksi().getTime()){
                dt.addRow(h.getObj());
            }
        }
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.setModel(dt);
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_transactionID = new javax.swing.JTextField();
        jButton_filter = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("TRANSACTION REPORT");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setText("FROM DATE : ");

        jLabel7.setText("TRANSACTION ID : ");

        jButton_filter.setText("FILTER");
        jButton_filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_filterActionPerformed(evt);
            }
        });

        jButton2.setText("SAVE REPORT");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel10.setText("TO DATE : ");

        jButton1.setText("SHOW REPORT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/note.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/Background_Transs.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel4)
                .addGap(272, 272, 272)
                .addComponent(jLabel10)
                .addGap(17, 17, 17)
                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel7)
                .addGap(14, 14, 14)
                .addComponent(jTextField_transactionID, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton_filter))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(700, 700, 700)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_transactionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_filter))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1AncestorMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        loadTabel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && evt.getButton() == evt.BUTTON1) {
            row = jTable1.getSelectedRow();
            idtransaksi = Integer.parseInt(jTable1.getValueAt(row, 0).toString()) ;
            System.out.println(idtransaksi);
            NewJFrame_transactionDetail frm = new NewJFrame_transactionDetail(this);
            frm.setVisible(true);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton_filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_filterActionPerformed
        // TODO add your handling code here:
        String idCari = "";
        if(!jTextField_transactionID.getText().equals("")){
            idCari = jTextField_transactionID.getText();
            arrHTrans = new ArrayList<>();
            String [] row = {"TRANSACTION ID","CUSTOMER NAME","TRANSACTION DATE","SUBTOTAL"};
            dt = new DefaultTableModel(row,0);
            try {
                statement = con.createStatement();
                rs = statement.executeQuery("select * from htrans where idtrans="+idCari);
                while(rs.next()){
                    HTrans ht = new HTrans(rs.getInt("IDTRANS"),
                            rs.getString("CUSTOMER"),
                            rs.getDate("WAKTUTRANSAKSI"),
                            rs.getInt("TOTAL"));
                   arrHTrans.add(ht);
                }
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(NewJFrame_transactionReport.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(HTrans h : arrHTrans){
                dt.addRow(h.getObj());
            }
            jTable1.setDefaultEditor(Object.class, null);
            jTable1.setModel(dt);
        }else{
            JOptionPane.showMessageDialog(null, "Isi ID terlebih dahulu!");
        }
    }//GEN-LAST:event_jButton_filterActionPerformed
    public void writeFile(File f){
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write("TRANSACTION REPORT");
            writer.newLine();
            writer.newLine();
            writer.write("TRANSACTION ID~CUSTOMER NAME~TRANSACTION DATE~SUBTOTAL");
            writer.newLine();
            for(HTrans ht: arrHTrans){
                writer.write(ht.toString());
                writer.newLine();
            }
            //HARUS URUT
            writer.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        jFileChooser1.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int response = jFileChooser1.showSaveDialog(this);
        if(response == JFileChooser.APPROVE_OPTION){
            File selectedFile = jFileChooser1.getSelectedFile();
            writeFile(selectedFile);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        adm.report_status=false;
        adm.setVisible(true);
        dispose();
    }//GEN-LAST:event_formWindowClosing

   
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
            java.util.logging.Logger.getLogger(NewJFrame_transactionReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame_transactionReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame_transactionReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame_transactionReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame_transactionReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_filter;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_transactionID;
    // End of variables declaration//GEN-END:variables
}
