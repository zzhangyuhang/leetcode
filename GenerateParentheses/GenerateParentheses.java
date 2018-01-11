import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> reslist=new LinkedList<>();
        StringBuffer resL = new StringBuffer();
        StringBuffer resR = new StringBuffer();
        for(int i=0;i<n;i++){
            resL.append('(');
            resR.append(')');
        }
        resL.append(resR);
        reslist.add(resL.toString());


        for(int a=0;a<n-1;a++) {
            resL = new StringBuffer();
            for(int b=0;b<n-1;b++) {
                if (a == b)
                    resL.append(')');
                else
                    resL.append('(');
            }
            for (int i = 0; i < n-1; i++) {
                resR = new StringBuffer();
                for (int j = 0; j < n-1; j++) {
                    if (i == j)
                        resR.append('(');
                     else
                        resR.append(')');
                }

                StringBuffer res = new StringBuffer();
                res.append('(');
                res.append(resL);
                res.append(resR);
                res.append(')');
                reslist.add(res.toString());
            }

        }
        return reslist;
    }

    public static List<String> generateParenthesis_A(int n){
        List<String> reslist = new ArrayList<>();
        String resL = new String();
        String resR = new String();
        for(int m=1;m<=n;m++) {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            backtrack(resL, '(', ')', m, n, 1);
            backtrack(resR, ')', '(', m, n, 1);
            sb.append(resL);
            sb.append(')');
            reslist.add(sb.toString());
        }
        return reslist;
    }
    public static void backtrack(String res,char cus,char cusa,int m,int n,int counter){
        if(counter==n)
            return ;
        if(m==counter)
            res=res+cusa;
        if(m!=counter)
            res=res+cus;
        backtrack(res,cus,cusa,m,n,counter+1);
    }
    public static void main(String args[]){
        List<String> reslist = new LinkedList<>();
        reslist = generateParenthesis(3);
        Iterator<String> it = reslist.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("-----------------");
        reslist = new ArrayList<>();
        reslist = generateParenthesis_A(3);
        for(String s : reslist){
            System.out.println(s);
        }
    }
}
