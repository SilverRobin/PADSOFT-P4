package proyecto.testerPackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import proyecto.Inmueble.Caracteristica;
import proyecto.Inmueble.Direccion;
import proyecto.Inmueble.Inmueble;

/**
 * Clase que comprueba el funcionamiento de la clase Inmueble
 * 
 * @author Antonio Oliva 
 *
 */
public class InmuebleTest {

	Inmueble i1;
	Inmueble i2;
	
	@Before
	public void setup() {
		i1 = new Inmueble("", Direccion.generarTestDir1());
		i2 = new Inmueble("Soleado, muy grande", Direccion.generarTestDir2());
	}
	
	@Test
	public void TesterGet() {
		Assert.assertEquals("Error en getDireccion()", i1.getDireccion(), Direccion.generarTestDir1());
		Assert.assertNotEquals("Error en el constructor (Direccion)", i1.getDireccion(), i2.getDireccion());
		
		Assert.assertNotEquals("Error en getID()", i1.getId(), 0);
		Assert.assertNotEquals("Error en el constructor (ID)", i1.getId(), i2.getId());
		
		Assert.assertEquals("Error en getDesc()", i1.getDesc(), "");
		Assert.assertNotEquals("Error en el constructor (Desc)", i1.getDesc(), i2.getDesc());
		
	}
	
	@Test
	public void TesterSet() {
		i1.setDesc("Soleado, muy grande");
		Assert.assertEquals("Error en setDesc()", i1.getDesc(), i2.getDesc());
	}
	
	@Test
	public void TesterCara() {
		i1.addCaracteristica(Caracteristica.generarTestCara1());
		Assert.assertEquals("Error al añadir una caracteristica", Caracteristica.generarTestCara1(), i1.getCaracteristicas().get(0));
	}
	
	@Test
	public void TesterTestObjects() {
		Assert.assertTrue("Error en isInmueble", i1.isInmueble());
	}
}
