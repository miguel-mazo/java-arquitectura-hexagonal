package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.entidad.EstadoReserva;
import com.ceiba.reserva.entidad.Reserva;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoReserva implements RowMapper<Reserva>, MapperResult {

    @Override
    public Reserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        var id = resultSet.getLong("id");
        var nombre_persona = resultSet.getString("nombre_persona");
        var fecha_reserva = resultSet.getString("fecha_reserva");
        var valor_alquiler = resultSet.getInt("valor_alquiler");
        var estado = EstadoReserva.valueOf(resultSet.getString("estado"));

        return Reserva.reconstruir(id, nombre_persona, fecha_reserva, valor_alquiler, estado);
    }
}
