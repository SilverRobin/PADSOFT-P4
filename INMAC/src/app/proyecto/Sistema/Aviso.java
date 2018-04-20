package app.proyecto.Sistema;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 
 * @author Laura Ramírez
 *
 */
public class Aviso implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String texto;
	private LocalDate fecha;
	
	
	/**
	 * @param texto texto
	 * @param fecha fecha de emision
	 */
	public Aviso(String texto, LocalDate fecha) {
		this.texto = texto;
		this.fecha = fecha;
	}
	
	/**
	 * Obtiene el texto
	 * @return texto
	 */
	public String getTexto() {
		return texto;
	}
	
	/**
	 * Obtiene la fecha
	 * @return fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return texto + ". Enviado el " + fecha;
		
	}
	
	
	
}
