package app.gui.Vista;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import app.Controlador.ControladorGestionarReserva;
import app.Controlador.ControladorVolver;
import app.proyecto.Sistema.Sistema;

/**
 * 
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class DReservaRScreen extends JPanel{

	private static final long serialVersionUID = 1L;

	private JButton pagarb;
	private JButton volverb;
	private JButton cancelarb;
	
	public DReservaRScreen(Sistema app, DReservaMScreen rs) {
		
		JPanel mainpanel = new JPanel();
		this.setLayout(new GridBagLayout());
		
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
		
		pagarb = new JButton("Pagar reserva");
		pagarb.setMinimumSize(new Dimension(150, 35));
		pagarb.setMaximumSize(new Dimension(150, 35));
		pagarb.setPreferredSize(new Dimension(150, 35));
		pagarb.addActionListener(new ControladorGestionarReserva(app,
				ControladorGestionarReserva.AccionReserva.PAGAR, rs));
		volverb = new JButton("Volver");
		volverb.setMinimumSize(new Dimension(150, 35));
		volverb.setMaximumSize(new Dimension(150, 35));
		volverb.setPreferredSize(new Dimension(150, 35));
		volverb.addActionListener(new ControladorVolver(this));
		cancelarb = new JButton("Cancelar reserva");
		cancelarb.setMinimumSize(new Dimension(150, 35));
		cancelarb.setMaximumSize(new Dimension(150, 35));
		cancelarb.setPreferredSize(new Dimension(150, 35));
		cancelarb.addActionListener(new ControladorGestionarReserva(app,
				ControladorGestionarReserva.AccionReserva.CANCELAR, rs));
		
		mainpanel.add(pagarb);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 10)));
		mainpanel.add(cancelarb);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 10)));
		mainpanel.add(volverb);
		
		this.add(mainpanel);
	}
}
