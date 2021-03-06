package week02;
import java.util.Random;

/**
 * Coin class used to create object for storing/flipping coins.
 * @author Nathan Laing.
 */
public class Coins{
    
    /**
     * Variable for Heads. Avoids always using T/F.
     */
    public static final boolean HEADS = true;
    
    /**
     * Variable for Tails. Avoids always using T/F.
     */
    public static final boolean TAILS = false;
    
    /**
     * Array to store coin flips in.
     */
    private boolean[] coins;
    
    /**
     * Default Constructor.
     * @param x creates a boolean Array and assigns it to coins.
     */
    public Coins(boolean[] x) {
        this.coins = x;
    }
    
    /**
     * Overriden Constructor.
     * @param c takes a "H/T" filled string and creates a boolean coin array.
     */
    public Coins(String c){
        boolean[] x = new boolean[c.length()];
        for(int i =0; i < x.length; i++){
            if(c.charAt(i)=='H'){
                x[i]=HEADS;
            } else {
                x[i]=TAILS;
            }
        }
        this.coins = x;
    }
    
    /**
     * Overriden Constructor.
     * @param length randomly fills a boolean coin Array based on length given.
     */    
    public Coins(int length){
        boolean[] x = new boolean[length];
        Random rn = new Random();
        for(int i = 0; i < length; i++){
            if(rn.nextInt(2)==1){
                x[i] = true;
            } else {
                x[i] = false;
            }
        }
        this.coins = x;
    }
    
    /**
     * Counts the 'runs' of H or T.
     * @return count the number of heads or tails runs.
     */    
    public int countRuns(){
        int count = 1;
        for(int i = 0; i < this.coins.length; i++){
            boolean run = this.coins[i];
            if((i+1)<this.coins.length && run != this.coins[i+1]){
                count++;
            }
        }
        return count;
    }
    
    /**
     * Counts the number of heads in the Array.
     * @return count the number of heads/
     */    
    public int countHeads(){
        int count = 0;
        for(int i = 0; i < coins.length; i++){
            if(coins[i]){
                count++;
            }
        }
        return count;
    }
    
    /**
     * toString method: converts boolean array to string of "H" or "T".
     * @return x the heads or tails string.
     */    
    public String toString(){
        String x = "";
        for(int i = 0; i < coins.length; i++){
            if(coins[i]){
                x+="H";
            } else {
                x+="T";
            }
        }
        return x;
    }
    
    /**
     * Main method: creates boolean array uses that for coin flips.
     * @param args  the arguements of the main method
     */    
    public static void main(String [] args){
        boolean [] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        Coins c = new Coins("HTHTHTHTHT");
        System.out.println(c.countRuns());
    }
}
