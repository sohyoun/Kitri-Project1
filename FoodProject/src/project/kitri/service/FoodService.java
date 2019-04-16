package project.kitri.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import project.kitri.data.BasketDto;
import project.kitri.data.FoodDto;
import project.kitri.data.StockDto;
import project.kitri.food.FoodController;
import project.kitri.food.FoodFrame;

public class FoodService {

	public FoodController foodController;
	public FoodFrame ff;

	public FoodDto foodDto;
	public BasketDto basketDto;

	public FoodService(FoodController foodController) {
		this.foodController = foodController;
		ff = foodController.foodFrame;
		foodDto = new FoodDto();

	}

	public void plus() {
		int row = ff.listT.getSelectedRow();// select �� row�� index (0���� ����/�ƹ��͵� select�ȵǸ� -1)
		if (row == -1) {
//			System.out.println("+�� ����� �������ּ���!");
			JOptionPane.showMessageDialog(ff, "(+) �� ����� �������ּ���!", "select����", JOptionPane.ERROR_MESSAGE);
		} else {
			int sumprice = Integer.parseInt(ff.sumprice.getText()) + (int) ff.tM.getValueAt(row, 4);
			ff.sumprice.setText(sumprice + "");

			Object column = ff.tM.getValueAt(row, 3);// �ش� index�� row���� ����column (0���� ����)/////////row�� -1�̶��(�ƹ��͵� ����X)��
														// ����â
			ff.tM.setValueAt((int) column + 1, row, 3);// ���� �ٲ�
		}

	}

	public void minus() {
		int row = ff.listT.getSelectedRow();// select �� row�� index (0���� ����/�ƹ��͵� select�ȵǸ� -1)
		if (row == -1) {
//			System.out.println("-�� ����� �������ּ���!");
			JOptionPane.showMessageDialog(ff, "(-) �� ����� �������ּ���!", "select����", JOptionPane.ERROR_MESSAGE);
		} else {
			int sumprice = Integer.parseInt(ff.sumprice.getText()) - (int) ff.tM.getValueAt(row, 4);
			ff.sumprice.setText(sumprice + "");

			Object column = ff.tM.getValueAt(row, 3);// �ش� index�� row���� ����column (0���� ����)/////////row�� -1�̶��(�ƹ��͵� ����X)��
														// ����â
			if ((int) column > 1) {
				ff.tM.setValueAt((int) column - 1, row, 3);// ���� �ٲ�
			} else {
				ff.tM.removeRow(row); // ������ 1���� �۾����� list���� ����
				// no �ٲٱ�
				int rownum = ff.tM.getRowCount();
				for (int i = row; i < rownum; i++) {
					ff.tM.setValueAt(row + 1, i, 0);
					row++;
				}
//				
			}

		}

	}

	public void oneCancel() {
		int row = ff.listT.getSelectedRow();// ������ row select
		if (row == -1) {
			JOptionPane.showMessageDialog(ff, "������ ����� �������ּ���!", "select����", JOptionPane.ERROR_MESSAGE);
		} else {
			// sumprice ����
			// ����� ����� �Ѱ��� ����Xprice
			int minusprice = (int) ff.tM.getValueAt(row, 4) * (int) ff.tM.getValueAt(row, 3);
			int sumprice = Integer.parseInt(ff.sumprice.getText()) - minusprice;
			ff.sumprice.setText(sumprice + "");

			ff.tM.removeRow(row); /// �����Ҷ��� listT�� �ƴ� tM����... listT.remove(row)�ȵ� �Ф�

			// no �ٲٱ�
			int rownum = ff.tM.getRowCount();
			for (int i = row; i < rownum; i++) {
				ff.tM.setValueAt(row + 1, i, 0);
				row++;
			}
		}
	}

	public void totalCancel() {
		int rownum = ff.tM.getRowCount();
		for (int i = 0; i < rownum; i++) {
			ff.tM.removeRow(0);// �ȿ� i�� �ƴ� 0�� �־����. ���پ� ���� ������ row�� index�� �޶����� ����!
		}
		ff.sumprice.setText("0");// sumprice �ʱ�ȭ

	}

	public void cancelOrder() {
		// �׳� ��ȭ������ ���ư���~~
		ff.setVisible(false);// ���α׷��� �������� ����!!
		// table �ʱ�ȭ
		totalCancel();
	}

//	public void completeOrder(String memberid) {//�ֹ��ϴ� member_id ���;���.
//		//food_name , member_id , pay_num, order_amt,pay_date
//		//tM list�� �ִ� food_num�̶� order_amt(����) �о��
//		int rownum = ff.tM.getRowCount();//1���� ����
////		Ư�� pay_num���� Order_hstr ���̺� insert �ϱ�!
//		for(int i=0;i<rownum;i++) {
//			String food_name = (String)ff.tM.getValueAt(i, 2);
//			String pay_num = "100001";
//			int order_amt = (int)ff.tM.getValueAt(i, 3);
//			FoodDao.getInstance().insertOrder(food_name, memberid, pay_num, order_amt);
//		}
//
//		cancelOrder();
//	}

	public void completeOrder() {
		int rownum = ff.tM.getRowCount();
		for (int i = 0; i < rownum; i++) {
			String food_name = (String) ff.tM.getValueAt(i, 2);
			int order_amt = (int) ff.tM.getValueAt(i, 3);
			FoodDto food1 = FoodDao.getInstance().selectFood(food_name);
			BasketDto bk = new BasketDto(food1, order_amt);
//		      mf.mc.mfs.addFood(bk);      
		}
		cancelOrder();
	}

//	public void icedrink() {
//		
//		int row = ff.listT.getSelectedRow();
//		if (row ==-1) {
//			JOptionPane.showMessageDialog(ff, "ice�� �� ���Ḧ �������ּ���!", "select����", JOptionPane.ERROR_MESSAGE);
//			ff.ice.setSelected(false);
//		} else {
//			String icedrink = (String)ff.tM.getValueAt(row, 2);
//			boolean flag = icedrink.endsWith("(I)");
////			System.out.println(flag);
//			if(flag ==false) {
//				ff.tM.setValueAt(icedrink+"(I)", row, 2);
//				
//			} else {
//				int leng = icedrink.length();
//				String orgin = icedrink.substring(0, leng-3);
//				ff.tM.setValueAt(orgin, row, 2);
//			}
//			ff.ice.setSelected(false);
//		}
//	}

	public void foodProccess(String btname) {// food�޴� ��ư ������ ��
		// db���� bt�� �̸��� ���� row�� ���� ������
		FoodDto food1 = FoodDao.getInstance().selectFood(btname);
		
		if(stockProccess(food1)==true) {//���� return�� true��  : ����ִ�
			int count = ff.tM.getRowCount();

			// �޾ƿ� ������ Vector�� �����
			Vector row = new Vector();
			row.addElement(count + 1);
			row.addElement(food1.getFoodCtg());
			row.addElement(food1.getFoodName());
			row.addElement(1);// �ֹ�����
			row.addElement(food1.getFoodPrice());
			// �ѱݾ� sumprice ���ϱ�
			int price = food1.getFoodPrice();
			int sumprice = price + Integer.parseInt(ff.sumprice.getText());
			ff.sumprice.setText(sumprice + "");

			boolean flag = false;
			if (count == 0) {
				ff.tM.addRow(row);
			} else {
				for (int i = 0; i < count; i++) {

					String foodname = (String) ff.tM.getValueAt(i, 2);// ���� list�� �ִ� FoodName
					if (foodname.equals(btname)) {// ���� list(i��°)�� ������ư�� �ִٸ�?!
						// �����ø���
						// �̸��� ��ư���̸��� ���� row indexã�� : i
						// �� row�� ����column�� ã�� getValueAt(row , 3)
						Object foodnum = ff.tM.getValueAt(i, 3);// ����
						// ����column�� +1�ϱ� setValueAt((int)column+1, row, 3)
						ff.tM.setValueAt((int) foodnum + 1, i, 3);
						flag = false;
						break;
					} else {// ���ο� �޴����
						flag = true;
					}
				}
			}

			if (flag == true) {
				ff.tM.addRow(row);// Jtable�� �߰�
			}
		} else {
			JOptionPane.showMessageDialog(ff, "��� �����ϴ�!", "���X", JOptionPane.NO_OPTION);
		}
		
	}

	private boolean stockProccess(FoodDto food1) {
		boolean flag = false;
		// stock table�� foodctg�� btname�� ctg ������ ã��.
		Map<String, StockDto> stock = FoodDao.getInstance().selectStock(food1.getFoodCtg());
		
		// food1.getStock1name()�� stockname�� ���� �� ã��
//		int stockCtgCount = stock.size();//ctg���� ��� ���� ��
		
		StockDto stockDto1 = stock.get(food1.getStock1name());//food1�� ���1�� �ش��ϴ� �����Dto
		
		StockDto stockDto2 = stock.get(food1.getStock2name());
		
		StockDto stockDto3 = stock.get(food1.getStock3name());
		//food1�� ��� 1���ۿ� ��� 2,3�� null�϶��� �����ؾ���.!!!!!!!!!
		if(stockDto1.getRestAmt()<=food1.getStock1num() && stockDto2.getRestAmt()<=food1.getStock2num() && stockDto3.getRestAmt()<=food1.getStock3num()) {
		//food1�� ������ ����Ҷ�!
			flag = true;//completeOrder�Ҷ� ��� �� ����!!!
		}
		System.out.println(stockDto1);
		/*
		int number = 24;
		System.out.println("�λ��� " + number + "���� ���� ����!!");
		PlayDto playDto = map.get("DS"+number);
		System.out.println(playDto); // Map�� ���� ������� key���� ����ؾ��Ѵ�.
									 // Map�ȿ��� �ּҰ��� �����.(�ּҰ�=key��)
		 */
		// food1.getStock1num() <=restamt ��� �� ���ƾ���!
		// ��� ������ ��� �� ���ƾ߸� ���� �� �մ�.
		return flag;
	}

}
