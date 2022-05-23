package com.ceiba.reserva.comando.fabrica;

import com.ceiba.reserva.comando.ComandoActualizar;
import com.ceiba.reserva.entidad.Reserva;
import com.ceiba.reserva.puerto.RepositorioReserva;
import org.springframework.stereotype.Component;

@Component
public class FabricaReserva {

    private final RepositorioReserva repositorioReserva;

    public FabricaReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public Reserva crear(ComandoActualizar comandoActualizar) {
        Reserva reserva = repositorioReserva.obtenerReservaPorId(comandoActualizar.getId());
        reserva.setFecha_reserva(comandoActualizar.getFecha_reserva());
        return reserva;
    }
}
