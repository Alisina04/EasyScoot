import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Zentrale Verwaltung aller E-Scooter im System.
 * Die Registry ist als einfache In-Memory-Liste umgesetzt und stellt
 * Hilfsmethoden zum Hinzufügen, Entfernen und Abfragen bereit.
 */
public final class EScooterRegistry {

    private static final List<EScooter> SCOOTERS = new ArrayList<>();

    private EScooterRegistry() {
        // Utility-Klasse
    }

    /**
     * Fügt einen Scooter zur Registry hinzu. Existiert bereits ein Scooter
     * mit derselben ID, wird dieser zuvor entfernt.
     */
    public static void add(EScooter scooter) {
        SCOOTERS.removeIf(s -> s.getId() == scooter.getId());
        SCOOTERS.add(scooter);
    }

    /**
     * Entfernt einen Scooter anhand seiner ID.
     */
    public static void removeById(int id) {
        SCOOTERS.removeIf(s -> s.getId() == id);
    }

    /**
     * Liefert eine unveränderliche Liste aller Scooter.
     */
    public static List<EScooter> getAll() {
        return Collections.unmodifiableList(SCOOTERS);
    }

    /**
     * Gibt alle Scooter zurück, die aktuell verliehbar sind.
     */
    public static List<EScooter> getAllAvailable() {
        return SCOOTERS.stream()
                .filter(EScooter::istVerfuegbar)
                .collect(Collectors.toList());
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

