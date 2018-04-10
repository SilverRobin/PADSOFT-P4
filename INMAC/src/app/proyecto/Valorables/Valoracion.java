package app.proyecto.Valorables;

import app.proyecto.Usuarios.Cliente;

/**
 * Clase que define el objeto Valoracion,
 * clase que consta de un valor y un Cliente Autor.
 * 
 * @author Antonio Oliva
 *
 */
public class Valoracion extends ElementoValorable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double valor;
	
	/**
	 * @param nV Nuevo valor
	 * @param nC Cliente
	 */
	public Valoracion(double nV, Cliente nC) {
		super(nC);
		valor = nV;
	}
	
	/**
	 * Obtiene el valor
	 * @return valor
	 */
	public double getValor() {
		return valor;
	}
	
	/**
	 * Cambia el valor
	 * @param nV valor
	 */
	public void setValor(double nV) {
		valor = nV;
		return;
	}

}
