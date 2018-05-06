package app.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import app.gui.MainGUI;
import app.gui.Vista.LogInScreen;
import app.gui.Vista.ResultScreen;
import app.gui.Vista.SearchScreen;
import app.proyecto.Sistema.Sistema;
import app.proyecto.Sistema.TipoCliente;

/**
 * 
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorCerrarSesion implements ActionListener{

	private Sistema app;
	private JPanel panel;
	
	public ControladorCerrarSesion(Sistema app, JPanel panel) {
		this.app = app;
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(panel); //Obtenemos la ventana en la que esta contenido el panel
		
		if(app.getTipoLogged() == TipoCliente.OFERTANTE
				|| app.getTipoLogged() == TipoCliente.GERENTE) {
			ventana.volver();
		}else {
			ventana.volverD();
		}
		app.logOut();
		CardLayout cl;
		
		ventana.cambiaIzquierda(new SearchScreen(), "Search"); //Cambiamos pantalla izquierda para ofertante
		ResultScreen rs = new ResultScreen(app);
		cl = (CardLayout) ventana.getIzquierda().getLayout();
		cl.show(ventana.getIzquierda(), "Search");
		
		ventana.cambiaCentro(rs, "Results"); //Cambiamos pantalla izquierda para ofertante		
		cl = (CardLayout) ventana.getCentro().getLayout();
		cl.show(ventana.getCentro(), "Results");
		
		ventana.cambiaDerecha(new LogInScreen(app, rs), "LogInScreen"); //Cambiamos pantalla izquierda para ofertante
		cl = (CardLayout) ventana.getDerecha().getLayout();
		cl.show(ventana.getDerecha(), "LogIn");
		((SearchScreen) ventana.getCurrentCardL()).desbloquearPanel(false); //Desbloqueamos el checkbox
	}

}
