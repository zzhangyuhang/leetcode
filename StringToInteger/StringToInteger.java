import javax.sql.rowset.spi.SyncResolver;

public class StringToInteger {
    public static void main(String args[]){
        String reg = "[a-zA-Z]";
        String s ="213 sdf 123";
        StringBuffer stringBuffer=new StringBuffer();
        if(s==""){
            System.out.println("String is empty!");
        }
        for(char c : s.toCharArray()){  //将字母转换成为数字
            if(String.valueOf(c).matches(reg)){
                stringBuffer.append(c-96);
            }
            else{
                stringBuffer.append(c);
            }
        }
        System.out.print(stringBuffer);
    }
}
