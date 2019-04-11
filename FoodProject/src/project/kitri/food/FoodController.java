package project.kitri.food;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.kitri.service.FoodService;

public class FoodController implements ActionListener{
	
	public FoodFrame foodFrame;
//	FoodService foodService;
	public FoodService foodService;
	
	public FoodController(FoodFrame foodFrame) {
		this.foodFrame = foodFrame;
		foodService = new FoodService(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
	      if(ob == foodFrame.drinkBtn) {
	    	  foodFrame.card.show(foodFrame.menuPanel, "drinkview");
	      } else if(ob == foodFrame.snackBtn) {
	    	  foodFrame.card.show(foodFrame.menuPanel, "snackview");
	      } else if(ob == foodFrame.noodleBtn) {
	    	  foodFrame.card.show(foodFrame.menuPanel, "noodleview");
	      } else if(ob == foodFrame.instfoodBtn) {
	    	  foodFrame.card.show(foodFrame.menuPanel, "instfoodview");
	      } else if(ob == foodFrame.plusBtn) {
	    	  foodService.plus();
	      } else if(ob == foodFrame.minusBtn) {
	    	  foodService.minus();
	      } else if(ob == foodFrame.oneCancel) {
	    	  foodService.oneCancel();
	      } else if(ob == foodFrame.totalCancel) {
	    	  foodService.totalCancel();
	      } else if(ob == foodFrame.cancelBtn) {
	    	  foodService.cancelOrder();
	      } else if(ob == foodFrame.completeBtn) {
	    	  foodService.completeOrder();
	      } else {
	    	  for(int i=0; i <foodFrame.dv.drinkbtn.length; i++) {
	    		  if(ob == foodFrame.dv.drinkbtn[i]) {
	    			  foodService.drinkProcess(foodFrame.dv.bt[i]);
			    	  break;
			      }
	    	  }
	    	  for(int i=0; i <foodFrame.sv.snackbtn.length; i++) {
	    		  if(ob == foodFrame.sv.snackbtn[i]) {
	    			  foodService.snackProcess();
			    	  break;
			      }
	    	  }
	    	  for(int i=0; i <foodFrame.nv.noodlebtn.length; i++) {
	    		  if(ob == foodFrame.nv.noodlebtn[i]) {
	    			  foodService.noodleProcess();
			    	  break;
			      }
	    	  }
	    	  for(int i=0; i <foodFrame.ifv.instfoodbtn.length; i++) {
	    		  if(ob == foodFrame.ifv.instfoodbtn[i]) {
	    			  foodService.instFoodProcess();
			    	  break;
			      }
	    	  }
	    	  
	      }
		
	}

}
