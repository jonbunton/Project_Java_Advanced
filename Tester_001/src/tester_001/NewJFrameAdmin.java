/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester_001;

import java.awt.Component;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
/**
 *
 * @author jou
 */
public class NewJFrameAdmin extends javax.swing.JFrame {

    DefaultListModel dl;
    DefaultComboBoxModel dc;
    DefaultTableModel tm;
    ArrayList<DTrans> arr=new ArrayList<DTrans>();
    NewJFrameAdmin frmini;
    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    ArrayList<Sampah> arrsampah;
    NewJFrameMaster mst;
    boolean master_status=false;
    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    class LabelRenderer implements TableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
            String photoname=o.toString();
            ImageIcon icon=new ImageIcon(photoname);
            TableColumn tc=TableBarang.getColumn("Icon");
            tc.setMinWidth(100);
            tc.setMaxWidth(100);
            TableBarang.setRowHeight(100);
            return new JLabel(icon);
        }
	
    }
    public NewJFrameAdmin() {
        initComponents();
        frmini=this;
        LabelIcon.setText("");
        dl = new DefaultListModel();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testingdbproyek","root","");
        } catch (Exception ex) {
            Logger.getLogger(NewJFrameAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        refreshTable();
        setSampah();
//        settingComboBoxSampah(CBKategorySampah);
        LabelKeterangan.setText(getKeteranganSampah(0));
        LabelKatDesc.setText(CBCategorySampah.getSelectedItem().toString());
        LabelHargaKat.setText(arrsampah.get(0).getHarga()+"");
        LabelIcon.setIcon(new ImageIcon("src/tester_001/0.jpg"));
        reset();
    }
    public void reset()
    {
        TFCustomer.setText("");
        LabelTotal.setText("0");
        CBCategorySampah.setSelectedIndex(0);
        Object obj=0;
        SBerat.setValue(obj);
    }
    public void refreshTable(){
        String[] title={"Kategori","Harga","Berat","Icon","Subtot"};
        tm=new DefaultTableModel(title,0);
        TableBarang.setModel(tm);
        TableBarang.setDefaultEditor(Object.class, null);
        int total=0;
        for(DTrans d:arr)
        {
            String barang=d.getBarang();
            int harga=d.getHarga();
            int jumlah=d.getJumlah();
            String icon=d.getIcon();
            int subtotal=d.getSubtotal();
            Object[] obj = {barang,harga,jumlah,icon,subtotal};
            tm.addRow(obj);
            total+=subtotal;
        }
        LabelSub.setText(Integer.toString(total));
        TableBarang.setModel(tm);
        TableColumn tc=TableBarang.getColumn("Icon");
        TableBarang.getColumnModel().getColumn(3).setCellRenderer(new LabelRenderer());
    }
    public void resetData()
    {
        LabelHargaKat.setText(arrsampah.get(0).getHarga()+"");
        String[] title={"Kategori","Harga","Berat","Icon","Subtot"};
        tm=new DefaultTableModel(title,0);      
        TableBarang.setModel(tm);
        LabelSub.setText("0");
        LabelTotal.setText("0");
        CBCategorySampah.setSelectedIndex(0);
        arr = new ArrayList<DTrans>();
        
        refreshTable();
    }
    public void setSampah()
    {
        arrsampah=new ArrayList<>();
        try {
            ps = con.prepareStatement("select * from sampah");
            rs=ps.executeQuery();
            while(rs.next())
            {
                int id=rs.getInt("idkategori");
                String nama=rs.getString("kategori");
                int harga=rs.getInt("harga");
                String ket=rs.getString("keterangan");
                Sampah obj=new Sampah(id, nama, harga, ket);
                arrsampah.add(obj);
            }
            rs.close();
            settingComboBoxSampah(CBCategorySampah);
        } catch (Exception e) {
            System.out.println("!");
        }
    }
    public String getKeteranganSampah(int idx)
    {
        String data[]=arrsampah.get(idx).getKeterangan().split(" ");
        String newket="";
        for (int i = 0; i < data.length; i++) {
            newket+=data[i]+" ";
            if(i%4==0&&i!=0)
            {
                newket+="\n";
            }
        }
        return newket;
    }
    public void settingComboBoxSampah(JComboBox cb)
    {
        DefaultComboBoxModel cm = new DefaultComboBoxModel();
        for(Sampah s:arrsampah){
            Object obj=s.getKategori();
            cm.addElement(obj);
        }
        cb.setModel(cm);
    }
    public void setLabelTotal(){
        int value=(int)SBerat.getValue();
        int harga=Integer.parseInt(LabelHargaKat.getText());
        int total=harga*value;
        LabelTotal.setText(total+"");
    }
    public boolean checkIcon(int index){
        if(index>=0&&index<=5){
            return true;
        }else{
            return false;
        }
    }
    public String PassingData(){
        String temp_id="";
        String temp_kategori=CBCategorySampah.getSelectedItem().toString();
        String harga=LabelHargaKat.getText();
        String keterangan=LabelKeterangan.getText();
        int index=-1;
        for (int i = 0; i < arrsampah.size(); i++) {
            if(arrsampah.get(i).getKategori().equals(CBCategorySampah.getSelectedItem().toString()))
            {
                index=i;
                temp_id=arrsampah.get(i).getId()+"";
                break;
            }
        }
        return temp_id+"~"+temp_kategori+"~"+harga+"~"+keterangan;
    }
    public boolean checkSpinner(int val){
        if(val>0)return true;
        else return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        CBCategorySampah = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableBarang = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        BLogOut = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        SBerat = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        LabelTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LabelSub = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TFCustomer = new javax.swing.JTextField();
        BAdd = new javax.swing.JButton();
        BSave = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        LabelHargaKat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LabelKeterangan = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        LabelIcon = new javax.swing.JLabel();
        LabelKatDesc = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        LOGO = new javax.swing.JLabel();
        BNewCategory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("HALO ADMIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 220, -1, -1));

        CBCategorySampah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBCategorySampah.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBCategorySampahItemStateChanged(evt);
            }
        });
        getContentPane().add(CBCategorySampah, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 296, 159, -1));

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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 583, 820, 178));

        jLabel3.setText("LIST SAMPAH");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 550, -1, -1));

        BLogOut.setText("LOG OUT");
        BLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLogOutActionPerformed(evt);
            }
        });
        getContentPane().add(BLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 130, -1));

        jLabel4.setText("Kategori :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 299, -1, -1));

        jLabel12.setText("Berat : ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 341, -1, -1));

        SBerat.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SBeratStateChanged(evt);
            }
        });
        getContentPane().add(SBerat, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 338, 60, -1));

        jLabel13.setText("Kg");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 341, -1, -1));

        jLabel14.setText("Total : ");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 382, -1, -1));

        LabelTotal.setText("LabelTotal");
        getContentPane().add(LabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 382, -1, -1));

        jLabel2.setText("Subtotal :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 547, -1, -1));

        LabelSub.setText("LabelSub");
        getContentPane().add(LabelSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 547, -1, -1));

        jLabel5.setText("Customer :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 257, -1, -1));

        TFCustomer.setText("TFCustomer");
        getContentPane().add(TFCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 254, 158, -1));

        BAdd.setText("Add");
        BAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAddActionPerformed(evt);
            }
        });
        getContentPane().add(BAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 420, 243, -1));

        BSave.setText("Save");
        BSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSaveActionPerformed(evt);
            }
        });
        getContentPane().add(BSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 770, 820, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Kategori");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel7.setText("Keterangan");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setText("Harga per Kg :");

        LabelHargaKat.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        LabelHargaKat.setText("0");

        LabelKeterangan.setColumns(20);
        LabelKeterangan.setRows(5);
        jScrollPane1.setViewportView(LabelKeterangan);

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 100));

        LabelIcon.setText("LabelIcon");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(LabelIcon)
                .addGap(0, 32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(LabelIcon)
                .addGap(0, 80, Short.MAX_VALUE))
        );

        LabelKatDesc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelKatDesc.setText("LabelKatDesc");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jScrollPane1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(LabelHargaKat))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LabelKatDesc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(112, 112, 112))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelKatDesc)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelHargaKat))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 240, 460, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Deskripsi");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        jButton1.setText("TRANSACTION HISTOY");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 810, 220, -1));

        LOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/kaumrombeng.png"))); // NOI18N
        getContentPane().add(LOGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 320, -1));

        BNewCategory.setText("Add New Category");
        BNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNewCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(BNewCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 470, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ImageIcon icon=new ImageIcon("src/format2.png");
        int input=JOptionPane.showConfirmDialog(rootPane, "yakin keluar", "OUT!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
        if(input==1){
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }else{
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
    }//GEN-LAST:event_formWindowClosing

    private void BLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLogOutActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Yakin mau Logout min?", "WARNING! ",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            setVisible(false);
            NewJFrameLogin frm=new NewJFrameLogin();
            frm.setVisible(true);
        }
    }//GEN-LAST:event_BLogOutActionPerformed

    private void CBCategorySampahItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBCategorySampahItemStateChanged
        int idx=CBCategorySampah.getSelectedIndex();
        int index=CBCategorySampah.getSelectedIndex();
        if(checkIcon(index)){
            LabelIcon.setIcon(new ImageIcon("src/tester_001/"+ CBCategorySampah.getSelectedIndex()+".jpg"));
        }else LabelIcon.setIcon(new ImageIcon("src/tester_001/"+"default"+".png"));
        LabelHargaKat.setText(arrsampah.get(idx).getHarga()+"");
        LabelKatDesc.setText(CBCategorySampah.getSelectedItem().toString());
        String data[]=arrsampah.get(idx).getKeterangan().split(" ");
        String newket="";
        for (int i = 0; i < data.length; i++) {
            newket+=data[i]+" ";
            if(i%4==0&&i!=0)
            {
                newket+="\n";
            }
        }
        LabelKeterangan.setText(newket);
        setLabelTotal();
        if(master_status)mst.RefreshTextField(mst);
    }//GEN-LAST:event_CBCategorySampahItemStateChanged

    private void BAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAddActionPerformed
        String sampah = CBCategorySampah.getSelectedItem().toString();
        int harga = Integer.parseInt(LabelHargaKat.getText());
        int berat = (int) SBerat.getValue();
        int index=CBCategorySampah.getSelectedIndex();
        if(checkSpinner(berat)){
            String icon;
            if(checkIcon(index))icon="src/tester_001/"+CBCategorySampah.getSelectedIndex()+".jpg";
            else icon="src/tester_001/default.png";
            int subtotal = harga * berat;

            DTrans obj = new DTrans(sampah, harga, berat,icon, subtotal);
            arr.add(obj);

            refreshTable();
        }else{
            JOptionPane.showMessageDialog(null, "Berat Tidak Boleh Kurang Dari 1 Kg");
        }
    }//GEN-LAST:event_BAddActionPerformed

    private void BSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSaveActionPerformed
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        System.out.println(sdf3.format(timestamp));
        try {
            con.setAutoCommit(false);
            int idbaru = -1 ;
            ps = con.prepareStatement("INSERT INTO htrans (customer, total) VALUES ( ?, ?)",Statement.RETURN_GENERATED_KEYS);
            String nama=TFCustomer.getText();
            int total=Integer.parseInt(LabelSub.getText());
            ps.setString(1, nama);
            ps.setInt(2, total);
//            ps.setTimestamp(3, timestamp);
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                //dapetin IDHTRANS,yang bertepatan di column pertama
                idbaru=rs.getInt(1);
            }
            if(idbaru!=-1){
                for(int i=0;i<arr.size();i++)
                {
                    ps = con.prepareStatement("insert into dtrans(idhtrans,kategory,harga,berat) values(?,?,?,?)");
                    ps.setInt(1, idbaru);
                    ps.setString(2, arr.get(i).getBarang());
                    ps.setInt(3, arr.get(i).getHarga() );
                    ps.setInt(4, arr.get(i).getJumlah() );
                    ps.executeUpdate();
                }
                con.commit();
                resetData();
                TFCustomer.setText("");
            }
        } catch (Exception ex) {
            
            System.out.println(ex.toString());;
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(NewJFrameAdmin.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }//GEN-LAST:event_BSaveActionPerformed

    private void SBeratStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SBeratStateChanged
        setLabelTotal();
    }//GEN-LAST:event_SBeratStateChanged

    private void BNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNewCategoryActionPerformed
        if(master_status==false){
            mst=new NewJFrameMaster(this);
            mst.setVisible(true);
            master_status=true;
        }
    }//GEN-LAST:event_BNewCategoryActionPerformed

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
    private javax.swing.JButton BAdd;
    private javax.swing.JButton BLogOut;
    private javax.swing.JButton BNewCategory;
    private javax.swing.JButton BSave;
    private javax.swing.JComboBox<String> CBCategorySampah;
    private javax.swing.JLabel LOGO;
    private javax.swing.JLabel LabelHargaKat;
    private javax.swing.JLabel LabelIcon;
    private javax.swing.JLabel LabelKatDesc;
    private javax.swing.JTextArea LabelKeterangan;
    private javax.swing.JLabel LabelSub;
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JSpinner SBerat;
    private javax.swing.JTextField TFCustomer;
    private javax.swing.JTable TableBarang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
