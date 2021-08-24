package game;

import java.net.URL;

import game.GuiController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * @author Bram Pulles
 * This is a program which simulates an introductory game I once played in high school.
 * The idea is that you have a group of persons. All of these persons walk around randomly in a room.
 * Every person has another person in their mind. When that person sits down on the floor, you need to sit down on the floor too.
 * Then there is one game master which initializes these chain reactions by giving signals to whom needs to sit down.
 *
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			// The layout must be in a resources folder.
			URL location = getClass().getResource("/Layout.fxml");
	        FXMLLoader fxmlLoader = new FXMLLoader(location);

	        Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Kennismakingsspel!");
            primaryStage.show();
        } catch (Exception ex) {
            System.out.println("The fxml file could not be opened, check if the fxml file is in the resources folder.");
			ex.printStackTrace();
            System.exit(1);
        }
	}

	public static void main(String[] args) {
		Application.launch();
	}
}
