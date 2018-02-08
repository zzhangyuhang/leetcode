import java.util.*;

public class MergeIntervals {
    public static class Interval implements Comparable<Interval>{
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Interval o) {
            if(this.start>o.start)
                return 1;
            else if(this.start==o.start)
                return 0;
            else
                return -1;
        }
        public String toString(){
            return "["+start+","+end+"]";
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals);//对原来的数据的进行排序，关键字为各个数据单元的start
        LinkedList<Interval> temp = new LinkedList<>();//用于记录结果的List
        //这里使用LinkedList，这样能哟个geLast()方法直接取到最后一个数据单元
        for(Interval item : intervals){
            if(temp.size()==0)
                temp.add(item);
            if (temp.getLast().end>=item.start){//合并，当前一个的end>=后一个的start的时候
                //前一个的Interval在temp中
                temp.getLast().end = Math.max(temp.getLast().end,item.end);
                //合并的时候用比较大的end作为结果
            }
            else //不用合并直接添加到结果中
                temp.add(item);
        }
        return temp;
    }
    public static void main(String args[]){
        List<Interval> list = new ArrayList<>();
        Interval item1 = new Interval(1,9);
        Interval item2 = new Interval(2,5);
        Interval item3 = new Interval(19,20);
        Interval item4 = new Interval(10,11);
        Interval item5 = new Interval(12,20);
        Interval item6 = new Interval(0,3);
        Interval item7 = new Interval(0,1);
        Interval item8 = new Interval(0,2);
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);
        list.add(item6);
        list.add(item7);
        list.add(item8);

        List<Interval> res = merge(list);
        System.out.print(res);
    }

}
