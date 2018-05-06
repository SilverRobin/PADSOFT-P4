/**
 * 
 */
package app.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import app.gui.MainGUI;
import app.gui.Vista.AddInmuebleScreen;
import app.gui.Vista.OfertanteLScreen;
import app.gui.Vista.OfertanteMScreen;
import app.proyecto.Inmueble.Caracteristica;
import app.proyecto.Inmueble.Direccion;
import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Sistema.Sistema;

/**
 * Controlador de los botones de añadir y eliminar caracteristicas, volver y
 * añadir inmueble
 * 
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class CtrlBAddInmuebleScreen implements ActionListener {
	private AddInmuebleScreen panel;
	private Sistema app;

	/**
	 * Constructor del controlador
	 * 
	 * @param panel,
	 *            panel de AddInmuebleScreen para acceder a todos los componentes
	 */
	public CtrlBAddInmuebleScreen(AddInmuebleScreen panel, Sistema app) {
		this.panel = panel;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int flag = 0;
		String command = ((JButton) arg0.getSource()).getActionCommand();
		if (command.equals("add")) {
			String titulo;
			String descripcion;
			titulo = panel.getTituloC();
			descripcion = panel.getDescC();
			if (titulo.equals("") || descripcion.equals("")) {
				return;
			}
			Caracteristica caracteristica = new Caracteristica(titulo, descripcion);
			panel.getListModel().addElement(caracteristica);
			return;
		} else if (command.equals("delete")) {
			int selectedIndex = panel.getList().getSelectedIndex();
			panel.getListModel().removeElementAt(selectedIndex);
			return;
		} else if (command.equals("addInm")) {
			Direccion dir = new Direccion(panel.getCP(), panel.getLocalidad(), panel.getDireccion());
			Inmueble inm = new Inmueble(panel.getDescripcion(), dir, app.getLogged());
			if (dir.isEmpty()) {
				return;
			}
			Caracteristica car;
			String titulo, descC;
			for (int i = 0; i < panel.getListModel().getSize(); i++) {
				titulo = ((Caracteristica) panel.getListModel().getElementAt(i)).getTitulo();
				descC = ((Caracteristica) panel.getListModel().getElementAt(i)).getDesc();
				car = new Caracteristica(titulo, descC);
				inm.addCaracteristica(car);
			}
			app.getInmuebles().add(inm);
			app.getLogged().getOfertante().addInmueble(inm);
			flag = 1;
		}
		MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(panel); // Obtenemos la ventana en la que esta
		CardLayout cl;
		((OfertanteLScreen) ventana.getCurrentCardL()).cleanList();
		((OfertanteLScreen) ventana.getCurrentCardL()).addInmuebles(app.getLogged().getOfertante().getInmuebles());
		ventana.getIzquierda().setVisible(true); // Volvemos a mostrar los paneles laterales
		((OfertanteLScreen) ventana.getCurrentCardL()).getLista()
				.addListSelectionListener(new ControladorListaOL(((OfertanteLScreen) ventana.getCurrentCardL()), app));
		ventana.getDerecha().setVisible(true);

		cl = (CardLayout) ventana.getCentro().getLayout();
		cl.show(ventana.getCentro(), "OMS"); // Recuperamos el panel central previo
		if(flag == 1) {
			if (ventana.getCurrentCardC() instanceof OfertanteMScreen)
				((OfertanteMScreen) ventana.getCurrentCardC()).getAddOferta().setEnabled(true);
		}

	}
}
