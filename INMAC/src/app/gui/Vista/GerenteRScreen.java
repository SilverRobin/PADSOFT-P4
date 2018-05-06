package app.gui.Vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import app.Controlador.ControladorAprobarOferta;
import app.Controlador.ControladorRechazarOferta;
import app.Controlador.ControladorVolver;
import app.proyecto.Sistema.Sistema;

public class GerenteRScreen extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButton aceptarb;
	private JButton rechazarb;
	private JButton volverb;
	
	public GerenteRScreen(Sistema app, GerenteMScreen ms) {
		
		this.setLayout(new GridBagLayout());
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
		
		volverb = new JButton("Volver");
		volverb.setAlignmentX(Component.CENTER_ALIGNMENT);
		volverb.addActionListener(new ControladorVolver(this));
		aceptarb = new JButton("Aceptar Oferta");
		aceptarb.setAlignmentX(Component.CENTER_ALIGNMENT);
		aceptarb.addActionListener(new ControladorAprobarOferta(ms));
		rechazarb = new JButton("Rechazar Oferta");
		rechazarb.setAlignmentX(Component.CENTER_ALIGNMENT);
		rechazarb.addActionListener(new ControladorRechazarOferta(
				ms.getSelected(), app, ms));
		
		mainpanel.add(aceptarb);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 15)));
		mainpanel.add(rechazarb);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 15)));
		mainpanel.add(volverb);
		
		this.add(mainpanel);
	}
}
