import java.util.ArrayList;
import java.util.List;

public class ServiceMitarbeiter extends Mitarbeiter {
    // Einfache In-Memory-Registry aller Scooter
    private static final List<EScooter> REGISTRY = new ArrayList<>();

    public ServiceMitarbeiter(String id, String name, String vorname, String email, Anschrift anschrift) {
        super(id, name, vorname, email, anschrift);
    }

    public List<EScooter> AlleScooterSuchen() {
        return new ArrayList<>(REGISTRY);
    }

    public void WartungStarten(int scooterID) {
        for (EScooter s : REGISTRY) {
            if (s.getId() == scooterID) {
                s.startWartung();
                return;
            }
        }
    }

    public void WartungBeenden(int scooterID) {
        for (EScooter s : REGISTRY) {
            if (s.getId() == scooterID) {
                s.beendeWartung();
                return;
            }
        }
    }

    public void ScooterHinzufuegen(EScooter scooter) {
        // Falls bereits vorhanden (gleiche ID), zuerst entfernen, dann hinzufügen
        REGISTRY.removeIf(s -> s.getId() == scooter.getId());
        REGISTRY.add(scooter);
    }

    public void ScooterEntfernen(int scooterID) {
        REGISTRY.removeIf(s -> s.getId() == scooterID);
    }

    public List<EScooter> KritischeScooterAnzeigen() {
        // Minimal: alles, was aktuell nicht verfügbar ist, als "kritisch" anzeigen
        List<EScooter> result = new ArrayList<>();
        for (EScooter s : REGISTRY) {
            if (!s.istVerfuegbar()) {
                result.add(s);
            }
        }
        return result;
    }
}