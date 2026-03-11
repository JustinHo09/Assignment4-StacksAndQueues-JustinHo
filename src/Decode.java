import java.util.LinkedList;

public class Decode {

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

    public static String decoder(String s) {

        LinkedList<String> letters = new LinkedList<>();
        LinkedList<Integer> ks = new LinkedList<>();
        String currentString = "";
        char current;
        int k = 0;
        int multiplier;

        for (int i = 0; i < s.length(); i++) {

            current = s.charAt(i);

            if (isNum(current)) {
                // one digit at a time
                k = (k * 10) + toNum(current);
            } else if (current == '[') {
                ks.addFirst(k);
                k = 0;

                letters.addFirst(currentString);
                currentString = "";
            } else if (current == ']') {
                // get the outside letter / previous segment
                String temp = letters.remove();
                
                String repeated = "";
                multiplier = ks.remove();

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

    public static boolean isNum ( char c) {

        if( c == '0' || c ==  '1' || c == '2' || c == '3' || c == '4'
                || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
            return true;
        }

        return false;
    }

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
