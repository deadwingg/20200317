package edu.educacionit.service;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import edu.educacionit.annotations.Loggeable;
import edu.educacionit.model.Ticket;
import edu.educacionit.repository.GuardadorEnJson;
import edu.educacionit.repository.IGuardador;
import edu.educacionit.repository.SQLMasJSON;
import java.util.UUID;
import org.springframework.stereotype.Component;
import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;
import sensorvelocidad.TipoVehiculo;

@Component
public class Evaluador {
    private static Table <TipoVehiculo, TipoClima, Integer> multas;
    private IGuardador guardador;
    
    static {
        multas = HashBasedTable.create();
        multas.put(TipoVehiculo.Auto, TipoClima.NORMAL, 130);
        multas.put(TipoVehiculo.Auto, TipoClima.LLUVIAS_MODERADAS, 110);
        multas.put(TipoVehiculo.Auto, TipoClima.LLUVIAS_TORRENCIALES, 90);
        
        multas.put(TipoVehiculo.Camion, TipoClima.NORMAL, 90);
        multas.put(TipoVehiculo.Camion, TipoClima.LLUVIAS_MODERADAS, 80);
        multas.put(TipoVehiculo.Camion, TipoClima.LLUVIAS_TORRENCIALES, 90);
        
        multas.put(TipoVehiculo.Moto, TipoClima.NORMAL, 130);
        multas.put(TipoVehiculo.Moto, TipoClima.LLUVIAS_MODERADAS, 110);
        multas.put(TipoVehiculo.Moto, TipoClima.LLUVIAS_TORRENCIALES, 90);
        
        multas.put(TipoVehiculo.Tractor, TipoClima.NORMAL, 60);
        multas.put(TipoVehiculo.Tractor, TipoClima.LLUVIAS_MODERADAS, 60);
        multas.put(TipoVehiculo.Tractor, TipoClima.LLUVIAS_TORRENCIALES, 60);
    }
    
    public Evaluador (IGuardador guardador) {
        this.guardador = guardador;
    }
    
    @Loggeable
    public void evaluar (TipoClima clima, DatosVehiculo vehiculo){
        if (vehiculo.velocidadMedida <= multas.get(vehiculo.tipoVehiculo, clima)) {
            return;
        }
        
        Ticket t = new Ticket();
        t.idTicket = UUID.randomUUID().toString();
        t.fechaYHora = System.currentTimeMillis() / 1000;
        t.patente = vehiculo.patente;
        t.tipoClima = clima.name();
        t.velocidadMedida = vehiculo.velocidadMedida;
        t.tipoVehiculo = vehiculo.tipoVehiculo.name();
        
        guardador.guardar(t);
    }
}
