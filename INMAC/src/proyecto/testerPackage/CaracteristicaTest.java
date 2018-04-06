package proyecto.testerPackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import proyecto.Inmueble.Caracteristica;

/**
 * CaracteristicaTest
 * 
 * Clase que comprueba el correcto funcionamiento de la clase Caracteristica
 * 
 * @author Antonio Oliva
 *
 */
public class CaracteristicaTest {
	
	Caracteristica c1;
	Caracteristica c2;
	
	@Before
	public void setup() {
		c1 = new Caracteristica("Test1", "Desc1");
		c2 = new Caracteristica("Test1", "Desc2");
	}
	
	@Test
	public void TesterGetSet(){
		Assert.assertEquals("Error en getTitulo()", c1.getTitulo(), c2.getTitulo());
		Assert.assertNotEquals("Error en el constructor", c1.getTitulo(), c1.getDesc());
		
		c1.setDesc("Test1");
		Assert.assertEquals("Error en setDesc()", c1.getTitulo(), c1.getDesc());
		c1.setTitulo("Desc2");
		Assert.assertEquals("Error en setTitulo()", c1.getTitulo(), c2.getDesc());
		
	}
	
	@Test
	public void TestTestObjects() {
		Assert.assertTrue("Error en isCaracteristica", c1.isCaracteristica());
		Assert.assertNotEquals("Error en la generacion de clases de prueba.",
				Caracteristica.generarTestCara1(),
				Caracteristica.generarTestCara2());		
		Assert.assertEquals("Error en el constructor, (no igual que la clase de prueba)", c1,
				Caracteristica.generarTestCara1());
	}
}
