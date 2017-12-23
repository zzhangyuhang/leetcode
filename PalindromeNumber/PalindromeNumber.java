public class PalindromeNumber {

    public static int reverseInt_1(int x){
        int n=Math.abs(x);
        int carry=(""+n).length();
        int sum=0;
        while(n!=0){
            sum=sum+(int)Math.pow(10,carry-1)*(n%10);
            n=n/10;
            carry-=1;
        }
        if(x>0){
            return sum;
        }
        else if(x==0){
            return 0;
        }
        else {
            return 0-sum;
        }
    }
    public static int reverseInt_2(int x){
        int n = Math.abs(x);
        String s = Integer.toString(n);
        StringBuffer stringBuffer=new StringBuffer(s);
        int res=Integer.valueOf(stringBuffer.reverse().toString());
        if(x>0)
            return res;
        else if (x==0)
            return 0;
        else
            return 0-res;
    }
    public static boolean isPalindrome(int x) {
        int reverse=reverseInt_1(x);
        if(reverse==x)
            return true;
        else
            return false;
    }

    public static void main(String args[]){
        int x = 12321;
        System.out.println(reverseInt_2(x));
        System.out.print(isPalindrome(x));
    }
}
