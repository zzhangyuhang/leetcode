public class CountAndSay {
    public static String countAndSay(int n,String preSay){
        StringBuffer s = new StringBuffer();//因为每次生成的preSay字符串都是逐步生成的，所以采用stringbuffer
//        System.out.println(preSay);
        int count=1;//计数器，从1开始
        for(int i=0;i<preSay.length();i++){
            //当前位置的char不为最后一个char时且和下一个位置的char相等的时候计数器++
            if(i+1<preSay.length()&&preSay.charAt(i)==preSay.charAt(i+1)){
                count++;
            }
            else {//其他情况就直接输出
                s.append(count);//在结果上先添加计数器
                s.append(preSay.charAt(i));//然后添加该位置的char
                count=1;//计数器回归，准备下一次的计数
            }
        }
        if(n==2)//因为第i个字符串由i-1次递归产生，而且第一次为1直接给的，所以n=2的时候为起点。
            return s.toString();
        else
            return countAndSay(n-1,s.toString());//递归
    }
    public static void main(String args[]){
        System.out.print(countAndSay(4,"1"));
    }
}

