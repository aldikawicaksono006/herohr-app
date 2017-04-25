/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Aldika W
 */
public class Lowongan {
     // Deklarasi variable
    private int idLowongan;
    private List<BerkasLamaran> berkasMasuk;
    private List<BerkasLamaran> berkasDiterima;
    private Date deadline;
    
    // Getter and Setter
    public void setIdLowongan(int idLowongan) {
        this.idLowongan = idLowongan;
    }
    
    public int getIdLowongan(){
            return idLowongan;
    }

    public BerkasLamaran getBerkasMasuk(int index) {
        return berkasMasuk.get(index);
    }
    
    public BerkasLamaran getBerkasMasukbyid(int id){
        if (berkasMasuk.equals(id)){
            return berkasMasuk.get(id);
        }
        return null;
    }

    public void setBerkasMasuk(List<BerkasLamaran> berkasMasuk) {
        this.berkasMasuk = berkasMasuk;
    }

    public BerkasLamaran getBerkasDiterima(int id) {
        return berkasDiterima.get(id);
    }

    public List<BerkasLamaran> getBerkasMasuk() {
        if(berkasMasuk.isEmpty()){
            return null;
        }else{
            return berkasMasuk;
        }
    }

    public List<BerkasLamaran> getBerkasDiterima() {
        return berkasDiterima;
    }
    
    public void setBerkasDiterima(List<BerkasLamaran> berkasDiterima) {
        this.berkasDiterima = berkasDiterima;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
    // Method
    public void addBerkas(BerkasLamaran b) {
        berkasMasuk.add(b);
    }
    
    public void removeBerkasMasuk(){
        
    }
        
    public void terimaBerkas(BerkasLamaran b){
        berkasDiterima.add(b);
    }

    @Override
    public String toString() {
        return "Lowongan{" + "idLowongan=" + idLowongan + ", berkasMasuk=" + berkasMasuk + ", berkasDiterima=" + berkasDiterima + ", deadline=" + deadline + '}';
    }
    
    
}
