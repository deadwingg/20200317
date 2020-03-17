package edu.educacionit.repository;

import edu.educacionit.model.Ticket;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class GuardadorEnMysql implements IGuardador {
    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional
    public void guardar(Ticket t) {
        em.persist(t);
    }
}
