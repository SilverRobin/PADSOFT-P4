/**
 * 
 */
package proyecto.Sistema;

import java.io.IOException;

import proyecto.Inmueble.Caracteristica;
import proyecto.Inmueble.Direccion;
import proyecto.Inmueble.Inmueble;
import proyecto.Oferta.LargaEstancia;
import proyecto.Oferta.Oferta;
import proyecto.Oferta.Reserva;
import proyecto.Usuarios.Cliente;
import proyecto.Usuarios.Ofertante;

/**
 * @author Laura Ramirez
 *
 */
public class mainPruebas {

	/**
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		Sistema apli = new Sistema("admin", "admin");
		Cliente dummy = Cliente.generarClienteTest();
		
		
		
		try {
			apli.leerFichero("clientes.txt"); //Leemos del fichero
		}catch (IOException e) {
			System.out.println("Error en archivo");
		}
		
		for(Cliente c : apli.getClientes()) {
			apli.guardarCliente(c);
		}
		
		apli = new Sistema("admin", "admin"); //Reiniciamos la aplicacion
		
		try {
			apli.recuperarClientes(); //Cargamos los clientes de las carpetas
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Ha fallado la carga de datos?");
		System.out.println(apli.getClientes().isEmpty()); //En este momento esto deberia devolver false
		
		System.out.println("\nIniciando sesion con cliente " + dummy.getNombre() + ".");
		dummy.addDemandante();
		apli.addNuevoCliente(dummy);
		apli.logIn(dummy.getNIF(), dummy.getPassword(), Sistema.TipoCliente.DEMANDANTE);
		System.out.print("Sesion iniciada con exito: ");
		System.out.println(apli.getLogged() != null);
		
		System.out.println("\nCerrando sesion.");
		apli.logOut();
		System.out.print("Sesion cerrada con exito: ");
		System.out.println(apli.getLogged() == null);
		
		apli.logIn("51999111X", "pezEspada", Sistema.TipoCliente.OFERTANTE);
		System.out.print("\nSesion iniciada con exito: ");
		System.out.println(apli.getLogged() != null);
		Inmueble i1;
		System.out.println("Creando inmueble");
		i1 = new Inmueble("Soleado en algun lado", Direccion.generarTestDir1());
		apli.getInmuebles().add(i1);
		i1.addCaracteristica(Caracteristica.generarTestCara1());
		
		apli.getLogged().getOfertante().addInmueble(i1);
		
		System.out.println("Creado inmueble llamado: " + i1.getDesc());
		Oferta o = new LargaEstancia(200, 100, new FechaSimulada(), 2);
		i1.addOferta(o);
		System.out.println("Estado de la oferta: " + o.getVisibilidad());
		System.out.println("\nCerrando sesion.");
		apli.logOut();
		
		if(apli.logIn("admin", "admin", null) == false) {
			System.out.println("Error en login");
			return;
		}
		System.out.println("\nSesion iniciada con exito como admin");
		
		for(Oferta of : apli.getNoAprobadas()) {
			of.aprobarOferta();
			System.out.println("Estado de la oferta: " + o.getVisibilidad());
		}
		
		System.out.println("Cerrando sesion como admin.");
		apli.logOut();
		
		System.out.println("Iniciando sesion como demandante");
		apli.logIn("55555111Z", "NoSeSaBe", Sistema.TipoCliente.DEMANDANTE);
		
		Oferta o1 = apli.getInmuebles().get(0).getOfertas().get(0);
		Reserva r1 = new Reserva(o1);
		
		System.out.println("Reservando oferta de " + o1.getPrecio() + "€");
		
		apli.getLogged().getDemandante().addReserva(r1);
		
		System.out.println("Reserva realizada?: "+ apli.getLogged().getDemandante().getReservas().contains(r1));
		
		
		
		return;
		
		
		
		
		

	}

}
