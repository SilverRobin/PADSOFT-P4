package app.proyecto.Sistema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import app.proyecto.Inmueble.*;
import app.proyecto.Usuarios.*;
import app.proyecto.Oferta.*;

public class Sistema implements Serializable{
	
	protected enum TipoCliente{
		NULL, OFERTANTE, DEMANDANTE, GERENTE
	}
	
	private ArrayList<Cliente> clientes;
	private ArrayList<Inmueble> inmuebles;
	private Cliente logeado;
	private TipoCliente tipolog;
	private double cuentas;

	
	private static final long serialVersionUID = 1L;
	protected static String gerPass;
	protected static String gerID;
	
	public static Sistema singleton = new Sistema("admin","admin");
	
	/**
	 * @param id id del admin	
	 * @param pass pass del admin
	 */
	private Sistema(String id, String pass) {
		gerID = id;
		gerPass = pass;
		clientes = new ArrayList<Cliente>();
		inmuebles = new ArrayList<Inmueble>();
		logeado = null;
		tipolog = TipoCliente.NULL;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Sistema getSistema() {
		return singleton;
	}
	
	/**
	 * Obtiene la lista de clientes
	 * @return clientes
	 */
	public ArrayList<Cliente> getClientes(){
		return clientes;
	}
	
	/**
	 * Obtiene la lista de inmuebles
	 * @return inmuebles
	 */
	public ArrayList<Inmueble> getInmuebles(){
		return inmuebles;
	}
	
	
	/**
	 * Devuelve el Cliente que ha iniciado sesion
	 * en la aplicacion
	 * 
	 * @return Cliente cuya sesion esta abierta
	 */
	public Cliente getLogged() {
		return logeado;
	}
	
	/**
	 * Obtiene la lista de ofertas disponibles
	 * @return lista de ofertas disponibles
	 */
	public ArrayList<Oferta> getDisponibles(){
		ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
		for(Inmueble i : this.inmuebles) {
			ofertas.addAll(i.getDisponibles());
		}
		
		return ofertas;
	}
	
	
	/**
	 * Obtiene la lista de ofertas no aprobadas
	 * @return lista de ofertas no aprobadas
	 */
	public ArrayList<Oferta> getNoAprobadas(){
		ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
		for(Inmueble i : this.inmuebles) {
			for(Oferta o : i.getOfertas()) {
				if(o.getVisibilidad() == EstadoOferta.NO_APROBADA) {
					ofertas.add(o);
				}
			}
		}
		
		return ofertas;
	}
	
	/**
	 * Busca ofertas entre dos fechas
	 * @param f1 fecha 1
	 * @param f2 fecha 2
	 * @return ofertas entre esas fechas
	 */
	public ArrayList<Oferta> busquedaFecha(LocalDate f1, LocalDate f2){
		ArrayList<Oferta> ofertas = getDisponibles();
		
		for(Oferta o : ofertas) {
			if(o.getInicio().isAfter(f1) && o.getInicio().isBefore(f2)) {
				ofertas.add(o);
			}
		}
		return ofertas;
 	}
	
	/**
	 * Busca ofertas con un codigo postal
	 * @param cp codigo postal
	 * @return ofertas entre esas fechas
	 */
	public ArrayList<Oferta> busquedaCP(String cp){
		ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
		
		for(Inmueble i : this.inmuebles) {
			if(i.getDireccion().getCP().equalsIgnoreCase(cp)) {
				ofertas.addAll(i.getDisponibles());
			}
		}
		return ofertas;
 	}
	
	/**
	 * Devuelve las ofertas vacacionales
	 * @return ofertas vacacionales
	 */
	public ArrayList<Oferta> busquedaVacacional(){
		ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
		for(Oferta o : this.getDisponibles() ) {
			if(o instanceof Vacacional) {
				ofertas.add(o);
			}
		}
		return ofertas;
	}
	
	/**
	 * Devuelve las ofertas de larga estancia
	 * @return ofertas de larga estancia
	 */
	public ArrayList<Oferta> busquedaLE(){
		ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
		for(Oferta o : this.getDisponibles() ) {
			if(o instanceof LargaEstancia) {
				ofertas.add(o);
			}
		}
		return ofertas;
	}
	
	
	/**
	 * Devuelve el tipo de cliente
	 * (demandante u ofertante) que
	 * ha iniciado sesion en la aplicacion
	 * 
	 * @return Tipo de Cliente de la sesion
	 */
	protected TipoCliente getTipoLogged() {
		return tipolog;
	}
	
	
	/**
	 * Inicia sesion dados unos
	 * parametros introducidos
	 * por el cliente
	 * 
	 * @param nif Numero de identificacion del cliente
	 * @param pass Contrasenia del cliente
	 * @param tipo Tipo de cliente
	 * @return true si se inicia sesion con exito, false si no
	 */
	
	public boolean logIn(String nif, String pass, TipoCliente tipo) {
		
		if(nif.equals(gerID) && pass.equals(gerPass)) {
			tipolog = TipoCliente.GERENTE;
			return true;
		}
		
		for(Cliente c : clientes) {
			if(c.getNIF().equals(nif)) {
				if(c.getPassword().equals(pass) &&
						((tipo == TipoCliente.DEMANDANTE && c.getDemandante() != null) ||
								(tipo == TipoCliente.OFERTANTE && c.getOfertante() != null))) {
					logeado = c;
					tipolog = tipo;
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}
	
	
	/**
	 * Logout del sistema
	 */
	public void logOut() {
		logeado = null;
		tipolog = TipoCliente.NULL;
		return;
	}
	
	/**
	 * Busca un cliente por nif
	 * @param nif  del cliente
	 * @return Cliente
	 */
	public Cliente buscarCliente(String nif) {
		if(nif == null) {
			return null;
		}
		for(Cliente c : this.clientes) {
			if(c.getNIF().equalsIgnoreCase(nif))
				return c;
		}
			return null;
		
	}
	
	/**
	 * Introduce un nuevo cliente en el array de clientes, comprobando antes si existe
	 * @param c Cliente
	 * @return true o false
	 */
	public boolean addNuevoCliente(Cliente c) {
		if(c == null) {
			return false;
		}
		if(this.clientes.contains(c)) {
			return false;
		}
		for(Cliente p : this.clientes) {
			if(c.getNIF().equalsIgnoreCase(p.getNIF())) {
				return false;
			}
		}
		 return this.clientes.add(c);
	}
	
	/**
	 * Lectura de la linea de fichero de clientes
	 * @param linea a leer
	 * @return true o false
	 */
	public boolean leerCliente(String linea) {
		String rol, NIF, name, pass, ccn;
		
		Scanner l;
		
		l = new Scanner(linea);
		
		l.useDelimiter("\\n");
		rol = l.next();
		
		String[] aux = rol.split("\\;");
		rol = aux[0];
		NIF = aux[1];
		name =aux[2];
		pass = aux[3];
		ccn = aux[4];
		
		l.close();
		
		Cliente c = new Cliente(name, NIF, pass, ccn);
		
		switch (rol) {
			case "O":
				c.addOfertante();
				break;
			case "D":
				c.addDemandante();
				break;
			case "OD":
				c.addDemandante();
				c.addOfertante();
				break;
			default:
				return false;
		}
		
		return this.addNuevoCliente(c);		
	}
	
	/**
	 * Lectura del fichero de clientes
	 * @param fichero de clientes
	 * @return true o false
	 * @throws IOException excepcion de entrada salida
	 */
	public boolean leerFichero(String fichero) throws IOException {
		String datos;
		
		if(fichero==null) {
			return false;
		}
		FileReader file = new FileReader(fichero);
		BufferedReader buffer = new BufferedReader(file);
		
		while((datos = buffer.readLine()) != null) {
			leerCliente(datos);
			
		}
		
		if(buffer != null) {
			buffer.close();
		}
		return true;
	}
	
	/**
	 * Guarda un cliente en disco
	 * @param c Cliente que guardar
	 */
	public void guardarCliente(Cliente c) {
		String path = System.getProperty("user.dir");
		String barras = File.separator;
		path += barras + "Datos" + barras + "Clientes" + barras
				+ c.getNIF() + barras;
		File folder = new File(path);
		if(!folder.exists()) {
			folder.mkdirs();
			
			try {
				FileOutputStream file = new FileOutputStream(path + "user.ser");
				ObjectOutputStream obj = new ObjectOutputStream(file);
				obj.writeObject(c);
				obj.close();
				file.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			File borrado = new File(path + "user.ser");
			borrado.delete();
			try {
				FileOutputStream file = new FileOutputStream(path + "user.ser");
				ObjectOutputStream obj = new ObjectOutputStream(file);
				obj.writeObject(c);
				obj.close();
				file.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		
	}
	
	/**
	 * Recupera los clientes del archivo y los carga en el sistema junto con los inmuebles
	 * @throws ClassNotFoundException Excepcion
	 * @throws IOException Excepcion
	 */
	public void recuperarClientes() throws ClassNotFoundException, IOException {
		this.clientes.addAll(cargarClientes());
		for(Cliente c : this.clientes) {
			if(c.getOfertante() != null && !(c.getOfertante().getInmuebles().isEmpty())) {
				this.inmuebles.addAll(c.getOfertante().getInmuebles());
			}
		}
	}
	
	/**
	 * Carga los clientes del disco
	 * @return Lista de clientes
	 * @throws IOException excepcion de E/S
	 * @throws ClassNotFoundException excepcion de clase
	 */
	public ArrayList<Cliente> cargarClientes() throws IOException, ClassNotFoundException {
		String path = System.getProperty("user.dir");
		String barras = File.separator;
		String directorio = path;
		ArrayList<Cliente> aux = new ArrayList<Cliente>();
		Cliente objeto = null;
		FileInputStream fichero = null;
		ObjectInputStream ois = null;
		
		//Directorio de clientes
		directorio  += barras + "Datos" + barras + "Clientes" + barras;
		
		File dirOfertantes = new File(directorio);
		
		if(dirOfertantes.exists()) {
			File[] verCarpetas = dirOfertantes.listFiles();
			
			for(int x = 0; x < verCarpetas.length; x++) {
				String direccion = directorio;
				direccion += verCarpetas[x].getName();
				File carpe = new File(direccion);
				File[] ficheros = carpe.listFiles();
				
				for(File obj : ficheros) {
					fichero = new FileInputStream(obj);
					ois = new ObjectInputStream(fichero);
					objeto = (Cliente) ois.readObject();
					ois.close();
					aux.add(objeto);
				}
			}
		}
		
		return aux;
	}
}
