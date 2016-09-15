import java.awt.Point;

public class Circle {
	private float radius;
	private Point center;
	
	public Circle(float radius, int centerX, int centerY){
		this.radius = radius;
		this.center = new Point(centerX, centerY);
	}
	
	public Circle(float radius){
		this(radius, 0,0);
	}
	
	public Circle(){
		this(1.0f);
	}
	
	public void setRadius(float radius){
		this.radius = radius;
	}
	
	public float getRadius(){
		return this.radius;
	}
	
	public void setCenter(int centerX, int centerY){
		this.center.x = centerX;
		this.center.y = centerY;
	}
	
	public int getCenterX(){
		return this.center.x;
	}
	
	public int getCenterY(){
		return this.center.y;
	}
	
	public float computeArea(){
		float area = 
				((float)(Math.PI*(double)this.radius*(double)this.radius));
		return area;
	}
	
	public boolean equals(Circle other){
		return this.radius == other.radius &&
				this.center.x == other.center.x &&
				this.center.y == other.center.y;
	}
	
	// Overides the hascode of the constructor
	// Refer to Lecture 5 Slides
//	public int hashCode(){
//		return 0x20;
//	}
	
	/*
	 * Prints a string representation of the Object.
	 * Can be found in Lecture 5 slides
	 */
	
//	public String toString(){
//		return "The circle has radius " + this.radius + ", center: (" + this.center.x + ", " + this.center.y + "), and area is: " + this.computeArea(); 
//	}
}
