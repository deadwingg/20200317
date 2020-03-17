package edu.educacionit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;
import sensorvelocidad.TipoVehiculo;

@Entity
@Table(name="tickets")
public class Ticket {
    @Id
    @Column(name="idTicket")
    public String idTicket;
    @Column(name="fechaYHora")
    public Long fechaYHora;
    @Column(name="patente")
    public String patente;
    @Column(name="tipoVehiculo")
    public String tipoVehiculo;
    @Column(name="velocidadMedida")
    public Integer velocidadMedida;
    @Column(name="tipoClima")
    public String tipoClima;

    public Ticket() {
    }
    
    public Ticket(String idTicket, Long fechaYHora, String patente, String tipoVehiculo, Integer velocidadMedida, String tipoClima) {
        this.idTicket = idTicket;
        this.fechaYHora = fechaYHora;
        this.patente = patente;
        this.tipoVehiculo = tipoVehiculo;
        this.velocidadMedida = velocidadMedida;
        this.tipoClima = tipoClima;
    }
}
