/**
 * 
 */
package app.proyecto.Oferta;

import java.io.Serializable;

import app.proyecto.Sistema.FechaSimulada;
import app.proyecto.Usuarios.Cliente;
import app.proyecto.Usuarios.Demandante;

/**
 * Clase que define el funcionamiento de los
 * objetos de tipo Reserva, que almacenan
 * una oferta y su fecha de reserva
 * 
 * @author Laura Ramirez
 *
 */
public class Reserva implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FechaSimulada fecha;
	private Oferta oferta;
	
		public Reserva(Oferta oferta){
			fecha = new FechaSimulada();
			this.oferta = oferta;
		}
		
		/**
		 * Obtiene la fecha 
		 * @return fecha
		 */
		public FechaSimulada getFecha() {
			return fecha;
		}
		/**
		 * Establece una nueva fecha
		 * @param fecha nueva
		 */
		public void setFecha(FechaSimulada fecha) {
			this.fecha = fecha;
		}
		
		/**
		 * Indica si la reserva es de larga estancia
		 * @return true o false
		 */
		public Boolean isLargaEstancia (){
			if(oferta instanceof LargaEstancia) {
				return true;
			}
			return false;
		}
		
		/**
		 * Obtiene la oferta de la reserva
		 * @return oferta
		 */
		public Oferta getOferta() {
			return oferta;
		}
		
		/**
		 * Hace el pago de una reserva
		 * @param c Demandante que realiza el pago
		 * @return true o false
		 */
		public boolean pagarReserva(Cliente c) {
			
			Demandante d = c.getDemandante();
			
			if(!d.comprobarReserva(this)) {
				return false;
			}
			
			if(!c.realizarPago((double) (-1 * (oferta.getPrecio() + oferta.getFianza())), "Pago de reserva")) {
				return false;
			}
			this.oferta.contratar();
			return true;
		}
		
		/**
		 * Cancela una reserva
		 * @param d DEmandante que cancela 
		 * @return true o false
		 */
		public boolean cancelarReserva(Demandante d) {
			if(d.comprobarReserva(this)) {
				d.eliminarReserva(this);
				return true;
			}
			return false;
		}
		
		
}
