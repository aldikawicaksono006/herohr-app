/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aldika W
 */
public class BerkasLamaran {
    // Deklarasi Variable
    private int idBerkas;
    private List<Gelar> gelar = new ArrayList<>();
    private List<String> skill = new ArrayList<>();
    private List<String> bahasa = new ArrayList<>();
    private List<Pengalaman> pengalamanKerja = new ArrayList<>();
    
    // Getter and Setter

    public int getIdBerkas() {
        return idBerkas;
    }

    public void setIdBerkas(int idBerkas) {
        this.idBerkas = idBerkas;
    }

    public List<Gelar> getGelar() {
        if(gelar.isEmpty()){
            return null;
        }else{
            return gelar;
        }
    }

    public void setGelar(List<Gelar> gelar) {
        this.gelar = gelar;
    }

    public List<String> getSkill() {
        if(skill.isEmpty()){
            return null;
        }else{
            return skill;
        }
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
    }

    public List<String> getBahasa() {
        if(bahasa.isEmpty()){
            return null;
        }else{
            return bahasa;
        }
    }

    public void setBahasa(List<String> bahasa) {
        this.bahasa = bahasa;
    }

    public List<Pengalaman> getPengalamanKerja() {
        if(pengalamanKerja.isEmpty()){
            return null;
        }else{
            return pengalamanKerja;
        }
    }

    public void setPengalamanKerja(List<Pengalaman> pengalamanKerja) {
        this.pengalamanKerja = pengalamanKerja;
    }
    
   
    // Method

    @Override
    public String toString() {
        return "BerkasLamaran{" + "idBerkas=" + idBerkas + ", gelar=" + gelar + ", skill=" + skill + ", bahasa=" + bahasa + ", pengalamanKerja=" + pengalamanKerja + '}';
    }
    
    public void addGelar(Gelar g){
        gelar.add(g);
    }
    
    public void addPengalaman(Pengalaman p){
        pengalamanKerja.add(p);
    }
    
    public void addSkill(String s){
        skill.add(s);
    }
    
    public void addBahasa(String b){
        bahasa.add(b);
    }

    void addSkill(List<String> skill) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
