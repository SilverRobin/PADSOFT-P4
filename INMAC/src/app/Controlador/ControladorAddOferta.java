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
import app.gui.Vista.AddOferta;
import app.gui.Vista.OfertanteLScreen;
import app.gui.Vista.OfertanteMScreen;
import app.gui.Vista.OfertanteRScreen;
import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Oferta.LargaEstancia;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Oferta.Vacacional;
import app.proyecto.Sistema.Sistema;

/**
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorAddOferta implements ActionListener {
	private AddOferta ao;
	private Sistema app;
	/**
	 * 
	 */
	public ControladorAddOferta(Sistema app, AddOferta ao) {
		this.ao = ao;
		this.app = app;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		MainGUI ventana = (MainGUI) SwingUtilities.getWindowAncestor(ao); //Obtenemos la ventana en la que esta contenido el panel
		LocalDate inicio;
		LocalDate fin;
		CardLayout cl;
		String meses;
		if(e.getActionCommand().equals("tipo")) {
			JComboBox cb = (JComboBox) e.getSource();
			if(cb.getSelectedItem().equals("Vacacional")){
				ao.modoVacacional();
			}else {
				ao.modoLargaEstancia();
			}
			return;
		}else if(e.getActionCommand().equals("add")) {
			Inmueble i = (Inmueble) ((OfertanteLScreen) ventana.getCurrentCardL()).getSelectedInmueble();
			Oferta o;
			String precio = ao.getPrecio();
			String fianza = ao.getFianza();
			inicio = ao.getInicio();
			System.out.println("Hola");
			if(ao.isVacacional()) {
				fin = ao.getFin();
				o = new Vacacional(Integer.parseInt(precio), Integer.parseInt(fianza), inicio, fin, i);
			}else {
				meses = ao.getMeses();
				o = new LargaEstancia(Integer.parseInt(precio), Integer.parseInt(fianza), inicio, Integer.parseInt(meses), i);
			}
			i.addOferta(o);
			((OfertanteRScreen) ventana.getCurrentCardR()).addOfertas(i.getOfertas());
			
		}
		((OfertanteLScreen) ventana.getCurrentCardL()).getLista().setEnabled(true);
		cl = (CardLayout) ventana.getCentro().getLayout();
		cl.show(ventana.getCentro(), "OMS");

	}

}
