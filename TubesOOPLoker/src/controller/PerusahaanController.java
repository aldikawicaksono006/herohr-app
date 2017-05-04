package controller;

import model.Aplikasi;
import model.Perusahaan;
import view.Loginpage;
import view.Perusahaanpage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aldika W
 */
public class PerusahaanController implements ActionListener {
    
    private Perusahaanpage view;
    private Aplikasi model;
    private Perusahaan perusahaan;
    
    public PerusahaanController(Aplikasi model, Perusahaan perusahaan){
        this.model = model;
        view = new Perusahaanpage();
        view.setVisible(true);
        this.perusahaan = perusahaan;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object klik = e.getSource(); 
        }
    }

