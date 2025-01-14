package negocio.ssactividades.map;


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
    	Mapa map = new Mapa();
    	coordenada = coord;
    	direccion = map.obtenerDireccion(coord);
    }
    /**
     * Constructor
     * @param direc
     */
    public Lugar(String direc){
    	Mapa map = new Mapa();
    	coordenada = map.obtenerCoordenada(direc);
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
