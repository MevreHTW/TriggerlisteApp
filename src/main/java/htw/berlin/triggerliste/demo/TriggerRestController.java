package htw.berlin.triggerliste.demo;

import htw.berlin.triggerliste.demo.api.Trigger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class TriggerRestController {

    private List<Trigger> triggers;

    public TriggerRestController() {
        triggers = new ArrayList<>();
        triggers.add(new Trigger(1, "22.10.2022", "beleidigt werden", -2, "Angst", "im Supermarkt alleine", "Krampf im Bauch",-1));
        triggers.add(new Trigger(2,"22.10.2022", "angegriffen werden", -8, "Angst", "im Park alleine", "Krampf im Bauch",-5));
    }

    @GetMapping(path = "/api/v1/trigger")
    public ResponseEntity<List<Trigger>> fetchTrigger() {
        return ResponseEntity.ok(triggers);
    }

}

//test
