import java.util.*;
public class SpiralMatrix {
    public static List<Integer> spiralMatrix(int[][] matrix){
        List<Integer> list = new ArrayList<>();
        int end = matrix[0].length-1;
        int start = 0;
        while(start<end){
            go(list,matrix,start,end);
            start+=1;
            end-=1;
        }
        list.add(matrix[start][end]);
        return list;
    }
    public static void go(List<Integer> list,int[][] matrix,int start,int end){
        int i = start;
        int j = start;
        while(j<=end)
            list.add(matrix[i][j++]);
        j--;
        while(i<end)
            list.add(matrix[++i][j]);
        while(j>start)
            list.add(matrix[i][--j]);
        while(i>start+1)
            list.add(matrix[--i][j]);
    }
    public static void main(String args[]){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = spiralMatrix(matrix);
        System.out.print(list);

    }
}
