package project.kitri.food;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NoodleView extends JPanel {

	/**
	 * Create the panel.
	 */
	public NoodleView() {
		setLayout(new GridLayout(5, 5));
		setBounds(713, 123, 656, 583);
		String bt[] = new String[25];
		//bt���� ���� : Food Class�� Food_Name
		bt[0] = "�Ŷ��";
		bt[1] = "�����";
		JButton noodlebtn[] = new JButton[25];
		int len = noodlebtn.length;
		for(int i=0; i<len; i++) {
			noodlebtn[i] = new JButton(bt[i]);
			noodlebtn[i].setFont(new Font("����", Font.BOLD, 14));
			noodlebtn[i].setForeground(Color.WHITE);
			noodlebtn[i].setBackground(new Color(52, 152, 219));
			add(noodlebtn[i]);
		}
		
		
	}

}
