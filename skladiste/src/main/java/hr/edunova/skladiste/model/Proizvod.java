/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.skladiste.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author marko
 */
@Entity
public class Proizvod extends Entitet{
    
    
    private String naziv;
    private BigDecimal cijena;
    private Integer kolicina;
    
    @ManyToOne
    private Proizvodjac proizvodjac;
    
    @ManyToOne
    private Dobavljac dobavljac;
    
    @ManyToMany
    private List<Narudzba> narudzbe = new ArrayList<>();

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(Proizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public Dobavljac getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(Dobavljac dobavljac) {
        this.dobavljac = dobavljac;
    }

    public List<Narudzba> getNarudzbe() {
        return narudzbe;
    }

    public void setNarudzbe(List<Narudzba> narudzbe) {
        this.narudzbe = narudzbe;
    }
    
    
    
}
