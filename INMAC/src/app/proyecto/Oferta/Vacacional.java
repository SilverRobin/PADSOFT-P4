/**
 * 
 */
package app.proyecto.Oferta;


import app.proyecto.Sistema.FechaSimulada;

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
	private FechaSimulada fechaFin;

	/**
	 * @param nP Precio
	 * @param nF Fianza
	 * @param nD Fecha de inicio
	 * @param fechaFin Fecha de fin
	 */
	public Vacacional(int nP, int nF, FechaSimulada nD, FechaSimulada fechaFin) {
		super(nP, nF, nD);
		this.fechaFin = fechaFin;
	}
	/* (non-Javadoc)
	 * @see Oferta.Oferta#modificarOferta(java.lang.String, int, Sistema.FechaSimulada)
	 */
	@Override
	public boolean modificarOferta(String dato, int precio, FechaSimulada fecha) {
		if(this.getVisibilidad() != EstadoOferta.A_MODIFICAR) {
			return false;
		}
		switch (dato.toLowerCase()) {
		case "fechainicio":
			this.setInicio(fecha);
			break;
		case "fechafin":
			this.setFin(fecha);
			break;
		case "fianza":
			this.setFianza(precio);
			break;
		case "precio":
			this.setPrecio(precio);
			break;
		default:
			return false;
		}
		return true;
		
	}
	/**
	 * Establece la fecha de fin
	 * @param fecha nueva fecha de fin
	 */
	public void setFin(FechaSimulada fecha) {
		this.fechaFin = fecha;
		
	}
	/**
	 * Obtiene la fecha de fin
	 * @return la fecha de fin
	 */
	public FechaSimulada getFin() {
		return fechaFin;
	}
	

}
