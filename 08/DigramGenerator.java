package week08;

import java.util.*;
import java.io.*;

/**
 * Word generator that takes into account previous letter.
 * @author Nathan Laing.
 */

public class DigramGenerator implements WordGenerator {

    /** Distribution of first letters for english words. */
    private char [] firstLetters;

    /** Associated following letters for given char. */
    private String [] pairs;

    /** Source of randomness. */
    private Random random;

    /** Length of alphabet. */
    private final int alphalen = 26;

    /**
     * Overriden default constructor.
     * @param r source of randomness
     */
    public DigramGenerator(Random r) {
        
        random = r;
        
        File file = new File("first-letters.txt");

        try{
            
            Scanner sc = new Scanner(file);
            String text = "";
            text = sc.nextLine();
            sc.close();
            firstLetters = new char [text.length()];
            for(int i = 0; i < text.length(); i++){
                firstLetters[i] = text.charAt(i);
            }
            
        } catch (FileNotFoundException e){
            
            System.out.println(e);
        }
        
        File file2 = new File("continuations.txt");

        try{
            Scanner sc2 = new Scanner(file2);
            int i = 0;
            pairs = new String [alphalen];
            while(sc2.hasNextLine()){
                pairs[i] = sc2.nextLine();
                i++;
            }
            sc2.close();
            
        } catch (FileNotFoundException e){
            
            System.out.println(e);
        }
            
    }

    /**
     * Generates the next word of given length.
     * @param n the length of the word.
     * @return result.toString() our generated word.
     */
    public String nextWord(int n){
        
        StringBuilder result = new StringBuilder();
        
        int randomFirstIndex = random.nextInt(firstLetters.length);
        char firstChar = firstLetters[randomFirstIndex];
        result.append(firstChar);
        char prev = firstChar;
        
        for(int i = 1; i < n; i++){
            int randomIndex = random.nextInt(pairs[prev-'a'].length());
            char next = pairs[prev-'a'].charAt(randomIndex);
            result.append(next);
            prev = next;
        }
        return result.toString();
    }
}
