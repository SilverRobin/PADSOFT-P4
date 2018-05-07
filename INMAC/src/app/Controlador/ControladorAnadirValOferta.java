package app.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.gui.Vista.DOfertaMScreen;
import app.proyecto.Sistema.Sistema;
import app.proyecto.Valorables.Valoracion;

/**
 * Controlador de añadir valoracion
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorAnadirValOferta implements ActionListener{

	private Sistema app;
	private DOfertaMScreen panel;
	
	/**
	 * Constructor del controlador
	 * @param app Aplicacion del sistema
	 * @param panel Panel central del Demandante
	 */
	public ControladorAnadirValOferta(Sistema app, DOfertaMScreen panel) {
		this.panel = panel;
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		double val = Double.parseDouble(panel.getVal());
		if(val < 1 || val > 5)
			return;
		panel.getOferta().addValorable(new Valoracion(val, app.getLogged()));
		panel.getAnadir().setEnabled(false);
		panel.getAnadir().setText("Oferta valorada");
		panel.getVals().setText(String.format("%.2f", panel.getOferta().calcularMediaValoraciones()));
		return;
	}

}
