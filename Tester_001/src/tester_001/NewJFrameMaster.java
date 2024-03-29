/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester_001;

import com.sun.imageio.plugins.jpeg.JPEG;
import java.awt.Color;
import static java.awt.Color.BLACK;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Jou
 */
public class NewJFrameMaster extends javax.swing.JFrame {
    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    NewJFrameAdmin admin;
    NewJFrameMaster master;
    NewJFrameListSampah ls;
    boolean status_list=false;
    public NewJFrameMaster() {
        initComponents();
        master=this;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testingdbproyek","root","");
        } catch (Exception ex) {
            Logger.getLogger(NewJFrameAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon pic = new ImageIcon("src/tester_001/kaumrombeng.png");
        Image icon = pic.getImage();
        Image real = icon.getScaledInstance(250, 175, java.awt.Image.SCALE_SMOOTH);
        pic = new ImageIcon(real);
        logo.setIcon(pic);
        logo.setText("");
    }
    public NewJFrameMaster(NewJFrameAdmin adm) {
        initComponents();
        master=this;
        admin=adm;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testingdbproyek","root","");
        } catch (Exception ex) {
            Logger.getLogger(NewJFrameAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon pic = new ImageIcon("src/tester_001/kaumrombeng.png");
        Image icon = pic.getImage();
        Image real = icon.getScaledInstance(250, 140, java.awt.Image.SCALE_SMOOTH);
        pic = new ImageIcon(real);
        logo.setIcon(pic);
        logo.setText("");
    }
    public void RefreshTextField(NewJFrameMaster m)
    {
        String hasilpassing=admin.PassingData();
        String data[]=hasilpassing.split("~");
        m.TFId.setText(data[0]);
        m.TFNama.setText(data[1]);
        m.TFHarga.setText(data[2]);
        m.TA.setText(data[3]);
    }
    public void RefreshTextField(NewJFrameMaster m,String value)
    {
        String hasilpassing=value;
        String data[]=hasilpassing.split("~");
        m.TFId.setText(data[0]);
        m.TFNama.setText(data[1]);
        m.TFHarga.setText(data[2]);
        m.TA.setText(data[3]);
    }
    public boolean check1()
    {
        if(TFNama.getText().equals("")||TFHarga.getText().equals("")||TA.getText().equals(""))return false;
        else return true;
    }
    public boolean isNumber(String val)
    {
        boolean temp=true;
        for (int i = 0; i < val.length(); i++) {
            char x=val.charAt(i);
            if(x<48&&x>57){
                temp=false;
                break;
            }
        }
        return temp;
    }
    public void reset(){
        TFId.setText("");
        TFNama.setText("");
        TFHarga.setText("");
        TA.setText("");
    }
    public void checkFrameListSampah()
    {
        if(status_list)ls.refreshtable();
    }
//    public void setIcon(){
//        UIManager UI=new UIManager();
//        UI.put("OptionPane.background", Color.BLACK);
//        UI.put("Panel.background", Color.BLACK);
//        UIManager.put("nimbusBase", new Color(0, 0, 0));
//        UIManager.put("text", new Color(255, 255, 255));
//        UIManager.put("control", new Color(0, 0, 0));
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TFHarga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TFId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA = new javax.swing.JTextArea();
        BAdd = new javax.swing.JButton();
        BEdit = new javax.swing.JButton();
        BDelete = new javax.swing.JButton();
        TFNama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        IconID = new javax.swing.JLabel();
        IconNama = new javax.swing.JLabel();
        IconHarga = new javax.swing.JLabel();
        IconDeskripsi = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setText("LOGO");
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel2.setText("Nama");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        TFHarga.setBackground(new java.awt.Color(0, 0, 0));
        TFHarga.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TFHarga.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TFHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 310, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel3.setText("Harga");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        TFId.setBackground(new java.awt.Color(0, 0, 0));
        TFId.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TFId.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TFId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 310, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel4.setText("Deskripsi");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        TA.setBackground(new java.awt.Color(0, 0, 0));
        TA.setColumns(20);
        TA.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        TA.setForeground(new java.awt.Color(255, 255, 255));
        TA.setRows(5);
        jScrollPane1.setViewportView(TA);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 310, 130));

        BAdd.setBackground(new java.awt.Color(0, 0, 0));
        BAdd.setForeground(new java.awt.Color(255, 255, 255));
        BAdd.setText("ADD");
        BAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAddActionPerformed(evt);
            }
        });
        getContentPane().add(BAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 100, -1));

        BEdit.setBackground(new java.awt.Color(0, 0, 0));
        BEdit.setForeground(new java.awt.Color(255, 255, 255));
        BEdit.setText("EDIT");
        BEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditActionPerformed(evt);
            }
        });
        getContentPane().add(BEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 90, -1));

        BDelete.setBackground(new java.awt.Color(0, 0, 0));
        BDelete.setForeground(new java.awt.Color(255, 255, 255));
        BDelete.setText("DELETE");
        BDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(BDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 100, -1));

        TFNama.setBackground(new java.awt.Color(0, 0, 0));
        TFNama.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TFNama.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TFNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 310, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        IconID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/id.png"))); // NOI18N
        getContentPane().add(IconID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        IconNama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/garbageIcon.png"))); // NOI18N
        getContentPane().add(IconNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        IconHarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/price.png"))); // NOI18N
        getContentPane().add(IconHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        IconDeskripsi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/checklist.png"))); // NOI18N
        getContentPane().add(IconDeskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 60, -1));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/background2.jpg"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
            admin.master_status=false;
//        ImageIcon pic = new ImageIcon("src/tester_001/warning.jpg");
//        pic.setImage(pic.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
//        UIManager UI=new UIManager();
//        UI.put("OptionPane.background", Color.BLACK);
//        UI.put("text",Color.WHITE);
//        UI.put("Panel.background",Color.BLACK);
//        UI.put("nimbusBase", new Color(0, 0, 0));
//        UI.put("control", new Color(0, 0, 0));
//        int input=JOptionPane.showConfirmDialog(null, "YAKIN KELUAR MIN?", "EXIT!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
//        if(input==1)
//        {
//            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        }else
//        {
//            admin.master_status=false;
//            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        }
    }//GEN-LAST:event_formWindowClosing

    private void BAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAddActionPerformed
        if(check1()){
            String nama=TFNama.getText();
            String price=TFHarga.getText();
            String keterangan=TA.getText();
            if(isNumber(price)){
                int harga=Integer.parseInt(price);
                try {
                ps = con.prepareStatement("insert into sampah(kategori,harga,keterangan) values(?,?,?)"); 
                ps.setString(1, nama);
                ps.setInt(2, harga);
                ps.setString(3, keterangan);
                ps.executeUpdate();
                reset();
                admin.setSampah();
                checkFrameListSampah();
                JOptionPane.showMessageDialog(null, "Sukses Add Sampah");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }else{
                JOptionPane.showMessageDialog(null, "Inputan Harga hanya boleh Angka");
                TFHarga.setText("");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Ada Column Yang Kosong","WARNING!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BAddActionPerformed

    private void BEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditActionPerformed
        if(!TFId.getText().equals(""))
        {
            int idx = Integer.parseInt(TFId.getText());
            if(idx>=6)
            {
                String nama=TFNama.getText();
                String price=TFHarga.getText();
                String keterangan=TA.getText();
    //            Sampah s=admin.arrsampah.get(idx);
                if(isNumber(price)){
                    int harga=Integer.parseInt(price);
                    try {
                        ps = con.prepareStatement("update sampah set kategori=?, harga=?, keterangan=? where idkategori=?");
                        ps.setString(1, nama);
                        ps.setInt(2, harga);
                        ps.setString(3, keterangan);
    //                    ps.setInt(4, s.getId());
                        ps.setInt(4, idx);
                        ps.executeUpdate();
                        reset();
                        admin.setSampah();
                        JOptionPane.showMessageDialog(null, "Sukses Update Sampah");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    checkFrameListSampah();
                }
            }
            else
            {
//                ImageIcon pic = new ImageIcon("src/tester_001/warning.jpg");
    //            setIcon(pic);
                JOptionPane.showMessageDialog(null,"ID Pertama Hingga Ke-Enam Tidak boleh di Update/Delete","WARNING!",JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "ID Tidak Boleh Kosong","WARNING!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BEditActionPerformed

    private void BDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDeleteActionPerformed
        if(!TFId.getText().equals(""))
        {
            int idx = Integer.parseInt(TFId.getText());
            if(idx>=6)
            {
                    try {
                        ps = con.prepareStatement("delete from sampah where idkategori=?");
                        ps.setInt(1, idx);
                        ps.executeUpdate();
                        reset();
                        admin.setSampah();
                        checkFrameListSampah();
                        JOptionPane.showMessageDialog(null, "Sukses Delete Sampah");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }

            }
            else
            {
//                ImageIcon pic = new ImageIcon("src/tester_001/warning.jpg");
    //            setIcon(pic);
                JOptionPane.showMessageDialog(null,"ID Pertama Hingga Ke-Enam Tidak boleh di Update/Delete","WARNING!",JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "ID Tidak Boleh Kosong","WARNING!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!status_list){
            ls=new NewJFrameListSampah(this, admin);
            ls.setVisible(true);
            status_list=true;
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
            java.util.logging.Logger.getLogger(NewJFrameMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrameMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrameMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrameMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrameMaster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAdd;
    private javax.swing.JButton BDelete;
    private javax.swing.JButton BEdit;
    private javax.swing.JLabel BG;
    private javax.swing.JLabel IconDeskripsi;
    private javax.swing.JLabel IconHarga;
    private javax.swing.JLabel IconID;
    private javax.swing.JLabel IconNama;
    private javax.swing.JTextArea TA;
    private javax.swing.JTextField TFHarga;
    private javax.swing.JTextField TFId;
    private javax.swing.JTextField TFNama;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
