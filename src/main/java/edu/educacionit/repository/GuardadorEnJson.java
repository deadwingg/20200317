package edu.educacionit.repository;

import com.google.gson.Gson;
import edu.educacionit.model.Ticket;
import java.io.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class GuardadorEnJson implements IGuardador{
    @Value("${patharchivos}")
    private String pathArchivos;
    
    public void guardar(Ticket t) {
        Gson gson = new Gson();
        String ticketJson = gson.toJson(t);        
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
}
