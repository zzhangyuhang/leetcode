import java.util.*;
public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        int[] fact = new int[n+1];//保存阶乘的数组,容量为n+1，因为0的阶乘需要也算进去
        fact[0]=1;//0的阶乘等于1
        List<Integer> nums = new ArrayList<>();//保存数字序列
        int sum = 1;//用于计算阶乘
        for(int i = 1;i<=n;i++){
            sum *= i;
            fact[i]=sum;
            nums.add(i);
        }
        k--;//因为保存的位置是从0开始的，所以需要k-1才能够正确访问到该位置的排列组合
        StringBuffer sb = new StringBuffer();//用于保存k索引出的排列组合
        for(int i = 1;i<=n;i++){
            int index = k/fact[n-i];//算出i位置的索引
            sb.append(nums.get(index));//加入到sb中
            nums.remove(index);//从原序列中移除，因为是不重复的排列组合
            k %= fact[n-i];
        }
        return sb.toString();
    }
    public static void main(String args[]){
        System.out.print(getPermutation(4,14));
    }
}
