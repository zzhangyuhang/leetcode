import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForARange {
    public static int[] searchRange(int[] nums, int target) {
        int[] targerRange={-1,-1};
        int low =0 ,high = nums.length-1;
        while(low<high){  //确定target的下届
            int mid = (low+high)/2;
            if(target<=nums[mid]){  //当小于的时候high=mid，当等于的时候也要向前走，因为要确定下届。
                high=mid-1;
            }
            else  //当大于mid的时候，low向前走，注意low一定不能等于mid，因为mid是向下取整的，容易造成死循环
                low=mid+1;//每次low走都要等于mid+1
            if(low==high) //当low=high的时候，确立一个位置。
                targerRange[0]=high+1;
            if(nums[0]==target) //检查头部，因为这个方法在位置的时候+1，显示不到0
                targerRange[0]=0;
        }
        low=0;
        high=nums.length-1;
        while(low<high){  //确定上届
            int mid = (low+high)/2;
            if(target>=nums[mid])  //当大于等于的时候，low向前走。
                low=mid+1;
            else //当小于的时候折半找high的位置
                high=mid-1;
            if(high==low) //因为high一直是在不等于targer的时候走的，所以high走到的位置是target的下一位
                targerRange[1]=low-1;
            if(nums[nums.length-1]==target)
                targerRange[1]=nums.length-1;
        }
        return targerRange;
    }
    public static void main(String args[]){
        int[] nums = new int[]{1,7,7,7,7,7,7,7,7,8};
        int[] res = searchRange(nums,7);
        for(int i=0;i<res.length;i++)
            System.out.print(res[i]+" ");
    }
}
