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
import hr.edunova.skladiste.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marko
 */
public class Start {
    
    public Start(){
        List<Proizvod> lista = new ArrayList<>();
        Proizvod p;
        for(int i=0;i<100;i++){
            p = new Proizvod();
            p.setNaziv("Generirano " + i);
            lista.add(p);
        }
        Narudzba n = new Narudzba();
        n.setProizvodi(lista);
        ObradaNarudzba za = new ObradaNarudzba();
        
        try {
            za.create();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        new Start();
    }
}
