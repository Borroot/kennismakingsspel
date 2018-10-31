package game;
	
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

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
            System.exit(1);
        }
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
}
