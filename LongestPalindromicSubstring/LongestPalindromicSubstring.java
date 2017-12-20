
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {

        int n = s.length();
        Set<Character> set = new LinkedHashSet<>();
        int i=0,j=0,maxlengthinset=0;
        String res = new String();
        while(i<n&&j<n){
            if(set.contains(s.charAt(i))) {
                if (s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(j));
                    j++;
                } else {
                    if ((i - j) > maxlengthinset) {
                        maxlengthinset = i - j;
                        res = "";
                        Iterator<Character> it = set.iterator();
                        while (it.hasNext()) {
                            res = res + it.next();
                        }
                        res = res + s.charAt(i);
                        set.remove(s.charAt(j));
                        j++;
                    } else {
                        set.remove(s.charAt(j));
                        j++;
                    }
                }
            }
            else {
                    set.add(s.charAt(i));
                    i++;
            }
        }

        return res;
    }
    public static void main(String args[]){
        String s = "babad";
        System.out.print(longestPalindrome(s));
    }
}
