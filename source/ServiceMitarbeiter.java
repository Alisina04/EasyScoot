import java.util.ArrayList;
import java.util.List;

public class ServiceMitarbeiter extends Mitarbeiter {

    public ServiceMitarbeiter(String id, String name, String vorname, String email, Anschrift anschrift) {
        super(id, name, vorname, email, anschrift);
    }

    public List<EScooter> AlleScooterSuchen() {
        return new ArrayList<>(EScooterRegistry.getAll());
    }

    public void WartungStarten(int scooterID) {
        EScooter scooter = EScooterRegistry.findById(scooterID);
        if (scooter != null) {
            scooter.startWartung();
        }
    }

    public void WartungBeenden(int scooterID) {
        EScooter scooter = EScooterRegistry.findById(scooterID);
        if (scooter != null) {
            scooter.beendeWartung();
        }
    }

    public void ScooterHinzufuegen(EScooter scooter) {
        EScooterRegistry.add(scooter);
    }

    public void ScooterEntfernen(int scooterID) {
        EScooterRegistry.removeById(scooterID);
    }

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