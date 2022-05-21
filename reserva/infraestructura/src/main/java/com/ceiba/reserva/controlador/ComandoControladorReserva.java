package com.ceiba.reserva.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.reserva.comando.manejador.ManejadorReservar;
import com.ceiba.reserva.entidad.Reserva;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva")
@Tag(name = "Controlador comando reserva")
public class ComandoControladorReserva {
    private final ManejadorReservar manejadorReservar;

    public ComandoControladorReserva(ManejadorReservar manejadorReservar) {
        this.manejadorReservar = manejadorReservar;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Reservar", description = "Metodo utilizado para guardar una reserva")
    public ComandoRespuesta<Long> reservar(@RequestBody Reserva reserva) {
        return this.manejadorReservar.ejecutar(reserva);
    }
}
