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
import hr.edunova.skladiste.model.ProizvodNarudzba;
import hr.edunova.skladiste.model.Zaposlenik;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author marko
 */
public class Pomocno {

    public static Zaposlenik LOGIRAN;
    private final static DecimalFormat df = df();

    public static Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static String getNazivAplikacije() {
        return "Skladiste";
    }

    public static String getFormatCijelogBroja(long i) {
        //https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html
        DecimalFormat dfCijeliBroj = new DecimalFormat("#");
        return dfCijeliBroj.format(i);
    }

    public static int getCijeliBrojIzStringa(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }

    public static String getFormatDecimalniBroj(BigDecimal b) {

        return df.format(b);
    }

    public static BigDecimal getDecimalniBrojIzStringa(String s) {
        try {
            return new BigDecimal(df.parse(s).doubleValue());
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }

    }

    private static DecimalFormat df() {
        NumberFormat nf = NumberFormat.
                getNumberInstance(new Locale("hr", "HR"));
        DecimalFormat dfl = (DecimalFormat) nf;
        dfl.applyPattern("#,###.00");
        return dfl;
    }

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

        Proizvod p2 = new Proizvod();
        p2.setAdresa("Negdje u Americi");
        p2.setDobavljac(d);
        p2.setEmail("proizvod@email.com");
        p2.setNaziv("Intel");
        p2.setCijena(new BigDecimal(2100.00));
        p2.setKolicina(3);
        p2.setKontakt("921313");

        obradaProizvod = new ObradaProizvod(p2);

        try {
            obradaProizvod.create(p2);
        } catch (EdunovaException ex) {
            Logger.getLogger(Pomocno.class.getName()).log(Level.SEVERE, null, ex);
        }

        Narudzba n = new Narudzba();
        n.setDatum(new Date());
        n.setZaposlenik(z);
        n.setSifra(1);

        ProizvodNarudzba pn = new ProizvodNarudzba();
        pn.setNarudzba(n);
        pn.setProizvod(p);
        pn.setCijena(new BigDecimal(2000.20));
        pn.setKolicina(2);

        n.getStavke().add(pn);

        pn = new ProizvodNarudzba();
        pn.setNarudzba(n);
        pn.setProizvod(p2);
        pn.setCijena(new BigDecimal(2300));
        pn.setKolicina(4);
        n.getStavke().add(pn);
        ObradaNarudzba obradaNarudzba = new ObradaNarudzba(n);

        try {
            obradaNarudzba.create();
        } catch (EdunovaException ex) {
            Logger.getLogger(Pomocno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
