import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static List<List<Integer>> combinationSum(int[] nums,int target){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);//排序
        backtrack(list,new ArrayList<>(),nums,target,0);//递归开始
        return list;
    }
    public static void backtrack(List<List<Integer>> list,ArrayList<Integer> templist,int[] nums,int remain,int start){
        if(remain==0){//当减出来的结果等于0时，符合要求
            list.add(new ArrayList<>(templist));//添加到结果list中
        }
        else if(remain<0)//小于0，退出，当前结果不满足要求，失败
            return;
        else {
            for(int i=start;i<nums.length;i++){
                if(i>start&&nums[i]==nums[i-1])//水平重复的跳过，这句代码很重要，记住！！！！
                    continue;
                templist.add(nums[i]);
                backtrack(list,templist,nums,remain-nums[i],i+1);//递归
                templist.remove(templist.size()-1);//回溯
            }
        }
    }
    public static void main(String args[]){
        int[] nums = {10,1,2,7,6,1,5};
        List<List<Integer>> list = combinationSum(nums,8);
        System.out.print(list);
    }
}
