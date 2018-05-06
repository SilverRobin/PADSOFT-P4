package app.Controlador;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.gui.Vista.GTarjetaMScreen;

public class ControladorClienteSelected implements ListSelectionListener{

	private GTarjetaMScreen ms;
	
	public ControladorClienteSelected(GTarjetaMScreen ms) {
		this.ms = ms;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		ms.refresh();
		return;
	}

}
