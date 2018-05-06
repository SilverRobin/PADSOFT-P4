package app.gui.Vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.Controlador.ControladorClienteSelected;
import app.proyecto.Sistema.Sistema;
import app.proyecto.Usuarios.Cliente;

public class GTarjetaMScreen extends JPanel{

	private static final long serialVersionUID = 1L;

	private JList<Cliente> clist;
	private JTextField tarea;
	private JLabel cl;
	private JLabel al;
	private DefaultListModel<Cliente> model;
	
	public GTarjetaMScreen(Sistema app) {
		
		this.setLayout(new GridBagLayout());
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
		cl = new JLabel("Clientes:");
		cl.setHorizontalAlignment(JLabel.CENTER);
		cl.setAlignmentX(Component.CENTER_ALIGNMENT);
		al = new JLabel("Tarjeta actual:");
		al.setAlignmentX(Component.CENTER_ALIGNMENT);
		al.setHorizontalAlignment(JLabel.CENTER);
		tarea = new JTextField();
		tarea.setEditable(false);
		tarea.setAlignmentX(Component.CENTER_ALIGNMENT);
		tarea.setHorizontalAlignment(JLabel.CENTER);
		
		model = new DefaultListModel<Cliente>();
		
		for(Cliente c : app.getClientes()) {
			model.addElement(c);
		}
		clist = new JList<Cliente>(model);
		clist.addListSelectionListener(new ControladorClienteSelected(this));
		clist.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		mainpanel.add(cl);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 5)));
		mainpanel.add(clist);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 15)));
		mainpanel.add(al);
		mainpanel.add(Box.createRigidArea(new Dimension(0, 5)));
		mainpanel.add(tarea);
		
		clist.setMaximumSize(new Dimension(200, 200));
		clist.setPreferredSize(new Dimension(200, 200));
		clist.setMinimumSize(new Dimension(200, 200));
		
		this.add(mainpanel);
	}
	
	public void refresh() {
		tarea.setText(clist.getSelectedValue().getCreditCard());
		return;
	}
	
	public Cliente getSelected() {
		return clist.getSelectedValue();
	}
	
}
