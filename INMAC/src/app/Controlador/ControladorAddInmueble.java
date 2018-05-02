/**
 * 
 */
package app.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import app.gui.MainGUI;
import app.gui.Vista.AddInmuebleScreen;
import app.gui.Vista.OfertanteMScreen;
import app.proyecto.Sistema.Sistema;

/**
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorAddInmueble implements ActionListener {
	private OfertanteMScreen oms;
	private Sistema app;
	/**
	 * 
	 */
	public ControladorAddInmueble(Sistema app, OfertanteMScreen oms) {
		this.oms = oms;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		CardLayout cl;
		MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(oms); //Obtenemos la ventana en la que esta contenido el panel
		//Nueva vista de añadir inmueble
		ventana.getIzquierda().setVisible(false);
		ventana.getDerecha().setVisible(false);
		ventana.cambiaCentro(new AddInmuebleScreen(app), "AddInmuebleScreen");
		cl = (CardLayout) ventana.getCentro().getLayout();
		cl.show(ventana.getCentro(), "AddInmuebleScreen");
		//ventana.cambiaIzquierda(ols, "OLS"); //Cambiamos pantalla izquierda para ofertante
		//cl = (CardLayout) ventana.getIzquierda().getLayout();
		//cl.show(ventana.getIzquierda(), "OLS");
		//
		
	}

}
