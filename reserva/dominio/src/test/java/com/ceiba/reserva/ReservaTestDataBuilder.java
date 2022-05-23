package com.ceiba.reserva;

import com.ceiba.reserva.entidad.EstadoReserva;
import com.ceiba.reserva.entidad.Reserva;

public class ReservaTestDataBuilder {

    private Long id;
    private String nombre_persona;
    private String fecha_reserva;

    private int valor_alquiler;
    private EstadoReserva estado;

    public ReservaTestDataBuilder conReservaPorDefecto(){

        this.id = 1l;
        this.nombre_persona = "Reserva 1";
        this.fecha_reserva = "01/01/1111";
        this.estado = EstadoReserva.ACTIVA;

        return this;
    }

    public ReservaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ReservaTestDataBuilder conNombrePersona(String nombre_persona){
        this.nombre_persona = nombre_persona;
        return this;
    }

    public ReservaTestDataBuilder conFechaRerserva(String fecha_reserva){
        this.fecha_reserva = fecha_reserva;
        return this;
    }

    public ReservaTestDataBuilder conValorAlquiler(int valor_alquiler){
        this.valor_alquiler = valor_alquiler;
        return this;
    }

    public ReservaTestDataBuilder conEstado(EstadoReserva estadoReserva){
        this.estado = estadoReserva;
        return this;
    }

    public Reserva reconstruir(){
        return Reserva.reconstruir(id,nombre_persona,fecha_reserva,valor_alquiler,estado);
    }

}
