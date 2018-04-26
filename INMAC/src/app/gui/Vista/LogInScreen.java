package app.gui.Vista;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.*;

import app.Controlador.ControladorInicioSesion;
import app.proyecto.Sistema.Sistema;


/**
 * Elemento de GUI que muestra la ventana de
 * inicio de sesion
 * 
 * @author Antonio Oliva
 *
 */
public class LogInScreen extends JPanel{
	
	static final long serialVersionUID = 1;
	
	private JButton volver;
	private JButton login;
	private JRadioButton dButton;
	private JRadioButton oButton;
	private ButtonGroup group;
	private JPasswordField passfield;
	private JTextField niffield;
	private JPanel panel;
	private JPanel paneltop;
	private JPanel panelbot;
	private JPanel panelmid;
	private JLabel label1, labelpass;
	
	
	public LogInScreen(Sistema app) {
		super();
		//((JFrame) this.getParent()).setTitle("Iniciar Sesion");
		this.setLayout(new GridBagLayout());

		volver = new JButton("Volver");
		login = new JButton("Iniciar sesion");
		login.addActionListener(new ControladorInicioSesion(app, this));
		passfield = new JPasswordField("Password...");
		niffield = new JTextField("NIF...");
		label1 = new JLabel("Número de Identificación");
		label1.setLabelFor(niffield);
		labelpass = new JLabel("Contraseña");
		labelpass.setLabelFor(passfield);
		
		group = new ButtonGroup();
		dButton = new JRadioButton("Soy demandante");
		dButton.setSelected(true); //Seleccionamos uno por defecto
		oButton = new JRadioButton("Soy ofertante");
		group.add(dButton);
		group.add(oButton);
		panelmid = new JPanel(new GridLayout(1, 2));
		dButton.setBorder(new EmptyBorder(0, 0, 0, 10)); //Vamos a separar los radiobuttons un poco
		panelmid.setBorder(new EmptyBorder(0, 0, 10, 0));
		panelmid.add(dButton);
		panelmid.add(oButton);
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		paneltop = new JPanel();
		paneltop.setLayout(new GridLayout(4, 1)); //Dos labels + dos jtwext field apilados en vertical
		paneltop.setBorder(new EmptyBorder(0, 0, 10, 0));
		paneltop.add(label1);
		paneltop.add(niffield);
		paneltop.add(labelpass);
		paneltop.add(passfield);
		
		panelbot = new JPanel();
		panelbot.setLayout(new GridLayout(1, 2, 5, 0));//Espacios entre los botones para que quede mas bonico
		panelbot.add(volver);
		panelbot.add(login);

		
		panel.add(paneltop);
		panel.add(panelmid);
		panel.add(panelbot);
		
		this.add(panel);
		this.setBorder(BorderFactory.createTitledBorder("Inicio de sesión"));
	}
	
	public String getNIF() {
		return this.niffield.getText();
	}
	public String getPassword() {
		return String.valueOf(this.passfield.getPassword());
	}
	public boolean isOfertante() {
		if(oButton.isSelected()) {
			return true;
		}
		return false;
	}
	

	

}
