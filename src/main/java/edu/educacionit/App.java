package edu.educacionit;

import edu.educacionit.model.Ticket;
import edu.educacionit.repository.GuardadorEnJson;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import sensorclima.TipoClima;
import sensorvelocidad.TipoVehiculo;

@Component
class Z {
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    public void persistir(B b) {
        em.persist(b);
    }
}

@Component
public class App implements CommandLineRunner {
    
    @Autowired
    ApplicationContext ctx;
    
    @Override
    public void run(String... args) throws Exception {
        sensorvelocidad.Sensor sensorvel = 
                new sensorvelocidad.Sensor();
        sensorclima.Sensor sensorclima = 
                new sensorclima.Sensor();
        
        TipoClima tipoClima = sensorclima.sensar();
        System.out.println(tipoClima);

        /*
        Ticket t = new Ticket();
        t.idTicket = UUID.randomUUID().toString();
        t.fechaYHora = System.currentTimeMillis() / 1000;
        t.patente = "A015 5451";
        t.tipoClima = TipoClima.LLUVIAS_MODERADAS.name();
        t.velocidadMedida = 120;
        t.tipoVehiculo = TipoVehiculo.Camion.name();
        
        GuardadorEnJson guardador = ctx.getBean(GuardadorEnJson.class);
        guardador.guardar(t);
        */
        
        // Testear la logica
        
        
        /*
        for (;;) {
            DatosVehiculo dv = sensorvel.sensarVehiculo();
            // Atencion SOLO SE USAN ESTOS TRES CAMPOS
            System.out.println(dv.patente);
            System.out.println(dv.tipoVehiculo);
            System.out.println(dv.velocidadMedida);
            System.out.println("");
            
            B b = new B(UUID.randomUUID().toString(), dv.patente);
            z.persistir(b);
        }
        */
    }
}
