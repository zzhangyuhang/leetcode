public class MultiplyStrings {
    public static String multiplyStrings(String num1,String num2){
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m+n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int temp = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                result[i+j+1]=result[i+j+1]+temp%10;
                result[i+j]=result[i+j]+temp/10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<m+n;i++){
            if(i==0&&result[i]==0)
                continue;
            sb.append(result[i]);
        }

        return sb.toString();
    }
    public static void main(String args[]){
        System.out.print(multiplyStrings("2","5"));

    }
}
