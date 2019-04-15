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
		int row = ff.listT.getSelectedRow();//select 한 row의 index (0부터 시작/아무것도 select안되면 -1)
		if (row ==-1) {
//			System.out.println("+할 대상을 선택해주세요!");
			JOptionPane.showMessageDialog(ff, "(+) 할 대상을 선택해주세요!", "select오류", JOptionPane.ERROR_MESSAGE);
		} else {
			int sumprice = Integer.parseInt(ff.sumprice.getText())+(int)ff.tM.getValueAt(row, 4);
			ff.sumprice.setText(sumprice+"");
			
			Object column = ff.tM.getValueAt(row, 3);//해당 index의 row값의 수량column (0부터 시작)/////////row가 -1이라면(아무것도 선택X)면 오류창
			ff.tM.setValueAt((int)column+1, row, 3);//수량 바꿈
		}
		
	}

	public void minus() {
		int row = ff.listT.getSelectedRow();//select 한 row의 index (0부터 시작/아무것도 select안되면 -1)
		if (row ==-1) {
//			System.out.println("-할 대상을 선택해주세요!");
			JOptionPane.showMessageDialog(ff, "(-) 할 대상을 선택해주세요!", "select오류", JOptionPane.ERROR_MESSAGE);
		} else {
			int sumprice = Integer.parseInt(ff.sumprice.getText())-(int)ff.tM.getValueAt(row, 4);
			ff.sumprice.setText(sumprice+"");
			
			Object column = ff.tM.getValueAt(row, 3);//해당 index의 row값의 수량column (0부터 시작)/////////row가 -1이라면(아무것도 선택X)면 오류창
			if((int)column>1) {
				ff.tM.setValueAt((int)column-1, row, 3);//수량 바꿈
			} else {
				ff.tM.removeRow(row);	//수량이 1보다 작아지면 list에서 뺴기
				//no 바꾸기
				int rownum = ff.tM.getRowCount();
				for(int i=row;i<rownum; i++) {
					ff.tM.setValueAt(row+1, i, 0);
					row++;
				}
//				
			}

		}
		
	}

	public void oneCancel() {
		int row = ff.listT.getSelectedRow();//제거할 row select
		if(row ==-1) {
			JOptionPane.showMessageDialog(ff, "제거할 대상을 선택해주세요!", "select오류", JOptionPane.ERROR_MESSAGE);
		} else {
			//sumprice 빼기
			//취소할 대상의 총가격 수량Xprice
			int minusprice = (int)ff.tM.getValueAt(row, 4)*(int)ff.tM.getValueAt(row, 3);
			int sumprice = Integer.parseInt(ff.sumprice.getText())-minusprice;
			ff.sumprice.setText(sumprice+"");
			
			ff.tM.removeRow(row);	///제거할때는 listT가 아닌 tM으로... listT.remove(row)안됨 ㅠㅠ	
			
			//no 바꾸기
			int rownum = ff.tM.getRowCount();
			for(int i=row;i<rownum; i++) {
				ff.tM.setValueAt(row+1, i, 0);
				row++;
			}
		}
	}

	public void totalCancel() {
		int rownum = ff.tM.getRowCount();
		for(int i=0; i<rownum; i++ ) {
			ff.tM.removeRow(0);//안에 i가 아닌 0을 넣어야함. 한줄씩 지울 때마다 row의 index가 달라지기 때문!
		}
		ff.sumprice.setText("0");//sumprice 초기화
		
	}

	public void cancelOrder() {
		//그냥 전화면으로 돌아가기~~
		ff.setVisible(false);//프로그램이 끝나지는 않음!!
		//table 초기화
		totalCancel();
	}

	public void completeOrder(String memberid) {//주문하는 member_id 얻어와야함.
		//food_name , member_id , pay_num, order_amt,pay_date
		//tM list에 있는 food_num이랑 order_amt(수량) 읽어옴
		int rownum = ff.tM.getRowCount();//1부터 시작
//		특정 pay_num으로 Order_hstr 테이블에 insert 하기!
		for(int i=0;i<rownum;i++) {
			String food_name = (String)ff.tM.getValueAt(i, 2);
			String pay_num = "100001";
			int order_amt = (int)ff.tM.getValueAt(i, 3);
			FoodDao.getInstance().insertOrder(food_name, memberid, pay_num, order_amt);
		}

		cancelOrder();
	}
	
	public void icedrink() {
//		if(ff.ice.isSelected()) {//라디오버튼 표시된채로 drinkbtn 누르면
//			System.out.println("(I)붙여라");
//		}
		int row = ff.listT.getSelectedRow();
		if (row ==-1) {
			JOptionPane.showMessageDialog(ff, "ice로 할 음료를 선택해주세요!", "select오류", JOptionPane.ERROR_MESSAGE);
			ff.ice.setSelected(false);
		} else {
			String icedrink = (String)ff.tM.getValueAt(row, 2);
			boolean flag = icedrink.endsWith("(I)");
			System.out.println(flag);
			if(flag ==false) {
				ff.tM.setValueAt(icedrink+"(I)", row, 2);
				
			} else {
				int leng = icedrink.length();
				String orgin = icedrink.substring(0, leng-3);
				ff.tM.setValueAt(orgin, row, 2);
			}
			ff.ice.setSelected(false);
		}
		/*
		int row = ff.listT.getSelectedRow();//select 한 row의 index (0부터 시작/아무것도 select안되면 -1)
		if (row ==-1) {
//			System.out.println("+할 대상을 선택해주세요!");
			JOptionPane.showMessageDialog(ff, "(+) 할 대상을 선택해주세요!", "select오류", JOptionPane.ERROR_MESSAGE);
		} else {
			int sumprice = Integer.parseInt(ff.sumprice.getText())+(int)ff.tM.getValueAt(row, 4);
			ff.sumprice.setText(sumprice+"");
			
			Object column = ff.tM.getValueAt(row, 3);//해당 index의 row값의 수량column (0부터 시작)/////////row가 -1이라면(아무것도 선택X)면 오류창
			ff.tM.setValueAt((int)column+1, row, 3);//수량 바꿈
		}
		 */
		
	}

	public void foodProccess(String btname) {//food메뉴 버튼 눌렀을 때
		//db에서 bt와 이름이 같은 row의 정보 빼오기
		FoodDto food1 = FoodDao.getInstance().selectFood(btname);		
		int count =ff.tM.getRowCount();

		//받아온 정보를 Vector로 만들기 
		Vector row = new Vector();
		row.addElement(count+1);
		row.addElement(food1.getFoodCtg());
		row.addElement(food1.getFoodName());
		row.addElement(1);//주문수량
		row.addElement(food1.getFoodPrice());
		//총금액 sumprice 구하기
		int price = food1.getFoodPrice();
		int sumprice = price +Integer.parseInt(ff.sumprice.getText());
		ff.sumprice.setText(sumprice+"");
		
		boolean flag = false;
		if(count==0) {
			ff.tM.addRow(row);
		} else {
			for(int i=0; i<count; i++ ) {
				
				String foodname = (String)ff.tM.getValueAt(i, 2);//기존 list에 있는 FoodName
				if(foodname.equals(btname)) {//기존 list(i번째)에 누른버튼이 있다면?! 
					//수량올리기
					//이름이 버튼의이름과 같은 row index찾기 : i
					//그 row의 수량column값 찾기 getValueAt(row , 3)
					Object foodnum = ff.tM.getValueAt(i, 3);//수량
					//수량column을 +1하기 setValueAt((int)column+1, row, 3)
					ff.tM.setValueAt((int)foodnum+1, i, 3);
					flag = false;
					break;
				} else {//새로운 메뉴라면
					flag = true;					
				}
			}
		}
		
		if(flag == true) {
			ff.tM.addRow(row);//Jtable에 추가
		}
		
	}

	
}
