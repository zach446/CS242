package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

/**
 * This class looks at event handlers at different
 * levels of the dispatch chain
 * 
 * @author Natasha Banerjee
 *
 */
public class eventHandler extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			/*
			 * Set up the layout components 
			 */
			VBox root = new VBox(); // Vertical box
			root.setSpacing(10.0f);
			
			Button btn1 = new Button(); // First button
			btn1.setText("Blank1");
			btn1.setStyle("-fx-background-color: #ff0000; -fx-font-size: 30; -fx-text-fill: #EEEEEE;");
			btn1.setMinWidth( 300 );
			btn1.setMinHeight( 100 );			
			
			Button btn2 = new Button(); // Second button
			btn2.setText("Blank2");
			btn2.setMinWidth( 300 );
			btn2.setMinHeight( 100 );
			btn2.setStyle("-fx-background-color: #00ff00;  -fx-font-size: 30; -fx-text-fill: #222222;");			
			
			Label printLabel = new Label();	// Label for displaying keys
			printLabel.setStyle("-fx-font-size: 30");
			
			/*
			 * Set up the scene graph
			 */
			root.getChildren().add(btn1); // Buttons and labels
			root.getChildren().add(btn2); // go into vertical box
			root.getChildren().add(printLabel);
			root.setAlignment(Pos.CENTER); // vertical box aligns to the center
			
			Scene scene = new Scene(root,400,400); // Scene is made from the root
			
			/*
			 * Set up the event handlers
			 */
			
			// key event handler for first button
			btn1.setOnKeyPressed( new EventHandler<KeyEvent>() {
				// change color of first button to red if r is pressed,
				// green if g is pressed, and blue if b is pressed 
				public void handle( KeyEvent ke ) {
					if ( ke.getCode() == KeyCode.R ) {
						btn1.setStyle("-fx-background-color: #ff0000; " + 
							"-fx-font-size: 30; -fx-text-fill: #EEEEEE;");
						
					} else if ( ke.getCode() == KeyCode.G ) {
						btn1.setStyle("-fx-background-color: #00ff00; " +
							"-fx-font-size: 30; -fx-text-fill: #222222;");
						
					} else if ( ke.getCode() == KeyCode.B ) {
						btn1.setStyle("-fx-background-color: #0000ff; " +
							"-fx-font-size: 30; -fx-text-fill: #EEEEEE;");
						
					}
				}
			});
			
			// key event handler for second button
			btn2.setOnKeyPressed( new EventHandler<KeyEvent>() {
				// change color of second button to red if r is pressed,
				// green if g is pressed, and blue if b is pressed 
				public void handle( KeyEvent ke ) {
					if ( ke.getCode() == KeyCode.R ) {
						btn2.setStyle("-fx-background-color: #ff0000; " + 
							"-fx-font-size: 30; -fx-text-fill: #EEEEEE;"); 
						
					} else if ( ke.getCode() == KeyCode.G ) {						
						btn2.setStyle("-fx-background-color: #00ff00; " + 
							"-fx-font-size: 30; -fx-text-fill: #222222;");
						
					} else if ( ke.getCode() == KeyCode.B ) {
						btn2.setStyle("-fx-background-color: #0000ff; " + 
							"-fx-font-size: 30; -fx-text-fill: #EEEEEE;");						
						
					}					
				}
			});
			
			// key event handler for vertical box (root)
			root.setOnKeyPressed( new EventHandler<KeyEvent>() {
				// shift focus between buttons if f is pressed 
				public void handle( KeyEvent ke ) {
					if ( ke.getCode() == KeyCode.F ) {
						if (btn1.isFocused()) btn2.requestFocus();
						else btn1.requestFocus();
					}					
				}
			});
			
			// another key event handler for vertical box (root)
			// to add another event, use the "addEventHandler()"
			// method
			root.addEventHandler( KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
				public void handle( KeyEvent ke ) {
					printLabel.setText( ke.getText() );					
				}
			});
			
			/*
			 * Set the scene onto the stage, and show the stage
			 */
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