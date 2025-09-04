import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    // Einfache Suche: alle verfügbaren Scooter (nicht verliehen, nicht in Wartung)
    public List<EScooter> ScooterSuchen() {
        return EScooterRegistry.getAllAvailable();
    }

    // Überladene Suche: nach Position, Radius (km) und Mindest-Ladestand (%)
    public List<EScooter> ScooterSuchen(Position zentrum, float maxDistanzKm, float minLadestandProzent) {
        List<EScooter> alle = EScooterRegistry.getAllAvailable();
        if (zentrum == null) {
            return alle.stream()
                    .filter(s -> s.getLadestand() != null && s.getLadestand() >= minLadestandProzent)
                    .collect(Collectors.toList());
        }
        List<EScooter> result = new ArrayList<>();
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
