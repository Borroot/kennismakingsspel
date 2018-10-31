package game;

import java.net.URL;
import java.util.ResourceBundle;

import game.logic.Group;
import game.logic.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

/**
 * @author Bram Pulles
 * This class controls the interaction between the GUI and the game logic.
 * 
 */
public class GuiController implements Initializable {

	/**
	 * A max number of people of 252 fits nicely on a large screen.
	 */
	private final int MAX_NUMBER_OF_PEOPLE = 252;
	
	private int numberOfPeople;
	private Group group;
	
	@FXML
	public TextField tfNumberOfPeople;
	
	/**
	 * The field is where all of the circles will be displayed.
	 */
	@FXML
	public AnchorPane field;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	/**
	 * @param e ActionEvent (The button is clicked or the 'enter' is pressed in the textfield.)
	 * Whenever the number of people is changed this function is called.
	 * The function first subtracts the number of people from the text field.
	 * Then the function creates a new group and calls the showGroup() function.
	 */
	public void numberOfPeopleChanged(ActionEvent e) {
		String text = tfNumberOfPeople.getText();
		text = text.replaceAll("[^0-9]", "");

		int num = Integer.valueOf(text);
		
		if(num < MAX_NUMBER_OF_PEOPLE + 1 && num > 1) {
				numberOfPeople = num;
				
				System.out.println("\nThere is a new Group:");
				
				Person.resetID();
				group = new Group(numberOfPeople);
				group.chooseForAll();
				showGroup();
		}
	}
	
	/**
	 * This function creates a GroupPane to show all the circles on the field.
	 */
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
