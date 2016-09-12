/**
 * @ author Zachary Heilman
 * @ date 09/11/16
 */

import java.util.Random;  //Imports the Random Class

/**
 * [Die description]
 * @return [description]
 */
public class Die (){
	private static Random r = new Random();
	private int sides;
	private int rollVal;
	private int topVal;
	
	public Die(){
		
	}
	/**
	 * [roll description]
	 * @return [description]
	 */
	public int roll(int sides){
		this.rollVal = r.nextInt(sides)+1;
	}
	/**
	 * [getTop description]
	 * @return [description]
	 */
	public int getTop(){

	}
}
