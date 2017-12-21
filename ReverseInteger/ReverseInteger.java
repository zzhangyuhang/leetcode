public class ReverseInteger {

    public static int reverse(int x) {

        if(x<0){
            return 0-rePositiveNums(Math.abs(x));
        }
        else {
            return rePositiveNums(x);
        }
    }
    public static int rePositiveNums(int x){
        int res;
        String s = Integer.toString(x);
        StringBuffer sb = new StringBuffer();
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=0){
                sb.append(s.charAt(i));
            }
            else {
                if(sb.length()!=0){
                    sb.append(s.charAt(i));
                }
            }
        }
        res =Integer.valueOf(sb.toString());
        return res;
    }
    public static void main(String args[]){
        int x = -1020;
        System.out.println(x);
        System.out.print(reverse(x));
    }
}
