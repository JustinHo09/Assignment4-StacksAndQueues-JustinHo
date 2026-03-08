import java.util.Stack;

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
        
    }
}
