package com.ceiba.reserva.controlador;

import com.ceiba.reserva.ApplicationMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorReserva.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ConsultaControladorReservaTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    void consultarReservasActivas() throws Exception {

        mocMvc.perform(get("/reserva/listar")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nombre_persona", is("primera reserva")))
                .andExpect(jsonPath("$[0].fecha_reserva", is("01/01/1111")))
                .andExpect(jsonPath("$[0].valor_alquiler", is(100)))
                .andExpect(jsonPath("$[0].estado", is("ACTIVA")));
    }

    @Test
    void consultarReservaPorId() throws Exception {
        mocMvc.perform(get("/reserva/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("nombre_persona", is("primera reserva")))
                .andExpect(jsonPath("fecha_reserva", is("01/01/1111")))
                .andExpect(jsonPath("valor_alquiler", is(100)))
                .andExpect(jsonPath("estado", is("ACTIVA")));
    }
}
