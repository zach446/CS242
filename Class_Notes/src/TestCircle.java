
public class TestCircle {
	public static void main (String[] args){
		Circle C1 = new Circle(5.2f, 1, 3);
		System.out.println("The radius of C1 is: " + C1.getRadius());
		System.out.println("The x coordinate of C1's center is: " + C1.getCenterX());
		System.out.println("The y coordinate of C1's center is: " + C1.getCenterY());
		System.out.println("The area of C1 is: " + C1.computeArea());
		System.out.println();
	}
}
