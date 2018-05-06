package app.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.gui.Vista.DReservaMScreen;
import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Oferta.Reserva;
import app.proyecto.Sistema.Pago;
import app.proyecto.Sistema.Sistema;
import app.proyecto.Usuarios.Cliente;

public class ControladorGestionarReserva implements ActionListener{

	public enum AccionReserva {
		CANCELAR,
		PAGAR
	}
	
	private AccionReserva accion;
	private Reserva res;
	private Sistema app;
	private DReservaMScreen rs;
	
	public ControladorGestionarReserva(Sistema app,
			AccionReserva ac, DReservaMScreen rs) {
		this.app = app;
		this.rs = rs;
		this.accion = ac;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		res = rs.getSelected();
		if(res == null) return;
		
		if(accion == AccionReserva.CANCELAR) {
			res.cancelarReserva(app.getLogged().getDemandante());
			rs.deleteReserva();
			return;
		}
		Inmueble i = res.getOferta().getInmueble();
		for(Cliente c : app.getClientes()) {
			if(c.getOfertante() != null) {
				for(Inmueble n : c.getOfertante().getInmuebles()) {
					if(i.equals(n)) {
						if(!app.resolverPago(new Pago(app.getLogged(), c,
								(res.getOferta().getFianza()+res.getOferta().getPrecio())
								*(1+res.getOferta().getComision()), res.getOferta().getComision()),
								"Reserva "+ res))
							;//spawn error
						else
							res.getOferta().contratar();
						rs.deleteReserva();
					}
				}
			}
		}
		return;
	}

}
