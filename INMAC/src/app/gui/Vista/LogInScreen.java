package app.gui.Vista;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.*;


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
	private JPasswordField passfield;
	private JTextField niffield;
	private JPanel panel;
	private JPanel paneltop;
	private JPanel panelbot;
	private JLabel label1, labelpass;
	
	
	public LogInScreen() {
		super();
		//((JFrame) this.getParent()).setTitle("Iniciar Sesion");
		this.setLayout(new GridBagLayout());

		volver = new JButton("Volver");
		login = new JButton("Iniciar sesion");
		passfield = new JPasswordField("Password...");
		niffield = new JTextField("NIF...");
		label1 = new JLabel("Número de Identificación");
		label1.setLabelFor(niffield);
		labelpass = new JLabel("Contraseña");
		labelpass.setLabelFor(passfield);
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
		panelbot.setLayout(new GridLayout(1, 2, 2, 0));//Espacios entre los botones para que quede mas bonico
		panelbot.add(volver);
		panelbot.add(login);

		
		panel.add(paneltop);
		panel.add(panelbot);
		
		this.add(panel);
		this.setBorder(BorderFactory.createTitledBorder("Inicio de sesión"));
	}
	

	

}
