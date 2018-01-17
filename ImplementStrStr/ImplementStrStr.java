public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        char[] a = haystack.toCharArray();
        int i=0,j=0;
        char[] b = needle.toCharArray();
        while(i<a.length&&j<b.length){
            j=0;
            if(a[i]!=b[j]){
                if(i==a.length-1)
                    return -1;
                i++;
            }
            while (a[i]==b[j]){
                if(j==b.length-1)
                    return i-j;
                if(i==a.length-1)
                    return -1;
                i++;
                j++;
            }
        }
        return -1;
    }
    public static int Kmp(String haystack,String needle){
        for(int i=0;;i++){   //从i位置开始匹配子字符串，每次向下走i步，i=i+1
            for(int j=0;;j++){   //遍历子字符串，开始匹配，每次子字符串字符走一个
                if(j==needle.length())     //只有相等的时候才会往下走，走到needle.length的时候说明全部匹配
                    return i;             //说明在i位置匹配到了子字符串，返回位置i
                if(i+j==haystack.length())//如果i位置后边的字符个数小于子字符串的字符个数，不可能匹配成功
                    return -1;            //返回匹配失败
                if(needle.charAt(j)!=haystack.charAt(i+j)) //源字符串从i位置起，子字符串走一位，源字符串也走一位，一位一位的匹配子字符串
                    break;    //如果子字符串的当前位和源字符串的当前位不匹配（不相等），源字符串i位匹配失败，进入下一位。
            }
        }

    }
    public static void main(String args[]){
       System.out.println( strStr("hello","ll"));
       System.out.print(Kmp("hello","lla"));
    }
}
