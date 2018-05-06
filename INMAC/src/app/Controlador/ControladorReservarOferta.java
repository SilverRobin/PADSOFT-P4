package app.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.gui.Vista.DOfertaMScreen;
import app.proyecto.Oferta.Reserva;
import app.proyecto.Sistema.Sistema;

public class ControladorReservarOferta implements ActionListener{

	private Sistema app;
	private DOfertaMScreen panel;
	
	public ControladorReservarOferta(Sistema app, DOfertaMScreen panel) {
		this.panel = panel;
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		panel.getOferta().reservar();
		app.getLogged().getDemandante().addReserva(new Reserva(panel.getOferta()));
		panel.getRButton().setText("Oferta Reservada");
		panel.getCButton().setText("Oferta Reservada");
		panel.getCButton().setEnabled(false);
		panel.getRButton().setEnabled(false);
		return;
	}

}
