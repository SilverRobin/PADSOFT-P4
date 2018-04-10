package app.proyecto.testerPackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import app.proyecto.Inmueble.Direccion;

/**
 * Clase que comprueba el correcto funcionamiento de la clase Direccion
 * 
 * @author Antonio Oliva
 *
 */
public class DireccionTest {

	Direccion d1;
	Direccion d2;
	
	@Before
	public void setup() {
		d1 = new Direccion("28040", "Madrid", "Fermines 13");
		d2 = new Direccion("03700", "Denia", "Andrés Ponte 24");
	}
	
	@Test
	public void TesterGetSet(){
		Assert.assertEquals("Error en getCalle()", d1.getCalle(), "Fermines 13");
		Assert.assertNotEquals("Error en el constructor (Calle)", d1.getCalle(), d2.getCalle());
		
		Assert.assertEquals("Error en getCP()", d1.getCP(), "28040");
		Assert.assertNotEquals("Error en el constructor (CP)", d1.getCP(), d2.getCP());
		
		Assert.assertEquals("Error en getLocalidad()", d1.getLocalidad(), "Madrid");
		Assert.assertNotEquals("Error en el constructor (Localidad)", d1.getLocalidad(), d2.getLocalidad());
		
	}
	
	@Test
	public void TesterTestObjects() {
		Assert.assertTrue("Error en isDireccion", d1.isDireccion());
		Assert.assertNotEquals("Error en la generacion de clases de prueba.",
				Direccion.generarTestDir1(),
				Direccion.generarTestDir2());		
		Assert.assertEquals("Error en el constructor, (no igual que la clase de prueba)", d1,
				Direccion.generarTestDir1());
	}
}
