package proyecto.Oferta;

import java.io.Serializable;
import java.util.ArrayList;

import proyecto.Sistema.FechaSimulada;
import proyecto.valorables.Valoracion;

/**
 * 
 * @author Antonio Oliva
 *
 */
public abstract class Oferta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int precio;
	private int fianza;
	private FechaSimulada fechaInicio;
	private EstadoOferta visibilidad;
	private ArrayList<Valoracion> valoraciones;
	
	/**
	 * @param nP Precio
	 * @param nF Fianza
	 * @param nD Fecha
	 */
	public Oferta (int nP, int nF, FechaSimulada nD) {
		this.precio = nP;
		this.fianza = nF;
		this.fechaInicio = nD;
		visibilidad = EstadoOferta.NO_APROBADA;
		valoraciones = new ArrayList<Valoracion>();
	}
	
	/**
	 * Obtiene el precio
	 * @return precio
	 */
	public int getPrecio() {
		return precio;
	}
	
	
	/** 
	 * Obtiene la lista de valoraciones de la oferta
	 * @return valoraciones
	 */
	public ArrayList<Valoracion> getValoraciones(){
		return valoraciones;
	}
	
	/**
	 * Añade una nueva valoracion
	 * @param v valoracion
	 * @return true si lo ha añadido bien
	 */
	public boolean addValoracion(Valoracion v) {
		return valoraciones.add(v);
	}
	
	/**
	 * Obtiene la visibilidad
	 * @return visibilidad
	 */
	public EstadoOferta getVisibilidad() {
		return visibilidad;
	}
	
	/**
	 * Obtiene la fianza
	 * @return fianza
	 */
	public int getFianza() {
		return fianza;
	}
	
	/**
	 * Obtiene la fecha de inicio
	 * @return fecha de inicio
	 */
	public FechaSimulada getInicio() {
		return fechaInicio;
	}
	/**
	 * Establece la fecha de inicio
	 * @param fecha nueva fecha
	 */
	public void setInicio(FechaSimulada fecha) {
		this.fechaInicio = fecha;
	}
	
	/**
	 * Establece el precio
	 * @param nP nuevo precio
	 */
	public void setPrecio(int nP) {
		this.precio = nP;
		return;
	}
	
	/**
	 * Establece la fiaza
	 * @param nF nueva fianza
	 */
	public void setFianza(int nF) {
		this.fianza = nF;
		return;
	}
	
	/**
	 * Nos dice si es oferta
	 * @return true o false
	 */
	public boolean isOferta() {
		return this instanceof Oferta;
	}
	
	/**
	 * Aprueba una oferta
	 */
	public void aprobarOferta() {
		this.visibilidad = EstadoOferta.DISPONIBLE;
	}
	
	/**
	 * Calcula la media de las valoraciones
	 * @return media de valoraciones
	 */
	public double calcularMediaValoraciones() {
		int i, suma = 0;
		for(i=0; i<valoraciones.size(); i++) {
			suma += valoraciones.get(i).getValor();
		}
		return suma/valoraciones.size();
	}
	
	/**
	 * Modifica parametros de una oferta
	 * @param dato a cambiar
	 * @param precio nuevo o 0 si no se va a cambiar
	 * @param fecha nueva o null si no se va a cambiar
	 * @return true o false
	 */
	public abstract boolean modificarOferta(String dato, int precio, FechaSimulada fecha);
	
	/**
	 * Reserva una oferta
	 */
	public void reservar() {
		visibilidad = EstadoOferta.RESERVADA;
		
	}
	/**
	 * Contrata una oferta
	 */
	public void contratar() {
		visibilidad = EstadoOferta.CONTRATADA;
	}
	/**
	 * Cancela una oferta
	 */
	public void cancelar() {
		visibilidad = EstadoOferta.DISPONIBLE;
	}
	/**
	 * Pide la rectificacion de una oferta
	 */
	public void rectificar() {
		visibilidad = EstadoOferta.A_MODIFICAR;
	}
}
