package app.proyecto.Oferta;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Valorables.ElementoValorable;
import app.proyecto.Valorables.Valoracion;

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
	private String descripcion;
	private LocalDate fechaInicio;
	private EstadoOferta visibilidad;
	private List<ElementoValorable> valorables;
	private String rectificacion;
	private Inmueble in;
	

	/**
	 * @param nP Precio
	 * @param nF Fianza
	 * @param nD Fecha 
	 * @param nI inmueble
	 */
	public Oferta (int nP, int nF, LocalDate nD, Inmueble nI) {
		this.precio = nP;
		this.fianza = nF;
		this.fechaInicio = nD;
		visibilidad = EstadoOferta.NO_APROBADA;
		valorables = new ArrayList<>();
		rectificacion = null;
		in = nI;
	}
	
	/**
	 * Obtiene el precio
	 * @return precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Devuelve el inmueble que hace esta oferta
	 * @return Inmueble padre
	 */
	public Inmueble getInmueble() {
		return in;
	}
	
	/**
	 * Asigna un nuevo mensaje de rectificacion
	 * @param nR Mensaje a asignar
	 */
	public void setRectificacion(String nR) {
		rectificacion = nR;
		return;
	}
	
	/**
	 * Devuelve el mensaje de rectificacion, si lo hay
	 * @return Mensaje de rectificacion
	 */
	public String getRectificacion() {
		return rectificacion;
	}
	
	
	/** 
	 * Obtiene la lista de comentarios y valoraciones de la oferta
	 * @return Comentarios y valoraciones
	 */
	public List<ElementoValorable> getValorables(){
		return valorables;
	}
	
	/**
	 * Añade un nuevo comentario o valoracion a la oferta
	 * 
	 * @param v Comentario o valoracion
	 * @return true si lo añade, false si no
	 */
	public boolean addValorable(ElementoValorable v) {
		return valorables.add(v);
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
	public LocalDate getInicio() {
		return fechaInicio;
	}
	/**
	 * Establece la fecha de inicio
	 * @param fecha nueva fecha
	 */
	public void setInicio(LocalDate fecha) {
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
	
	public void setDescripcion(String s) {
		this.descripcion = s;
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
		
		int suma = 0, counter=0;
		
		for(ElementoValorable e : valorables) {
			if(!e.isComentario()) {
				counter++;
				suma += ((Valoracion) e).getValor();
			}
		}
		if(counter == 0)
			return 0;
		
		return suma/counter;
	}
	
	public abstract boolean isVacacional();
	
	/**
	 * Modifica parametros de una oferta
	 */
	public void modificarOferta() {
		rectificacion = "";
		visibilidad =EstadoOferta.NO_APROBADA;
		
	}
	
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
	
	/**
	 * Devuelve false salvo que se trate de una oferta vacacional
	 * 
	 * @return false
	 */
	public boolean hasExpired() {
		return false;
	}
	
	public static Oferta generarOfertaTest() {
		return new Vacacional(400, 30, LocalDate.now(), LocalDate.now(), Inmueble.generarInmuebleTest());
	}
	
	public abstract double getComision();

	@Override
	public String toString() {
		if(rectificacion.equals(""))
			return this.descripcion + "		"+ this.precio + " €";
		return "(R)" + rectificacion;
	}
	
}
