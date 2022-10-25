package htw.berlin.triggerliste.demo.service;

import htw.berlin.triggerliste.demo.web.api.Trigger;
import htw.berlin.triggerliste.demo.web.api.TriggerCreateRequest;
import htw.berlin.triggerliste.demo.persistence.TriggerEntity;
import htw.berlin.triggerliste.demo.persistence.TriggerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TriggerService {

    private final TriggerRepository triggerRepository;

    public TriggerService(TriggerRepository triggerrepository) {
        this.triggerRepository = triggerrepository;
    }

    public List<Trigger> findAll() {
        List<TriggerEntity> trigger = triggerRepository.findAll();
        return trigger.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Trigger create(TriggerCreateRequest request) {
        var triggerEntity = new TriggerEntity(
                request.getDatum(),
                request.getTriggerBeschreibung(),
                request.getSkala(),
                request.getEmotion(),
                request.getOrt(),
                request.getAuswirkungEmotion(),
                request.getSkalaNachIntervention());
       triggerEntity = triggerRepository.save(triggerEntity);
       return transformEntity(triggerEntity);
    }

    private Trigger transformEntity(TriggerEntity triggerEntity){
        return new Trigger(
                triggerEntity.getId(),
                triggerEntity.getDatum(),
                triggerEntity.getTriggerBeschreibung(),
                triggerEntity.getSkala(),
                triggerEntity.getEmotion(),
                triggerEntity.getOrt(),
                triggerEntity.getAuswirkungEmotion(),
                triggerEntity.getSkalaNachIntervention()
        );
    }
}
