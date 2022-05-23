package com.ceiba.reserva;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.entidad.EstadoReserva;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReservaTest {

    @Test
    void deberiaCrearReservaExitoso(){
        var reserva = new ReservaTestDataBuilder()
                .conId(1l)
                .conNombrePersona("Reserva 1")
                .conFechaRerserva("01/01/1111")
                .conValorAlquiler(100)
                .conEstado(EstadoReserva.ACTIVA)
                .reconstruir();

        Assertions.assertEquals(EstadoReserva.ACTIVA, reserva.getEstado());
        Assertions.assertEquals(100, reserva.getValor_alquiler());
        Assertions.assertEquals("01/01/1111", reserva.getFecha_reserva());
        Assertions.assertEquals("Reserva 1", reserva.getNombre_persona());
        Assertions.assertEquals(1l, reserva.getId());
    }

    @Test
    void reconstruirReservaSinFechaDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new ReservaTestDataBuilder()
                        .conNombrePersona("Reserva 1").reconstruir(),
                ExcepcionValorObligatorio.class,
                "Fecha de la reserva es requerida");
    }

    @Test
    void reconstruirReservaSinNombreDeberiaLanzarError(){
        BasePrueba.assertThrows(()->new ReservaTestDataBuilder()
                        .conFechaRerserva("01/01/1111").reconstruir(),
                ExcepcionValorObligatorio.class,
                "Nombre de la persona es requerido");
    }
}
