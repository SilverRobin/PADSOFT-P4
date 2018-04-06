package proyecto.testerPackage;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import proyecto.Sistema.FechaSimulada;

/**
 * Clase que comprueba el funcionamiento de la clase FechaSimulada
 * 
 * @author Antonio Oliva
 *
 */
public class FechaSimuladaTest {
		
	FechaSimulada f1;
	
	@Before
	public void setup() {
		f1 = new FechaSimulada();
	}
	
	@Test
	public void TesterMetodosFecha() {
		
		Assert.assertEquals("Error en la inicializacion de FechaSimulada (constructor)",
				f1.getHoy().getDayOfYear(),
				LocalDate.now().getDayOfYear());
		
		int i=5;
		
		while(f1.getHoy().plusDays(i).getDayOfYear()
				<= f1.getHoy().getDayOfYear()) {
			i--;
		}
		
		f1.avanzarDias(i);
			
		Assert.assertEquals("Error en avanzarDias()",
				f1.getHoy().getDayOfYear(),
				LocalDate.now().getDayOfYear() + i);
		
		f1.reestablecerHoy();
		
		Assert.assertEquals("Error en reestablecerHoy()",
				f1.getHoy().getDayOfYear(),
				LocalDate.now().getDayOfYear());
	}
}
