package app.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import app.gui.MainGUI;
import app.gui.Vista.BlankScreen;
import app.gui.Vista.GTarjetaMScreen;
import app.gui.Vista.GTarjetaRScreen;
import app.gui.Vista.GerenteRScreen;
import app.proyecto.Sistema.Sistema;

public class ControladorCTarjetasVer implements ActionListener{

	private Sistema app;
	private GerenteRScreen panel;
	
	public ControladorCTarjetasVer(Sistema app, GerenteRScreen panel) {
		this.app = app;
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		CardLayout cl;
		MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(panel); //Obtenemos la ventana en la que esta contenido el panel
		
		BlankScreen bs = new BlankScreen();
		ventana.cambiaIzquierda(bs, "BSCT"); //Cambiamos pantalla izquierda para demandante
		cl = (CardLayout) ventana.getIzquierda().getLayout();
		cl.show(ventana.getIzquierda(), "BSCT");
		
		GTarjetaMScreen cms = new GTarjetaMScreen(app);
		ventana.cambiaCentro(cms, "CMSG"); //Cambiamos pantalla centro para demandante
		cl = (CardLayout) ventana.getCentro().getLayout();
		cl.show(ventana.getCentro(), "CMSG");
		
		GTarjetaRScreen crs = new GTarjetaRScreen(cms);
		ventana.cambiaDerecha(crs, "CRSG"); //Cambiamos pantalla derecha para demandante
		cl = (CardLayout) ventana.getDerecha().getLayout();
		cl.show(ventana.getDerecha(), "CRSG");
		return;
	}
}
