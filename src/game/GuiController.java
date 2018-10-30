package game;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class GuiController implements Initializable {

	@FXML
	public TextField numberOfPeople;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void numberOfPeopleChanged(ActionEvent e) {
		System.out.println(numberOfPeople.getText());
	}

}
