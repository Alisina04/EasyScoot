public class Kunde {
    private String name;
    private String vorname;
    private String email;
    private Anschrift anschrift;

    /**
     * Erstellt einen neuen Kunden.
     */
    public Kunde(String name, String vorname, String email, Anschrift anschrift) {
        this.name = name;
        this.vorname = vorname;
        this.email = email;
        this.anschrift = anschrift;
    }
}
