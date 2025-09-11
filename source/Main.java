import java.util.List;

public class Main {
    /**
     * Startpunkt der kleinen Simulation.
     */
    public static void main(String[] args) {
        System.out.println("=== EasyScoot Simulation ===");

        Anschrift dummy = new Anschrift("Musterstr", "1", "12345", "Musterstadt");

        ServiceMitarbeiter service = new ServiceMitarbeiter("s1", "Mustermann", "Max", "max@example.com", dummy);
        FlottenManager manager = new FlottenManager("f1", "Chef", "Carla", "carla@example.com", dummy);

        EScooter scooter1 = new EScooter(1, new Position(52.52f, 13.40f), 80f,
                "Modell A", 500f, 20f, Fahrstatus.STEHEND, Leihstatus.VERFUEGBAR, Wartungsstatus.KEINE_WARTUNG);
        EScooter scooter2 = new EScooter(2, new Position(52.50f, 13.45f), 40f,
                "Modell B", 500f, 20f, Fahrstatus.STEHEND, Leihstatus.VERFUEGBAR, Wartungsstatus.KEINE_WARTUNG);

        service.scooterHinzufuegen(scooter1);
        EScooterRegistry.add(scooter2);

        System.out.println("\n--- Wartung testen ---");
        EScooterService.startWartung(scooter1);
        System.out.println("Scooter1 verfügbar? " + EScooterService.istVerfuegbar(scooter1));
        EScooterService.beendeWartung(scooter1);
        System.out.println("Scooter1 verfügbar nach Wartung? " + EScooterService.istVerfuegbar(scooter1));

        System.out.println("\n--- Alle Scooter anzeigen ---");
        System.out.println("Alle Scooter: " + EScooterRegistry.getAll().size());
        System.out.println("Alle Scooter laut Service: " + service.alleScooterSuchen().size());

        System.out.println("\n--- Kundensuche ---");
        Kunde kunde = new Kunde("Meier", "Hans", "hans@example.com", dummy);
        List<EScooter> verfuegbar = KundenService.scooterSuchen();
        System.out.println("Verfügbare Scooter: " + verfuegbar.size());
        List<EScooter> nah = KundenService.scooterSuchen(new Position(52.51f, 13.41f), 5f, 30f);
        System.out.println("Scooter in der Nähe: "+ nah.size());

        System.out.println("\n--- Scooter mit wenig Akku ---");
        System.out.println("Scooter mit <=50% Akku: " + service.kritischeScooterAnzeigen().size());

        System.out.println("\n--- Entfernung berechnen ---");
        double dist = EScooterService.entfernungKmZu(scooter1, scooter2.getPosition());
        System.out.println("Abstand Scooter1 zu Scooter2: " + dist + " km");

        System.out.println("\n--- Wartung über Service ---");
        service.wartungStarten(2);
        EScooter wartungsScooter = EScooterRegistry.findById(2);
        System.out.println("Scooter2 verfügbar nach Start? " + EScooterService.istVerfuegbar(wartungsScooter));
        service.wartungBeenden(2);
        System.out.println("Scooter2 verfügbar nach Ende? " + EScooterService.istVerfuegbar(wartungsScooter));

        System.out.println("\n--- Fahrtsimulation ---");
        Fahrt fahrt = FahrtService.startFahrt(kunde, 2);
        System.out.println("Fahrt mit Scooter2 gestartet: " + (fahrt != null));
        Fahrt fahrtZwei = FahrtService.startFahrt(kunde, 2);
        System.out.println("Zweite Fahrt gleichzeitig möglich? " + (fahrtZwei != null));
        FahrtService.beendeFahrt(fahrt, 2.0f, 4.0f);
        System.out.println("Fahrt beendet. Strecke: " + fahrt.getStrecke() + " km, Verbrauch: " + fahrt.getVerbrauch() + " Wh, Preis: " + fahrt.getPreis() + " EUR");

        System.out.println("\n--- Reservierten Scooter testen ---");
        scooter1.setLeihstatus(Leihstatus.RESERVIERT);
        Fahrt reserviert = FahrtService.startFahrt(kunde, 1);
        System.out.println("Fahrt mit reserviertem Scooter möglich? " + (reserviert != null));

        System.out.println("\n--- Scooter entfernen ---");
        service.scooterEntfernen(1);
        System.out.println("Übrige Scooter laut Manager: " + manager.alleScooterAnzeigen().size());
        System.out.println("Verfügbare Scooter zum Schluss: " + EScooterRegistry.getAllAvailable().size());

        System.out.println("\n=== Ende der Simulation ===");
    }
}
