package application;
	
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

/**
 * This class looks at event filters at different levels
 * of the dispatch chain
 * 
 * @author Natasha Banerjee
 *
 */
public class Click_To_Print extends Application {
	
	// Global variables
	private boolean setDraggable = false; // toggle between dragging and clicking
	private boolean mousePressed = false; // flag to keep track of whether the mouse is held down
	private double xoffset; // offset of left side of hbox from x coordinate of clicked point
	private double yoffset; // offset of top side of hbox from y coordinate of clicked point
	
	@Override	
	public void start(Stage primaryStage) {
		try {
			
			/*
			 * Set up the layout components
			 */
			AnchorPane root = new AnchorPane(); // root is anchorpane
			root.setStyle( "-fx-background-color: #444444");
			
			HBox box = new HBox(); // box is within anchor pane
			box.setStyle( "-fx-background-color: #aaaaaa;");
			box.setMinWidth( 300 );
			box.setMinHeight( 100 );
			box.setTranslateX( 50 );
			box.setTranslateY( 50 );
			box.setAlignment(Pos.CENTER);
	        
	        Button button = new Button(); // Button to click for printing to label
	        button.setText("Click to print");
	        button.setStyle( "-fx-background-color: #bbff7f; -fx-font-size: 30");
	        
	        ToggleButton dragToggleButton = new ToggleButton(); // Button to toggle dragging and clicking
	        dragToggleButton.setStyle( "-fx-background-color: #bbff7f; -fx-font-size: 30");
	        dragToggleButton.setText("Toggle Drag/Click");
	        
	        Label printLabel = new Label(); // Label to print "Hello" to
	        printLabel.setText("");
	        printLabel.setStyle( "-fx-text-fill: #eeeeee; -fx-font-size: 20");
	        
	        /*
	         * Build the scene graph
	         */
	        Scene scene = new Scene(root,400,400); // At the top is the scene
	        root.getChildren().add( box ); // The anchor pane contains the HBox,	        
	        root.getChildren().add(dragToggleButton); // the toggle button,
	        root.getChildren().add(printLabel); // and the label to print to	      
	        box.getChildren().add( button ); // The HBox contains the clickable button
	        
	        
	        AnchorPane.setBottomAnchor( dragToggleButton, 100.0 ); // anchor the toggle button to the bottom left
	        AnchorPane.setLeftAnchor( dragToggleButton, 10.0 );
	        AnchorPane.setBottomAnchor( printLabel, 50.0 ); // anchor the label to the bottom left
	        AnchorPane.setLeftAnchor( printLabel, 10.0 );
	        
	        /*
	         * Set up your event handling
	         */
	        
	        // Click to button handler appends hello to print label
	        button.setOnAction( new EventHandler<ActionEvent>() {
	        	public void handle( ActionEvent ae ) {
	        		printLabel.setText(printLabel.getText() + " Hello" );
	        	}
	        });
	        
	        // Toggle button handler: toggles the drag/click stage
	        dragToggleButton.setOnAction( new EventHandler<ActionEvent>() {
	        	public void handle( ActionEvent ae ) {
	        		setDraggable = !setDraggable;	        		
	        	}
	        });
	        
	        
	        /*
	         * The following currently uncommented event handlers do not let
	         * the HBox be moved if the mouse cursor is clicked
	         * at the location of the Click to print button,
	         * as the button is the lowest node in the scene graph,
	         * and receives the event and acts on it. We will comment
	         * these out in class 
	         */
	        
	        box.setOnMousePressed( new EventHandler<MouseEvent>() {
	        	public void handle( MouseEvent me ) {
	        		if (setDraggable) {
	        			// Gets the current coordinates of the HBox
	        			xoffset = box.getTranslateX() - me.getSceneX();
	        			yoffset = box.getTranslateY() - me.getSceneY();
	        			mousePressed = true;
	        			
	        		}	        		
	        	}
	        });
	        
	        box.setOnMouseDragged( new EventHandler<MouseEvent>() {
	        	public void handle( MouseEvent me ) {
	        		if (setDraggable && mousePressed) {
	        			// Translates the box to the location pointed
	        			// by the cursor via dragging
	        			box.setTranslateX( xoffset + me.getSceneX() );
	        			box.setTranslateY( yoffset + me.getSceneY() );
	        			
	        		}
	        	}
	        });
	        
	        box.setOnMouseReleased( new EventHandler<MouseEvent>() {
	        	public void handle( MouseEvent me ) {
	        		if (setDraggable) {
	        			// Releases the mouse press
	        			mousePressed = false;
	        			
	        		}	        		
	        	}
	        });
	        
	        
	        /*
	         * Instead, we use event filters to filter out the event 
	         * of clicking the mouse at the location of the button,
	         * before it reaches the button. Currently, these are
	         * commented out, we will uncomment them in class 
	         */
	        
	        /*
	        // Filter for mouse pressed event: records the offset of the 
	        // box left and top from the current pressed coordinates
	        // in scene space (i.e., within the entire stage)
	        box.addEventFilter( MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
	        	public void handle( MouseEvent me ) {
	        		if (setDraggable) {
	        			// Gets the current coordinates of the HBox
	        			xoffset = box.getTranslateX() - me.getSceneX();
	        			yoffset = box.getTranslateY() - me.getSceneY();
	        			mousePressed = true;
	        			
	        		}	        		
	        	}
	        });
	        
	        // Filter for mouse dragged event: moves the HBox (and everything in it)
	        // by changing the box's translation using the scene coordinates
	        // offset by the values in xoffset and yoffset
	        box.addEventFilter( MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
	        	public void handle( MouseEvent me ) {
	        		if (setDraggable && mousePressed) {
	        			// Translates the box to the location pointed
	        			// by the cursor via dragging
	        			box.setTranslateX( xoffset + me.getSceneX() );
	        			box.setTranslateY( yoffset + me.getSceneY() );
	        			
	        		}
	        	}
	        });
	        
	        // Filter for mouse released: update the fact that the mouse was pressed to false
	        box.addEventFilter( MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
	        	public void handle( MouseEvent me ) {
	        		if (setDraggable) {
	        			// Releases the mouse press
	        			mousePressed = false;
	        			
	        		}	        		
	        	}
	        });
	        */
	        	        
	        /*
	         * Set the scene within the stage and show the stage			
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