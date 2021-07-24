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
public class Sampah {
    int id,harga;
    String kategori,keterangan;

    public Sampah(int id, String kategori,int harga, String keterangan) {
        this.id = id;
        this.harga = harga;
        this.kategori = kategori;
        this.keterangan = keterangan;
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
    
}
