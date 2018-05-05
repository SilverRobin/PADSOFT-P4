package app.gui.Vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import app.proyecto.Inmueble.Caracteristica;
import app.proyecto.Oferta.Oferta;

public class DOfertaLScreen extends JPanel{

	private static final long serialVersionUID = 1L;

	private JLabel cpl, locall, dirl, descl, carl;
	private JTextField cp;
	private JTextField localidad;
	private JTextField direccion;
	private JTextArea desc;
	private JTextArea cdesc;
	private JList<String> lcars;
	private List<Caracteristica> cars;

	public DOfertaLScreen(Oferta of) {
		this.setLayout(new GridBagLayout());
		cars = of.getInmueble().getCaracteristicas();
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.X_AXIS));
		JPanel left = new JPanel();
		left.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		JPanel right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		right.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		
		cpl = new JLabel("Codigo Postal:");
		cpl.setHorizontalAlignment(JLabel.CENTER);
		cpl.setAlignmentX(Component.CENTER_ALIGNMENT);
		carl = new JLabel("Caracteristicas:");
		carl.setAlignmentX(Component.CENTER_ALIGNMENT);
		carl.setHorizontalAlignment(JLabel.CENTER);
		descl = new JLabel("Descripcion:");
		descl.setHorizontalAlignment(JLabel.CENTER);
		descl.setAlignmentX(Component.CENTER_ALIGNMENT);
		dirl = new JLabel("Direccion:");
		dirl.setHorizontalAlignment(JLabel.CENTER);
		dirl.setAlignmentX(Component.CENTER_ALIGNMENT);
		locall = new JLabel("Localidad:");
		locall.setHorizontalAlignment(JLabel.CENTER);
		locall.setAlignmentX(Component.CENTER_ALIGNMENT);
		cp = new JTextField(of.getInmueble().getDireccion().getCP());
		localidad = new JTextField(of.getInmueble().getDireccion().getLocalidad());
		direccion = new JTextField(of.getInmueble().getDireccion().getCalle());
		desc = new JTextArea(of.getInmueble().getDesc());
		
		cp.setEditable(false);
		cp.setHorizontalAlignment(JTextField.CENTER);
		localidad.setEditable(false);
		localidad.setHorizontalAlignment(JTextField.CENTER);
		direccion.setEditable(false);
		direccion.setHorizontalAlignment(JTextField.CENTER);
		desc.setEditable(false);
		desc.setPreferredSize(new Dimension(150, 100));
		desc.setMaximumSize(new Dimension(150, 100));
		desc.setMinimumSize(new Dimension(150, 100));
		List<String> aux = new ArrayList<>();
		for(Caracteristica c : cars) {
			aux.add(c.getTitulo());
		}
		DefaultListModel<String> model = new DefaultListModel<>();
		for(Caracteristica c : cars) {
			model.addElement(c.getTitulo());
		}
		lcars = new JList<String>(model);
		lcars.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				cdesc.setText(cars.get(lcars.getSelectedIndex()).getDesc());
			}
		});
		lcars.setPreferredSize(new Dimension(150, 100));
		lcars.setMaximumSize(new Dimension(150, 100));
		lcars.setMinimumSize(new Dimension(150, 100));
		if(cars.isEmpty())
			cdesc = new JTextArea();
		else
			cdesc = new JTextArea(cars.get(0).getDesc());
		cdesc.setEditable(false);
		cdesc.setPreferredSize(new Dimension(150, 100));
		cdesc.setMaximumSize(new Dimension(150, 100));
		cdesc.setMinimumSize(new Dimension(150, 100));
		
		
		
		left.add(cpl);
		left.add(Box.createRigidArea(new Dimension(0, 5)));
		left.add(cp);
		left.add(Box.createRigidArea(new Dimension(0, 15)));
		left.add(locall);
		left.add(Box.createRigidArea(new Dimension(0, 5)));
		left.add(localidad);
		left.add(Box.createRigidArea(new Dimension(0, 15)));
		left.add(dirl);
		left.add(Box.createRigidArea(new Dimension(0, 5)));
		left.add(direccion);
		left.add(Box.createRigidArea(new Dimension(0, 15)));
		left.add(descl);
		left.add(Box.createRigidArea(new Dimension(0, 5)));
		left.add(desc);
		right.add(carl);
		right.add(Box.createRigidArea(new Dimension(0, 5)));
		right.add(lcars);
		right.add(Box.createRigidArea(new Dimension(0, 75)));
		right.add(cdesc);
		mainpanel.add(left);
		mainpanel.add(Box.createRigidArea(new Dimension(40, 0)));
		mainpanel.add(right);
		this.add(mainpanel);
	}
}
