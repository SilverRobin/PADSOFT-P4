package proyecto.testerPackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import proyecto.Sistema.Pago;
import proyecto.Usuarios.Cliente;

/**
 * Clase que comprueba el correcto funcionamiento de la clase Pago
 * 
 * @author Antonio Oliva
 *
 */
public class PagoTest {

	Pago p;
	Cliente de;
	Cliente of;
	
	@Before
	public void setup() {
		de = Cliente.generarClienteTest();
		of = Cliente.generarClienteTest();
		p = new Pago(de, of, 100, 0.02);
	}
	
	@Test
	public void testGetYPagoCorrecto() {
		Assert.assertEquals("Error en getGanancia()", p.getGanancia(), 0, 0.01);
		Assert.assertEquals("Error en getEstado()", p.getEstado(), Pago.EstadoPago.PORPAGAR);
		
		Assert.assertTrue("Error en resolverPago() (correcto)", p.resolverPago("test"));
		Assert.assertNotEquals("Error al guardar ingresos", p.getGanancia(), 0, 0.01);
		Assert.assertEquals("Error al guardar el estado", p.getEstado(), Pago.EstadoPago.PAGADO);
	}
	
	@Test
	public void testPagoIncorrecto() {
		de.cambiarTarjeta("d");
		
		Assert.assertFalse("Error en resolverPago() (incorrecto demandante)", p.resolverPago("test"));
		Assert.assertEquals("Error al guardar fallo demandante", Pago.EstadoPago.PORPAGAR, p.getEstado());
		Assert.assertEquals("Error guardado de incorrectas ganancias", p.getGanancia(), 0, 0.01);
		
		de = Cliente.generarClienteTest();
		of.cambiarTarjeta("d");
		p = new Pago(de, of, 100, 0.02);
		Assert.assertFalse("Error en resolverPago() (incorrecto ofertante)", p.resolverPago("test"));
		Assert.assertEquals("Error al guardar fallo ofertante", Pago.EstadoPago.ERROR, p.getEstado());
		Assert.assertEquals("Error guardado de incorrectas ganancias", p.getGanancia(), 0, 0.01);
		
		of = Cliente.generarClienteTest();
		p = new Pago(de, of, 100, 0.02);
		Assert.assertTrue("Error en resolverPago() (retomar uno fallido)", p.resolverPago("test"));
		Assert.assertEquals("Error al guardar exito tras fallo", Pago.EstadoPago.PAGADO, p.getEstado());
		Assert.assertNotEquals("Error guardado de incorrectas ganancias", p.getGanancia(), 0, 0.01);
	}
}
