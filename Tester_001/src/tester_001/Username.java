/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester_001;

import java.util.ArrayList;

/**
 *
 * @author Jou
 */
public class Username {
    static int index=1;
    private int id;
    private String user;
    private String pass;
    private String nama;
    private String alamat;
    private long nohp;
    public Username(String user, String pass, String nama, String alamat, long nohp) {
        this.id=index;
        this.user = user;
        this.pass = pass;
        this.nama = nama;
        this.alamat = alamat;
        this.nohp = nohp;
        index++;
    }
    public Username() {
        this.id=index;
        this.user = user;
        this.pass = pass;
        this.nama = nama;
        this.alamat = alamat;
        this.nohp = nohp;
        index++;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public long getNohp() {
        return nohp;
    }

    public void setNohp(long nohp) {
        this.nohp = nohp;
    }
    @Override
    public String toString(){
        return this.id+"-"+this.user+"-"+this.nama+"-"+this.nohp;
    }
}
