/**
 * 
 */
package app.gui.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ResultScreen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList lista;
	private DefaultListModel listModel;
	private JButton breservar;
	
	/**
	 * 
	 */
	public ResultScreen() {
		super(new BorderLayout());
		listModel = new DefaultListModel();
        listModel.addElement("Apartamento en la calle de la gominola. Soleado. 300€");
		
		//Create the list and put it in a scroll pane.
        lista = new JList(listModel);
        lista.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25)); //Nos quedamos con esta fuente, supongo
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setSelectedIndex(0);
        //lista.addListSelectionListener(this);
        lista.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(lista);
        
        breservar = new JButton("Ver Oferta");
        //breservar.setVisible(false);
        breservar.setEnabled(false);
        
        add(listScrollPane, BorderLayout.CENTER);
        add(breservar, BorderLayout.PAGE_END);
        this.setBorder(BorderFactory.createTitledBorder("Resultados de busqueda"));
	}

	public void reactivarVerOferta() {
		breservar.setEnabled(true);
	}

}
