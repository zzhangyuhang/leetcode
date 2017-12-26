public class IntegerToRoman {
    public static String intToRoman(int num) {
        StringBuffer res=new StringBuffer();
        String s = Integer.toString(num);
        int carry = s.length();
        for(char c : s.toCharArray()){
            int i=c-'0';
            if(carry==4){
                res=toRoman(res,i,'M',' ',' ');
            }
            if(carry==3){
                res=toRoman(res,i,'C','D','M');
            }
            if(carry==2){
                res=toRoman(res,i,'X','L','C');
            }
            if(carry==1){
                res=toRoman(res,i,'I','V','X');
            }
            carry--;
        }

        return res.toString();
    }
    public static StringBuffer toRoman(StringBuffer res,int i,char a,char b,char c){

        if(i<=3){
            for(int j=1;j<=i;j++){
                res.append(a);
            }
        }
        if(3<i&&i<=5){
            for(int j=1;j<=5-i;j++){
                res.append(a);
            }
            res.append(b);
        }
        if(5<i&&i<=8){
            res.append(b);
            for(int j=6;j<=i;j++) {
                res.append(a);
            }
        }
        if(i==9){
            res.append(a);
            res.append(c);
        }
        return res;
    }
    public static void main(String args[]){
        int i =1976;
        System.out.println(intToRoman(i));
        char c ='2';
        int j =Integer.valueOf(c);
        System.out.println(Character.toString(c));
    }
}
