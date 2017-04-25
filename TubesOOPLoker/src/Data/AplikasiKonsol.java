/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Aldika W
 */
public class AplikasiKonsol {
    
    public void mainMenu() throws ParseException{
        List<Pelamar> pelamarList = new ArrayList<>();
        List<Perusahaan> perusahaanList = new ArrayList();
        
        Scanner input = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);
        Scanner ind = new Scanner(System.in);
        
        // Coba Buat Perusahaan
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date2=null;
        
        Perusahaan p = new Perusahaan(perusahaanList.size()-1, "PT", "08", "Perbankan", "Keuangan", 5, "", "", "");
        perusahaanList.add(p);
        Perusahaan p1 = new Perusahaan(perusahaanList.size()-1, "Psahdasd", "08", "Perbankan", "Keuangan", 5, "Darth", "Vader", "Sith");
        perusahaanList.add(p1);
        try{
            String tgl = "08-12-2017";
            date2 = dateFormat.parse(tgl);
            
            //Output Tanggal System.out.println ("tgl : "+dateFormat.format(date2));
            perusahaanList.get(0).createLowongan(date2);
            perusahaanList.get(0).createLowongan(date2);
            perusahaanList.get(1).createLowongan(date2);
            perusahaanList.get(1).createLowongan(date2);
            
            //System.out.println("Lowongan berhasil");
        
        }catch(ParseException e){
            e.printStackTrace();
        }
        
        // Buat Pelamar
        Pelamar pel = new Pelamar(pelamarList.size()-1, "", "","");
        pelamarList.add(pel);
        
        
        List<Gelar> gelar = new ArrayList<>();
        List<String> skill = new ArrayList<>();
        List<Pengalaman> pengalaman = new ArrayList<>();
        List<String> bahasa = new ArrayList<>();        
        
        // Menu List
        Aplikasi app = new Aplikasi();
        int pil = -1; 
        boolean keluar = false;
        do{
            app.mainMenu();
            try{
                int n = -1;
                pil = input.nextInt();
                switch(pil){
                    case 0 : // Keluar
                        keluar = true;
                        System.out.println("Keluar Program");
                        break;
                    case 1 : // Daftar Lowongan Kerja
                        if(perusahaanList.isEmpty()){
                            System.out.print("Tidak ada daftar Lowongan");
                        }else{
                            System.out.println("\nBanyak Perusahaan : "+ perusahaanList.size() + "\n");
                            System.out.println("Daftar Lowongan Kerja : ");
                            int SP = perusahaanList.size();
                            for(int i=0;i<=SP-1;i++){
                                String namaPerusahaan = perusahaanList.get(i).getNmPerusahaan(); 
                                System.out.println("Nama Perusahaan : " + namaPerusahaan);
                                if(perusahaanList.get(i).getDaftarLowongan() == null){
                                    System.out.println("Perusahaan " + namaPerusahaan + " tidak memiliki lowongan pekerjaan");
                                }else{
                                    int SL = perusahaanList.get(i).getDaftarLowongan().size();
                                    for (int j = 0; j <= SL-1; j++) {
                                        System.out.println("Lowongan " + (j+1));
                                        System.out.println("\t Deadline : " + dateFormat.format(perusahaanList.get(i).getdaftarLowongan(j).getDeadline()) + "\n");
                                    } 
                                }
                            } 
                        }
                        String in = inp.nextLine();
                        break;
                    case 2 : // Menu Perusahaan
                        boolean exit = false;
                        do{
                            app.PerusahaanMenu();
                            n = input.nextInt();
                            switch(n){
                                case 0 :
                                    exit = true;
                                    break;
                                case 1 : // Login Perusahaan
                                    app.login(1);
                                    String email = inp.nextLine();
                                    app.login(2);
                                    String password = inp.nextLine();
                                    if(perusahaanList.size() == 0 ){
                                        System.out.println("Anda belum terdaftar"); 
                                        break;
                                    }else{
                                        int i = 0;
                                        boolean find = false;
                                        while (find != true) {
                                            if (perusahaanList.get(i).getEmail().equals(email) && perusahaanList.get(i).getPassword().equals(password)) {
                                                find = true;
                                            }else {
                                                i++;
                                            }
                                        }
                                        if(find==true){
                                            System.out.println("Selamat Datang Perusahaan " + perusahaanList.get(i).getNmPerusahaan());
                                            System.out.println("=================================");
                                            boolean kl = false;
                                            do{
                                                app.perusahaanMainMenu();
                                                try{
                                                    int pilihan = input.nextInt();
                                                    switch(pilihan){
                                                        case 0 :
                                                            System.out.println("Apakah anda yakin akan keluar?");
                                                            System.out.print("Pilihan (Ya/Tidak) : ");
                                                            String inpt = inp.nextLine();
                                                            if(inpt.equals("Ya") || inpt.equals("ya")){
                                                                kl = true;
                                                            }else{
                                                                inpt = inp.nextLine();
                                                            }
                                                            break;
                                                        case 1 : // Daftar Pelamar
                                                            System.out.println("Daftar Pelamar (Keseluruhan) : ");
                                                            String q = inp.nextLine();
                                                            break;
                                                        case 2 : // Lihat Lowongan
                                                            if(perusahaanList.get(i).getDaftarLowongan() == null){
                                                                System.out.println("Tidak ada lowongan. Silahkan buat lowongan!");
                                                            }else {
                                                                int jmlLow = perusahaanList.get(i).getDaftarLowongan().size();
                                                                for (int j = 0; j <= jmlLow-1; j++) {
                                                                    System.out.println("Lowongan ke-" + (j+1));
                                                                    System.out.println("\t Deadline : " + dateFormat.format(perusahaanList.get(i).getdaftarLowongan(j).getDeadline()) + "\n");
                                                                }
                                                            }
                                                            q = inp.nextLine();
                                                            break;
                                                        case 3 : //Buat Lowongan
                                                            System.out.print("Masukkan Tanggal : ");
                                                            String tgl = inp.nextLine();
                                                            try {
                                                                date2 = dateFormat.parse(tgl);
                                                                System.out.println(perusahaanList.get(i).getNmPerusahaan());
                                                                perusahaanList.get(i).createLowongan(date2);
                                                                System.out.println("Lowongan telah dibuat!");
                                                            } catch (ParseException e) {
                                                                e.printStackTrace();
                                                            }
                                                            q = inp.nextLine();
                                                            break;
                                                        case 4 : //Hapus Lowongan
                                                            q = inp.next();
                                                            break;
                                                        case 5 : //Lihat Berkas Lamaran Masuk
                                                            q = inp.next();
                                                            break;
                                                        case 6 : //Lihat Berkas Lamaran Di Terima
                                                            q = inp.next();
                                                            break;
                                                        default : 
                                                            System.out.println("Anda salah memasukkan angka !");
                                                            q = inp.next();
                                                            break;
                                                    }
                                                }catch(Exception e){
                                                    System.out.println("Kesalah input");
                                                    String mk = inp.nextLine();
                                                }
                                            }while(kl == false);
                                        }else{
                                            System.out.println("Email dan Password Salah!");
                                        }
                                    }
                                    in = inp.nextLine();
                                    break;
                                case 2 : // Daftar Akun Perusahaan
                                    app.daftarAccPerusahaan(1);
                                    String nmPerusahaan = inp.nextLine();
                                    app.daftarAccPerusahaan(2);
                                    String noTelp = inp.nextLine();
                                    app.daftarAccPerusahaan(3);
                                    String jenis = inp.nextLine();
                                    app.daftarAccPerusahaan(4);
                                    String kat = inp.nextLine();
                                    app.daftarAccPerusahaan(5);
                                    int karyawan = input.nextInt();
                                    app.daftarAccPerusahaan(6);
                                    String nama = inp.nextLine();
                                    app.daftarAccPerusahaan(7);
                                    email = inp.nextLine();
                                    app.daftarAccPerusahaan(8);
                                    password = inp.nextLine();
                                    app.daftarAccPerusahaan(9);
                                    String pass = inp.nextLine();
                                    Perusahaan per = new Perusahaan(perusahaanList.size()-1, nmPerusahaan, noTelp, jenis, kat, karyawan, nama, email, pass);
                                    perusahaanList.add(per);
                                    System.out.println("Berhasil. Silahkan Login!");
                                    String msk = inp.nextLine();
                                    break;
                                default : 
                                    System.out.println("Pilihan Tidak Ada!");
                                    in = inp.nextLine();
                                    break;
                            }
                        }while(exit == false);
                        break;
                    case 3 : // Menu Pencari Kerja atau Pelamar
                        boolean kluar = false;
                        do{
                            app.pencariKerjaMenu();
                            try{
                                n = input.nextInt();
                                switch(n){
                                    case 0 :
                                        kluar = true;
                                        break;
                                    case 1 : // Login Pelamar
                                        app.login(1);
                                        String email = inp.nextLine();
                                        app.login(2);
                                        String password = inp.nextLine();
                                        if(pelamarList.size() == 0 ){
                                            System.out.println("Anda belum terdaftar"); 
                                            break;
                                        }else{
                                            int i = 0;
                                            boolean find = false;
                                            while (find != true) {
                                                if (pelamarList.get(i).getEmail().equals(email) && pelamarList.get(i).getPassword().equals(password)) {
                                                    find = true;
                                                } else {
                                                    i++;
                                                }
                                            }
                                            if(find==true){
                                                System.out.println("Selamat Datang " + pelamarList.get(i).getNama());
                                                System.out.println("=================================");
                                                boolean pilih = false;
                                                do{
                                                    app.pelamarMenu();
                                                    try{
                                                        int pilihan = input.nextInt();
                                                        switch(pilihan){
                                                            case 0 :
                                                                System.out.println("Apakah anda yakin akan keluar?");
                                                                System.out.print("Pilihan (Ya/Tidak) : ");
                                                                String inpt = inp.nextLine();
                                                                if(inpt.equals("Ya") || inpt.equals("ya")){
                                                                    pilih = true;
                                                                }else{
                                                                    inpt = inp.nextLine();
                                                                }
                                                                break;
                                                            case 1 : // Daftar Lamaran
                                                                if(perusahaanList.isEmpty()){
                                                                    System.out.println("Tidak Ada Perusahaan yang Memberi Lowongan!");
                                                                }else{
                                                                    int jmlP = perusahaanList.size();
                                                                    for (int j = 0; j <= jmlP-1; j++) {
                                                                        System.out.print("Perusahaan : "+perusahaanList.get(j).getNmPerusahaan());
                                                                        if(perusahaanList.get(j).getDaftarLowongan()==null){
                                                                            System.out.println("Perusahaan ini tidak menyediakan lowongan!");
                                                                        }else{
                                                                            int jmlL = perusahaanList.get(i).getDaftarLowongan().size();
                                                                            for (int k = 0; k <= jmlL-1; k++) {
                                                                                System.out.println("Lowongan ke-" + (k+1));
                                                                                System.out.println("\t Deadline : " + dateFormat.format(perusahaanList.get(j).getdaftarLowongan(k).getDeadline()) + "\n");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                System.out.println("Daftar yang di Lamaran : ");
                                                                System.out.println("Daftar Lamaran di Terima : ");
                                                                System.out.println("Apakah anda akan melamar pekerjaan?");
                                                                System.out.print("Masukkan pilihan : ");
                                                                String q = inp.nextLine();
                                                                break;
                                                            case 2 :    // Profil Pelamar memunculkan detail (editable)
                                                                boolean sts = false;
                                                                do{
                                                                    app.pelamarProfil();
                                                                    int lh = input.nextInt();
                                                                    switch(lh){
                                                                        case 0 :
                                                                            sts = true;
                                                                            break;
                                                                        case 1 : // Gelar
                                                                            System.out.print("Banyak Gelar : ");
                                                                            n = input.nextInt();
                                                                            for (int j = 0; j < n; j++) {
                                                                                System.out.println("Gelar ke-"+(j+1));
                                                                                app.pelamarGelar(1);
                                                                                String nama = inp.nextLine();
                                                                                app.pelamarGelar(2);
                                                                                int msk = input.nextInt();
                                                                                app.pelamarGelar(3);
                                                                                int klr = input.nextInt();
                                                                                app.pelamarGelar(4);
                                                                                String institusi = inp.nextLine();
                                                                                app.pelamarGelar(5);
                                                                                String ipk = inp.nextLine();
                                                                                try{
                                                                                    double ip = Double.parseDouble(ipk);
                                                                                    Gelar g = new Gelar(nama, msk, klr, institusi, ip);
                                                                                    gelar.add(g);
                                                                                    System.out.println("Berhasil!");
                                                                                }catch(Exception e){
                                                                                    System.out.println("Tidak dapat diinputkan");
                                                                                }
                                                                                q = inp.nextLine();
                                                                            }
                                                                            break;
                                                                        case 2 : // Bahasa
                                                                            System.out.print("Banyak Bahasa : ");
                                                                            n = input.nextInt();
                                                                            for (int j = 0; j < n; j++) {
                                                                                System.out.print("Bahasa ke-"+(j+1)+" = ");
                                                                                String nmBhs = inp.nextLine();
                                                                                bahasa.add(nmBhs);
                                                                                System.out.println("Berhasil");
                                                                            }
                                                                            q = inp.nextLine();
                                                                            break;
                                                                        case 3 : // Skill
                                                                            System.out.print("Banyak Keahlian : ");
                                                                            n = input.nextInt();
                                                                            for (int j = 0; j < n; j++) {
                                                                                System.out.print("Keahlian ke-"+(j+1)+" = ");
                                                                                String nmKeahlian = inp.nextLine();
                                                                                skill.add(nmKeahlian);
                                                                                System.out.println("Berhasil");
                                                                            }
                                                                            q = inp.nextLine();
                                                                            break;
                                                                        case 4 : // Pengalman
                                                                            System.out.print("Banyak Pengalaman Kerja : ");
                                                                            n = input.nextInt();
                                                                            for (int j = 0; j < n; j++) {
                                                                                System.out.println("Pengalaman ke-"+(j+1));
                                                                                app.pelamarPengalaman(1);
                                                                                String nama = inp.nextLine();
                                                                                app.pelamarPengalaman(2);
                                                                                int msk = input.nextInt();
                                                                                app.pelamarPengalaman(3);
                                                                                int klr = input.nextInt();
                                                                                app.pelamarPengalaman(4);
                                                                                String divisi = inp.nextLine();
                                                                                app.pelamarPengalaman(5);
                                                                                String kota = inp.nextLine();
                                                                                app.pelamarPengalaman(6);
                                                                                String prov = inp.nextLine();
                                                                                try{
                                                                                    Pengalaman pl = new Pengalaman(nama, msk, klr, divisi, kota, prov);
                                                                                    pengalaman.add(pl);
                                                                                    System.out.println("Berhasil");
                                                                                }catch(Exception e){
                                                                                    System.out.println("Data tidak dapat diinputkan");
                                                                                }
                                                                                q = inp.nextLine();
                                                                            }
                                                                            break;
                                                                        case 5 :
                                                                            System.out.println("Pengaturan / Profil");
                                                                            System.out.println("Nama          : "+((pelamarList.get(i).getNama() == null) ? "N/A" : pelamarList.get(i).getNama()));
                                                                            System.out.println("Email         : "+((pelamarList.get(i).getEmail() == null) ? "N/A" : pelamarList.get(i).getEmail()));
                                                                            System.out.println("Jenis Kelamin : "+((pelamarList.get(i).getJk()== null) ? "N/A" : pelamarList.get(i).getJk()));
                                                                            System.out.println("Tempat Lahir  : "+((pelamarList.get(i).getTempatLahir()== null) ? "N/A" : pelamarList.get(i).getTempatLahir()));
                                                                            System.out.println("Tanggal Lahir : "+((pelamarList.get(i).getTglLahir()== null) ? "N/A" : dateFormat.format(pelamarList.get(i).getTglLahir())));
                                                                            System.out.println("No Telp       : "+((pelamarList.get(i).getNoTelp()== null) ? "N/A" : pelamarList.get(i).getNoTelp()));
                                                                            System.out.println("Apakah anda akan mengubah ?");
                                                                            System.out.println("Pilihan (Ya/Tidak) : ");
                                                                            inpt = inp.nextLine();
                                                                            if(inpt.equals("Ya") || inpt.equals("ya")){
                                                                                System.out.println("Isi data secara lengkap!");
                                                                                app.pelamarProfil(1);
                                                                                String nama = inp.nextLine();
                                                                                app.pelamarProfil(2);
                                                                                email = inp.nextLine();
                                                                                app.pelamarProfil(3);
                                                                                String jk = inp.nextLine();
                                                                                app.pelamarProfil(4);
                                                                                String tmpt = inp.nextLine();
                                                                                app.pelamarProfil(5);
                                                                                String tgl = inp.nextLine();
                                                                                try {
                                                                                    date2 = dateFormat.parse(tgl);
                                                                                } catch (ParseException e) {
                                                                                    e.printStackTrace();
                                                                                }
                                                                                app.pelamarProfil(6);
                                                                                String notelp = inp.nextLine();
                                                                                pelamarList.get(i).setNama(nama);
                                                                                pelamarList.get(i).setEmail(email);
                                                                                pelamarList.get(i).setJk(jk);
                                                                                pelamarList.get(i).setTempatLahir(tmpt);
                                                                                pelamarList.get(i).setTglLahir(date2);
                                                                                pelamarList.get(i).setNoTelp(notelp);
                                                                                System.out.println("Data berhasil di ubah!");
                                                                            }
                                                                            q = inp.nextLine();
                                                                            break;
                                                                        case 6 : //Buat berkas
                                                                            if(gelar.isEmpty() || bahasa.isEmpty()||skill.isEmpty()|| pengalaman.isEmpty()){
                                                                                System.out.println("Isi gelar, bahasa, keahlian dan pengalaman secara lengkap!");
                                                                            }else if(pelamarList.get(i).getB().getIdBerkas()==1){
                                                                                pelamarList.get(i).getB().getBahasa().clear();
                                                                                pelamarList.get(i).getB().getGelar().clear();
                                                                                pelamarList.get(i).getB().getPengalamanKerja().clear();
                                                                                pelamarList.get(i).getB().getSkill().clear();
                                                                                try{
                                                                                    pelamarList.get(i).createBerkas(1, gelar, skill, bahasa, pengalaman);
                                                                                    System.out.println("Berhasil");
                                                                                }catch(Exception e){
                                                                                    System.out.println("Berkas tidak dapat di buat");
                                                                                }
                                                                            }else{
                                                                                try{
                                                                                    pelamarList.get(i).createBerkas(1, gelar, skill, bahasa, pengalaman);
                                                                                    System.out.println("Berhasil");
                                                                                }catch(Exception e){
                                                                                    System.out.println("Berkas tidak dapat di buat");
                                                                                }
                                                                            }
                                                                            q = inp.nextLine();
                                                                            break;
                                                                    }
                                                                }while(sts == false);
                                                                break;
                                                            case 3 :    // Setting Akun Pelamar memunculkan nama dan email (editable)
                                                                System.out.println("Pengaturan / Setting");
                                                                System.out.println("Nama          : "+((pelamarList.get(i).getNama() == null) ? "N/A" : pelamarList.get(i).getNama()));
                                                                System.out.println("Email         : "+((pelamarList.get(i).getEmail() == null) ? "N/A" : pelamarList.get(i).getEmail()));
                                                                System.out.println("Apakah anda akan mengubah ?");
                                                                System.out.println("Pilihan (Ya/Tidak) : ");
                                                                inpt = inp.nextLine();
                                                                if(inpt.equals("Ya") || inpt.equals("ya")){
                                                                    System.out.println("Isi data secara lengkap!");
                                                                    app.pelamarProfil(1);
                                                                    String nama = inp.nextLine();
                                                                    app.pelamarProfil(2);
                                                                    email = inp.nextLine();
                                                                    pelamarList.get(i).setNama(nama);
                                                                    pelamarList.get(i).setEmail(email);
                                                                }
                                                                q = inp.nextLine();
                                                                break;
                                                            case 4 : //Lihat Berkas masih ada yg kurang
                                                                System.out.println("Berkas kamu");
                                                                if(pelamarList.get(i).getB().getGelar() == null|| pelamarList.get(i).getB().getSkill() == null || pelamarList.get(i).getB().getBahasa() == null || pelamarList.get(i).getB().getPengalamanKerja()== null){
                                                                    System.out.println("Anda belum selesai mengisi berkas");
                                                                }else{
                                                                    for (int j = 0; j < pelamarList.get(i).getB().getGelar().size(); j++) {
                                                                        System.out.println("Gelar " + (j+1));
                                                                        System.out.println("========");
                                                                        System.out.println("\t Nama Gelar  : "+pelamarList.get(i).getB().getGelar().get(j).getNamaGelar());
                                                                        System.out.println("\t Tahun Masuk : "+pelamarList.get(i).getB().getGelar().get(j).getThnMasuk());
                                                                        System.out.println("\t Tahun Lulus : "+pelamarList.get(i).getB().getGelar().get(j).getThnKeluar());
                                                                        System.out.println("\t Institusi   : "+pelamarList.get(i).getB().getGelar().get(j).getInstitusi());
                                                                        System.out.println("\t IPK         : "+pelamarList.get(i).getB().getGelar().get(j).getIpk());
                                                                    }
                                                                    System.out.println("Keahlian");
                                                                    System.out.println("========");
                                                                    for (int j = 0; j < pelamarList.get(i).getB().getSkill().size(); j++) {
                                                                        System.out.println("\t "+pelamarList.get(i).getB().getSkill().get(j));
                                                                    }
                                                                    System.out.println("Bahasa");
                                                                    System.out.println("======");
                                                                    for (int j = 0; j < pelamarList.get(i).getB().getBahasa().size(); j++) {
                                                                        System.out.println("\t "+pelamarList.get(i).getB().getBahasa().get(j));
                                                                    }
                                                                    for (int j = 0; j < pelamarList.get(i).getB().getPengalamanKerja().size(); j++) {
                                                                        System.out.println("Pengalaman Kerja "+(j+1));
                                                                        System.out.println("================");
                                                                        System.out.println("\t Pekerjaan    : "+pelamarList.get(i).getB().getPengalamanKerja().get(j).getJob());
                                                                        System.out.println("\t Tahun Masuk  : "+pelamarList.get(i).getB().getPengalamanKerja().get(j).getThnMasuk());
                                                                        System.out.println("\t Tahun Keluar : "+pelamarList.get(i).getB().getPengalamanKerja().get(j).getThnKeluar());
                                                                        System.out.println("\t Divisi       : "+pelamarList.get(i).getB().getPengalamanKerja().get(j).getDivisi());
                                                                        System.out.println("\t Kota         : "+pelamarList.get(i).getB().getPengalamanKerja().get(j).getKota());
                                                                        System.out.println("\t Provinsi     : "+pelamarList.get(i).getB().getPengalamanKerja().get(j).getProv());
                                                                    }
                                                                }
                                                                q = inp.nextLine();
                                                                break;
                                                            default : 
                                                                System.out.println("Angka yang Anda Masukkan Salah!");
                                                                q = inp.nextLine();
                                                                break;
                                                        }
                                                    }catch(Exception e){
                                                        System.out.println("Ada Kesalahan Input");
                                                        in = inp.nextLine();
                                                    }
                                                }while(pilih == false);
                                            }else{
                                                System.out.println("Email dan Password Salah!");
                                                in = inp.nextLine();
                                            }
                                        }
                                        break;
                                    case 2 :    // Daftar Akun Pelamar
                                        app.daftarAccPelamar(1);
                                        String nama = inp.nextLine();
                                        app.daftarAccPelamar(2);
                                        email = inp.nextLine();
                                        app.daftarAccPelamar(3);
                                        password = inp.nextLine();
                                        app.daftarAccPelamar(4);
                                        String pass = inp.nextLine();
                                        Pelamar pe = new Pelamar(pelamarList.size(),nama, email, password);
                                        pelamarList.add(pe);
                                        System.out.println("Berhasil. Silahkan Login!");
                                        in = inp.nextLine();
                                        break;
                                    default : 
                                        System.out.println("Anda salah memasukkan angka !");
                                        in = inp.nextLine();
                                        break;
                                }
                            }catch(Exception e){
                                System.out.println("Terdapat Kesalahan Input!");
                            }
                        }while(kluar == false);
                        break;
                    case 4 : // Daftar Akun
                        boolean status = false;
                        do{
                            app.daftarMenu();
                            int msk = input.nextInt();
                            switch (msk){
                                case 0 :
                                    status = true;
                                    break;
                                case 1 :
                                    app.daftarAccPelamar(1);
                                    String nama = inp.nextLine();
                                    app.daftarAccPelamar(2);
                                    String email = inp.nextLine();
                                    app.daftarAccPelamar(3);
                                    String password = inp.nextLine();
                                    app.daftarAccPelamar(4);
                                    String pass = inp.nextLine();
                                    Pelamar pe = new Pelamar(pelamarList.size(),nama, email, password);
                                    pelamarList.add(pe);
                                    System.out.println("Berhasil. Silahkan Login!");
                                    in = inp.nextLine();
                                    break;
                                case 2 : 
                                    app.daftarAccPerusahaan(1);
                                    String nmPerusahaan = inp.nextLine();
                                    app.daftarAccPerusahaan(2);
                                    String noTelp = inp.nextLine();
                                    app.daftarAccPerusahaan(3);
                                    String jenis = inp.nextLine();
                                    app.daftarAccPerusahaan(4);
                                    String kat = inp.nextLine();
                                    app.daftarAccPerusahaan(5);
                                    int karyawan = input.nextInt();
                                    app.daftarAccPerusahaan(6);
                                    nama = inp.nextLine();
                                    app.daftarAccPerusahaan(7);
                                    email = inp.nextLine();
                                    app.daftarAccPerusahaan(8);
                                    password = inp.nextLine();
                                    app.daftarAccPerusahaan(9);
                                    pass = inp.nextLine();
                                    Perusahaan per = new Perusahaan(perusahaanList.size()-1, nmPerusahaan, noTelp, jenis, kat, karyawan, nama, email, pass);
                                    perusahaanList.add(per);
                                    System.out.println("Berhasil. Silahkan Login!");
                                    in = inp.nextLine();
                                    break;
                                default :
                                    System.out.println("Terjadi kesalahan");
                                    in = inp.nextLine();
                                    break;
                            }
                            
                        }while(status == false);
                        String pt = inp.nextLine();
                        break;
                    default :
                        System.out.println("Pilihan Tidak Ada!");
                        break;
                }
            }catch(Exception e){
                System.out.println("Input Error, restart program.");
            }
        }while(keluar == false);
    }
    
}
