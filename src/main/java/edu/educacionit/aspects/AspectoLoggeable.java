package edu.educacionit.aspects;

import com.google.gson.Gson;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;

@Component
@Aspect
public class AspectoLoggeable {
    
    @Value("${pathregistroactividad}")
    private String pathRegistroActividad;
    
    public AspectoLoggeable() {
        System.out.println("Constructor aspecto");
    }
    @Before("@annotation(edu.educacionit.annotations.Loggeable)")
    public void antesDeEjecutar(JoinPoint joinpoint) { 
        System.out.println("Antes de ejecutar al metodo ************ INIT ");
        System.out.println(joinpoint.getKind());
        System.out.println(joinpoint.getSignature().getName());
        System.out.println(joinpoint.getSignature().getDeclaringType());
        System.out.println(joinpoint.getSignature().getDeclaringTypeName());
        System.out.println(joinpoint.getThis());
        
        TipoClima clima = (TipoClima)joinpoint.getArgs()[0];
        DatosVehiculo dv = (DatosVehiculo)joinpoint.getArgs()[1];
        grabar(clima, dv);
        System.out.println("Antes de ejecutar al metodo ************ FIN");
    }
    public void grabar (TipoClima clima, DatosVehiculo vehiculo) {
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
    }
    @After("@annotation(edu.educacionit.annotations.Loggeable)")
    public void despuesDeEjecutar(JoinPoint joinpoint) { 
        System.out.println("Luego de ejecutar al metodo ************* INIT");
        System.out.println(joinpoint.getKind());
        System.out.println(joinpoint.getSignature().getName());
        System.out.println(joinpoint.getSignature().getDeclaringType());
        System.out.println(joinpoint.getSignature().getDeclaringTypeName());
        System.out.println(joinpoint.getThis());
        System.out.println("Luego de ejecutar al metodo ************* FIN");
    }            
}
