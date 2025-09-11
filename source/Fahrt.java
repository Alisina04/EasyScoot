import java.time.LocalDateTime;

public class Fahrt {
    private Kunde kunde;
    private EScooter scooter;
    private LocalDateTime startZiel;
    private LocalDateTime endZiel;
    private Float strecke;
    private Float verbrauch;
    private Float preis;

    public Fahrt(Kunde kunde, EScooter scooter, LocalDateTime startZiel, LocalDateTime endZiel, Float strecke, Float verbrauch, Float preis) {
        this.kunde = kunde;
        this.scooter = scooter;
        this.startZiel = startZiel;
        this.endZiel = endZiel;
        this.strecke = strecke;
        this.verbrauch = verbrauch;
        this.preis = preis;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public EScooter getScooter() {
        return scooter;
    }

    public LocalDateTime getStartZiel() {
        return startZiel;
    }

    public LocalDateTime getEndZiel() {
        return endZiel;
    }

    public void setEndZiel(LocalDateTime endZiel) {
        this.endZiel = endZiel;
    }

    public Float getStrecke() {
        return strecke;
    }

    public void setStrecke(Float strecke) {
        this.strecke = strecke;
    }

    public Float getVerbrauch() {
        return verbrauch;
    }

    public void setVerbrauch(Float verbrauch) {
        this.verbrauch = verbrauch;
    }

    public Float getPreis() {
        return preis;
    }

    public void setPreis(Float preis) {
        this.preis = preis;
    }
}
