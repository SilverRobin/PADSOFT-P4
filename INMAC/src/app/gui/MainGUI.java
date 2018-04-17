package app.gui;

import java.awt.*;

import javax.swing.JFrame;

import app.gui.Login.*;
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
		login = new LogInScreen();
		this.add(login);
		this.pack();
		this.setVisible(true);
		this.setSize(tamanyo.width*30/100, tamanyo.height*80/100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
