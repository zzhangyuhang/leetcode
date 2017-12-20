public class LongestPalindromicSubstring_A {
    public static String longestPalindrome(String s){

        int n =s.length();
        int start=0,end=0;
        for(int i=0;i<n;i++){
            int len1=expandAroundCenter(s,i,i);  //有中心轴的情况 中心轴为i
            int len2=expandAroundCenter(s,i,i+1);//无中心轴的情况 离中心最近的左边的为i，右边的为i+1
            int len=Math.max(len1,len2);//当有中心轴的通过无中心返回的len为0，反之也为0.所以需要判断一下取最长才为正确的长度

            if(len>end-start){  //如果当前回文长度大于之前的回文长度，从新给回文开始结束位置赋值（等于更新长度）最后输出的就是最长的回文。
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end);//返回确定为最长的回文的字符串的片段
    }
    private static int expandAroundCenter(String s, int left, int right){

        int L=left,R=right;
        while(L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
    public static void main(String args[]){
        String s ="adcdedcda";
        System.out.print(longestPalindrome(s));
    }
}
