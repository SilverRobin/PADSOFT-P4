package app.proyecto.testerPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.proyecto.Inmueble.Direccion;
import app.proyecto.Inmueble.Inmueble;
import app.proyecto.Usuarios.Cliente;

/**
 * Clase que comprueba el correcto funcionamiento de la clase Ofertante
 * 
 * @author Laura Ramirez
 *
 */
public class OfertanteTest {
	private Cliente c1, c2;
	private Inmueble i;
	/**
	 * @throws java.lang.Exception excepcion
	 */
	@Before
	public void setUp() throws Exception {
		c1 = new Cliente("Fulano", "05325211L", "sopadefideos", "0000111122223333");
		c2 = new Cliente("Fulano2", "0532548L", "sopadefideos", "a");
		c1.addOfertante();
		c2.addOfertante();
		i = new Inmueble("Soleado, muy grande", Direccion.generarTestDir2());
		
	}

	@Test
	public void test() {
		assertTrue(c1.getOfertante().getInmuebles().isEmpty());
		assertTrue(c1.getOfertante().addInmueble(i));
		assertTrue(c1.realizarPago((double) 200, "cobro reserva"));
		assertFalse(c2.realizarPago((double) 200, "cobro")); //Error por tarjeta invalida
		assertFalse(c1.realizarPago((double) 200, "w")); //Error por conexion fallida y genera aviso
		assertFalse(c1.getAvisos().isEmpty()); //Tenemos un aviso
		
	}

}
