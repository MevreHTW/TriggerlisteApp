package htw.berlin.triggerliste.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TriggerRepository extends JpaRepository<TriggerEntity, Long> {

    List<TriggerEntity> findAllByAuswirkungEmotion(String AuswirkungEmotion);
}
