package app.proyecto.Valorables;

import java.util.ArrayList;
import java.util.List;

import app.proyecto.Usuarios.Cliente;

/**
 * Clase que define el objeto Comentario, que contiene
 * un Cliente autor, un texto, y un conjunto de valoraciones
 * y comentarios.
 * 
 * @author Antonio Oliva 
 *
 */
public class Comentario extends ElementoValorable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String texto;
	private List<ElementoValorable> valorables;
	
	/**
	 * @param nT Texto
	 * @param nC Cliente que realiza el comentario
	 */
	public Comentario(String nT, Cliente nC) {
		super(nC);
		texto = nT;
		valorables = new ArrayList<>();
	}
	
	/**
	 * Obtiene el texto
	 * @return texto
	 */
	public String getTexto() {
		return texto;
	}
	
	/**
	 * Cambia el texto
	 * @param nT Texto
	 */
	public void setTexto(String nT) {
		texto = nT;
		return;
	}
	
	/**
	 * Incluye un nuevo elemento valorable
	 * @param e elemento
	 */
	public void addValorable(ElementoValorable e) {
		valorables.add(e);
		return;
	}
	
	/**
	 * Obtiene los elementos valorables del comentario
	 * @return elementos valorables
	 */
	public List<ElementoValorable> getValorables(){
		return valorables;
	}
}
