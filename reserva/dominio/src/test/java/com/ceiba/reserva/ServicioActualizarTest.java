package com.ceiba.reserva;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.entidad.Reserva;
import com.ceiba.reserva.puerto.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioActualizar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class ServicioActualizarTest {

    @Test
    void deberiaActualizarExitosamente(){

        var reserva = new ReservaTestDataBuilder().conReservaPorDefecto()
                .conFechaRerserva("22/05/2020")
                .reconstruir();

        var repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.guardarReserva(Mockito.any())).thenReturn(1l);

        var servicioActualizar = new ServicioActualizar(repositorioReserva);

        servicioActualizar.ejecutar(reserva);

        ArgumentCaptor<Reserva> captorFactura = ArgumentCaptor.forClass(Reserva.class);
        Mockito.verify(repositorioReserva, Mockito.times(1)).actualizarFecha(captorFactura.capture());

        Assertions.assertEquals(reserva, captorFactura.getValue());
    }

    @Test
    void actualizarReservaNullDeberiaLanzarError(){
        var repositorioReserva = Mockito.mock(RepositorioReserva.class);
        var servicioActualizar = new ServicioActualizar(repositorioReserva);

        BasePrueba.assertThrows(() -> servicioActualizar.
                ejecutar(null), ExcepcionValorObligatorio.class, "No existe una reserva para actualizar");
    }
}
