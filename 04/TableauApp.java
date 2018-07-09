package week04;
import java.util.*;
/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Nathan Laing
 */
public class TableauApp{

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        return rowLengthsDecrease(t) && rowValuesIncrease(t)
            && columnValuesIncrease(t) && isSetOf1toN(t);
    }

    /**
     * Used to check if the row length decreases each time.
     * @param t is a 2D array representing a Tableau
     * @return true if row lengths all decrease
     */
    public static boolean rowLengthsDecrease(int [] [] t){//WORKING!!!
        for(int i = 0; i < t.length; i++){
            if(t.length == 0){//Empty arrays return true
                return true;
            }else{//If you are not at the 0th character check the one behind you
                if(i != 0 && t[i].length > t[i-1].length){
                    return false;
                }
            }
        }
        return true;//Once you have checked everything
        //and are still in loop: Finished!
    }

    /**
     * Used to check if column values increase each time.
     * @param t is a 2D array representing a Tableau
     * @return true if column values increase
     */
    public static boolean columnValuesIncrease(int [] [] t){//WORKING!!!
        for(int i = 0; i < t.length; i++){
            for(int j = 0; j < t[i].length; j++){
                if( i != 0 && t[i][j] < t[i-1][j]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Used to check if row  values increase each time.
     * @param t is a 2D array representing a Tableau
     * @return true if row values increase
     */
    public static boolean rowValuesIncrease(int [] [] t){//WORKING!!!
        for(int i = 0; i < t.length; i++){
            for(int j = 0; j < t[i].length; j++){
                if(t[i].length == 0){
                    return true;
                }else{
                    if(j != 0 && t[i][j] < t[i][j-1]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    
    /**
     * Used to check if all values from 1 to n occur.
     * @param t is a 2D array representing a Tableau
     * @return true if all values are used.
     */
    public static boolean isSetOf1toN(int [] [] t){
        int n = 0;
        for(int i =0; i < t.length; i++){
            for(int j =0; j < t[i].length; j++){
                n++;
            }
        }
        int [] result = new int [n];
        int x = 0;
        for(int i =0; i < t.length; i++){
            for(int j =0; j < t[i].length; j++){
                result[x] = t[i][j];
                x++;
            }
        }
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
        for(int i = 0; i < result.length; i++){
            if(result[i] != i+1){
                return false;
            }
        }
        return true;
    }
    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
    
}
