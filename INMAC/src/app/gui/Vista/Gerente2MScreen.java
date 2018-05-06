package app.gui.Vista;

import java.awt.Component;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
	
	public Gerente2MScreen(Sistema app, Oferta of, GerenteMScreen ms) {
		
		this.setLayout(new GridBagLayout());
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
		
		JPanel pbel = new JPanel();
		pbel.setLayout(new BoxLayout(pbel, BoxLayout.Y_AXIS));
		
		modarea = new JTextArea();
		modarea.setAlignmentX(Component.CENTER_ALIGNMENT);
		volverb = new JButton("Volver");
		volverb.setAlignmentX(Component.CENTER_ALIGNMENT);
		volverb.addActionListener(new ControladorVolver(this));
		rechazarb = new JButton("Rechazar oferta");
		rechazarb.setAlignmentX(Component.CENTER_ALIGNMENT);
		rechazarb.addActionListener(new Controlador2RechazarOferta(of,
				this, Controlador2RechazarOferta.TipoRechazo.RECHAZAR,
				app, ms));
		modificarb = new JButton("Solicitar modificacion");
		modificarb.setAlignmentX(Component.CENTER_ALIGNMENT);
		modificarb.addActionListener(new Controlador2RechazarOferta(of,
				this, Controlador2RechazarOferta.TipoRechazo.MODIFICAR,
				app, ms));
		
		mainpanel.add(modarea);
		pbel.add(rechazarb);
		pbel.add(modificarb);
		pbel.add(volverb);
		mainpanel.add(pbel);
		
		this.add(mainpanel);
	}
	
	public String getRect() {
		return modarea.getText();
	}
}
