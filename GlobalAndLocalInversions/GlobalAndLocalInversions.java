public class GlobalAndLocalInversions {
    public static boolean isIdealPermutation(int[] A) {
        int i = 0;
        int j = A.length-2;
        int global = 0;
        int local =0;
        while(i<=j){
            for(int m = i+1;m<A.length;m++){
                if(A[i]>A[m]){
                    global++;
                    if(m==i+1)
                        local++;
                }
            }
            if(i==j)
                break;
            i++;
            for(int m = j+1;m<A.length;m++){
                if(A[j]>A[m]){
                    global++;
                    if(m==j+1)
                        local++;
                }
            }
            j--;
        }
        return global==local;
    }
    public static void main(String args[]){
        int[] A = {1,0,2};
        System.out.print(isIdealPermutation(A));
    }
}
