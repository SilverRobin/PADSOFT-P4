package app.proyecto.Sistema;

import java.time.LocalDate;

/**
 * Esta clase genera una fecha virtual
 * que se puede adelantar o atrasar
 * con motivos de simulacion del
 * programa
 * 
 * @author Antonio Oliva Hernandez
 *
 */
public class FechaSimulada {

	private static LocalDate fecha = LocalDate.now();
	
	/**
	 * Devuelve el valor de fecha
	 * 
	 * @return Fecha guardada
	 */
	public static LocalDate getHoy() {
		return fecha;
	}
	
	/**
	 * Avanza la fecha un numero de
	 * dias pasado por argumento
	 * 
	 * @param dias Dias a adelantar
	 */
	public static void avanzarDias(int dias) {
		fecha = fecha.plusDays(dias);
		return;
	}
	
	public static void retrasarDias(int dias) {
		fecha = fecha.minusDays(dias);
	}
	
	/**
	 * Actualiza el valor de fecha
	 * al dia de hoy
	 */
	public static void reestablecerHoy(){
		fecha = LocalDate.now();
		return;
	}
	
	public static boolean hanPasado5dias() {
		if(LocalDate.now().isEqual(fecha.plusDays(5)) || LocalDate.now().isAfter(fecha.plusDays(5))) //Vemos si esa fecha es de hace 5 dias o mas
			return true;
		return false;
	}
	
}
