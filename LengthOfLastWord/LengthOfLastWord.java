public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        return (s.trim().length()-1)-s.trim().lastIndexOf(" ");
    }

    public static void main(String args[]) {
        System.out.print(lengthOfLastWord("Hello World"));
    }
}
