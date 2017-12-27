public class RomanToInteger {
    public static int romanToInt(String s) {
        int sum =0;
        int sign_100 =-1;
        int sign_10  =-1;
        int sign_1   =-1;
        char[] c = s.toCharArray();
        for(int i =0;i<s.length();i++){
            if(c[i]=='M'){  //千位
                sum=sum+1000;
            }


            if(c[i]=='D'){ //百位
                sum=sum+500;
                sign_100=1;
            }
            if(c[i]=='C'){
                sum=sum+100*sign_100;
            }


            if(c[i]=='L'){     //十位
                sum=sum+50;
                sign_10=1;
            }
            if(c[i]=='X'){
                if(i==s.length()-1){
                    sum=sum+10;
                }
                else
                    sum=sum+10*sign_10;
            }


            if(c[i]=='V'){   //个位
                sum=sum+5;
                sign_10=1;
            }
            if(c[i]=='I'){
                sum=sum+1*sign_1;
            }
        }
        return sum;
    }
    public static void main(String args[]){
        String s="MMMDCCCXXCIX";
        System.out.print(romanToInt(s));
    }
}
