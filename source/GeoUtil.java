public final class GeoUtil {

    private GeoUtil() {
        // Utility-Klasse
    }

    public static double distanceKm(Position p1, Position p2) {
        if (p1 == null || p2 == null) return Double.POSITIVE_INFINITY;
        final double R = 6371.0088; // Erdradius in km (mittlerer)
        double lat1 = Math.toRadians(p1.lat);
        double lat2 = Math.toRadians(p2.lat);
        double dLat = Math.toRadians(p2.lat - p1.lat);
        double dLon = Math.toRadians(p2.lng - p1.lng);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
