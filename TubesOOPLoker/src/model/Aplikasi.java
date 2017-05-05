package model;

/**
 * File Description
 *
 * @author Afnizar Nur Ghifari <afnizarhilmi@gmail.com>
 * @since Apr 30, 2017
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aplikasi {

    private List<Pelamar> daftarPelamar = new ArrayList<>();
    private List<Perusahaan> daftarPerusahaan = new ArrayList();

    public Aplikasi() {
        daftarPerusahaan = new ArrayList();
        daftarPelamar = new ArrayList();

        Perusahaan p = new Perusahaan(daftarPerusahaan.size(), "Tripvisto", "-", "Leisure, Travel & Tourism", "Information Technology", 30, "Bernardus Sumartok", "1", "1");

        addPerusahaan(p);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateData = null;
        String judul = null;
        String deskripsi = null;

        try {
            // Seeders
            String tgl = "08-12-2017";
            dateData = dateFormat.parse(tgl);
            judul = "UI/UX Designer";
            deskripsi = "Work closely with the Product Team to propose new solutions to complex user-centered design problems\n"
                    + "Identify design problems and devise elegant solutions.";
            daftarPerusahaan.get(0).createLowongan(judul, deskripsi, dateData);

            tgl = "02-02-2017";
            dateData = dateFormat.parse(tgl);
            judul = "Senior Software Engineer ";
            deskripsi = "Designing, developing and improving the quality of Tripvisto’s tech and product.";
            daftarPerusahaan.get(0).createLowongan(judul, deskripsi, dateData);

            Pelamar a = new Pelamar(daftarPelamar.size() - 1, "Afnizar", "1", "1");
            addPelamar(a);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void addPerusahaan(Perusahaan p) {
        daftarPerusahaan.add(p);
    }

    public List<Perusahaan> getDaftarPerusahaan() {
        if (daftarPerusahaan.isEmpty()) {
            return null;
        } else {
            return daftarPerusahaan;
        }
    }

    public List<Pelamar> getDaftarPelamar() {
        if (daftarPelamar.isEmpty()) {
            return null;
        } else {
            return daftarPelamar;
        }
    }
    
     public Pelamar getDaftarPelamar(int id) {
        return daftarPelamar.get(id);
    }
    
    
    public BerkasLamaran lihatBerkas(Pelamar p){
        return p.getB();
    }

    public Perusahaan loginPerusahaan(String email, String pass) {
        int i = 0;
        boolean find = false;

        while (find == false) {
            if (getDaftarPerusahaan().get(i).getEmail().equals(email) && getDaftarPerusahaan().get(i).getPass().equals(pass)) {
                return getDaftarPerusahaan().get(i);
            } else {
                i++;
            }
        }
        return null;
    }

    public Pelamar loginPelamar(String email, String pass) {
        int i = 0;
        boolean find = false;

        while (find == false) {
            if (getDaftarPelamar().get(i).getEmail().equals(email) && getDaftarPelamar().get(i).getPass().equals(pass)) {
                return getDaftarPelamar().get(i);
            } else {
                i++;
            }
        }
        return null;
    }

    public void addPelamar(Pelamar p) {
        daftarPelamar.add(p);
    }

    public Object getDaftarLowongan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
