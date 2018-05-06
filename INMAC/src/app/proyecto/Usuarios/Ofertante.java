/**
 * 
 */
package app.proyecto.Usuarios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Sistema.Aviso;

/**
 * @author Laura Ramirez
 *
 */
public class Ofertante implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Inmueble> inmuebles;


	public Ofertante() {
		inmuebles = new ArrayList<>();
	}
	
	/**
	 * Obtiene la lista de inmuebles
	 * @return inmuebles
	 */
	public List<Inmueble> getInmuebles() {
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
