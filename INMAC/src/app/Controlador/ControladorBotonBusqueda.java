/**
 * 
 */
package app.Controlador;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import app.gui.MainGUI;
import app.gui.Vista.ResultScreen;
import app.gui.Vista.SearchScreen;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Sistema.Sistema;

/**
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorBotonBusqueda implements ActionListener {
	private SearchScreen panel;
	private Sistema app;

	/**
	 * 
	 */
	public ControladorBotonBusqueda(Sistema app, SearchScreen panel) {
		this.app = app;
		this.panel = panel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ArrayList<Oferta> lista = new ArrayList<Oferta>();
		ArrayList<Oferta> aux = new ArrayList<Oferta>();
		boolean vacacional = panel.isVacSelected();
		boolean largaEstancia = panel.isLESelected();
		String codigo = panel.getCP();
		LocalDate inicio = panel.getInicio();
		LocalDate fin = panel.getFin();
		int valoracion = panel.valoracion();
		MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(panel); //Obtenemos la ventana en la que esta contenido el panel

		if (app.getLogged() != null) { // Usuario logueado
			if (vacacional) 
				lista.addAll(app.busquedaVacacional()); // Incluimos las vacacionales

			if (largaEstancia) 
				lista.addAll(app.busquedaLE()); // Incluimos las de larga estancia

		} else { //Usuario no logueado
			lista.addAll(app.getDisponibles()); // Si no esta logueado añadimos todas las ofertas
		}
		if(lista.isEmpty()) {
			((ResultScreen) ventana.getCurrentCardC()).limpiarLista();
			JOptionPane.showMessageDialog(null,
					"No hay resultados",
					"Avisos", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		aux.addAll(lista);
		///// ** FILTROS APLICABLES POR TODOS LOS USUARIOS**//////
		if (codigo != null) { // Filtro por codigo postal
			for (Oferta o : lista) { // Recorremos la lista de ofertas filtradas por estancia
				if (app.busquedaCP(codigo).contains(o) == false) { // Si la lista de busqueda por codigo no contiene la oferta del primer filtro												
					aux.remove(o); // La eliminamos
				}
			}
		} else if (inicio != null && fin != null) { // Filtro por fechas
			for (Oferta o : lista) {
				if (app.busquedaFecha(inicio, fin).contains(o) == false) 
					aux.remove(o);	
			}
		} else {
			for (Oferta o : lista) { // Filtro por valoracion
				if (app.busquedaValoracion(valoracion).contains(o) == false) 
					aux.remove(o);
			}
		}
		if(aux.isEmpty()) {
			((ResultScreen) ventana.getCurrentCardC()).limpiarLista();
			JOptionPane.showMessageDialog(null,
					"No hay resultados",
					"Avisos", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		///**CAMBIO DE ESTADO DEL PANEL CENTRAL**////
		((ResultScreen) ventana.getCurrentCardC()).limpiarLista(); //Va, eliminamos todo para dejarlo limpico
		((ResultScreen) ventana.getCurrentCardC()).addResultados(aux); //Si con esto no se actualiza hay que preguntar a Google
		
	}

}
