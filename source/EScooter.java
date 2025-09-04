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

    // Business-Methoden
    public boolean istVerfuegbar() {
        return leihstatus == Leihstatus.VERFUEGBAR && wartungsstatus == Wartungsstatus.KEINE_WARTUNG;
    }

    public double entfernungKmZu(Position other) {
        if (this.position == null) return Double.POSITIVE_INFINITY;
        return this.position.distanceKm(other);
    }

    public void startWartung() {
        this.wartungsstatus = Wartungsstatus.IN_WARTUNG;
        // Optional: Scooter kann während Wartung nicht verliehen werden
        if (this.leihstatus == Leihstatus.VERFUEGBAR) {
            this.leihstatus = Leihstatus.BLOCKIERT;
        }
    }

    public void beendeWartung() {
        this.wartungsstatus = Wartungsstatus.KEINE_WARTUNG;
        if (this.leihstatus == Leihstatus.BLOCKIERT) {
            this.leihstatus = Leihstatus.VERFUEGBAR;
        }
    }

    // Getter/Setter
    public Wartungsstatus getWartungsstatus() {
        return wartungsstatus;
    }

    public void setWartungsstatus(Wartungsstatus wartungsstatus) {
        this.wartungsstatus = wartungsstatus;
    }

    public Leihstatus getLeihstatus() {
        return leihstatus;
    }

    public void setLeihstatus(Leihstatus leihstatus) {
        this.leihstatus = leihstatus;
    }

    public Fahrstatus getFahrstatus() {
        return fahrstatus;
    }

    public void setFahrstatus(Fahrstatus fahrstatus) {
        this.fahrstatus = fahrstatus;
    }

    public Float getVerbrauchskoeffizienten() {
        return verbrauchskoeffizienten;
    }

    public void setVerbrauchskoeffizienten(Float verbrauchskoeffizienten) {
        this.verbrauchskoeffizienten = verbrauchskoeffizienten;
    }

    public Float getBatteriekapazitaet() {
        return batteriekapazitaet;
    }

    public void setBatteriekapazitaet(Float batteriekapazitaet) {
        this.batteriekapazitaet = batteriekapazitaet;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public Float getLadestand() {
        return ladestand;
    }

    public void setLadestand(Float ladestand) {
        this.ladestand = ladestand;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}