package com.ceiba.reserva.servicio;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.reserva.entidad.Reserva;
import com.ceiba.reserva.puerto.RepositorioReserva;

public class ServicioActualizar {

    private final RepositorioReserva repositorioReserva;

    public ServicioActualizar(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(Reserva reserva){
        ValidadorArgumento.validarObligatorio(reserva, "No existe una reserva para actualizar");
        reserva.actualizar(reserva);
        repositorioReserva.actualizarFecha(reserva);
    }
}
