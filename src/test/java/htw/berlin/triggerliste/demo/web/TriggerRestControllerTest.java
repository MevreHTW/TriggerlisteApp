package htw.berlin.triggerliste.demo.web;


import htw.berlin.triggerliste.demo.service.TriggerService;
import htw.berlin.triggerliste.demo.web.api.Trigger;
import htw.berlin.triggerliste.demo.persistence.TriggerRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TriggerRestController.class)
public class TriggerRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TriggerService triggerService;

    @Test
    @DisplayName("should return found trigger from trigger service")
    void should_return_found_trigger_from_trigger_service() throws Exception {
        // given
        var trigger = List.of(
                new Trigger(1,"12.10.2022","TestTest",-8,
                        "TestRestEmotion","RestOrt","TestAE",
                        -6),
                new Trigger(2,"12.10.2022","TestTest",-8,
                        "TestRestEmotion","RestOrt","TestAE",
                        -6)
        );
        doReturn(trigger).when(triggerService).findAll();

        // when
        mockMvc.perform(get("/api/v1/trigger"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].datum").value("12.10.2022"))
                .andExpect(jsonPath("$[0].triggerBeschreibung").value("TestTest"))
                .andExpect(jsonPath("$[0].skala").value(-8))
                .andExpect(jsonPath("$[0].emotion").value("TestRestEmotion"))
                .andExpect(jsonPath("$[0].ort").value("RestOrt"))
                .andExpect(jsonPath("$[0].auswirkungEmotion").value("TestAE"))
                .andExpect(jsonPath("$[0].skalaNachIntervention").value(-6))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].datum").value("12.10.2022"))
                .andExpect(jsonPath("$[1].triggerBeschreibung").value("TestTest"))
                .andExpect(jsonPath("$[1].skala").value(-8))
                .andExpect(jsonPath("$[1].emotion").value("TestRestEmotion"))
                .andExpect(jsonPath("$[1].ort").value("RestOrt"))
                .andExpect(jsonPath("$[1].auswirkungEmotion").value("TestAE"))
                .andExpect(jsonPath("$[1].skalaNachIntervention").value(-6));
    }


    @Test
    @DisplayName("should return 201 http status and Location header when creating a trigger")
    void should_return_201_http_status_and_location_header_when_creating_a_trigger() throws Exception {
        // given
        String triggerToCreateAsJson = """
                {
                  "id": 123,
                  "datum": "12.10.2022",
                  "triggerBeschreibung": "TestTest",
                  "skala": -8,
                  "emotion": "TestRestEmotion",
                  "ort": "RestOrt",
                  "auswirkungEmotion": "TestAE",
                  "skalaNachIntervention": -6
                }
                """;
        var trigger = new Trigger(123,"12.10.2022","TestTest",-8,
                "TestRestEmotion","RestOrt","TestAE",
                -6);
        doReturn(trigger).when(triggerService).create(any());

        // when
        mockMvc.perform(
                        post("/api/v1/trigger")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(triggerToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/trigger/" + trigger.getId()))));
//            .andExpect(header().string("Location", Matchers.containsString(Long.toString(person.getId()))));

    }

    @Test
    @DisplayName("should validate create trigger request")
    void should_validate_create_person_trigger() throws Exception {
        // given
        String triggerToCreateAsJson = "{\"12.10.2022\": \"TestTest\", \"-8\":\"TestRestEmotion\", \"RestOrt\":\"TestAE\", \"-6\"}";

        // when
        mockMvc.perform(
                        post("/api/v1/trigger")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(triggerToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }
}


