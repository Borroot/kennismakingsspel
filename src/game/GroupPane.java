package game;

import game.logic.Group;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GroupPane extends FlowPane{

	private Group group;
	
	GroupPane(Group group){
		this.group = group;
		initializeCircles();
	}
	
	private void initializeCircles() {
		Circle circles[] = new Circle[group.size()];
		
		for(int i = 0; i < group.size(); i++) {
			circles[i] = new Circle();
			circles[i].setRadius(30);
			circles[i].setFill(Color.BLACK);
			circles[i].setOnMouseClicked(e -> circleClicked());
			
			this.getChildren().add(circles[i]);
			FlowPane.setMargin(circles[i], new Insets(10, 10, 10, 10));
		}
	}
	
	private void circleClicked() {
		System.out.println("Circle Clicked.");
	}
	
}
