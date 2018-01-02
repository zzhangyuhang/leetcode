import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> reslist = new ArrayList<>();
        boolean exist=false;
        for(int a=0;a<nums.length;a++){
            for(int b=a+1;b<nums.length;b++){
                for(int c=b+1;c<nums.length;c++){
                    for(int d=c+1;d<nums.length;d++){
                        if(nums[a]+nums[b]+nums[c]+nums[d]==target){
                           for(List<Integer> list : reslist){
                               if(list.contains(nums[a])&&list.contains(nums[b])&&list.contains(nums[c])){
                                   exist=true;
                               }
                           }
                           if(exist==false){
                               List<Integer> res =  new LinkedList<>();
                               res.add(nums[a]);
                               res.add(nums[b]);
                               res.add(nums[c]);
                               res.add(nums[d]);
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
        FourSum fs = new FourSum();
        int[] nums = new int[]{1,0,-1,0,2,-2};
        int target = 0;
        System.out.print(fs.fourSum(nums,target));
    }
}
