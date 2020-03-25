/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.skladiste.util;

import hr.edunova.skladiste.controller.ObradaDobavljac;
import hr.edunova.skladiste.controller.ObradaNarudzba;
import hr.edunova.skladiste.controller.ObradaProizvod;
import hr.edunova.skladiste.controller.ObradaZaposlenik;
import hr.edunova.skladiste.model.Dobavljac;
import hr.edunova.skladiste.model.Narudzba;
import hr.edunova.skladiste.model.Proizvod;
import hr.edunova.skladiste.model.Zaposlenik;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author marko
 */
public class Pomocno {

    
    public static Zaposlenik LOGIRAN;
    
    public static void pocetniInsert() {

        Zaposlenik z = new Zaposlenik();
        z.setIme("Marko");
        z.setPrezime("Milić");
        z.setKontakt("091213132");
        z.setEmail("marko.milic@email.com");
        z.setLozinka(BCrypt.hashpw("m", BCrypt.gensalt()));

        ObradaZaposlenik obradaZaposlenik = new ObradaZaposlenik(z);

        try {
            
            obradaZaposlenik.create();

        } catch (EdunovaException ex) {
            Logger.getLogger(Pomocno.class.getName()).log(Level.SEVERE, null, ex);
        }

        Dobavljac d = new Dobavljac();
        d.setAdresa("Adresa");
        d.setEmail("dobavljac@email.com");
        d.setKontakt("0923532");
        d.setNaziv("Centar tehnike");
        
        ObradaDobavljac obradaDobavljac = new ObradaDobavljac(d);
        
        try {
            obradaDobavljac.create();
        } catch (EdunovaException ex) {
            Logger.getLogger(Pomocno.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Proizvod> lista = new ArrayList<>();
        Proizvod p = new Proizvod();
        p.setAdresa("Negdje u Americi");
        p.setDobavljac(d);
        p.setEmail("proizvodjac@email.com");
        p.setNaziv("Amd");
        p.setCijena(new BigDecimal(2000.99));
        p.setKolicina(2);
        p.setKontakt("091413431");
        
        ObradaProizvod obradaProizvod = new ObradaProizvod(p);
        
        try {
            obradaProizvod.create(p);
        } catch (EdunovaException ex) {
            Logger.getLogger(Pomocno.class.getName()).log(Level.SEVERE, null, ex);
        }
        lista.add(p);
        
        Narudzba n = new Narudzba();
        n.setProizvodi(lista);
        n.setDatum(new Date());
        n.setZaposlenik(z);
        
        ObradaNarudzba obradaNarudzba = new ObradaNarudzba(n);
        
        try {
            obradaNarudzba.create();
        } catch (EdunovaException ex) {
            Logger.getLogger(Pomocno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
