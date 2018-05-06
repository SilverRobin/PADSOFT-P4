/**
 * 
 */
package app.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import app.gui.MainGUI;
import app.gui.Vista.AddInmuebleScreen;
import app.gui.Vista.AddOferta;
import app.gui.Vista.ModificarOferta;
import app.gui.Vista.OfertanteLScreen;
import app.gui.Vista.OfertanteMScreen;
import app.gui.Vista.OfertanteRScreen;
import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Oferta.EstadoOferta;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Sistema.Sistema;

/**
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorMainScreenOfertante implements ActionListener {
	private OfertanteMScreen oms;
	private Sistema app;
	/**
	 * 
	 */
	public ControladorMainScreenOfertante(Sistema app, OfertanteMScreen oms) {
		this.oms = oms;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		CardLayout cl;
		MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(oms); //Obtenemos la ventana en la que esta contenido el panel
		String command = arg0.getActionCommand();
		if(command.equals("addInmueble")) {
			//Nueva vista de añadir inmueble
			ventana.getIzquierda().setVisible(false);
			ventana.getDerecha().setVisible(false);
			AddInmuebleScreen is = new AddInmuebleScreen(app);
			ventana.cambiaCentro(is, "AddInmuebleScreen");
			
			cl = (CardLayout) ventana.getCentro().getLayout();
			cl.show(ventana.getCentro(), "AddInmuebleScreen");

			return;
		}else if(command.equals("addOferta")) {
			if(((OfertanteLScreen) ventana.getCurrentCardL()).getLista().getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null,
						"Por favor, seleciona un inmueble para agregar una oferta",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			((OfertanteLScreen) ventana.getCurrentCardL()).blockLista();
			AddOferta addOfertaPanel = new AddOferta(app);
			ventana.cambiaCentro(addOfertaPanel, "addOferta");
			cl = (CardLayout) ventana.getCentro().getLayout();
			cl.show(ventana.getCentro(), "addOferta");
			return;
		}else if(command.equals("modificar")) {
			if(((OfertanteRScreen) ventana.getCurrentCardR()).getLista().getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null,
						"Por favor, seleciona una oferta válida",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Oferta o = ((OfertanteRScreen) ventana.getCurrentCardR()).getSelectedOferta();
			if(o.getVisibilidad() != EstadoOferta.A_MODIFICAR) {
				JOptionPane.showMessageDialog(null,
						"Esa oferta no se puede modificar. Selecciona una oferta pendiente de modificaciones",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			((OfertanteRScreen) ventana.getCurrentCardR()).blockLista();
			ModificarOferta modOfertaPanel = new ModificarOferta(app);
			Oferta om = ((Oferta) ((OfertanteRScreen) ventana.getCurrentCardR()).getLista().getSelectedValue());
			if(om.isVacacional()) {
				modOfertaPanel.getTipoLabel().setText("Vacacional");;
			}else {
				modOfertaPanel.getTipoLabel().setText("Larga estancia");
			}
			modOfertaPanel.recuperarDatosOferta(om);
			ventana.cambiaCentro(modOfertaPanel, "modOferta");
			cl = (CardLayout) ventana.getCentro().getLayout();
			cl.show(ventana.getCentro(), "modOferta");
		}
		
		
	}

}
