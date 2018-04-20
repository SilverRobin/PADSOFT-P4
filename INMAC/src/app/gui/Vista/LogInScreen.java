package app.gui.Vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.BoxLayout;


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
	private static CardLayout cardlayout = new CardLayout();
	private static JPanel cards = new JPanel(cardlayout);
	
	public LogInScreen() {
		super();
		
		//((JFrame) this.getParent()).setTitle("Iniciar Sesion");
		volver = new JButton("Volver");
		login = new JButton("Iniciar sesion");
		passfield = new JPasswordField("Password...");
		niffield = new JTextField("NIF...");
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		paneltop = new JPanel();
		paneltop.setLayout(new BoxLayout(paneltop, BoxLayout.Y_AXIS));
		paneltop.add(niffield);
		paneltop.add(passfield);
		panelbot = new JPanel();
		panelbot.setLayout(new BoxLayout(panelbot, BoxLayout.X_AXIS));
		panelbot.add(volver);
		panelbot.add(login);

		
		panel.add(paneltop);
		panel.add(panelbot);
		
		this.add(panel);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}
	

}
