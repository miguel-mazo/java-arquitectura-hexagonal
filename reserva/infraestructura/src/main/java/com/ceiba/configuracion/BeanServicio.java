package com.ceiba.configuracion;

import com.ceiba.reserva.puerto.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioActualizar;
import com.ceiba.reserva.servicio.ServicioCancelar;
import com.ceiba.reserva.servicio.ServicioReservar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioReservar servicioReservar(RepositorioReserva repositorioReserva){
        return new ServicioReservar(repositorioReserva);
    }
    @Bean
    public ServicioCancelar servicioCancelar(RepositorioReserva repositorioReserva){
        return new ServicioCancelar(repositorioReserva);
    }
    @Bean
    public ServicioActualizar servicioActualizar(RepositorioReserva repositorioReserva){
        return new ServicioActualizar(repositorioReserva);
    }
}
