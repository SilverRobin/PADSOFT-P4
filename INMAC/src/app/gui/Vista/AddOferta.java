/**
 * 
 */
package app.gui.Vista;

import com.toedter.calendar.JDateChooser;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import app.proyecto.Sistema.Sistema;

/**
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class AddOferta extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel label1, label2, label3, label4, label5;
	private JComboBox<String> tipoOferta;
	private JDateChooser inicio;
	private JDateChooser fin;
	private JFormattedTextField precio;
	private JFormattedTextField fianza;
	private JFormattedTextField meses;
	private JButton addOferta;
	private JButton volver;
	
	
	public AddOferta(Sistema app) {
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createTitledBorder("Crear nueva oferta"));
		GridBagConstraints gbc = new GridBagConstraints();
		
		/* ---- Panel de seleccion de tipo -----*/
		JPanel top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
		top.setBorder(BorderFactory.createTitledBorder("Tipo de oferta"));
		String[] tipo = { "Vacacional", "Larga estancia"};
		label1 = new JLabel("Seleccionar tipo");
		top.add(label1);
		tipoOferta = new JComboBox(tipo);
		tipoOferta.setSelectedIndex(0);
		top.add(tipoOferta);
		//tipoOferta.addActionListener();
		
		
		/* --- PANEL DE FECHAS Y PERIODOS ----*/
		JPanel midL = new JPanel();
		midL.setLayout(new BoxLayout(midL, BoxLayout.Y_AXIS)); 
		midL.setBorder(BorderFactory.createTitledBorder("Periodo"));
		label2 = new JLabel("Fecha de inicio");
		inicio = new JDateChooser();
		label3 = new JLabel("Meses");
		meses = new JFormattedTextField(
				createFormatter("##"));
		meses.setColumns(2);
		meses.setMaximumSize(meses.getPreferredSize());
		label3 = new JLabel("Fecha de fin");
		fin = new JDateChooser();
		midL.add(label2);
		midL.add(inicio);
		midL.add(label3);
		midL.add(meses);
		midL.add(label3);
		midL.add(fin);
		label3.setVisible(false);
		meses.setVisible(false);
		
		/* ---- PANEL DE PRECIO -----*/
		JPanel midR = new JPanel();
		midR.setLayout(new BoxLayout(midR, BoxLayout.Y_AXIS)); 
		midR.setBorder(BorderFactory.createTitledBorder("Precio"));
		label4 = new JLabel("Precio");
		label4.setAlignmentX(CENTER_ALIGNMENT);
		precio = new JFormattedTextField(
				createFormatter("#####"));
		precio.setColumns(10);
		precio.setMaximumSize(precio.getPreferredSize());
		precio.setAlignmentX(CENTER_ALIGNMENT);
		label5 = new JLabel("Fianza");
		label5.setAlignmentX(CENTER_ALIGNMENT);
		fianza = new JFormattedTextField(
				createFormatter("#####"));
		fianza.setColumns(10);
		fianza.setMaximumSize(fianza.getPreferredSize());
		fianza.setAlignmentX(CENTER_ALIGNMENT);
		midR.add(label4);
		midR.add(precio);
		midR.add(label5);
		midR.add(fianza);
		
		/*------ PANEL DE BOTONES  ----------*/
		JPanel bot = new JPanel();
		bot.setLayout(new BoxLayout(bot, BoxLayout.X_AXIS));
		volver = new JButton("Cancelar");
		addOferta = new JButton(" Añadir ");
		bot.add(volver);
		bot.add(Box.createRigidArea(new Dimension(5, 1)));
		bot.add(addOferta);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 2, 0);
		this.add(top, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 0, 2, 5);
		this.add(midL, gbc);
		gbc.gridx = 1;
		this.add(midR, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		this.add(bot, gbc);	
		
	}
	
	   protected MaskFormatter createFormatter(String s) {
	        MaskFormatter formatter = null;
	        try {
	            formatter = new MaskFormatter(s);
	        } catch (java.text.ParseException exc) {
	            System.err.println("formatter is bad: " + exc.getMessage());
	            System.exit(-1);
	        }
	        return formatter;
	    }

}
