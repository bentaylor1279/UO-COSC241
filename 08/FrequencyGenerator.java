package week08;

import java.io.*;
import java.util.*;

/**
 * Produces words based on their first letter frequencies.
 * @author Nathan Laing
 */
public class FrequencyGenerator implements WordGenerator {

    /** Given source of randomness. */
    private Random random;

    /** Letter distributions. */
    private double [] weights = new double['z'-'a'+1];

    /**
     * Constructor maeks a new word generator using the letter-frequencies.
     * @param r our source of pseudo-randomness.
     */
    public FrequencyGenerator(Random r) {
        random = r;
        File file = new File("letter-frequencies.txt");

        try {
            Scanner sc = new Scanner(file);
            for (int i = 0; sc.hasNextDouble(); i++){
                weights[i] = sc.nextDouble();
            }
            sc.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Returns the next random word (of len n).
     * @param n the len
     * @return the generated word
     */
    public String nextWord(int n) {
        
        final int alphalen = 26;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < n; i++){
            char c = (char) ('a'+ chooseIndex());
            result.append(c);
        }
        return result.toString();
    }

    /**
     * Used to choose the index of the letter we want.
     * @return a 'random' letter
     */
    public double chooseIndex(){

        int i = 0;
        double r = random.nextDouble();

        while (r > weights[i]){
            r = r - weights[i];
            i++;
        }
        return i;
    }
}
    
