/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester_001;

import java.awt.Image;
import javax.swing.*;
public class NewJFrameCredit extends javax.swing.JFrame {

    NewJFrameLogin login;
    public NewJFrameCredit() {
        initComponents();
        reset();
    }
    public NewJFrameCredit(NewJFrameLogin param) {
        initComponents();
        login=param;
        reset();
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
        Joe = new javax.swing.JLabel();
        Kevin = new javax.swing.JLabel();
        Royce = new javax.swing.JLabel();
        CBSHOW = new javax.swing.JCheckBox();
        CBJon = new javax.swing.JRadioButton();
        CBVin = new javax.swing.JRadioButton();
        CBRoy = new javax.swing.JRadioButton();
        JIcon1 = new javax.swing.JLabel();
        JIcon2 = new javax.swing.JLabel();
        KIcon1 = new javax.swing.JLabel();
        KIcon2 = new javax.swing.JLabel();
        RIcon1 = new javax.swing.JLabel();
        RIcon2 = new javax.swing.JLabel();
        BackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Joe.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Joe.setForeground(new java.awt.Color(255, 255, 0));
        Joe.setText("jLabel1");
        getContentPane().add(Joe, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        Kevin.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Kevin.setForeground(new java.awt.Color(255, 255, 0));
        Kevin.setText("jLabel2");
        getContentPane().add(Kevin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        Royce.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Royce.setForeground(new java.awt.Color(255, 255, 0));
        Royce.setText("jLabel3");
        getContentPane().add(Royce, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        CBSHOW.setBackground(new java.awt.Color(0, 9, 64));
        CBSHOW.setForeground(new java.awt.Color(102, 204, 0));
        CBSHOW.setText("SHOW CREATOR NAME");
        CBSHOW.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBSHOWItemStateChanged(evt);
            }
        });
        getContentPane().add(CBSHOW, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        CBJon.setBackground(new java.awt.Color(0, 9, 64));
        buttonGroup1.add(CBJon);
        CBJon.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        CBJon.setForeground(new java.awt.Color(102, 204, 0));
        CBJon.setText("220310636");
        CBJon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBJonItemStateChanged(evt);
            }
        });
        getContentPane().add(CBJon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        CBVin.setBackground(new java.awt.Color(0, 9, 64));
        buttonGroup1.add(CBVin);
        CBVin.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        CBVin.setForeground(new java.awt.Color(102, 204, 0));
        CBVin.setText("220310638");
        CBVin.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBVinItemStateChanged(evt);
            }
        });
        getContentPane().add(CBVin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        CBRoy.setBackground(new java.awt.Color(0, 9, 64));
        buttonGroup1.add(CBRoy);
        CBRoy.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        CBRoy.setForeground(new java.awt.Color(102, 204, 0));
        CBRoy.setText("220310643");
        CBRoy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBRoyItemStateChanged(evt);
            }
        });
        getContentPane().add(CBRoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        JIcon1.setText("jLabel1");
        getContentPane().add(JIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        JIcon2.setText("jLabel2");
        getContentPane().add(JIcon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, -1, -1));

        KIcon1.setText("jLabel3");
        getContentPane().add(KIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        KIcon2.setText("jLabel4");
        getContentPane().add(KIcon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        RIcon1.setText("jLabel5");
        getContentPane().add(RIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        RIcon2.setText("jLabel6");
        getContentPane().add(RIcon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        BackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/CreditBG.jpg"))); // NOI18N
        getContentPane().add(BackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public int checkRB()
    {
        if(CBJon.isSelected())return 0;
        else if(CBVin.isSelected())return 1;
        else if(CBRoy.isSelected()) return 2;
        else return -1;
    }
    public void hideother(JLabel l1,JLabel l2)
    {
        l1.setText("");
        l2.setText("");
    }
    public void hideIcon(JLabel icon1,JLabel icon2){
        icon1.setIcon(null);
        icon2.setIcon(null);
    }
    public void setIcon(JLabel icon1,JLabel icon2,ImageIcon pic1,ImageIcon pic2){
        icon1.setIcon(pic1);
        icon2.setIcon(pic2);
    }
    public void popupname(int index){
        ImageIcon pic = new ImageIcon("src/tester_001/java.png");
            Image icon = pic.getImage();
            Image real = icon.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
            pic = new ImageIcon(real);
        ImageIcon pic2 = new ImageIcon("src/tester_001/design.png");
            Image icon2 = pic2.getImage();
            Image real2 = icon2.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
            pic2 = new ImageIcon(real2);
        ImageIcon pic3 = new ImageIcon("src/tester_001/server.png");
            Image icon3 = pic3.getImage();
            Image real3 = icon3.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
            pic3 = new ImageIcon(real3);
        ImageIcon pic4 = new ImageIcon("src/tester_001/checklist.png");
            Image icon4 = pic4.getImage();
            Image real4 = icon4.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
            pic4 = new ImageIcon(real4);        
        if(index==0){
            Joe.setText("Jonathan Untario");
            setIcon(JIcon1, JIcon2, pic, pic2);
            hideIcon(KIcon1, KIcon2);
            hideIcon(RIcon1, RIcon2);
            hideother(Kevin, Royce);
        }else if(index==1)
        {
            Kevin.setText("Kevin Andrew Wijaya");
            setIcon(KIcon1, KIcon2, pic3, pic2);
            hideother(Joe, Royce);
            hideIcon(JIcon1, JIcon2);
            hideIcon(RIcon1, RIcon2);
        }else
        {
            Royce.setText("Royce Steven");
            setIcon(RIcon1, RIcon2, pic, pic4);
            hideother(Kevin, Joe);
            hideIcon(KIcon1, KIcon2);
            hideIcon(JIcon1, JIcon2);
        }
    }
    public void reset()
    {
        Joe.setText("");
        Kevin.setText("");
        Royce.setText("");
        JIcon1.setText("");
        JIcon2.setText("");
        KIcon1.setText("");
        KIcon2.setText("");
        RIcon1.setText("");
        RIcon2.setText("");
    }
    public void checkCheckBox()
    {
        if(CBSHOW.isSelected())
        {
            int temp=checkRB();
            if(temp!=-1)popupname(temp);
            else reset();
        }else
        {
            Joe.setText("");
            Kevin.setText("");
            Royce.setText("");
            hideIcon(JIcon1, JIcon2);
            hideIcon(KIcon1, KIcon2);
            hideIcon(RIcon1, RIcon2);
        }
    }
    private void CBJonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBJonItemStateChanged
        checkCheckBox();
    }//GEN-LAST:event_CBJonItemStateChanged

    private void CBVinItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBVinItemStateChanged
        checkCheckBox();
    }//GEN-LAST:event_CBVinItemStateChanged

    private void CBRoyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBRoyItemStateChanged
        checkCheckBox();
    }//GEN-LAST:event_CBRoyItemStateChanged

    private void CBSHOWItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBSHOWItemStateChanged
        checkCheckBox();
    }//GEN-LAST:event_CBSHOWItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        login.credit_status=false;
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
            java.util.logging.Logger.getLogger(NewJFrameCredit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrameCredit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrameCredit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrameCredit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrameCredit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGround;
    private javax.swing.JRadioButton CBJon;
    private javax.swing.JRadioButton CBRoy;
    private javax.swing.JCheckBox CBSHOW;
    private javax.swing.JRadioButton CBVin;
    private javax.swing.JLabel JIcon1;
    private javax.swing.JLabel JIcon2;
    private javax.swing.JLabel Joe;
    private javax.swing.JLabel KIcon1;
    private javax.swing.JLabel KIcon2;
    private javax.swing.JLabel Kevin;
    private javax.swing.JLabel RIcon1;
    private javax.swing.JLabel RIcon2;
    private javax.swing.JLabel Royce;
    private javax.swing.ButtonGroup buttonGroup1;
    // End of variables declaration//GEN-END:variables
}