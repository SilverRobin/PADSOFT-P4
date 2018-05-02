/**
 * 
 */
package app.gui.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
	private Dimension tamanyo = Toolkit.getDefaultToolkit().getScreenSize();
	private int height, width;
	
	/**
	 * 
	 */
	public OfertanteMScreen() {
		height = tamanyo.height;
		width = tamanyo.width;
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		this.setLayout(new BorderLayout());
		JPanel minipanel = new JPanel(new GridLayout(2,2, height*10/100, width*10/100));
		JPanel minipanel2 = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;

		minipanel.setPreferredSize(new Dimension(width*50/100, height*50/100));

		addOferta = new JButton("Añadir oferta");
		addOferta.setFont(f);
		addVivienda = new JButton("Añadir inmueble");
		addVivienda.setFont(f);
		modOferta = new JButton("Modificar oferta");
		modOferta.setFont(f);
		verAvisos = new JButton("Ver avisos");
		verAvisos.setFont(f);
		cerrarSesion = new JButton("Cerrar sesión");
		cerrarSesion.setFont(f);
		cerrarSesion.setPreferredSize(new Dimension(width*28/100,height*18/100));
		
		minipanel.add(addOferta);
		minipanel.add(addVivienda);
		minipanel.add(modOferta);
		minipanel.add(verAvisos);


		minipanel2.add(cerrarSesion, gbc);

		

		
		add(minipanel, BorderLayout.PAGE_START);
		add(minipanel2, BorderLayout.CENTER);
		
		this.setBorder(BorderFactory.createTitledBorder("Lista de inmuebles"));
		
	}

}
