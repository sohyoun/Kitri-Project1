package project.kitri.food;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InstFoodView extends JPanel {
	public String bt[];
	public JButton instfoodbtn[];
	/**
	 * Create the panel.
	 */
	public InstFoodView() {
		setLayout(new GridLayout(5, 5));
		setBounds(713, 123, 656, 583);
		bt = new String[25];
		//btæ»¿« ≥ªøÎ : Food Class¿« Food_Name
		bt[0] = "∫∫¿Ωπ‰";
		bt[1] = "≥ø∫Ò∂Û∏È";
		instfoodbtn = new JButton[25];
		int len = instfoodbtn.length;
		for(int i=0; i<len; i++) {
			instfoodbtn[i] = new JButton(bt[i]);
			instfoodbtn[i].setFont(new Font("±º∏≤", Font.BOLD, 14));
			instfoodbtn[i].setForeground(Color.WHITE);
			instfoodbtn[i].setBackground(new Color(52, 152, 219));
			add(instfoodbtn[i]);
		}
	}

}
