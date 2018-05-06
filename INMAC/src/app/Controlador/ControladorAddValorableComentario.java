package app.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

import app.gui.Vista.DOfertaRScreen;
import app.proyecto.Sistema.Sistema;
import app.proyecto.Valorables.Comentario;
import app.proyecto.Valorables.Valoracion;

public class ControladorAddValorableComentario implements ActionListener{

	private Sistema app;
	private DOfertaRScreen panel;
	private boolean comentario;
	
	public ControladorAddValorableComentario(Sistema app, DOfertaRScreen s, boolean com){
		panel = s;
		this.app = app;
		comentario = com;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		DefaultMutableTreeNode c = panel.getComment();
		if(c == null || c.equals(panel.getRoot()))
			return;
		Comentario b = ((Comentario) c.getUserObject());
		if(comentario) {
			b.addValorable(new Comentario(panel.newComment(), app.getLogged()));
		}else {
			Double d = Double.parseDouble(panel.getNVal());
			if(d < 1 || d > 5)
				return;
			b.addValorable(new Valoracion(d, app.getLogged()));
		}
		panel.updateComment(b);
		panel.refreshTree();
	}
	
}
