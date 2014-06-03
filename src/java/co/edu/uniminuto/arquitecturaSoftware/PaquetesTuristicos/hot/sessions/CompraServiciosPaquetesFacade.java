/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.sessions;

import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.CompraServiciosPaquetes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cristian
 */
@Stateless
public class CompraServiciosPaquetesFacade extends AbstractFacade<CompraServiciosPaquetes> {
    @PersistenceContext(unitName = "PaquetesTuristicosMTCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompraServiciosPaquetesFacade() {
        super(CompraServiciosPaquetes.class);
    }
    
}
