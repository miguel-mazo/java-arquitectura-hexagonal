package com.ceiba.reserva.consulta;

import com.ceiba.reserva.entidad.Reserva;
import com.ceiba.reserva.puerto.RepositorioReserva;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarReserva {

    private final RepositorioReserva repositorioReserva;

    public ManejadorConsultarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public Reserva obtenerReservaPorId(Long id){
        return this.repositorioReserva.obtenerReservaPorId(id);
    }

    public List<Reserva> obtenerReservas(){
        return this.repositorioReserva.obtenerReservas();
    }
}
