/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester_001;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import java.util.Properties;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jou
 */
public class NewJFrameAdmin extends javax.swing.JFrame {

    DefaultListModel dl;
    DefaultComboBoxModel dc;
    DefaultTableModel tm;
    ArrayList<Username> arr;
    ArrayList<Barang> arrBarang=new ArrayList<Barang>();
    NewJFrameAdmin frmini;
    Barang objBar;
    String[] gudang={"all","gudang A","gudang B","gudang C"};
    String[] ket={"all","Buku","Elektronik","Pakaian","Makanan & Minuman","Fashion","Rumah Tangga","Barang Antik","Produk Kecantikan","Others"};
    public NewJFrameAdmin() {
        initComponents();
        frmini=this;
        this.arr= NewJFrameCreateuser.arr;
        dl = new DefaultListModel();
        List01.setModel(dl);
        refreshDataList();
        refreshTable();
        settingComboBoxKategori(CBKategori);
        settingComboBoxKategori(CBKategori02);
        settingComboBoxGudang(CBGudang);
        settingComboBoxGudang(CBGudang02);
        reset();
    }
    public void reset()
    {
        TFNamaB.setText("");
        TFJumlahB.setText("");
        TFCariUser.setText("");
    }
    public void refreshDataList()
    {
        dl.clear();
        for (int i = 0; i < arr.size(); i++) {
            dl.addElement(arr.get(i).toString());
        }
    }
    public void refreshTable(){
        String[] title={"Id","Nama","Jumlah","Kategori","Gudang"};
        tm=new DefaultTableModel(title,0);
        TableBarang.setModel(tm);
        //perintah ini digunakan agar data tidak bisa diedit edit di model nanti
        TableBarang.setDefaultEditor(Object.class, null);
        for (int i = 0; i < arrBarang.size(); i++) {
            addtoTable(i);
        }
    }
    public void addtoTable(int i)
    {
        Object[]obj={arrBarang.get(i).getID(),arrBarang.get(i).getNama() ,arrBarang.get(i).getJumlah(),arrBarang.get(i).getKategori(),arrBarang.get(i).getGudang()};
        tm.addRow(obj);
    }
    public void refreshTable(int k,int j){
        String[] title={"Id","Nama","Jumlah","Kategori","Gudang"};
        tm=new DefaultTableModel(title,0);
        TableBarang.setModel(tm);
        //perintah ini digunakan agar data tidak bisa diedit edit di model nanti
        TableBarang.setDefaultEditor(Object.class, null);
        String kategori_now="";
        String gudang_now="";
        String temp_kat;
        String temp_gud;
        if(k!=0)kategori_now=ket[k];
        if(j!=0)gudang_now=gudang[j];
        for (int i = 0; i < arrBarang.size(); i++) {
            temp_kat=arrBarang.get(i).getKategori();
            temp_gud=arrBarang.get(i).getGudang();
            if(kategori_now.equals(""))
            {
                if(temp_gud.equals(gudang_now))
                {addtoTable(i);}
            }
            else if(gudang_now.equals(""))
            {
                if(temp_kat.equals(kategori_now))
                {addtoTable(i);}
            }
            else
            {
                if(temp_kat.equals(kategori_now)&&temp_gud.equals(gudang_now))
                {addtoTable(i);}
            }
        }
    }
    public void settingComboBoxKategori(JComboBox cb)
    {
        dc=new DefaultComboBoxModel(ket);
        cb.setModel(dc);
    }
    public void settingComboBoxGudang(JComboBox cb)
    {
        dc=new DefaultComboBoxModel(gudang);
        cb.setModel(dc);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        List01 = new javax.swing.JList<>();
        CBGudang = new javax.swing.JComboBox<>();
        CBKategori = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableBarang = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CBKategori02 = new javax.swing.JComboBox<>();
        CBGudang02 = new javax.swing.JComboBox<>();
        BAddB = new javax.swing.JButton();
        TFNamaB = new javax.swing.JTextField();
        TFJumlahB = new javax.swing.JTextField();
        BRefresh = new javax.swing.JButton();
        BLogOut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TFCariUser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("HALO ADMIN");

        List01.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        List01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                List01MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(List01);

        CBGudang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CBKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        TableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableBarang.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(TableBarang);

        jLabel3.setText("LIST BARANG");

        jLabel4.setText("DATA USER");

        jLabel5.setText("ADD BARANG");

        jLabel6.setText("Nama Barang");

        jLabel7.setText("Jumlah Barang");

        jLabel8.setText("Kategori");

        jLabel9.setText("Gudang");

        CBKategori02.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CBGudang02.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BAddB.setText("ADD ITEM");
        BAddB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAddBActionPerformed(evt);
            }
        });

        TFNamaB.setText("TFNamaB");

        TFJumlahB.setText("TFJumlahB");

        BRefresh.setText("Refresh");
        BRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRefreshActionPerformed(evt);
            }
        });

        BLogOut.setText("LOG OUT");
        BLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLogOutActionPerformed(evt);
            }
        });

        jLabel2.setText("Cari Barang");

        jLabel10.setText("jLabel10");

        TFCariUser.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TFJumlahB, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BAddB)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CBGudang02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CBKategori02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFNamaB)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CBKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)
                                        .addComponent(jLabel3)
                                        .addGap(90, 90, 90)
                                        .addComponent(BRefresh))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(35, 35, 35)
                                                .addComponent(TFCariUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(CBGudang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(BLogOut)
                        .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BLogOut))
                .addGap(54, 54, 54)
                .addComponent(CBGudang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(BRefresh))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TFNamaB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(TFCariUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TFJumlahB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(CBKategori02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(CBGudang02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BAddB)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ImageIcon icon=new ImageIcon("src/format2.png");
        int input=JOptionPane.showConfirmDialog(rootPane, "yakin keluar", "OUT!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
        if(input==1)
        {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            //atau
//            frmini.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }else
        {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //atau
//            frmini.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
    }//GEN-LAST:event_formWindowClosing

    private void BAddBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAddBActionPerformed
        String nama=TFNamaB.getText();
        int jum=Integer.parseInt(TFJumlahB.getText());
        int i=CBGudang02.getSelectedIndex();
        int j=CBKategori02.getSelectedIndex();
        if(TFNamaB.getText().equals("") ||TFJumlahB.getText().equals("") )JOptionPane.showMessageDialog(rootPane, "nama& jumlah tidak boleh kosong");
        if(j==0)
        {
            JOptionPane.showMessageDialog(rootPane, "pilihkan salah satu kategori");
        }else if(i==0)
        {
            JOptionPane.showMessageDialog(rootPane, "pilihlah salah satu gudang");
        }else
        {
            objBar=new Barang(nama,jum,ket[j],gudang[i]);
            arrBarang.add(objBar);
            refreshTable();
            reset();
        }
    }//GEN-LAST:event_BAddBActionPerformed

    private void BRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRefreshActionPerformed
        int i=CBKategori.getSelectedIndex();
        int j=CBGudang.getSelectedIndex();
        if(i==0&&j==0)
        {
            refreshTable();
        }else
        {
            refreshTable(i,j);
        }
    }//GEN-LAST:event_BRefreshActionPerformed

    private void BLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLogOutActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Yakin mau Logout min?", "WARNING! ",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            setVisible(false);
            NewJFrameLogin frm=new NewJFrameLogin();
            frm.setVisible(true);
        }
    }//GEN-LAST:event_BLogOutActionPerformed

    private void List01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_List01MouseClicked
        int i=List01.getSelectedIndex();
        String str=new String(dl.get(i).toString());
        String[]temp= str.split("-", 4);
        //BELUM SELSAI
        for (String a : temp)
            System.out.println(a);
    }//GEN-LAST:event_List01MouseClicked

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
            java.util.logging.Logger.getLogger(NewJFrameAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrameAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrameAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrameAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrameAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAddB;
    private javax.swing.JButton BLogOut;
    private javax.swing.JButton BRefresh;
    private javax.swing.JComboBox<String> CBGudang;
    private javax.swing.JComboBox<String> CBGudang02;
    private javax.swing.JComboBox<String> CBKategori;
    private javax.swing.JComboBox<String> CBKategori02;
    private javax.swing.JList<String> List01;
    private javax.swing.JTextField TFCariUser;
    private javax.swing.JTextField TFJumlahB;
    private javax.swing.JTextField TFNamaB;
    private javax.swing.JTable TableBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
