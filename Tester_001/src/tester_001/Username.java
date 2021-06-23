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
//    ArrayList<Username>arr=new ArrayList<Username>();
//
//    public ArrayList<Username> getArr() {
//        return arr;
//    }
//
//    public void setArr(ArrayList<Username> arr) {
//        this.arr = arr;
//    }
//    public void inputarr(int i,Username us)
//    {
//        if(i==100)arr.add(us);
//    }
    public Username(String user, String pass, String nama, String alamat, long nohp) {
//        arr=new ArrayList<Username>();
        this.id=index;
        this.user = user;
        this.pass = pass;
        this.nama = nama;
        this.alamat = alamat;
        this.nohp = nohp;
        index++;
    }
    public Username() {
//        arr=new ArrayList<Username>();
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
        return this.id+"-"+this.user+"-"+this.nama+"-"+this.alamat+"-"+this.nohp;
    }
}
