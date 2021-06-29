/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester_001;

/**
 *
 * @author Jou
 */
public class Barang {
    protected String nama;
    protected int jumlah;
    protected String kategori;
    protected String gudang;
    protected int ID;
    static int temp=1;
    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getGudang() {
        return gudang;
    }

    public void setGudang(String gudang) {
        this.gudang = gudang;
    }
    public Barang(String nama, int jumlah,String kategori,String gudang) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.kategori=kategori;
        this.gudang=gudang;
        this.ID=temp;
        temp++;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
}
