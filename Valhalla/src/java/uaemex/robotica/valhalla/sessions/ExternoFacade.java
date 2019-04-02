/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uaemex.robotica.valhalla.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uaemex.robotica.valhalla.entities.Externo;

/**
 *
 * @author zeroxcharlie
 */
@Stateless
public class ExternoFacade extends AbstractFacade<Externo> {

    @PersistenceContext(unitName = "ValhallaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExternoFacade() {
        super(Externo.class);
    }
    
}
