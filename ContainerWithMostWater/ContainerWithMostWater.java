public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                if(Math.abs((i-j))*(Math.min(height[i],height[j]))>res)
                    res=Math.abs((i-j))*(Math.min(height[i],height[j]));
            }
        }
        return res;
    }
    public int maxArea_A(int[] height){
        int res=0;
        int L =0,R=height.length-1;
        while(R<L){
            res=Math.max(res,(R-L)*Math.min(height[L],height[R]));
            if(height[L]<height[R])
                L++;
            else
                R--;

        }
        return res;
    }
    public static void main(String args[]){
        int[] height = new int[]{1,8,5,6,9};
        ContainerWithMostWater con = new ContainerWithMostWater();
        System.out.println(con.maxArea(height));
        System.out.print(con.maxArea_A(height));
    }
}
