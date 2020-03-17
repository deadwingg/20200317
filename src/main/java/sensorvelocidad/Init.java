package sensorvelocidad;

import sensorvelocidad.*;

public class Init {
    public static void main(String ...params) {
        for (;;) {
            DatosVehiculo datosVehiculo = new Sensor().sensarVehiculo();
            System.out.println(datosVehiculo);
            System.out.println("-------------------------------");
        }
    }
}
