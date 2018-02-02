import java.util.ArrayList;
import java.util.List;

public class RotateImage {
    public static void rotateimage(List<List<Integer>> image){
        int i = 0;
        int j = image.size()-1;
        while(i<j){
            List<Integer> temp = image.get(i);
            image.set(i,image.get(j));
            image.set(j,temp);
            i++;
            j--;
        }
        swap(image);
    }
    public static void swap(List<List<Integer>> image){
            for (int i = 0; i < image.size(); i++) {
                for (int j = i+1; j < image.size(); j++) {

                        Integer temp = image.get(i).get(j);
                        image.get(i).set(j, image.get(j).get(i));
                        image.get(j).set(i, temp);
                }
            }
    }
    public static void main(String args[]){
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(5);
        row1.add(1);
        row1.add(9);
        row1.add(11);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(2);
        row2.add(4);
        row2.add(8);
        row2.add(10);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(13);
        row3.add(3);
        row3.add(6);
        row3.add(7);
        ArrayList<Integer> row4 = new ArrayList<>();
        row4.add(15);
        row4.add(14);
        row4.add(12);
        row4.add(16);
        ArrayList<List<Integer>> image = new ArrayList<>();
        image.add(row1);
        image.add(row2);
        image.add(row3);
        image.add(row4);
        rotateimage(image);
        for(List list : image){
            for(Object i : list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
