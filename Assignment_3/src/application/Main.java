package application;
	
import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.image.*;

public class Main extends Application {
	protected static Random r = new Random();
	protected int topVal;
	private int loadSide;
	private int rollFactor;
	int dieVal = 0;

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane firstPane = new BorderPane();
			BorderPane secondPane = new BorderPane();
			BorderPane thirdPane = new BorderPane();
			BorderPane fourthPane = new BorderPane();
			StackPane layout = new StackPane();
			Pane p = new Pane();
			HBox hbox = new HBox();
			VBox vbox = new VBox();
			HBox hbox2 = new HBox();
			VBox vbox2 = new VBox();
			HBox hbox3 = new HBox();
			VBox vbox3 = new VBox();
			VBox vbox4 = new VBox();
			
			final TextField dieSides = new TextField();
			
			
			Button fair = new Button();	// Button for Fair dice roll
			Button loaded = new Button();  // Button for loaded dice roll
			Button cont = new Button();		// Button to decide on N sides of die
			Button roll = new Button();
			Button exit = new Button();
			Button reroll = new Button();
		
	        Label firstLabel = new Label(); // Generic Labeling
	        Label secondLabel = new Label();
	        Label thirdLabel = new Label();
	        Label fourthLabel = new Label();
	        
	        firstPane.setTop(hbox);
	        firstPane.setBottom(vbox);
	        secondPane.setTop(secondLabel);
	        secondPane.setCenter(dieSides);
	        secondPane.setBottom(vbox2);
	        thirdPane.setTop(thirdLabel);
	        thirdPane.setBottom(vbox3);
	        fourthPane.setCenter(vbox4);
	        
	        hbox.setPadding(new Insets(15,12,15,12));
	        hbox.setSpacing(10.f);
	        vbox2.setPadding(new Insets(15,12,15,12));
	        vbox2.setSpacing(10.f);
	        vbox3.setPadding(new Insets(15,12,15,12));
	        vbox3.setSpacing(10.f);
	        
	        firstLabel.setStyle("-fx-font-size: 30");
	        firstLabel.setText("Would you like to use a fair die, or a loaded die?");
	        secondLabel.setStyle("-fx-font-size: 30");
			secondLabel.setText("How many sides does your die have?");
			fourthLabel.setStyle("-fx-font-size: 30");
			fourthLabel.setText("Your first roll was a 1, Game Over!  You Lose!");
			
			Image image1 = new Image(Main.class.getResourceAsStream("die_face_1.jpg"));
			ImageView firstDie = new ImageView();   
			firstDie.setImage(image1);
			
			Image image2 = new Image(Main.class.getResourceAsStream("die_face_2.jpg"));
			ImageView secondDie = new ImageView();   
			secondDie.setImage(image2);
			
			Image image3 = new Image(Main.class.getResourceAsStream("die_face_3.jpg"));
			ImageView thirdDie = new ImageView();   
			thirdDie.setImage(image3);
			
			Image image4 = new Image(Main.class.getResourceAsStream("die_face_4.jpg"));
			ImageView fourthDie = new ImageView();   
			fourthDie.setImage(image4);
			
			Image image5 = new Image(Main.class.getResourceAsStream("die_face_5.jpg"));
			ImageView fifthDie = new ImageView();   
			fifthDie.setImage(image5);
			
			Image image6 = new Image(Main.class.getResourceAsStream("die_face_6.jpg"));
			ImageView sixthDie = new ImageView();   
			sixthDie.setImage(image6);
			
			Image blank = new Image(Main.class.getResourceAsStream("blank_face.jpg"));
			ImageView nthDie = new ImageView();   
			nthDie.setImage(blank);
			
			fair.setText("Fair Die");
			fair.setLineSpacing(10.f);
			fair.setMinWidth( 150 );
			fair.setMinHeight( 50 );			
			
			loaded.setText("Loaded Die");
			loaded.setLineSpacing(10.f);
			loaded.setMinWidth( 150 );
			loaded.setMinHeight( 50 );
			
			cont.setText("Continue");
			cont.setLineSpacing(10.f);
			cont.setMinWidth( 150 );
			cont.setMinHeight( 50 );
			
			roll.setText("Roll");
			roll.setLineSpacing(10.f);
			roll.setMinWidth( 150 );
			roll.setMinHeight( 50 );
			
			exit.setText("Exit");
			exit.setLineSpacing(10.f);
			exit.setMinWidth( 150 );
			exit.setMinHeight( 50 );
			
			reroll.setText("ReRoll");
			reroll.setLineSpacing(10.f);
			reroll.setMinWidth( 150 );
			reroll.setMinHeight( 50 );
			
			
			vbox.getChildren().add(firstLabel);
			vbox.getChildren().addAll( fair, loaded);
			hbox.getChildren().addAll(fair, loaded);
			hbox.setAlignment(Pos.CENTER); // vertical box aligns to the center
			
			
			vbox2.getChildren().add(dieSides);
			vbox2.getChildren().add(cont);
			vbox2.setAlignment(Pos.CENTER);

//			hbox3.getChildren().add(thirdLabel);
			vbox3.getChildren().addAll(roll, thirdLabel);
			vbox3.setAlignment(Pos.CENTER);
			
			vbox4.getChildren().addAll(fourthLabel, exit);
			
			Scene scene = new Scene(firstPane);
			Scene scene2 = new Scene(secondPane);
			Scene scene3 = new Scene(thirdPane, 900, 900);
			Scene scene4 = new Scene(fourthPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene4.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			fair.setOnAction( new EventHandler<ActionEvent>() {
				@Override
				public void handle( ActionEvent ke ) {
					primaryStage.close();	
					primaryStage.setScene(scene2);
					primaryStage.show();
					
					cont.setOnAction(new EventHandler<ActionEvent>(){
						@Override
						public void handle(ActionEvent arg0) {
							if (dieSides.getText().trim().isEmpty() || dieSides.getText() == null){
								dieSides.setPromptText("Please choose how many sides your die has.");
							}
							else {
								Integer value = Integer.valueOf(dieSides.getText());
								FairDie diceRoll = new FairDie(value);
								diceRoll.roll();
								topVal = diceRoll.getTop();
								primaryStage.close();
								primaryStage.setScene(scene3);
								primaryStage.show();
								
								thirdLabel.setStyle("-fx-font-size: 30");
								thirdLabel.setText("You rolled a " + topVal + "!");
								
								if(value <= 6){
									if (topVal == 1){
										thirdPane.setCenter(firstDie);
										primaryStage.setScene(scene4);
										primaryStage.show();
										
										exit.setOnAction(new EventHandler<ActionEvent>(){
											@Override
											public void handle (ActionEvent exit){
												primaryStage.close();
											}
										});
									} else if (topVal == 2){
										thirdPane.setCenter(secondDie);
									}else if (topVal == 3){
										thirdPane.setCenter(thirdDie);
									}else if (topVal == 4){
										thirdPane.setCenter(fourthDie);
									}else if (topVal == 5){
										thirdPane.setCenter(fifthDie);
									}else if (topVal == 6){
										thirdPane.setCenter(sixthDie);
									} else {
										
									}
								} else {
									
								}
							} 
								
							}
					});
				}
			});
			
			
			
			loaded.setOnAction( new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent se){
					System.out.println("Loaded Die");
				}
			});
			
			
			
			
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
