import java.time.LocalDateTime;

public final class FahrtService {

    private FahrtService() {
        // Utility-Klasse
    }

    public static Fahrt startFahrt(Kunde kunde, int scooterId) {
        EScooter scooter = EScooterRegistry.findById(scooterId);
        if (scooter == null) {
            return null;
        }
        if (scooter.getLeihstatus() != Leihstatus.VERFUEGBAR) {
            return null;
        }
        scooter.setLeihstatus(Leihstatus.VERLIEHEN);
        scooter.setFahrstatus(Fahrstatus.IN_BETRIEB);
        return new Fahrt(kunde, scooter, LocalDateTime.now(), null, null, null, null);
    }

    public static void beendeFahrt(Fahrt fahrt, float streckeKm, float preis) {
        if (fahrt == null) return;
        fahrt.setEndZiel(LocalDateTime.now());
        fahrt.setStrecke(streckeKm);
        EScooter scooter = fahrt.getScooter();
        Float verbrauch = null;
        if (scooter.getVerbrauchskoeffizienten() != null) {
            verbrauch = streckeKm * scooter.getVerbrauchskoeffizienten();
        }
        fahrt.setVerbrauch(verbrauch);
        fahrt.setPreis(preis);
        scooter.setLeihstatus(Leihstatus.VERFUEGBAR);
        scooter.setFahrstatus(Fahrstatus.STEHEND);
        if (verbrauch != null && scooter.getBatteriekapazitaet() != null && scooter.getLadestand() != null) {
            float newLadestand = scooter.getLadestand() - (verbrauch / scooter.getBatteriekapazitaet()) * 100f;
            scooter.setLadestand(Math.max(0f, newLadestand));
        }
    }
}
