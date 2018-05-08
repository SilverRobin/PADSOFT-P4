package app.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Toolkit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import app.gui.Vista.*;
import app.proyecto.Sistema.*;

/**
 * Ventana de la aplicacion
 * @author Antonio Oliva
 *
 */
public class MainGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedHashMap<String, JPanel> ld, li, lc;
	private JPanel dcha;
	private JPanel izqda;
	private JPanel centro;
	private Dimension tamanyo = Toolkit.getDefaultToolkit().getScreenSize();
	private int height, width;
	private Sistema app;
	
	/**
	 * Constructor de la ventana
	 * @param sistema Aplicacion del sistema
	 */
	public MainGUI(Sistema sistema) {
		super("INMAC");
		
		ld = new LinkedHashMap<>();
		li = new LinkedHashMap<>();
		lc = new LinkedHashMap<>();
		
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

		ResultScreen rs = new ResultScreen(sistema);
		izqda.add(new SearchScreen(sistema), "Search");		
		centro.add(rs, "Results");
		dcha.add(new LogInScreen(app, rs), "LogIn");

		this.add(izqda, BorderLayout.LINE_START);//Parte izquierda de la pantalla. Busqueda
		this.add(centro, BorderLayout.CENTER);
		this.add(dcha, BorderLayout.LINE_END); //Parte derecha de la pantalla. Login
		this.pack();
		this.setVisible(true);
		this.setSize(width, height);
		this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
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
		if(lc.containsKey(nombre)){
			this.centro.remove(nuevo);
			this.centro.add(nuevo, nombre);
			return;
		}
		this.centro.add(nuevo, nombre);
		lc.put(nombre, nuevo);
		this.validate();
	}
	
	/**
	 * Añade un panel nuevo en las cartas de la derecha
	 * @param nuevo Nuevo panel derecho
	 * @param nombre Nombre del panel. Debe ser unico
	 */
	public void cambiaDerecha(JPanel nuevo, String nombre) {
		if(ld.containsKey(nombre)) {
			this.dcha.remove(nuevo);
			this.dcha.add(nuevo, nombre);
			return;
		}
		this.dcha.add(nuevo, nombre);
		ld.put(nombre, nuevo);
		this.validate();
	}
	
	/**
	 * Añade un panel nuevo a las cartas de la izquierda
	 * @param nuevo Nuevo panel izquierdo
	 * @param nombre Nombre del panel. Debe ser unico
	 */
	public void cambiaIzquierda(JPanel nuevo, String nombre) {
		if(li.containsKey(nombre)) {
			this.izqda.remove(nuevo);
			this.izqda.add(nuevo, nombre);
			return;
		}
		this.izqda.add(nuevo, nombre);
		li.put(nombre, nuevo);
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
	
	public void volverD() {
		JPanel p = (JPanel) dcha.getComponent(dcha.getComponents().length - 1);
		for(String d : ld.keySet()) {
			if(ld.get(d).equals(p))
				ld.remove(d, ld.get(d));
		}
		dcha.remove(p);
	}
	
	public void volverC() {
		JPanel p = (JPanel) centro.getComponent(centro.getComponents().length - 1);
		for(String d : lc.keySet()) {
			if(lc.get(d).equals(p))
				lc.remove(d, lc.get(d));
		}
		centro.remove(p);
	}
	
	public void volver() {
		JPanel p = (JPanel) dcha.getComponent(dcha.getComponents().length - 1);
		for(String d : ld.keySet()) {
			if(ld.get(d).equals(p))
				ld.remove(d, ld.get(d));
		}
		dcha.remove(p);
		p = (JPanel) izqda.getComponent(izqda.getComponents().length - 1);
		for(String d : li.keySet()) {
			if(li.get(d).equals(p))
				li.remove(d, li.get(d));
		}
		izqda.remove(p);		
		p = (JPanel) centro.getComponent(centro.getComponents().length - 1);
		for(String d : lc.keySet()) {
			if(lc.get(d).equals(p))
				lc.remove(d, lc.get(d));
		}
		centro.remove(p);
	}
	
	public String getDName() {
		String s="";
		for(String r : ld.keySet()) {
			s = r;
		}
		return s;
	}
	
	public String getIName() {
		String s="";
		for(String r : li.keySet()) {
			s = r;
		}
		return s;
	}
	
	public String getCName() {
		String s="";
		for(String r : lc.keySet()) {
			s = r;
		}
		return s;
	}
}
