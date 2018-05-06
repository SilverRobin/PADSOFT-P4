/**
 * 
 */
package app.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import app.gui.MainGUI;
import app.gui.Vista.BlankScreen;
import app.gui.Vista.GerenteMScreen;
import app.gui.Vista.GerenteRScreen;
import app.gui.Vista.LogInScreen;
import app.gui.Vista.OfertanteLScreen;
import app.gui.Vista.OfertanteMScreen;
import app.gui.Vista.OfertanteRScreen;
import app.gui.Vista.PanelDScreen;
import app.gui.Vista.ResultScreen;
import app.gui.Vista.SearchScreen;
import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Oferta.EstadoOferta;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Sistema.Sistema;
import app.proyecto.Sistema.TipoCliente;

/**
 * Controlador del inicio de sesion
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorInicioSesion implements ActionListener {
	

	private LogInScreen panel;
	private Sistema app;

	/**
	 * Controlador del inicio de sesion
	 * @param app Aplicacion
	 * @param panel Panel de Login
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
			if(app.getTipoLogged() == TipoCliente.GERENTE){
				
				ventana.cambiaIzquierda(new BlankScreen(), "BS");
				cl = (CardLayout) ventana.getIzquierda().getLayout();
				cl.show(ventana.getIzquierda(), "BS");
				
				GerenteMScreen gms = new GerenteMScreen(app);
				ventana.cambiaCentro(gms, "GMS"); //Cambiamos pantalla izquierda para ofertante
				cl = (CardLayout) ventana.getCentro().getLayout();
				cl.show(ventana.getCentro(), "GMS");
				
				ventana.cambiaDerecha(new GerenteRScreen(app, gms), "GRS");
				cl = (CardLayout) ventana.getDerecha().getLayout();
				cl.show(ventana.getDerecha(), "GRS");
				return;
				
				
				
			}else if(tipo == TipoCliente.OFERTANTE) {
				
				ventana.cambiaCentro(new OfertanteMScreen(app), "OMS");
				cl = (CardLayout) ventana.getCentro().getLayout();
				cl.show(ventana.getCentro(), "OMS");
				
				if(app.getLogged().getOfertante().getInmuebles().isEmpty() == true) {
					((OfertanteMScreen) ventana.getCurrentCardC()).getAddOferta().setEnabled(false);
				}
				ventana.cambiaDerecha(new OfertanteRScreen(), "ORS");
				cl = (CardLayout) ventana.getDerecha().getLayout();
				cl.show(ventana.getDerecha(), "ORS");
				
				OfertanteLScreen ols = new OfertanteLScreen(app);
				//ols.addInmuebles(app.getLogged().getOfertante().getInmuebles());
				ventana.cambiaIzquierda(ols, "OLS"); //Cambiamos pantalla izquierda para ofertante
				cl = (CardLayout) ventana.getIzquierda().getLayout();
				cl.show(ventana.getIzquierda(), "OLS");
				
				ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();
				if(app.getLogged().getAviso() != null) {
					JOptionPane.showMessageDialog(null,
							"[" + app.getLogged().getAviso().getFecha()+ "]" + 
							app.getLogged().getAviso().getTexto(),
							"Avisos", JOptionPane.INFORMATION_MESSAGE);
					return;
				}else if(app.getLogged().getAviso() == null) {
					JOptionPane.showMessageDialog(null,
							"No tiene avisos pendientes",
							"Avisos", JOptionPane.INFORMATION_MESSAGE);
					return;
				}else if(app.getLogged().getOfertante().getInmuebles().isEmpty() == false) {
					inmuebles.addAll(app.getLogged().getOfertante().getInmuebles());
					for(Inmueble i : inmuebles) {
						if(i.getOfertas().isEmpty())
							continue;
						for(Oferta o : i.getOfertas()) {
							if(o.getVisibilidad() != EstadoOferta.A_MODIFICAR) {
								String cadena = "La oferta [" + o + "] del inmueble " + "[" + i + "] ha de ser modificada";
								JOptionPane.showMessageDialog(null,
										cadena,
										"Avisos", JOptionPane.INFORMATION_MESSAGE);
								return;
							}
							continue;
						}
					}
					return;
				}
				
			}else {
				cl = (CardLayout) ventana.getDerecha().getLayout();
				PanelDScreen pds = new PanelDScreen(app, (ResultScreen) ventana.getCurrentCardC());
				ventana.cambiaDerecha(pds, "PDS"); //Cambiamos pantalla izquierda para ofertante
				cl = (CardLayout) ventana.getDerecha().getLayout();
				cl.show(ventana.getDerecha(), "PDS");
			
				((SearchScreen) ventana.getCurrentCardL()).desbloquearPanel(true); 
			}
			
		}else {
			JOptionPane.showMessageDialog(null,
				"Por favor, compruebe el correo o la contraseña introducidos",
				"Error al iniciar sesión", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(app.getLogged().getAviso() != null) {
			JOptionPane.showMessageDialog(null,
					app.getLogged().getAviso().getTexto(),
					"Error de tarjeta", JOptionPane.ERROR_MESSAGE);
		}

	}

}
