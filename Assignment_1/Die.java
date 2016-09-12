/**
 * @ author Zachary Heilman
 * @ date 09/11/16
 */

import java.util.Random;  //Imports the Random Class

/**
 * [Die description]
 * @return [description]
 */
public class Die{
//	private static Random r = new Random();
//	private int sides;
//	private int topVal;
	// Need to ask Natasha what I am doing wrong
	public Die(){
		return Random r = new Random();
		return int sides;
		return int topVal;
	}
	/**
	 * [roll description] Rolls the die to find a random number between 1 and the number of sides
	 * @return [description]
	 */
	public int roll(int sides, int topVal){
		return this.topVal = r.nextInt(sides)+1;
	}
	/**
	 * [getTop description]  Looks at the topvalue of the die
	 * @return [description]
	 */
	public int getTop(){
		System.out.println("The Dice reads " + topVal);
		return this.topVal;
	}
}
