public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) { //找到i的位置
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {  //找j的位置
                j--;
            }
            swap(i,j,nums);  //交换i，j位置的两个数字
        }
        reverse(i+1,nums);

    }
    public static void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void reverse(int start,int[] nums){
        int i = start;
        int j = nums.length-1;
        while (i<j){
            swap(i,j,nums);
            i++;
            j--;
        }
    }
    public static void main(String args[]){
        int[] nums = new int[]{1,5,8,4,7,6,5,3,1};
        nextPermutation(nums);
        for (int i=0;i<nums.length;i++)
            System.out.print(nums[i]+" ");
    }
}
