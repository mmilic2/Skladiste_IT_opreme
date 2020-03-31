/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.skladiste.controller;

import hr.edunova.skladiste.util.EdunovaException;
import hr.edunova.skladiste.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author marko
 */
public abstract class Obrada<T> {
    
    protected T entitet;
    protected Session session;
    protected abstract void kontrolaCreate() throws EdunovaException;
    protected abstract void kontrolaUpdate() throws EdunovaException;
    protected abstract void kontrolaDelete() throws EdunovaException;
    public abstract List<T> getPodaci();
    protected abstract void nakonSpremanja();

    public Obrada() {
        session = HibernateUtil.getSessionFactory().openSession();   
    }
    
    public Obrada(T entitet){
        this();
        this.entitet=entitet;
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    
    public T create() throws EdunovaException{
        kontrolaCreate();
        save();
        nakonSpremanja();
        return entitet;
    }
    
    public void createAll(List<T> lista) throws EdunovaException{
        session.beginTransaction();
        for(T sl: lista){
            this.entitet=sl;
            kontrolaCreate();
            session.save(sl);
            nakonSpremanja();
        }
        session.getTransaction().commit();
    }
    
    public T update() throws EdunovaException{
        kontrolaUpdate();
        save();
        nakonSpremanja();
        return entitet;
    }
    
    public boolean delete() throws EdunovaException{
        kontrolaDelete();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
        return true;
    }

    private void save() {
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
        
    }
}
