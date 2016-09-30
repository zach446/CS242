package Dice;
import java.lang.reflect.Array;
import java.util.Arrays;


public class DiceArray {
	/**
	 * The main program will create an array of 5 die rolls.  3 of which are regular die rolls, and 2 are loaded.
	 * They will then roll the dice and show the value of the die rolls.  After that the value will be 
	 * added into an array, so it can sort the array in numerical order.
	 *
	 *@params Will run without user input
	 */
	public static void main(String[] args){
		
		/**
		 * Creates the array of dice rolls
		 */
		int Dn = 12;
		Die[] dice = new Die[5];
		dice[0] = new Die(Dn);
		dice[1] = new Die(Dn);
		dice[2] = new Die(Dn);
		dice[3] = new LoadedDie(Dn, 2, 68);
		dice[4] = new LoadedDie(Dn, 5, 70);

		/**
		 * Evaluates each die roll
		 */
		int[] results = new int[5];
		for (int i = 0; i < dice.length; i++){
			dice[i].roll();
			results[i] = dice[i].roll();
			System.out.println(dice[i]);
		}
		System.out.println("\n\n");
		
		/**
		 * Sorts the results
		 */
		Arrays.sort(results);

		for (int m = 0; m < results.length; m++){
			System.out.println("With a " + Dn + "-sided die we get the following roles: " + results[m]);
		}

	}
}
