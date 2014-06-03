/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.sessions;

import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.TipoPersona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cristian
 */
@Stateless
public class TipoPersonaFacade extends AbstractFacade<TipoPersona> {
    @PersistenceContext(unitName = "PaquetesTuristicosMTCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPersonaFacade() {
        super(TipoPersona.class);
    }
    
}
