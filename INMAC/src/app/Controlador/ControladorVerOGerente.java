package app.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import app.gui.MainGUI;
import app.gui.Vista.BlankScreen;
import app.gui.Vista.DOfertaMScreen;
import app.gui.Vista.GerenteMScreen;
import app.gui.Vista.GerenteRScreen;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Sistema.Sistema;

/**
 * Controlador de ver Ofertas del gerente
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorVerOGerente implements ActionListener{

	private GerenteMScreen ms;
	private GerenteRScreen panel;
	private Sistema app;
	
	/**
	 * Constructor del controlador
	 * @param app Aplicacion del sistema
	 * @param panel Panel derecho del gerente
	 * @param ms Panel central del gerente
	 */
	public ControladorVerOGerente(Sistema app, GerenteRScreen panel, GerenteMScreen ms) {
		this.panel = panel;
		this.ms = ms;
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Oferta o = ms.getSelected();
		if(o == null)
			return;
		
		CardLayout cl;
		MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(panel); //Obtenemos la ventana en la que esta contenido el panel
		
		BlankScreen bs = new BlankScreen();
		ventana.cambiaIzquierda(bs, "GVOBSL"); //Cambiamos pantalla izquierda para demandante
		cl = (CardLayout) ventana.getIzquierda().getLayout();
		cl.show(ventana.getIzquierda(), "GVOBSL");
		
		DOfertaMScreen dms = new DOfertaMScreen(app, o, DOfertaMScreen.TipoView.GERENTE);
		ventana.cambiaCentro(dms, "GVOMS"); //Cambiamos pantalla centro para demandante
		cl = (CardLayout) ventana.getCentro().getLayout();
		cl.show(ventana.getCentro(), "GVOMS");
		
		BlankScreen bsr = new BlankScreen();
		ventana.cambiaDerecha(bsr, "GVOBSR"); //Cambiamos pantalla derecha para demandante
		cl = (CardLayout) ventana.getDerecha().getLayout();
		cl.show(ventana.getDerecha(), "GVOBSR");
		
		return;
	}
}
