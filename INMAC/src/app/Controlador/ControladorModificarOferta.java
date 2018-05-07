/**
 * 
 */
package app.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

import app.gui.MainGUI;
import app.gui.Vista.ModificarOferta;
import app.gui.Vista.OfertanteLScreen;
import app.gui.Vista.OfertanteRScreen;
import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Oferta.LargaEstancia;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Oferta.Vacacional;
import app.proyecto.Sistema.Sistema;

/**
 * Controlador del panel de modificar oferta
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorModificarOferta implements ActionListener {
	private ModificarOferta panel;
	private Sistema app;

	/**
	 * Constructor del controlador
	 * @param app Aplicacion del sistema
	 * @param panel Panel de modificar oferta
	 */
	public ControladorModificarOferta(Sistema app, ModificarOferta panel) {
		this.panel = panel;
		this.app = app;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(panel); //Obtenemos la ventana en la que esta contenido el panel
		LocalDate inicio;
		LocalDate fin;
		CardLayout cl;
		String meses;
		if(e.getActionCommand().equals("add")) {
			Inmueble i = (Inmueble) ((OfertanteLScreen) ventana.getCurrentCardL()).getSelectedInmueble();
			Oferta o = ((OfertanteRScreen) ventana.getCurrentCardR()).getSelectedOferta();
			String precio = panel.getPrecio();
			String fianza = panel.getFianza();
			inicio = panel.getInicio();
			if(panel.isVacacional()) {
				fin = panel.getFin();
				((Vacacional) o).setFin(fin);
			}else {
				meses = panel.getMeses();
				((LargaEstancia) o).setMinimaEstancia(Integer.parseInt(meses));
			}
			o.setFianza(Integer.parseInt(fianza));
			o.setPrecio(Integer.parseInt(precio));
			o.modificarOferta();
			((OfertanteRScreen) ventana.getCurrentCardR()).cleanList();
			((OfertanteRScreen) ventana.getCurrentCardR()).addOfertas(i.getOfertas());
			
		}
		((OfertanteLScreen) ventana.getCurrentCardL()).getLista().setEnabled(true);
		((OfertanteRScreen) ventana.getCurrentCardR()).getLista().setEnabled(true);
		cl = (CardLayout) ventana.getCentro().getLayout();
		cl.show(ventana.getCentro(), "OMS");


	}

}
