package com.ceiba.reserva.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@NoArgsConstructor
@Setter
public class Reserva {

    private Long id;
    private String nombre_persona;
    private String fecha_reserva;
    private int valor_alquiler;
    private EstadoReserva estado;

    private Reserva(Long id, String nombre_persona, String fecha_reserva, int valor_alquiler, EstadoReserva estado) {
        this.id = id;
        this.nombre_persona = nombre_persona;
        this.fecha_reserva = fecha_reserva;
        this.valor_alquiler = valor_alquiler;
        this.estado = estado;
    }

    private Reserva(Long id, String nombre_persona, String fecha_reserva) {
        this.id = id;
        this.nombre_persona = nombre_persona;
        this.fecha_reserva = fecha_reserva;
        this.estado = EstadoReserva.ACTIVA;
        aplicarValorAlquiler();
    }

    @SneakyThrows
    private void aplicarValorAlquiler(){
        this.valor_alquiler = 100;

        Calendar fecha = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fecha.setTime(sdf.parse(fecha_reserva));

        int day = fecha.get(Calendar.DAY_OF_WEEK);
        switch (day){
            case Calendar.SATURDAY:
                valor_alquiler = valor_alquiler + 20;
                break;
            case Calendar.SUNDAY:
                valor_alquiler = valor_alquiler + 30;
                break;
            default:
                valor_alquiler = valor_alquiler;
        }
    }

    public static Reserva reconstruir(Long id, String nombre_persona, String fecha_reserva, int valor_alquiler, EstadoReserva estado) {
        ValidadorArgumento.validarObligatorio(fecha_reserva, "Fecha de la reserva es requerida");
        ValidadorArgumento.validarObligatorio(nombre_persona, "Nombre de la persona es requerido");
        return new Reserva(id, nombre_persona, fecha_reserva, valor_alquiler, estado);
    }

    public static Reserva crear(Reserva reserva) {
        ValidadorArgumento.validarObligatorio(reserva.getFecha_reserva(), "Fecha de la reserva es requerida");
        ValidadorArgumento.validarObligatorio(reserva.getNombre_persona(), "Nombre de la persona es requerido");
        return new Reserva(reserva.getId(), reserva.getNombre_persona(), reserva.getFecha_reserva());
    }

    public void cancelar() {
        this.estado = EstadoReserva.CANCELADA;
    }

    public void actualizar(Reserva reserva){
        ValidadorArgumento.validarObligatorio(reserva.getFecha_reserva(), "Fecha de la reserva es requerida");

        if(esCancelada()){
            throw new ExcepcionValorInvalido("No se puede actualizar una reserva cancelada");
        }

        this.fecha_reserva = reserva.getFecha_reserva();
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

    public EstadoReserva getEstado() { return estado; }

    public boolean esCancelada(){ return estado.equals(EstadoReserva.CANCELADA); }
}
