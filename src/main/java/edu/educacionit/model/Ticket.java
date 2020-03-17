package edu.educacionit.model;

import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;
import sensorvelocidad.TipoVehiculo;

public class Ticket {
    public String idTicket;
    public Long fechaYHora;
    public String patente;
    public String tipoVehiculo;
    public Integer velocidadMedida;
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
