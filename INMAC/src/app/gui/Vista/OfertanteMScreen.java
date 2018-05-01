/**
 * 
 */
package app.gui.Vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.*;

/**
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class OfertanteMScreen extends JPanel {
	private JButton addOferta;
	private JButton addVivienda;
	private JButton modOferta;
	private JButton verAvisos;
	private JButton cerrarSesion;
	
	/**
	 * 
	 */
	public OfertanteMScreen() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		addOferta = new JButton("Añadir vferta");
		addVivienda = new JButton("Añadir inmueble");
		modOferta = new JButton("Modificar oferta");
		verAvisos = new JButton("Ver avisos");
		cerrarSesion = new JButton("Cerrar sesión");
		
		add(addOferta);
		add(addVivienda);
		add(modOferta);
		add(verAvisos);
		add(Box.createVerticalGlue());
		add(cerrarSesion);
		
	}

}
