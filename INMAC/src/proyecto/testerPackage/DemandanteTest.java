package proyecto.testerPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import proyecto.Oferta.*;
import proyecto.Oferta.EstadoOferta;
import proyecto.Oferta.LargaEstancia;
import proyecto.Oferta.Reserva;
import proyecto.Oferta.Vacacional;
import proyecto.Sistema.FechaSimulada;
import proyecto.Usuarios.Cliente;

/**
 * Clase que comprueba el correcto funcionamiento de la clase Demandante
 * 
 * @author Laura Ramirez
 *
 */
public class DemandanteTest {
	
	private Cliente c;
	private Vacacional v, v2;
	private LargaEstancia le, le2;
	private Reserva r1, r2, r3, r4;
	private FechaSimulada fecha;

	/**
	 * @throws java.lang.Exception excepcion
	 */
	@Before
	public void setUp() throws Exception {
		c = new Cliente("Fulano", "1234567899P", "sopadefideos", "0000111122223333");
		c.addDemandante();
		v = new Vacacional(200, 50, new FechaSimulada(), new FechaSimulada());
		v.getFin().avanzarDias(7);
		v2 = new Vacacional(100, 50, new FechaSimulada(), new FechaSimulada());
		v2.getFin().avanzarDias(10);
		le = new LargaEstancia(300, 150, new FechaSimulada(), 5);
		le2 = new LargaEstancia(400, 100, new FechaSimulada(), 3);
		r1 = new Reserva(v);
		r2 = new Reserva(le);
		r3 = new Reserva(v2);
		r4 = new Reserva(le2);
		fecha = new FechaSimulada();
		fecha.retrasarDias(5);
		r3.setFecha(fecha);
	}

	@Test
	public void testGet() {
		assertEquals("0000111122223333", c.getCreditCard());
		assertTrue(c.getDemandante().getReservas().isEmpty());
		assertTrue(fecha.hanPasado5dias());

	}
	
	@Test
	public void testReserva() {
		assertTrue(c.getDemandante().addReserva(r1));
		assertTrue(c.getDemandante().addReserva(r2));
		assertTrue(c.getDemandante().limiteAlcanzado());
		assertFalse(c.getDemandante().addReserva(r3));
		assertFalse(c.getDemandante().comprobarReserva(r4));
		assertTrue(c.getDemandante().comprobarReserva(r1));
		c.getDemandante().eliminarReserva(r1); //Eliminamos una reserva
		assertEquals(1, c.getDemandante().getReservas().size()); //Ahora solo hay una (r2)
		assertFalse(c.getDemandante().addReserva(r4)); //No podemos reservar otra de larga estancia
		assertTrue(c.getDemandante().getReservas().get(0).pagarReserva(c)); //Contratamos r2
		assertEquals(EstadoOferta.CONTRATADA, r2.getOferta().getVisibilidad()); //La oferta esta pagada
		c.getDemandante().addReserva(r3); //Añadimos la reserva vacacional caducada
		assertEquals(2, c.getDemandante().getReservas().size());//Ahora hay dos reservas
		c.getDemandante().eliminarReservaCaducada(); //Eliminamos reserva caducada
		assertEquals(1, c.getDemandante().getReservas().size());//Ahora solo hay una
		c.getDemandante().eliminarReserva(r2);
		assertTrue(c.getDemandante().getReservas().isEmpty());
		
	}

}
