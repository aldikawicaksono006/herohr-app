/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.List;

/**
 *
 * @author Aldika W
 */
public class Aplikasi {
    // Pendeklarasian variable
    private List<Perusahaan> daftarPerusahaan;
    private List<Pelamar> daftarPelamar;
    
    // Perusahaan
    public void addPerusahaan(Perusahaan prsh){
        daftarPerusahaan.add(prsh);
    }
    
    public List<Perusahaan> getDaftarPerusahaan(){
        return daftarPerusahaan;
    }
    
    public List<Lowongan> getDaftarLowongan(int nlowongan){
        return daftarPerusahaan.get(nlowongan).getDaftarLowongan();
    }
    
    // Pelamar
    public void addPelamar(Pelamar plmr){
        daftarPelamar.add(plmr);
    }

    public Pelamar getDaftarPelamar(int plmr) {
        return daftarPelamar.get(plmr);
    }
    
    public void deletePelamar(int plmr){
        daftarPelamar.remove(plmr);
    }   

    
    // Menu
    public void PerusahaanMenu(){
        System.out.println("Pilihan");
        System.out.println("1. Login");
        System.out.println("2. Daftar Akun Perusahaan");                        
        System.out.println("0. Kembali");
        System.out.print("Masukkan Pilihan : ");
    }
    
    public void perusahaanMainMenu(){
        System.out.println("Pilihan");
        System.out.println("1. Daftar Pelamar");
        System.out.println("2. Lihat Lowongan");
        System.out.println("3. Buat Lowongan");
        System.out.println("4. Hapus Lowongan");
        System.out.println("5. Lihat Berkas Lamaran Masuk");
        System.out.println("6. Lihat Berkas Lamaran Di Terima");
        System.out.println("0. Logout");
        System.out.print("Masukkan Pilihan : ");
    }
    
    public void daftarAccPerusahaan(int pilihan){
        switch (pilihan) {
            case 1:
                System.out.println("Silahkan Mendaftar.");
                System.out.println("==================");
                System.out.print("Nama Perusahaan   : ");
                break;
            case 2:
                System.out.print("No Telp           : ");
                break;
            case 3:
                System.out.print("Jenis             : ");
                break;
            case 4:
                System.out.print("Kategori          : ");
                break;
            case 5:
                System.out.print("Jumlah Karyawan   : ");
                break;
            case 6:
                System.out.print("Nama              : ");
                break;
            case 7:
                System.out.print("Email             : ");
                break;
            case 8:
                System.out.print("Kata Sandi        : ");
                break;
            default:
                System.out.print("Ulangi Kata Sandi : ");
                break;
        } 
    }
    
    public void login(int pilihan){
        if(pilihan == 1){
            System.out.println("Silahkan masukkan kredensial login Anda di bawah ini.");
            System.out.println("=====================================================");
            System.out.print("Email      : ");
        }
        else{
            System.out.print("Kata Sandi : ");
        }
    }
     
    public void pencariKerjaMenu(){
        System.out.println("Pilihan ");
        System.out.println("1. Login");
        System.out.println("2. Daftar Akun Pelamar");
        System.out.println("0. Kembali");
        System.out.print("Masukkan Pilihan : ");
    }
    
    public void daftarAccPelamar(int pilihan){
        switch (pilihan) {
            case 1:
                System.out.println("Silahkan Mendaftar.");
                System.out.println("===================");
                System.out.print("Nama              : ");
                break;
            case 2:
                System.out.print("Email             : ");
                break;
            case 3:
                System.out.print("Kata Sandi        : ");
                break;
            default:
                System.out.print("Ulangi Kata Sandi : ");
                break;
        } 
    }
    
    public void pelamarMenu(){
        System.out.println("Pilihan ");
        System.out.println("1. Daftar Lamaran");
        System.out.println("2. Profil");
        System.out.println("3. Setting");
        System.out.println("4. Lihat Berkas");
        System.out.println("0. Logout");
        System.out.print("Masukkan Pilihan : ");
    }
    
    public void pelamarProfil(){
        System.out.println("Pengaturan / Profil");
        System.out.println("1. Gelar");
        System.out.println("2. Bahasa");
        System.out.println("3. Keahlian");
        System.out.println("4. Pengalaman Kerja");
        System.out.println("5. View Profil");
        System.out.println("6. Buat Berkas");
        System.out.println("0. Kembali");
        System.out.print("Masukkan Pilihan : ");
    }
    
    public void pelamarGelar(int pilihan){
        switch(pilihan){
            case 1 :
                System.out.println("Masukkan data secara benar!");
                System.out.print("Gelar          : ");
                break;
            case 2 :
                System.out.print("Tahun Masuk    : ");
                break;
            case 3 :
                System.out.print("Tahun Lulus    : ");
                break;
            case 4 :
                System.out.print("Nama Institusi : ");
                break;
            case 5 :
                System.out.print("IPK            : ");
                break;
        }
    }
    
    public void pelamarPengalaman(int pilihan){
        switch(pilihan){
            case 1 :
                System.out.print("Nama Pekerjaan : ");
                break;
            case 2 :
                System.out.print("Tahun Masuk    : ");
                break;
            case 3 :
                System.out.print("Tahun Keluar   : ");
                break;
            case 4 :
                System.out.print("Divisi         : ");
                break;
            case 5 :
                System.out.print("Kota           : ");
                break;
            case 6 :
                System.out.print("Provinsi       : ");
                break;
        }
    }
    
    public void pelamarBerkas(){
        System.out.println("Pengaturan / Profil");
        System.out.println("1. Gelar");
        System.out.println("2. Bahasa");
        System.out.println("3. Keahlian");
        System.out.println("4. Pengalaman Kerja");
        System.out.println("5. Buat Lamaran");
        System.out.println("0. Kembali");
        System.out.print("Masukkan Pilihan : ");
    }
    
    public void pelamarSetting(int pilihan){
        switch(pilihan){
            case 1 :
                System.out.println("Pengaturan / Setting");
                System.out.print("Nama         : ");
                break;
            case 2 :
                System.out.print("Alamat Email : ");
                break;
        }
    }
    
    public void pelamarProfil(int pilihan){
        switch(pilihan){
            case 1 : 
                System.out.println("Pengaturan / Profil");
                System.out.print("Nama          : ");
                break;
            case 2 : 
                System.out.print("Email         : ");
                break;
            case 3 : 
                System.out.print("Jenis Kelamin : ");
                break;
            case 4 : 
                System.out.print("Tempat Lahir  : ");
                break;
            case 5 : 
                System.out.print("Tanggal Lahir : ");
                break;
            default : 
                System.out.print("No Telp       : ");
                break;
        }   
    }
    
    public void daftarMenu(){
        System.out.println("Silahkan Pilih Jenis Pendaftaran.");
        System.out.println("1. Pencari Kerja");
        System.out.println("2. Perusahaan");
        System.out.println("0. Kembali");
        System.out.print("Masukkan pilihan : ");
    }
    
    public void mainMenu(){
        System.out.println("Main Menu");
        System.out.println("1. Cari Lowongan");
        System.out.println("2. Perusahaan");
        System.out.println("3. Pencari Kerja");
        System.out.println("4. Daftar Akun");
        System.out.println("0. Keluar");
        System.out.print("Masukkan Pilihan : ");
    }
}


