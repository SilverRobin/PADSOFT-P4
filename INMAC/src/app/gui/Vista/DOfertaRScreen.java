package app.gui.Vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import app.Controlador.ControladorAddValorableComentario;
import app.Controlador.ControladorComentarOferta;
import app.Controlador.ControladorComentarioEscogido;
import app.proyecto.Oferta.Oferta;
import app.proyecto.Sistema.Sistema;
import app.proyecto.Valorables.Comentario;
import app.proyecto.Valorables.ElementoValorable;

/**
 * 
 * @author Laura Ramirez
 * @author Antonio Oliva
 *
 */
public class DOfertaRScreen extends JPanel{

	private static final long serialVersionUID = 1L;

	private JTree coms;
	private JTextArea comarea;
	private JTextArea ncomarea;
	private JButton ccomb;
	private JButton cofb;
	private JButton avalb;
	private JTextField valfield;
	private JTextField nvalfield;
	private JLabel vall;
	private Oferta of;
	private DefaultMutableTreeNode c;
	
	public DOfertaRScreen(Sistema app, Oferta of) {
	
		this.of = of;
		
		this.setLayout(new GridBagLayout());
		this.setAlignmentY(JPanel.CENTER_ALIGNMENT);
		this.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		
		c = new DefaultMutableTreeNode("Comentarios");
		for(ElementoValorable e : of.getValorables()) {
			if(e.isComentario()) {
				insertNode(c, (Comentario) e);
			}
		}
		
		coms = new JTree(c);
		coms.addTreeSelectionListener(new ControladorComentarioEscogido(coms, this));
		coms.setMaximumSize(new Dimension(200, 300));
		coms.setPreferredSize(new Dimension(200, 300));
		coms.setMinimumSize(new Dimension(200, 300));
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.X_AXIS));
		mainpanel.setAlignmentY(JPanel.CENTER_ALIGNMENT);
		mainpanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		right.setAlignmentX(Component.CENTER_ALIGNMENT);
		right.setMaximumSize(new Dimension(180, 400));
		right.setMinimumSize(new Dimension(180, 400));
		right.setPreferredSize(new Dimension(180, 400));
		left.setMaximumSize(new Dimension(160, 400));
		left.setMinimumSize(new Dimension(160, 400));
		left.setPreferredSize(new Dimension(160, 400));
		JPanel rhorizontal = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		rhorizontal.setLayout(new BoxLayout(rhorizontal, BoxLayout.Y_AXIS));
		ccomb = new JButton("Comentar comentario");
		ccomb.setAlignmentX(Component.CENTER_ALIGNMENT);
		ccomb.setMaximumSize(new Dimension(170, 25));
		ccomb.setPreferredSize(new Dimension(170, 25));
		ccomb.setMinimumSize(new Dimension(170, 25));
		ccomb.addActionListener(new ControladorAddValorableComentario(
				app, this, true));
		cofb = new JButton("Comentar oferta");
		cofb.addActionListener(new ControladorComentarOferta(app, this));
		cofb.setMaximumSize(new Dimension(170, 25));
		cofb.setPreferredSize(new Dimension(170, 25));
		cofb.setMinimumSize(new Dimension(170, 25));
		cofb.setAlignmentX(Component.CENTER_ALIGNMENT);
		avalb = new JButton("Valorar comentario");
		avalb.addActionListener(new ControladorAddValorableComentario(
				app, this, false));
		avalb.setMaximumSize(new Dimension(170, 25));
		avalb.setPreferredSize(new Dimension(170, 25));
		avalb.setMinimumSize(new Dimension(170, 25));
		avalb.setAlignmentX(Component.CENTER_ALIGNMENT);
		comarea = new JTextArea("");
		comarea.setEditable(false);
		ncomarea = new JTextArea("");
		ncomarea.setAlignmentX(Component.CENTER_ALIGNMENT);
		vall = new JLabel("Valoracion:");
		vall.setHorizontalAlignment(JLabel.CENTER);
		vall.setAlignmentX(Component.CENTER_ALIGNMENT);
		valfield = new JTextField();
		valfield.setEditable(false);
		valfield.setHorizontalAlignment(JTextField.CENTER);
		valfield.setAlignmentX(Component.CENTER_ALIGNMENT);
		valfield.setMaximumSize(new Dimension(50, 25));
		valfield.setMinimumSize(new Dimension(50, 25));
		valfield.setPreferredSize(new Dimension(50, 25));
		nvalfield = new JTextField();
		nvalfield.setAlignmentX(Component.CENTER_ALIGNMENT);
		nvalfield.setHorizontalAlignment(JTextField.CENTER);
		nvalfield.setMaximumSize(new Dimension(50, 25));
		nvalfield.setMinimumSize(new Dimension(50, 25));
		nvalfield.setPreferredSize(new Dimension(50, 25));
		
		if(app.getLogged() == null) {
			avalb.setEnabled(false);
			ccomb.setEnabled(false);
			cofb.setEnabled(false);
		}
		
		left.add(coms);
		left.add(Box.createRigidArea(new Dimension(0, 25)));
		left.add(comarea);
		right.add(vall);
		right.add(Box.createRigidArea(new Dimension(0, 5)));
		right.add(valfield);
		right.add(Box.createRigidArea(new Dimension(0, 15)));
		right.add(nvalfield);
		right.add(Box.createRigidArea(new Dimension(0, 15)));
		right.add(avalb);
		right.add(Box.createRigidArea(new Dimension(0, 40)));
		right.add(ncomarea);
		right.add(Box.createRigidArea(new Dimension(0, 40)));
		rhorizontal.add(ccomb);
		rhorizontal.add(Box.createRigidArea(new Dimension(0, 10)));
		rhorizontal.add(cofb);
		right.add(rhorizontal);
		mainpanel.add(left);
		mainpanel.add(Box.createRigidArea(new Dimension(20, 0)));
		mainpanel.add(right);
		this.add(mainpanel);
	}
	
	public String newComment() {
		return ncomarea.getText();
	}
	
	public Oferta getOf() {
		return of;
	}
	
	public void refreshTree() {
		c.removeAllChildren();
		for(ElementoValorable e : of.getValorables()) {
			if(e.isComentario()) {
				insertNode(c, (Comentario) e);
			}
		}
		expandAll();
		return;
	}
	
	public void insertNode(DefaultMutableTreeNode j, Comentario r) {
		DefaultMutableTreeNode d = new DefaultMutableTreeNode(r);
		for(ElementoValorable e : r.getValorables()) {
			if(e.isComentario()) {
				insertNode(d, (Comentario) e);
			}
		}
		j.add(d);
		return;
	}
	
	public void expandAll() {
        int row = 0;
        DefaultTreeModel model = (DefaultTreeModel) coms.getModel();
        model.reload();
        while (row < coms.getRowCount()) {
          coms.expandRow(row);
          row++;
        }
    }
	
	public String getNVal() {
		return nvalfield.getText();
	}
	
	public DefaultMutableTreeNode getComment() {
		return (DefaultMutableTreeNode) coms.getLastSelectedPathComponent();
	}
	
	public void updateComment(Comentario h) {
		comarea.setText(h.getTexto());
		valfield.setText(String.format("%.2f", h.calcularMediaValoraciones()));
		return;
	}
	
	public DefaultMutableTreeNode getRoot() {
		return c;
	}
}
