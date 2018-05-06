package app.Controlador;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import app.gui.Vista.DOfertaRScreen;
import app.proyecto.Valorables.Comentario;

public class ControladorComentarioEscogido implements TreeSelectionListener{

	private JTree tree;
	private DOfertaRScreen panel;
	
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
