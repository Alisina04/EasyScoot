public abstract class Mitarbeiter {
    private String id;
    private String name;
    private String vorname;
    private String email;
    private Anschrift anschrift;

    /**
     * Legt einen neuen Mitarbeiter an.
     */
    public Mitarbeiter(String id, String name, String vorname, String email, Anschrift anschrift) {
        this.id = id;
        this.name = name;
        this.vorname = vorname;
        this.email = email;
        this.anschrift = anschrift;
    }
}
