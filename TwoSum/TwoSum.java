/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

Create by zyh 2017.12.13
 */

public class TwoSum {
    public static int[] twoSum(int[] nums,int target){
        int[] res={-1,-1};
        for (int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        int[] nums={2,7,11,15};
        int target=9;
        int[] res = twoSum(nums,target);
        if(res[0]==-1)
            System.out.println("No match the nums!");
        else{
            System.out.println("["+res[0]+","+res[1]+"]");
        }

    }
}
