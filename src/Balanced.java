import java.util.LinkedList;

/**
 * This is the balanced calss which will call a method to determine if the input consisting of
 * the symbols (),[],{},<>, ¿?, is a balanced pair.
 */
public class Balanced {

    /**
     * This is the main method which runs some test on the isBalanced method with some test strings
     * to see if they are balanced or not. It will print the test input and the result.
     * @param args User input but not used in this
     */
    public static void main( String[] args){
        String input1 = "{[()]}";
        System.out.println(input1);
        System.out.println(isBalanced(input1));
        String input2 = "{[(])}¿";
        System.out.println(input2);
        System.out.println(isBalanced(input2));
        String input3 = "{{[[(()<>)]]}}";
        System.out.println(input3);
        System.out.println(isBalanced(input3));
    }

    /**
     * This method  will take in a string made of the proper symbols (),[],{},<>, ¿?
     * and return yes or no depending on if its balanced or not.
     * @param s The input string to test.
     * @return NO if s is not balanced, and YES if s is balanced
     */
    public static String isBalanced(String s){

        LinkedList <Character> symbolStack = new LinkedList<>();
        char currentSymbol;

        for(int i = 0; i < s.length(); i++){
            currentSymbol = s.charAt(i);

            //opening symbol
            if ( currentSymbol == '{' || currentSymbol == '(' || currentSymbol == '[' ||
                currentSymbol == '<' || currentSymbol == '¿') {

                symbolStack.addFirst(currentSymbol);

            // closing symbol
            } else {

                // No previous opening symbols but it's a closing one
                if(symbolStack.peek() == null){
                    return "NO";
                }
                // checks if hte previous one is its matching pair since
                // that is the only possible case since [{] would be false
                if (isAPair(symbolStack.peek(), currentSymbol)){
                    symbolStack.remove();
                } else {
                    return "NO";
                }

            }
        }

        if ( symbolStack.peek() == null ) {
            return "YES";
        }

        return "NO";
    }

    /**
     * This method will take two characters, in order, and return a boolean
     * value to indicate if they are pairs or not.
     * @param open The first symbol, which is usually the open one.
     * @param close The second symbol, which is usually the closed one.
     * @return true if the two characters are a matching pair, and false if not.
     */
    private static boolean isAPair (char open, char close) {

        if( open == '{' && close == '}' ) {
            return true;

        } else if ( open == '(' && close == ')' ) {
            return true;

        } else if ( open == '[' && close == ']' ) {
            return true;

        } else if ( open == '<' && close == '>' ) {
            return true;

        } else if ( open == '¿' && close == '?' ) {
            return true;

        }

        return false;
    }

}
