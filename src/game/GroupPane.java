package game;

import game.logic.Group;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author Bram Pulles
 * This class creates a Pane with the right amount of circles.
 * It is also responsible for updating the state of the circles and persons.
 */
public class GroupPane extends FlowPane{

	private Group group;
	private Circle circles[];
	
	GroupPane(Group group){
		this.group = group;
		initializeCircles();
	}
	
	/**
	 * This function initializes the Pane with the right amount of circles.
	 */
	private void initializeCircles() {
		circles = new Circle[group.size()];
		
		for(int i = 0; i < group.size(); i++) {
			circles[i] = new Circle();
			circles[i].setRadius(30);
			circles[i].setFill(Color.BLACK);
			circles[i].setOnMouseClicked(e -> circleClicked(e));
			
			this.getChildren().add(circles[i]);
			FlowPane.setMargin(circles[i], new Insets(10, 10, 10, 10));
		}
	}
	
	/**
	 * @param e MouseEvent
	 * Whenever a circle is clicked this function is called.
	 * The circle's and persons state are changed to sitting.
	 * The updateAll() function is called to start a chain reaction.
	 */
	private void circleClicked(MouseEvent e) {
		int index = -1;
		for(int i = 0; i < group.size(); i++)
			if(circles[i] == e.getSource()) {
				index = i;
				break;
			}
		
		((Circle) e.getSource()).setFill(Color.RED);
		group.getPerson(index).setStanding(false);
		System.out.println(index + " -> " + group.getPerson(index).getChoice().getID());
		
		updateAll();	
	}
	
	/**
	 * This function is called whenever a circle is clicked (after circleClicked).
	 * The function handles the chain reaction and makes everyone sit down on the floor who need to.
	 * So it changes the state of the circles and persons accordingly. 
	 */
	private void updateAll() {
		boolean stable = false;
		
		while(!stable) {
			int count = 0;
			
			for(int i = 0; i < group.size(); i++) {
				if(group.getPerson(i).getStanding() && !group.getPerson(i).getChoice().getStanding()) {
					group.getPerson(i).setStanding(false);
					circles[i].setFill(Color.RED);
					System.out.println(i + " -> " + group.getPerson(i).getChoice().getID());
				}else{
					count++;
				}
			}
			
			if(count == group.size())
				stable = true;
		}	
	}
}
