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

import app.proyecto.Oferta.Oferta;
import app.proyecto.Sistema.Sistema;

public class DOfertaRScreen extends JPanel{

	private static final long serialVersionUID = 1L;

	private JTextArea comarea;
	private JTextArea ncomarea;
	private JButton ccomb;
	private JButton cofb;
	private JButton avalb;
	private JTextField valfield;
	private JTextField nvalfield;
	private JLabel vall;
	
	
	public DOfertaRScreen(Sistema app, Oferta of) {
	
		this.setLayout(new GridBagLayout());
		this.setAlignmentY(JPanel.CENTER_ALIGNMENT);
		this.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.X_AXIS));
		mainpanel.setAlignmentY(JPanel.CENTER_ALIGNMENT);
		mainpanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel rhorizontal = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		rhorizontal.setLayout(new BoxLayout(rhorizontal, BoxLayout.X_AXIS));
		ccomb = new JButton("Comentar comentario");
		cofb = new JButton("Comentar oferta");
		avalb = new JButton("Valorar comentario");
		comarea = new JTextArea("");
		comarea.setEditable(false);
		ncomarea = new JTextArea("");
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
		
		left.add(comarea);
		right.add(vall);
		right.add(Box.createRigidArea(new Dimension(0, 5)));
		right.add(valfield);
		right.add(Box.createRigidArea(new Dimension(0, 15)));
		right.add(nvalfield);
		right.add(Box.createRigidArea(new Dimension(0, 15)));
		right.add(ncomarea);
		right.add(Box.createRigidArea(new Dimension(0, 15)));
		rhorizontal.add(ccomb);
		right.add(Box.createRigidArea(new Dimension(10, 0)));
		rhorizontal.add(cofb);
		right.add(rhorizontal);
		mainpanel.add(left);
		mainpanel.add(right);
		this.add(mainpanel);
	}
	
}
