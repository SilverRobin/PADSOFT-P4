package app.proyecto.testerPackage;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import app.proyecto.Sistema.FechaSimulada;

/**
 * Clase que comprueba el funcionamiento de la clase FechaSimulada
 * 
 * @author Antonio Oliva
 *
 */
public class FechaSimuladaTest {
	
	
	@Before
	public void setup() {
	}
	
	@Test
	public void TesterMetodosFecha() {
		
		Assert.assertEquals("Error en la inicializacion de FechaSimulada (constructor)",
				FechaSimulada.getHoy().getDayOfYear(),
				LocalDate.now().getDayOfYear());
		
		int i=5;
		
		while(FechaSimulada.getHoy().plusDays(i).getDayOfYear()
				<= FechaSimulada.getHoy().getDayOfYear()) {
			i--;
		}
		
		FechaSimulada.avanzarDias(i);
			
		Assert.assertEquals("Error en avanzarDias()",
				f1.getHoy().getDayOfYear(),
				LocalDate.now().getDayOfYear() + i);
		
		f1.reestablecerHoy();
		
		Assert.assertEquals("Error en reestablecerHoy()",
				f1.getHoy().getDayOfYear(),
				LocalDate.now().getDayOfYear());
	}
}
