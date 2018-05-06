package app.proyecto.Inmueble;

import java.io.Serializable;

/**
 * @author Antonio Oliva
 *
 */
public class Direccion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoPostal;
	private String localidad;
	private String calle;
	
	/**
	 * @param codigoPostal codigo postal
	 * @param localidad localidad
	 * @param calle calle
	 */
	public Direccion(String codigoPostal, String localidad, String calle) {
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.calle = calle;
	}
	
	/**
	 * Obtiene el codigo postal
	 * @return CP
	 */
	public String getCP() {
		return codigoPostal;
	}
	
	/**
	 * Obtiene la localidad
	 * @return localidad
	 */
	public String getLocalidad() {
		return localidad;
	}
	
	/**
	 * Obtiene la calle
	 * @return calle
	 */
	public String getCalle() {
		return calle;
	}
	
	public static Direccion generarTestDir1() {
		return new Direccion("28040", "Madrid", "Fermines 13");
	}
	
	public static Direccion generarTestDir2() {
		return new Direccion("03700", "Denia", "Andrés Ponte 24");
	}
	
	/**
	 * Comprueba que es una direccion
	 * @return direccion
	 */
	public boolean isDireccion() {
		return this instanceof Direccion;
	}
	
	
	public boolean isEmpty() {
		if(this.codigoPostal.isEmpty() || this.calle.isEmpty() || this.localidad.isEmpty())
			return true;
		return false;
		
	}
	
	@Override
	public boolean equals (Object e) {
		
		if(!(e instanceof Direccion))
			return false;
		
		Direccion d = (Direccion) e;
		
		if(!(d.calle.equals(this.calle))
				|| !(d.codigoPostal.equals(this.codigoPostal))
				|| !(d.localidad.equals(this.localidad)))
			return false;
		
		return true;
	}
}
