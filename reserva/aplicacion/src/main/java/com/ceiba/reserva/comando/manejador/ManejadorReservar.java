package com.ceiba.reserva.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.reserva.entidad.Reserva;
import com.ceiba.reserva.servicio.ServicioReservar;
import org.springframework.stereotype.Component;

@Component
public class ManejadorReservar implements ManejadorComandoRespuesta<Reserva, ComandoRespuesta<Long>> {

    private final ServicioReservar servicioReservar;

    public ManejadorReservar(ServicioReservar servicioReservar) {
        this.servicioReservar = servicioReservar;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(Reserva comando) {
        return new ComandoRespuesta<>(servicioReservar
                .ejecutar(comando));
    }
}
