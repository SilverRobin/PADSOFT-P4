package app.gui;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
	private JPanel dcha;
	private JPanel izqda;
	private JPanel centro;
	private Dimension tamanyo = Toolkit.getDefaultToolkit().getScreenSize();
	private int height, width;
	private Sistema app;
	
	public MainGUI(Sistema sistema) {
		super("INMAC");
		app = sistema;
		
		height = tamanyo.height*80/100;
		width = tamanyo.width*80/100;
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		dcha = new LogInScreen(app);
		dcha.setPreferredSize(new Dimension(width*20/100, height));
		izqda = new SearchScreen();
		izqda.setPreferredSize(new Dimension(width*20/100, height));
		centro = new ResultScreen();
		centro.setPreferredSize(new Dimension(width*60/100, height));
		this.add(izqda, BorderLayout.LINE_START);//Parte izquierda de la pantalla. Busqueda
		this.add(centro, BorderLayout.CENTER);
		this.add(dcha, BorderLayout.LINE_END); //Parte derecha de la pantalla. Login
		this.pack();
		this.setVisible(true);
		this.setSize(width, height);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Obtiene el panel situado en el centro de la ventana
	 * @return panel central
	 */
	public JPanel getCentro() {
		return centro;
	}
	
	/**
	 * Obtiene el panel situado en el lado derecho de la pantalla
	 * @return panel derecho
	 */
	public JPanel getDerecha() {
		return dcha;
	}
	
	/**
	 * Obtiene el panel situado en el lado izquierdo de la pantalla
	 * @return panel izquierdo
	 */
	public JPanel getIzquierda() {
		return izqda;
	}
	
	/**
	 * Cambia el panel del centro por uno nuevo
	 * @param nuevo Nuevo panel central
	 */
	public void cambiaCentro(JPanel nuevo) {
		this.centro = nuevo;
	}
	
	/**
	 * Cambia el panel derecho por uno nuevo
	 * @param nuevo Nuevo panel derecho
	 */
	public void cambiaDerecha(JPanel nuevo) {
		this.dcha = nuevo;
	}
	
	/**
	 * Cambia el panel izquierdo por uno nuevo
	 * @param nuevo Nuevo panel izquierdo
	 */
	public void cambiaIzquierda(JPanel nuevo) {
		this.izqda = nuevo;
	}
}
