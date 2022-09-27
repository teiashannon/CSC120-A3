import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;
import java.util.Random;

class Conversation {

  /** Runs the chatbot program */
  public static String main(String[] arguments) {

    ArrayList<String> transcript = new ArrayList<String>(); /** Creates array list to store conversation transcript */

    System.out.println("Hello! How many rounds of conversation would you like?"); /** Takes user input to determine length of program */

    Scanner input = new Scanner(System.in); /** Creates Scanner */

    int userRounds = input.nextInt(); /** Creates a variable for the user input */

    System.out.println("Hello, what are you up to?"); /** Begin conversation */
    transcript.add("Hello, what are you up to?"); /** Adding conversation starter to transcript */
    Scanner input2 = new Scanner(System.in); /** Creates Scanner for conversation */

    /** Loop for the number of rounds specified by the user */
    for (int i = 0; i < userRounds; i++) { 
        String conversationInput = input2.nextLine(); /** Creates a variable for conversation input */
        transcript.add(conversationInput); /** Adds conversation input to transcript */
        mirrorWord(conversationInput, transcript); /** Runs mirror word function */
    }

    System.out.println("Ok, goodbye!"); /** Ends conversation */
    transcript.add("Ok, goodbye!"); /** Adds end of conversation to transcript */
    System.out.println("Transcript:" + transcript); /** Prints transcript */
    input.close(); /** Closes Scanner */
    input2.close(); /** Closes second Scanner */
    return "Done"; /** Dummy return so class can return string (necessary for another process earlier on) */
  }

  /** Looks for words to mirror, then replaces them in the string and returns the modified string (or unmodified if no mirror words are present) */
  public static String mirrorWord(String s, ArrayList<String> transcript) {
    String[] words = s.split(" "); /** Splits input into words and creates an array */
    String cannedResponses = new String("Oh.,Hmm.,Cool!,Interesting,Aha."); /** Creates array list to store canned responses (when no mirror words exist) */
    String[] responsesWords = cannedResponses.split(","); /** Splits responses up into each response */
    for (CharSequence w : words) { /** Loop for the detection and replacement of mirror words */
      if (w.equals("I")) { /** Replacing I with you */
        s = s.replace("I", "you");
        s = s.concat("?"); /** Adding a question mark to the end of the phrase */
      }
      else if (w.equals("you")) { /** Replacing you with I */
        s = s.replace("you","I");
        s = s.concat("?"); /** Adding a question mark to the end of the phrase */
      }
      else if (w.equals("me")) { /** Replacing me with you */
        s = s.replace("me","you");
        s = s.concat("?"); /** Adding a question mark to the end of the phrase */
      }
      else if (w.equals("am")) { /** Replacing am with are */
        s = s.replace("am","are");
        s = s.concat("?"); /** Adding a question mark to the end of the phrase */
      }
      else if (w.equals("my")) { /** Replacing my with your */
        s = s.replace("my","your");
        s = s.concat("?"); /** Adding a question mark to the end of the phrase */
      }
      else if (w.equals("your")) { /** Replacing your with my */
        s = s.replace("your","my");
        s = s.concat("?"); /** Adding a question mark to the end of the phrase */
      }
      else { /** If no mirror words are present */
        Random rand = new Random(); /** Invokes random number generator */
        int upperbound = 5; /** Sets upper bound for random number (Sets range up to 5 since there are 5 response options) */
        int int_random = rand.nextInt(upperbound); /** Random number generated */
        String randomResponse = responsesWords[int_random]; /** Random response generated */
        System.out.println(randomResponse); /** Prints random response */
        transcript.add(randomResponse); /** Adds random response to transcript */
        }
  }
    transcript.add(s); /** Add resulting string to transcript */
    System.out.println(s); /** Printing resulting string */
    return s; /** Returning resulting string */
}

}





