package edu.educacionit.repository;

import edu.educacionit.model.Ticket;

public class GuardadorEnMysql implements IGuardador {
    @Override
    public void guardar(Ticket t) {
        System.out.println("Guardando en mysql");
    }
}
