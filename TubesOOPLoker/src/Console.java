
/**
 * File Description
 *
 * @author Afnizar Nur Ghifari <afnizarhilmi@gmail.com>
 * @since Apr 29, 2017
 */
import model.Aplikasi;
import model.Perusahaan;
import model.Pelamar;
import model.BerkasLamaran;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.util.List;

public class Console {

    Aplikasi model;

    Scanner inputString = new Scanner(System.in);
    Scanner inputInt = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date date = null;

    public Console(Aplikasi model) {
        this.model = model;
    }

    public void menu() throws ParseException {
        boolean exit = false;
        do {
            mainMenu();
            try {
                int choose = Integer.parseInt(inputString.nextLine());

                switch (choose) {
                    case 1:
                        if (model.getDaftarPerusahaan() == null) {
                            System.out.println("Tidak ada lowongan kerja yang terbuka");
                        } else {
                            lihatLowongan();
                        }

                        String in = inputString.nextLine();
                        break;
                    case 2:
                        menuPerusahaan();
                        in = inputString.nextLine();
                        break;
                    case 3:
                        menuPelamar();
                        in = inputString.nextLine();
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Pilihan Tidak Ada");
                        choose = Integer.parseInt(inputString.nextLine());
                        break;
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan");
                String choose = inputString.nextLine();
            }
        } while (exit == false);
    }

    public void mainMenu() {
        System.out.println("\nMenu Utama");
        System.out.println("1. Lowongan Kerja");
        System.out.println("2. Perusahaan");
        System.out.println("3. Pelamar");
        System.out.println("4. Keluar");
        System.out.print("Masukkan Pilihan : ");
    }

    public void menuPerusahaan() {
        boolean exit = false;
        do {
            System.out.println("\nMenu Perusahaan");
            System.out.println("1. Login");
            System.out.println("2. Daftarkan Perusahaan");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.print("Masukkan Pilihan : ");
            try {
                int n = Integer.parseInt(inputString.nextLine());
                switch (n) {
                    case 1:
                        System.out.println("Login Perusahaan");
                        System.out.print("Email      : ");
                        String email = inputString.nextLine();
                        System.out.print("Kata Sandi : ");
                        String pass = inputString.nextLine();

                        try {
                            Perusahaan perusahaan = model.loginPerusahaan(email, pass);
                            perusahaanMainMenu(perusahaan);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Akun tidak ditemukan");
                        } catch (Exception e) {
                            System.out.println("Ada error");
                        }

                        String in = inputString.nextLine();
                        break;
                    case 2:
                        daftarPerusahaan();
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Pilihan tidak ditemukan");
                        in = inputString.nextLine();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
                String in = inputString.nextLine();
            }
        } while (exit == false);
    }

    public void menuPelamar() {
        boolean exit = false;
        do {
            System.out.println("\nMenu Pelamar");
            System.out.println("1. Login");
            System.out.println("2. Daftarkan Pelamar");
            System.out.println("3. Keluar");
            System.out.print("Masukkan Pilihan : ");
            try {
                int n = Integer.parseInt(inputString.nextLine());
                switch (n) {
                    case 1:
                        System.out.println("Login Pelamar");
                        System.out.print("Email      : ");
                        String email = inputString.nextLine();
                        System.out.print("Kata Sandi : ");
                        String pass = inputString.nextLine();

                        try {
                            Pelamar pelamar = model.loginPelamar(email, pass);
                            pelamarMainMenu(pelamar);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Akun tidak ditemukan");
                        } catch (Exception e) {
                            System.out.println("Ada error");
                        }

                        String in = inputString.nextLine();
                        break;
                    case 2:
                        daftarPelamar();
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Pilihan tidak ditemukan");
                        in = inputString.nextLine();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
                String in = inputString.nextLine();
            }
        } while (exit == false);
    }

    public void daftarPerusahaan() {
        System.out.println("\nDaftarkan Perusahaan Baru");
        System.out.print("Nama Perusahaan ");
        String namaPerusahaan = inputString.nextLine();
        System.out.print("No. Telp ");
        String notelp = inputString.nextLine();
        System.out.print("Jenis Perusahaan ");
        String jenis = inputString.nextLine();
        System.out.print("Kategori Perusahaan ");
        String kat = inputString.nextLine();
        System.out.print("Jumlah Karyawan ");
        int karyawan = inputInt.nextInt();
        System.out.println("\nAkun Utama");
        System.out.print("Nama ");
        String nama = inputString.nextLine();
        System.out.print("Email ");
        String email = inputString.nextLine();

        boolean error = true;
        do {
            System.out.print("Kata Sandi ");
            String pass = inputString.nextLine();
            System.out.print("Ketik ulang kata sandi ");
            String pass2 = inputString.nextLine();

            if (pass.equals(pass2) && !pass.isEmpty()) {
                model.addPerusahaan(new Perusahaan(model.getDaftarPerusahaan().size() - 1, namaPerusahaan, notelp, jenis, kat, karyawan, nama, email, pass));
                System.out.println("Pendaftaran berhasil!");
                error = false;
            } else {
                if (pass.isEmpty()) {
                    System.out.println("Kata Sandi tidak boleh kosong\n");
                } else {
                    System.out.println("Kata sandi tidak sama silahkan ketik ulang\n");
                }
            }

        } while (error);

        String in = inputString.nextLine();
    }

    public void daftarPelamar() {
        System.out.println("\nDaftar Pelamar");
        System.out.print("Nama ");
        String nama = inputString.nextLine();
        System.out.print("Email ");
        String email = inputString.nextLine();

        boolean error = true;
        do {
            System.out.print("Kata Sandi ");
            String pass = inputString.nextLine();
            System.out.print("Ketik ulang kata sandi ");
            String pass2 = inputString.nextLine();

            if (pass.equals(pass2) && !pass.isEmpty()) {
                model.addPelamar(new Pelamar(model.getDaftarPelamar().size() - 1, nama, email, pass));
                System.out.println("Pendaftaran berhasil!");
                error = false;
            } else {
                if (pass.isEmpty()) {
                    System.out.println("Kata Sandi tidak boleh kosong\n");
                } else {
                    System.out.println("Kata sandi tidak sama silahkan ketik ulang\n");
                }
            }
        } while (error);

        String in = inputString.nextLine();
    }

    public void lihatLowongan() {
        System.out.println("\nDaftar Lowongan Kerja\n");

        for (int i = 0; i <= model.getDaftarPerusahaan().size() - 1; i++) {
            String namaPerusahaan = model.getDaftarPerusahaan().get(i).getNamaPerusahaan();

            if (model.getDaftarPerusahaan().get(i).getDaftarLowongan() == null) {
                System.out.println("Perusahaan " + namaPerusahaan + " tidak membuka lowongan kerja");
            } else {
                System.out.println("Nama Perusahaan : " + namaPerusahaan);
                for (int j = 0; j <= model.getDaftarPerusahaan().get(i).getDaftarLowongan().size() - 1; j++) {
                    System.out.println("Lowongan " + (j + 1));
                    System.out.println("Judul " + model.getDaftarPerusahaan().get(i).getDaftarLowonganById(j).getJudul());
                    System.out.println("Deskripsi " + model.getDaftarPerusahaan().get(i).getDaftarLowonganById(j).getDeskripsi());
                    System.out.println("Deadline : " + dateFormat.format(model.getDaftarPerusahaan().get(i).getDaftarLowonganById(j).getDeadline()));
                }
            }
        }
    }

    public void pelamarMainMenu(Pelamar p) {
        List<Perusahaan> per = model.getDaftarPerusahaan();
        boolean exit = false;
        do {
            System.out.println("Hi, " + p.getNama());
            System.out.println("\nMenu Pelamar");
            System.out.println("1. Profil Saya");
            System.out.println("2. Ubah Profil");
            System.out.println("3. Apply Pekerjaan");
            System.out.println("4. Pekerjaan yang Di Apply");
            System.out.println("5. Lihat Berkas");
            System.out.println("6. Buat Berkas");
            System.out.println("7. Logout");
            System.out.print("Masukkan Pilihan : ");

            try {
                int n = Integer.parseInt(inputString.nextLine());
                switch (n) {
                    case 1:
                        // Profil Saya
                        System.out.println("Profil Saya");
                        System.out.println("Nama " + p.getNama());
                        System.out.println("Email " + p.getEmail());
                        System.out.println("Jenis Kelamin " + p.getjKelamin());
                        System.out.println("Tempat Lahir " + p.getTempatLahir());
                        System.out.println("Tanggal Lahir " + p.getTempatLahir());
                        System.out.println("No Telp" + p.getNoTelp());

                        String in = inputString.nextLine();
                        break;
                    case 2:
                        // Ubah Profil
                        try {
                            boolean error = true;
                            do {
                                System.out.println("Ubah Profil");
                                System.out.print("Nama ");
                                String nama = inputString.nextLine();
                                System.out.print("Email ");
                                String email = inputString.nextLine();
                                System.out.print("Jenis Kelamin ");
                                String jk = inputString.nextLine();
                                System.out.print("Tempat Lahir ");
                                String tmpt = inputString.nextLine();
                                System.out.print("Tanggal Lahir (e.g 17-08-1997)");
                                String tggl = inputString.nextLine();
                                System.out.print("No Telp ");
                                String notelp = inputString.nextLine();
                                try {
                                    date = dateFormat.parse(tggl);
                                    p.setNama(nama);
                                    p.setEmail(email);
                                    p.setjKelamin(jk);
                                    p.setTempatLahir(tmpt);
                                    p.setTglLahir(date);
                                    p.setNoTelp(notelp);
                                    System.out.println("Ubah profil berhasil");
                                    error = false;
                                } catch (Exception e) {
                                    System.out.println("Masukan tanggal sesuai format!\n");
                                }
                            } while (error);

                        } catch (Exception e) {
                            System.out.println(e);
                        }

                        in = inputString.nextLine();
                        break;
                    case 3:
                        // Apply Pekerjaan
                        System.out.println("\nDaftar Lowongan Kerja\n");

                        for (int i = 0; i <= model.getDaftarPerusahaan().size() - 1; i++) {
                            String namaPerusahaan = model.getDaftarPerusahaan().get(i).getNamaPerusahaan();

                            if (model.getDaftarPerusahaan().get(i).getDaftarLowongan() == null) {
                                System.out.println("Perusahaan " + namaPerusahaan + " tidak membuka lowongan kerja");
                            } else {
                                System.out.println("Nama Perusahaan : " + namaPerusahaan);
                                for (int j = 0; j <= model.getDaftarPerusahaan().get(i).getDaftarLowongan().size() - 1; j++) {
                                    System.out.println("Lowongan " + (j + 1));
                                    System.out.println("Judul " + model.getDaftarPerusahaan().get(i).getDaftarLowonganById(j).getJudul());
                                    System.out.println("Deskripsi " + model.getDaftarPerusahaan().get(i).getDaftarLowonganById(j).getDeskripsi());
                                    System.out.println("Deadline " + dateFormat.format(model.getDaftarPerusahaan().get(i).getDaftarLowonganById(j).getDeadline()) + "\n");
                                }
                            }
                        }

                        System.out.print("Masukkan Nama Perusahaan ");
                        in = inputString.nextLine();
                        boolean status = false;

                        for (int j = 0; j <= model.getDaftarPerusahaan().size() -1 ; j++) {
                            if (per.get(j).getNamaPerusahaan().equals(in)) {
                                for (int k = 0; k <= per.get(j).getDaftarLowongan().size() - 1; k++) {
                                    if (per.get(j).getDaftarLowongan(k).getIdLowongan() == per.get(j).getId()) {
                                        for (int l = 0; l <= per.get(j).getDaftarLowongan().size()-1; l++){
                                        System.out.println("Lowongan ke-" + (l + 1));
                                        System.out.println("Judul " + model.getDaftarPerusahaan().get(j).getDaftarLowongan(l).getJudul());
                                        System.out.println("Deadline " + dateFormat.format(per.get(j).getDaftarLowongan(l).getDeadline()) + "\n");                   
                                        }     
                                        status = true;
                                    }                                    
                                }
                                if (status == true) {
                                    
                                    System.out.print("Masukkan pilihan (1 - " + /*model.getDaftarPerusahaan().size()*/per.get(j).getDaftarLowongan().size() + ") : ");
                                    int pilihan = Integer.parseInt(inputString.nextLine());
                                    if ((pilihan >/* model.getDaftarPerusahaan().size()*/per.get(j).getDaftarLowongan().size()) || (pilihan < 0)) {
                                        System.out.println("Lowongan tidak tersedia");
                                    } else {
                                        per.get(j).getDaftarLowonganById(pilihan - 1).addBerkas(p.getB());
                                        System.out.println("Anda berhasil melamar");
                                    }
                                } else {
                                    System.out.println("Data tidak ditemukan");
                                }
                            }
                        }

                        in = inputString.nextLine();
                        break;
                    case 4:
                        System.out.println("Perusahaan yang Anda apply : ");
                        status = false;

                        for (int i = 0; i < per.size(); i++) {
                            for (int j = 0; j < per.get(i).getDaftarLowongan().size(); j++) {
                                if (per.get(i).getDaftarLowonganById(j).getBerkasMasuk() != null) {
                                    for (int k = 0; k < per.get(i).getDaftarLowonganById(j).getBerkasMasuk().size(); k++) {
                                        if (per.get(i).getDaftarLowonganById(j).getBerkasMasuk(k).getIdBerkas() == (p.getB().getIdBerkas())) {
                                            System.out.println("Perusahaan : " + per.get(i).getNamaPerusahaan());
                                            System.out.println("Posisi : " + per.get(i).getDaftarLowonganById(j).getJudul());
                                            status = true;
                                        }
                                    }
                                }
                            }
                        }

                        System.out.println("\nDaftar Lamaran di Terima : ");
                        for (int i = 0; i < per.size(); i++) {
                            for (int j = 0; j < per.get(i).getDaftarLowongan().size(); j++) {
                                if (per.get(i).getDaftarLowongan(j).getBerkasDiterima() != null) {
                                    for (int k = 0; k < per.get(i).getDaftarLowongan(j).getBerkasDiterima().size(); k++) {
                                        if (per.get(i).getDaftarLowongan(j).getBerkasDiterima(k).getIdBerkas() == (p.getB().getIdBerkas())) {
                                            System.out.println("Perusahaan yang menerima Anda : " + per.get(i).getNamaPerusahaan());
                                            status = true;
                                        }
                                    }
                                }
                            }
                        }

                        if (status == false) {
                            System.out.println("\n\"Tidak ada perusahaan yang Anda lamar\"");
                        }

                        in = inputString.nextLine();
                        break;
                    case 5:
                        // Lihat Berkas
                        System.out.println("Berkas Lamaran Anda");
                        BerkasLamaran berkas = model.lihatBerkas(p);
                        if (berkas.getDeskripsi() == null) {
                            System.out.println("\"Berkas Lamaran anda masih kosong segera isi\"");
                        } else {
                            System.out.println(berkas.getDeskripsi());
                        }
                        in = inputString.nextLine();
                        break;
                    case 6:
                        System.out.println("Isi berkas Lamaran Anda");
                        System.out.print("Berkas Lamaran (isi dengan riwayat hidup, pengalaman kerja, dll) : ");
                        String berkasL = inputString.nextLine();
                        model.lihatBerkas(p).setDeskripsi(berkasL);

                        System.out.println("\nIsi berkas berhasil!");
                        in = inputString.nextLine();
                        break;
                    case 7:
                        System.out.println("Logout berhasil");
                        exit = true;
                        in = inputString.nextLine();
                        break;
                    default:
                        System.out.println("Pilihan tidak ditemukan");
                        in = inputString.nextLine();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
                String in = inputString.nextLine();
            }
        } while (exit == false);
    }

    public void perusahaanMainMenu(Perusahaan p) {
        boolean exit = false;
        do {
            System.out.println("\nPerusahaan " + p.getNamaPerusahaan());
            System.out.println("\nMenu Perusahaan");
            System.out.println("1. Buka Lowongan Kerja");
            System.out.println("2. Lihat Lowongan Kerja Perusahaan Ini");
            System.out.println("3. Ubah Lowongan Kerja");
            System.out.println("4. Hapus Lowongan Kerja");
            System.out.println("5. Lihat Berkas Lamaran Masuk");
            System.out.println("6. Lihat Berkas Lamaran Diterima");
            System.out.println("7. Logout");
            System.out.print("Masukkan Pilihan : ");

            try {
                int n = Integer.parseInt(inputString.nextLine());
                switch (n) {
                    case 1:
                        System.out.println("\nBuka Lowongan Kerja\n");

                        boolean error = true;
                        do {
                            System.out.println("Nama Lowongan Pekerjaan ");
                            String judul = inputString.nextLine();
                            System.out.println("Deskripsi Pekerjaan");
                            String deskripsi = inputString.nextLine();
                            System.out.print("\nMasukan tanggal deadline, (e.g 17-08-1997) ");
                            String deadline = inputString.nextLine();

                            try {
                                date = dateFormat.parse(deadline);
                                p.createLowongan(judul, deskripsi, date);
                                System.out.println("Lowongan telah dipublish!");
                                error = false;
                            } catch (Exception e) {
                                System.out.println("Masukan tanggal sesuai format!\n");
                            }
                        } while (error);

                        String in = inputString.nextLine();
                        break;
                    case 2:
                        System.out.println("Lihat Lowongan di " + p.getNamaPerusahaan());

                        if (p.getDaftarLowongan() == null) {
                            System.out.println("Perusahaan tidak membuka lowongan pekerjaan");
                        } else {
                            for (int i = 0; i <= p.getDaftarLowongan().size() - 1; i++) {
                                System.out.println("Lowongan ke-" + (i + 1));
                                System.out.println("Judul " + p.getDaftarLowonganById(i).getJudul());
                                System.out.println("Deskripsi " + p.getDaftarLowonganById(i).getDeskripsi());
                                System.out.println("Deadline " + dateFormat.format(p.getDaftarLowonganById(i).getDeadline()) + "\n");
                            }
                        }

                        in = inputString.nextLine();
                        break;
                    case 3:
                        // Ubah Lowongan Kerja
                        if (p.getDaftarLowongan() == null) {
                            System.out.println("Perusahaan tidak membuka lowongan pekerjaan");
                        } else {
                            for (int i = 0; i <= p.getDaftarLowongan().size() - 1; i++) {
                                System.out.println("Lowongan ke-" + (i + 1));
                                System.out.println("Judul " + p.getDaftarLowonganById(i).getJudul());
                                System.out.println("Deskripsi " + p.getDaftarLowonganById(i).getDeskripsi());
                                System.out.println("Deadline " + dateFormat.format(p.getDaftarLowonganById(i).getDeadline()) + "\n");
                            }
                        }

                        System.out.print("Masukkan ID pekerjaan yang ingin diubah: ");
                        int idlowongan = Integer.parseInt(inputString.nextLine());

                        if ((idlowongan > p.getDaftarLowongan().size()) || (idlowongan < 0)) {
                            System.out.println("Data tidak ditemukan");
                        } else {
                            try {
                                error = true;
                                do {
                                    System.out.println("Nama Lowongan Pekerjaan ");
                                    String judul = inputString.nextLine();
                                    System.out.println("Deskripsi Pekerjaan");
                                    String deskripsi = inputString.nextLine();
                                    System.out.print("\nMasukan tanggal deadline, (e.g 17-08-1997) ");
                                    String deadline = inputString.nextLine();

                                    try {
                                        date = dateFormat.parse(deadline);
                                        p.updateLowongan(idlowongan, judul, deskripsi, date);
                                        System.out.println("Lowongan telah diupdate!");
                                        error = false;
                                    } catch (Exception e) {
                                        System.out.println("Masukan tanggal sesuai format!\n");
                                    }
                                } while (error);

                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                        in = inputString.nextLine();
                        break;
                    case 4:
                        System.out.println("Daftar Lowongan Kerja\n");
                        for (int j = 0; j <= p.getDaftarLowongan().size() - 1; j++) {
                            System.out.println("Lowongan " + (j + 1));
                        }

                        System.out.print("Masukkan ID pekerjaan: ");
                        idlowongan = Integer.parseInt(inputString.nextLine());

                        if ((idlowongan > p.getDaftarLowongan().size()) || (idlowongan < 0)) {
                            System.out.println("Data tidak ditemukan");
                        } else {
                            System.out.println("Apakah anda yakin menghapus data ini?");
                            System.out.print("Y/N? ");
                            in = inputString.nextLine();

                            if (in.toLowerCase().equals("y")) {
                                try {
                                    p.removeLowongan(idlowongan - 1);
                                    System.out.println("Data berhasil dihapus \n");
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                        }

                        in = inputString.nextLine();
                        break;
                    case 5:
                        // Lihat Berkas Lamaran Masuk
                        System.out.println("Berkas Lamaran Masuk : ");
                        if (p.getDaftarLowongan() == null) {
                            System.out.println("Tidak ada lamaran masuk");
                        } else {
                            int st = 0;
                            for (int j = 0; j <= p.getDaftarLowongan().size() - 1; j++) {
                                if (p.getDaftarLowongan(j).getBerkasMasuk() == null) {
                                    st++;
                                } else {
                                    System.out.println("Ada " + p.getDaftarLowongan(j).getBerkasMasuk().size() + " berkas yang masuk");
                                    for (int k = 0; k <= p.getDaftarLowongan(j).getBerkasMasuk().size() - 1; k++) {
                                        System.out.println("Berkas Masuk ke-" + (k + 1));
                                        for (int i = 0; i < model.getDaftarPelamar().size(); i++) {
                                            if (model.getDaftarPelamar(i).getIdPelamar() == p.getDaftarLowongan(j).getBerkasMasuk(k).getIdBerkas()) {
                                                System.out.println("Nama " + model.getDaftarPelamar(i).getNama());
                                                System.out.println("No Telp : " + model.getDaftarPelamar(i).getNoTelp());
                                                System.out.println("Jenis Kelamin :" + model.getDaftarPelamar(i).getjKelamin());
                                            }
                                        }
                                    }
                                }
                            }
                            if (st == p.getDaftarLowongan().size()) {
                                System.out.println("Tidak ada lamaran masuk");
                            }
                        }

                        in = inputString.nextLine();
                        break;
                    case 6:
                        // Lihat Berkas Lamaran Diterima
                        if (p.getDaftarLowongan() == null) {
                            System.out.println("Tidak ada lamaran masuk yang di terima");
                        } else {
                            int st = 0;
                            for (int j = 0; j <= p.getDaftarLowongan().size() - 1; j++) {
                                if (p.getDaftarLowongan(j).getBerkasDiterima() == null) {
                                    st++;
                                } else {
                                    System.out.println("Ada " + p.getDaftarLowongan(j).getBerkasDiterima().size() + " berkas yang di terima");
                                    for (int k = 0; k <= p.getDaftarLowongan(j).getBerkasDiterima().size() - 1; k++) {
                                        System.out.println("Berkas di Terima ke-" + (k + 1));
                                        for (int i = 0; i < model.getDaftarPelamar().size(); i++) {
                                            if (model.getDaftarPelamar(i).getIdPelamar() == p.getDaftarLowongan(j).getBerkasDiterima(k).getIdBerkas()) {
                                                System.out.println("Nama          : " + model.getDaftarPelamar(i).getNama());
                                                System.out.println("No Telp       : " + model.getDaftarPelamar(i).getNoTelp());
                                            }
                                        }
                                    }
                                }
                            }
                            if (st == p.getDaftarLowongan().size()) {
                                System.out.println("Tidak ada lamaran masuk yang di terima.");
                            }
                        }

                        in = inputString.nextLine();
                        break;
                    case 7:
                        System.out.println("Logout berhasil");
                        exit = true;
                        break;
                    default:
                        System.out.println("Pilihan tidak ditemukan");
                        in = inputString.nextLine();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
                String in = inputString.nextLine();
            }
        } while (exit == false);
    }
}
