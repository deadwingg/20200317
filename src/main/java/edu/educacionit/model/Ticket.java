package edu.educacionit.model;

import org.hibernate.annotations.GenericGenerator;
import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;
import sensorvelocidad.TipoVehiculo;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "uuid2"
    )
    public UUID idTicket;
    public Long fechaYHora;
    public String patente;
    public String tipoVehiculo;
    public Integer velocidadMedida;
    public String tipoClima;

    public Ticket() {
    }
    
    public Ticket(Long fechaYHora, String patente, String tipoVehiculo, Integer velocidadMedida, String tipoClima) {
        this.fechaYHora = fechaYHora;
        this.patente = patente;
        this.tipoVehiculo = tipoVehiculo;
        this.velocidadMedida = velocidadMedida;
        this.tipoClima = tipoClima;
    }
}
