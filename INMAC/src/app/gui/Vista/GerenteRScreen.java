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
		volverb.setMinimumSize(new Dimension(130, 25));
		volverb.setPreferredSize(new Dimension(130, 25));
		volverb.setMaximumSize(new Dimension(130, 25));
		volverb.addActionListener(new ControladorVolver(this));
		aceptarb = new JButton("Aceptar Oferta");
		aceptarb.setAlignmentX(Component.CENTER_ALIGNMENT);
		aceptarb.addActionListener(new ControladorAprobarOferta(ms));
		aceptarb.setMinimumSize(new Dimension(130, 25));
		aceptarb.setPreferredSize(new Dimension(130, 25));
		aceptarb.setMaximumSize(new Dimension(130, 25));
		rechazarb = new JButton("Rechazar Oferta");
		rechazarb.setAlignmentX(Component.CENTER_ALIGNMENT);
		rechazarb.addActionListener(new ControladorRechazarOferta(
				ms.getSelected(), app, ms));
		rechazarb.setMinimumSize(new Dimension(130, 30));
		rechazarb.setPreferredSize(new Dimension(130, 30));
		rechazarb.setMaximumSize(new Dimension(130, 30));
		
		mainpanel.add(aceptarb);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 10)));
		mainpanel.add(rechazarb);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 10)));
		mainpanel.add(volverb);
		
		this.add(mainpanel);
	}
}
