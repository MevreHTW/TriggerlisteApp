package htw.berlin.triggerliste.demo.api;

import java.util.Date;

public class Trigger {
    private long id;
    private String datum;
    private String triggerBeschreibung;
    private int skala;
    private String emotion;
    private String ort;
    private String auswirkungEmotion;
    private int skalaNachIntervention;

    public Trigger(long id, String datum, String triggerBeschreibung, int skala, String emotion, String ort, String auswirkungEmotion, int skalaNachIntervention) {
        this.id = id;
        this.datum = datum;
        this.triggerBeschreibung = triggerBeschreibung;
        this.skala = skala;
        this.emotion = emotion;
        this.ort = ort;
        this.auswirkungEmotion = auswirkungEmotion;
        this.skalaNachIntervention = skalaNachIntervention;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
