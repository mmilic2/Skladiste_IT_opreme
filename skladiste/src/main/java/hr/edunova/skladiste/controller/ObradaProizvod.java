/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.skladiste.controller;

import hr.edunova.skladiste.model.Proizvod;
import hr.edunova.skladiste.util.EdunovaException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author marko
 */
public class ObradaProizvod extends Obrada<Proizvod>{

    public ObradaProizvod() {
        super();
    }

    public ObradaProizvod(Proizvod entitet){
        super(entitet);
    }
    
    
    @Override
    protected void kontrolaCreate() throws EdunovaException {
       
        
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }

    @Override
    public List<Proizvod> getPodaci() {
        return session.createQuery("from Proizvod").list();
    }

    public List<Proizvod> getPodaci(String uvjet){
        return session.createQuery("from Proizvod p "
                + " where p.naziv like :uvjet ")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(20).list();
    }
    
    @Override
    protected void nakonSpremanja() {
        
    }
    
    public void create(Proizvod p) throws EdunovaException{
        super.entitet = p;
        super.create();
    }
    
    public BigDecimal cijenaNakonPdva(BigDecimal p){
        BigDecimal pdv = new BigDecimal("0.25");
        BigDecimal dodatak = new BigDecimal("0.10");
        BigDecimal pdvDio = p.multiply(pdv);
        BigDecimal dodatakNaCijenu = p.multiply(dodatak);
        BigDecimal ukupno = p.add(pdvDio).add(dodatakNaCijenu);
        return ukupno;
        
    }
}
