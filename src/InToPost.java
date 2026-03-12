import java.util.LinkedList;

public class InToPost {

    public static void main( String[] args) {

        String input = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(input);
        System.out.println(toPostfix(input));

    }

    public static String toPostfix(String s) {

        String result = "";
        LinkedList <Character> operators = new LinkedList<>();
        char currentChar;

        for(int i = 0; i < s.length(); i++) {

            currentChar = s.charAt(i);

            if( !isOperator(currentChar ) ) {
                result = result + currentChar;

            } else if ( currentChar == '(' ) {
                operators.addFirst(currentChar);

            } else if ( currentChar == ')' ) {

                // runs until ( is met or end is reached, which could be n, max 3
                while ( operators.peek() != null && operators.peek() != '(' ) {
                    result = result + operators.remove();
                }
                operators.remove();

            } else if ( isOperator(currentChar) ) {

                if( operators.peek() == null ) {
                    operators.addFirst(currentChar);

                } else {

                    // Will only run max of 3 times
                    while ( operators.peek() != null && operators.peek() != '(' &&
                            (precedence(operators.peek()) >= precedence(currentChar))){

                        result = result + operators.remove();
                    }
                    operators.addFirst(currentChar);

                }
            }

        }
        // operators.length < size.length
        while (operators.peek() != null) {
            result = result + operators.remove();
        }

        return result;
    }

    private static boolean isOperator(char c) {

        if ( c == '+' ) {
            return true;

        } else if ( c == '-' ){
            return true;

        } else if ( c == '*' ) {
            return true;

        } else if ( c == '/' ) {
            return true;

        } else if ( c == '^' ) {
            return true;

        } else if ( c == '(' ) {
            return true;

        } else if ( c == ')' ) {
            return true;

        }

        return false;
    }

    private static int precedence(char c) {

        if ( c == '^') {
            return 3;
        } else if ( c == '*' || c == '/' ) {
            return 2;
        } else if ( c == '+' || c == '-' ) {
            return 1;
        }

        return -1;
    }
}
