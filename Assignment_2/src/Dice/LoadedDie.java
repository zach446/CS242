/**
 * @author Zachary Heilman
 * Date: 09/30/16
 *
 */
package Dice;
import java.lang.*;
import java.util.Random;


public class LoadedDie extends Die{

	private int loadSide;
	private int rollFactor;

	/**
	 * Default Constructor given the values of (6,2,56)
	 *
	 */
	public LoadedDie(){
		this(6, 2, 56); // Value picked arbitrarily 
	}

	/**
	 * Secondary Constructor which brings in n, loadedSide, and loadFactor
	 * 
	 * @param Where n is the number of sides, loadedSide is which side will show, and load factor is the 
	 * percentage of how often the loaded side will be rolled
	 */
	public LoadedDie(int n, int loadedSide, int loadFactor){
		super.sides = n; // Used super to bring in the variables from the Die Class
		super.topVal = 1;
		this.loadSide = loadedSide;
		this.rollFactor = loadFactor;
	}

	/**
	 * Works just like roll() within the Die class.  Will evaluate the inputs, and throw an exception if there is
	 * invalid input data. Will then find the value of topVal.  It does this by finding a random number between
	 * 0 and 100.  If the value is less than the loadFactor then it will assign topVal a random value between 1 and the
	 * number of sides on the die.  If the RNG picks the same value as the loaded side, then it finds a different random number.
	 * If the rollfactor from the 1-100 RNG is above the user input, then it assigns topVal the value of loadSide. 
	 * 
	 * @return Returns the value of the top facing die.
	 *
	 */
	public int roll(){
		if(sides < 4){
			// Utilizing the exception handling this way allows for ease when it comes to exception handling
			throw new IllegalArgumentException("Must have more than 4 sides. You have " + sides + " sides.");
		} else if(loadSide < 1 || loadSide > sides){
			throw new IllegalArgumentException("Your loaded side must be between 1 and the number of sides on the die."
					+ "  Your loaded side is " + loadSide + ".");
		} else if(rollFactor < 0 || rollFactor > 100){
			throw new IllegalArgumentException("Your load factor must be between 0 and 100.  Yours is " + rollFactor + ".");
		}else {	
			// The variable, results, is given a valua betwen 0-100
			int result = super.r.nextInt(101);
			// If that result is less than the percentile chance of getting the loaded value then the value of the die
			// will have to be determined
			if (result < this.rollFactor) {
				// topVal is given a random value between 1 and n-sides of the die
				topVal = super.r.nextInt(sides) + 1;
				// If the value of topVal is given the value of the loaded side, then it will assign it a different number
				while(topVal == loadSide){
					topVal = super.r.nextInt(sides) + 1;
				}
			} else {
				// If the result variable is greater than the percentile chance of getting the load value then topVal
				// is assigned the value of loadSide
				topVal = loadSide;
			}
			return topVal;
		}
	}
	
	/**
	 * Is looking at the top value of the 6-sided die to determine what the value rolled is.
	 * @return the top value of the 6-sided die.
	 */
	public int getTop(){
		return this.topVal;
	}
	
	/**
	 * Tests to make sure that the number of sides and the top face are the same
	 * 
	 * @return A True or False depending on if the value of sides and topVal are equal
	 * to the other.
	 *
	 */
	public boolean equals(Object other){
		LoadedDie otherDie = (LoadedDie)other;
		return this.sides == otherDie.sides &&
				this.topVal == otherDie.topVal &&
				this.loadSide == otherDie.loadSide &&
				this.rollFactor == otherDie.rollFactor;
	}
	
	/**
	 * compareTo is used to compare objects to other objects.
	 * In this case, it will compare the die value.  
	 *
	 *@return Will return the value of the compareTo.  Which will be -1 if the sides are less than the other sides
	 *0 if the sides are equal
	 *or 1 if the sides are greater than the other sides
	 */
	public int compareTo(Die otherDie){
		if (this.sides < otherDie.sides){
			return -1;
		} else if(this.sides == otherDie.sides){
			return 0;
		} else {
			return 1;
		}
	}
	
	/**
	 * HashCode will be called because of the equals class.  Whenever an object is called more than once
	 * the hashCode must return the same integer provided.  This will show that the values are truely equal.
	 * 
	 * The value of the return should equal to the values of sides and topVal.  If they are different then we know
	 * that they do not equal.
	 * 
	 * @return Will return the values of sides and topVal.
	 *
	 */
	public int hashCode(){
		int result = 7;
		result = 31*result + sides;
		result = 31*result + topVal;
		result = 31*result + rollFactor;
		return result;
	}
	
	/**
	 * Will return a string that indicates the status of the die.
	 * 
	 * @return Will describe the status of the Die.
	 *
	 */
	public String toString(){
		return "The die has " + this.sides + " sides and has an upward facing number of " + this.topVal + ".  Which "
				+ "is loaded to show " + this.loadSide + " with a percentage of " + this.rollFactor + "%";
	}
	
}
