/**
 * 
 */
package app.Controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.gui.MainGUI;
import app.gui.Vista.OfertanteLScreen;
import app.gui.Vista.OfertanteMScreen;
import app.gui.Vista.OfertanteRScreen;
import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Sistema.Sistema;

/**
 * Controlador de lista de ofertante
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorListaOL implements ListSelectionListener {
	private OfertanteLScreen panel;
	private Sistema app;


	/**
	 * @param panel Panel izquierdo de ofertante
	 * @param app Aplicacion del sistema
	 */
	public ControladorListaOL(OfertanteLScreen panel, Sistema app) {
		this.panel = panel;
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.
	 * ListSelectionEvent)
	 */
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(panel);
		Inmueble i = (Inmueble) panel.getLista().getSelectedValue();
		((OfertanteRScreen) ventana.getCurrentCardR()).cleanList();
		if(i.getOfertas().isEmpty() == false) {
			((OfertanteRScreen) ventana.getCurrentCardR()).addOfertas((ArrayList<Oferta>) i.getOfertas());
		}
		if (ventana.getCurrentCardC() instanceof OfertanteMScreen)
			((OfertanteMScreen) ventana.getCurrentCardC()).getAddOferta().setEnabled(true);

	}

}
