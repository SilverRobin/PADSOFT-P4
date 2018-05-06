package app.gui.Vista;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import app.Controlador.ControladorCerrarSesion;
import app.Controlador.ControladorVerOferta;
import app.Controlador.ControladorVerReserva;
import app.proyecto.Sistema.Sistema;

public class PanelDScreen extends JPanel{

	private static final long serialVersionUID = 1L;

	private JButton vresb;
	private JButton loutb;
	private JButton vofer;

	public PanelDScreen(Sistema app, ResultScreen rs) {
		this.setLayout(new GridBagLayout());
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
		vresb = new JButton("Ver reservas");
		vresb.setMinimumSize(new Dimension(150, 35));
		vresb.setMaximumSize(new Dimension(150, 35));
		vresb.setPreferredSize(new Dimension(150, 35));
		vresb.addActionListener(new ControladorVerReserva(app, this));
		loutb = new JButton("Cerrar sesión");
		loutb.setMinimumSize(new Dimension(150, 35));
		loutb.setMaximumSize(new Dimension(150, 35));
		loutb.setPreferredSize(new Dimension(150, 35));
		loutb.addActionListener(new ControladorCerrarSesion(app, this));
		vofer = new JButton("Ver Oferta");
		vofer.setMinimumSize(new Dimension(150, 35));
		vofer.setMaximumSize(new Dimension(150, 35));
		vofer.setPreferredSize(new Dimension(150, 35));
		vofer.addActionListener(new ControladorVerOferta(app, rs));
		mainpanel.add(vofer);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 10)));
		mainpanel.add(vresb);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 10)));
		mainpanel.add(loutb);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 500)));
		this.add(mainpanel);
	}
	
}
