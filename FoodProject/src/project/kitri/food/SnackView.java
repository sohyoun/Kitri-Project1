package project.kitri.food;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import project.kitri.service.FoodDao;

import java.awt.Color;
import java.awt.Font;

public class SnackView extends JPanel {
	public String bt[];
	public JButton snackbtn[];
	/**
	 * Create the panel.
	 */
	public SnackView() {
		setLayout(new GridLayout(5, 5, 1, 1));
		setBounds(713, 123, 656, 583);
		
		String foodctg = "����";//??????????
		List<String> foodnamelist = FoodDao.getInstance().getFoodnamelist(foodctg);
		
		int len = foodnamelist.size();
		snackbtn = new JButton[len];
		for(int i=0; i<len; i++) {
			snackbtn[i] = new JButton(foodnamelist.get(i));
			snackbtn[i].setFont(new Font("����", Font.BOLD, 14));
			snackbtn[i].setForeground(Color.WHITE);
			snackbtn[i].setBackground(new Color(52, 152, 219));
			add(snackbtn[i]);
		}
	}

}
