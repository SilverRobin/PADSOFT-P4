/**
 * 
 */
package app.proyecto.Usuarios;

import java.io.Serializable;
import java.time.LocalDate;
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
	private List<Aviso> rects;


	public Ofertante() {
		inmuebles = new ArrayList<>();
		rects = new ArrayList<>();
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
	
	public List<Aviso> getRects(){
		return rects;
	}

	public void addRect(String rect) {
		rects.add(new Aviso(rect, LocalDate.now()));
		return;
	}

	public void removeRect(Aviso a) {
		rects.remove(a);
	}	

}
