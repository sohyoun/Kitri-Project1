package project.kitri.food;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class DrinkView extends JPanel {
	/**
	 * Create the panel.
	 */
	public String bt[];
	public JButton drinkbtn[];
	public DrinkView() {
		setLayout(new GridLayout(5, 5, 1,1));
		setBounds(713, 123, 656, 583);
		//String bt[] =  {"7","8","9","+","4","5","6","-","1","2","3","*","0","C","=","/"};
		bt = new String[25];
		//bt안의 내용 : Food Class의 Food_Name
		bt[0] = "아메리카노";
		bt[1] = "카페라떼";
		drinkbtn = new JButton[25];
		int len = drinkbtn.length;
		for(int i=0; i<len; i++) {
			drinkbtn[i] = new JButton(bt[i]);
			drinkbtn[i].setFont(new Font("굴림", Font.BOLD, 14));
			drinkbtn[i].setForeground(Color.WHITE);
			drinkbtn[i].setBackground(new Color(52, 152, 219));
			add(drinkbtn[i]);
		}

	}

}