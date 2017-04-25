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
public class Gelar {
     private String namaGelar;
    private int thnMasuk;
    private int thnKeluar;
    private String institusi;
    private double ipk;

    public Gelar(String namaGelar, int thnMasuk, int thnKeluar, String institusi, double ipk) {
        this.namaGelar = namaGelar;
        this.thnMasuk = thnMasuk;
        this.thnKeluar = thnKeluar;
        this.institusi = institusi;
        this.ipk = ipk;
    }
    
    // Setter & Getter
    
    public String getNamaGelar() {
        return namaGelar;
    }

    public void setNamaGelar(String namaGelar) {
        this.namaGelar = namaGelar;
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

    public String getInstitusi() {
        return institusi;
    }

    public void setInstitusi(String institusi) {
        this.institusi = institusi;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }
}
