/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester_001;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;


/**
 *
 * @author ADMIN
 */
public class HTrans {
    int idtrans;
    String customer;
    Date waktutransaksi;
    int total;

    public HTrans(int idtrans, String customer, Date waktutransaksi, int total) {
        this.idtrans = idtrans;
        this.customer = customer;
        this.waktutransaksi = waktutransaksi;
        this.total = total;
    }

    public int getIdtrans() {
        return idtrans;
    }

    public void setIdtrans(int idtrans) {
        this.idtrans = idtrans;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getWaktutransaksi() {
        return waktutransaksi;
    }

    public void setWaktutransaksi(Date waktutransaksi) {
        this.waktutransaksi = waktutransaksi;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object[] getObj(){
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        
        Object[] o = {this.idtrans,this.customer, this.waktutransaksi, kursIndonesia.format(total)};
        return o;
    }

    @Override
    public String toString() {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        return  idtrans + "~" + customer + "~" + waktutransaksi + "~" + kursIndonesia.format(total) ;
    }
    
    
    
    
    
    
    
}
