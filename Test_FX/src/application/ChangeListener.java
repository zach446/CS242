package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;

/**
 * This application shows a text field and a slider.
 * Currently, the slider does nothing, but
 * we will write code where
 *  the text field contents are updated based on
 * the change of the slider's valueProperty
 * 
 * @author Natasha Banerjee
 *
 */
public class ChangeListener extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox(); // Vertical box at root of scene graph
			root.setSpacing(10.0f);
			root.setStyle( "-fx-background-color: #333333");
			
			TextField textField = new TextField(); // Text Field
			textField.setStyle("-fx-background-color: #FFFFFF; -fx-font-size: 30; -fx-text-fill: #000000;");
			textField.setMaxWidth( 300 );
			
			Slider slider = new Slider(); // Slider
			slider.setMaxWidth( 300 );
			slider.setStyle("-fx-font-size: 30; -fx-text-fill: #EEEEEE;");
						
			// Add text field and slider to root			
			root.getChildren().add(textField);
			root.getChildren().add(slider);
			root.setAlignment(Pos.CENTER); // set their alignment to be centered
			
			// Code for updating the text field with the slider's
			// current value will start here
			
			
			// and the code will end here
			
			// Create a new Scene object with the VBox root
			Scene scene = new Scene(root,400,400);			
			primaryStage.setScene(scene); // set the scene on the Stage object
			primaryStage.show(); // show the Stage object (i.e., the window)
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}