public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int i = nums.length-1;
        for(int j=0;j<i;j++){
            if(nums[j]==val){
                while (nums[i]==val){
                    i--;
                }
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        for(int j=0;j<i;j++)
            System.out.print(nums[j]+" ");
        return nums.length-1-(i-1);
    }
    public static int removeElement_A(int[] nums,int val){

        int i = 0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
    public static void main(String args[]){
        int[] nums = new int[]{3,1,1,3,2,2,3};
        System.out.print(removeElement_A(nums,1));
    }
}
