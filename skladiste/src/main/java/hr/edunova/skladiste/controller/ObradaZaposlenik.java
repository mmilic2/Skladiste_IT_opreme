/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.skladiste.controller;

import hr.edunova.skladiste.model.Zaposlenik;
import hr.edunova.skladiste.util.EdunovaException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author marko
 */
public class ObradaZaposlenik extends Obrada<Zaposlenik> {

    public ObradaZaposlenik() {
        super();
    }

    public ObradaZaposlenik(Zaposlenik entitet) {
        super(entitet);
    }

    public Zaposlenik autoriziraj(String email, String lozinka) {

        List<Zaposlenik> lista = session.createQuery("from Zaposlenik z "
                + " where z.email=:email")
                .setParameter("email", email).list();

        if (lista == null || lista.isEmpty()) {
            return null;
        }

        Zaposlenik o = lista.get(0);

        if (o == null) {
            return null;
        }

        return BCrypt.checkpw(lozinka, o.getLozinka()) ? o : null;
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
    public List<Zaposlenik> getPodaci() {
        return session.createQuery("from Zaposlenik").list();
    }

    @Override
    protected void nakonSpremanja() {

    }

}
