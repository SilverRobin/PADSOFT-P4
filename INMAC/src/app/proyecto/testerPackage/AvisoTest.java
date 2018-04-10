package app.proyecto.testerPackage;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import app.proyecto.Sistema.FechaSimulada;

/**
 * Clase que comprueba el correcto funcionamiento de la clase Aviso
 * 
 * @author Antonio Oliva
 *
 */
public class AvisoTest {

	FechaSimulada f1;
	FechaSimulada f2;
	
	@Before
	public void setup() {
		f1 = new FechaSimulada();
		f2 = new FechaSimulada();
	}
	
	@Test
	public void testFSimulada() {
				
		Assert.assertEquals("Error en getHoy()", LocalDate.now().getDayOfYear(), f1.getHoy().getDayOfYear());
		Assert.assertEquals("Error en getHoy()", LocalDate.now().getYear(), f1.getHoy().getYear());
		
		
		if(f1.getHoy().getDayOfYear() > 363)
			f1.avanzarDias(-2);
		else
			f2.avanzarDias(2);
		
		Assert.assertEquals("Error en avanzarDias()", f1.getHoy().getDayOfYear()+2, f2.getHoy().getDayOfYear());
		Assert.assertEquals("Error en avanzarDias()", f1.getHoy().getYear(), f2.getHoy().getYear());
		
	}
}
