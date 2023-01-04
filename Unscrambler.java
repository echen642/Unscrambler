import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

// TODO: CREATE AN UNSCRAMBLER

public class Unscrambler {
    private HashMap<Character, Integer> letterFreqDict;
    private HashMap<String, HashMap<Character, Integer>> bigMap;


    Unscrambler() {
        letterFreqDict = new HashMap<Character, Integer>();
        bigMap = new HashMap<String, HashMap<Character, Integer>>();
    }

    public void setUp() throws FileNotFoundException {
        File file = new File("words_alpha.txt");
        Scanner fScan = new Scanner(file);

        // ---- Creates our precomputed dictionary which we will rely on later ----
        
        while (fScan.hasNextLine() != false) {
            String nextWord = fScan.nextLine();
            nextWord = nextWord.toUpperCase();
            char[] nextWordArray = nextWord.toCharArray();
            HashMap<Character, Integer> wordMap = new HashMap<Character, Integer>();
            for (Character c : nextWordArray) {
                if (wordMap.get(c) == null) {
                    wordMap.put(c, 1);
                } else {
                    wordMap.put(c, (wordMap.get(c) + 1));
                }
            }

            bigMap.put(nextWord, wordMap);
        }
        fScan.close();
    }

    public String unscramble(String userInput) {
        // This reads user input

        // System.out.print("Please type the scrambled word: ");
        letterFreqDict.clear();
        userInput = userInput.strip();
        userInput = userInput.toUpperCase();
        
        char[] userInputArray = userInput.toCharArray();

        for (Character c : userInputArray) {
            if (letterFreqDict.get(c) == null) {
                letterFreqDict.put(c, 1);
            } else {
                letterFreqDict.put(c, letterFreqDict.get(c) + 1);
            }
        }
        
        ArrayList<String> possibleWords = new ArrayList<String>();
        for (String s : bigMap.keySet()) {
            if (bigMap.get(s).equals(letterFreqDict)) {
                possibleWords.add(s);
            }
        }

        if (possibleWords.isEmpty()) {
            return "Nothing to see here folks!";
        }

        return possibleWords.toString();

    }
    public static void main(String[] args) throws IOException{
        Unscrambler u = new Unscrambler();
        u.setUp();
        System.out.println(u.unscramble("naple  ").toString());
    }
        
}

