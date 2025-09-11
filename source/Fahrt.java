import java.time.LocalDateTime;

public class Fahrt {
    private Kunde kunde;
    private EScooter scooter;
    private LocalDateTime startZiel;
    private LocalDateTime endZiel;
    private Float strecke;
    private Float verbrauch;
    private Float preis;

    /**
     * Speichert alle Infos zu einer Fahrt.
     */
    public Fahrt(Kunde kunde, EScooter scooter, LocalDateTime startZiel, LocalDateTime endZiel, Float strecke, Float verbrauch,
Float preis) {
        this.kunde = kunde;
        this.scooter = scooter;
        this.startZiel = startZiel;
        this.endZiel = endZiel;
        this.strecke = strecke;
        this.verbrauch = verbrauch;
        this.preis = preis;
    }

    /**
     * Gibt den Kunden zurück.
     */
    public Kunde getKunde() {
        return kunde;
    }

    /**
     * Gibt den benutzten Scooter zurück.
     */
    public EScooter getScooter() {
        return scooter;
    }

    /**
     * Gibt den Startzeitpunkt zurück.
     */
    public LocalDateTime getStartZiel() {
        return startZiel;
    }

    /**
     * Gibt den Endzeitpunkt zurück.
     */
    public LocalDateTime getEndZiel() {
        return endZiel;
    }

    /**
     * Setzt den Endzeitpunkt.
     */
    public void setEndZiel(LocalDateTime endZiel) {
        this.endZiel = endZiel;
    }

    /**
     * Gibt die gefahrene Strecke in km zurück.
     */
    public Float getStrecke() {
        return strecke;
    }

    /**
     * Setzt die gefahrene Strecke in km.
     */
    public void setStrecke(Float strecke) {
        this.strecke = strecke;
    }

    /**
     * Gibt den Verbrauch in Wh zurück.
     */
    public Float getVerbrauch() {
        return verbrauch;
    }

    /**
     * Setzt den Verbrauch in Wh.
     */
    public void setVerbrauch(Float verbrauch) {
        this.verbrauch = verbrauch;
    }

    /**
     * Gibt den Preis in Euro zurück.
     */
    public Float getPreis() {
        return preis;
    }

    /**
     * Setzt den Preis in Euro.
     */
    public void setPreis(Float preis) {
        this.preis = preis;
    }
}
