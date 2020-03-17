package edu.educacionit.repository;

import edu.educacionit.model.Ticket;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SQLMasJSON implements IGuardador {
    private GuardadorEnJson guardadorEnJson;
    private GuardadorEnMysql guardadorEnMySQL;

    public SQLMasJSON(GuardadorEnJson guardadorEnJson, GuardadorEnMysql guardadorEnMySQL) {
        this.guardadorEnJson = guardadorEnJson;
        this.guardadorEnMySQL = guardadorEnMySQL;
    }
    
    @Override
    public void guardar(Ticket t) {
        try {
            guardadorEnJson.guardar(t);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        
        try {
            guardadorEnMySQL.guardar(t);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
