package app.gui.Vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.Controlador.ControladorCambiarTarjeta;
import app.Controlador.ControladorVolver;

public class GTarjetaRScreen extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButton volverb;
	private JButton cambiarb;
	private JTextField narea;
	private JLabel nl;
	
	public GTarjetaRScreen(GTarjetaMScreen ms) {
		
		this.setLayout(new GridBagLayout());
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
		
		nl = new JLabel("Nueva tarjeta:");
		nl.setAlignmentX(Component.CENTER_ALIGNMENT);
		nl.setHorizontalAlignment(JLabel.CENTER);
		volverb = new JButton("Volver");
		volverb.setMinimumSize(new Dimension(130, 30));
		volverb.setPreferredSize(new Dimension(130, 30));
		volverb.setMaximumSize(new Dimension(130, 30));
		volverb.setAlignmentX(Component.CENTER_ALIGNMENT);
		volverb.addActionListener(new ControladorVolver(this));
		cambiarb = new JButton("Cambiar tarjeta");
		cambiarb.setMinimumSize(new Dimension(130, 30));
		cambiarb.setPreferredSize(new Dimension(130, 30));
		cambiarb.setMaximumSize(new Dimension(130, 30));
		cambiarb.setAlignmentX(Component.CENTER_ALIGNMENT);
		cambiarb.addActionListener(new ControladorCambiarTarjeta(this, ms));
		narea = new JTextField();
		narea.setAlignmentX(Component.CENTER_ALIGNMENT);
		narea.setHorizontalAlignment(JTextField.CENTER);
		
		mainpanel.add(nl);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 5)));
		mainpanel.add(narea);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 15)));
		mainpanel.add(cambiarb);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 10)));
		mainpanel.add(volverb);
		
		this.add(mainpanel);
	}
	
	public String getNTarj() {
		return narea.getText();
	}
}
