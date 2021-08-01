/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester_001;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author Jou
 */
public class Sampah {
    int id,harga;
    String kategori,keterangan,icon;

    public Sampah(int id, String kategori,int harga, String keterangan) {
        this.id = id;
        this.harga = harga;
        this.kategori = kategori;
        this.keterangan = keterangan;
        this.icon="src/Tester_001/default.png";
    }

    public String getIcon() {
        if(this.id>0&&this.id<=6){
            return "src/tester_001/"+this.id+".png";
        }
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    public Object[] getObj(){
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        
        Object[] o = {this.kategori,kursIndonesia.format(this.harga), getIcon(), this.keterangan};
        return o;
    }
}
