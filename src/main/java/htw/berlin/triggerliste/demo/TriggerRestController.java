package htw.berlin.triggerliste.demo;

import htw.berlin.triggerliste.demo.api.Trigger;
import htw.berlin.triggerliste.demo.api.TriggerCreateRequest;
import htw.berlin.triggerliste.demo.persistence.TriggerEntity;
import htw.berlin.triggerliste.demo.persistence.TriggerRepository;
import htw.berlin.triggerliste.demo.service.TriggerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
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

    @PostMapping(path = "/api/v1/trigger")
    public ResponseEntity<Void> createTrigger(@RequestBody TriggerCreateRequest request){
       var trigger :Trigger = triggerService.create(request);
       URI uri = new URI("/api/v1/trigger/" + trigger.getId());
       return ResponseEntity.created();
    }
}

