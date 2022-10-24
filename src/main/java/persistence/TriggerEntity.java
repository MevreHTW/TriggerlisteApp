package persistence;

import javax.persistence.*;

@Entity(name = "trigger")
public class TriggerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "datum")
    private String datum;

    @Column(name = "trigger_beschreibugn", nullable = false)
    private String triggerBeschreibung;

    @Column(name = "skala")
    private int skala;

    @Column(name = "emotion")
    private String emotion;

    @Column(name = "ort")
    private String ort;

    @Column(name = "auswirkung_emotion")
    private String auswirkungEmotion;

    @Column(name = "skala_nach_intervention")
    private int skalaNachIntervention;

    public TriggerEntity(long id, String datum, String triggerBeschreibung, int skala, String emotion, String ort, String auswirkungEmotion, int skalaNachIntervention) {
        this.id = id;
        this.datum = datum;
        this.triggerBeschreibung = triggerBeschreibung;
        this.skala = skala;
        this.emotion = emotion;
        this.ort = ort;
        this.auswirkungEmotion = auswirkungEmotion;
        this.skalaNachIntervention = skalaNachIntervention;
    }

    protected TriggerEntity() {}

    public long getId() {
        return id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getTriggerBeschreibung() {
        return triggerBeschreibung;
    }

    public void setTriggerBeschreibung(String triggerBeschreibung) {
        this.triggerBeschreibung = triggerBeschreibung;
    }

    public int getSkala() {
        return skala;
    }

    public void setSkala(int skala) {
        this.skala = skala;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getAuswirkungEmotion() {
        return auswirkungEmotion;
    }

    public void setAuswirkungEmotion(String auswirkungEmotion) {
        this.auswirkungEmotion = auswirkungEmotion;
    }

    public int getSkalaNachIntervention() {
        return skalaNachIntervention;
    }

    public void setSkalaNachIntervention(int skalaNachIntervention) {
        this.skalaNachIntervention = skalaNachIntervention;
    }
}
