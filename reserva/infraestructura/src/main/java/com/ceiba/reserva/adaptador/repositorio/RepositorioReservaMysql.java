package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.entidad.Reserva;
import com.ceiba.reserva.puerto.RepositorioReserva;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioReservaMysql implements RepositorioReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoReserva mapeoReserva;
    @SqlStatement(namespace = "reserva", value = "obtenerporid")
    private static String sqlObtenerPorId;

    @SqlStatement(namespace = "reserva", value = "obtenerreservas")
    private static String sqlObtenerReservas;

    @SqlStatement(namespace = "reserva", value = "guardarreserva")
    private static String sqlGuardarReserva;

    public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoReserva mapeoReserva) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoReserva = mapeoReserva;
    }

    @Override
    public Reserva obtenerReservaPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId,
                        paramSource, new MapeoReserva()));
    }

    @Override
    public List<Reserva> obtenerReservas(){
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerReservas, mapeoReserva);
    }

    @Override
    public Long guardarReserva(Reserva reserva){
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", reserva.getId());
        paramSource.addValue("nombre_persona", reserva.getNombre_persona());
        paramSource.addValue("fecha_reserva", reserva.getFecha_reserva());
        paramSource.addValue("valor_alquiler", reserva.getValor_alquiler());
        Long idReserva = this.customNamedParameterJdbcTemplate.crear(paramSource, sqlGuardarReserva);
        Reserva.crear(reserva);
        return idReserva;
    }
}
