package app.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import app.gui.MainGUI;

/**
 * Controlador del boton de volver
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorVolver implements ActionListener{

	JPanel panel;
	
	/**
	 * Constructor del controlador
	 * @param panel Panel actual
	 */
	public ControladorVolver(JPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		CardLayout cl;
		MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(panel); //Obtenemos la ventana en la que esta contenido el panel
		ventana.volver();
		cl = (CardLayout) ventana.getIzquierda().getLayout();
		cl.show(ventana.getIzquierda(), ventana.getIName());
		cl = (CardLayout) ventana.getDerecha().getLayout();
		cl.show(ventana.getDerecha(), ventana.getDName());
		cl = (CardLayout) ventana.getCentro().getLayout();
		cl.show(ventana.getCentro(), ventana.getCName());
	}

}
