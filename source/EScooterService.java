public final class EScooterService {

    private EScooterService() {
        // Utility-Klasse
    }

    public static boolean istVerfuegbar(EScooter scooter) {
        return scooter.getLeihstatus() == Leihstatus.VERFUEGBAR
                && scooter.getWartungsstatus() == Wartungsstatus.KEINE_WARTUNG;
    }

    public static double entfernungKmZu(EScooter scooter, Position other) {
        if (scooter.getPosition() == null) return Double.POSITIVE_INFINITY;
        return GeoUtil.distanceKm(scooter.getPosition(), other);
    }

    public static void startWartung(EScooter scooter) {
        scooter.setWartungsstatus(Wartungsstatus.IN_WARTUNG);
        if (scooter.getLeihstatus() == Leihstatus.VERFUEGBAR) {
            scooter.setLeihstatus(Leihstatus.BLOCKIERT);
        }
    }

    public static void beendeWartung(EScooter scooter) {
        scooter.setWartungsstatus(Wartungsstatus.KEINE_WARTUNG);
        if (scooter.getLeihstatus() == Leihstatus.BLOCKIERT) {
            scooter.setLeihstatus(Leihstatus.VERFUEGBAR);
        }
    }
}
