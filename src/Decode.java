import java.util.LinkedList;

/**
 * This method will run tests on some string inputs to decode them given that
 * they are in the format of number[digit].
 */
public class Decode {

    /**
     * This will run some basic tests on some input strings using the
     * decoer method and will print the input, and then the decoded string.
     * @param args User input but not used in this.
     */
    public static void main(String[] args) {
        String input1 = "3[a]2[bc]";
        System.out.println(input1);
        System.out.println(decoder(input1));
        String input2 = "3[a2[c]]";
        System.out.println(input2);
        System.out.println(decoder(input2));
        String input3 = "2[abc]3[cd]ef";
        System.out.println(input3);
        System.out.println(decoder(input3));
    }

    /**
     * This method will take a string in the format number[letter]
     * and will decode it so that there be a number amounnt of letter.
     * @param s The string to decode
     * @return A decoded string
     */
    public static String decoder(String s) {

        // keep track of the letters at each bracket
        LinkedList<String> letters = new LinkedList<>();
        // keep track of hte multiplier for each bracket
        LinkedList<Integer> ks = new LinkedList<>();
        String currentString = "";
        char current;
        int k = 0;
        int multiplier;

        for (int i = 0; i < s.length(); i++) {

            current = s.charAt(i);

            // check if number
            if (isNum(current)) {
                // one digit at a time
                k = (k * 10) + toNum(current);
            // breack means number ends and letter will start
            } else if (current == '[') {
                // add the number since its done and then reset it for next time
                ks.addFirst(k);
                k = 0;
                // add what ever the current string for this set of bracket is to the LL
                // and reset currentString to build from scratch
                letters.addFirst(currentString);
                currentString = "";
            // the end of hte bracket pair is reached
            } else if (current == ']') {
                // get the outside letter / previous segment
                String temp = letters.remove();
                
                String repeated = "";
                multiplier = ks.remove();
                // repeats the current string for this bracket layer
                // its multiplier amount of times
                for (int j = 0; j < multiplier; j++) {
                    repeated = repeated + currentString;
                }
                // add outside letter / previous sequence to current one
                currentString = temp + repeated;

            } else {
                // add to current letter sequence
                currentString = currentString + current;

            }


        }

        return currentString;

    }

    /**
     * This method will take in a character and return if the character is a number
     * or has a numeric equivalent.
     * @param c The charcter to check if it is a number.
     * @return true if it is a number, false if not.
     */
    public static boolean isNum ( char c) {

        if( c == '0' || c ==  '1' || c == '2' || c == '3' || c == '4'
                || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
            return true;
        }

        return false;
    }

    /**
     * This will take in a number character and return its integer equivalent.
     * @param c The character to get its numeric equivalent.
     * @return An integer that is the character's equivalment, -1 if not a character 0-9.
     */
    public static int toNum( char c) {

        if( c == '0'){
            return 0;
        } else if ( c == '1' ) {
            return 1;
        } else if ( c == '2' ) {
            return 2;
        } else if ( c == '3' ) {
            return 3;
        } else if ( c == '4' ) {
            return 4;
        } else if ( c == '5' ) {
            return 5;
        } else if ( c == '6' ) {
            return 6;
        } else if ( c == '7' ) {
            return 7;
        } else if ( c == '8' ) {
            return 8;
        } else if ( c == '9' ) {
            return 9;
        }
        return -1;
    }
}
