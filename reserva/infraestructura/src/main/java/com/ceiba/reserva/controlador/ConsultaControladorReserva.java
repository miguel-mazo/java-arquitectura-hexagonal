package com.ceiba.reserva.controlador;

import com.ceiba.reserva.consulta.ManejadorConsultarReserva;
import com.ceiba.reserva.entidad.Reserva;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reserva")
@Tag(name = "Controlador consulta reserva")
public class ConsultaControladorReserva {

    private final ManejadorConsultarReserva manejadorConsultarReserva;

    public ConsultaControladorReserva(ManejadorConsultarReserva manejadorConsultarReserva) {
        this.manejadorConsultarReserva = manejadorConsultarReserva;
    }

    @GetMapping("/listar")
    @Operation(summary = "Consultar todas las reservas", description = "Metodo utilizado para consultar todas las reservas")
    public List<Reserva> obtenerReservas(){
        return manejadorConsultarReserva.obtenerReservas();
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Consultar reserva por id", description = "Metodo utilizado para consultar una reserva por id")
    public Reserva obtenerReservaPorId(@PathVariable("id") Long id) {
        return manejadorConsultarReserva.obtenerReservaPorId(id);
    }
}
