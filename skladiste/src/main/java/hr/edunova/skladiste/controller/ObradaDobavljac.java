/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.skladiste.controller;

import hr.edunova.skladiste.model.Dobavljac;
import hr.edunova.skladiste.util.EdunovaException;
import java.util.List;

/**
 *
 * @author marko
 */
public class ObradaDobavljac extends Obrada<Dobavljac>{

    public ObradaDobavljac() {
        super();
    }

    public ObradaDobavljac(Dobavljac entitet){
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
    public List<Dobavljac> getPodaci() {
        return session.createQuery("from Dobavljac").list();
    }

    @Override
    protected void nakonSpremanja() {
        
    }
    
}
