package app.gui.Login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Elemento de GUI que muestra la ventana de
 * inicio de sesion
 * 
 * @author Antonio Oliva
 *
 */
public class LogInScreen extends JFrame{
	
	static final long serialVersionUID = 1;
	
	private JButton volver;
	private JButton login;
	private JPasswordField passfield;
	private JTextField niffield;
	private JPanel panel;
	
	public LogInScreen() {
		super();
		this.setTitle("Iniciar Sesion");
		volver = new JButton("Volver");
		login = new JButton("Iniciar sesion");
		panel = new JPanel();
	}	
	

}
