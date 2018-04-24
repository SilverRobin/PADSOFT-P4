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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LogInScreen login;
	private SearchScreen search;
	private Dimension tamanyo = Toolkit.getDefaultToolkit().getScreenSize();
	private int height, width;
	
	public MainGUI(Sistema sistema) {
		super("INMAC");
		height = tamanyo.height*80/100;
		width = tamanyo.width*80/100;
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		login = new LogInScreen();
		login.setPreferredSize(new Dimension(width*20/100, height));
		search = new SearchScreen();
		search.setPreferredSize(new Dimension(width*20/100, height));
		this.add(search, BorderLayout.LINE_START);//Parte izquierda de la pantalla. Busqueda
		this.add(login, BorderLayout.LINE_END); //Parte derecha de la pantalla. Login
		this.pack();
		this.setVisible(true);
		this.setSize(width, height);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
