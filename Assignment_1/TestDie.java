import java.util.Random;  //Imports the Random Class

public class TestDie{
	public static void main(String [] args){
		Die D1 = new Die();
		D1.roll();
		System.out.println("The value of the die is " + D1.getTop());
	}
}