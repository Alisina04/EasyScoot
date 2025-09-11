import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Eine Beispiel-Adresse
        Anschrift dummy = new Anschrift("Musterstr", "1", "12345", "Musterstadt");

        // Mitarbeiter und Manager
        ServiceMitarbeiter service = new ServiceMitarbeiter("s1", "Mustermann", "Max", "max@example.com", dummy);
        FlottenManager manager = new FlottenManager("f1", "Chef", "Carla", "carla@example.com", dummy);

        // Zwei Scooter erstellen
        EScooter scooter1 = new EScooter(1, new Position(52.52f, 13.40f), 80f,
                "Modell A", 500f, 20f, Fahrstatus.STEHEND, Leihstatus.VERFUEGBAR, Wartungsstatus.KEINE_WARTUNG);
        EScooter scooter2 = new EScooter(2, new Position(52.50f, 13.45f), 40f,
                "Modell B", 500f, 20f, Fahrstatus.STEHEND, Leihstatus.VERFUEGBAR, Wartungsstatus.KEINE_WARTUNG);

        // Ersten Scooter über den Service hinzufügen, zweiten direkt
        service.scooterHinzufuegen(scooter1);
        EScooterRegistry.add(scooter2);

        // Kurze Wartung über Service durchführen
        EScooterService.startWartung(scooter1);
        System.out.println("Scooter1 verfügbar in Wartung? " + EScooterService.istVerfuegbar(scooter1));
        EScooterService.beendeWartung(scooter1);

        // Alle Scooter anzeigen
        System.out.println("Alle Scooter: " + EScooterRegistry.getAll().size());
        List<EScooter> alleVomService = service.alleScooterSuchen();
        System.out.println("Alle Scooter laut Service: " + alleVomService.size());

        // Kunde sucht verfügbare Scooter (einfache Suche)
        Kunde kunde = new Kunde("Meier", "Hans", "hans@example.com", dummy);
        List<EScooter> verfuegbar = KundenService.scooterSuchen();
        System.out.println("Verfügbare Scooter: " + verfuegbar.size());

        // Kunde sucht mit Position, Radius und Mindestladestand
        List<EScooter> nah = KundenService.scooterSuchen(new Position(52.51f, 13.41f), 5f, 30f);
        System.out.println("Scooter in der Nähe: " + nah.size());

        // Scooter mit wenig Akku anzeigen
        List<EScooter> kritisch = service.kritischeScooterAnzeigen();
        System.out.println("Scooter mit <=50% Akku: " + kritisch.size());

        // Entfernung zwischen den beiden Scootern
        double dist = EScooterService.entfernungKmZu(scooter1, scooter2.getPosition());
        System.out.println("Abstand Scooter1 zu Scooter2: " + dist);

        // Wartung über Service starten und beenden
        service.wartungStarten(2);
        EScooter wartungsScooter = EScooterRegistry.findById(2);
        System.out.println("Scooter2 verfügbar nach Start? " + EScooterService.istVerfuegbar(wartungsScooter));
        service.wartungBeenden(2);
        System.out.println("Scooter2 verfügbar nach Ende? " + EScooterService.istVerfuegbar(wartungsScooter));

        // Fahrtsimulation
        Fahrt fahrt = FahrtService.startFahrt(kunde, 2);
        if (fahrt != null) {
            System.out.println("Fahrt gestartet mit Scooter2");
            FahrtService.beendeFahrt(fahrt, 2.0f, 4.0f);
            System.out.println("Fahrt beendet. Ladestand Scooter2: " + fahrt.getScooter().getLadestand());
        }

        // Kunde darf keinen reservierten Scooter buchen
        scooter1.setLeihstatus(Leihstatus.RESERVIERT);
        Fahrt reserviert = FahrtService.startFahrt(kunde, 1);
        System.out.println("Fahrt mit reserviertem Scooter möglich? " + (reserviert != null));

        // Einen Scooter entfernen
        service.scooterEntfernen(1);

        // Manager zeigt restliche Scooter
        List<EScooter> rest = manager.alleScooterAnzeigen();
        System.out.println("Übrige Scooter: " + rest.size());

        // Verfügbare Scooter direkt aus der Registry
        List<EScooter> verfuegbarAmEnde = EScooterRegistry.getAllAvailable();
        System.out.println("Verfügbare Scooter zum Schluss: " + verfuegbarAmEnde.size());
    }
}
