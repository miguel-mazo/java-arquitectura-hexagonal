package com.ceiba.reserva.controlador;

import com.ceiba.reserva.entidad.EstadoReserva;
import com.ceiba.reserva.entidad.Reserva;

public class ComandoActualizarTestDataBuilder {

    private Reserva reserva;

    public ComandoActualizarTestDataBuilder() { this.reserva = new Reserva(); }

    public ComandoActualizarTestDataBuilder crearPorDefecto(){
        this.reserva.setNombre_persona("primera reserva");
        this.reserva.setFecha_reserva("04/06/1995");
        return this;
    }

    public Reserva build(){
        return Reserva.crear(reserva);
    }
}
