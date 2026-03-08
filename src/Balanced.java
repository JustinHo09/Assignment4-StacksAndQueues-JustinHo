import java.util.LinkedList;

public class Balanced {

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
