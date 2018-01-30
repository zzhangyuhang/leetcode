public class TrappingRainWater {
    public static int trappingRainWater(int[] nums) {
        int key = 0;
        int sum = 0;
        int i = 0;

        while(i<nums.length) {
            while(i<nums.length-1&&nums[i]<=nums[i+1]) { //查找第一个栅栏的位置
                i++;
            }
            if(i<nums.length) { //位置有效
                int j = i+1;//j为第二个栅栏
                while (j < nums.length && nums[i] > nums[j]) { //当高度大于等于当前前一根栅栏就可以作为第二根栅栏
                    j++;
                }
                if (j < nums.length) {  //j的位置有效，说明存在第二根栅栏
                    key = Math.min(nums[i],nums[j]); //取低的栅栏为水位高度
                    while (i < j) { //计算容量
                        sum = sum + (key - nums[i]);
                        i++;
                    }
                }
                else //如果没有找到第二根栅栏，说明上一根栅栏是最高的，并不能作为第一根栅栏
                    i++;//掠过开始下一位。
            }
        }
        return sum;
    }
    public static void main (String args[]){
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(trappingRainWater(nums));
    }
}
