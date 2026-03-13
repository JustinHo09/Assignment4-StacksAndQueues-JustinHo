import java.util.LinkedList;

/**
 * This class is used to implement a infix to post fix expression converter.
 */
public class InToPost {

    /**
     * This will run a test input on the toPostfix and print the
     * input and output, which should be the postfix expression.
     * @param args User input but not used here.
     */
    public static void main( String[] args) {

        String input = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(input);
        System.out.println(toPostfix(input));

    }

    /**
     * This returns the postfix equivalent of an infix expression.
     * @param s The infix expression to get the postfix equivalent of.
     * @return String which is the postfix expression.
     */
    public static String toPostfix(String s) {

        String result = "";
        // Stores operators
        LinkedList <Character> operators = new LinkedList<>();
        char currentChar;

        for(int i = 0; i < s.length(); i++) {

            currentChar = s.charAt(i);

            // adds the non operator to the postfix expression
            if( !isOperator(currentChar ) ) {
                result = result + currentChar;

            // This will add ( to the linked list to handle
            // the precedent of things encased in parentheses
            } else if ( currentChar == '(' ) {
                operators.addFirst(currentChar);

            // This means the part in parentheses is done and is higher precedent is over.
            } else if ( currentChar == ')' ) {

                // runs until ( is met or end is reached, which could be n, max 3
                // will pop all operators to ensure they happen and removes () from
                // the final expression
                while ( operators.peek() != null && operators.peek() != '(' ) {
                    result = result + operators.remove();
                }
                operators.remove();

            // This will add one of the operators not (), to the linked list
            } else if ( isOperator(currentChar) ) {

                // if it is empty, no need to check precedent just insert.
                if( operators.peek() == null ) {
                    operators.addFirst(currentChar);

                } else {

                    // Will only run max of 3 times
                    // Check precedent to make sure it follows the order and if
                    // it does follow with order skip loop and just add to linked list
                    // if not take loop until a point where precedent will hold then add
                    // to linked list.
                    while ( operators.peek() != null && operators.peek() != '(' &&
                            (precedence(operators.peek()) >= precedence(currentChar))){

                        result = result + operators.remove();
                    }
                    operators.addFirst(currentChar);

                }
            }

        }
        // operators.length < size.length
        // add remaining operators to the result
        while (operators.peek() != null) {
            result = result + operators.remove();
        }

        return result;
    }

    /**
     * This checks to see if a character is one of the operators
     * or parentheses.
     * @param c The character to check.
     * @return true if it is an operator or a parentheses.
     */
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

    /**
     * This method takes in a character, which is an operator
     * and returns a numerical equivalent of its precedent
     * the higher the integer the greater the precedent.
     * @param c The operator to get the precedent of.
     * @return Integer value, the higher the value the greater its precedence, -1
     *          if not an operator.
     */
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
