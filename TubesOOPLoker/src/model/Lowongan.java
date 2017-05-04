package model;

/**
 * File Description
 *
 * @author Afnizar Nur Ghifari <afnizarhilmi@gmail.com>
 * @since Apr 30, 2017
 */
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Lowongan {

    private int idLowongan;
    private String judul;
    private String deskripsi;
    private Date deadline;
    private List<BerkasLamaran> berkasMasuk;
    private List<BerkasLamaran> berkasDiterima;

    public Lowongan(int idLowongan, String judul, String deskripsi, Date deadline) {
        this.idLowongan = idLowongan;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.deadline = deadline;
        berkasMasuk = new ArrayList<BerkasLamaran>();
        berkasDiterima = new ArrayList<BerkasLamaran>();
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getIdLowongan() {
        return idLowongan;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
    

    public void setIdLowongan(int idLowongan) {
        this.idLowongan = idLowongan;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public List<BerkasLamaran> getBerkasMasuk() {
        if (berkasMasuk.isEmpty()) {
            return null;
        } else {
            return berkasMasuk;
        }
    }

    public BerkasLamaran getBerkasMasukbyid(int id) {
        if (berkasMasuk.equals(id)) {
            return berkasMasuk.get(id);
        }
        return null;
    }

    public void setBerkasMasuk(List<BerkasLamaran> berkasMasuk) {
        this.berkasMasuk = berkasMasuk;
    }

    public List<BerkasLamaran> getBerkasDiterima() {
        if (berkasDiterima.isEmpty()) {
            return null;
        } else {
            return berkasDiterima;
        }
    }

    public BerkasLamaran getBerkasDiterimaByID(int id) {
        return berkasDiterima.get(id);
    }

    public void setBerkasDiterima(List<BerkasLamaran> berkasDiterima) {
        this.berkasDiterima = berkasDiterima;
    }

    public void addBerkas(BerkasLamaran b) {
        berkasMasuk.add(b);
    }

    public void terimaBerkas(BerkasLamaran b) {
        berkasDiterima.add(b);
    }

    public String toString() {
        return "ID " + idLowongan 
                + " Judul " + judul
                + " Berkas Masuk " + berkasMasuk
                + " , Berkas Diterima " + berkasDiterima
                + " , deadline " + deadline;
    }
}
