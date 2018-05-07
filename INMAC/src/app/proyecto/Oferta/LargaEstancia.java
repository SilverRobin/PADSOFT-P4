/**
 * 
 */
package app.proyecto.Oferta;

import java.time.LocalDate;

import app.proyecto.Inmueble.Inmueble;

/**
 * @author Laura Ramirez
 *
 */
public class LargaEstancia extends Oferta {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int minimaEstancia; 
	/**
	 * @param nP Precio
	 * @param nF Fianza
	 * @param nD Fecha de inicio
	 * @param minimaEstancia meses de estancia
	 * @param in inmueble
	 */
	public LargaEstancia(int nP, int nF, LocalDate nD, int minimaEstancia, Inmueble in) {
		super(nP, nF, nD, in);
		this.minimaEstancia = minimaEstancia;
	}



	/**
	 * Obtiene los meses de estancia
	 * @return los meses de estancia
	 */
	public int getMinimaEstancia() {
		return minimaEstancia;
	}

	/**
	 * Cambia los meses de estancia
	 * @param minimaEstancia meses minimos de estancia
	 */
	public void setMinimaEstancia(int minimaEstancia) {
		this.minimaEstancia = minimaEstancia;
	}

	@Override
	public boolean isVacacional() {
		return false;
	}

	@Override
	public String toString() {
		return "[Larga Estancia] " + this.getMinimaEstancia() + " meses. " + "Fianza: " + getFianza() + "€. Precio: " + getPrecio() + "€";
	}
	
	@Override
	public double getComision() {
		return 0.005;
	}

}
