package app.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import app.gui.MainGUI;
import app.gui.Vista.DOfertaLScreen;
import app.gui.Vista.DOfertaMScreen;
import app.gui.Vista.DOfertaRScreen;
import app.gui.Vista.ResultScreen;
import app.proyecto.Sistema.Sistema;

/**
 * Controlador de ver Oferta
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorVerOferta implements ActionListener{

	private Sistema app;
	private ResultScreen panel;
	
	/**
	 * Controlador de ver Oferta
	 * @param app Aplicacion del sistema
	 * @param rs Panel de resultados de busqueda
	 */
	public ControladorVerOferta(Sistema app, ResultScreen rs) {
		this.panel = rs;
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		CardLayout cl;
		MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(panel); //Obtenemos la ventana en la que esta contenido el panel
		
		DOfertaLScreen ols = new DOfertaLScreen(panel.getOferta());
		ventana.cambiaIzquierda(ols, "DOLS"); //Cambiamos pantalla izquierda para demandante
		cl = (CardLayout) ventana.getIzquierda().getLayout();
		cl.show(ventana.getIzquierda(), "DOLS");
		
		DOfertaMScreen oms = new DOfertaMScreen(app, panel.getOferta(), DOfertaMScreen.TipoView.USER);
		ventana.cambiaCentro(oms, "DOMS"); //Cambiamos pantalla centro para demandante
		cl = (CardLayout) ventana.getCentro().getLayout();
		cl.show(ventana.getCentro(), "DOMS");
		
		DOfertaRScreen ors = new DOfertaRScreen(app, panel.getOferta());
		ventana.cambiaDerecha(ors, "DORS"); //Cambiamos pantalla derecha para demandante
		cl = (CardLayout) ventana.getDerecha().getLayout();
		cl.show(ventana.getDerecha(), "DORS");
	}
}
