package application;
import java.lang.*;
import java.util.Random;  /*Imports the Random Class*/
public class FairDie {
	protected static Random r = new Random();
	protected int sides;
	protected int topVal;


	/**
	 * This is the second Die Constructor.  It takes in n amount of sides
	 *
	 *@param The constructor brings in user data which represents the number of sides on the die
	 */
	public FairDie(int n){
		this.sides = n;
		this.topVal = 1;

	}

	/**
	 * Rolls the die to determine the number on the die.  The value of sides indicates
	 * the range of the random number generator and topVal is the variable that will store
	 * the value of the die.
	 * @return 	the top value of the 6-sided die.
	 */
	public int roll(){
		this.topVal = r.nextInt(sides)+1;
		return topVal;
	}

	/**
	 * Is looking at the top value of the 6-sided die to determine what the value rolled is.
	 * @return the top value of the 6-sided die.
	 */
	public int getTop(){
		return this.topVal;
	}

}
