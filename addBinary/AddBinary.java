public class AddBinary {
    public static String addBinary(String a,String b){
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;//进位
        StringBuilder sb = new StringBuilder();
        while(i>=0||j>=0){
            int sum = carry;
            if(i>=0)
                sum += a.charAt(i--)-'0';
            if(j>=0)
                sum += b.charAt(j--)-'0';
            //我们把对应位置上的数字和进位加起来就是该位的总的加和sum
            //sum % 进制 = 该位的进位后的数字
            //sum / 进制 = 该位的进位
            sb.append(sum%2);
            carry = sum/2;
        }
        if(carry==1)
            sb.append(carry);
        return sb.reverse().toString();
    }
    public static void main(String args[]){
        String a = "11";
        String b = "1";
        System.out.print(addBinary(a,b));
    }
}
