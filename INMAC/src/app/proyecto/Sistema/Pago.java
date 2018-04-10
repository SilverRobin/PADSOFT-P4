package app.proyecto.Sistema;

import app.proyecto.Usuarios.Cliente;

/**
 * Clase que define el objeto de tipo Pago,
 * que relaciona dos clientes, cobra a uno
 * y paga a otro cobrando una pequenia comision
 * 
 * @author Antonio Oliva
 *
 */
public class Pago {

	public enum EstadoPago {
		PORPAGAR, PAGADO, ERROR
	}
	
	private Cliente demandante;
	private Cliente ofertante;
	private double cantidad;
	private EstadoPago estado;
	private double ganancia;
	private double comision;
	
	/**
	 * Constructor de Pago
	 * 
	 * @param d Cliente demandante (a cobrarle)
	 * @param o Cliente ofertante (a pagarle)
	 * @param quantity Cantidad a cobrar/pagar
	 * @param nComision Tanto por 1 a cobrar de la transaccion
	 */
	public Pago(Cliente d, Cliente o, double quantity, double nComision) {
		estado = EstadoPago.PORPAGAR;
		demandante = d;
		ofertante = o;
		cantidad = quantity;
		ganancia = 0;
		comision = nComision;
	}
	
	/**
	 * Resuelve el pago entre los ofertantes y
	 * demandantes y almacena los ingresos
	 * 
	 * @param subject Motivo del cargo
	 * @return true si se ejecuta con exito, false si no
	 */
	public boolean resolverPago(String subject) {
		
		switch(estado) {
			case PORPAGAR:
				if(!(demandante.realizarPago(-1 * cantidad, subject)))
					return false;
			case ERROR:
				if(!(ofertante.realizarPago((1-comision)*cantidad, subject))) {
					estado = EstadoPago.ERROR;
					return false;
				}
				break;
			default:
				break;
		}
		ganancia = comision*cantidad;
		estado = EstadoPago.PAGADO;
		
		return true;
	}
	
	/**
	 * Devuelve el dinero ganado por ese pago
	 * 
	 * @return Dinero ganado por la aplicacion
	 */
	public double getGanancia() {
		return ganancia;
	}
	
	/**
	 * Devuelve el estado del pago
	 * 
	 * @return Estado del pago
	 */
	public EstadoPago getEstado() {
		return estado;
	}
}
