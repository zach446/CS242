package Shape_2_Abstract_Class;

public class TestShape {
	/**
	 * This is used to show the usefullness of Polymorphism
	 * Because we extend Triangle from Shape and solidTriangle from Triangle
	 * We can use any 3 constructors to calculate the volume
	 */
	public static void main(String[] args){
		
		//Shape t = new SolidTriangle(2.0f, 1.5f);
		//Triangle t = new SolidTriangle(2.0f, 1.5f);
		SolidTriangle t = new SolidTriangle(2.0f, 1.5f);
		System.out.println(t.computeArea());
		t.drawShape();
		t.displayNumberOfSides();
	}
}
