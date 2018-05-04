package app.gui.Vista;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.Controlador.ControladorAnadirValOferta;
import app.Controlador.ControladorReservarOferta;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Oferta.Vacacional;
import app.proyecto.Sistema.Sistema;

public class DOfertaMScreen extends JPanel{

	private static final long serialVersionUID = 1L;

	private JLabel toferta, comof, finof, preof, fiof, vaof;
	private JTextField comfield;
	private JTextField finfield;
	private JTextField tipofield;
	private JTextField prefield;
	private JTextField fifield;
	private JTextField valfield;
	private JTextField nvalfield;
	private Oferta oferta;
	private JButton anabutton;
	private JButton reservar;
	private JButton volver;
	
	
	public DOfertaMScreen(Sistema app, Oferta of) {
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
		JPanel horizontalhi = new JPanel();
		horizontalhi.setLayout(new BoxLayout(horizontalhi, BoxLayout.X_AXIS));
		JPanel hileft = new JPanel();
		hileft.setLayout(new BoxLayout(hileft, BoxLayout.Y_AXIS));
		JPanel hiright = new JPanel();
		hiright.setLayout(new BoxLayout(hiright, BoxLayout.Y_AXIS));
		JPanel horizontallow = new JPanel();
		horizontallow.setLayout(new BoxLayout(horizontallow, BoxLayout.X_AXIS));
		this.oferta = of;
		
		horizontalhi.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalhi.setAlignmentY(Component.CENTER_ALIGNMENT);
		hileft.setAlignmentX(Component.CENTER_ALIGNMENT);
		hileft.setAlignmentY(Component.CENTER_ALIGNMENT);
		hiright.setAlignmentX(Component.CENTER_ALIGNMENT);
		hiright.setAlignmentY(Component.CENTER_ALIGNMENT);
		horizontallow.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontallow.setAlignmentY(Component.CENTER_ALIGNMENT);
		mainpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainpanel.setAlignmentY(Component.CENTER_ALIGNMENT);
		this.setAlignmentY(Component.CENTER_ALIGNMENT);
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		if(of.isVacacional())
			tipofield = new JTextField("Vacacional");
		else
			tipofield = new JTextField("Larga estancia");
		
		toferta = new JLabel("Tipo de Oferta:");
		comof = new JLabel("Comienzo de la oferta:");
		preof = new JLabel("Precio:");
		fiof = new JLabel("Fianza:");
		vaof = new JLabel("Valoracion:");
		
		comfield = new JTextField(of.getInicio().toString());
		prefield = new JTextField(of.getPrecio() + "€");
		fifield = new JTextField(of.getFianza() + "€");
		valfield = new JTextField(String.format("%.2f", of.calcularMediaValoraciones()));
		nvalfield = new JTextField("");
		anabutton = new JButton("Añadir Valoracion");
		anabutton.addActionListener(new ControladorAnadirValOferta(app, this));
		reservar = new JButton("Reservar Oferta");
		reservar.addActionListener(new ControladorReservarOferta(app, this));
		volver = new JButton("Volver");
		
		prefield.setEditable(false);
		fifield.setEditable(false);
		valfield.setEditable(false);
		tipofield.setEditable(false);
		
		hileft.add(comof, Component.CENTER_ALIGNMENT);
		hileft.add(comfield, Component.CENTER_ALIGNMENT);
		if(of.isVacacional()) {
			finfield = new JTextField(((Vacacional)of).getFin().toString());
			finof = new JLabel("Fin de la oferta:");
			hileft.add(finof, Component.CENTER_ALIGNMENT);
			hileft.add(finfield, Component.CENTER_ALIGNMENT);
		}
		hiright.add(preof, Component.CENTER_ALIGNMENT);
		hiright.add(prefield, Component.CENTER_ALIGNMENT);
		hiright.add(fiof, Component.CENTER_ALIGNMENT);
		hiright.add(fifield, Component.CENTER_ALIGNMENT);
		horizontalhi.add(hileft, Component.CENTER_ALIGNMENT);
		horizontalhi.add(hiright, Component.CENTER_ALIGNMENT);
		mainpanel.add(toferta, Component.CENTER_ALIGNMENT);
		mainpanel.add(tipofield, Component.CENTER_ALIGNMENT);
		mainpanel.add(horizontalhi, Component.CENTER_ALIGNMENT);
		mainpanel.add(vaof, Component.CENTER_ALIGNMENT);
		mainpanel.add(valfield, Component.CENTER_ALIGNMENT);
		mainpanel.add(nvalfield, Component.CENTER_ALIGNMENT);
		mainpanel.add(anabutton, Component.CENTER_ALIGNMENT);
		horizontallow.add(volver, Component.CENTER_ALIGNMENT);
		horizontallow.add(reservar, Component.CENTER_ALIGNMENT);
		
		mainpanel.add(horizontallow, BorderLayout.CENTER);
		this.add(mainpanel, BorderLayout.CENTER);
	}
	
	public Oferta getOferta() {
		return oferta;
	}
	
	public String getVal() {
		return nvalfield.getText();
	}
	
	public JTextField getVals() {
		return valfield;
	}
	
	public JButton getAnadir() {
		return anabutton;
	}
	
	public JButton getRButton() {
		return reservar;
	}
	
	
	
}
