import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

// TODO: CREATE AN UNSCRAMBLER

// TODO: GET A REFERENCE PAGE FOR WORDS (DONE)


// TODO: IMPLEMENT A WAY TO INCLUDE INPUT FROM USER (DONE)
class Unscrambler {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        HashMap<Character, Integer> letterFreqDict = new HashMap<Character, Integer>();

        // TODO: Convert all words in the file to a HashMap<Word, Map<Character, Integer>>
        File file = new File("randomWords.txt");
        Scanner fScan = new Scanner(file);
        
        fScan.useDelimiter("\n");

        String nextWord = fScan.next();
        while (fScan.hasNext() != false) {
            nextWord = fScan.next();
            System.out.println(fScan.next());
            for (Character c : 
        }

        
        // System.out.print("Please type the scrambled word: ");
        // String userInput = scan.nextLine();
        // System.out.println("\n");
        // userInput = userInput.toUpperCase();

        // char[] userInputArray = userInput.toCharArray();
        // for (Character c : userInputArray) {
        //     if (letterFreqDict.get(c) == null) {
        //         letterFreqDict.put(c, 1);
        //     } else {
        //         letterFreqDict.put(c, letterFreqDict.get(c) + 1);
        //     }
        // }

        // System.out.println(letterFreqDict);

        // TODO: READ THE WORDS_ALPHA TXT FILE USING FILEREADER

    }
}

