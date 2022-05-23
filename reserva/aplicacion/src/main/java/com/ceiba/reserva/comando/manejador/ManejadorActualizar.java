package com.ceiba.reserva.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.reserva.comando.ComandoActualizar;
import com.ceiba.reserva.comando.fabrica.FabricaReserva;
import com.ceiba.reserva.servicio.ServicioActualizar;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizar implements ManejadorComando<ComandoActualizar> {

    private final ServicioActualizar servicioActualizar;

    private final FabricaReserva fabricaReserva;


    public ManejadorActualizar(ServicioActualizar servicioActualizar, FabricaReserva fabricaReserva) {
        this.servicioActualizar = servicioActualizar;
        this.fabricaReserva = fabricaReserva;
    }

    @Override
    public void ejecutar(ComandoActualizar comandoActualizar) {
        servicioActualizar.ejecutar(fabricaReserva.crear(comandoActualizar));
    }
}
