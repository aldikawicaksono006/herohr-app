/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Date;

/**
 *
 * @author Aldika W
 */
abstract public class Orang {
    // Deklarasi variable
    private int id;
    private String nama;
    private String jk;
    private String tempatLahir;
    private Date tglLahir;
    private String noTelp;
    private String email;
    private String password;

    // Constructor
    public Orang(int id, String nama, String jk, String tempatLahir, Date tglLahir, String noTelp, String email, String Password){
        this.id = id;
        this.nama = nama;
        this.jk = jk;
        this.tempatLahir = tempatLahir;
        this.tglLahir = tglLahir;
        this.noTelp = noTelp;
        this.email = email;
        this.password = Password;
    }
    
    public Orang(int id, String nama, String email, String Password){
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.password = Password;
    }
    
    public Orang(int id, String nama, String noTelp, String email, String Password){
        this.id = id;
        this.nama = nama;
        this.noTelp = noTelp;
        this.email = email;
        this.password = Password;
    }
    
    // Getter and Setter
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

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
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
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
