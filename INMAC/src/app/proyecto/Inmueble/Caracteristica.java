/**
 * 
 */
package app.proyecto.Inmueble;

/**
 * @author Antonio Oliva
 *
 */

public class Caracteristica {
	private String titulo;
	private String descripcion;
	
	/**
	 * @param nT Titulo de la caracteristica
	 * @param nD Descripcion
	 */
	public Caracteristica(String nT, String nD) {
		this.titulo = nT;
		this.descripcion = nD;
	}
	
	/**
	 * Obtiene el titulo
	 * @return titulo
	 */
	public String getTitulo(){
		return titulo;
	}
	
	/**
	 * Obtiene la descripcion
	 * @return descripcion
	 */
	public String getDesc() {
		return descripcion;
	}
	
	/**
	 * Cambia el titulo
	 * @param nT titulo
	 */
	public void setTitulo(String nT) {
		titulo = nT;
		return;
	}
	
	/**
	 * Cambia la descripcion
	 * @param nD Descripcion
	 */
	public void setDesc(String nD) {
		descripcion = nD;
		return;
	}
	
	/**
	 * Test caracteristica
	 * @return caracteristica
	 */
	public static Caracteristica generarTestCara1() {
		return new Caracteristica("Test1", "Desc1");
	}
	
	/**
	 * Test caracteristica
	 * @return caracteristica
	 */
	public static Caracteristica generarTestCara2() {
		return new Caracteristica("Test1", "Desc2");
	}
	
	/**
	 * Comprueba si es una caracteristica
	 * @return true o false
	 */
	public boolean isCaracteristica() {
		return this instanceof Caracteristica;
	}
	
	@Override
	public boolean equals(Object e) {
		
		if(!(e instanceof Caracteristica))
			return false;
		
		Caracteristica c = (Caracteristica) e;
		
		if(!(c.descripcion.equals(this.descripcion))
				|| !(c.titulo.equals(this.titulo)))
			return false;
		
		return true;
	}
}
