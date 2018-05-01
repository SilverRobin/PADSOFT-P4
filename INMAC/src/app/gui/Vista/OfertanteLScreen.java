/**
 * 
 */
package app.gui.Vista;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Oferta.Oferta;

/**
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class OfertanteLScreen extends JPanel {
	private JList lista;
	private DefaultListModel listModel;
	/**
	 * 
	 */
	public OfertanteLScreen() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		lista = new JList(listModel);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setSelectedIndex(0);
        JScrollPane listScrollPane = new JScrollPane(lista);
        
        this.add(listScrollPane, BoxLayout.Y_AXIS);
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
