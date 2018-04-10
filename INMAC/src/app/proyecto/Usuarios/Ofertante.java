/**
 * 
 */
package app.proyecto.Usuarios;

import java.io.Serializable;
import java.util.ArrayList;

import app.proyecto.Inmueble.Inmueble;

/**
 * @author Laura Ramirez
 *
 */
public class Ofertante implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Inmueble> inmuebles;


	public Ofertante() {
		// TODO Auto-generated constructor stub
		inmuebles = new ArrayList<Inmueble>();
	}
	
	/**
	 * Obtiene la lista de inmuebles
	 * @return inmuebles
	 */
	public ArrayList<Inmueble> getInmuebles() {
		return inmuebles;
	}
	/**
	 * Añade un nuevo inmueble
	 * @param inmueble nuevo
	 * @return true o false
	 */
	public boolean addInmueble(Inmueble inmueble) {
		return inmuebles.add(inmueble);
	}	

}
