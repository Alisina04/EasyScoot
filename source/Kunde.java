import java.util.ArrayList;
import java.util.List;

public class Kunde {
    private String name;
    private String vorname;
    private String email;
    private Anschrift anschrift;

    public Kunde(String name, String vorname, String email, Anschrift anschrift) {
        this.name = name;
        this.vorname = vorname;
        this.email = email;
        this.anschrift = anschrift;
    }

    // Sucht alle verfügbaren Scooter
    public List<EScooter> scooterSuchen() {
        return EScooterRegistry.getAllAvailable();
    }

    // Suche nach Position, Radius (km) und Mindest-Ladestand (%)
    public List<EScooter> scooterSuchen(Position zentrum, float maxDistanzKm, float minLadestandProzent) {
        List<EScooter> alle = EScooterRegistry.getAllAvailable();
        List<EScooter> result = new ArrayList<>();

        // Wenn keine Position angegeben ist, nur den Ladestand prüfen
        if (zentrum == null) {
            for (EScooter s : alle) {
                Float ladestand = s.getLadestand();
                if (ladestand != null && ladestand >= minLadestandProzent) {
                    result.add(s);
                }
            }
            return result;
        }

        // Mit Position: auch die Entfernung prüfen
        for (EScooter s : alle) {
            if (s.getPosition() == null) continue;
            double dist = s.entfernungKmZu(zentrum);
            Float ladestand = s.getLadestand();
            if (dist <= maxDistanzKm && ladestand != null && ladestand >= minLadestandProzent) {
                result.add(s);
            }
        }
        return result;
    }
}
