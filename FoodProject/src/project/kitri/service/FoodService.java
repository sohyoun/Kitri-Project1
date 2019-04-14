package project.kitri.service;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import project.kitri.data.FoodDto;
import project.kitri.food.FoodController;
import project.kitri.food.FoodFrame;

public class FoodService {
	
	public FoodController foodController;
	public FoodFrame ff;
	
	public FoodDto foodDto;
	
	public FoodService(FoodController foodController) {
		this.foodController = foodController;
		ff = foodController.foodFrame;
		foodDto = new FoodDto();
	}

	public void plus() {
		int row = ff.listT.getSelectedRow();//select �� row�� index (0���� ����/�ƹ��͵� select�ȵǸ� -1)
		if (row ==-1) {
//			System.out.println("+�� ����� �������ּ���!");
			JOptionPane.showMessageDialog(ff, "(+) �� ����� �������ּ���!", "select����", JOptionPane.ERROR_MESSAGE);
		} else {
			Object column = ff.listT.getValueAt(row	, 3);//�ش� index�� row���� ����column (0���� ����)/////////row�� -1�̶��(�ƹ��͵� ����X)�� ����â
			ff.listT.setValueAt((int)column+1, row, 3);//���� �ٲ�
		}
		
	}

	public void minus() {
		int row = ff.listT.getSelectedRow();//select �� row�� index (0���� ����/�ƹ��͵� select�ȵǸ� -1)
		if (row ==-1) {
//			System.out.println("-�� ����� �������ּ���!");
			JOptionPane.showMessageDialog(ff, "(-) �� ����� �������ּ���!", "select����", JOptionPane.ERROR_MESSAGE);
		} else {
			Object column = ff.listT.getValueAt(row	, 3);//�ش� index�� row���� ����column (0���� ����)/////////row�� -1�̶��(�ƹ��͵� ����X)�� ����â
			if((int)column>1) {
				ff.listT.setValueAt((int)column-1, row, 3);//���� �ٲ�
			} else {
				ff.tM.removeRow(row);	//������ 1���� �۾����� list���� ����
			}
			
		}
		
	}

	public void oneCancel() {
		int row = ff.listT.getSelectedRow();//������ row select
		if(row ==-1) {
			JOptionPane.showMessageDialog(ff, "������ ����� �������ּ���!", "select����", JOptionPane.ERROR_MESSAGE);
		} else {
			ff.tM.removeRow(row);	///�����Ҷ��� listT�� �ƴ� tM����... listT.remove(row)�ȵ� �Ф�		
		}
	}

	public void totalCancel() {
		int rownum = ff.listT.getRowCount();
		for(int i=0; i<rownum; i++ ) {
			ff.tM.removeRow(0);//�ȿ� i�� �ƴ� 0�� �־����. ���پ� ���� ������ row�� index�� �޶����� ����!
		}
		
	}

	public void cancelOrder() {
		//�׳� ��ȭ������ ���ư���~~
		ff.setVisible(false);//���α׷��� �������� ����!!
		//table �ʱ�ȭ
		totalCancel();
	}

	public void completeOrder() {
		
	}

	public void foodProccess(String btname) {//food�޴� ��ư ������ ��
		//db���� bt�� �̸��� ���� row�� ���� ������
		FoodDto food1 = FoodDao.getInstance().selectFood(btname);		
		int count =foodController.foodFrame.tM.getRowCount();
		
		//�޾ƿ� ������ Vector�� ����� 
		Vector row = new Vector();
		row.addElement(count+1);
		row.addElement(food1.getFoodCtg());
		row.addElement(food1.getFoodName());
		row.addElement(1);//�ֹ�����
		row.addElement(food1.getFoodPrice());
//		System.out.println(row);
		
		
		
		//�޾ƿ� ������ Jtable�� ���� ��� �ֹ� ���� �ø���!!!!
//		int rownum = ff.listT.getRowCount();//���� list�� rownum
//		if(rownum==0) {
//			foodController.foodFrame.tM.addRow(row);
//		} else {
//			for(int i=0; i<rownum; i++ ) {
//				String foodname = (String)ff.listT.getValueAt(i, 2);//���� list�� �ִ� FoodName
//				if(foodname != food1.getFoodName()) { //���ο� �޴����
//					foodController.foodFrame.tM.addRow(row);//Jtable�� �߰�
//				} else {//���� list(i��°)�� ������ư�� �ִٸ�?!
//					//�����ø���
//					//�̸��� ��ư���̸��� ���� row indexã�� : i
//					//�� row�� ����column�� ã�� getValueAt(row , 3)
//					Object foodnum = ff.listT.getValueAt(i, 3);//����
//					//����column�� +1�ϱ� setValueAt((int)column+1, row, 3)
//					ff.listT.setValueAt((int)foodnum+1, i, 3);
//				}
//			}
//		}
		
		int rownum = ff.listT.getRowCount();//���� list�� rownum
		if(rownum==0) {
			foodController.foodFrame.tM.addRow(row);
		} else {
			for(int i=0; i<rownum; i++ ) {
				String foodname = (String)ff.listT.getValueAt(i, 2);//���� list�� �ִ� FoodName
				if(foodname != food1.getFoodName()) { //���ο� �޴����
					foodController.foodFrame.tM.addRow(row);//Jtable�� �߰�
					break;
				} else {//���� list(i��°)�� ������ư�� �ִٸ�?!
					//�����ø���
					//�̸��� ��ư���̸��� ���� row indexã�� : i
					//�� row�� ����column�� ã�� getValueAt(row , 3)
					Object foodnum = ff.listT.getValueAt(i, 3);//����
					//����column�� +1�ϱ� setValueAt((int)column+1, row, 3)
					ff.listT.setValueAt((int)foodnum+1, i, 3);
				}
			}
		}
		
		
	}
}
