package Shape_Notes;

public class Shape {
	protected int shapeType = 0;
	
	protected void displayShapeType(){
		if(shapeType == 1){
			System.out.println("I am a Triangle");
		} else {
			System.out.println("I am a Rectangle");
		}
	}
}
