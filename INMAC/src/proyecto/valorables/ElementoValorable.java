package proyecto.valorables;

import java.io.Serializable;

import proyecto.Usuarios.Cliente;

/**
 * Clase abstracta que define el objeto ElementoValorable,
 * que esta compuesta de un cliente autor.
 * 
 * @author Antonio Oliva
 *
 */
public abstract class ElementoValorable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente autor;
	
	/**
	 * @param nC Cliente
	 */
	public ElementoValorable(Cliente nC) {
		autor = nC;
	}
	
	/**
	 * Obtiene el autor
	 * @return autor
	 */
	public Cliente getAutor() {
		return autor;
	}
	
	/**
	 * Cambia el autor
	 * @param nC nuevo autor
	 */
	public void setAutor(Cliente nC) {
		autor = nC;
		return;
	}
}
