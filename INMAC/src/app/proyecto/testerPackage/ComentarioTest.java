package app.proyecto.testerPackage;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import app.proyecto.Usuarios.Cliente;
import app.proyecto.Valorables.Comentario;

/**
 * Clase que comprueba el correcto funcionamiento de la clase Comentario
 * 
 * @author Antonio Oliva
 *
 */
public class ComentarioTest {

	private Comentario c1;
	private Comentario c2;
	private Cliente autor;
	
	@Before
	public void setup() {
		autor = Cliente.generarClienteTest();
		c1 = new Comentario("buena vivienda", autor);
		c2 = new Comentario("mediocre vivienda", autor);
	}
	
	@Test
	public void testComentario() {
		Assert.assertEquals("Error en getValor()", c1.getTexto(), "buena vivienda");
		c1.setTexto("mala vivienda");;
		Assert.assertNotEquals("Error en setValor()", c1.getTexto(), "buena vivienda");
		
		Assert.assertEquals("Error en getAutor()", c1.getAutor(), autor);
		c1.setAutor(null);
		Assert.assertNull("Error en setAutor()", c1.getAutor());
		
		c1.addValorable(c2);
		Assert.assertTrue("Error en add/getValorables()", c1.getValorables().contains(c2));
	}
}
