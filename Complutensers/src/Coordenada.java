/**
 * 
 * @author Ariadna
 * @version 1.0
 */
public class Coordenada {
	private  double latitud;
    private double longitud;
    /**
     * Modifies the latitude of the place.
     * @param lat
     */
    public void modificarLatitud(double lat) {
    	latitud = lat;
    }
    /**
     * Modifies the longitude of the place.
     * @param longit
     */
    public void modificarLongitud(double longit){
    	longitud = longit;
    }
    /**
     * @return latitude of the place.
     */
    public double getLatitud(){
    	return latitud;
    }
    /**
     * @return longitude of the place.
     */
    public double getLongitud(){
    	return longitud;
    }
}
