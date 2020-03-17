package edu.educacionit.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// @Component
// @Aspect
public class AspectoPerformance {
    public AspectoPerformance() {
        System.out.println("Constructor aspecto");
    }
    
    @Around("@annotation(edu.educacionit.annotations.MedicionPerformance)")
    public void encerrar(ProceedingJoinPoint joinPoint) {
        System.out.println("ANTES DE LLAMAR AL METODO ******** A R O U N D");
        try {
            long ms = System.currentTimeMillis();
            joinPoint.proceed();
            long diff = System.currentTimeMillis() - ms;
            System.out.println("Tiempo total en llamar al metodo: " + diff);
        }
        catch (Throwable ex) {
            // tracer.tracear(ex.getMessage());
        }
        System.out.println("DESPUES DE LLAMAR AL METODO ******** A R O U N D ");
    }            
}
