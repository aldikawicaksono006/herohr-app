package model;

/**
 * File Description
 *
 * @author Afnizar Nur Ghifari <afnizarhilmi@gmail.com>
 * @since Apr 30, 2017
 */
public class BerkasLamaran {

    private int idBerkas;
    private String deskripsi;

    public int getIdBerkas() {
        return idBerkas;
    }

    public void setIdBerkas(int idBerkas) {
        this.idBerkas = idBerkas;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String toString() {
        return "ID Berkas " + idBerkas
                + " Deskripsi " + deskripsi;
    }
}
