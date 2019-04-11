package project.kitri.food;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class SnackView extends JPanel {

	/**
	 * Create the panel.
	 */
	public SnackView() {
		setLayout(new GridLayout(5, 5, 1, 1));
		setBounds(713, 123, 656, 583);
		String bt[] = new String[25];
		//bt¾ÈÀÇ ³»¿ë : Food ClassÀÇ Food_Name
		bt[0] = "²¿ºÏÄ¨";
		bt[1] = "»õ¿ì±ø";
		JButton snackbtn[] = new JButton[25];
		int len = snackbtn.length;
		for(int i=0; i<len; i++) {
			snackbtn[i] = new JButton(bt[i]);
			snackbtn[i].setFont(new Font("±¼¸²", Font.BOLD, 14));
			snackbtn[i].setForeground(Color.WHITE);
			snackbtn[i].setBackground(new Color(52, 152, 219));
			add(snackbtn[i]);
		}
	}

}
