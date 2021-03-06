package app.proyecto.testerPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.proyecto.Usuarios.Cliente;

/**
 * Clase que comprueba el correcto funcionamiento de la clase Cliente
 * 
 * @author Laura Ramirez
 *
 */
public class ClienteTest {
	private Cliente c;
	/**
	 * @throws java.lang.Exception excepcion
	 */
	@Before
	public void setUp() throws Exception {
		c = new Cliente("Fulano", "00000000D", "sopadefideos", "0000111122223333");
	}

	@Test
	public void test() {
		assertTrue(Cliente.comprobarTarjeta(c.getCreditCard()));
		c.cambiarTarjeta("a");
		assertFalse(Cliente.comprobarTarjeta(c.getCreditCard()));
		assertTrue(c.getAvisos().isEmpty());
		c.addAviso("Holo");
		assertFalse(c.getAvisos().isEmpty());
		c.leerAvisos();
	}

}
