package com.ceiba.reserva;

import com.ceiba.reserva.entidad.Reserva;
import com.ceiba.reserva.puerto.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioReservar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class ServicioReservarTest {

    @Test
    void deberiaReservar(){
        Reserva reserva = new ReservaTestDataBuilder()
                .conReservaPorDefecto().reconstruir();

        var respositorioReserva =  Mockito.mock(RepositorioReserva.class);
        Mockito.when(respositorioReserva.guardarReserva(Mockito.any())).thenReturn(1l);

        var servicioReservar = new ServicioReservar(respositorioReserva);

        var idReservaCreada = servicioReservar.ejecutar(reserva);

        ArgumentCaptor<Reserva> captorReserva = ArgumentCaptor.forClass(Reserva.class);
        Mockito.verify(respositorioReserva, Mockito.times(1)).guardarReserva(captorReserva.capture());

        Assertions.assertEquals(1l, idReservaCreada);
    }
}
