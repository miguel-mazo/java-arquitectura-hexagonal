package com.ceiba.configuracion;

import com.ceiba.reserva.puerto.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioReservar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioReservar servicioReservar(RepositorioReserva repositorioReserva){
        return new ServicioReservar(repositorioReserva);
    }
}
