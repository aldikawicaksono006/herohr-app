package controller;

import model.Aplikasi;
import view.Homepage;
import view.Loginpage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.sun.javafx.css.CalculatedValue;
import javax.swing.Icon;

/**
 *
 * @author Aldika W
 */
public class HomeController {
    private Aplikasi model;
    private Homepage view;
    
    public HomeController(Homepage view, Aplikasi model){
        this.view = view;
        this.model = model;
        this.view.addListencari(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }        
        });
        this.view.addListenPelamar(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                Loginpage viewLogin = new Loginpage();
                viewLogin.setVisible(true);
            }
        });
        this.view.addListenPerusahaan(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                Loginpage viewLogin = new Loginpage();
                viewLogin.setVisible(true);
            }
        });
        this.view.addListenDaftar(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();               
            }
        });
        this.view.addListenClose(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedOption = JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan keluar?", "Informasi", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_OPTION) {
                        System.exit(0);
                        view.dispose();
                }
            }
        });
    }
}
