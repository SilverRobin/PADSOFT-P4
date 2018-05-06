package app.gui.Vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Oferta.EstadoOferta;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Sistema.Sistema;

/**
 * 
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class GerenteMScreen extends JPanel{

	private static final long serialVersionUID = 1L;

	private JList<Oferta> olist;
	private DefaultListModel<Oferta> model;
	
	public GerenteMScreen(Sistema app) {
		
		this.setLayout(new GridBagLayout());
		model = new DefaultListModel<Oferta>();
		
		for(Inmueble i : app.getInmuebles()) {
			for(Oferta o : i.getOfertas()) {
				if(o.getVisibilidad() == EstadoOferta.NO_APROBADA)
					model.addElement(o);
			}
		}
		olist = new JList<Oferta>(model);
		olist.setAlignmentX(Component.CENTER_ALIGNMENT);
		olist.setMinimumSize(new Dimension(200, 200));
		olist.setMaximumSize(new Dimension(200, 200));
		olist.setPreferredSize(new Dimension(200, 200));
		this.add(olist);
	}
	
	public Oferta getSelected() {
		return olist.getSelectedValue();
	}
	
	public void deleteSelected() {
		model.remove(olist.getSelectedIndex());
		return;
	}
}
