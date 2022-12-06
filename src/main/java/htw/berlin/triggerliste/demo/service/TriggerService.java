package htw.berlin.triggerliste.demo.service;

import htw.berlin.triggerliste.demo.web.api.Trigger;
import htw.berlin.triggerliste.demo.web.api.TriggerManipulationRequest;
import htw.berlin.triggerliste.demo.persistence.TriggerEntity;
import htw.berlin.triggerliste.demo.persistence.TriggerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TriggerService {

    private final TriggerRepository triggerRepository;
    private final TriggerTransformer triggerTransformer;

    public TriggerService(TriggerRepository triggerrepository, TriggerTransformer triggerTransformer) {
        this.triggerRepository = triggerrepository;
        this.triggerTransformer = triggerTransformer;
    }

    public List<Trigger> findAll() {
        List<TriggerEntity> trigger = triggerRepository.findAll();
        return trigger.stream()
                .map(triggerTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Trigger findById(Long id){
        var triggerEntity = triggerRepository.findById(id);
        return triggerEntity.map(triggerTransformer::transformEntity).orElse(null);
    }


    public Trigger create(TriggerManipulationRequest request) {
        var triggerEntity = new TriggerEntity(
                request.getDatum(),
                request.getTriggerBeschreibung(),
                request.getSkala(),
                request.getEmotion(),
                request.getOrt(),
                request.getAuswirkungEmotion(),
                request.getSkalaNachIntervention());
       triggerEntity = triggerRepository.save(triggerEntity);
       return triggerTransformer.transformEntity(triggerEntity);
    }

    public Trigger update(Long id, TriggerManipulationRequest request) {
        var triggerEntityOptional = triggerRepository.findById(id);
        if (triggerEntityOptional.isEmpty()) {
            return null;
        }

        var triggerEntity = triggerEntityOptional.get();
        triggerEntity.setDatum(request.getDatum());
        triggerEntity.setTriggerBeschreibung(request.getTriggerBeschreibung());
        triggerEntity.setSkala(request.getSkala());
        triggerEntity.setEmotion(request.getEmotion());
        triggerEntity.setOrt(request.getOrt());
        triggerEntity.setAuswirkungEmotion(request.getAuswirkungEmotion());
        triggerEntity.setSkalaNachIntervention(request.getSkalaNachIntervention());
        triggerEntity = triggerRepository.save(triggerEntity);

        return triggerTransformer.transformEntity(triggerEntity);
    }

    public boolean deleteById (Long id) {
        if (!triggerRepository.existsById(id)) {
            return false;
        }

        triggerRepository.deleteById(id);
        return true;
    }

  //  public Trigger transformEntity(TriggerEntity triggerEntity){
  //      return new Trigger(
  //              triggerEntity.getId(),
  //              triggerEntity.getDatum(),
  //              triggerEntity.getTriggerBeschreibung(),
 //               triggerEntity.getSkala(),
 //               triggerEntity.getEmotion(),
 //               triggerEntity.getOrt(),
 //               triggerEntity.getAuswirkungEmotion(),
 //               triggerEntity.getSkalaNachIntervention()
//        );
 //   }
}
