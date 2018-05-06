package app.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.gui.Vista.DOfertaRScreen;
import app.proyecto.Sistema.Sistema;
import app.proyecto.Valorables.Comentario;

public class ControladorComentarOferta implements ActionListener{

	private DOfertaRScreen panel;
	private Sistema app;
	
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
