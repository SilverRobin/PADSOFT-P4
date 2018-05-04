/**
 * 
 */
package app.gui.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import app.Controlador.ControladorAddInmueble;
import app.proyecto.Sistema.Sistema;

/**
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class AddInmuebleScreen extends JPanel {
	
	private JPanel panelDireccion;
	private JPanel panelDescripcion;
	private JPanel panelCaracteristicas;
	private JPanel panelBotones;
	
	private JTextField codigo;
	private JTextField localidad;
	private JTextField direccion;
	
	private JTextArea descripcion;
	
	private JTextField nombreCaracteristica;
	private JList lista;
	private DefaultListModel listModel;
	private JTextField descCaracteristica;
	private JButton addCaracteristica;
	private JButton deleteCaracteristica;
	
	private JButton volver;
	private JButton addInmueble;
	
	
	/**
	 * 
	 */
	public AddInmuebleScreen(Sistema app) {
		this.setLayout(new BorderLayout());
		JPanel contenedor = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		String[] caract = { "Piscina", "Trastero", "Garaje", "Jardín", "Ascensor" };
		
		/*PANEL DE DIRECCION */
		panelDireccion = new JPanel();
		panelDireccion.setBorder(BorderFactory.createTitledBorder("Dirección"));
		panelDireccion.setLayout(new BoxLayout(panelDireccion, BoxLayout.Y_AXIS));
		codigo = new JFormattedTextField(
				createFormatter("#####"));
		codigo.setColumns(5);
		codigo.setMaximumSize(codigo.getPreferredSize());
		
		JLabel label1= new JLabel("Código postal");
		label1.setAlignmentX(CENTER_ALIGNMENT);
		panelDireccion.add(label1);
		panelDireccion.add(codigo);
		panelDireccion.add(Box.createVerticalGlue());
		localidad = new JTextField();
		localidad.setColumns(20);
		localidad.setMaximumSize(localidad.getPreferredSize());
		direccion = new JTextField();
		direccion.setColumns(30);
		JLabel label2= new JLabel("Localidad");
		label2.setAlignmentX(CENTER_ALIGNMENT);
		panelDireccion.add(label2);
		panelDireccion.add(localidad);
		panelDireccion.add(Box.createVerticalGlue());
		JLabel label3 = new JLabel("Direccion");
		label3.setAlignmentX(CENTER_ALIGNMENT);
		panelDireccion.add(label3);
		panelDireccion.add(direccion);
		
		/*PANEL DE CARACTERISTICAS*/
		panelCaracteristicas = new JPanel();
		panelCaracteristicas.setBorder(BorderFactory.createTitledBorder("Características"));
		panelCaracteristicas.setLayout(new BoxLayout(panelCaracteristicas, BoxLayout.Y_AXIS));
		listModel = new DefaultListModel();
		lista = new JList(listModel);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setSelectedIndex(0);
        lista.setVisibleRowCount(10);
        lista.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 9)); //Nos quedamos con esta fuente, supongo
        JScrollPane listScrollPane = new JScrollPane(lista);
        listScrollPane.setAlignmentX(CENTER_ALIGNMENT);
        JLabel label4 = new JLabel("Lista de caracteristicas"); 
        label4.setAlignmentX(CENTER_ALIGNMENT);
        panelCaracteristicas.add(label4);
        panelCaracteristicas.add(listScrollPane);
        nombreCaracteristica = new JTextField();
        nombreCaracteristica.setAlignmentX(CENTER_ALIGNMENT);
        JLabel label5 = new JLabel("Selecciona una caracteristica"); 
        label5.setAlignmentX(CENTER_ALIGNMENT);
        panelCaracteristicas.add(label5);
        panelCaracteristicas.add(nombreCaracteristica);
        descCaracteristica = new JTextField();
        descCaracteristica.setAlignmentX(CENTER_ALIGNMENT);
        JLabel label6 = new JLabel("Descripción caracteristica");
        label6.setAlignmentX(CENTER_ALIGNMENT);
        panelCaracteristicas.add(label6);
        panelCaracteristicas.add(descCaracteristica);
        addCaracteristica = new JButton("  Añadir característica ");
        addCaracteristica.setAlignmentX(CENTER_ALIGNMENT);
        deleteCaracteristica = new JButton("Eliminar característica");
        deleteCaracteristica.setAlignmentX(CENTER_ALIGNMENT);
        panelCaracteristicas.add(Box.createRigidArea(new Dimension(2,8)));
        panelCaracteristicas.add(addCaracteristica);
        panelCaracteristicas.add(Box.createRigidArea(new Dimension(2,4)));
        panelCaracteristicas.add(deleteCaracteristica);
        
		/*PANEL DE DESCRIPCION*/
        panelDescripcion = new JPanel(new GridLayout());
        panelDescripcion.setBorder(BorderFactory.createTitledBorder("Descripción"));
        descripcion = new JTextArea(30, 30);
        descripcion.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
        panelDescripcion.add(descripcion);
        
		/*PANEL CON BOTONES*/
        panelBotones = new JPanel(new GridLayout(1, 2, 10, 5));
        volver = new JButton("Volver");
        addInmueble = new JButton("Añadir inmueble");
       
        panelBotones.add(volver);
		panelBotones.add(addInmueble);
		
		/*AÑADIMOS SUBPANELES A PANEL PRINCIPAL*/
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 0.5;
		gbc.weighty = 0.3;
		contenedor.add(panelDireccion, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 0.5;
		gbc.weighty = 0.3;
		contenedor.add(panelDescripcion, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 0.5;
		gbc.weighty = 0.6;
		gbc.gridheight = 2;
		contenedor.add(panelCaracteristicas, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 1;
		gbc.weighty = 0.3;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		contenedor.add(panelBotones, gbc);
		
		
		this.add(contenedor, BorderLayout.CENTER);
		contenedor.setBorder(BorderFactory.createTitledBorder("Añadir inmueble"));
	}
	
    /**
     * A convenience method for creating a MaskFormatter.
     * @param s Formato en el que queremos el texto
     * @return Mascara de formato
     */
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
