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
 * @author THUANPROJECT
 */
public class DTrans {
    String barang;
    int harga;
    int jumlah;
    String icon;
    int subtotal;

    public DTrans(String barang, int harga, int jumlah,String icon,int subtotal) {
        this.barang = barang;
        this.harga = harga;
        this.jumlah = jumlah;
        this.icon= icon;
        this.subtotal = subtotal;
    }
    
    public DTrans(String barang, int harga, int jumlah,int subtotal) {
        this.barang = barang;
        this.harga = harga;
        this.jumlah = jumlah;
        this.subtotal = subtotal;
    }

    public Object[] getObj(){
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        Object[] o = {this.barang,kursIndonesia.format(harga) + "/ Kg", this.jumlah + " Kg", kursIndonesia.format(subtotal)};
        return o;
    }
    
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
    @Override
    public String toString() {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        return  barang + "~" + kursIndonesia.format(harga) + "/ Kg~" + jumlah + " Kg~" + kursIndonesia.format(subtotal);
    }
    
    
}
