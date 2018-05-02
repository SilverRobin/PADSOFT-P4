/**
 * 
 */
package app.gui.Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Oferta.Oferta;

/**
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class OfertanteLScreen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList lista;
	private DefaultListModel listModel;
	private Dimension tamanyo = Toolkit.getDefaultToolkit().getScreenSize();
	private int height, width;
	/**
	 * 
	 */
	public OfertanteLScreen() {
		JPanel minipanel = new JPanel();
		height = tamanyo.height;
		width = tamanyo.width;
		
		this.setLayout(new BorderLayout());
		listModel = new DefaultListModel();
		lista = new JList(listModel);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setSelectedIndex(0);
        lista.setVisibleRowCount(20);
        lista.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 9)); //Nos quedamos con esta fuente, supongo
        JScrollPane listScrollPane = new JScrollPane(lista);
        minipanel.add(listScrollPane);
        minipanel.setBorder(new EmptyBorder(height*20/100, 0, 0, 0));
        this.add(minipanel, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createTitledBorder("Lista de inmuebles"));
	}
	
	public void addInmuebles(List<Inmueble> list) {
		for(Inmueble i : list) {
			listModel.addElement(i);
		}
	}
	
	public Inmueble getSelectedInmueble() {
		return (Inmueble) lista.getSelectedValue();
	}

}
