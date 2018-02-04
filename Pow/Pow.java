public class Pow {
    public static double mypow(double x,double n){
        int N = (int)n;
        if(N<0){  //当n小于0的时候
            x = 1/x;// 我们需要把数字取反
            N = Math.abs(N);//n取绝对值
        }
        return quickpow(x,N);
    }
    public static double quickpow(double x,int n){
        if(n==0){  //递归终点
            return 1.0;
        }
        double half = quickpow(x,n/2);
        //长度每次分半，直到长度为1的时候，1/2=0的时候停止
        //返回的时候half=1.0
        //然后开始向前递归
        //有了基础的half，考虑当前的分半是否整分
        if(n%2==0)//整分直接平放
            return half*half;
        else//没整分，因为是向下取整，每次奇数都会余出来一个单个数据，所以在原来的基础上多乘以一个x
            return half*half*x;
    }
    public static void main(String args[]){
        System.out.print(mypow(2.0,4.0));
    }
}
