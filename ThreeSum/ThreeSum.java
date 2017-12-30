import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> reslist = new ArrayList<>();
        boolean exist=false;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> res = new LinkedList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[k]);
                        if(reslist.isEmpty()){
                            reslist.add(res);
                        }
                        else {
                            for(int t=0;t<reslist.size();t++) {
                                if (reslist.get(t).contains(nums[i])&&reslist.get(t).contains(nums[j])) {
                                    exist=true;
                                }
                            }
                            if(exist==false){
                                reslist.add(res);
                            }
                        }

                    }
                }
            }
        }
        return reslist;
    }
    public static void main(String args[]){
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test=null;
        System.out.print(test);
    }
}
