package controller;

import model.Aplikasi;
import model.Perusahaan;
import view.Loginpage;
import view.PerusahaanSetpage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Aldika W
 */
public class PerusahaanSetController implements ActionListener{
    
    private PerusahaanSetpage view;
    private Aplikasi model;
    private Perusahaan p;

    public PerusahaanSetController(Aplikasi model, Perusahaan p) {
        this.model = model;
        view = new PerusahaanSetpage();
        view.setVisible(true);
        this.p = p;
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object klik = e.getSource();
    }
    
}
