import org.w3c.dom.NodeList;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeTwoSortedLists {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val){
            this.val=val;
        }
    }
    public static ListNode constructListNodeList(int[] nums){
        ListNode head = new ListNode();
        head.next=null;
        ListNode p = new ListNode();
        p=head;

        for(int i : nums){
            ListNode q = new ListNode(i);
            q.next=null;
            p.next=q;
            p=q;
        }

        return head;
    }
    public static void displayNodeList(ListNode head){
        ListNode p = new ListNode();
        p=head.next;
        while(p!=null){

            if(p.next!=null)
                System.out.print(p.val+"->");
            else
                System.out.print(p.val);
            p=p.next;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        head=null;
        ListNode p = new ListNode();
        p=l1.next;
        ListNode q = new ListNode();
        q=l2.next;
        Queue<Integer> queue = new PriorityQueue<>();
        while(p!=null&&q!=null){
            if(p!=null){
                queue.add(p.val);
                p=p.next;
            }
            if(q!=null){
                queue.add(q.val);
                q=q.next;
            }
        }
        p = new ListNode();
        head=p;
        Iterator<Integer> it = queue.iterator();
        while(it.hasNext()){
            q = new ListNode(it.next());
            p.next=q;
            p=q;
        }
        return head;
    }
    public static ListNode mergeTwoLists_A(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = new ListNode();
        p=head;
        l1=l1.next;
        l2=l2.next;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next=l1;
                l1=l1.next;
            }
            else {
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        if (l1 == null) {
            p.next = l2;
        } else {
            p.next = l1;
        }
        return head;

    }
    public static void main(String args[]){
        int[] nums1=new int[]{1,2,4};
        int[] nums2=new int[]{1,3,4};
        ListNode l1 = constructListNodeList(nums1);
        ListNode l2 = constructListNodeList(nums2);
        displayNodeList(mergeTwoLists_A(l1,l2));
    }
}
