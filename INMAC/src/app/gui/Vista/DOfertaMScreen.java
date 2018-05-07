package app.gui.Vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.Controlador.ControladorAnadirValOferta;
import app.Controlador.ControladorCNewOferta;
import app.Controlador.ControladorReservarOferta;
import app.Controlador.ControladorVolver;
import app.proyecto.Oferta.EstadoOferta;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Oferta.Vacacional;
import app.proyecto.Sistema.Sistema;

/**
 * Panel de oferta central de Demandante
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class DOfertaMScreen extends JPanel{

	private static final long serialVersionUID = 1L;

	public enum TipoView{
		USER,
		GERENTE
	}
	
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
	private JButton contratar;
	private JButton reservar;
	private JButton volver;
	
	
	/**
	 * Consructor de panel de oferta izquierdo de Demandante
	 * @param app Aplicacion del sistema
	 * @param of Oferta a mostrar
	 * @param t tipo de vista
	 */
	public DOfertaMScreen(Sistema app, Oferta of, TipoView t) {
		
		this.setLayout(new GridBagLayout());
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
		JPanel horizontalhi = new JPanel();
		horizontalhi.setLayout(new BoxLayout(horizontalhi, BoxLayout.X_AXIS));
		JPanel hileft = new JPanel();
		hileft.setLayout(new BoxLayout(hileft, BoxLayout.Y_AXIS));
		JPanel hiright = new JPanel();
		hiright.setLayout(new BoxLayout(hiright, BoxLayout.Y_AXIS));
		JPanel horizontallow = new JPanel();
		horizontallow.setLayout(new BoxLayout(horizontallow, BoxLayout.Y_AXIS));
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
		tipofield.setHorizontalAlignment(JTextField.CENTER);
		tipofield.setAlignmentX(Component.CENTER_ALIGNMENT);
		tipofield.setPreferredSize(new Dimension(130, 20));
		tipofield.setMinimumSize(new Dimension(130, 20));
		tipofield.setMaximumSize(new Dimension(130, 20));
		
		toferta = new JLabel("Tipo de Oferta:");
		toferta.setHorizontalAlignment(JLabel.CENTER);
		toferta.setAlignmentX(Component.CENTER_ALIGNMENT);
		comof = new JLabel("Comienzo de la oferta:");
		comof.setHorizontalAlignment(JLabel.CENTER);
		comof.setAlignmentX(Component.CENTER_ALIGNMENT);
		preof = new JLabel("Precio:");
		preof.setHorizontalAlignment(JLabel.CENTER);
		preof.setAlignmentX(Component.CENTER_ALIGNMENT);
		fiof = new JLabel("Fianza:");
		fiof.setHorizontalAlignment(JLabel.CENTER);
		fiof.setAlignmentX(Component.CENTER_ALIGNMENT);
		vaof = new JLabel("Valoracion:");
		vaof.setHorizontalAlignment(JLabel.CENTER);
		vaof.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		comfield = new JTextField(of.getInicio().toString());
		comfield.setHorizontalAlignment(JTextField.CENTER);
		comfield.setAlignmentX(Component.CENTER_ALIGNMENT);
		prefield = new JTextField(of.getPrecio() + "€");
		prefield.setHorizontalAlignment(JTextField.CENTER);
		prefield.setAlignmentX(Component.CENTER_ALIGNMENT);
		fifield = new JTextField(of.getFianza() + "€");
		fifield.setHorizontalAlignment(JTextField.CENTER);
		fifield.setAlignmentX(Component.CENTER_ALIGNMENT);
		valfield = new JTextField(String.format("%.2f", of.calcularMediaValoraciones()));
		valfield.setHorizontalAlignment(JTextField.CENTER);
		valfield.setAlignmentX(Component.CENTER_ALIGNMENT);
		valfield.setMaximumSize(new Dimension(50, 20));
		valfield.setMinimumSize(new Dimension(50, 20));
		valfield.setPreferredSize(new Dimension(50, 20));
		nvalfield = new JTextField("");
		nvalfield.setHorizontalAlignment(JTextField.CENTER);
		nvalfield.setAlignmentX(Component.CENTER_ALIGNMENT);
		nvalfield.setAlignmentX(Component.CENTER_ALIGNMENT);
		nvalfield.setMaximumSize(new Dimension(50, 25));
		nvalfield.setMinimumSize(new Dimension(50, 25));
		nvalfield.setPreferredSize(new Dimension(50, 25));
		
		contratar = new JButton("Contratar Oferta");
		contratar.addActionListener(new ControladorCNewOferta(app, of, this));
		contratar.setAlignmentX(Component.CENTER_ALIGNMENT);
		contratar.setPreferredSize(new Dimension(140, 25));
		contratar.setMinimumSize(new Dimension(140, 25));
		contratar.setMaximumSize(new Dimension(140, 25));
		
		anabutton = new JButton("Añadir Valoracion");
		anabutton.setAlignmentX(Component.CENTER_ALIGNMENT);
		anabutton.addActionListener(new ControladorAnadirValOferta(app, this));
		anabutton.setPreferredSize(new Dimension(140, 25));
		anabutton.setMinimumSize(new Dimension(140, 25));
		anabutton.setMaximumSize(new Dimension(140, 25));
		reservar = new JButton("Reservar Oferta");
		reservar.setAlignmentX(Component.CENTER_ALIGNMENT);
		reservar.addActionListener(new ControladorReservarOferta(app, this));
		volver = new JButton("Volver");
		volver.addActionListener(new ControladorVolver(this));
		volver.setAlignmentX(Component.CENTER_ALIGNMENT);
		volver.setPreferredSize(new Dimension(140, 25));
		volver.setMinimumSize(new Dimension(140, 25));
		volver.setMaximumSize(new Dimension(140, 25));
		reservar.setPreferredSize(new Dimension(140, 25));
		reservar.setMinimumSize(new Dimension(140, 25));
		reservar.setMaximumSize(new Dimension(140, 25));
		
		comfield.setEditable(false);
		prefield.setEditable(false);
		fifield.setEditable(false);
		valfield.setEditable(false);
		tipofield.setEditable(false);
		if(app.getLogged() != null && of.getVisibilidad() != EstadoOferta.DISPONIBLE) {
			reservar.setEnabled(false);
			reservar.setText("Ya reservada");
			contratar.setEnabled(false);
			contratar.setText("Ya reservada");
		}else if(app.getLogged() == null) {
			contratar.setEnabled(false);
			reservar.setEnabled(false);
			anabutton.setEnabled(false);
		}else if(app.getLogged() != null && app.getLogged().getAviso() != null) {
			reservar.setEnabled(false);
			reservar.setText("Error en tarjeta");
			contratar.setEnabled(false);
			contratar.setText("Error en tarjeta");
		}
		
		hileft.setPreferredSize(new Dimension(130, 100));
		hileft.setMinimumSize(new Dimension(130, 60));
		hileft.setMaximumSize(new Dimension(130, 100));
		hiright.setPreferredSize(new Dimension(70, 100));
		hiright.setMinimumSize(new Dimension(70, 60));
		hiright.setMaximumSize(new Dimension(70, 100));
		hileft.add(comof, Component.CENTER_ALIGNMENT);
		hileft.add(Box.createRigidArea(new Dimension(0, 5)));
		hileft.add(comfield, Component.CENTER_ALIGNMENT);
		if(of.isVacacional()) {
			finfield = new JTextField(((Vacacional)of).getFin().toString());
			finfield.setAlignmentX(Component.CENTER_ALIGNMENT);
			finfield.setHorizontalAlignment(JTextField.CENTER);
			finof = new JLabel("Fin de la oferta:");
			finof.setAlignmentX(Component.CENTER_ALIGNMENT);
			finof.setHorizontalAlignment(JLabel.CENTER);
			finfield.setEditable(false);
			hileft.add(Box.createRigidArea(new Dimension(0, 15)));
			hileft.add(finof, Component.CENTER_ALIGNMENT);
			hileft.add(Box.createRigidArea(new Dimension(0, 5)));
			hileft.add(finfield, Component.CENTER_ALIGNMENT);
		}
		hiright.add(preof, Component.CENTER_ALIGNMENT);
		hiright.add(Box.createRigidArea(new Dimension(0, 5)));
		hiright.add(prefield, Component.CENTER_ALIGNMENT);
		hiright.add(Box.createRigidArea(new Dimension(0, 15)));
		hiright.add(fiof, Component.CENTER_ALIGNMENT);
		hiright.add(Box.createRigidArea(new Dimension(0, 5)));
		hiright.add(fifield, Component.CENTER_ALIGNMENT);
		horizontalhi.add(hileft, Component.CENTER_ALIGNMENT);
		horizontalhi.add(Box.createRigidArea(new Dimension(10, 0)));
		horizontalhi.add(hiright, Component.CENTER_ALIGNMENT);
		mainpanel.add(toferta, Component.CENTER_ALIGNMENT);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 5)));
		mainpanel.add(tipofield, Component.CENTER_ALIGNMENT);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 15)));
		mainpanel.add(horizontalhi, Component.CENTER_ALIGNMENT);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 15)));
		if(t != TipoView.GERENTE) {
			mainpanel.add(vaof, Component.CENTER_ALIGNMENT);
			mainpanel.add(Box.createRigidArea(new Dimension(0, 5)));
			mainpanel.add(valfield, Component.CENTER_ALIGNMENT);
			mainpanel.add(Box.createRigidArea(new Dimension(0, 15)));
			mainpanel.add(nvalfield, Component.CENTER_ALIGNMENT);
		}
		mainpanel.add(Box.createRigidArea(new Dimension(0, 25)));
		if(t != TipoView.GERENTE)
			mainpanel.add(anabutton, Component.CENTER_ALIGNMENT);
		
		if(t != TipoView.GERENTE) {
			horizontallow.add(contratar, Component.CENTER_ALIGNMENT);
			horizontallow.add(Box.createRigidArea(new Dimension(0, 10)));
			horizontallow.add(reservar, Component.CENTER_ALIGNMENT);
			horizontallow.add(Box.createRigidArea(new Dimension(0, 10)));
		}
		horizontallow.add(volver, Component.CENTER_ALIGNMENT);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 15)));
		mainpanel.add(horizontallow, BorderLayout.CENTER);
		this.add(mainpanel);
	}
	
	/**
	 * Devuelve la oferta que se esta viendo actualmente
	 * @return Oferta
	 */
	public Oferta getOferta() {
		return oferta;
	}
	
	/**
	 * Obtiene el valor
	 * @return cadena con valor
	 */
	public String getVal() {
		return nvalfield.getText();
	}
	
	/**
	 * Obtiene el campo del valor
	 * @return campo del valor
	 */
	public JTextField getVals() {
		return valfield;
	}
	
	/**
	 * Obtiene el boton de añadir
	 * @return boton de añadir
	 */
	public JButton getAnadir() {
		return anabutton;
	}
	
	/**
	 * Obtiene el boton de contratar
	 * @return boton de contratar
	 */
	public JButton getCButton() {
		return contratar;
	}
	
	/**
	 * Obtiene el boton de reservar
	 * @return boton de reservar
	 */
	public JButton getRButton() {
		return reservar;
	}
	
	
	
}
