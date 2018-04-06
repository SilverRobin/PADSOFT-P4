package proyecto.testerPackage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
	CaracteristicaTest.class,
	DireccionTest.class,
	InmuebleTest.class,
	FechaSimuladaTest.class,
	PagoTest.class,
	LargaEstanciaTest.class,
	VacacionalTest.class,
	ReservaTest.class,
	ClienteTest.class,
	DemandanteTest.class,
	OfertanteTest.class
})

/**
 * Clase vacia que corre todos los tests de las clases
 * 
 * @author Antonio Oliva
 *
 */
public class Tests {

}
