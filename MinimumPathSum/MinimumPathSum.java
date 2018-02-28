public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int length = grid.length;//二维数组行长度
        int wigth = grid[0].length;//二维数组宽长度
        int[] dp = new int[wigth];//我们以列为单位建立dp数组
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < wigth; j++) {
                if (j == 0) {
                    if (i == 0)//i=0&&j=0,为起点，dp[j]=1
                        dp[j] = 1;
                    else//j=0,为上边界
                        //new dp[j] = grid[i][j] + old dp[j]
                        dp[j] = grid[i][j] + dp[j];
                }
                else {
                    if (i == 0)//i=0，为左边界
                        dp[j] = grid[i][j] + dp[j - 1];
                    else {//i!=0&&j!=0，非边界
                        int min = Math.min(dp[j], dp[j - 1]);
                        dp[j] = grid[i][j] + min;
                    }
                }
            }
        }
        return dp[wigth - 1];
    }

    public static void main(String args[]){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.print(new MinimumPathSum().minPathSum(grid));
    }
}
