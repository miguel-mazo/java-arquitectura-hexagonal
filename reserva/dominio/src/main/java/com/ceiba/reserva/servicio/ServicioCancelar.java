package com.ceiba.reserva.servicio;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.reserva.entidad.Reserva;
import com.ceiba.reserva.puerto.RepositorioReserva;

public class ServicioCancelar {

    private final RepositorioReserva repositorioReserva;

    public ServicioCancelar(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(Reserva reserva){
        ValidadorArgumento.validarObligatorio(reserva, "No existe una reserva para cancelar");
        reserva.cancelar();
        repositorioReserva.actualizarEstado(reserva);
    }
}
