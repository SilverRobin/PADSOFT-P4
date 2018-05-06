package app.gui.Vista;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import app.proyecto.Oferta.Reserva;
import app.proyecto.Sistema.Sistema;

public class DReservaMScreen extends JPanel{

	private static final long serialVersionUID = 1L;

	private JList<Reserva> rlist;
	DefaultListModel<Reserva> model;
	
	public DReservaMScreen(Sistema app) {
		
		this.setLayout(new GridBagLayout());
		
		model = new DefaultListModel<>();
		for(Reserva r : app.getLogged().getDemandante().getReservas()) {
			model.addElement(r);
		}
		rlist = new JList<Reserva>(model);
		rlist.setMaximumSize(new Dimension(160, 200));
		rlist.setMinimumSize(new Dimension(160, 200));
		rlist.setPreferredSize(new Dimension(160, 200));
		
		this.add(rlist);
	}
	
	public Reserva getSelected() {
		return rlist.getSelectedValue();
	}
	
	public void deleteReserva() {
		model.remove(rlist.getSelectedIndex());
		return;
	}
}
