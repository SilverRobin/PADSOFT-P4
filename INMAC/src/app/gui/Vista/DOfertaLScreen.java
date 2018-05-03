package app.gui.Vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
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

	private JLabel cpl, locall, dirl, descl;
	private JTextField cp;
	private JTextField localidad;
	private JTextField direccion;
	private JTextArea desc;
	private JTextArea cdesc;
	private JList<String> lcars;
	private List<Caracteristica> cars;

	public DOfertaLScreen(Oferta of) {
		cars = of.getInmueble().getCaracteristicas();
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.X_AXIS));
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		JPanel right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		
		cpl = new JLabel("Codigo Postal:");
		descl = new JLabel("Descripcion:");
		dirl = new JLabel("Direccion:");
		locall = new JLabel("Localidad:");
		cp = new JTextField(of.getInmueble().getDireccion().getCP());
		localidad = new JTextField(of.getInmueble().getDireccion().getLocalidad());
		direccion = new JTextField(of.getInmueble().getDireccion().getCalle());
		desc = new JTextArea(of.getInmueble().getDesc());
		
		cp.setEditable(false);
		localidad.setEditable(false);
		direccion.setEditable(false);
		desc.setEditable(false);
		List<String> aux = new ArrayList<>();
		for(Caracteristica c : cars) {
			aux.add(c.getTitulo());
		}
		lcars = new JList<String>((String[]) aux.toArray());
		lcars.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				cdesc.setText(cars.get(lcars.getSelectedIndex()).getDesc());
			}
		});
		if(cars.isEmpty())
			cdesc = new JTextArea();
		else
			cdesc = new JTextArea(cars.get(0).getDesc());
		cdesc.setEditable(false);
		
		
		
		left.add(cpl);
		left.add(cp);
		left.add(locall);
		left.add(localidad);
		left.add(dirl);
		left.add(direccion);
		left.add(descl);
		left.add(desc);
		right.add(lcars);
		right.add(cdesc);
		mainpanel.add(left);
		mainpanel.add(right);
	}
}
