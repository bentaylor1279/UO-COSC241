package week03;

/**
 *Recursive class used to find and sum digits in a long.
 *@author Nathan Laing.
 */
public class RecursiveApp{
    
    /**
     *Main method: creates a new obj to test on.
     * @param args the args of main.
     */
    public static void main(String [] args){
    }
    
    /**
     *Returns the number of digits in a long.
     *@param n the long
     *@return returns # of digits in n.
     */
    public static long digits(long n){
        if(n < 10){
            return 1;
        }
        return 1 + digits(n/10);
    }

    /**
     *Returns the sum of the digits.
     *@param n the long.
     *@return the sum of the digits in n.
     */
    public static long sumOfDigits(long n){
        boolean isPositive = (n >= 0);
        long n2 = Math.abs(n);
        if(n2==0){
            return 0;
        }else{
            if(isPositive){
                return n2 % 10 + sumOfDigits(n2/10);
            }else{
                return -1*(n2 % 10 + sumOfDigits(n2/10));
            }
        }
    }
}
