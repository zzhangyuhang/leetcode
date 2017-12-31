import java.util.ArrayList;
import java.util.List;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {

        int n=target;
        ThreeSum ts = new ThreeSum();
        List<List<Integer>> reslist = new ArrayList<>();
        reslist = ts.threeSum(nums,target);
        if(reslist.isEmpty()){
            reslist=ts.threeSum(nums,n+=1);
        }

        System.out.println(reslist);


        return n;
    }
    public static void main(String args[]){
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
        String s = "abc";
        char[] c = s.toCharArray();
        char temp;
        for(int i=0;i<s.length()/2;i++){
            temp=c[i];
            c[i]=c[s.length()-1-i];
            c[s.length()-1-i]=temp;
        }
        String ss =String.valueOf(c);
        System.out.print(ss);
    }
}
