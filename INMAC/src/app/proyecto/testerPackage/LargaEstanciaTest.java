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
		l = new LargaEstancia(200, 100, FechaSimulada.getHoy(), 2);
	}

	/**
	 * Test method for {@link proyecto.Oferta.LargaEstancia#modificarOferta(java.lang.String, int, proyecto.Sistema.FechaSimulada)}.
	 */
	@Test
	public void testModificarOferta() {
		l.rectificar();
		assertEquals("Error en getFianza()", 100, l.getFianza());
		assertEquals("Error en getInicio()", FechaSimulada.getHoy(), l.getInicio());
		assertTrue(l.modificarOferta("fechainicio", 0, FechaSimulada.retrasarDias(3)));
		assertEquals("Error al modificar la fecha", FechaSimulada.getHoy(), l.getInicio());
		assertEquals("Error en getMinimaEstancia()", 2, l.getMinimaEstancia());
		l.modificarOferta("minimaestancia", 3, null);
		assertEquals("Error al modificar la minima estancia", 3, l.getMinimaEstancia());
		assertTrue("Error al modificar el precio (proceso incompleto)", l.modificarOferta("fianza", 150, null));
		assertEquals("Error al modificar el precio (valor no actualizado)", 150, l.getFianza());
		assertTrue(l.modificarOferta("precio", 400, null));
		assertEquals(400, l.getPrecio());
		l.aprobarOferta();
		assertEquals(EstadoOferta.DISPONIBLE, l.getVisibilidad());
		l.reservar();
		assertEquals(EstadoOferta.RESERVADA, l.getVisibilidad());
	}
}
