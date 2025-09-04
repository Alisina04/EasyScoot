import java.util.ArrayList;
import java.util.List;

public class ServiceMitarbeiter extends Mitarbeiter {

    public ServiceMitarbeiter(String id, String name, String vorname, String email, Anschrift anschrift) {
        super(id, name, vorname, email, anschrift);
    }

    // Gibt alle Scooter zurück
    public List<EScooter> AlleScooterSuchen() {
        return new ArrayList<>(EScooterRegistry.getAll());
    }

    // Startet eine Wartung für einen Scooter
    public void WartungStarten(int scooterID) {
        EScooter scooter = EScooterRegistry.findById(scooterID);
        if (scooter != null) {
            scooter.startWartung();
        }
    }

    // Beendet eine laufende Wartung
    public void WartungBeenden(int scooterID) {
        EScooter scooter = EScooterRegistry.findById(scooterID);
        if (scooter != null) {
            scooter.beendeWartung();
        }
    }

    // Fügt einen neuen Scooter hinzu
    public void ScooterHinzufuegen(EScooter scooter) {
        EScooterRegistry.add(scooter);
    }

    // Entfernt einen Scooter über seine ID
    public void ScooterEntfernen(int scooterID) {
        EScooterRegistry.removeById(scooterID);
    }

    // Zeigt Scooter mit einem Ladestand unter oder gleich 50%
    public List<EScooter> KritischeScooterAnzeigen() {
        List<EScooter> result = new ArrayList<>();
        for (EScooter s : EScooterRegistry.getAll()) {
            Float ladestand = s.getLadestand();
            if (ladestand != null && ladestand <= 50f) {
                result.add(s);
            }
        }
        return result;
    }
}