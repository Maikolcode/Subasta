/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sub.subasta.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sub.subasta.entity.Subasta;

/**
 *
 * @author ROOT
 */
@Stateless
public class SubastaFacade extends AbstractFacade<Subasta> implements SubastaFacadeLocal {

    @PersistenceContext(unitName = "SubastaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubastaFacade() {
        super(Subasta.class);
    }
    
}
