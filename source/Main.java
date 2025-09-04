

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Anschrift dummy = new Anschrift("Musterstr", "1", "12345", "Musterstadt");
        ServiceMitarbeiter service = new ServiceMitarbeiter("s1", "Mustermann", "Max", "max@example.com", dummy);

        // Beispielhafte Scooter zur Registry hinzufügen
        service.ScooterHinzufuegen(new EScooter(1, new Position(52.52f, 13.40f), 80f,
                "Modell A", 500f, 20f, Fahrstatus.STEHEND, Leihstatus.VERFUEGBAR, Wartungsstatus.KEINE_WARTUNG));
        service.ScooterHinzufuegen(new EScooter(2, new Position(52.50f, 13.45f), 40f,
                "Modell B", 500f, 20f, Fahrstatus.STEHEND, Leihstatus.VERFUEGBAR, Wartungsstatus.KEINE_WARTUNG));

        Kunde kunde = new Kunde("Meier", "Hans", "hans@example.com", dummy);

        List<EScooter> verfuegbar = kunde.ScooterSuchen();
        System.out.println("Verfügbare Scooter: " + verfuegbar.size());
        for (EScooter s : verfuegbar) {
            System.out.println("Scooter " + s.getId() + " Ladestand: " + s.getLadestand());
        }

        List<EScooter> kritisch = service.KritischeScooterAnzeigen();
        System.out.println("Scooter mit Ladestand <= 50%: " + kritisch.size());
    }
}