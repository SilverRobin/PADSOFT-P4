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
		height = tamanyo.height;
		width = tamanyo.width;
		
		dcha = new JPanel(new CardLayout());
		dcha.setPreferredSize(new Dimension(width*20/100, height));
		izqda = new JPanel(new CardLayout());
		izqda.setPreferredSize(new Dimension(width*20/100, height));
		centro = new JPanel(new CardLayout());
		centro.setPreferredSize(new Dimension(width*60/100, height));
		
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		dcha.add(new LogInScreen(app), "LogIn");

		izqda.add(new SearchScreen(), "Search");
		
		centro.add(new ResultScreen(), "Results");

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
	 * Incluye un panel en las cartas centrales
	 * @param nuevo Nuevo panel central
	 * @param nombre Nombre del panel. Debe ser unico
	 */
	public void cambiaCentro(JPanel nuevo, String nombre) {
		this.centro.add(nuevo, nombre);
	}
	
	/**
	 * Añade un panel nuevo en las cartas de la derecha
	 * @param nuevo Nuevo panel derecho
	 * @param nombre Nombre del panel. Debe ser unico
	 */
	public void cambiaDerecha(JPanel nuevo, String nombre) {
		this.dcha.add(nuevo, nombre);
		this.validate();
	}
	
	/**
	 * Añade un panel nuevo a las cartas de la izquierda
	 * @param nuevo Nuevo panel izquierdo
	 * @param nombre Nombre del panel. Debe ser unico
	 */
	public void cambiaIzquierda(JPanel nuevo, String nombre) {;
		this.izqda.add(nuevo, nombre);
		this.validate();
	}
	
	/**
	 * Obtiene la carta que se esta mostrando actualmente en el panel central
	 * @return la carta que se esta mostrando
	 */
	public JPanel getCurrentCardC() {
		JPanel card = null;
		for (Component comp : centro.getComponents()) {
			card = (JPanel) comp;
		}
		return card;
	}
	
	/**
	 * Obtiene la carta que se esta mostrando actualmente en el panel izquierdo
	 * @return la carta que se esta mostrando
	 */
	public JPanel getCurrentCardL() {
		JPanel card = null;
		for (Component comp : izqda.getComponents()) {
			card = (JPanel) comp;
		}
		return card;
	}
	
	/**
	 * Obtiene la carta que se esta mostrando actualmente en el panel derecho
	 * @return la carta que se esta mostrando
	 */
	public JPanel getCurrentCardR() {
		JPanel card = null;
		for (Component comp : dcha.getComponents()) {
			card = (JPanel) comp;
		}
		return card;
	}
}
