import java.util.List;

/**
 * Der Flottenmanager hat hauptsächlich Überblick über die gesamte Flotte.
 * Er kann sich alle registrierten Scooter anzeigen lassen.
 */
public class FlottenManager extends Mitarbeiter {

    public FlottenManager(String id, String name, String vorname, String email, Anschrift anschrift) {
        super(id, name, vorname, email, anschrift);
    }

    public List<EScooter> alleScooterAnzeigen() {
        return EScooterRegistry.getAll();
    }
}

