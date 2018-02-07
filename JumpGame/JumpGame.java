public class JumpGame {
    public boolean canJump(int[] nums) {
        return jump(nums,0);
    }
    public boolean jump(int[] nums,int position){
        if(position==nums.length-1)
            return true;
        int furthestJump = Math.min(position+nums[position],nums.length-1);
        for(int nextposition = position+1;nextposition<=furthestJump;position++){
            if(jump(nums,nextposition))
                return true;
        }
        return false;
    }
    public static void main(String args[]){

    }
}
