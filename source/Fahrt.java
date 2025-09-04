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

}
