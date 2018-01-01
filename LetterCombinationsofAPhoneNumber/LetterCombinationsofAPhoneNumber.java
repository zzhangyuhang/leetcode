import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofAPhoneNumber {
    public static List<List<String>> strutureLetter(){
        List<List<String>> content = new ArrayList<>();
        List<String> two = new LinkedList<>();
        two.add("a");
        two.add("b");
        two.add("c");
        List<String> three = new LinkedList<>();
        three.add("d");
        three.add("e");
        three.add("f");
        List<String> four = new LinkedList<>();
        four.add("g");
        four.add("h");
        four.add("i");
        List<String> five = new LinkedList<>();
        five.add("j");
        five.add("k");
        five.add("l");
        List<String> six = new LinkedList<>();
        six.add("m");
        six.add("n");
        six.add("o");
        List<String> seven = new LinkedList<>();
        seven.add("p");
        seven.add("q");
        seven.add("r");
        seven.add("s");
        List<String> eight = new LinkedList<>();
        eight.add("t");
        eight.add("u");
        eight.add("v");
        List<String> night = new LinkedList<>();
        night.add("w");
        night.add("x");
        night.add("y");
        night.add("z");
        content.add(two);
        content.add(three);
        content.add(four);
        content.add(five);
        content.add(six);
        content.add(seven);
        content.add(eight);
        content.add(night);
        return content;
    }
    public static List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        List<String> temp = new LinkedList<>();
        List<List<String>> content = strutureLetter();
        for(char c : digits.toCharArray()){
            if(res.isEmpty()){
                Iterator<String> it = content.get(c-'0'-2).iterator();
                while (it.hasNext()){
                    String s = it.next();
                    res.add(s);
                }
            }
            else {
                temp=res;
                res=new LinkedList<>();

                Iterator<String> itt = temp.iterator();

                while (itt.hasNext()) {
                    String s = itt.next();
                    Iterator<String> it = content.get(c-'0'-2).iterator();
                    while(it.hasNext()){
                        String ss = it.next();
                        res.add(s+ss);
                    }
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        String digits = "29";
        System.out.print(letterCombinations(digits));
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        for(Integer i : test){
            System.out.println(i);
        }
    }
}
