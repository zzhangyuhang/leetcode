import java.util.Arrays;

public class UniquePaths {
    public static int uniquePaths(int m,int n){
        //这里默认m最小
        //如果m>n进行处理,m和n互换
        if(m>n)
            return uniquePaths(n,m);
        int[] dp = new int[m];//用于记录路径数的dp数组
        //dp数组的初始化，全部初值为1
        Arrays.fill(dp,1);
        //计算非边界的路径数
        //因为非边界值是非0行或者非0列，所以我们都从1开始
        for(int i = 1;i<n;i++){
            for(int j=1;j<m;j++){
                //本行的dp[j]=上一行的dp[j]+本行的dp[j-1]
                dp[j]=dp[j]+dp[j-1];
            }
        }
        return dp[m-1];
    }
    public static void main(String args[]){
        System.out.print(uniquePaths(3,6));
    }
}
