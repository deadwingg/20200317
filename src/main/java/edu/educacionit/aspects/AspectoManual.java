package edu.educacionit.aspects;

import com.google.gson.Gson;
import edu.educacionit.repository.IGuardador;
import edu.educacionit.service.Evaluador;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;

@Component
public class AspectoManual {
    private Evaluador evaluador;
    
    @Value("${pathregistroactividad}")
    private String pathRegistroActividad;
    
    public AspectoManual(Evaluador evaluador) {
        System.out.println("Chequeando si llama al constructor");
        System.out.println(evaluador);
        this.evaluador = evaluador;
    }
    public void evaluar (TipoClima clima, DatosVehiculo vehiculo) {
        try {
            Gson gson = new Gson();
            String ticketJson = gson.toJson(vehiculo);        
            
            File f = new File(pathRegistroActividad);
            FileUtils.write(f, clima.name(), "UTF-8", true);
            FileUtils.write(f, System.lineSeparator(), "UTF-8", true);
            FileUtils.write(f, ticketJson, "UTF-8", true);
            FileUtils.write(f, System.lineSeparator(), "UTF-8", true);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        evaluador.evaluar(clima, vehiculo);
    }
}
