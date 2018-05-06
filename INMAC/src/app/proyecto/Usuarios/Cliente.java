package app.proyecto.Usuarios;

import java.io.Serializable;
import java.time.LocalDate;

import es.uam.eps.padsof.telecard.*;
import app.proyecto.Sistema.Aviso;
import app.proyecto.Sistema.Sistema;

/**
 * @author Laura Ramirez
 *
 */
public class Cliente implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String nif;
	private String password;
	private Ofertante ofertante;
	private Demandante demandante;
	private String creditCard;
	private Aviso aviso;
	
	/**
	 * @param nombre nombre
	 * @param nif NIF
	 * @param password contraseña
	 * @param creditCard tarjeta de credito
	 */
	public Cliente(String nombre, String nif, String password, String creditCard) {
		this.nombre = nombre;
		this.nif = nif;
		this.password = password;
		this.creditCard = creditCard;
		aviso = null;
	}
	
	/**
	 * Devuelve el nombre del Cliente
	 * 
	 * @return Nombre del cliente
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Devuelve la contrasenia del cliente
	 * @return Contrasenia del cliente
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Devuelve el posible demandante del cliente
	 * @return Perfil demandante
	 */
	public Demandante getDemandante() {
		return demandante;
	}
	
	/**
	 * Devuelve el posible ofertante del cliente
	 * @return Perfil ofertante
	 */
	public Ofertante getOfertante() {
		return ofertante;
	}
	
	/**
	 * Comprueba la validez de la tarjeta de credito
	 * @return true si la tarjeta es valida o false en caso contrario
	 */
	public static boolean comprobarTarjeta(String cc) {
		return TeleChargeAndPaySystem.isValidCardNumber(cc);
	}
	
	public String getNIF() {
		return nif;
	}
	
	
	public void addDemandante() {
		demandante = new Demandante(this);
		return;
	}
	
	public void addOfertante() {
		ofertante = new Ofertante();
		return;
	}
	
	/**
	 * Obtiene la tarjeta
	 * @return la tarjeta de credito
	 */
	public String getCreditCard() {
		return creditCard;
	}
	
	/**
	 * Añade un aviso con un mensaje y la fecha en la que se genera
	 * @param mensaje contenido del aviso
	 */
	public void setAviso(Aviso a) {
		aviso = a;
	}

	/**
	 * Obtiene la lista de avisos
	 * @return Aviso del cliente
	 */
	public Aviso getAviso() {
		return aviso;
	}
	
	/**
	 * Cambia el numero de tarjeta a una pasada por argumento si
	 * se trata de una tarjeta valida
	 * 
	 * @param tarjeta Nueva tarjeta
	 * @return true si se cambia con exito, false si no
	 */
	public boolean cambiarTarjeta(String tarjeta) {
		if(Cliente.comprobarTarjeta(tarjeta)) {
			this.creditCard = tarjeta;
			Sistema.singleton.checkPagos(this);
			return true;
		}
		return false;
	}
	
	/**
	 * Carga un pago (negativo o positivo) de magnitud
	 * pasada por argumento a la tarjeta del cliente con
	 * motivo pasado por argumento
	 * 
	 * @param cantidad Cantidad a cobrar/ingresar
	 * @param subject Motivo de la transaccion
	 * @return
	 */
	public boolean realizarPago(Double cantidad, String subject) {
		int cont = 0;
		int maxIntentos = 4;
		
		while(true) {
			try {
				TeleChargeAndPaySystem.charge(creditCard, subject, cantidad);
				return true;
			} catch(FailedInternetConnectionException e){
				cont++;
				if(cont == maxIntentos) {
					setAviso(new Aviso("Fallo de conexión. Inténtalo más tarde", LocalDate.now()));
					break;
				}
			} catch (InvalidCardNumberException e) {
				setAviso(new Aviso("Tarjeta inválida. Contacta con el administrador", LocalDate.now()));
				break;
			} catch (OrderRejectedException e) {
				setAviso(new Aviso("Transaccion rechazada", LocalDate.now()));
				break;
			}
		}
		return false;
	}


	/**
	 * Genera un cliente de prueba
	 * @return cliente generado
	 */
	public static Cliente generarClienteTest() {
		return new Cliente("Ernesto Leal", "01256477p",
				"alpaca", "0000111122223333");
	}
	
	@Override
	public String toString() {
		return nif;
	}
	
}
