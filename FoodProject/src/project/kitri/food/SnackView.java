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
		JButton snack1 = new JButton("²¿ºÏÄ¨");
		snack1.setFont(new Font("±¼¸²", Font.BOLD, 14));
		snack1.setForeground(Color.WHITE);
		snack1.setBackground(new Color(52, 152, 219));
		add(snack1);
		JButton snack2 = new JButton("»©»©·Î");
		snack2.setFont(new Font("±¼¸²", Font.BOLD, 14));
		snack2.setForeground(Color.WHITE);
		snack2.setBackground(new Color(52, 152, 219));
		add(snack2);
		JButton snack3 = new JButton("¸¶ÀÌÂé");
		snack3.setFont(new Font("±¼¸²", Font.BOLD, 14));
		snack3.setForeground(Color.WHITE);
		snack3.setBackground(new Color(52, 152, 219));
		add(snack3);
		JButton snack4 = new JButton("°¡³ªÃÊÄÝ¸´");
		snack4.setFont(new Font("±¼¸²", Font.BOLD, 14));
		snack4.setForeground(Color.WHITE);
		snack4.setBackground(new Color(52, 152, 219));
		add(snack4);
		JButton snack5 = new JButton("¸ù½©");
		snack5.setFont(new Font("±¼¸²", Font.BOLD, 14));
		snack5.setForeground(Color.WHITE);
		snack5.setBackground(new Color(52, 152, 219));
		add(snack5);
		JButton snack6 = new JButton("ÃÊÄÚÆÄÀÌ");
		snack6.setFont(new Font("±¼¸²", Font.BOLD, 14));
		snack6.setForeground(Color.WHITE);
		snack6.setBackground(new Color(52, 152, 219));
		add(snack6);
		JButton snack7 = new JButton("»õ¿ì±ø");
		snack7.setFont(new Font("±¼¸²", Font.BOLD, 14));
		snack7.setForeground(Color.WHITE);
		snack7.setBackground(new Color(52, 152, 219));
		add(snack7);
	}

}
