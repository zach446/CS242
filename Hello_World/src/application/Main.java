package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Sets up the Flow Pane from javaFX
			FlowPane root = new FlowPane();
//			Group root = new Group();
			// Used to make the box that pops up look better
			root.setPadding(new Insets(20,20,20,20));
			root.setHgap(20);
			Scene scene = new Scene(root,370,60, Color.BLACK);
			
			final Canvas canvas = new Canvas(25, 25);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			
			gc.setFill(Color.BLUE);
			gc.fillRect(20, 20, 20, 20);
			// Sets up the TextField from within javaFX
			TextField txtField = new TextField();
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Button btn = new Button();
			btn.setText("Print Hello World!");
			
//			ButtonHandler handler = new ButtonHandler();
//			btn.setOnAction(handler);  //Sets the event handler for the buttons action to be handler
			
			
			// The below code works just like the above code, but creates an anonymous
			// class that implements and interface
			btn.setOnAction(new EventHandler<ActionEvent>(){
				
				@Override
				public void handle(ActionEvent event){
				txtField.setText("Hello World");
				}
			});
			root.getChildren().add(canvas);
			root.getChildren().add(btn);  // Adds button obj to the scene graph
			root.getChildren().add(txtField);  // Adds Textfield obj to the scene graph
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
