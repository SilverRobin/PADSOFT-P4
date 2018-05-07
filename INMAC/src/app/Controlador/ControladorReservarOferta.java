package app.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.gui.Vista.DOfertaMScreen;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Oferta.Reserva;
import app.proyecto.Sistema.Sistema;
import app.proyecto.Usuarios.Demandante;

/**
 * Controlador de reservar oferta
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorReservarOferta implements ActionListener{

	private Sistema app;
	private DOfertaMScreen panel;
	
	/**
	 * Constructor del controlador
	 * @param app Aplicacion del sistema
	 * @param panel Panel central
	 */
	public ControladorReservarOferta(Sistema app, DOfertaMScreen panel) {
		this.panel = panel;
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Oferta a = panel.getOferta();
		Demandante d = app.getLogged().getDemandante();
		for(Reserva r : d.getReservas()) {
			if(r.getOferta().isVacacional() == a.isVacacional())
				return;
		}
		panel.getOferta().reservar();
		app.getLogged().getDemandante().addReserva(new Reserva(panel.getOferta()));
		panel.getRButton().setText("Oferta Reservada");
		panel.getCButton().setText("Oferta Reservada");
		panel.getCButton().setEnabled(false);
		panel.getRButton().setEnabled(false);
		return;
	}

}
