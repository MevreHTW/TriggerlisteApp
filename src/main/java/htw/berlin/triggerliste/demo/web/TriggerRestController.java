package htw.berlin.triggerliste.demo.web;

import htw.berlin.triggerliste.demo.web.api.Trigger;
import htw.berlin.triggerliste.demo.web.api.TriggerCreateRequest;
import htw.berlin.triggerliste.demo.service.TriggerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
public class TriggerRestController {

    private final TriggerService triggerService;

    public TriggerRestController(TriggerService triggerService) {
        this.triggerService = triggerService;
    }

    @GetMapping(path = "/api/v1/trigger")
    public ResponseEntity<List<Trigger>> fetchTrigger() {
        return ResponseEntity.ok(triggerService.findAll());
    }

    @GetMapping(path = "/api/v1/trigger/{id}")
    public ResponseEntity<Trigger> fetchTriggerById(@PathVariable Long id) {
        var trigger = triggerService.findById(id);
        return trigger != null? ResponseEntity.ok(trigger) : ResponseEntity.notFound().build();

    }

    @PostMapping(path = "/api/v1/trigger")
    public ResponseEntity<Void> createTrigger(@RequestBody TriggerCreateRequest request) throws URISyntaxException {
       var trigger = triggerService.create(request);
       URI uri = new URI("/api/v1/trigger/" + trigger.getId());
       return ResponseEntity.created(uri).build();
    }
}

