/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.skladiste.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author marko
 */

@Entity
public class Narudzba extends Entitet{
    
    private Date datum;
    private Integer sifra;
    
    @ManyToOne
    private Zaposlenik zaposlenik;
    
    @OneToMany(mappedBy = "narudzba")
    private List<ProizvodNarudzba> stavke = new ArrayList<>();

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Integer getSifra() {
        return sifra;
    }

    public void setSifra(Integer sifra) {
        this.sifra = sifra;
    }

    public Zaposlenik getZaposlenik() {
        return zaposlenik;
    }

    public void setZaposlenik(Zaposlenik zaposlenik) {
        this.zaposlenik = zaposlenik;
    }

    public List<ProizvodNarudzba> getStavke() {
        return stavke;
    }

    public void setStavke(List<ProizvodNarudzba> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        return sifra.toString();
    }

    
    
    
}
