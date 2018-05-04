package app.gui.Vista;

import java.awt.Dimension;

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
		ncomarea = new JTextArea("");
		vall = new JLabel("Valoracion:");
		valfield = new JTextField();
		nvalfield = new JTextField();
		
		left.add(comarea);
		right.add(vall);
		right.add(valfield);
		right.add(nvalfield);
		right.add(ncomarea);
		rhorizontal.add(ccomb);
		rhorizontal.add(cofb);
		right.add(rhorizontal);
		mainpanel.add(left);
		mainpanel.add(right);
		this.add(mainpanel);
	}
	
}
