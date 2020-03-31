/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.skladiste;

import hr.edunova.skladiste.controller.ObradaDobavljac;
import hr.edunova.skladiste.controller.ObradaNarudzba;
import hr.edunova.skladiste.controller.ObradaProizvod;
import hr.edunova.skladiste.controller.ObradaZaposlenik;
import hr.edunova.skladiste.model.Dobavljac;
import hr.edunova.skladiste.model.Narudzba;
import hr.edunova.skladiste.model.Proizvod;
import hr.edunova.skladiste.model.Zaposlenik;
import hr.edunova.skladiste.util.EdunovaException;
import hr.edunova.skladiste.util.HibernateUtil;
import hr.edunova.skladiste.util.Pomocno;
import hr.edunova.skladiste.view.SplashScreen;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marko
 */
public class Start {
    
    public Start(){
       
        //Pomocno.pocetniInsert();
        new SplashScreen().setVisible(true);
        
        
        
        /*List<Proizvod> lista = new ArrayList<>();
        Proizvod p;
        ObradaProizvod op = new ObradaProizvod();
        for(int i=0;i<100;i++){
            p = new Proizvod();
            p.setNaziv("Generirano " + i);
            try {
                op.create(p);
            } catch (EdunovaException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            }
            lista.add(p);
        }
        Narudzba n = new Narudzba();
        n.setProizvodi(lista);
        ObradaNarudzba za = new ObradaNarudzba();
        
        try {
            za.create();
        } catch (Exception e) {
        }*/
        
        
    }
    
    public static void main(String[] args) {
        new Start();
    }
}
