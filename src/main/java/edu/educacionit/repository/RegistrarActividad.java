package edu.educacionit.repository;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sensorclima.TipoClima;
import sensorvelocidad.TipoVehiculo;

import java.io.File;

@Component
public class RegistrarActividad {
/*


    public void registrar (TipoClima clima, TipoVehiculo vehiculo){
        Gson gson = new Gson();
        String ticketJson = gson.toJson(vehiculo);
        System.out.println(ticketJson);

        String pathArchivo = String.join("", pathArchivos, t.idTicket, ".json");
        System.out.println(pathArchivo);

        File f = new File(pathArchivo);
        try {
            org.apache.commons.io.FileUtils.write(f, ticketJson, "UTF-8", false);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
*/
}
