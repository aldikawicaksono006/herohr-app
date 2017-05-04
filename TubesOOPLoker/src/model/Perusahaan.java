package model;

/**
 * File Description
 *
 * @author Afnizar Nur Ghifari <afnizarhilmi@gmail.com>
 * @since Apr 30, 2017
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;

public class Perusahaan extends Orang {

    private List<Lowongan> daftarLowongan;
    private int id;
    private String namaPerusahaan;
    private String jenis;
    private String kat;
    private int karyawan;

    public Perusahaan(int id, String nama, String jKelamin, String tempatLahir, Date tglLahir, String noTelp, String email, String pass, String namaPerusahaan) {
        super(id, nama, jKelamin, tempatLahir, tglLahir, noTelp, email, pass);
        this.id = id;
        this.namaPerusahaan = namaPerusahaan;
        daftarLowongan = new ArrayList<Lowongan>() {
        };
    }

    public Perusahaan(int id, String namaPerusahaan, String noTelp, String jenis, String kat, int karyawan, String nama, String email, String pass) {
        super(id, nama, noTelp, email, pass);
        this.id = id;
        this.namaPerusahaan = namaPerusahaan;
        this.jenis = jenis;
        this.kat = kat;
        this.karyawan = karyawan;
        daftarLowongan = new ArrayList<Lowongan>() {
        };
    }

    public List<Lowongan> getDaftarLowongan() {
        if (daftarLowongan.isEmpty()) {
            return null;
        } else {
            return daftarLowongan;
        }
    }

    public Lowongan getDaftarLowonganById(int id) {
        return daftarLowongan.get(id);
    }

    public void setDaftarLowongan(List<Lowongan> daftarLowongan) {
        this.daftarLowongan = daftarLowongan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getKat() {
        return kat;
    }

    public void setKat(String kat) {
        this.kat = kat;
    }

    public int getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(int karyawan) {
        this.karyawan = karyawan;
    }

    public void createLowongan(String judul, String deskripsi, Date deadline) {
        int totalLowongan = daftarLowongan.size();
        Lowongan lo = new Lowongan(totalLowongan++, judul, deskripsi, deadline);
        daftarLowongan.add(lo);
    }
    
    public void updateLowongan(int id, String judul, String deskripsi, Date deadline) {
        Lowongan lo = new Lowongan(id, judul, deskripsi, deadline);
        daftarLowongan.add(lo);
    }

    public void removeLowongan(int id) {
        daftarLowongan.remove(id);
    }

    public String toString() {
        return "ID " + id
                + " Perusahaan " + namaPerusahaan
                + " , Daftar Lowongan " + daftarLowongan
                + " , Jenis " + jenis
                + " , Kategori " + kat
                + " , Karyawan " + karyawan;
    }
}
