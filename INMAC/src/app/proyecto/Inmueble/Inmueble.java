package app.proyecto.Inmueble;

import java.util.ArrayList;
import java.util.List;

import app.proyecto.Oferta.EstadoOferta;
import app.proyecto.Oferta.Oferta;

/**
 * 
 * @author Antonio Oliva
 *
 */
public class Inmueble {
	
	private static int GLOBAL_ID = 0;

	private String descripcion;
	private int id;
	private List<Caracteristica> caracteristicas;
	private Direccion direccion;
	private ArrayList<Oferta> ofertas;
	
	/**
	 * @param nD Descripcion
	 * @param nDir Direccion
	 */
	public Inmueble(String nD, Direccion nDir) {
		this.descripcion = nD;
		this.id = GLOBAL_ID+1;
		GLOBAL_ID++;
		this.caracteristicas = new ArrayList<>();
		this.direccion = nDir;
		this.ofertas = new ArrayList<Oferta>();
	}
	
	/**
	 * Obtiene el id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Obtiene las ofertas
	 * @return ofertas
	 */
	public ArrayList<Oferta> getOfertas() {
		return ofertas;
	}
	
	/**
	 * Obtiene las ofertas disponibles
	 * @return lista de ofertas disponibles
	 */
	public ArrayList<Oferta> getDisponibles(){
		ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
		for(Oferta o : this.ofertas) {
			if(o.getVisibilidad() == EstadoOferta.DISPONIBLE) {
				ofertas.add(o);
			}
		}
		return ofertas;
	}

	/**
	 * Obtiene la descripcion
	 * @return descripcion
	 */
	public String getDesc() {
		return descripcion;
	}
	
	/**
	 * Obtiene la direccion
	 * @return direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}
	
	/**
	 * Obtiene las caracteristicas
	 * @return caracteristicas
	 */
	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}
	
	/**
	 * Obtiene la descripcion
	 * @param nD Descripcion
	 */
	public void setDesc(String nD) {
		descripcion = nD;
		return;
	}
	
	/**
	 * Incluye una nueva caracteristica
	 * @param nC Caracteristica
	 */
	public void addCaracteristica(Caracteristica nC) {
		caracteristicas.add(nC);
		return;
	}
	
	/**
	 * Borra una caracteristica
	 * @param nC caracteristica
	 */
	public void deleteCaracteristica(Caracteristica nC) {
		caracteristicas.remove(nC);
		return;
	}
	
	/**
	 * Indica si es inmueble
	 * @return true o false
	 */
	public boolean isInmueble() {
		return this instanceof Inmueble;
	}
	
	/**
	 * Incluye una nueva oferta
	 * @param e oferta
	 * @return true o false
	 */
	public boolean addOferta(Oferta e) {
		
		return ofertas.add(e);
	}
	
}
