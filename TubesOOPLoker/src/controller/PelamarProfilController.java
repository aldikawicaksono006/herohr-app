package controller;

import model.Aplikasi;
import model.Pelamar;
import view.Homepage;
import view.Loginpage;
import view.PelamarProfilpage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aldika W
 */
public class PelamarProfilController  implements ActionListener {
    
    private PelamarProfilpage view;
    private Aplikasi model;
    private Pelamar pelamar;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public PelamarProfilController(Aplikasi model, Pelamar pelamar) {
        view = new PelamarProfilpage();
        view.setVisible(true);
        this.model = model;
        this.pelamar = pelamar;
    }

    @Override
    public void actionPerformed(ActionEvent ec) {
        Object klik = ec.getSource();
        Date tgl = null;
       
    }
}
