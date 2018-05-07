/**
 * 
 */
package app.gui.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import app.Controlador.ControladorVerOferta;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Sistema.Sistema;

/**
 * Panel de resultados de busqueda
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ResultScreen extends JPanel {


	private static final long serialVersionUID = 1L;
	private JList<Oferta> lista;
	private DefaultListModel<Oferta> listModel;
	private JButton breservar;
	
	/**
	 * Constructor del panel de resultados
	 * @param app Aplicacion del sistema
	 */
	public ResultScreen(Sistema app) {
		super(new BorderLayout());
		listModel = new DefaultListModel<>();
		
		//Create the list and put it in a scroll pane.
        lista = new JList<>(listModel);
        lista.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25)); //Nos quedamos con esta fuente, supongo
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setSelectedIndex(0);
        //lista.addListSelectionListener(this);
        lista.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(lista);

        add(listScrollPane, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createTitledBorder("Resultados de busqueda"));
	}
	
	/**
	 * Añade resultados a la lista
	 * @param lista de ofertas
	 */
	public void addResultados(ArrayList<Oferta> lista) {
		for(Oferta o : lista) {
			listModel.addElement(o);
		}
	}
	
	/**
	 * Limpia la lista visible
	 */
	public void limpiarLista() {
		listModel.clear();
	}

	/**
	 * Obtiene la oferta seleccionada
	 * @return oferta seleccionada
	 */
	public Oferta getOferta() {
		return (Oferta) lista.getSelectedValue();
	}
	
}
