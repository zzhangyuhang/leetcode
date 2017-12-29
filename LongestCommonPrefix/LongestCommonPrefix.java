public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer(strs[0]);
        int n = strs.length;
        for(int i=1;i<n;i++){
            int j=0;
            while(j<sb.length()){
                if(strs[i].length()<sb.length()){
                    sb.delete(strs[i].length(),sb.length());
                }
                if(strs[i].charAt(j)!=sb.toString().charAt(j)){
                    sb.delete(j,sb.length());
                    break;
                }
                j++;
            }
        }
        return sb.toString();
    }
    public static String a(String[] strs){
        for(int i=0;i<strs[0].length();i++){
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i)!=strs[0].charAt(i)||i==strs[j].length()){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
    public static void main(String args[]){
        String[] strs = new String[]{"abc","abcdef","abcsdf"};
        System.out.println(longestCommonPrefix(strs));
        System.out.print(a(strs));
    }
}
