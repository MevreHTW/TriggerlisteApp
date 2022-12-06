package htw.berlin.triggerliste.demo.service;
import htw.berlin.triggerliste.demo.persistence.TriggerEntity;
import htw.berlin.triggerliste.demo.service.TriggerService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.doReturn;

public class TriggerTransformerTest implements WithAssertions {
    private final TriggerTransformer underTest = new TriggerTransformer();

    @Test
    @DisplayName("should return transform TriggerEntity to Trigger")
    void should_transform_trigger_entity_to_trigger(){
        //given
        var triggerEntity = Mockito.mock(TriggerEntity.class);
        doReturn(111L).when(triggerEntity).getId();
        doReturn("12.10.2022").when(triggerEntity).getDatum();
        doReturn("TestMs5").when(triggerEntity).getTriggerBeschreibung();
        doReturn(-10).when(triggerEntity).getSkala();
        doReturn("emotionenTest5").when(triggerEntity).getEmotion();
        doReturn("hierTest5").when(triggerEntity).getOrt();
        doReturn("AuswirkungTest5").when(triggerEntity).getAuswirkungEmotion();
        doReturn(-5).when(triggerEntity).getSkalaNachIntervention();

        //when
        var result = underTest.transformEntity(triggerEntity);

        //then
        assertThat(result.getId()).isEqualTo(111);
        assertThat(result.getDatum()).isEqualTo("12.10.2022");
        assertThat(result.getTriggerBeschreibung()).isEqualTo("TestMs5");
        assertThat(result.getSkala()).isEqualTo(-10);
        assertThat(result.getEmotion()).isEqualTo("emotionenTest5");
        assertThat(result.getOrt()).isEqualTo("hierTest5");
        assertThat(result.getAuswirkungEmotion()).isEqualTo("AuswirkungTest5");
        assertThat(result.getSkalaNachIntervention()).isEqualTo(-5);
    }
}
