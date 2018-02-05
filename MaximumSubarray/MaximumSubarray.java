public class MaximumSubarray {
    public int maxSubArray(int[] nums){
        //问题求的序列最大子序列的和
        //我们把问题形式划分为求[0-i]的最大子序列的和
        //i从1开始到nums.length
        //每个子问题是在之前子问题的基础上建立的
        int n = nums.length;
        int[] dp = new int[n];
        dp[0]=nums[0];
        int max = dp[0];
        //我们采用动态规划的方法
        //将问题规划成若干问题
        //每个问题都是在之前问题的基础上添加一个数据出的新的子问题
        //我们判断，如果之前子问题的结果小于0
        //只会减少当前问题的结果
        //所以我们在处理的时候，当之前子问题的结果小于0的时候我们不加入当前问题，即+0
        //只有大于0的时候才加入
        for(int i =1;i<n;i++){
            dp[i] = (dp[i-1]>0?dp[i-1]:0)+nums[i];
            max = Math.max(dp[i],max);
        }
        return max;
    }
    public static void main(String args[]){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(new MaximumSubarray().maxSubArray(nums));
    }
}
