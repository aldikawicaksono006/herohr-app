package model;

/**
 * File Description
 *
 * @author Afnizar Nur Ghifari <afnizarhilmi@gmail.com>
 * @since Apr 29, 2017
 */
import java.util.Date;

abstract public class Orang {

    private int id;
    private String nama;
    private String jKelamin;
    private String tempatLahir;
    private Date tglLahir;
    private String noTelp;
    private String email;
    private String pass;

    public Orang(int id, String nama, String jKelamin, String tempatLahir, Date tglLahir, String noTelp, String email, String pass) {
        this.id = id;
        this.nama = nama;
        this.jKelamin = jKelamin;
        this.tempatLahir = tempatLahir;
        this.tglLahir = tglLahir;
        this.noTelp = noTelp;
        this.email = email;
        this.pass = pass;
    }

    public Orang(int id, String nama, String email, String pass) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.pass = pass;
    }

    public Orang(int id, String nama, String noTelp, String email, String pass) {
        this.id = id;
        this.nama = nama;
        this.noTelp = noTelp;
        this.email = email;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getjKelamin() {
        return jKelamin;
    }

    public void setjKelamin(String jKelamin) {
        this.jKelamin = jKelamin;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
