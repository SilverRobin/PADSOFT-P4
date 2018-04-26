/**
 * 
 */
package app.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import app.gui.MainGUI;
import app.gui.Vista.LogInScreen;
import app.gui.Vista.ResultScreen;
import app.gui.Vista.SearchScreen;
import app.proyecto.Sistema.Sistema;
import app.proyecto.Sistema.TipoCliente;

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
			MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(panel); //Obtenemos la ventana en la que esta contenido el panel
			((ResultScreen) ventana.getCentro()).reactivarVerOferta(); //Reactivamos el boton
			((SearchScreen) ventana.getIzquierda()).desbloquearPanel(); //Desbloqueamos el checkbox
			//Cambiamos de panel y listo. Necesitamos un panel nuevo con los menus
			
		}else {
		JOptionPane.showMessageDialog(null,
				"Por favor, compruebe el correo o la contraseña introducidos",
				"Error al iniciar sesión", JOptionPane.ERROR_MESSAGE);
		}
		

	}

}
