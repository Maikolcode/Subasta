/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sub.subasta.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sub.subasta.entity.Moneda;

/**
 *
 * @author ROOT
 */
@Stateless
public class MonedaFacade extends AbstractFacade<Moneda> implements MonedaFacadeLocal {

    @PersistenceContext(unitName = "SubastaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MonedaFacade() {
        super(Moneda.class);
    }
    
}
