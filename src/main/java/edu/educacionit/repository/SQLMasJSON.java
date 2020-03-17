package edu.educacionit.repository;

import edu.educacionit.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SQLMasJSON implements IGuardador {

    GuardadorEnJson guardadorEnJson;
    GuardadorEnMysql guardadorEnMysql;

    public SQLMasJSON(
            @Autowired GuardadorEnJson guardadorEnJson,
            @Autowired GuardadorEnMysql guardadorEnMysql) {
        this.guardadorEnJson = guardadorEnJson;
        this.guardadorEnMysql = guardadorEnMysql;
    }

    @Override
    public void guardar(Ticket t) {
        try{
            guardadorEnJson.guardar(t);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        try {
            guardadorEnMysql.guardar(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
