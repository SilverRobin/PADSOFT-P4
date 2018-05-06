package app.gui.Vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import app.Controlador.ControladorAprobarOferta;
import app.Controlador.ControladorCTarjetasVer;
import app.Controlador.ControladorCerrarSesion;
import app.Controlador.ControladorRechazarOferta;
import app.Controlador.ControladorVerOGerente;
import app.proyecto.Sistema.Sistema;

public class GerenteRScreen extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButton aceptarb;
	private JButton rechazarb;
	private JButton cambiarb;
	private JButton volverb;
	private JButton verb;
	
	public GerenteRScreen(Sistema app, GerenteMScreen ms) {
		
		this.setLayout(new GridBagLayout());
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
		
		volverb = new JButton("Cerrar sesión");
		volverb.setAlignmentX(Component.CENTER_ALIGNMENT);
		volverb.setMinimumSize(new Dimension(130, 30));
		volverb.setPreferredSize(new Dimension(130, 30));
		volverb.setMaximumSize(new Dimension(130, 30));
		volverb.addActionListener(new ControladorCerrarSesion(app, this));
		verb = new JButton("Ver oferta");
		verb.setAlignmentX(Component.CENTER_ALIGNMENT);
		verb.setMinimumSize(new Dimension(130, 30));
		verb.setPreferredSize(new Dimension(130, 30));
		verb.setMaximumSize(new Dimension(130, 30));
		verb.addActionListener(new ControladorVerOGerente(app,
				this, ms));
		cambiarb = new JButton("Cambiar tarjetas");
		cambiarb.setAlignmentX(Component.CENTER_ALIGNMENT);
		cambiarb.setMinimumSize(new Dimension(130, 30));
		cambiarb.setPreferredSize(new Dimension(130, 30));
		cambiarb.setMaximumSize(new Dimension(130, 30));
		cambiarb.addActionListener(new ControladorCTarjetasVer(app, this));
		aceptarb = new JButton("Aceptar Oferta");
		aceptarb.setAlignmentX(Component.CENTER_ALIGNMENT);
		aceptarb.addActionListener(new ControladorAprobarOferta(ms));
		aceptarb.setMinimumSize(new Dimension(130, 30));
		aceptarb.setPreferredSize(new Dimension(130, 30));
		aceptarb.setMaximumSize(new Dimension(130, 30));
		rechazarb = new JButton("Rechazar Oferta");
		rechazarb.setAlignmentX(Component.CENTER_ALIGNMENT);
		rechazarb.addActionListener(new ControladorRechazarOferta(
				ms.getSelected(), app, ms));
		rechazarb.setMinimumSize(new Dimension(130, 30));
		rechazarb.setPreferredSize(new Dimension(130, 30));
		rechazarb.setMaximumSize(new Dimension(130, 30));
		
		mainpanel.add(verb);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 10)));
		mainpanel.add(cambiarb);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 10)));
		mainpanel.add(aceptarb);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 10)));
		mainpanel.add(rechazarb);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 10)));
		mainpanel.add(volverb);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		this.add(mainpanel);
	}
}
