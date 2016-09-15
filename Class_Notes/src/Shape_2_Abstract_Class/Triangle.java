package Shape_2_Abstract_Class;

public abstract class Triangle extends Shape{
	
	private float base;
	private float height;
	private final static int NUMSIDES = 3;
		
	public Triangle(float base, float height){
		super( NUMSIDES );
		this.base = base;
		this.height = height;
	}
	
	public float computeArea(){
		return 0.5f * base * height;
	}
}
