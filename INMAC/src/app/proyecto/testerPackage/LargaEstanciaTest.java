/**
 * 
 */
package app.proyecto.testerPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.proyecto.Oferta.EstadoOferta;
import app.proyecto.Oferta.LargaEstancia;
import app.proyecto.Sistema.FechaSimulada;

/**
 * Clase que comprueba el correcto funcionamiento de la clase LargaEstancia
 * 
 * @author Laura Ramirez
 *
 */
public class LargaEstanciaTest {
	
	private LargaEstancia l;
	/**
	 * @throws java.lang.Exception Excepcion
	 */
	@Before
	public void setUp() throws Exception {
		l = new LargaEstancia(200, 100, new FechaSimulada(), 2);
	}

	/**
	 * Test method for {@link proyecto.Oferta.LargaEstancia#modificarOferta(java.lang.String, int, proyecto.Sistema.FechaSimulada)}.
	 */
	@Test
	public void testModificarOferta() {
		l.rectificar();
		FechaSimulada fecha = new FechaSimulada();
		assertEquals(fecha.getHoy(), l.getInicio().getHoy());
		fecha.retrasarDias(3);
		assertTrue(l.modificarOferta("fechainicio", 0, fecha));
		assertEquals(fecha.getHoy(), l.getInicio().getHoy());
		assertEquals(2, l.getMinimaEstancia());
		l.modificarOferta("minimaestancia", 3, null);
		assertEquals(3, l.getMinimaEstancia());
		assertTrue(l.modificarOferta("fianza", 150, null));
		assertEquals(150, l.getFianza());
		assertTrue(l.modificarOferta("precio", 400, null));
		assertEquals(400, l.getPrecio());
		l.aprobarOferta();
		assertEquals(EstadoOferta.DISPONIBLE, l.getVisibilidad());
		l.reservar();
		assertEquals(EstadoOferta.RESERVADA, l.getVisibilidad());
	}
}
