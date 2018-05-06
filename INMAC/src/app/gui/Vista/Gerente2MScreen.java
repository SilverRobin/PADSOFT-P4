package app.gui.Vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import app.Controlador.ControladorVolver;
import app.gui.Vista.GerenteMScreen;
import app.Controlador.Controlador2RechazarOferta;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Sistema.Sistema;

public class Gerente2MScreen extends JPanel{

	private static final long serialVersionUID = 1L;

	private JTextArea modarea;
	private JButton volverb;
	private JButton rechazarb;
	private JButton modificarb;
	private JLabel nl;
	
	public Gerente2MScreen(Sistema app, Oferta of, GerenteMScreen ms) {
		
		this.setLayout(new GridBagLayout());
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
		
		JPanel pbel = new JPanel();
		pbel.setLayout(new BoxLayout(pbel, BoxLayout.Y_AXIS));
		
		nl = new JLabel("Mensaje rectificacion:");
		nl.setHorizontalAlignment(JLabel.CENTER);
		nl.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		modarea = new JTextArea();
		modarea.setMinimumSize(new Dimension(200, 200));
		modarea.setPreferredSize(new Dimension(200, 200));
		modarea.setMaximumSize(new Dimension(200, 200));
		modarea.setAlignmentX(Component.CENTER_ALIGNMENT);
		volverb = new JButton("Volver");
		volverb.setAlignmentX(Component.CENTER_ALIGNMENT);
		volverb.addActionListener(new ControladorVolver(this));
		volverb.setMaximumSize(new Dimension(160, 30));
		volverb.setMinimumSize(new Dimension(160, 30));
		volverb.setPreferredSize(new Dimension(160, 30));
		rechazarb = new JButton("Rechazar oferta");
		rechazarb.setAlignmentX(Component.CENTER_ALIGNMENT);
		rechazarb.addActionListener(new Controlador2RechazarOferta(of,
				this, Controlador2RechazarOferta.TipoRechazo.RECHAZAR,
				app, ms));
		rechazarb.setMaximumSize(new Dimension(160, 30));
		rechazarb.setMinimumSize(new Dimension(160, 30));
		rechazarb.setPreferredSize(new Dimension(160, 30));
		modificarb = new JButton("Solicitar modificacion");
		modificarb.setAlignmentX(Component.CENTER_ALIGNMENT);
		modificarb.addActionListener(new Controlador2RechazarOferta(of,
				this, Controlador2RechazarOferta.TipoRechazo.MODIFICAR,
				app, ms));
		modificarb.setMaximumSize(new Dimension(160, 30));
		modificarb.setMinimumSize(new Dimension(160, 30));
		modificarb.setPreferredSize(new Dimension(160, 30));
		
		mainpanel.add(nl);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 5)));
		mainpanel.add(modarea);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 25)));
		pbel.add(rechazarb);
		pbel.add(Box.createRigidArea(new Dimension(0, 10)));
		pbel.add(modificarb);
		pbel.add(Box.createRigidArea(new Dimension(0, 10)));
		pbel.add(volverb);
		mainpanel.add(pbel);
		
		this.add(mainpanel);
	}
	
	public String getRect() {
		return modarea.getText();
	}
}
