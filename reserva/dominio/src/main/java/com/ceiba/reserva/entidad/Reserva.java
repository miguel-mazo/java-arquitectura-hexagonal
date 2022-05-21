package com.ceiba.reserva.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Reserva {

    private Long id;
    private String nombre_persona;
    private String fecha_reserva;
    private int valor_alquiler;

    private Reserva(Long id, String nombre_persona, String fecha_reserva, int valor_alquiler) {
        this.id = id;
        this.nombre_persona = nombre_persona;
        this.fecha_reserva = fecha_reserva;
        this.valor_alquiler = valor_alquiler;
    }

    public static Reserva reconstruir(Long id, String nombre_persona, String fecha_reserva, int valor_alquiler) {
        ValidadorArgumento.validarObligatorio(valor_alquiler, "Valor del alquiler es requerido");
        ValidadorArgumento.validarObligatorio(fecha_reserva, "Fecha de la reserva es requerida");
        ValidadorArgumento.validarObligatorio(nombre_persona, "Nombre de la persona es requerido");
        return new Reserva(id, nombre_persona, fecha_reserva, valor_alquiler);
    }

    public static Reserva crear(Reserva reserva) {
        ValidadorArgumento.validarObligatorio(reserva.getValor_alquiler(), "Valor del alquiler es requerido");
        ValidadorArgumento.validarObligatorio(reserva.getFecha_reserva(), "Fecha de la reserva es requerida");
        ValidadorArgumento.validarObligatorio(reserva.getNombre_persona(), "Nombre de la persona es requerido");
        return new Reserva(reserva.getId(), reserva.getNombre_persona(), reserva.getFecha_reserva(), reserva.getValor_alquiler());
    }

    public Long getId() {
        return id;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public int getValor_alquiler() {
        return valor_alquiler;
    }
}
