public class ValidParentheses {
    public static boolean isValid(String s) throws ArrayIndexOutOfBoundsException{

        boolean res=false;
        try {
            if (s.toCharArray()[0] == '{') {
                if (s.toCharArray()[s.length()-1] == '}')
                    res = true;
            }
            else if (s.toCharArray()[0] == '[') {
                if (s.toCharArray()[s.length()-1] == ']')
                    res = true;
            }
            else if (s.toCharArray()[0] == '(') {
                if (s.toCharArray()[s.length()-1] == ')')
                    res = true;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            throw e;
        }
        return res;
    }
    public static void main(String args[]){
        String s = "(12312]";
        String ss = "[#$%^$^%]";
        System.out.println(isValid(s));
        System.out.print(isValid(ss));
    }
}
