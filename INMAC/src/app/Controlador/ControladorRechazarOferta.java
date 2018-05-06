package app.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import app.gui.MainGUI;
import app.gui.Vista.BlankScreen;
import app.gui.Vista.Gerente2MScreen;
import app.gui.Vista.GerenteMScreen;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Sistema.Sistema;

public class ControladorRechazarOferta implements ActionListener{

	private GerenteMScreen panel;
	private Sistema app;
	private Oferta of;
	
	public ControladorRechazarOferta(Oferta of, Sistema app, GerenteMScreen ms) {
		panel = ms;
		this.app = app;
		this.of = of;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		CardLayout cl;
		MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(panel); //Obtenemos la ventana en la que esta contenido el panel
		
		BlankScreen bs = new BlankScreen();
		ventana.cambiaIzquierda(bs, "BSG"); //Cambiamos pantalla izquierda para demandante
		cl = (CardLayout) ventana.getIzquierda().getLayout();
		cl.show(ventana.getIzquierda(), "BSG");
		
		Gerente2MScreen g2ms = new Gerente2MScreen(app, of, panel);
		ventana.cambiaCentro(g2ms, "G2MS"); //Cambiamos pantalla centro para demandante
		cl = (CardLayout) ventana.getCentro().getLayout();
		cl.show(ventana.getCentro(), "G2MS");
		
		BlankScreen bsd = new BlankScreen();
		ventana.cambiaDerecha(bsd, "BSGD"); //Cambiamos pantalla derecha para demandante
		cl = (CardLayout) ventana.getDerecha().getLayout();
		cl.show(ventana.getDerecha(), "BSGD");
	}
}
