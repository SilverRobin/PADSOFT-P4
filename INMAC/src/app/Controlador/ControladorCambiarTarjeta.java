package app.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.gui.Vista.GTarjetaMScreen;
import app.gui.Vista.GTarjetaRScreen;
import app.proyecto.Usuarios.Cliente;

/**
 * 
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorCambiarTarjeta implements ActionListener{

	private GTarjetaMScreen ms;
	private GTarjetaRScreen rs;
	
	public ControladorCambiarTarjeta(GTarjetaRScreen rs, GTarjetaMScreen ms){
		this.ms = ms;
		this.rs = rs;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Cliente c = ms.getSelected();
		if(c == null)
			return;
		if(c.cambiarTarjeta(rs.getNTarj()))
			c.setAviso(null);
		ms.refresh();
		return;
	}

	
}
