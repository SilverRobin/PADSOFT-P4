/**
 * 
 */
package app.gui.Vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.Controlador.ControladorListaOL;
import app.gui.MainGUI;
import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Sistema.Sistema;

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
	public OfertanteLScreen(Sistema app) {
		JPanel minipanel = new JPanel();

		height = tamanyo.height;
		width = tamanyo.width;
		
		this.setLayout(new BorderLayout());
		listModel = new DefaultListModel();
		lista = new JList(listModel);
		if(app.getLogged().getOfertante().getInmuebles().isEmpty() == false && listModel.isEmpty()) {
			this.addInmuebles(app.getLogged().getOfertante().getInmuebles());
			lista.addListSelectionListener(new ControladorListaOL(this, app));
		}
		
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setVisibleRowCount(20);
        lista.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12)); //Nos quedamos con esta fuente, supongo
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
	
	public void cleanList() {
		listModel.removeAllElements();
	}
	
	public Inmueble getSelectedInmueble() {
		return (Inmueble) lista.getSelectedValue();
	}
	
	public void blockLista() {
		lista.setEnabled(false);
	}
	public JList getLista() {
		return lista;
	}
	
	public List<Inmueble> getActualList(){
		List<Inmueble> aux = new ArrayList<Inmueble>();
		for(int i = 0; i<listModel.getSize(); i++) {
			aux.add((Inmueble) listModel.get(i));
		}
		return aux;
	}

}
