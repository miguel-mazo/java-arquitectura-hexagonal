package com.ceiba.reserva.puerto;

import com.ceiba.reserva.entidad.Reserva;

import java.util.List;

public interface RepositorioReserva {

    Reserva obtenerReservaPorId(Long id);

    List<Reserva> obtenerReservas();

    Long guardarReserva(Reserva reserva);
}
