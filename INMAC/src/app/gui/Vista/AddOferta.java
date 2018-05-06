/**
 * 
 */
package app.gui.Vista;

import com.toedter.calendar.JDateChooser;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import app.Controlador.ControladorAddOferta;
import app.proyecto.Sistema.Sistema;

/**
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class AddOferta extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel label1, label2, label3, label4, label5, label6;
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
		
		tipoOferta.setActionCommand("tipo");
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
		meses = new JFormattedTextField(Integer.valueOf("0"));
		meses.setColumns(2);
		meses.setMaximumSize(meses.getPreferredSize());
		label4 = new JLabel("Fecha de fin");
		fin = new JDateChooser();
		midL.add(label2);
		midL.add(inicio);
		midL.add(label3);
		midL.add(meses);
		midL.add(label4);
		midL.add(fin);
		label3.setVisible(false);
		meses.setVisible(false);
		
		/* ---- PANEL DE PRECIO -----*/
		JPanel midR = new JPanel();
		midR.setLayout(new BoxLayout(midR, BoxLayout.Y_AXIS)); 
		midR.setBorder(BorderFactory.createTitledBorder("Precio"));
		label5 = new JLabel("Precio");
		label5.setAlignmentX(Component.CENTER_ALIGNMENT);
		precio = new JFormattedTextField(Integer.valueOf("0"));
		precio.setColumns(10);
		precio.setMaximumSize(precio.getPreferredSize());
		precio.setAlignmentX(Component.CENTER_ALIGNMENT);
		label6 = new JLabel("Fianza");
		label6.setAlignmentX(Component.CENTER_ALIGNMENT);
		fianza = new JFormattedTextField(Integer.valueOf("0"));
		fianza.setColumns(10);
		fianza.setMaximumSize(fianza.getPreferredSize());
		fianza.setAlignmentX(Component.CENTER_ALIGNMENT);
		midR.add(label5);
		midR.add(precio);
		midR.add(label6);
		midR.add(fianza);
		
		/*------ PANEL DE BOTONES  ----------*/
		JPanel bot = new JPanel();
		bot.setLayout(new BoxLayout(bot, BoxLayout.X_AXIS));
		volver = new JButton("Cancelar");
		
		volver.setActionCommand("Volver");
		addOferta = new JButton(" Añadir ");
		
		addOferta.setActionCommand("add");
		bot.add(volver);
		bot.add(Box.createRigidArea(new Dimension(5, 1)));
		bot.add(addOferta);
		
		tipoOferta.addActionListener(new ControladorAddOferta(app, this));
		addOferta.addActionListener(new ControladorAddOferta(app, this));
		volver.addActionListener(new ControladorAddOferta(app, this));
		
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
	   
	   public void modoVacacional() {
		   label2.setVisible(true);
		   inicio.setVisible(true);
		   label3.setVisible(false);
		   meses.setVisible(false);
		   fin.setVisible(true);
		   label4.setVisible(true);
	   }
	   
	   public void modoLargaEstancia() {
		   label2.setVisible(true);
		   inicio.setVisible(true);
		   label3.setVisible(true);
		   meses.setVisible(true);
		   fin.setVisible(false);
		   label4.setVisible(false);
	   }

	public LocalDate getInicio() {
		return LocalDate.ofInstant(this.inicio.getDate().toInstant(), ZoneId.systemDefault());
	}

	public LocalDate getFin() {
		// TODO Auto-generated method stub
		return LocalDate.ofInstant(this.fin.getDate().toInstant(), ZoneId.systemDefault());
	}

	public boolean isVacacional() {
		if(this.tipoOferta.getSelectedItem().equals("Vacacional"))
			return true;
		return false;
	}

	public String getMeses() {
		return this.meses.getText();
	}

	public String getPrecio() {
		// TODO Auto-generated method stub
		return this.precio.getText();
	}

	public String getFianza() {
		// TODO Auto-generated method stub
		return this.fianza.getText();
	}
	   

}
