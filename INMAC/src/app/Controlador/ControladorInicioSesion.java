/**
 * 
 */
package app.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import app.gui.MainGUI;
import app.gui.Vista.LogInScreen;
import app.gui.Vista.OfertanteLScreen;
import app.gui.Vista.OfertanteMScreen;
import app.gui.Vista.OfertanteRScreen;
import app.gui.Vista.ResultScreen;
import app.gui.Vista.SearchScreen;
import app.proyecto.Sistema.Sistema;
import app.proyecto.Sistema.TipoCliente;
import app.proyecto.Usuarios.Ofertante;

/**
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorInicioSesion implements ActionListener {
	

	private LogInScreen panel;
	private Sistema app;
	/**
	 * 
	 */
	public ControladorInicioSesion(Sistema app, LogInScreen panel) {
		this.panel = panel;
		this.app = app;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		TipoCliente tipo;
		if(panel.isOfertante()) {
			tipo = TipoCliente.OFERTANTE;
			
		}else {
			tipo = TipoCliente.DEMANDANTE;
		}
		if(app.logIn(panel.getNIF(), panel.getPassword(), tipo)) {
			CardLayout cl;
			MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(panel); //Obtenemos la ventana en la que esta contenido el panel
			if(tipo == TipoCliente.OFERTANTE) {
				
				OfertanteLScreen ols = new OfertanteLScreen();
				ols.addInmuebles(app.getLogged().getOfertante().getInmuebles());
				ventana.cambiaIzquierda(ols, "OLS"); //Cambiamos pantalla izquierda para ofertante
				cl = (CardLayout) ventana.getIzquierda().getLayout();
				cl.show(ventana.getIzquierda(), "OLS");
				
				ventana.cambiaCentro(new OfertanteMScreen(app), "OMS");
				cl = (CardLayout) ventana.getCentro().getLayout();
				cl.show(ventana.getCentro(), "OMS");
				
				ventana.cambiaDerecha(new OfertanteRScreen(), "ORS");
				cl = (CardLayout) ventana.getDerecha().getLayout();
				cl.show(ventana.getDerecha(), "ORS");
				
			}else {
			cl = (CardLayout) ventana.getCentro().getLayout();
			
			((ResultScreen) ventana.getCurrentCardC()).reactivarVerOferta(); //Reactivamos el boton
			((SearchScreen) ventana.getCurrentCardL()).desbloquearPanel(); //Desbloqueamos el checkbox
			//Cambiamos de panel y listo. Necesitamos un panel nuevo con los menus
			}
			
		}else {
		JOptionPane.showMessageDialog(null,
				"Por favor, compruebe el correo o la contraseña introducidos",
				"Error al iniciar sesión", JOptionPane.ERROR_MESSAGE);
		}
		

	}

}
