import java.util.LinkedList;

public class LongestValidParentheses {
    public static int validParentheses(String s) {
        int counter = 0;
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i)=='(')
                stack.push(s.charAt(i));
            if(s.charAt(i)==')'){
                if(stack.peek()=='('){
                    counter+=2;
                    stack.pop();
                }
            }
        }
        return counter;
    }
    public static int longestValidParenttheses(String s){
        int maxLength=0;
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            if(s.charAt(i)=='(')
                stack.push(i);
            if(s.charAt(i)==')'){
                Integer j=stack.pop();
                maxLength=Math.max(maxLength,i-j+1);
            }
        }
        return maxLength;
    }
    public static int longestValidParentthesesNoSpace(String s){
        int lcounter = 0;
        int rcounter = 0;
        int maxLength = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                lcounter++;
            if(s.charAt(i)==')')
                rcounter++;
            if(lcounter==rcounter)
                maxLength=Math.max(maxLength,rcounter*2);
            if(rcounter>lcounter){
                lcounter=0;
                rcounter=0;
            }
        }
        lcounter=rcounter=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='(')
                lcounter++;
            if(s.charAt(i)==')')
                rcounter++;
            if(lcounter==rcounter)
                maxLength=Math.max(maxLength,rcounter*2);
            if(lcounter>rcounter){
                lcounter=0;
                rcounter=0;
            }
        }
        return maxLength;
    }
    public static void main(String args[]){
        System.out.println(validParentheses("())(())"));
        System.out.println(longestValidParenttheses("())(())"));
        System.out.print(longestValidParentthesesNoSpace("())(())"));
    }
}
