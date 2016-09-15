package Circle_Notes;
public class TestCircle {
	public static void main (String[] args){
		Circle C1 = new Circle(5.2f, 1, 3);
		System.out.println("The radius of C1 is: " + C1.getRadius());
		System.out.println("The x coordinate of C1's center is: " + C1.getCenterX());
		System.out.println("The y coordinate of C1's center is: " + C1.getCenterY());
		System.out.println("The area of C1 is: " + C1.computeArea());
		System.out.println();
		
		
		// Used with toString()
//		Circle C2 = new Circle();
//		System.out.println(C2);
//		
//		C2.setRadius(2.0f);
//		System.out.println(C2);
//		
//		Circle C3 = new Circle(3.0f);
//		System.out.println(C3);
		
		Circle C2 = new Circle();
		Circle C3 = new Circle(2.0f, 0,0);
		
		if(C2.equals(C3)){
			System.out.println("The Circles are the same.");
		} else {
			System.out.println("The Circles are not the same.");
		}
	}
}
