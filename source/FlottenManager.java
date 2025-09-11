import java.util.List;

/**
 * Der Flottenmanager hat Überblick über die gesamte Flotte.
 */
public class FlottenManager extends Mitarbeiter {

    public FlottenManager(String id, String name, String vorname, String email, Anschrift anschrift) {
        super(id, name, vorname, email, anschrift);
    }

    /**
     * Gibt alle registrierten Scooter zurück.
     */
    public List<EScooter> alleScooterAnzeigen() {
        return EScooterRegistry.getAll();
    }
}
