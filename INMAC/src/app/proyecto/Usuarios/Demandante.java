/**
 * 
 */
package app.proyecto.Usuarios;

import java.io.Serializable;
import java.util.ArrayList;

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
	private ArrayList<Reserva> reservas;

	
	public Demandante() {
		reservas = new ArrayList<Reserva>();
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
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	
	/**
	 * añade una nueva reserva
	 * @param r reserva
	 * @return true o false
	 */
	public boolean addReserva(Reserva r) {
		
		r.setDemandante(this);
		
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
	public void eliminarReservaCaducada() {
		int i;
		for(i = 0; i<reservas.size(); i++) {
			if(reservas.get(i).getFecha().isBefore(FechaSimulada.retrasarDias(5))) {
				eliminarReserva(reservas.get(i));
			}
		}
	}
	
	
	

}
