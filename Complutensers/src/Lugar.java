
/**
 * 
 * @author Ariadna
 * @version 1.0
 */
public class Lugar {
    private String direccion;
    private Coordenada coordenada;
    
    /**
     * Constructor
     * @param coord
     * @param direc
     */
    public Lugar(Coordenada coord, String direc){
    	coordenada = coord;
    	direccion = direc;
    }
    /**
     * Constructor
     * @param coord
     */
    public Lugar(Coordenada coord){
    	coordenada = coord;
    	//The address could be obtained through a map
    	direccion = null;
    }
    /**
     * Constructor
     * @param direc
     */
    public Lugar(String direc){
    	//The coordinates could be obtained through a map
    	coordenada = null;
    	direccion = direc;
    }
    /**
     * @return coordinate of the place.
     */
    public Coordenada getCoordenadas(){
    	return coordenada;
    }
    /**
     * @return address of the place.
     */
    public String getDireccion(){
    	return direccion;
    }
    /**
     * Sets the latitude and the longitude of the place.
     * @param lat
     * @param longit
     */
    public void modificarCoordenadas(double lat, double longit) {
    	coordenada.modificarLatitud(lat);
    	coordenada.modificarLongitud(longit);
    }
    /**
     * Modifies the address of the place.
     * @param direc
     */
    public void modificarDireccion(String direc){
    	direccion = direc;
    }
}
