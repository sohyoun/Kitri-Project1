package project.kitri.food;

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
		JButton noodle1 = new JButton("�Ŷ��");
		add(noodle1);
		JButton noodle2 = new JButton("�Ŷ���");
		add(noodle2);
		JButton noodle3 = new JButton("������");
		add(noodle3);
		JButton noodle4 = new JButton("��¡��«��");
		add(noodle4);
		JButton noodle5 = new JButton("Ƣ��쵿");
		add(noodle5);
		JButton noodle6 = new JButton("�����");
		add(noodle6);
		JButton noodle7 = new JButton("�նѲ�");
		add(noodle7);
		
		
	}

}
