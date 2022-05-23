package com.ceiba.reserva;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.entidad.Reserva;
import com.ceiba.reserva.puerto.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioCancelar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class ServicioCancelarTest {

    @Test
    void deberiaCancelarExitosamente(){
        var repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.guardarReserva(Mockito.any())).thenReturn(1l);

        var reserva = new ReservaTestDataBuilder().conReservaPorDefecto().reconstruir();

        var servicioCancelar = new ServicioCancelar(repositorioReserva);

        servicioCancelar.ejecutar(reserva);

        ArgumentCaptor<Reserva> captorReserva = ArgumentCaptor.forClass(Reserva.class);
        Mockito.verify(repositorioReserva, Mockito.times(1)).actualizarEstado(captorReserva.capture());

        Assertions.assertTrue(captorReserva.getValue().esCancelada());
    }

    @Test
    void cancelarReservaNullDeberiaLanzarError(){
        var repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var servicioCancelar = new ServicioCancelar(repositorioReserva);

        BasePrueba.assertThrows(() -> servicioCancelar.
                ejecutar(null), ExcepcionValorObligatorio.class, "No existe una reserva para cancelar");
    }
}
