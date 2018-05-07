package app.Controlador;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.gui.Vista.GTarjetaMScreen;

/**
 * Controlador de cliente seleccionado
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorClienteSelected implements ListSelectionListener{

	private GTarjetaMScreen ms;
	
	/**
	 * Constructor del controlador
	 * @param ms Panel de tarjeta de gerente central
	 */
	public ControladorClienteSelected(GTarjetaMScreen ms) {
		this.ms = ms;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		ms.refresh();
		return;
	}

}
