package project.kitri.food;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.kitri.service.FoodService;
import project.kitri.service.FoodServiceImpl;

public class FoodController implements ActionListener{
	
	FoodFrame foodFrame;
	FoodService foodService;
	
	public FoodController(FoodFrame foodFrame) {
		this.foodFrame = foodFrame;
		foodService = new FoodServiceImpl(this);
		
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
	      }
		
	}

}