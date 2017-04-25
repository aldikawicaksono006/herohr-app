/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Aldika W
 */
public class Pengalaman {
    private String job;
    private int thnMasuk;
    private int thnKeluar;
    private String divisi;
    private String kota;
    private String prov;

    public Pengalaman(String job, int thnMasuk, int thnKeluar, String divisi, String kota, String prov) {
        this.job = job;
        this.thnMasuk = thnMasuk;
        this.thnKeluar = thnKeluar;
        this.divisi = divisi;
        this.kota = kota;
        this.prov = prov;
    }

    // Setter & Getter
    
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getThnMasuk() {
        return thnMasuk;
    }

    public void setThnMasuk(int thnMasuk) {
        this.thnMasuk = thnMasuk;
    }

    public int getThnKeluar() {
        return thnKeluar;
    }

    public void setThnKeluar(int thnKeluar) {
        this.thnKeluar = thnKeluar;
    }

    public String getDivisi() {
        return divisi;
    }

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }
    
}
