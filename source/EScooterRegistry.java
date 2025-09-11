import java.util.ArrayList;

import java.util.List;

/**
 * Eine sehr einfache zentrale Liste für alle Scooter.
 * Hier wird nichts mit Datenbanken gemacht, sondern nur mit einer Liste.
 */
public final class EScooterRegistry {

    // Hier liegen alle Scooter drin

  
    private static final List<EScooter> SCOOTERS = new ArrayList<>();

    private EScooterRegistry() {
        // Utility-Klasse
    }

    /**
     * Falls die ID schon existiert, wird der alte Scooter gelöscht.
     */
    public static void add(EScooter scooter) {
        for (int i = 0; i < SCOOTERS.size(); i++) {
            if (SCOOTERS.get(i).getId() == scooter.getId()) {
                SCOOTERS.remove(i);
                break;
            }
        }

        SCOOTERS.add(scooter);
    }

    /**
     * Entfernt einen Scooter über seine ID.
     */
    public static void removeById(int id) {
        for (int i = 0; i < SCOOTERS.size(); i++) {
            if (SCOOTERS.get(i).getId() == id) {
                SCOOTERS.remove(i);
                break;
            }
        }
    }

    /**
     * Gibt eine neue Liste mit allen Scootern zurück.
     */
    public static List<EScooter> getAll() {
        return new ArrayList<>(SCOOTERS);
    }

    /**
     * Sucht alle Scooter, die gerade ausgeliehen werden können.
     */
    public static List<EScooter> getAllAvailable() {
        List<EScooter> result = new ArrayList<>();
        for (EScooter s : SCOOTERS) {
            if (EScooterService.istVerfuegbar(s)) {
                result.add(s);
            }
        }
        return result;
    }

    /**
     * Sucht einen Scooter anhand seiner ID.
     */
    public static EScooter findById(int id) {
        for (EScooter scooter : SCOOTERS) {
            if (scooter.getId() == id) {
                return scooter;
            }
        }
        return null;
    }
}

