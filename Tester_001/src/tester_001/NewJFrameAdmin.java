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
    boolean report_status=false;
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
        //LabelIcon.setText("");
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
        //LabelKatDesc.setText(CBCategorySampah.getSelectedItem().toString());
        LabelHargaKat.setText(arrsampah.get(0).getHarga()+"");
        LabelNamaSampah.setText(CBCategorySampah.getSelectedItem().toString());
        //LabelIcon.setIcon(new ImageIcon("src/tester_001/0.png"));
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
        String[] title={"Kategori","Harga","Berat","Subtot"};
        tm=new DefaultTableModel(title,0);
        TableBarang.setModel(tm);
        TableBarang.setDefaultEditor(Object.class, null);
        int total=0;
        for(DTrans d:arr)
        {
            String barang=d.getBarang();
            int harga=d.getHarga();
            int jumlah=d.getJumlah();
            //String icon=d.getIcon();
            int subtotal=d.getSubtotal();
            Object[] obj = {barang,harga,jumlah,subtotal};
            tm.addRow(obj);
            total+=subtotal;
        }
        LabelSub.setText(Integer.toString(total));
        TableBarang.setModel(tm);
        //TableColumn tc=TableBarang.getColumn("Icon");
        //TableBarang.getColumnModel().getColumn(3).setCellRenderer(new LabelRenderer());
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
    public int getIndexArr(String value){
        int temp=-1;
        for (int i = 0; i < arrsampah.size(); i++) {
            if(value.equals(arrsampah.get(i).getKategori())){
                temp=i;
                break;
            }
        }
        return temp;
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
        jButton1 = new javax.swing.JButton();
        LOGO = new javax.swing.JLabel();
        BNewCategory = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        LabelHargaKat = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LabelKeterangan = new javax.swing.JTextArea();
        UserIcon = new javax.swing.JLabel();
        CategoryIcon = new javax.swing.JLabel();
        WeightIcon = new javax.swing.JLabel();
        PriceIcon = new javax.swing.JLabel();
        SubTotalIcon = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        PriceIcon1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        LabelNamaSampah = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("HALO ADMIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        CBCategorySampah.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        CBCategorySampah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBCategorySampah.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBCategorySampahItemStateChanged(evt);
            }
        });
        getContentPane().add(CBCategorySampah, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 159, 30));

        TableBarang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 820, 190));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("LIST SAMPAH");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, -1, -1));

        BLogOut.setBackground(new java.awt.Color(0, 0, 0));
        BLogOut.setForeground(new java.awt.Color(255, 255, 255));
        BLogOut.setText("LOG OUT");
        BLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLogOutActionPerformed(evt);
            }
        });
        getContentPane().add(BLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 130, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("KATEGORI");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("WEIGHT");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

        SBerat.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        SBerat.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SBeratStateChanged(evt);
            }
        });
        getContentPane().add(SBerat, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 80, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel13.setText("Kg");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("TOTAL");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        LabelTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelTotal.setText("LabelTotal");
        getContentPane().add(LabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("SUBTOTAL :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 730, -1, -1));

        LabelSub.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelSub.setText("0");
        getContentPane().add(LabelSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 730, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("CUSTOMER");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 730, -1, -1));

        TFCustomer.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        TFCustomer.setText("TFCustomer");
        getContentPane().add(TFCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 730, 140, 30));

        BAdd.setBackground(new java.awt.Color(0, 0, 0));
        BAdd.setForeground(new java.awt.Color(255, 255, 255));
        BAdd.setText("Add");
        BAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAddActionPerformed(evt);
            }
        });
        getContentPane().add(BAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 320, -1));

        BSave.setBackground(new java.awt.Color(0, 0, 0));
        BSave.setForeground(new java.awt.Color(255, 255, 255));
        BSave.setText("Save");
        BSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSaveActionPerformed(evt);
            }
        });
        getContentPane().add(BSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 770, 820, -1));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("TRANSACTION HISTOY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 210, -1));

        LOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/kaumrombeng.png"))); // NOI18N
        getContentPane().add(LOGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 310, 190));

        BNewCategory.setBackground(new java.awt.Color(0, 153, 153));
        BNewCategory.setForeground(new java.awt.Color(255, 255, 255));
        BNewCategory.setText("Add New Category");
        BNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNewCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(BNewCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 210, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel11.setText("Harga per Kg :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, -1, -1));

        LabelHargaKat.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        LabelHargaKat.setText("0");
        getContentPane().add(LabelHargaKat, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel7.setText("Keterangan Sampah");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));

        LabelKeterangan.setColumns(20);
        LabelKeterangan.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        LabelKeterangan.setRows(5);
        jScrollPane1.setViewportView(LabelKeterangan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 251, 380, 110));

        UserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/anonymoususer.png"))); // NOI18N
        getContentPane().add(UserIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 720, -1, -1));

        CategoryIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/garbageIcon.png"))); // NOI18N
        getContentPane().add(CategoryIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        WeightIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/weight01.png"))); // NOI18N
        getContentPane().add(WeightIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        PriceIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/price.png"))); // NOI18N
        getContentPane().add(PriceIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, -1, -1));

        SubTotalIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/subtotal.png"))); // NOI18N
        getContentPane().add(SubTotalIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 720, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Rp.");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 730, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setText("Rp.");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Rp.");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Batal Transaksi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 130, -1));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Batal Item");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 110, -1));

        PriceIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/price.png"))); // NOI18N
        getContentPane().add(PriceIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/checklist.png"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, -1, -1));

        LabelNamaSampah.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        LabelNamaSampah.setText("nama");
        getContentPane().add(LabelNamaSampah, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tester_001/BackgroundAdmin.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 840));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ImageIcon icon=new ImageIcon("src/format2.png");
        int input=JOptionPane.showConfirmDialog(rootPane, "yakin keluar min?", "GET OUT!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
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
        String item=CBCategorySampah.getSelectedItem().toString();
        int idx=getIndexArr(item);
        int id=arrsampah.get(idx).getId();
//        if(checkIcon(id)){
//            LabelIcon.setIcon(new ImageIcon("src/tester_001/"+ CBCategorySampah.getSelectedIndex()+".png"));
//        }else LabelIcon.setIcon(new ImageIcon("src/tester_001/"+"default"+".png"));
        LabelHargaKat.setText(arrsampah.get(idx).getHarga()+"");
        //LabelKatDesc.setText(CBCategorySampah.getSelectedItem().toString());
        LabelNamaSampah.setText(item);
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
            if(checkIcon(index))icon="src/tester_001/"+CBCategorySampah.getSelectedIndex()+".png";
            else icon="src/tester_001/default.png";
            int subtotal = harga * berat;

            DTrans obj = new DTrans(sampah, harga, berat, subtotal);
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(report_status==false){
            this.setVisible(false);
            NewJFrame_transactionReport frm=new NewJFrame_transactionReport(this);
            frm.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        resetData();
        refreshTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int indexNya = TableBarang.getSelectedRow();
        arr.remove(indexNya);
        refreshTable();
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private javax.swing.JLabel Background;
    private javax.swing.JComboBox<String> CBCategorySampah;
    private javax.swing.JLabel CategoryIcon;
    private javax.swing.JLabel LOGO;
    private javax.swing.JLabel LabelHargaKat;
    private javax.swing.JTextArea LabelKeterangan;
    private javax.swing.JLabel LabelNamaSampah;
    private javax.swing.JLabel LabelSub;
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JLabel PriceIcon;
    private javax.swing.JLabel PriceIcon1;
    private javax.swing.JSpinner SBerat;
    private javax.swing.JLabel SubTotalIcon;
    private javax.swing.JTextField TFCustomer;
    private javax.swing.JTable TableBarang;
    private javax.swing.JLabel UserIcon;
    private javax.swing.JLabel WeightIcon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
