package Shape_Notes;

public class TestShape {
	public static void main(String[] args){
		/*Shape firstShape = new Triangle();
		Shape secondShape = new Rectangle();
		
		firstShape.displayShapeType();
		secondShape.displayShapeType();*/
		
		Shape[] shapes = new Shape[2];
		shapes[0] = new Triangle();
		shapes[1] = new Rectangle();
		
		for(int i = 0; i<2; i++){
			shapes[i].displayShapeType();
		}
	}
}
