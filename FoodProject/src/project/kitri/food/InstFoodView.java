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
		JButton instfood1 = new JButton("������");
		add(instfood1);
		JButton instfood2 = new JButton("������");
		add(instfood2);
		JButton instfood3 = new JButton("¥�İ�Ƽ");
		add(instfood3);
		JButton instfood4 = new JButton("�ܹ���");
		add(instfood4);
		JButton instfood5 = new JButton("����");
		add(instfood5);
		JButton instfood6 = new JButton("ġŲ");
		add(instfood6);
		JButton instfood7 = new JButton("����Ƣ��");
		add(instfood7);
	}

}
