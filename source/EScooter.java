public class EScooter {
    private int id;
    private Position position;
    private Float ladestand; // Prozent (0..100)
    private String modell;
    private Float batteriekapazitaet; // z.B. Wh
    private Float verbrauchskoeffizienten; // z.B. Wh/km
    private Fahrstatus fahrstatus;
    private Leihstatus leihstatus;
    private Wartungsstatus wartungsstatus;

    /**
     * Erstellt einen neuen EScooter mit allen Angaben.
     */
    public EScooter(
            int id,
            Position position,
            Float ladestand,
            String modell,
            Float batteriekapazitaet,
            Float verbrauchskoeffizienten,
            Fahrstatus fahrstatus,
            Leihstatus leihstatus,
            Wartungsstatus wartungsstatus
    ) {
        this.id = id;
        this.position = position;
        this.ladestand = ladestand;
        this.modell = modell;
        this.batteriekapazitaet = batteriekapazitaet;
        this.verbrauchskoeffizienten = verbrauchskoeffizienten;
        this.fahrstatus = fahrstatus;
        this.leihstatus = leihstatus;
        this.wartungsstatus = wartungsstatus;
    }

    /**
     * Gibt den Wartungsstatus zurück.
     */
    public Wartungsstatus getWartungsstatus() {
        return wartungsstatus;
    }

    /**
     * Setzt den Wartungsstatus.
     */
    public void setWartungsstatus(Wartungsstatus wartungsstatus) {
        this.wartungsstatus = wartungsstatus;
    }

    /**
     * Gibt den Leihstatus zurück.
     */
    public Leihstatus getLeihstatus() {
        return leihstatus;
    }

    /**
     * Setzt den Leihstatus.
     */
    public void setLeihstatus(Leihstatus leihstatus) {
        this.leihstatus = leihstatus;
    }

    /**
     * Gibt den Fahrstatus zurück.
     */
    public Fahrstatus getFahrstatus() {
        return fahrstatus;
    }

    /**
     * Setzt den Fahrstatus.
     */
    public void setFahrstatus(Fahrstatus fahrstatus) {
        this.fahrstatus = fahrstatus;
    }

    /**
     * Gibt den Verbrauchskoeffizienten zurück.
     */
    public Float getVerbrauchskoeffizienten() {
        return verbrauchskoeffizienten;
    }

    /**
     * Setzt den Verbrauchskoeffizienten.
     */
    public void setVerbrauchskoeffizienten(Float verbrauchskoeffizienten) {
        this.verbrauchskoeffizienten = verbrauchskoeffizienten;
    }

    /**
     * Gibt die Batteriekapazität zurück.
     */
    public Float getBatteriekapazitaet() {
        return batteriekapazitaet;
    }

    /**
     * Setzt die Batteriekapazität.
     */
    public void setBatteriekapazitaet(Float batteriekapazitaet) {
        this.batteriekapazitaet = batteriekapazitaet;
    }

    /**
     * Gibt das Modell zurück.
     */
    public String getModell() {
        return modell;
    }

    /**
     * Setzt das Modell.
     */
    public void setModell(String modell) {
        this.modell = modell;
    }

    /**
     * Gibt den Ladestand zurück.
     */
    public Float getLadestand() {
        return ladestand;
    }

    /**
     * Setzt den Ladestand.
     */
    public void setLadestand(Float ladestand) {
        this.ladestand = ladestand;
    }

    /**
     * Gibt die Position zurück.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Setzt die Position.
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Gibt die ID zurück.
     */
    public int getId() {
        return id;
    }

    /**
     * Setzt die ID.
     */
    public void setId(int id) {
        this.id = id;
    }
}
