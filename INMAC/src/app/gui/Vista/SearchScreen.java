/**
 * 
 */
package app.gui.Vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

/**
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class SearchScreen extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton buscar;
	private JRadioButton disponibles;
	private JRadioButton todas;
	private ButtonGroup radios;
	private JFormattedTextField cp;
	private JDateChooser inicio;
	private JDateChooser fin;
	private JCheckBox vacButton;
    private JCheckBox larButton;
    private JRadioButton dispb;
    private JPanel checkPanel;
	private JPanel basico;
	private JPanel fechas;
	private JPanel codigo;
	private JPanel slider;
	private JSlider valoracion;
	/**
	 * 
	 */
	public SearchScreen() {
		super();
		JLabel labelcp = new JLabel("Código postal");
		JLabel labeli = new JLabel("Fecha de inicio:");
		JLabel labelf = new JLabel("Fecha de fin:");
		JLabel labelv = new JLabel("Valoración");
		
		this.setLayout(new BorderLayout());
		GridBagConstraints c = new GridBagConstraints();
		basico = new JPanel();
		codigo = new JPanel();
		codigo.setLayout(new BoxLayout(codigo, BoxLayout.Y_AXIS));

		//Panel de codigo postal
		buscar = new JButton("Buscar");
		cp = new JFormattedTextField(
				createFormatter("#####"));
		cp.setColumns(10);
		cp.setMaximumSize(cp.getPreferredSize());
		labelcp.setAlignmentX(Component.CENTER_ALIGNMENT);
		cp.setAlignmentX(Component.CENTER_ALIGNMENT);
		codigo.add(labelcp);
		codigo.add(cp);
		
		//Botonera de seleccion de tipo de estancia
		checkPanel = new JPanel(new GridLayout(2, 2));
		larButton = new JCheckBox("Larga Estancia");
		vacButton = new JCheckBox("Vacacional");
		checkPanel.add(larButton);
		checkPanel.add(vacButton);
		disponibles = new JRadioButton("Disponibles");
		//Nuevo
		todas = new JRadioButton("Todas");
		radios = new ButtonGroup();
		this.radios.add(disponibles);
		this.radios.add(todas);
		checkPanel.add(disponibles);
		checkPanel.add(todas);
		checkPanel.setVisible(false);
		
		dispb = new JRadioButton("Filtrar no disponibles");
		dispb.setSelected(false);
		
		
		//Panel de seleccion de fechas
		inicio = new JDateChooser(); 
		fin = new JDateChooser();
		fechas = new JPanel(new GridBagLayout());
		//fechas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1.0;
		fechas.add(labeli, c); //Etiquetas
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 1.0;
		fechas.add(labelf, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 1;
		c.gridx = 0;
		c.weightx = 0.5;
		
		fechas.add(inicio, c);//Selectores de fechas
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 1;
		c.gridx = 2;
		c.weightx = 0.5;
		fechas.add(fin, c);
		
		//Selector de valoraciones
		slider = new JPanel();
		slider.setLayout(new BoxLayout(slider, BoxLayout.Y_AXIS));
		valoracion = new JSlider(JSlider.HORIZONTAL, 1, 5, 3);
		labelv.setAlignmentX(Component.CENTER_ALIGNMENT);
		valoracion.setAlignmentX(Component.CENTER_ALIGNMENT);
		valoracion.setMajorTickSpacing(1);
		valoracion.setPaintLabels(true);
		valoracion.setPaintTicks(true);
		slider.add(labelv);
		slider.add(valoracion);

		//Panel Basico
		basico.setLayout(new GridBagLayout());
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		basico.add(codigo,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		basico.add(fechas,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		basico.add(checkPanel, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		basico.add(slider,c);
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		basico.add(buscar,c);
		
		
		//basico.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setBorder(BorderFactory.createTitledBorder("Busqueda de inmuebles"));
		
		this.add(basico, BorderLayout.CENTER);
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
    
    public void desbloquearPanel(boolean b) {
    	this.checkPanel.setVisible(b);
    }
    
    public String getCP() {
    	return this.cp.getText();
    }
    
    public LocalDate getInicio() {
    	return LocalDate.ofInstant(this.inicio.getDate().toInstant(), ZoneId.systemDefault());
    }
    
    public LocalDate getFin() {
    	return LocalDate.ofInstant(this.fin.getDate().toInstant(), ZoneId.systemDefault());
    }
    
    public boolean isLESelected() {
    	return this.larButton.isSelected();
    }
    
    public boolean isVacSelected() {
    	return this.vacButton.isSelected();
    }
    
    public int valoracion() {
    	return this.valoracion.getValue();
    }
}
