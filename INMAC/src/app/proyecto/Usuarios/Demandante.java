/**
 * 
 */
package app.proyecto.Usuarios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import app.proyecto.Oferta.Oferta;
import app.proyecto.Oferta.Reserva;
import app.proyecto.Sistema.FechaSimulada;

/**
 * @author Laura Ramirez
 *
 */
public class Demandante implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Reserva> reservas;
	private Cliente cliente;

	
	public Demandante(Cliente nC) {
		reservas = new ArrayList<Reserva>();
		cliente = nC;
	}
	
	/**
	 * Determina si se ha alcanzado el limite de una reserva de cada tipo
	 * @return true o false
	 */
	public boolean limiteAlcanzado() {
		if(reservas.size()!=2) {
			return false;
		}else if(!reservas.get(0).isLargaEstancia() && reservas.get(1).isLargaEstancia()) {
			return true;
		}else if(reservas.get(0).isLargaEstancia() && !reservas.get(1).isLargaEstancia()) {
			return true;
		}
		return true;
	}

	/**
	 * Obtiene la lista de reservas
	 * @return reservas
	 */
	public List<Reserva> getReservas() {
		return reservas;
	}
	
	/**
	 * Añade una nueva reserva al demandante si puede reservar una nueva oferta
	 * @param r Reserva
	 * @return true si se reserva con exito, false si no es posible hacer la operacion
	 */
	public boolean addReserva(Reserva r) {
		
		r.setDemandante(this);
		
		if(!(Cliente.comprobarTarjeta(cliente.getCreditCard())))
			return false;
		
		if(limiteAlcanzado()) {
			return false;
		}if(reservas.isEmpty()) {
			reservas.add(r);
			return true;
		}if(r.isLargaEstancia()) {//Nueva reserva larga estancia
			if(reservas.get(0).isLargaEstancia()) //Reserva larga estancia ya realizada
				return false;
			reservas.add(r);
			r.getOferta().reservar();
			return true;
		}else { //Nueva reserva vacacional
			if(reservas.get(0).isLargaEstancia()) { //Reserva larga estancia ya realizada
				reservas.add(r); //Podemos añadir nueva reserva
				r.getOferta().reservar();
				return true;
			}
			return false;
		}
	}
	
	/**
	 * Comprueba si el demandante ya ha realizado una reserva
	 * @param r reserva a comprobar
	 * @return true o false
	 */
	public boolean comprobarReserva(Reserva r) {
		if(reservas.contains(r))
			return true;
		return false;
	}
	
	/**
	 * Elimina una reserva
	 * @param r reserva
	 */
	public void eliminarReserva(Reserva r) {
		r.getOferta().cancelar();
		reservas.remove(r);	
	}
	
	/**
	 * Elimina las reservas caducadas
	 */
	public List<Oferta> eliminarReservaCaducada() {

		List<Oferta> rets = new ArrayList<>();
		
		for(Reserva r : reservas) {
			if(r.getFecha().isBefore(FechaSimulada.retrasarDias(5))) {
				rets.add(r.getOferta());
				eliminarReserva(r);
			}
		}
		
		return rets;
	}
	
	
	

}
