import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LSWRC {
    public static int lengthOfLongestSubstring_bySet(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i=0,j=0,ans=0;
        while(i<n&&j<n){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                i++;
                ans=Math.max(ans,i-j);
            }
            else {
                set.remove(s.charAt(j));
                j++;
            }
        }
        System.out.println(set);
        return ans;
    }

    public static int lengthOfLongestSubstring_byMap(String s){
        int n = s.length();
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0,j=0;i<n;i++){
            if(map.containsKey(s.charAt(i))){
                j=Math.max(map.get(s.charAt(i)),j);
            }
            ans =  Math.max(ans,i-j+1);
            map.put(s.charAt(i),i+1);
        }

        System.out.println(map);
        return ans;
    }
    public static  void main(String args[]){

        String s ="pwwkew";
        System.out.print(lengthOfLongestSubstring_bySet(s));
        System.out.print(lengthOfLongestSubstring_byMap(s));
    }
}
