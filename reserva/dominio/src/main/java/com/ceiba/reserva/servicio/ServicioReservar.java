package com.ceiba.reserva.servicio;

import com.ceiba.reserva.entidad.Reserva;
import com.ceiba.reserva.puerto.RepositorioReserva;

public class ServicioReservar {

    private final RepositorioReserva repositorioReserva;

    public ServicioReservar(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public Long ejecutar(Reserva reservaParametro) {
        var reserva = Reserva.crear(reservaParametro);
        return repositorioReserva.guardarReserva(reserva);
    }
}
