
/**
 * File Description
 *
 * @author Afnizar Nur Ghifari <afnizarhilmi@gmail.com>
 * @since Apr 29, 2017
 */
import model.Aplikasi;
import model.Perusahaan;
import model.Pelamar;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;

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
//                            perusahaanMainMenu(pelamar);
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
        System.out.print("Password ");
        String pass = inputString.nextLine();

        model.addPerusahaan(new Perusahaan(model.getDaftarPerusahaan().size() - 1, namaPerusahaan, notelp, jenis, kat, karyawan, nama, email, pass));
        System.out.println("Pendaftaran Berhasil!");
        String in = inputString.nextLine();
    }

    void DaftarPelamar() {
        System.out.println("\nDaftar Pelamar");
        System.out.print("Nama");
        String nama = inputString.nextLine();
        System.out.print("Email");
        String email = inputString.nextLine();
        System.out.print("Kata Sandi");
        String pass = inputString.nextLine();
        model.addPelamar(new Pelamar(model.getDaftarPelamar().size() - 1, nama, email, pass));
        System.out.println("Pendaftaran berhasil!");
        
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
                        System.out.println("Berkas Lamaran Masuk");
                        if (p.getDaftarLowongan() == null) {
                            System.out.println("Tidak ada lamaran masuk");
                        } else {
                            for (int j = 0; j <= p.getDaftarLowongan().size() - 1; j++) {
                                System.out.println("Lowongan " + (j + 1));
                                if (p.getDaftarLowonganById(j).getBerkasMasuk() != null) {
                                    for (int i = 0; i < p.getDaftarLowonganById(j).getBerkasMasuk().size(); i++) {
                                        System.out.println("Ada berkas masuk");
                                    }
                                }
                            }
                        }

                        in = inputString.nextLine();
                        break;
                    case 6:
                        // Lihat Berkas Lamaran Diterima
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
