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
private static int rollVal = 0;
private static int topVal;
/**
 * [roll description]
 * @return [description]
 */
public int roll(int sides){
        Random r = new Random();
        this.rollVal = r.nextInt(sides)+1;
}
/**
 * [getTop description]
 * @return [description]
 */
public int getTop(){

}
}
