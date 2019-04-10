package project.kitri.food;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InstFoodView extends JPanel {

	/**
	 * Create the panel.
	 */
	public InstFoodView() {
		setLayout(new GridLayout(5, 5));
		setBounds(713, 123, 656, 583);
		JButton instfood1 = new JButton("³¿ºñ¶ó¸é");
		add(instfood1);
		JButton instfood2 = new JButton("ººÀ½¹ä");
		add(instfood2);
		JButton instfood3 = new JButton("Â¥ÆÄ°ÔÆ¼");
		add(instfood3);
		JButton instfood4 = new JButton("ÇÜ¹ö°Å");
		add(instfood4);
		JButton instfood5 = new JButton("ÇÇÀÚ");
		add(instfood5);
		JButton instfood6 = new JButton("Ä¡Å²");
		add(instfood6);
		JButton instfood7 = new JButton("°¨ÀÚÆ¢±è");
		add(instfood7);
	}

}
