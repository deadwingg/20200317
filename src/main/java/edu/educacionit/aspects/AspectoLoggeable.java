package edu.educacionit.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectoLoggeable {
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
        // tracer.tracear(joinpoint.getThis().toString());
        System.out.println("Antes de ejecutar al metodo ************ FIN");
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
