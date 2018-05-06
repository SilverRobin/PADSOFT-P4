package app.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import app.gui.MainGUI;
import app.gui.Vista.Gerente2MScreen;
import app.gui.Vista.GerenteMScreen;
import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Sistema.Sistema;

public class Controlador2RechazarOferta implements ActionListener{

	public enum TipoRechazo {
		RECHAZAR,
		MODIFICAR
	}
	
	private Gerente2MScreen panel;
	private GerenteMScreen mpanel;
	private Oferta of;
	private Sistema app;
	private TipoRechazo tipo;
	
	public Controlador2RechazarOferta(Oferta of,
			Gerente2MScreen panel, TipoRechazo tipo,
			Sistema app, GerenteMScreen ms) {
		this.panel = panel;
		this.of = of;
		this.tipo = tipo;
		this.app = app;
		this.mpanel = ms;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(tipo == TipoRechazo.RECHAZAR) {
			for(Inmueble i : app.getInmuebles()) {
				for(Oferta o : i.getOfertas()) {
					if(o.equals(of)) {
						i.removeOferta(o);
						break;
					}
				}
			}
		}else {
			of.setRectificacion(panel.getRect());
			app.getLogged().getOfertante().addRect(panel.getRect());
			of.rectificar();
		}
		
		mpanel.deleteSelected();
		
		CardLayout cl;
		MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(panel); //Obtenemos la ventana en la que esta contenido el panel
		ventana.volver();
		cl = (CardLayout) ventana.getIzquierda().getLayout();
		cl.show(ventana.getIzquierda(), ventana.getIName());
		cl = (CardLayout) ventana.getDerecha().getLayout();
		cl.show(ventana.getDerecha(), ventana.getDName());
		cl = (CardLayout) ventana.getCentro().getLayout();
		cl.show(ventana.getCentro(), ventana.getCName());
	}

}
