/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uaemex.robotica.valhalla.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uaemex.robotica.valhalla.entities.Prestador;

/**
 *
 * @author zeroxcharlie
 */
@Stateless
public class PrestadorFacade extends AbstractFacade<Prestador> {

    @PersistenceContext(unitName = "ValhallaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrestadorFacade() {
        super(Prestador.class);
    }
    
}
