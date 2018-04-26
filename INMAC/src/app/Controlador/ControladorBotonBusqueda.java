/**
 * 
 */
package app.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.gui.Vista.SearchScreen;
import app.proyecto.Sistema.Sistema;

/**
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorBotonBusqueda implements ActionListener {
	private SearchScreen panel;
	private Sistema app;
	/**
	 * 
	 */
	public ControladorBotonBusqueda(Sistema app, SearchScreen panel) {
		this.app = app;
		this.panel = panel;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//TODO Wow very POO such work
		//Comprobar codigo postal
		//Comprobar fecha inicio
		//Comprobar fecha fin
		//Comprobar tipo de estancia (Si esta logueado)
		//Comprobar valoracion
		
		//Mostrar resultados en la pantalla central

	}

}
