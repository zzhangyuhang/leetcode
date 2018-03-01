public class PlusOne {
    public static int[] plusOne(int[] digits){
        for(int i = digits.length-1;i>=0;i--){
            if(digits[i]<9){
                //在末尾小于9，直接加，加完返回
                //如果末尾等于9，交给else，在前边最近的小于9的位完成进位，完成后返回
                digits[i]+=1;
                return digits;
            }
            else //该位等于9，进位1，该位等于0
                digits[i]=0;
        }
        //如果digits数组全是9的情况，for循环内是没有返回的
        //99999+1=100000，数组长度是不够的，需要新建一个length+1的数组，首位为1，其他都为0
        int[] newDigits = new int[digits.length+1];
        newDigits[0]=1;
        return newDigits;
    }
    public static void main(String args[]){
        int[] digits = {1,2,3,9};
        for(int i : plusOne(digits))
            System.out.print(i+" ");
    }
}
