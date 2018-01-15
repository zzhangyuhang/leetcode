public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int counter = nums.length;
        for(int i=0;i<counter;i++){
            for(int j=0;j<counter&&j!=i;j++){
                if(nums[i]==nums[j]){
                    counter--;
                    for(int k=j;k<counter;k++){
                        nums[k]=nums[k+1];
                    }
                }
            }
        }
        for(int i=0;i<counter;i++)
            System.out.print(nums[i]+" ");
        System.out.println();
        return counter;
    }
    public int removeDuplicates_A(int[] nums){
        int i = 0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        for(int j=0;j<i+1;j++)
            System.out.print(nums[j]);
        System.out.println();
        return i+1;
    }
    public static void main(String args[]){
        int[] nums = new int[]{1,1,2};
        System.out.print(new RemoveDuplicatesfromSortedArray().removeDuplicates_A(nums));

    }
}
