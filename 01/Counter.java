package week01;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Counter class for lines and words.
 * @author Nathan Laing.
 */
public class Counter{
    /**
     * Main method:
     * Creates a Scanner to read in user input.
     * Sets up counters.
     * Reads lines and and increments word+line count.
     * Outputs word and line count to command line.
     * @param args takes user input through Scanner.
     */
    public static void main(String [] args){
                
        Scanner sc = new Scanner(System.in);
        int countWords = 0;
        int countLines = 0;
        while(sc.hasNextLine()){     
            String userIn = sc.nextLine();
            countLines++;
            countWords += wordCount(userIn);
        
        }
        System.out.println("lines: "+countLines);
        System.out.println("words: "+countWords);
    }
    /**
     * Takes a String and returns the tokens (i.e. wordcount).
     * @param x the input String.
     * @return tokens.countTokens() the word count.
     */
    public static int  wordCount(String x){
        StringTokenizer tokens = new StringTokenizer(x);
        return tokens.countTokens();
    }
}
