package app.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import app.gui.MainGUI;
import app.gui.Vista.BlankScreen;
import app.gui.Vista.DReservaMScreen;
import app.gui.Vista.DReservaRScreen;
import app.gui.Vista.PanelDScreen;
import app.proyecto.Sistema.Sistema;

public class ControladorVerReserva implements ActionListener{

	private PanelDScreen panel;
	private Sistema app;
	
	public ControladorVerReserva(Sistema app, PanelDScreen panel) {
		this.panel = panel;
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		CardLayout cl;
		MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(panel); //Obtenemos la ventana en la que esta contenido el panel
		
		BlankScreen bs = new BlankScreen();
		ventana.cambiaIzquierda(bs, "BS"); //Cambiamos pantalla izquierda para demandante
		cl = (CardLayout) ventana.getIzquierda().getLayout();
		cl.show(ventana.getIzquierda(), "BS");
		
		DReservaMScreen dms = new DReservaMScreen(app);
		ventana.cambiaCentro(dms, "DRMS"); //Cambiamos pantalla centro para demandante
		cl = (CardLayout) ventana.getCentro().getLayout();
		cl.show(ventana.getCentro(), "DRMS");
		
		DReservaRScreen drs = new DReservaRScreen(app, dms);
		ventana.cambiaDerecha(drs, "DRRS"); //Cambiamos pantalla derecha para demandante
		cl = (CardLayout) ventana.getDerecha().getLayout();
		cl.show(ventana.getDerecha(), "DRRS");
	}

	
}
