import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;


// TODO: CREATE AN UNSCRAMBLER

public class Unscrambler {
    private HashMap<Character, Integer> letterFreqDict;
    private HashMap<String, HashMap<Character, Integer>> bigMap;
    private int maxLength;
    private File currFile = new File("words_alpha.txt");


    Unscrambler() {
        letterFreqDict = new HashMap<Character, Integer>();
        bigMap = new HashMap<String, HashMap<Character, Integer>>();
    }

    public void setUp() throws FileNotFoundException {
        bigMap.clear();
        Scanner fScan = new Scanner(currFile);

        maxLength = checkMaxLength(currFile);
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

    public void setUp(File file) throws FileNotFoundException {
        bigMap.clear();
        Scanner fScan = new Scanner(file);

        maxLength = checkMaxLength(file);
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


    public void add(File file) throws FileNotFoundException {
        Scanner fScan = new Scanner(file);
        maxLength = Math.max(maxLength, checkMaxLength(file));
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

    /**
     * Given a reference file, will figure out the length of the longest word in the
     * reference file.
     * 
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    private int checkMaxLength(File file) throws FileNotFoundException{
        Scanner fScan = new Scanner(file);
        int maxWordLength = 0;

        // ---- Creates our precomputed dictionary which we will rely on later ----
        
        while (fScan.hasNextLine() != false) {
            String nextWord = fScan.nextLine();
            if (maxWordLength == 0) {
                maxWordLength = nextWord.length();
            } else {
                maxWordLength = Math.max(maxWordLength, nextWord.length());
            }
        }
        fScan.close();
        return maxWordLength;
    }

    public int getMaxLength() {
        return maxLength;
    }
    public static void main(String[] args) throws IOException{
        Unscrambler unscrambler = new Unscrambler();
        System.out.println(unscrambler.checkMaxLength(new File("words_alpha.txt")));
    }
}