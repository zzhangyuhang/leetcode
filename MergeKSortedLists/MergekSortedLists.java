import org.w3c.dom.NodeList;

import java.util.*;

public class MergekSortedLists {
    public static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(){
            this.next=null;
        }
        public ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public static ListNode constructList(int[] nums){
        ListNode head = new ListNode();
        ListNode p = head;
        for(int i : nums){
            ListNode q = new ListNode(i);
            p.next=q;
            p=q;
        }
        return head;
    }
    public static void displayList(ListNode head){
        ListNode p = head.next;
        while(p!=null){
            if(p.next==null)
                System.out.print(p.val);
            else
                System.out.print(p.val+"->");
            p=p.next;
        }
    }
    public static class Com implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            if((int)o1>(int)o2)
                return -1;
            if((int)o1<(int)o2)
                return 1;
            else
                return 0;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode p = head;
        List<Integer> nums = new ArrayList<>();
        for(ListNode q : lists){
            q=q.next;
            while(q!=null){
                nums.add(q.val);
                q=q.next;
            }
        }
        Collections.reverse(nums);
        for (int i : nums){
            ListNode q = new ListNode(i);
            p.next=q;
            p=q;
        }
        return head;
    }
    public static ListNode mergeKListsByRecursion(ListNode result,ListNode[] lists,int n){
        ListNode reshead = new ListNode();
        ListNode resnode = reshead;
        if(n==0) {
            return result;
        }
        else {
            ListNode p = lists[n-1].next;
            ListNode q = result.next;
            while (p != null && q != null) {
                if (p.val < q.val) {
                    resnode.next = p;
                    p = p.next;
                } else {
                    resnode.next = q;
                    q = q.next;
                }
                resnode=resnode.next;
            }
            if (q == null)
                resnode.next = p;
            else
                resnode.next = q;
        }
        return mergeKListsByRecursion(reshead,lists,n-1);
    }
    public static void main(String args[]){

        ListNode list1 = constructList(new int[]{1,2,6});
        ListNode list2 = constructList(new int[]{1,4,7});
        ListNode list3 = constructList(new int[]{5,8,9});

        ListNode[] lists = new ListNode[]{list1,list2,list3};
        displayList(mergeKLists(lists));
        System.out.println();
        System.out.println("-------------------------");
        displayList(mergeKListsByRecursion(new ListNode(),lists,lists.length));
    }
}
