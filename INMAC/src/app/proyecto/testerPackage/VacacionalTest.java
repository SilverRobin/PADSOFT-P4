/**
 * 
 */
package app.proyecto.testerPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.proyecto.Oferta.EstadoOferta;
import app.proyecto.Oferta.Vacacional;
import app.proyecto.Sistema.FechaSimulada;

/**
 * @author Laura Ramirez
 *
 */
public class VacacionalTest {
	private Vacacional v;

	/**
	 * @throws java.lang.Exception excepcion
	 */
	@Before
	public void setUp() throws Exception {
		v = new Vacacional(200, 50, new FechaSimulada(), new FechaSimulada());
	}

	@Test
	public void testModificarOferta() {
		v.rectificar();
		FechaSimulada fecha = new FechaSimulada();
		assertEquals(fecha.getHoy(), v.getInicio().getHoy());
		fecha.avanzarDias(7);
		assertTrue(v.modificarOferta("fechafin", 0, fecha));
		assertTrue(v.modificarOferta("fianza", 150, null));
		assertEquals(150, v.getFianza());
		assertTrue(v.modificarOferta("precio", 400, null));
		assertEquals(400, v.getPrecio());
		v.aprobarOferta();
		assertEquals(EstadoOferta.DISPONIBLE, v.getVisibilidad());
		v.reservar();
		assertEquals(EstadoOferta.RESERVADA, v.getVisibilidad());
	}

}
