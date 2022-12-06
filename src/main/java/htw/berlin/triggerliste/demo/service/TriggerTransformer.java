package htw.berlin.triggerliste.demo.service;

import htw.berlin.triggerliste.demo.persistence.TriggerEntity;
import htw.berlin.triggerliste.demo.web.api.Trigger;
import org.springframework.stereotype.Service;

@Service
public class TriggerTransformer {

    public Trigger transformEntity(TriggerEntity triggerEntity) {
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
