package model;

/**
 * File Description
 *
 * @author Afnizar Nur Ghifari <afnizarhilmi@gmail.com>
 * @since Apr 30, 2017
 */
import java.util.Date;
import java.util.List;

public class Pelamar extends Orang {

    private BerkasLamaran b;
    private int idPelamar;

    public Pelamar(int id, String nama, String jKelamin, String tempatLahir, Date tglLahir, String noTelp, String email, String pass) {
        super(id, nama, jKelamin, tempatLahir, tglLahir, noTelp, email, pass);
        this.idPelamar = id;
        b = new BerkasLamaran();
    }

    public Pelamar(int id, String nama, String email, String pass) {
        super(id, nama, email, pass);
        this.idPelamar = id;
        b = new BerkasLamaran();
    }

    public int getIdPelamar() {
        return idPelamar;
    }

    public void setIdPelamar(int idPelamar) {
        this.idPelamar = idPelamar;
    }

    public BerkasLamaran getB() {
        return b;
    }

    public void setB(BerkasLamaran b) {
        this.b = b;
    }

    public void createBerkas(int idpelamar) {
        getB().setIdBerkas(idpelamar);
    }
}
