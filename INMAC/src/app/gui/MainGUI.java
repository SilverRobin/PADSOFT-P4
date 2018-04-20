package app.gui;

import java.awt.*;

import javax.swing.JFrame;

import app.gui.Vista.*;
import app.proyecto.Sistema.*;

/**
 * 
 * @author Antonio Oliva
 *
 */
public class MainGUI extends JFrame{
	private LogInScreen login;
	Dimension tamanyo = Toolkit.getDefaultToolkit().getScreenSize();
	
	public MainGUI(Sistema sistema) {
		super("INMAC");
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		login = new LogInScreen();
		this.add(login, BorderLayout.LINE_END);
		this.pack();
		this.setVisible(true);
		this.setSize(tamanyo.width*80/100, tamanyo.height*80/100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
