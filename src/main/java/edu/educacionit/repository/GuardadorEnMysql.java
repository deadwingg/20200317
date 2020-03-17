package edu.educacionit.repository;

import edu.educacionit.model.Ticket;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class GuardadorEnMysql implements IGuardador {
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    public void guardar(Ticket t) {
        em.persist(t);
    }
}
