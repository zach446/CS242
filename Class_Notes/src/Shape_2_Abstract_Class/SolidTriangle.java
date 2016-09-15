package Shape_2_Abstract_Class;

public class SolidTriangle extends Triangle{

		public SolidTriangle(float base, float height){
			super(base, height);
		}
		
		public void drawShape(){
			System.out.println("The Shape is a " + "solid triangle");
		}
}
