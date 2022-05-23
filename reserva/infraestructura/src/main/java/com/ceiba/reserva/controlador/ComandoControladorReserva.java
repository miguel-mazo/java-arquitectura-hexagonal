package com.ceiba.reserva.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.reserva.comando.ComandoActualizar;
import com.ceiba.reserva.comando.ComandoCancelar;
import com.ceiba.reserva.comando.manejador.ManejadorActualizar;
import com.ceiba.reserva.comando.manejador.ManejadorCancelar;
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

    private final ManejadorCancelar manejadorCancelar;

    private final ManejadorActualizar manejadorActualizar;

    public ComandoControladorReserva(ManejadorReservar manejadorReservar, ManejadorCancelar manejadorCancelar, ManejadorActualizar manejadorActualizar) {
        this.manejadorReservar = manejadorReservar;
        this.manejadorCancelar = manejadorCancelar;
        this.manejadorActualizar = manejadorActualizar;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Reservar", description = "Metodo utilizado para guardar una reserva")
    public ComandoRespuesta<Long> reservar(@RequestBody Reserva reserva) {
        return this.manejadorReservar.ejecutar(reserva);
    }

    @PostMapping("cancelar/{id-reserva}")
    @Operation(summary = "Cancelar", description = "Metodo utilizado para cancelar una reserva")
    public void cancelar(@PathVariable("id-reserva") Long idReserva) {
        this.manejadorCancelar.ejecutar(new ComandoCancelar(idReserva));
    }

    @PostMapping("actualizar/{id-reserva}")
    @Operation(summary = "Actualizar", description = "Metodo utilizado para actualizar una reserva")
    public void actualizar(@PathVariable("id-reserva") Long idReserva, @RequestBody Reserva reserva) {
        this.manejadorActualizar.ejecutar(new ComandoActualizar(idReserva, reserva.getFecha_reserva()));
    }
}
