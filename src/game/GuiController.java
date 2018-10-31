package game;

import java.net.URL;
import java.util.ResourceBundle;

import game.logic.Group;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class GuiController implements Initializable {

	private int numberOfPeople;
	private Group group;
	
	@FXML
	public TextField tfNumberOfPeople;
	
	@FXML
	public AnchorPane field;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void numberOfPeopleChanged(ActionEvent e) {
		String text = tfNumberOfPeople.getText();
		text = text.replaceAll("[^0-9]", "");

		int num = Integer.valueOf(text);
		
		if(num < 50 && num > 1) {
			if(num == numberOfPeople) {
				group.chooseForAll();
			}else{
				numberOfPeople = num;
				group = new Group(numberOfPeople);
				group.chooseForAll();
				showGroup();
			}
		}
	}
	
	public void showGroup() {
		GroupPane groupPane = new GroupPane(group);
		
		// This is so the groupPane automatically resizes.
		AnchorPane.setBottomAnchor(groupPane, (double) 0);
		AnchorPane.setLeftAnchor(groupPane, (double) 0);
		AnchorPane.setRightAnchor(groupPane, (double) 0);
		AnchorPane.setTopAnchor(groupPane, (double) 0);
		
		groupPane.setAlignment(Pos.BASELINE_CENTER);
		
		field.getChildren().clear(); 
		field.getChildren().add(groupPane);
	}
}
