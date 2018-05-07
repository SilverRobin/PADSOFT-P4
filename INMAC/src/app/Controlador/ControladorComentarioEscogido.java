package app.Controlador;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import app.gui.Vista.DOfertaRScreen;
import app.proyecto.Valorables.Comentario;

/**
 * Controlador de comentario escogido
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class ControladorComentarioEscogido implements TreeSelectionListener{

	private JTree tree;
	private DOfertaRScreen panel;
	
	/**
	 * Constructor del controlador
	 * @param tree Arbol de comentarios
	 * @param rs Panel de Oferta Derecho
	 */
	public ControladorComentarioEscogido(JTree tree, DOfertaRScreen rs) {
		this.tree = tree;
		panel = rs;
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                           tree.getLastSelectedPathComponent();

        if (node == null || panel.getRoot().equals(node)) return;

        panel.updateComment((Comentario)node.getUserObject());
        
        return;
    }
}
