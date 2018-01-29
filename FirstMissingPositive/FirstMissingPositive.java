public class FirstMissingPositive {
    public static int partition(int[] nums,int i,int j){
        int piovt = nums[i];
        while(i<j){
            if(i<j&&nums[j]>piovt)
                j--;
            else
                nums[i]=nums[j];
            i++;
            if(i<j&&nums[i]<piovt)
                i++;
            else
                nums[j]=nums[i];
            j--;
        }
        nums[i]=piovt;
        return i;
    }
    public static void quickSort(int[] nums,int low,int high){
        if(low<high) {
            int pivotloc = partition(nums, low, high);
            quickSort(nums, low, pivotloc - 1);
            quickSort(nums, pivotloc + 1, high);
        }
    }
    public static int firstMissPositive(int[] nums){
        for(int i=0;i<nums.length;i++){
            //把正整数移动到应该在的位置
            //例如nums[i]=5，移动到4的位置，也就是nums[4],nums[i]-1=4;
            if(nums[i]>0&&nums[i]<nums.length&&nums[i]!=nums[nums[i]-1]){
                int temp = nums[i];        //两个位置互换
                nums[i] = nums[nums[i]-1];
                nums[nums[i]-1] = temp;
            }
        }
        for(int i=0;i<nums.length;i++){  //遍历当遇到不连续的位置+1为最终结果
            if(nums[i]!=i+1)
                return i+1;
        }
        return nums.length+1;//因为1开头，当都连续的时候，缺失的一定是队尾的那个数字
    }
    public static void main(String args[]){
        int[] nums = {1,2,0};
        System.out.print(firstMissPositive(nums));
    }
}
