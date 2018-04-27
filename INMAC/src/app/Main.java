package app;

import java.io.File;
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
		String path = System.getProperty("user.dir");
		String barras = File.separator;
		path += barras + "Datos" + barras;
		File folder = new File(path);
		Sistema app = Sistema.getSistema();
		
		if(!folder.exists()) {
			try {
				app.leerFichero("clientes.txt"); //Leemos del fichero
			}catch (IOException e) {
				System.out.println("Error en archivo");
			}
			
			for(Cliente c : app.getClientes()) {
				app.guardarCliente(c);
			}
		}
		
		
		try {
			app.recuperarClientes(); //Cargamos los clientes de las carpetas
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainGUI ventana = new MainGUI(app);
		
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
