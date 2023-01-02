import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

// TODO: CREATE AN UNSCRAMBLER

public class Unscrambler {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        HashMap<Character, Integer> letterFreqDict = new HashMap<Character, Integer>();
        File file = new File("words_alpha.txt");
        Scanner fScan = new Scanner(file);

        // ---- Creates our precomputed dictionary which we will rely on later ----
        HashMap<String, HashMap<Character, Integer>> bigMap = new HashMap<String, HashMap<Character, Integer>>();
        
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

        // This reads user input
        while (true) {
            System.out.print("Please type the scrambled word: ");
            letterFreqDict.clear();
            String userInput = scan.nextLine();
            userInput = userInput.toUpperCase();

            if (userInput.equals("")) {
                scan.close();
                break;
            }
            
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
    
            System.out.println(possibleWords);
        }
    }
        
}

