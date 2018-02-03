import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            //用排序好的s当作key，来进行分组
            //当存在key的时候，存在该分组，添加到对应分组中
            if(map.containsKey(String.valueOf(c))){
                map.get(String.valueOf(c)).add(s);
            }
            else {//当map中没有对应key的时候，创建新分组，然后添加s
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(String.valueOf(c),list);
            }
        }
        return new ArrayList<>(map.values());//将map的value转化为list
    }
    public static void main(String args[]){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> list = groupAnagrams(strs);
        System.out.print(list);
    }
}
