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
			Object column = ff.listT.getValueAt(row	, 3);//해당 index의 row값의 수량column (0부터 시작)/////////row가 -1이라면(아무것도 선택X)면 오류창
			ff.listT.setValueAt((int)column+1, row, 3);//수량 바꿈
		}
		
	}

	public void minus() {
		int row = ff.listT.getSelectedRow();//select 한 row의 index (0부터 시작/아무것도 select안되면 -1)
		if (row ==-1) {
//			System.out.println("-할 대상을 선택해주세요!");
			JOptionPane.showMessageDialog(ff, "(-) 할 대상을 선택해주세요!", "select오류", JOptionPane.ERROR_MESSAGE);
		} else {
			Object column = ff.listT.getValueAt(row	, 3);//해당 index의 row값의 수량column (0부터 시작)/////////row가 -1이라면(아무것도 선택X)면 오류창
			if((int)column>1) {
				ff.listT.setValueAt((int)column-1, row, 3);//수량 바꿈
			} else {
				ff.tM.removeRow(row);	//수량이 1보다 작아지면 list에서 뺴기
			}
			
		}
		
	}

	public void oneCancel() {
		int row = ff.listT.getSelectedRow();//제거할 row select
		if(row ==-1) {
			JOptionPane.showMessageDialog(ff, "제거할 대상을 선택해주세요!", "select오류", JOptionPane.ERROR_MESSAGE);
		} else {
			ff.tM.removeRow(row);	///제거할때는 listT가 아닌 tM으로... listT.remove(row)안됨 ㅠㅠ		
		}
	}

	public void totalCancel() {
		int rownum = ff.listT.getRowCount();
		for(int i=0; i<rownum; i++ ) {
			ff.tM.removeRow(0);//안에 i가 아닌 0을 넣어야함. 한줄씩 지울 때마다 row의 index가 달라지기 때문!
		}
		
	}

	public void cancelOrder() {
		//그냥 전화면으로 돌아가기~~
		ff.setVisible(false);//프로그램이 끝나지는 않음!!
		//table 초기화
		totalCancel();
	}

	public void completeOrder() {
		
	}

	public void foodProccess(String btname) {//food메뉴 버튼 눌렀을 때
		//db에서 bt와 이름이 같은 row의 정보 빼오기
		FoodDto food1 = FoodDao.getInstance().selectFood(btname);		
		int count =foodController.foodFrame.tM.getRowCount();
		
		//받아온 정보를 Vector로 만들기 
		Vector row = new Vector();
		row.addElement(count+1);
		row.addElement(food1.getFoodCtg());
		row.addElement(food1.getFoodName());
		row.addElement(1);//주문수량
		row.addElement(food1.getFoodPrice());
//		System.out.println(row);
		
		
		
		//받아온 정보가 Jtable에 있을 경우 주문 수량 올리기!!!!
//		int rownum = ff.listT.getRowCount();//기존 list의 rownum
//		if(rownum==0) {
//			foodController.foodFrame.tM.addRow(row);
//		} else {
//			for(int i=0; i<rownum; i++ ) {
//				String foodname = (String)ff.listT.getValueAt(i, 2);//기존 list에 있는 FoodName
//				if(foodname != food1.getFoodName()) { //새로운 메뉴라면
//					foodController.foodFrame.tM.addRow(row);//Jtable에 추가
//				} else {//기존 list(i번째)에 누른버튼이 있다면?!
//					//수량올리기
//					//이름이 버튼의이름과 같은 row index찾기 : i
//					//그 row의 수량column값 찾기 getValueAt(row , 3)
//					Object foodnum = ff.listT.getValueAt(i, 3);//수량
//					//수량column을 +1하기 setValueAt((int)column+1, row, 3)
//					ff.listT.setValueAt((int)foodnum+1, i, 3);
//				}
//			}
//		}
		
		int rownum = ff.listT.getRowCount();//기존 list의 rownum
		if(rownum==0) {
			foodController.foodFrame.tM.addRow(row);
		} else {
			for(int i=0; i<rownum; i++ ) {
				String foodname = (String)ff.listT.getValueAt(i, 2);//기존 list에 있는 FoodName
				if(foodname != food1.getFoodName()) { //새로운 메뉴라면
					foodController.foodFrame.tM.addRow(row);//Jtable에 추가
					break;
				} else {//기존 list(i번째)에 누른버튼이 있다면?!
					//수량올리기
					//이름이 버튼의이름과 같은 row index찾기 : i
					//그 row의 수량column값 찾기 getValueAt(row , 3)
					Object foodnum = ff.listT.getValueAt(i, 3);//수량
					//수량column을 +1하기 setValueAt((int)column+1, row, 3)
					ff.listT.setValueAt((int)foodnum+1, i, 3);
				}
			}
		}
		
		
	}
}
