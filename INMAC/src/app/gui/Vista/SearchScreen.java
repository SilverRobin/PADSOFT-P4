/**
 * 
 */
package app.gui.Vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	private JFormattedTextField cp;
	private JDateChooser inicio;
	private JDateChooser fin;
	private JPanel basico;
	private JPanel fechas;
	private JPanel codigo;
	/**
	 * 
	 */
	public SearchScreen() {
		super();
		JLabel labelcp = new JLabel("Código postal");
		JLabel labeli = new JLabel("Fecha de inicio:");
		JLabel labelf = new JLabel("Fecha de fin:");
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
		fechas.add(inicio, c);//Selectores
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 1;
		c.gridx = 2;
		c.weightx = 0.5;
		fechas.add(fin, c);

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
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 1;
		c.gridy = 2;
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

}
