/**
 * 
 */
package app.proyecto.Oferta;


import java.time.LocalDate;

import app.proyecto.Inmueble.Inmueble;

/**
 * Clase que comprueba el correcto funcionamiento de la clase Vacacional
 * 
 * @author Laura Ramirez
 *
 */
public class Vacacional extends Oferta {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate fechaFin;

	/**
	 * @param nP Precio
	 * @param nF Fianza
	 * @param nD Fecha de inicio
	 * @param fechaFin Fecha de fin
	 * @param in inmueble
	 */
	public Vacacional(int nP, int nF, LocalDate nD, LocalDate fechaFin, Inmueble in) {
		super(nP, nF, nD, in);
		this.fechaFin = fechaFin;
	}

	/**
	 * Establece la fecha de fin
	 * @param fecha nueva fecha de fin
	 */
	public void setFin(LocalDate fecha) {
		this.fechaFin = fecha;
		
	}
	/**
	 * Obtiene la fecha de fin
	 * @return la fecha de fin
	 */
	public LocalDate getFin() {
		return fechaFin;
	}
	
	/**
	 * Devuelve true si la fecha actual es posterior
	 * a la fecha de expiracion de la oferta
	 * 
	 * @return true si es posterior, false si no
	 */
	public boolean hasExpired() {
		
		if(fechaFin.isBefore(LocalDate.now()))
			return true;
		
		return false;
	}
	@Override
	public boolean isVacacional() {
		return true;
	}
	@Override
	public String toString() {
		return "[Vacacional] (Del "+ this.getInicio().toString() + " al " + this.getFin() + "). Fianza: " + this.getFianza() + "€. Precio: "+this.getPrecio() + "€";
	}
	
	@Override
	public double getComision() {
		return 0.02;
	}
}
