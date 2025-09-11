import java.util.ArrayList;
import java.util.List;

public final class KundenService {

    private KundenService() {
        // Utility-Klasse
    }

    public static List<EScooter> scooterSuchen() {
        return EScooterRegistry.getAllAvailable();
    }

    public static List<EScooter> scooterSuchen(Position zentrum, float maxDistanzKm, float minLadestandProzent) {
        List<EScooter> alle = EScooterRegistry.getAllAvailable();
        List<EScooter> result = new ArrayList<>();

        if (zentrum == null) {
            for (EScooter s : alle) {
                Float ladestand = s.getLadestand();
                if (ladestand != null && ladestand >= minLadestandProzent) {
                    result.add(s);
                }
            }
            return result;
        }

        for (EScooter s : alle) {
            if (s.getPosition() == null) continue;
            double dist = EScooterService.entfernungKmZu(s, zentrum);
            Float ladestand = s.getLadestand();
            if (dist <= maxDistanzKm && ladestand != null && ladestand >= minLadestandProzent) {
                result.add(s);
            }
        }
        return result;
    }
}
