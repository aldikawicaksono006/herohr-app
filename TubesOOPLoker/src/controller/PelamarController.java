package controller;

import model.Aplikasi;
import model.BerkasLamaran;
import view.Loginpage;
import view.PelamarDaftarLamaranpage;
import view.PelamarProfilpage;
import view.PelamarSetpage;
import view.Pelamarpage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pelamar;


/**
 *
 * @author Aldika W
 */
public class PelamarController {
    private Pelamarpage view;
    private Aplikasi model;
    
    public PelamarController(Aplikasi model, Pelamar pelamar){
        view = new Pelamarpage();
        view.setVisible(true);
        this.model = model;
        view.setSession("Selamar Datang "+pelamar.getNama());
        this.view.addListendaftar(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                //PelamarDaftarLamaranController LamaranCon = new PelamarDaftarLamaranController(model, pelamar);
            }
        });
        this.view.addListenkeluar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedOption = JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan keluar?", "Informasi", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_OPTION) {
                    view.dispose();
                    Loginpage viewLogin = new Loginpage();
                   //LoginController login = new LoginController(viewLogin, model);
                    viewLogin.setVisible(true);
                }
            }
        });
        this.view.addListenset(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                //PelamarSetController pelamarController = new PelamarSetController(model, pelamar);
            }
        });
        this.view.addListenprofil(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                //PelamarProfilController pelamarCon = new PelamarProfilController(model, pelamar);
            }
        });
        
    }
}
