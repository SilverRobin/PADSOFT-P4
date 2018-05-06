package app.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.gui.Vista.DOfertaMScreen;
import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Sistema.Pago;
import app.proyecto.Sistema.Sistema;
import app.proyecto.Usuarios.Cliente;

public class ControladorCNewOferta implements ActionListener{

	private Sistema app;
	private Oferta o;
	private DOfertaMScreen ms;
	
	public ControladorCNewOferta(Sistema app, Oferta o,
			DOfertaMScreen ms) {
		this.app = app;
		this.o = o;
		this.ms = ms;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Inmueble i = o.getInmueble();
		for(Cliente c : app.getClientes()) {
			if(c.getOfertante() != null) {
				for(Inmueble n : c.getOfertante().getInmuebles()) {
					if(i.equals(n)) {
						if(!app.resolverPago(new Pago(app.getLogged(), c,
								(o.getFianza()+o.getPrecio())
								*(1+o.getComision()), o.getComision()),
								"Oferta "+ o)) {
							ms.getCButton().setText("Error al contr.");
							ms.getRButton().setText("Error al contr.");
							;//spawn error
						}else {
							ms.getCButton().setText("Ya contratada");
							ms.getRButton().setText("Ya contratada");
							o.contratar();
						}
						ms.getCButton().setEnabled(false);
						ms.getRButton().setEnabled(false);
					}
				}
			}
		}
		return;
	}

}
