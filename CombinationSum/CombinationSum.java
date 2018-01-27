import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] nums,int target){
        List<List<Integer>> resultlist = new ArrayList<>();
        Arrays.sort(nums);//对nums进行排序
        backtrack(resultlist,new ArrayList<Integer>(),target,nums,0);
        return resultlist;
    }
    public static void backtrack(List<List<Integer>> resultlist,List<Integer> result,int remain,int[] nums,int start){
        if(remain<0) //如果当前结果小于0，结果错误，退出
            return;
        else if(remain == 0)//如果等于0，符合要求，添加到最终结果中
            resultlist.add(new ArrayList<>(result));//注意这里一定要new ArrayList(result)
        else {
            for(int i = start;i<nums.length;i++){
                result.add(nums[i]);  //添加到当前的结果中
                backtrack(resultlist,result,remain-nums[i],nums,i);//注意这里是i，不是i+1.因为可以重复使用数据
                result.remove(result.size()-1);//递归完，回溯
            }
        }
    }

    public static void main(String args[]){
        int[] nums ={2,3,6,7};
        List<List<Integer>> reslist = combinationSum(nums,7);
        System.out.println(reslist);
    }
}
