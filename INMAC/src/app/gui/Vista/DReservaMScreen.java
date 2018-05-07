package app.gui.Vista;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import app.proyecto.Oferta.Reserva;
import app.proyecto.Sistema.Sistema;

/**
 * Pantalla central de reserva del demandante
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class DReservaMScreen extends JPanel{

	private static final long serialVersionUID = 1L;

	private JList<Reserva> rlist;
	DefaultListModel<Reserva> model;
	
	/**
	 * Constructor de pantalla central de reserva del demandante
	 * @param app Aplicacion del sistema
	 */
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
	
	/**
	 * Obtiene la reserva selecionada
	 * @return reserva selecionada en lista
	 */
	public Reserva getSelected() {
		return rlist.getSelectedValue();
	}
	
	/**
	 * Borra la reserva seleccionada
	 */
	public void deleteReserva() {
		model.remove(rlist.getSelectedIndex());
		return;
	}
}
