package app.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.gui.Vista.GerenteMScreen;
import app.proyecto.Oferta.Oferta;

/**
 * 
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorAprobarOferta implements ActionListener{

	private GerenteMScreen ls;
	
	public ControladorAprobarOferta(GerenteMScreen panel) {
		this.ls = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Oferta of = ls.getSelected();
		if(of == null)
			return;
		of.aprobarOferta();
		ls.deleteSelected();
		return;
	}

}
