package app;

import java.io.IOException;

import app.gui.MainGUI;
import app.proyecto.Sistema.Sistema;
import app.proyecto.Usuarios.Cliente;

/**
 * 
 * @author Antonio Oliva
 *
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
	
		Sistema app = Sistema.getSistema();
		MainGUI ventana = new MainGUI(app);
		
		try {
			app.recuperarClientes(); //Cargamos los clientes de las carpetas
		} catch (ClassNotFoundException | IOException e) {
			try {
				app.leerFichero("clientes.txt"); //Leemos del fichero
			}catch (IOException e1) {
				System.out.println("Error en archivo");
			}
			
			for(Cliente c : app.getClientes()) {
				app.guardarCliente(c);
			}
		}
		
		ventana.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {

					if (app.getLogged() != null) {
						app.logOut();
					}
					
					for (Cliente c : app.getClientes()) {
						app.guardarCliente(c);
					}
					
					System.exit(0);
				}
			});
	}

}
