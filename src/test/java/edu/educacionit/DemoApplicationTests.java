package edu.educacionit;

import edu.educacionit.repository.IGuardador;
import edu.educacionit.service.Evaluador;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;
import sensorvelocidad.TipoVehiculo;

@SpringBootTest
class DemoApplicationTests {
    @Test
    void CamionLLuviaModerada() {
        // Arrange
        GuardadorStub stub = new GuardadorStub();
        Evaluador evaluador = new Evaluador(stub);
        DatosVehiculo dv = new DatosVehiculo();
        dv.patente = "N/A";
        dv.tipoVehiculo = TipoVehiculo.Camion;
        dv.velocidadMedida = 80;
        // Act
        evaluador.evaluar(TipoClima.LLUVIAS_MODERADAS, dv);
        // Assert
        Assert.isTrue(stub.seLlamo==false, "Cuidado que deberia ser multado!!!!");
    }
    @Test
    public void MotoNormal() {
        // Arrange
        IGuardador guardador = Mockito.mock(IGuardador.class);
        Evaluador evaluador = new Evaluador(guardador);
        DatosVehiculo dv = new DatosVehiculo();
        dv.tipoVehiculo = TipoVehiculo.Moto;
        dv.velocidadMedida = 80;
        // Act
        evaluador.evaluar(TipoClima.NORMAL, dv);
        // Assert
        Mockito.verify(guardador, Mockito.times(0)).guardar(Mockito.any());
    }
}
