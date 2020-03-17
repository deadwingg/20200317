package edu.educacionit;

import edu.educacionit.model.Ticket;
import edu.educacionit.repository.IGuardador;

public class GuardadorStub implements IGuardador {

    public boolean seLlamo = false;
    
    @Override
    public void guardar(Ticket t) {
        seLlamo = true;
    }
}
