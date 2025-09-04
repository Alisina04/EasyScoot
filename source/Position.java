public class Position {
    public float lat;
    public float lng;

    public Position(float lat, float lng) {
        this.lat = lat;
        this.lng = lng;
    }

    // Haversine-Entfernung in Kilometern
    public double distanceKm(Position other) {
        if (other == null) return Double.POSITIVE_INFINITY;
        final double R = 6371.0088; // Erdradius in km (mittlerer)
        double lat1 = Math.toRadians(this.lat);
        double lat2 = Math.toRadians(other.lat);
        double dLat = Math.toRadians(other.lat - this.lat);
        double dLon = Math.toRadians(other.lng - this.lng);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}