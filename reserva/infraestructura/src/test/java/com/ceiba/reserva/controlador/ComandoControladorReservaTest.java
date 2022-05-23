package com.ceiba.reserva.controlador;

import com.ceiba.reserva.ApplicationMock;
import com.ceiba.reserva.entidad.EstadoReserva;
import com.ceiba.reserva.puerto.RepositorioReserva;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorReserva.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorReservaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioReserva repositorioReserva;

    @Test
    void crearReservaExitosa() throws Exception {

        var reservaTestDataBuilder = new ReservaTestDataBuilder().crearPorDefecto().build();

        var resultado = mocMvc.perform(post("/reserva")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservaTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, RespuestaReservar.class);

        var reservaGuardada = repositorioReserva.obtenerReservaPorId(respuesta.getValor());

        Assertions.assertEquals(3l, reservaGuardada.getId());
        Assertions.assertEquals("primera reserva", reservaGuardada.getNombre_persona());
        Assertions.assertEquals("23/05/2022", reservaGuardada.getFecha_reserva());
        Assertions.assertEquals(100, reservaGuardada.getValor_alquiler());
        Assertions.assertEquals(EstadoReserva.ACTIVA, reservaGuardada.getEstado());
    }

    @Test
    void cancelarReservaExitosa() throws Exception {

        mocMvc.perform(post("/reserva/cancelar/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        var reservaCancelada = repositorioReserva.obtenerReservaPorId(1l);

        Assertions.assertTrue(reservaCancelada.esCancelada());
    }

    @Test
    void actualizarReservaExitosa() throws Exception {

        var comandoActualizarTestDataBuilder = new ComandoActualizarTestDataBuilder().crearPorDefecto().build();

        var resultado = mocMvc.perform(post("/reserva/actualizar/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoActualizarTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        var reservaActualizada = repositorioReserva.obtenerReservaPorId(1l);

        Assertions.assertEquals(1l, reservaActualizada.getId());
        Assertions.assertEquals("04/06/1995", reservaActualizada.getFecha_reserva());
    }
}
