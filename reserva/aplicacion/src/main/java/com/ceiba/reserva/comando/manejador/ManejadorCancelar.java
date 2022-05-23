package com.ceiba.reserva.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.reserva.comando.ComandoCancelar;
import com.ceiba.reserva.puerto.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioCancelar;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCancelar implements ManejadorComando<ComandoCancelar> {

    private final ServicioCancelar servicioCancelar;
    private final RepositorioReserva repositorioReserva;

    public ManejadorCancelar(ServicioCancelar servicioCancelar, RepositorioReserva repositorioReserva) {
        this.servicioCancelar = servicioCancelar;
        this.repositorioReserva = repositorioReserva;
    }

    @Override
    public void ejecutar(ComandoCancelar comandoCancelar) {
        servicioCancelar.ejecutar(repositorioReserva.obtenerReservaPorId(comandoCancelar.getIdReserva()));
    }
}
