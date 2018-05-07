package app.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.gui.Vista.DOfertaRScreen;
import app.proyecto.Sistema.Sistema;
import app.proyecto.Valorables.Comentario;

/**
 * Controlador de comentar oferta
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorComentarOferta implements ActionListener{

	private DOfertaRScreen panel;
	private Sistema app;
	
	/**
	 * Constructor del controlador
	 * @param app Aplicacion del sistema
	 * @param s Panel derecho de Oferta
	 */
	public ControladorComentarOferta(Sistema app, DOfertaRScreen s){
		panel = s;
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String s = panel.newComment();
		if(s.equals(""))
			return;
		panel.getOf().addValorable(new Comentario(s, app.getLogged()));
		panel.refreshTree();
		return;
	}

	
}
