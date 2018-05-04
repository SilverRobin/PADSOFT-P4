package app.gui.Vista;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		reservar = new JButton("Reservar Oferta");
		volver = new JButton("Volver");
		
		prefield.setEditable(false);
		fifield.setEditable(false);
		valfield.setEditable(false);
		tipofield.setEditable(false);
		
		hileft.add(comof);
		hileft.add(comfield);
		if(of.isVacacional()) {
			finfield = new JTextField(((Vacacional)of).getFin().toString());
			finof = new JLabel("Fin de la oferta:");
			hileft.add(finof);
			hileft.add(finfield);
		}
		hiright.add(preof);
		hiright.add(prefield);
		hiright.add(fiof);
		hiright.add(fifield);
		horizontalhi.add(hileft);
		horizontalhi.add(hiright);
		mainpanel.add(toferta);
		mainpanel.add(tipofield);
		mainpanel.add(horizontalhi);
		mainpanel.add(vaof);
		mainpanel.add(valfield);
		mainpanel.add(nvalfield);
		mainpanel.add(anabutton);
		horizontallow.add(volver);
		horizontallow.add(reservar);
		mainpanel.add(horizontallow);
		this.add(mainpanel);
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
