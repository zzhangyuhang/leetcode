import java.util.ArrayList;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public static int[] getNext(String t) {  //得到模式串的next数组
        int[] next = new int[t.length()];
        next[0] = -1;
        next[1] = 0;
        int j = 1;
        int k = 0;
        while (j < t.length() - 1) {
            if (t.charAt(j) == t.charAt(k)) {
                next[j + 1] = k + 1;
                j++;
                k++;
            } else if (k == 0) {
                next[j + 1] = 0;
                j++;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static int kmp(String s, String t) { //模式串匹配kmp算法
        int[] next = getNext(t);
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (j == -1 || s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == t.length())
            return i - t.length();
        else
            return -1;
    }

    public static String concatWord(String[] str,String n) {
        String word = new String(n);
        for (int i = 0; i < str.length; i++) {
            if(str[i]==n)
                continue;
            word = word + str[i];
        }
        return word;
    }

    public static List<String> concatWords(String[] str) {//排列组合

        List<String> words = new ArrayList<>();
        for(int n=0;n<str.length;n++) {
            for (int i = 0; i < str.length; i++) {
                if (i == n)
                    continue;
                for (int j = 0; j < str.length; j++) {
                    if (j == n)
                        continue;
                    String[] str_copy = str.clone();
                    String temp = str_copy[i];
                    str_copy[i] = str[j];
                    str_copy[j] = temp;
                    String word = new String();
                    word = concatWord(str_copy, str[n]);
                    if (!words.contains(word))
                        words.add(word);
                }
            }
        }
        return words;
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> position = new ArrayList<>();
        List<String> combination = concatWords(words);
        for(String t : combination){
            int i=kmp(s,t);
            position.add(i);
        }
        return position;
    }

    public static void main(String args[]) {
        List<Integer> position = findSubstring("barfoothefoobarman",new String[]{"foo","bar"});
        for(Integer i : position)
            System.out.print(i+" ");
    }
}
