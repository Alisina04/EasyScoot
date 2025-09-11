public final class EScooterService {

    private EScooterService() {
        // Utility-Klasse
    }

    /**
     * Prüft, ob der Scooter ausgeliehen werden darf.
     */
    public static boolean istVerfuegbar(EScooter scooter) {
        return scooter.getLeihstatus() == Leihstatus.VERFUEGBAR
                && scooter.getWartungsstatus() == Wartungsstatus.KEINE_WARTUNG;
    }

    /**
     * Berechnet die Entfernung in Kilometern zu einem anderen Punkt.
     */
    public static double entfernungKmZu(EScooter scooter, Position other) {
        if (scooter.getPosition() == null) return Double.POSITIVE_INFINITY;
        return GeoUtil.distanceKm(scooter.getPosition(), other);
    }

    /**
     * Setzt den Scooter in den Wartungsmodus.
     */
    public static void startWartung(EScooter scooter) {
        scooter.setWartungsstatus(Wartungsstatus.IN_WARTUNG);
        if (scooter.getLeihstatus() == Leihstatus.VERFUEGBAR) {
            scooter.setLeihstatus(Leihstatus.BLOCKIERT);
        }
    }

    /**
     * Beendet den Wartungsmodus.
     */
    public static void beendeWartung(EScooter scooter) {
        scooter.setWartungsstatus(Wartungsstatus.KEINE_WARTUNG);
        if (scooter.getLeihstatus() == Leihstatus.BLOCKIERT) {
            scooter.setLeihstatus(Leihstatus.VERFUEGBAR);
        }
    }
}
