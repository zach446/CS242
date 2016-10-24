package application;

import javafx.event.*;

public class ButtonHandler 
		implements EventHandler<ActionEvent> {

	public ButtonHandler(){
		
	}
	
	public void handle(ActionEvent event){
		System.out.println("Hello World!");
	}
}
