public class SearchInRotatedSortedArray {
    public static int search(int[] nums,int key){
        int low=0,high=nums.length;  //初始化
        int mid = (low+high)/2;  //mid初始化，要是数组为递增顺序mid=（low+high）/2
        int i=0;
        while(i<nums.length-2){   //遍历数组，查看数组是否为递增顺序
            if(nums[i]>nums[i+1]) //若不是，修改mid值为递增顺序的最后一个数字
                mid=i;
            i++;
        }
        while(low<=high){ //二分查找
            if(key==nums[mid])//因为之前定义了mid的值，所以这么先进行对比再修改mid值
                return mid; //找到返回下标mid
            if(key<nums[mid]&&key>=nums[low])  //确定key所在的区间
                high=mid-1;
            else
                low=mid+1;
            mid=(low+high)/2;
        }
        return -1;
    }
    public static void main(String args[]){
        int[] nums = new int[]{0,1,2,3,4,5,6,7};
        int[] nums1 = new int[]{4,5,6,7,0,1,2,3};
        System.out.print(search(nums1,3));
    }
}
