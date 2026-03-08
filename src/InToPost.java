import java.util.Stack;

public class InToPost {

    public static void main( String[] args) {

        String input = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(input);
        System.out.println(toPostfix(input));

    }

    public static String toPostfix(String s) {
        
        String result = "";
        Stack <Character> operators = new Stack<>();
        char currentChar;

        for(int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if( !isOperator(currentChar ) ) {

            }

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
}
