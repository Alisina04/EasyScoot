public class Anschrift {
    public String strasse;
    public String hausnummer;
    public String plz;
    public String ort;

    /**
     * Speichert eine einfache Anschrift.
     */
    public Anschrift(String strasse, String hausnummer, String plz, String ort) {
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }
}
