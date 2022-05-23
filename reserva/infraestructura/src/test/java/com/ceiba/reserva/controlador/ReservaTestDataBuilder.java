package com.ceiba.reserva.controlador;

import com.ceiba.reserva.entidad.EstadoReserva;
import com.ceiba.reserva.entidad.Reserva;

public class ReservaTestDataBuilder {

    private Reserva reserva;

    public ReservaTestDataBuilder() { this.reserva = new Reserva(); }

    public ReservaTestDataBuilder crearPorDefecto(){
        this.reserva.setId(3l);
        this.reserva.setNombre_persona("primera reserva");
        this.reserva.setFecha_reserva("23/05/2022");
        this.reserva.setValor_alquiler(100);
        this.reserva.setEstado(EstadoReserva.ACTIVA);
        return this;
    }

    public Reserva build(){
        return Reserva.crear(reserva);
    }
}
