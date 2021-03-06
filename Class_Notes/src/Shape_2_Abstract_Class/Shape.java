package Shape_2_Abstract_Class;

public abstract class Shape {
	
	private int numberOfSides;
	protected Shape(int numberOfSides){
		this.numberOfSides = numberOfSides;
	}
	
	public abstract float computeArea();
	
	public void displayNumberOfSides(){
		System.out.println("Number of sides in shape = " + this.numberOfSides);
	}
	
	public abstract void drawShape();

}
