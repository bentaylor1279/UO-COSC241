package week12;
import java.util.*;

/**
 *  Practical test 2 - Part A
 *
 *  An array based implementation of Young's tableau.
 *
 * @author Iain Hewson
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        final int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        System.out.println(TableauApp.toString(valid));
        System.out.println(isSetOf1toN(valid));
    }

    /**
     * Determines whether the array passed to it is valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        return rowLengthsDecrease(t) && rowValuesIncrease(t) &&
            columnValuesIncrease(t) && isSetOf1toN(t);
    }

    /**
     *  Returns a string representation of a tableau.
     *
     * @param t a two-dimensional array which should be a tableau.
     *
     * @return a string representation of a tableau.
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

    /**
     * Determines whether the array passed to it is valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean rowLengthsDecrease(int[][] t) {
      if(t.length == 0){
        return true;
      }
        for(int i = 0; i  < t.length-1; i++){
            if(t[i].length < t[i + 1].length){
                return false;
            }
        }
        return true;
    }

    /**
     * Determines whether the array passed to it is valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean rowValuesIncrease(int[][] t) {
        for(int i = 0; i < t.length; i++){
            for(int j = 0; j < t[i].length-1; j++){
                if(t[i][j] > t[i][j + 1]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determines whether the array passed to it is valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean columnValuesIncrease(int[][] t) {
        for(int i = 0; i < t.length-1; i++){
            for(int j = 0; j < t[i + 1].length; j++){
                if(t[i][j] > t[i + 1][j]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determines whether the array passed to it is valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isSetOf1toN(int[][] t) {
        
        int maxN = 0;
        for(int i = 0; i < t.length; i++){
            maxN += t[i].length;
        }
        int[] result = new int[maxN];
        int resultIndex = 0;
        for(int i = 0; i < t.length; i++){
          for(int j = 0; j < t[i].length; j++){
              result[resultIndex] = t[i][j];
              resultIndex++;
          }
        }
        Arrays.sort(result);
        for(int i = 0; i < result.length; i++){
          if(result[i] != i + 1){
            return false;
          }
        }
        return true;
    }
}
